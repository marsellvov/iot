
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Main {
	MqttClient myClient;
	MqttConnectOptions connOpt;
    String topic        = "topic/something";
    String content      = "Message from MqttPublishSample";
    int qos             = 0;
    String broker       = "tcp://0.0.0.0:1883";
    String clientId     = "JavaSample2";
	
	
	public static void main(String[] args) {
		new Main().runClient();
	}
	
	public void runClient() {
		// setup MQTT Client
		String clientID = clientId;
		connOpt = new MqttConnectOptions();
		
		connOpt.setCleanSession(true);
		
		// Connect to Broker
		try {
			myClient = new MqttClient(broker, clientID);
			myClient.setCallback(new Subscriber());
			myClient.connect(connOpt);
			myClient.subscribe(topic, qos);
		} catch (MqttException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		System.out.println("Connected to " + broker);
		// disconnect
		try {
			// wait to ensure subscribed messages are delivered
				Thread.sleep(50000);
			myClient.disconnect();
			System.out.println("Disconnected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
