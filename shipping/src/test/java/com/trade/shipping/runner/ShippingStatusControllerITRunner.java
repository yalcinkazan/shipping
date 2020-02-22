package com.trade.shipping.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.trade.shipping.integration.ShippingStatusControllerIT;

public class ShippingStatusControllerITRunner {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(ShippingStatusControllerIT.class);

		if (result.wasSuccessful()) {
			System.out.println("Integration Test Was Successful");
		} else {
			System.err.println("Integration Test Was Failure!");
			for (Failure failure : result.getFailures()) {
				System.out.println("Failure: " + failure.toString());
			}
		}
	}
}
