package com.company;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    Map<String, Integer> digits = new HashMap<String,Integer>();
    {
        digits.put("I",1);
        digits.put("V",5);
        digits.put("X",10);
        digits.put("M",100);
    }
    public int convert(String roman) {
        String unparsed = roman;
        int result = 0;
        while (unparsed.length()>1) {
            int current = toNumber(unparsed.substring(0,1));
            int next = toNumber(unparsed.substring(1,2));
            result += current < next ? -current : +current;
            unparsed = unparsed.substring(1);
        }

        return result += toNumber(unparsed);
    }


    private void checkRoman(String roman) {
        if (!digits.containsKey(roman)) throw new UnknowRomanNumeralException(roman + " is unknown roman");
    }

    private Integer toNumber(String roman) {
        checkRoman(roman);
        return digits.get(roman);
    }

}
