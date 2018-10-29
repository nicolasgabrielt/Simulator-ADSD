package entities;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_port;
import eduni.simjava.distributions.Sim_uniform_obj;

public class Server extends Sim_entity {

    private Sim_port in_a;
    private Sim_port in_b;

    private Sim_port out_a;
    private Sim_port out_b;

    private Sim_uniform_obj delay;

    public Server(String name, double min, double max) {
        super(name);

        delay = new Sim_uniform_obj("Delay", min, max);
        add_generator(delay);

        in_a = new Sim_port("InA");
        in_b = new Sim_port("InB");

        out_a = new Sim_port("OutA");
        out_b = new Sim_port("OutB");

        add_port(in_a);
        add_port(in_b);
        add_port(out_a);
        add_port(out_b);
    }

    @Override
    public void body() {
        super.body();
    }
}
