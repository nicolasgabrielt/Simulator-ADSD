package entities;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_port;
import eduni.simjava.distributions.Sim_uniform_obj;

public class Sensor extends Sim_entity {
    private Sim_port out;

    private Sim_uniform_obj delay;

    private int eventsAmount;

    public Sensor(String s, int eventsAmount, double min, double max) {
        super(s);
        this.eventsAmount = eventsAmount;

        out = new Sim_port("Out");
        add_port(out);

        delay = new Sim_uniform_obj("Delay", min, max);
        add_generator(delay);
    }

    @Override
    public void body() {
        for(int i = 1; i <= eventsAmount; i++) {
//          send the event to the entity connected to the OUT port
            sim_schedule(out, 0.0, 0);
//          wait for a random period of time to send the next event
            sim_pause(delay.sample());
        }
    }
}
