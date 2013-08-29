dostSensor
==========
Stores DOST Sensor information taken from its Web Service into 
PostgreSQL/PostGIS database


Things to do:
-------------
1. Create a PostgreSQL Database.

    * createdb flood

2. Add PostGIS extension
 
    * psql flood
    * create extension postgis;
    * create extension postgis_topology;
    
3. Create the Sensor tables
<code> 
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
</code>
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

4. Create view tables to access only the latest data

    create view asg_latest as  
        select a.* from asg as a inner join 
            (select  name,max(time) as time from asg group by name) as b 
            on a.name = b.name and a.time = b.time order by a.time desc;
            
    create view arg_latest as  
        select a.* from arg as a inner join 
            (select  name,max(time) as time from arg group by name) as b 
            on a.name = b.name and a.time = b.time order by a.time desc;     
            
    create view aws_latest as  
        select a.* from aws as a inner join 
            (select  name,max(time) as time from aws group by name) as b 
            on a.name = b.name and a.time = b.time order by a.time desc;
        
    create view td_latest as  
        select a.* from td as a inner join 
            (select  name,max(time) as time from td group by name) as b 
            on a.name = b.name and a.time = b.time order by a.time desc;        
        
5. Run the jar file that will populate the sensor table

    java -jar dostFlood.jar http://noah.dost.gov.ph/asg/metromanilastonino_wl/
    
6. Create a Cron entry that will execute the program above and
     populate the sensor table at specific times.
   