package com.in30mins.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.in30mins.source.Assignment1;

public class Test_Assignment1 {

Assignment1 ass = new Assignment1();
	
	@Test
	public void test_Ass() {
		assertEquals(20, ass.convertStringToInt("20"));
	}
	
	@Test
	public void test_Ass1() {
		String str = null;
		assertThrows(IllegalArgumentException.class, ()->ass.convertStringToInt(str));
	}
	@Test
	public void test_Ass2() {
		assertThrows(IllegalArgumentException.class, ()->ass.convertStringToInt(""));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"19","32","23","9"})
	public void test_para(String str) {
		assertEquals(Integer.parseInt(str), ass.convertStringToInt(str));
	}

}
