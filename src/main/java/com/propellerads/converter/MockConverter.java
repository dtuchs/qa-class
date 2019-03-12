package com.propellerads.converter;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import static com.propellerads.Color.ANSI_RESET;
import static com.propellerads.Color.ANSI_YELLOW;
import static java.lang.System.identityHashCode;
import static java.lang.Thread.currentThread;

public class MockConverter implements ArgumentConverter {
    @Override
    public Object convert(Object o, ParameterContext parameterContext) throws ArgumentConversionException {
        Object testInstance = parameterContext.getTarget().get();
        System.out.println("                ### UNIQUE CONVERTER" + ANSI_YELLOW
                + " THREAD ID: " + currentThread().getId() + ANSI_RESET
                + " for test instance ID:  " + identityHashCode(testInstance));
        return o;
    }
}
