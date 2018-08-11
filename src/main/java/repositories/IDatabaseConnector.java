package repositories;

import java.sql.Connection;

public interface IDatabaseConnector {
    Connection connect();
}
