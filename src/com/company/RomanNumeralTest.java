package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RomanNumeralTest {



    private static Stream<Arguments> roman() {
        return Stream.of(
                Arguments.of("I",1),
                Arguments.of("VI",6),
                Arguments.of("VII",7),
                Arguments.of("IV",4),
                Arguments.of("VI",6),
                Arguments.of("XXI",21),

                Arguments.of("VM",95)
        );
    }



    @Test
    public void it_should_convert_I_to_1(){
        RomanNumeral romanNumeral = new RomanNumeral();
        int result = romanNumeral.convert("I");

        Assertions.assertEquals(1,result);
    }

    @Test
    public void it_should_convert_V_to_5(){
        RomanNumeral romanNumeral = new RomanNumeral();
        int result = romanNumeral.convert("V");

        Assertions.assertEquals(5,result);
    }


    @ParameterizedTest
    @MethodSource("roman")
    public void it_should_convert_roman_to_number(String roman,Integer expected){
        RomanNumeral romanNumeral = new RomanNumeral();
        Assertions.assertEquals(romanNumeral.convert(roman),expected);

    }

    @Test
    public void it_should_fail_convert_to_unknown_roman()  {
        boolean thrown = false;
        try {
            RomanNumeral romanNumeral = new RomanNumeral();
            romanNumeral.convert("k");
        }catch (UnknowRomanNumeralException e){
            thrown = true;
        }
        Assertions.assertTrue(thrown);


    }
}
