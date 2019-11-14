/**
 * 
 */
package com.hoolah.transtat;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
/**
 * @author Naveen
 *
 */

public class CSVReader {
     
    /**
     * @param filePath
     * @return
     * @throws IOException
     */
    public static Map<String, TransactionVO>  readTransactionCSV(String filePath) throws IOException {
    	Map<String, TransactionVO> transactionMap = new HashMap<String, TransactionVO>();
		try (Reader reader = Files.newBufferedReader(Paths.get(filePath));) {
			CsvToBean<TransactionVO> csvToBean = new CsvToBeanBuilder<TransactionVO>(reader)
					.withType(TransactionVO.class).withIgnoreLeadingWhiteSpace(true).build();
			Iterator<TransactionVO> transactionVOIterator = csvToBean.iterator();
			Iterable<TransactionVO> iterable = () -> transactionVOIterator;
			StreamSupport.stream(iterable.spliterator(), false).forEach(transactionVO -> {
				transactionMap.put(transactionVO.getId(), transactionVO);
				// According to the assumption,the transaction date is sorted already. Hence, we can search
				// reversed transaction back from so far loaded Map
				if (TranStatManager.REVERSAL_TYPE.equalsIgnoreCase(transactionVO.getType())) {
					transactionMap.get(transactionVO.getRelatedTransaction()).setReversed(true);
				}
			});
		}
		TranStatManager.log("CSV file is loaded");
		return transactionMap;
	}   
    
}
