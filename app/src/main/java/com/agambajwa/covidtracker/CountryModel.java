package com.agambajwa.covidtracker;

public class CountryModel {
    private String countryFlag, countryName, cases, casesToday, deaths, deathsToday, recovered, active, critical;

    public CountryModel() {
    }

    public CountryModel(String countryFlag, String countryName, String cases, String casesToday, String deaths, String deathsToday, String recovered, String active, String critical) {
        this.countryFlag = countryFlag;
        this.countryName = countryName;
        this.cases = cases;
        this.casesToday = casesToday;
        this.deaths = deaths;
        this.deathsToday = deathsToday;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getCasesToday() {
        return casesToday;
    }

    public void setCasesToday(String casesToday) {
        this.casesToday = casesToday;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getDeathsToday() {
        return deathsToday;
    }

    public void setDeathsToday(String deathsToday) {
        this.deathsToday = deathsToday;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }
}
