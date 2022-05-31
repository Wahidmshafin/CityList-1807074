package com.example.citylist;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CityList
{
    private List<City> cities=new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns Sorted list of cities
     * @param options
     * option 1 means sort by city name
     * option 2 means sort by province name
     * @return
     * returns the sorted city list
     */
    public List<City> getCities(int options)
    {
        List<City> list = cities;
        if(options==1)
        Collections.sort(list);
        else
            Collections.sort(list, new Comparator<City>()
            {
                @Override
                public int compare(City o1, City o2)
                {
                    return o1.getProvinceName().compareTo(o2.getProvinceName());
                }
            });
        return list;
    }

    /**
     * This deletes a city from the list.
     * @param city
     * This is a candidate city to delete
     */
    public void delete(City city)
    {
        if(cities.contains(city))
        {
            cities.remove(city);
        }
        else
            throw new IllegalArgumentException();

    }

    /**
     * This returns the total number of cities in the list
     * @return
     * returns the number of cities
     */

    public int Count()
    {
        return cities.size();
    }



}
