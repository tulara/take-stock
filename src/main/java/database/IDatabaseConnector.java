package database;

import java.sql.Connection;

public interface IDatabaseConnector {
    Connection connect();
}
