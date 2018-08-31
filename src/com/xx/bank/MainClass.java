package com.xx.bank;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {

	public static void main(String[] args) {
		// common service window: 4
		for (int i = 1; i < 5; i++) {
			ServiceWindow commmonService = new ServiceWindow();
			commmonService.setType(CustomerType.COMMON);
			commmonService.start();
			commmonService.setWindowId(i);
		}

		// express window: 1
		ServiceWindow expressService = new ServiceWindow();
		expressService.setType(CustomerType.EXPRESS);
		expressService.start();

		// vip window: 1
		ServiceWindow vipService = new ServiceWindow();
		vipService.setType(CustomerType.VIP);
		vipService.start();

		// Common Customer get service number
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
			public void run() {
				Integer serviceNumber = NumberMachine.getInstance().getCommonManager().generateNewNumber();
				System.out.println("Common Customer # " + serviceNumber + " is waitting for service!");
			}
		}, 0, Constants.COMMON_CUSTOMER_INTERVAL_TIME, TimeUnit.SECONDS);

		// Express Customer get waiting number
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
			public void run() {
				Integer serviceNumber = NumberMachine.getInstance().getExpressManager().generateNewNumber();
				System.out.println("The Express Customer # " + serviceNumber + " is waitting for service!");
			}
		}, 0, Constants.COMMON_CUSTOMER_INTERVAL_TIME * 2, TimeUnit.SECONDS);

		// VIP Customer get waiting number
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
			public void run() {
				Integer serviceNumber = NumberMachine.getInstance().getVipManager().generateNewNumber();
				System.out.println("The VIP Customer # " + serviceNumber + " is waitting for service!");
			}
		}, 0, Constants.COMMON_CUSTOMER_INTERVAL_TIME * 6, TimeUnit.SECONDS);
	}
}
