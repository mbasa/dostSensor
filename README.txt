Things to do:

1. Create a PostgreSQL Database.

    createdb flood
 
 2. Add PostGIS extension
 
    psql flood
    create extension postgis;
    create extension postgis_topology;
    
 3. Create the Sensor tables
 
    create table asg (
        id    serial,
        name  text,
        time  timestamp,
        value float,
        water_level_change float,
        time_difference    float,
        lon   float,
        lat   float,
        the_geom geometry('POINT',4326),
        PRIMARY KEY ( name,time )
    );

    create table td (
        id    serial,
        name  text,
        time  timestamp,
        value float,
        water_level_change float,
        time_difference    float,
        lon   float,
        lat   float,
        the_geom geometry('POINT',4326),
        PRIMARY KEY ( name,time )
    );

    create table arg (
        id    serial,
        name  text,
        time  timestamp,
        value float,
        lon   float,
        lat   float,
        the_geom geometry('POINT',4326),
        PRIMARY KEY ( name,time )
    );

    create table aws (
        id    serial,
        name  text,
        time  timestamp,
        temp  float,
        humi  float,
        pres  float,
        rain  float,
        lon   float,
        lat   float,
        the_geom geometry('POINT',4326),
        PRIMARY KEY ( name,time )
    );
    
4. Run the jar file that will populate the sensor table

    java -jar dostFlood.jar http://noah.dost.gov.ph/asg/metromanilastonino_wl/
    
5. Create a Cron entry that will execute the program above and
     populate the sensor table at specific times.
   