package com.propellerads.extension;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.propellerads.Color.ANSI_RESET;
import static com.propellerads.Color.ANSI_YELLOW;
import static java.lang.System.identityHashCode;
import static java.lang.Thread.currentThread;

public class BeforeEachExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        Object testInstance = context.getRequiredTestInstance();
        System.out.println("        ### BeforeEachExtension INSTANCE ID: " + identityHashCode(this));
        System.out.println("        ### BeforeEachExtension" + ANSI_YELLOW
                + " THREAD ID: " + currentThread().getId() + ANSI_RESET
                + " for test instance ID: " + identityHashCode(testInstance));
    }
}
