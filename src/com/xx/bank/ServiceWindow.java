package com.xx.bank;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ServiceWindow {
	private static Logger logger = Logger.getLogger("com.xx.bank");
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

	public CustomerType getType() {
		return type;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}

	private void commonService() {
		String windowName = "# " + windowId + " " + type + " Service Window ";
		Integer serviceNumber = NumberMachine.getInstance().getCommonManager().fetchServiceNumber();
		System.out.println(windowName + "tries to get Common Task......");
		if (serviceNumber != null) {
			System.out.println(windowName + "is working for Common Task" + serviceNumber);
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
// why vip window could service for common customer?
	private void vipService() {
		String windowName = "# " + windowId + " " + type + " Service Window ";
		Integer serviceNumber = NumberMachine.getInstance().getVipManager().fetchServiceNumber();
		System.out.println(windowName + "tries to get VIP task......");
		if (serviceNumber != null) {
			System.out.println(windowName + "is working for VIP Task " + serviceNumber);
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
//			Try to service common customer
			commonService();
		}

	}

	private void expressService() {
		String windowName = "# " + windowId + " " + type + " Service Window ";
		Integer serviceNumber = NumberMachine.getInstance().getExpressManager().fetchServiceNumber();
		System.out.println(windowName + "tries to get Express task......");
		if (serviceNumber != null) {
			System.out.println(windowName + "is working for Express Task" + serviceNumber);
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
//			Try to service common customer
			commonService();
		}

	}
}
