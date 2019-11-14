/**
 * 
 */
package com.hoolah.transtat;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Naveen
 *
 */
public class TranStatManager {

	Map<String, TransactionVO> transactionMap;
	private static final DecimalFormat df2 = new DecimalFormat("#.##");
	public static final String REVERSAL_TYPE = "REVERSAL";

	public static TranStatManager getInstance() {
		TranStatManager tm = new TranStatManager();
		return tm;
	}

	private TranStatManager() {
	}

	/**
	 * @param filePath
	 * @throws IOException
	 */
	public void loadCSVData(String filePath) throws IOException {
		this.transactionMap = CSVReader.readTransactionCSV(filePath);
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @param merchant
	 */
	public void generateStat(Date startDate, Date endDate, String merchant) {
		log("Generate Stats - Started");
		StatsVO statsVO = new StatsVO();
		transactionMap.values().stream()
				.filter(obj -> obj.getMerchant().trim().equalsIgnoreCase(merchant)
						&& startDate.compareTo(obj.getDate()) * obj.getDate().compareTo(endDate) >= 0
						&& !obj.isReversed()
						&& !REVERSAL_TYPE.equalsIgnoreCase(obj.getType())
						)
				.collect(Collectors.toList()).forEach(obj -> {
					// prepare statistics from transaction within specified
					// date range
					statsVO.setTotalTransactions(statsVO.getTotalTransactions() + 1);
					statsVO.setTotalAmount(statsVO.getTotalAmount() + obj.getAmount());
					statsVO.getIdList().add(obj.getId());
				});
		log("Generate Stats - Ended");
		System.out.println("***");
		System.out.println("Merchant: " + merchant);
		System.out.println("Total transactions: " + statsVO.getTotalTransactions());
		System.out.println("Avearge amount: " + (statsVO.getTotalTransactions() != 0
				? df2.format(statsVO.getTotalAmount() / statsVO.getTotalTransactions())
				: 0));
		System.out.println("***");
	}

	public static String trim(String val) {
		return null != val ? val.trim() : val;
	}

	public static void log(String message) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()) + ": " + message);
	}

	/**
	 * @param source
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String source, String format) throws ParseException {
		return new SimpleDateFormat(format).parse(source);
	}
}
