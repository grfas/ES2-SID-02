package javamongo;

import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import config.Config;
import mongo.MongoWrite;

public class Mqtt implements MqttCallback {
	  static Config cfg = new Config();
	 
	 static final String brokerUrl   = cfg.getProperty("mBrokerName");
	 static final String clientId = cfg.getProperty("mClientId");
	 static final String topic = cfg.getProperty("mTopicName");

	MongoWrite wr = new MongoWrite();
	

	/** The broker url. */
	//private static final String brokerUrl = "tcp://iot.eclipse.org:1883";

	/** The client id. */
	//private static final String clientId = "/sid_lab_2019";

	/** The topic. */
	//private static final String topic = "/sid_lab_2019";

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		new Mqtt().subscribe(topic);
	}

	/**
	 * Subscribe. In this method we need to make sure the brokerUrl, clientID is
	 * passing the right values so that the connection can be Established with the
	 * topic and broker
	 * 
	 * @param topic the topic
	 */
	public void subscribe(String topic) {

		MemoryPersistence persistence = new MemoryPersistence();

		try {

			MqttClient sampleClient = new MqttClient(brokerUrl, clientId, persistence);

			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);

			System.out.println("checking");

			System.out.println("Mqtt Connecting to broker: " + brokerUrl);
			sampleClient.connect(connOpts);
			System.out.println("Mqtt Connected");

			sampleClient.setCallback(this);
			sampleClient.subscribe(topic);

			System.out.println("Subscribed");
			System.out.println("Listening");

		} catch (MqttException me) {

			System.out.println("Mqtt reason " + me.getReasonCode());
			System.out.println("Mqtt msg " + me.getMessage());
			System.out.println("Mqtt loc " + me.getLocalizedMessage());
			System.out.println("Mqtt cause " + me.getCause());
			System.out.println("Mqtt excep " + me);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.paho.client.mqttv3.MqttCallback#connectionLost(java.lang.
	 * Throwable)
	 */
	public void connectionLost(Throwable arg0) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.paho.client.mqttv3.MqttCallback#deliveryComplete(org.eclipse.
	 * paho.client.mqttv3.IMqttDeliveryToken)
	 */
	public void deliveryComplete(IMqttDeliveryToken arg0) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.paho.client.mqttv3.MqttCallback#messageArrived(java.lang.
	 * String, org.eclipse.paho.client.mqttv3.MqttMessage)
	 */

	/**
	 * @author Francisco
	 * @category The first (if) is in order to differentiate from the connection
	 *           message and the information messages, allowing ourselves to get a
	 *           not needed message.
	 * 
	 *           The second (if) has the objective of splitting the String into
	 *           several strings that allocated into an array, in order to be able
	 *           to access it afterwards and verifying the number of splits that
	 *           occurred.
	 * 
	 *           There is a call to (mw) with is an instance of a MongoWrite in
	 *           order to insert the strings in the mongo database.
	 * @param         topic,
	 * @param message
	 * 
	 */
	public void messageArrived(String topic, MqttMessage message) throws Exception {

		System.out.println("Mqtt topic : " + topic);
		System.out.println("Mqtt msg : " + message.toString());

		String mens = message.toString();
		if (!(mens.toString().contains("I'm"))) {

			String[] parts = mens.split(Pattern.quote(","));
			if (parts.length == 5) {

				System.out.println("Leitura Com Luminosidade");

				String a = parts[0];

				String b = parts[1];

				String c = parts[2];
				String d = parts[3];
				String e = parts[4];

				wr.insert(a, b, c, d, e);

			} else if (!(parts.length == 5)) {
				System.out.println("Leitura Sem Luminosidade");
				String cell = " 'cell':0";
				String a = parts[0];

				String b = parts[1];

				String c = parts[2];

				String d = parts[3];

				wr.insert(a, b, c, d, cell);

			}

		}

	}
}
