package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice
{
	private static final int COUNT = 10;

	public static void main(String[] args)
	{
		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start
		
		// create a client object and use it to
		Client client = new Client("sensor", "localhost", 8080);
		
		// - connect to the broker
		client.connect();
		
		// - publish the temperature(s)
		String temperature = "temperature";
		client.createTopic(temperature);
		
		for (int i = 0; i < COUNT; i++)
		{
			client.publish(temperature, Integer.toString(sn.read()));
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// - disconnect from the broker
		client.disconnect();

		// TODO - end

		System.out.println("Temperature device stopping ... ");
	}
}
