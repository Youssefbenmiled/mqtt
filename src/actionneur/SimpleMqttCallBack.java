/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionneur;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author asus
 */
public class SimpleMqttCallBack implements MqttCallback {

    public SimpleMqttCallBack() {
    }
    
    

    @Override
    public void connectionLost(Throwable thrwbl) {
            System.out.println("Connection to MQTT broker lost!");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void messageArrived(String string, MqttMessage mqttMessage) throws Exception {
            System.out.println("Message received:\t"+ new String(mqttMessage.getPayload()) );

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
                    System.out.println("DElivery done !" );
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
