package org.usman.dogs_cats.utilities;

import com.fasterxml.jackson.databind.util.StdConverter;

public class ToLowerCaseCon extends StdConverter<String, String> {
    @Override
    public String convert(String s) {
        if (s== null){
            return null;
        }
        return s.toLowerCase();
    }
    }

