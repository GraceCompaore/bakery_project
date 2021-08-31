package greta.cda.bakeryproject.domain;

public class Order {
    private int id;
    private Client client;
    private String order_at;

    public Order(int id, Client client, String order_at) {
        this.id = id;
        this.client = client;
        this.order_at = order_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getOrder_at() {
        return order_at;
    }

    public void setOrder_at(String order_at) {
        this.order_at = order_at;
    }
}
