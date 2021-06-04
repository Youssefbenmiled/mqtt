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
public class SalonPublisher implements climatiseur {
    
    public SalonPublisher(){
        
    }
    
        @Override
    public String start(int temperatureMax) {
        if(temperatureMax>32){
            return "Activer Climatiseur sur 24°";

        }else if(temperatureMax<20){
            return "Activer Climatiseur sur 30°";

        }else if(temperatureMax<10){
            return "Fermer les Rideaux";

        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public static void main(String[] args) throws MqttException {

    String messageString = new SalonPublisher().start(19);

    /*if (args.length == 2 ) {
      messageString = args[1];
    }*/


    System.out.println("== START TEMPERATURE PUBLISHER ==");


    MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
    client.connect();
    MqttMessage message = new MqttMessage();
    
    
    message.setPayload(messageString.getBytes());
    
    
    client.publish("température", message);

    //System.out.println("\tMessage '"+ messageString);

    client.disconnect();

    System.out.println("== END TEMPERATURE PUBLISHER ==");

  }
     
   

  

    
    
    
}
