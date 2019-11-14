/**
 * 
 */
package com.hoolah.transtat;

import java.util.Date;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

/**
 * @author Naveen
 *
 */
public class TransactionVO {

@CsvBindByName(column = "ID", required = true)
private String id;
@CsvBindByName(column = "Date", required = false)
@CsvDate("dd/MM/yyyy HH:mm:ss")
private Date date;
@CsvBindByName(column = "Amount", required = false)
private float amount;
@CsvBindByName(column = "Merchant", required = false)
private String merchant;
@CsvBindByName(column = "Type", required = false)
private String type;
@CsvBindByName(column = "Related Transaction", required = false)
private String relatedTransaction;
private boolean reversed;
/**
 * @return the id
 */

public String getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(String id) {
	this.id = TranStatManager.trim(id);
}
/**
 * @return the date
 */
public Date getDate() {
 	return date;
}
/**
 * @param date the date to set
 */
public void setDate(Date date) {
	this.date = date;
}
/**
 * @return the amount
 */
public float getAmount() {
	return amount;
}
/**
 * @param amount the amount to set
 */
public void setAmount(float amount) {
	this.amount = amount;
}

/**
 * @return the merchant
 */
public String getMerchant() {
	
	return merchant;
}
/**
 * @param merchant the merchant to set
 */
public void setMerchant(String merchant) {
	this.merchant = TranStatManager.trim(merchant);
}
/**
 * @return the type
 */
public String getType() {
	return type;
}
/**
 * @param type the type to set
 */
public void setType(String type) {
	this.type = TranStatManager.trim(type);
}
/**
 * @return the relatedTransaction
 */
public String getRelatedTransaction() {
	return relatedTransaction;
}
/**
 * @param relatedTransaction the relatedTransaction to set
 */
public void setRelatedTransaction(String relatedTransaction) {
	this.relatedTransaction = TranStatManager.trim(relatedTransaction);
}
/**
 * @return the reversed
 */
public boolean isReversed() {
	return reversed;
}
/**
 * @param reversed the reversed to set
 */
public void setReversed(boolean reversed) {
	this.reversed = reversed;
}
@Override
public String toString() {
	return "TransactionVO [id=" + id + ", date=" + date + ", amount=" + amount + ", merchant=" + merchant + ", type="
			+ type + ", relatedTransaction=" + relatedTransaction + ", reversed=" + reversed + "]";
}


}
