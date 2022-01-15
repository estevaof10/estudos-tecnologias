package br.com.alura.estudo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Map;
import java.util.Properties;

public class NewOrderMain {
    public static void main(String[] args) {

        var producer =  new KafkaProducer<String, String>(properties());
        var value ="123456,654654,8978979879" ;
        var record = new ProducerRecord<>("ECOMMERCE_NEW_ORDER",value,value);
        producer.send(record, (data,ex) ->{
            if(ex != null){
                ex.printStackTrace();
                return;
            }
            System.out.println("sucesso enviando "+ data.topic() + ":::: partition " + data.partition() + " / offset "
            + data.offset() + "time " + data.timestamp());
        });
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1.:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties ;
    }
}
