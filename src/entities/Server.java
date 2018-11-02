package entities;

import eduni.simjava.Sim_event;
import eduni.simjava.Sim_port;
import eduni.simjava.Sim_system;

public class Server extends CustomEntity {

    private Sim_port inA;
    private Sim_port inB;
    private Sim_port outA;
    private Sim_port outB;


    public Server(String name, double min, double max) {
        super(name, min, max);

        inA = new Sim_port("InA");
        inB = new Sim_port("InB");

        outA = new Sim_port("OutA");
        outB = new Sim_port("OutB");

        add_port(inA);
        add_port(inB);
        add_port(outA);
        add_port(outB);
    }

    @Override
    public void body() {
        while (Sim_system.running()) {
//        get the next event and process it
            Sim_event e = new Sim_event();
            sim_get_next(e);
            sim_process(getDelay().sample());
            sim_completed(e);
//        send an event to each output ports
            sim_schedule(outA, 0.0, 2);
            sim_schedule(outB, 0.0, 2);
        }
    }
}
