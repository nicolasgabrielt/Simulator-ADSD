package entities;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_event;
import eduni.simjava.Sim_port;
import eduni.simjava.Sim_system;
import eduni.simjava.distributions.Sim_uniform_obj;

public class Computer extends Sim_entity {
    private Sim_port inA;
    private Sim_port inB;

    private Sim_port out;

    private Sim_uniform_obj delay;

    public Computer(String name, double min, double max) {
        super(name);
//      create and add ports
        inA = new Sim_port("InA");
        inB = new Sim_port("InB");
        out = new Sim_port("Out");
        add_port(inA);
        add_port(inB);
        add_port(out);
//      create and add distribution
        delay = new Sim_uniform_obj("Delay", min, max);
        add_generator(delay);
    }

    @Override
    public void body() {
        while (Sim_system.running()) {
            Sim_event e = new Sim_event();
//            get the next event
            sim_get_next(e);
//            process the event
            sim_process(delay.sample());
//            the event has completed service
            sim_completed(e);
//            send the event to the server
            sim_schedule(out, 0.0,1);
        }

    }
}
