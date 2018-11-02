package entities;

import eduni.simjava.Sim_event;
import eduni.simjava.Sim_port;
import eduni.simjava.Sim_system;

public class Database extends CustomEntity {

    private Sim_port in;

    public Database(String name, double min, double max) {
        super(name, min, max);

        in = new Sim_port("In");
        add_port(in);
    }

    @Override
    public void body() {
       while (Sim_system.running()) {
//        get the next event and process it
           Sim_event e = new Sim_event();
           sim_get_next(e);
           sim_process(getDelay().sample());
           sim_completed(e);
       }
    }
}
