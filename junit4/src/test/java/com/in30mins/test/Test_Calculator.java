package com.in30mins.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.in30mins.Calculator;

public class Test_Calculator {

static Calculator cal = null;
	
	@BeforeClass
	public static void init() {
		cal = new Calculator();
	}
	@AfterClass
	public static void destroy() {
		cal = null;
	}
	
	@Test
	public void test_Add() {
		assertEquals(34, cal.add(29, 5));
	}
	
	@Test
	public void test_Sub() {
		assertEquals(24, cal.sub(29, 5));
	}
}
