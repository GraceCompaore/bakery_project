package greta.cda.bakeryproject.domain;

public class OrderProduct {
    private Order order;
    private Product product;
    private int quantity;

    public OrderProduct(Order order, User user, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMontant(int quantity, int price){
        int total = quantity * price;
        return total;
    }
}
