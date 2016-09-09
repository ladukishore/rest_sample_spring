package com.lkd.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lkd.spring.model.Weather;

/**
 * Handles requests for the weather service.
 */
@Controller
public class WeatherController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @RequestMapping(value = RestURIConstants.GET_TEMP, method = RequestMethod.GET)
    public @ResponseBody Weather getTemperature(@RequestParam("city") String city, @RequestParam("date") String date) {
        logger.info("city=" + city);
        Weather weather = new Weather();
        weather.setCity(city);
        weather.setDate(fromDateQueryParameter(date));
        weather.setTemperature(15); // hard coded temperature
        return weather;
    }

    /**
     * Convert a String date parameter (format <code>yyyy-MM-dd</code>) into a Date.
     */
    @ExceptionHandler(BadRequestException.class)
    protected Date fromDateQueryParameter(final String dateParam) {
        if (dateParam != null) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(dateParam);
            } catch (final ParseException e) {

                throw new BadRequestException("Unable to parse date querystring parameter " + dateParam);
            }
        } else {
            return null;
        }
    }

    @RequestMapping(value = RestURIConstants.CREATE_TEMP, method = RequestMethod.POST)
    public @ResponseBody Weather createEmployee(@RequestBody Weather weather) {
        logger.info("Storing  temperature for a city.");
        // Add logic to store temperature in a db
        return weather;
    }

}
