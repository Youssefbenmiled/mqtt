/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqttv2;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author asus
 */
public class Publisher {
    
     public static void main(String[] args) throws MqttException {

    String messageString = "Message to io_data topic subscribers !";

    /*if (args.length == 2 ) {
      messageString = args[1];
    }*/


    System.out.println("== START PUBLISHER ==");


    MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
    client.connect();
    MqttMessage message = new MqttMessage();
    
    
    message.setPayload(messageString.getBytes());
    
    
    client.publish("iot_data", message);


    client.disconnect();


  }
    
}
