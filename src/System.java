import eduni.simjava.Sim_system;
import entities.*;


public class System {

    public static void main(String[] args) {

        // Initialise Sim_system
        Sim_system.initialise();
        // Add the sensors
        Sensor sensorA = new Sensor("SensorA", 100,5 , 10 );
        Sensor sensorB = new Sensor("SensorB", 70,1, 5 );
        Sensor sensorC = new Sensor("SensorC", 80, 10 , 20 );
        Sensor sensorD = new Sensor("SensorD", 95,20, 30 );
        // Add the computers
        Computer computerA = new Computer("ComputerA", 30 , 50);
        Computer computerB = new Computer("ComputerB", 10 , 20);
        // Add the Server
        Server server = new Server("Server", 60, 80);
        // Add the Database
        Database db = new Database("Database", 110, 220);
        // Add the Client
        Client client = new Client("Client", 50, 60);

        // Link the entities' ports
        Sim_system.link_ports("SensorA", "Out", "ComputerA", "InA");
        Sim_system.link_ports("SensorB", "Out", "ComputerA", "InB");
        Sim_system.link_ports("SensorC", "Out", "ComputerB", "InA");
        Sim_system.link_ports("SensorD", "Out", "ComputerB", "InB");

        Sim_system.link_ports("ComputerA", "Out", "Server", "InA");
        Sim_system.link_ports("ComputerB", "Out", "Server", "InB");

        Sim_system.link_ports("Server", "OutA", "Client", "In");
        Sim_system.link_ports("Server", "OutB", "Database", "In");
        // Run the simulation
        Sim_system.run();

    }
}
