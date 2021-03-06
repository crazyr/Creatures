package com.epam.test.encoder;

import com.epam.creatures.encoder.PasswordEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The type Password encoder test.
 */
public class PasswordEncoderTest {
    private static final String PASSWORD = "1234";
    private static final int HASH_SIZE = 64;
    private PasswordEncoder passwordEncoder = new PasswordEncoder();
    private static final Logger LOGGER = LogManager.getLogger(PasswordEncoderTest.class);

    /**
     * Encrypt password 1.
     */
    @Test
    public void encryptPassword1(){

        String encryptedPassword = passwordEncoder.encryptPassword(PASSWORD);

        Assert.assertNotNull(encryptedPassword);

        LOGGER.info("Password: "+encryptedPassword);
    }

    /**
     * Encrypt password 2.
     */
    @Test
    public void encryptPassword2(){
        String encryptedPassword = passwordEncoder.encryptPassword(PASSWORD);

        Assert.assertEquals(HASH_SIZE,encryptedPassword.length());

        LOGGER.info("Password: "+encryptedPassword);
    }

    /**
     * Encrypt password 3.
     */
    @Test
    public void encryptPassword3(){
        Assert.assertEquals(passwordEncoder.encryptPassword(PASSWORD),passwordEncoder.encryptPassword(PASSWORD));
    }
}
