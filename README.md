# Take Stock

## Development

Running a local postgres instance. This will create the db on which the migration scripts run.
```
cd docker
docker build . -t thingo
docker run -p 5432:5432 thingo 
```

Migration scripts:
```
./gradlew flywayMigrate -i
```

After manual changes you can reset flyway state with `flywayClean`  

Or connect manually to poke around
```
$ psql -h 192.168.99.100  -U postgres
```