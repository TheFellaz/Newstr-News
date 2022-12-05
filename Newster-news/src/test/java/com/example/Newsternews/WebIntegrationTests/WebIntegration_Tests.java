package com.example.Newsternews.WebIntegrationTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.example.Newsternews.Resources.token;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@RunWith(JUnit4.class)
public class WebIntegration_Tests
{
    @Test
    public void tokenObfuscation() throws Exception
    {
        String testID = "testforobfuscation";

        String obfuscatedID = token.createToken(testID);

        //Basic assertion that ID is obfuscated
        assertNotEquals(obfuscatedID, testID);
    }
}
