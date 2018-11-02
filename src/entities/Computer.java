package entities;

import eduni.simjava.Sim_event;
import eduni.simjava.Sim_port;
import eduni.simjava.Sim_system;

public class Computer extends CustomEntity {

    private Sim_port inA;
    private Sim_port inB;
    private Sim_port out;


    public Computer(String name, double min, double max) {
        super(name, min, max);
//      create and add ports
        inA = new Sim_port("InA");
        inB = new Sim_port("InB");
        out = new Sim_port("Out");
        add_port(inA);
        add_port(inB);
        add_port(out);
    }

    @Override
    public void body() {
        while (Sim_system.running()) {
            Sim_event e = new Sim_event();
//            get the next event
            sim_get_next(e);
//            process the event
            sim_process(getDelay().sample());
//            the event has completed service
            sim_completed(e);
//            send the event to the server
            sim_schedule(out, 0.0,1);
        }

    }
}
