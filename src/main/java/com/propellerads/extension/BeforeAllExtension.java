package com.propellerads.extension;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.propellerads.Color.ANSI_RESET;
import static com.propellerads.Color.ANSI_YELLOW;
import static java.lang.System.identityHashCode;
import static java.lang.Thread.currentThread;

public class BeforeAllExtension implements BeforeAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) {
        System.out.println("### BeforeAllExtension INSTANCE ID: " + identityHashCode(this));
        System.out.println("### BeforeAllExtension" + ANSI_YELLOW + " THREAD ID: " + currentThread().getId() + ANSI_RESET);
    }
}
