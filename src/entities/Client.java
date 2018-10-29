package entities;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_port;
import eduni.simjava.distributions.Sim_uniform_obj;

public class Client extends Sim_entity {

    private Sim_port in;
    private Sim_uniform_obj delay;

    public Client (String name, double min, double max) {
        super(name);

        delay = new Sim_uniform_obj("Delay", min, max);
        add_generator(delay);

        in = new Sim_port("In");

        add_port(in);

    }

    @Override
    public void body() {
        super.body();
    }
}
