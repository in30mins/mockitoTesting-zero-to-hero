package com.in30mins.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.in30mins.source.EvenOdd;

public class Test_EvenOdd {

	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	public void test_EvenOdd(int input,String expectedValue) {
		EvenOdd ev = new EvenOdd();
		String act = ev.checkEvenOdd(input);
		assertEquals(expectedValue,act);
	}
}
