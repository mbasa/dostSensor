create table sensor (
    id    serial,
    name  text,
    time  timestamp,
    value float,
    lon   float,
    lat   float,
    the_geom geometry('POINT',4326),
    PRIMARY KEY ( name,time )
);