/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionneur;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author asus
 */
public class climatiseurClass{

  
    
     public static void main(String[] args) throws MqttException {

    System.out.println("START TEMPERTURE SUBSCRIBER");

    MqttClient client=new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
    client.setCallback((MqttCallback) new SimpleMqttCallBack());
    client.connect();

    client.subscribe("température");

  }
    
}
