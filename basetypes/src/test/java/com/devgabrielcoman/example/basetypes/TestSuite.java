package com.devgabrielcoman.example.basetypes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MoshiParserTest.class,
        OkHttpConnectionTest.class
})
public class TestSuite {
}
