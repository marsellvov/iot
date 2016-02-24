

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
/**
 * Hello world!
 *
 */
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Subscriber implements MqttCallback {

	public void connectionLost(Throwable arg0) {
		arg0.printStackTrace();
		System.out.println("-------------------LOST-----------------------------");
		
	}

	public void deliveryComplete(IMqttDeliveryToken arg0) {
		System.out.println("------------------Delivered--------------------------");
		
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("-------------------------------------------------");
		System.out.println("| Topic:" + topic);
		System.out.println("| Message: " + new String(message.getPayload()));
		System.out.println("-------------------------------------------------");
	}
}