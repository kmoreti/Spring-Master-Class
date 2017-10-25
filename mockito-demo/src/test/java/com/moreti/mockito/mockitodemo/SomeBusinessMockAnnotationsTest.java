package com.moreti.mockito.mockitodemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class SomeBusinessMockAnnotationsTest {

	DataService dataServiceMock = mock(DataService.class);

	@Test
	public void testFindTheGreatestFromAllDate() {
		when(dataServiceMock.retrievesAllData()).thenReturn(new int[] { 24, 15, 3 });
		
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findTheGreatestFromAllDate();
		assertEquals(24, result);
	}

	@Test
	public void testFindTheGreatestFromAllDate_ForOneValue() {
		when(dataServiceMock.retrievesAllData()).thenReturn(new int[] { 15 });

		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findTheGreatestFromAllDate();
		assertEquals(15, result);
	}

}