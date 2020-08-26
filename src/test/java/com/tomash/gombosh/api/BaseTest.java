package com.tomash.gombosh.api;

import com.google.inject.Guice;
import com.tomash.gombosh.api.module.CoreModule;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class BaseTest implements WithAssertions {
    @BeforeAll
    public void setUp() {
        Guice.createInjector(new CoreModule()).injectMembers(this);
    }
}
