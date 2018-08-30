package com.xx.bank;

import java.util.ArrayList;
import java.util.List;

public class NumberManager {
	private int lastNumber = 1;
	private List<Integer> queueNumbers = new ArrayList<Integer>();

	/**
	 * following two method need synchronized.
	 * two different thread visit same data source.
	 * 
	 * return Integer instead of int to avoid null exception.
	 * @return
	 */
//	produce service number when customer come in bank 
	public synchronized Integer generateNewNumber() {
		queueNumbers.add(lastNumber);
		return lastNumber++;
	}

//	service window get current service number 
	public synchronized Integer fetchServiceNumber() {
		if(queueNumbers.size() > 0){
			return (Integer)queueNumbers.remove(0);
		}else{
			return null;
		}
	}
}
