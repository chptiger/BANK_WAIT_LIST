package com.xx.bank;

public class MainClass {

	public static void main(String[] args) {
		// common service window: 4
		for (int i = 1; i < 5; i++) {
			ServiceWindow commmonService = new ServiceWindow();
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
	}
}
