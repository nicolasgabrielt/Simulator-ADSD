package entities;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_port;
import eduni.simjava.distributions.Sim_uniform_obj;

public class Database extends Sim_entity {

    private Sim_port in_a;
    private Sim_uniform_obj delay;

    public Database(String name, double min, double max) {
        super(name);

        delay = new Sim_uniform_obj("Delay", min, max);
        add_generator(delay);

        in_a = new Sim_port("InA");

        add_port(in_a);

    }

    @Override
    public void body() {
        super.body();
    }
}
