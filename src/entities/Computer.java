package entities;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_port;
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

    public void body() {

    }
}
