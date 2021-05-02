package com.internship.dayLength.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DayLength {
    private String sunRise;
    private String sunSet;
    private String solarNoon;
    private String dayLength;
    private String civilTwilightStart;
    private String civlTwilightEnd;
    private String nauticalTwilightStart;
    private String nauticalTwilightEnd;
    private String astronomicalTwilightStart;
    private String astronomicalTwilightEnd;

    public DayLength(@JsonProperty(value = "sunrise")String sunRise, @JsonProperty(value = "sunset")String sunSet,
                     @JsonProperty(value = "solar_noon") String solarNoon, @JsonProperty(value = "day_length")String dayLength,
                     @JsonProperty(value = "civil_twilight_begin")String civilTwilightStart,
                     @JsonProperty(value = "civil_twilight_end")String civlTwilightEnd,
                     @JsonProperty(value = "nautical_twilight_begin")String nauticalTwilightStart,
                     @JsonProperty(value = "nautical_twilight_end")String nauticalTwilightEnd,
                     @JsonProperty(value = "astronomical_twilight_begin")String astronomicalTwilightStart,
                     @JsonProperty(value = "astronomical_twilight_end")String astronomicalTwilightEnd) {
        this.sunRise = sunRise;
        this.sunSet = sunSet;
        this.solarNoon = solarNoon;
        this.dayLength = dayLength;
        this.civilTwilightStart = civilTwilightStart;
        this.civlTwilightEnd = civlTwilightEnd;
        this.nauticalTwilightStart = nauticalTwilightStart;
        this.nauticalTwilightEnd = nauticalTwilightEnd;
        this.astronomicalTwilightStart = astronomicalTwilightStart;
        this.astronomicalTwilightEnd = astronomicalTwilightEnd;
    }

    public DayLength(String sunRise, String sunSet, String dayLength) {
        this.sunRise = sunRise;
        this.sunSet = sunSet;
        this.dayLength = dayLength;
    }

    public String getSunRise() {
        return sunRise;
    }

    public String getSunSet() {
        return sunSet;
    }

    public String getDayLength() {
        return dayLength;
    }

    @Override
    public String toString() {
        return "DayLength{" +
                "sunRise='" + sunRise + '\'' +
                ", sunSet='" + sunSet + '\'' +
                ", solarNoon='" + solarNoon + '\'' +
                ", dayLength='" + dayLength + '\'' +
                '}';
    }
}
