package entities;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_stat;
import eduni.simjava.distributions.Sim_uniform_obj;

public class CustomEntity extends Sim_entity{
    private Sim_stat stat;
    private Sim_uniform_obj delay;

    public CustomEntity(String s, double min, double max) {
        super(s);
        setupStats();
        setupDistribution(min, max);
    }

    protected void setupDistribution(double min, double max) {
        delay = new Sim_uniform_obj("Delay", min, max);
        add_generator(delay);
    }

    protected void setupStats() {
        stat = new Sim_stat();
        stat.add_measure(Sim_stat.UTILISATION);
        stat.add_measure(Sim_stat.SERVICE_TIME);
        stat.add_measure(Sim_stat.WAITING_TIME);
        stat.add_measure(Sim_stat.QUEUE_LENGTH);
        set_stat(stat);
    }

    public Sim_uniform_obj getDelay() {
        return delay;
    }
}
