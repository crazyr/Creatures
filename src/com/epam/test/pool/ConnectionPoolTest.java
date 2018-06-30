package com.epam.test.pool;

import com.epam.creatures.config.DataBaseConfigurator;
import com.epam.creatures.pool.ConnectionPool;
import com.epam.creatures.pool.SafeConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ConnectionPoolTest {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPoolTest.class);

    @Test
    public void testConnectionPool(){
        DataBaseConfigurator.INSTANCE.configureDBProperties("web/config/db_config.properties");
        ConnectionPool.INSTANCE.init();

        SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
        LOGGER.info(connection);
        ConnectionPool.INSTANCE.returnConnection(connection);

        ConnectionPool.INSTANCE.closeAll();
    }
}