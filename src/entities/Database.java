package entities;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_event;
import eduni.simjava.Sim_port;
import eduni.simjava.Sim_system;
import eduni.simjava.distributions.Sim_uniform_obj;

public class Database extends Sim_entity {

    private Sim_port in;
    private Sim_uniform_obj delay;

    public Database(String name, double min, double max) {
        super(name);

        delay = new Sim_uniform_obj("Delay", min, max);
        add_generator(delay);

        in = new Sim_port("In");
        add_port(in);
    }

    @Override
    public void body() {
       while (Sim_system.running()) {
//        get the next event and process it
           Sim_event e = new Sim_event();
           sim_get_next(e);
           sim_process(delay.sample());
           sim_completed(e);
       }
    }
}
