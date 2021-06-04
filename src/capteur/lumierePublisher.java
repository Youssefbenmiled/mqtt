/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capteur;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author asus
 */
public class lumierePublisher implements lumiere{
    
    public lumierePublisher(){
        
    }
    
    @Override
    public String allumer() {
        return "Allumer la lumieiere";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void eteindre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public static void main(String[] args) throws MqttException {

    String messageString = "A message to lumiereTopic subscirbers ";

    /*if (args.length == 2 ) {
      messageString = args[1];
    }*/


    System.out.println("== START LUMIERE PUBLISHER ==");


    MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
    client.connect();
    MqttMessage message = new MqttMessage();
    message.setPayload(new lumierePublisher().allumer().getBytes());
    client.publish("lumière et sécurité", message);

    System.out.println("\tMessage '"+ messageString );

    client.disconnect();

    //System.out.println("== END LUMIERE PUBLISHER ==");

  }

    
}
