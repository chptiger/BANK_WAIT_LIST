package com.xx.bank;

import java.util.Random;
import java.util.concurrent.Executors;

public class ServiceWindow {
	private CustomerType type = CustomerType.COMMON;
	private int windowId = 1;

	public void start() {
		Executors.newSingleThreadExecutor().execute(new Runnable() {

			@Override
			public void run() {
				while (true) {
					switch (type) {
					case COMMON:
						commonService();
						break;
					case EXPRESS:
						expressService();
						break;
					case VIP:
						vipService();
						break;
					default:
						break;
					}
				}
			}


		});
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}
	
	private void commonService() {
		String windowName = "The " + windowId + " " + type
				+ " service window ";
		System.out.println("try to get task......");
		Integer number = NumberMachine.getInstance().getCommonManager()
				.fetchServiceNumber();
		if (number != null) {
			long beginTime = System.currentTimeMillis();
			int maxRandom = Constants.MAX_SERVICE_TIME
					- Constants.MIN_SERVICE_TIME;
			long serverTime = new Random().nextInt(maxRandom) + 1
					+ Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serverTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long workTime = System.currentTimeMillis() - beginTime;
			System.out.println(windowName + " spend " + workTime / 1000
					+ " secondes to service the " + number
					+ "th customer");
		} else {
			System.out.println("did not find task, waitting 1 second");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void vipService() {
		String windowName = "The " + windowId + " " + type
				+ " service window ";
		System.out.println("try to get task......");
		Integer number = NumberMachine.getInstance().getVipManager()
				.fetchServiceNumber();
		if (number != null) {
			long beginTime = System.currentTimeMillis();
			int maxRandom = Constants.MAX_SERVICE_TIME
					- Constants.MIN_SERVICE_TIME;
			long serverTime = new Random().nextInt(maxRandom) + 1
					+ Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serverTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long workTime = System.currentTimeMillis() - beginTime;
			System.out.println(windowName + " spend " + workTime / 1000
					+ " secondes to service the " + number
					+ "th customer");
		} else {
			System.out.println("did not find task......");
			commonService();
		}
		
	}
	
	private void expressService() {
		String windowName = "The " + windowId + " " + type
				+ " service window ";
		System.out.println("try to get task......");
		Integer number = NumberMachine.getInstance().getExpressManager()
				.fetchServiceNumber();
		if (number != null) {
			long beginTime = System.currentTimeMillis();
			int maxRandom = Constants.MAX_SERVICE_TIME
					- Constants.MIN_SERVICE_TIME;
			long serverTime = new Random().nextInt(maxRandom) + 1
					+ Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serverTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long workTime = System.currentTimeMillis() - beginTime;
			System.out.println(windowName + " spend " + workTime / 1000
					+ " secondes to service the " + number
					+ "th customer");
		} else {
			System.out.println("did not find task......");
			commonService();
		}
		
	}
}
