package com.example.citylist;

import static org.junit.Assert.*;

import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CityListTest
{
    private static final String TAG = "Error";

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
        assertEquals(1, cityList.getCities(1).size());
        City city=new City("Khulna","Fullbarigate");
        cityList.add(city);
        assertEquals(2,cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
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

    @Test
    public void testDelete()
    {
        CityList cityList=new CityList();
        City city=new City("Dhaka", "Motijheel");
        cityList.add(city);
        cityList.delete(city);
        assertFalse(cityList.getCities(1).contains(city));
    }

    @Test
    public void testDeleteExceptions()
    {
        CityList cityList=mockCityList();
        City city=new City("Khulna", "Fullbarigate");
        assertThrows(IllegalArgumentException.class,()->{
            cityList.delete(city);
        });
    }

    @Test
    public void testCount()
    {
        CityList cityList=mockCityList();
        assertEquals(1,cityList.Count());
    }

    @Test
    public void testSort()
    {
        CityList cityList=new CityList();
        City city1=new City("Dhaka", "Motijheel");
        City city2=new City("Khulna", "Fullbarigate");
        cityList.add(city1);
        cityList.add(city2);
        List<City> testList=new ArrayList<>();
        testList.add(city1);
        testList.add(city2);
        Collections.sort(testList);
        assertEquals(cityList.getCities(1),testList);
        Collections.sort(testList, new Comparator<City>()
        {
            @Override
            public int compare(City o1, City o2)
            {
                return o1.getProvinceName().compareTo(o2.getProvinceName());
            }
        });
        assertEquals(cityList.getCities(2),testList);

    }

}