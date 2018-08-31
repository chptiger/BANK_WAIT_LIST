package com.xx.bank;

public enum CustomerType {
	COMMON, EXPRESS, VIP;
	public String toString() {
		String name = null;
		switch (this) {
		case COMMON:
			name = "COMMON";
			break;
		case EXPRESS:
			name = "EXPRESS";
			break;
		case VIP:
			name = "VIP";
			break;
		}
		return name;
	}
}
