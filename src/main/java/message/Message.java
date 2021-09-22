package message;

public class Message {

    private String sensor_id;
    private String model;
    private String payload;

    public String getSensor_id() {
        return sensor_id;
    }

    public String getModel() {
        return model;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Message() {
    }

    public Message(String sensor_id, String model, String payload) {
        this.sensor_id = sensor_id;
        this.model = model;
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "message.Message{" +
                "sensor_id='" + sensor_id + '\'' +
                ", model='" + model + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
