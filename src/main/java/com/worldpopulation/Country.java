package com.worldpopulation;

public class Country {
    private String countryname, capitalname, regionname, subregionname;

    public Country(String countryname, String capitalname, String regionname, String subregionname) {
        this.countryname = countryname;
        this.capitalname = capitalname;
        this.regionname = regionname;
        this.subregionname = subregionname;
    }

    public String getCountryname() {
        return countryname;
    }

    public String getCapitalname() {
        return capitalname;
    }

    public String getRegionname() {
        return regionname;
    }

    public String getSubregionname() {
        return subregionname;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryname='" + countryname + '\'' +
                ", capitalname='" + capitalname + '\'' +
                ", regionname='" + regionname + '\'' +
                ", subregionname='" + subregionname + '\'' +
                '}';
    }
}
