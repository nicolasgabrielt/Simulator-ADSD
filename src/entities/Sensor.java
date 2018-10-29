package entities;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_port;
import eduni.simjava.distributions.Sim_uniform_obj;

public class Sensor extends Sim_entity {
    private Sim_port out;
    private Sim_uniform_obj delay;

    public Sensor(String s, double min, double max) {
        super(s);
        out = new Sim_port("Out");
        add_port(out);
        delay = new Sim_uniform_obj("Delay", min, max);
        add_generator(delay);
    }

    public void body() {

    }
}
