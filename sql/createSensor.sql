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
