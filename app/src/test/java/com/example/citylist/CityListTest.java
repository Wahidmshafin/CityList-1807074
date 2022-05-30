package com.example.citylist;

import static org.junit.Assert.*;

import org.junit.Test;

public class CityListTest
{
    private CityList mockCityList()
    {
        CityList citylist=new CityList();
        citylist.add(mockCity());
        return citylist;
    }
    private City mockCity()
    {
        return new City("Dhaka", "Motijheel");
    }

    @Test
    public void testAdd()
    {
        CityList cityList=mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city=new City("Khulna","Fullbarigate");
        cityList.add(city);
        assertEquals(2,cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testDuplicate()
    {
        CityList cityList=mockCityList();
        City city=new City("Khulna","Fullbarigate");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class,()->{
            cityList.add(city);
        });
    }
}