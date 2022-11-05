MODSEN REST CRUD APPLICATION

    The app will start running at http://localhost:8080
                    

         CRUDs commands for RestCintroller:
                     
              GET:/rest/getData
              GET:/rest/getEvent/byId
              GET:/rest/filter
              GET:/rest/sort
              POST:/rest/deleteEvent/{event}
              POST:/rest/addNewEvent"
              POST:/rest/updateEvent

You can create DB with scripts:

        create table if not exists event
        (
        id integer not null
        primary key,
        organizer varchar(255),
        place varchar(255),
        subject varchar(255),
        time timestamp
        );
        
        alter table event
        owner to postgres;

or you can run migrations from resources.db.migrations

also you can use docker-compose.yml, but my pc is on fire when i try to use it)


