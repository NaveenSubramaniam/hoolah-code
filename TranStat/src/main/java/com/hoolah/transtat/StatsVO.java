/**
 * 
 */
package com.hoolah.transtat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Naveen
 *
 */
public class StatsVO {

	StatsVO(){
        this.totalTransactions=0;
        this.totalAmount=0;
        this.idList= new ArrayList<String>();
 }

 private int totalTransactions;
 private List<String> idList;
 private double totalAmount;
/**
 * @return the totalTransactions
 */
public int getTotalTransactions() {
	return totalTransactions;
}
/**
 * @param totalTransactions the totalTransactions to set
 */
public void setTotalTransactions(int totalTransactions) {
	this.totalTransactions = totalTransactions;
}
/**
 * @return the idList
 */
public List<String> getIdList() {
	return idList;
}
/**
 * @param idList the idList to set
 */
public void setIdList(List<String> idList) {
	this.idList = idList;
}
/**
 * @return the totalAmount
 */
public double getTotalAmount() {
	return totalAmount;
}
/**
 * @param totalAmount the totalAmount to set
 */
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}
@Override
public String toString() {
	return "StatsVO [totalTransactions=" + totalTransactions + ", idList=" + idList + ", totalAmount=" + totalAmount
			+ "]";
}


 
}
