package tech.altier;

import tech.altier.dba.Connector;

import java.sql.Connection;

public class Main {
    public static Connection connection = Connector.getConnection();
}
