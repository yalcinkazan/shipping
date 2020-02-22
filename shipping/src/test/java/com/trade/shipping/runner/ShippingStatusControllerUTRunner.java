package com.trade.shipping.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.trade.shipping.unit.ShippingStatusControllerUT;

public class ShippingStatusControllerUTRunner {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(ShippingStatusControllerUT.class);

		if (result.wasSuccessful()) {
			System.out.println("Unit Test Was Successful");
		} else {
			System.err.println("Unit Test Was Failure!");
			for (Failure failure : result.getFailures()) {
				System.out.println("Failure: " + failure.toString());
			}
		}
	}
}
