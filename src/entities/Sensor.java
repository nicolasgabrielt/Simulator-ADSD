package entities;

import eduni.simjava.Sim_port;

public class Sensor extends CustomEntity {

    private Sim_port out;
    private int eventsAmount;


    public Sensor(String s, int eventsAmount, double min, double max) {
        super(s, min, max);
        this.eventsAmount = eventsAmount;

        out = new Sim_port("Out");
        add_port(out);
    }

    @Override
    public void body() {
        for(int i = 1; i <= eventsAmount; i++) {
//          send the event to the entity connected to the OUT port
            sim_schedule(out, 0.0, 0);
//          wait for a random period of time to send the next event
            sim_pause(getDelay().sample());
        }
    }
}
