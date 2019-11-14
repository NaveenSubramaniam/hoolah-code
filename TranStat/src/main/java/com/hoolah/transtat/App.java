package com.hoolah.transtat;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	private static final String INPUT_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";

	private App() {
	}

	public static App getInstance() {
		return new App();
	}

	public static void main(String[] args) {
		if (args == null || args.length != 1) {
			System.out.println("Please provide csv file location as command line argument");
			return;
		}
		App.getInstance().execute(args[0]);
	}

	@SuppressWarnings("resource")
	public void execute(String file) {
		Scanner scanner = null;
		try {
			TranStatManager tranStatManager = TranStatManager.getInstance();
			tranStatManager.loadCSVData(file);
			String start = "";
			String end = "";
			String merchant = "";
			scanner = new Scanner(System.in).useDelimiter(System.lineSeparator());
			System.out.println("Enter merchant name: ");
			merchant = TranStatManager.trim(TranStatManager.trim(scanner.next()));
			System.out.println("Enter Start date: ");
			start =  TranStatManager.trim(TranStatManager.trim(scanner.next()));
			System.out.println("Enter End date: ");
			end =  TranStatManager.trim(TranStatManager.trim(scanner.next()));
			tranStatManager.generateStat(TranStatManager.parseDate(start, INPUT_DATE_FORMAT),
					TranStatManager.parseDate(end, INPUT_DATE_FORMAT), merchant);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != scanner) {
				scanner.close();
			}
		}
	}

}
