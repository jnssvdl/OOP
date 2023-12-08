package inventorymanager;

public class BoxedProduct {
    String brand;
    int quantity;
    
    BoxedProduct(String brand, int quantity) {
        this.brand = brand;
        this.quantity = quantity;
    }
    
    String getBrand() {
        return brand;
    }
    
    int getQuantity() {
        return quantity;
    }
}
