package com.propellerads.extension;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.propellerads.Color.ANSI_RESET;
import static com.propellerads.Color.ANSI_YELLOW;
import static java.lang.System.identityHashCode;
import static java.lang.Thread.currentThread;

public class AfterEachExtension implements AfterEachCallback {
    @Override
    public void afterEach(ExtensionContext context) {
        Object testInstance = context.getRequiredTestInstance();
        System.out.println("        ### AfterEachExtension" + ANSI_YELLOW
                + " THREAD ID: " + currentThread().getId() + ANSI_RESET
                + " for test instance ID: " + identityHashCode(testInstance));
    }
}
