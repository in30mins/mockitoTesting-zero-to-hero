package com.in30mins.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.in30mins.source.Calculator;

public class TestCalculator {

Calculator cal = null;
	
	@BeforeEach
	public void init() {
		cal = new Calculator();
	}
	@AfterEach
	public void destroy() {
		cal = null;
	}
	
	@Test
	public void test_Add() {
		assertEquals(23, cal.add(10,13));
	}
	@Test
	public void test_Sub() {
		assertEquals(3, cal.sub(13,10));
	}
	
	@Test
	public void test_PrivateMe() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Method privateMt = Calculator.class.getDeclaredMethod("addPrivate",int.class,int.class);
		privateMt.setAccessible(true);
		assertEquals(5,privateMt.invoke(cal,3,2));
	}
}
