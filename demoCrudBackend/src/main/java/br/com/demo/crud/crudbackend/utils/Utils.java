package br.com.demo.crud.crudbackend.utils;

import br.com.demo.crud.crudbackend.domain.enums.Country;
import java.util.Arrays;
import java.util.Optional;

/**
 * class of generic utilities
 */
public class Utils {

    private Utils() {
    }

    /**
     * checks if is a number
     * @param s string that will be checked
     * @return if is a number
     */
    public static boolean isNumeric(String s) {

        return s.chars().allMatch( Character::isDigit );
    }

    /**
     * checks if is a Country
     * @param s string that will be checked
     * @return if is a Country
     */
    public static Optional<Country> isCountry(String s) {

        return Arrays.asList(Country.values())
                .stream()
                .filter(
                        country -> country.getDescription().toUpperCase()
                                .indexOf(s.toUpperCase().trim()) !=-1
                ).findFirst();

    }


}
