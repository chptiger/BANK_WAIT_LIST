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
		String windowName = "# " + windowId + " " + type + " Service Window ";
		System.out.println(windowName + "tries to get task......");
		Integer serviceNumber = NumberMachine.getInstance().getCommonManager().fetchServiceNumber();
		if (serviceNumber != null) {
			System.out.println(windowName + "is working for " + serviceNumber);
			long beginTime = System.currentTimeMillis();
			int maxRandom = Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME;
			long serverTime = new Random().nextInt(maxRandom) + 1 + Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serverTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long workTime = System.currentTimeMillis() - beginTime;
			System.out.println(
					windowName + " spends " + workTime / 1000 + " secondes to service the "  + serviceNumber + "th customer");
		} else {
			System.out.println(windowName + "did not find task, waitting 1 second");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void vipService() {
		String windowName = "# " + windowId + " " + type + " Service Window ";
		System.out.println(windowName + "tries to get task......");
		Integer serviceNumber = NumberMachine.getInstance().getVipManager().fetchServiceNumber();
		if (serviceNumber != null) {
			System.out.println(windowName + "is working for " + serviceNumber);
			long beginTime = System.currentTimeMillis();
			int maxRandom = Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME;
			long serverTime = new Random().nextInt(maxRandom) + 1 + Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serverTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long workTime = System.currentTimeMillis() - beginTime;
			System.out.println(
					windowName + " spends " + workTime / 1000 + " secondes to service the " + serviceNumber + "th customer");
		} else {
			System.out.println(windowName + "did not find task......");
			commonService();
		}

	}

	private void expressService() {
		String windowName = "# " + windowId + " " + type + " Service Window ";
		System.out.println(windowName + "tries to get task......");
		Integer serviceNumber = NumberMachine.getInstance().getExpressManager().fetchServiceNumber();
		if (serviceNumber != null) {
			System.out.println(windowName + "is working for " + serviceNumber);
			long beginTime = System.currentTimeMillis();
			int maxRandom = Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME;
			long serverTime = new Random().nextInt(maxRandom) + 1 + Constants.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serverTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long workTime = System.currentTimeMillis() - beginTime;
			System.out.println(
					windowName + " spends " + workTime / 1000 + " secondes to service the "  + serviceNumber + "th customer");
		} else {
			System.out.println(windowName + "did not find task......");
			commonService();
		}

	}
}
