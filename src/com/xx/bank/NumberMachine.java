package com.xx.bank;

/**
 * This is Singleton class.
 * Only one NumberMachine to produce Service Number 
 */
public class NumberMachine {
	private NumberManager commonManager = new NumberManager();
	private NumberManager expressManager = new NumberManager();
	private NumberManager vipManager = new NumberManager();

	public NumberManager getCommonManager() {
		return commonManager;
	}

	public NumberManager getExpressManager() {
		return expressManager;
	}

	public NumberManager getVipManager() {
		return vipManager;
	}

	private NumberMachine(){};
	
	public static NumberMachine getInstance() {
		return instance;
	}
	
	private static NumberMachine  instance = new NumberMachine();
}
