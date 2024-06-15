package com.in30mins.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.in30mins.source.Assignment2;
import com.in30mins.source.EvenOdd;

public class Test_Assignment2 {

	Assignment2 ass2 = new Assignment2();
	EvenOdd eo = new EvenOdd();
	
	@Test
	@RepeatedTest(value=3)
	public void test_checkEvenOrOdd() {
		assertTrue(ass2.checkEvenOdd(2));
	}
	@Disabled
	@Test
	public void test_checkEvenOrOdd1() {
		assertFalse(ass2.checkEvenOdd(11));
	}
	@Disabled
	@ParameterizedTest
	@ValueSource(ints = {20,12,4,8,32})
	public void test_checkEvenOrOdd2(int num) {
		assertTrue(ass2.checkEvenOdd(num));
	}
	@ParameterizedTest
	@ValueSource(ints = {21,19,9,81,37})
	public void test_checkEvenOrOdd3(int num) {
		assertFalse(ass2.checkEvenOdd(num));
	}
	
	@ParameterizedTest
	@MethodSource("passing")
	public void test_byMethod(int num,boolean ex) {
		assertEquals(ex,ass2.checkEvenOdd(num));
	}
	static Stream<Arguments> passing(){
		return Stream.of(
				Arguments.of(10,true),
				Arguments.of(11,false),
				Arguments.of(10,true),
				Arguments.of(13,false)
				);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	public void test_para(int input, String expectedValue) {
		String ast = eo.checkEvenOdd(input);
		assertEquals(expectedValue, ast);
	}
	@Disabled
	@ParameterizedTest
	@CsvSource({"10,even","11,odd"})
	public void test_para1(int input, String expect) {
		assertEquals(expect, eo.checkEvenOdd(input));
	}
}
