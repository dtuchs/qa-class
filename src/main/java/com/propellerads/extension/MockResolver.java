package com.propellerads.extension;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import static com.propellerads.Color.ANSI_RESET;
import static com.propellerads.Color.ANSI_YELLOW;
import static java.lang.System.identityHashCode;
import static java.lang.Thread.currentThread;

public class MockResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(Integer.class);
    }

    @Override
    public Integer resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Object testInstance = parameterContext.getTarget().get();
        System.out.println("                ### MockResolver" + ANSI_YELLOW
                + " THREAD ID: " + currentThread().getId() + ANSI_RESET
                + " for test instance ID: " + identityHashCode(testInstance));
        return 1;
    }
}
