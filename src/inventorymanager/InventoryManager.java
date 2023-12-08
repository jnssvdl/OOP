package inventorymanager;

import java.util.ArrayList;

public class InventoryManager {
    ArrayList<SingleProduct> singleProducts = new ArrayList<>();
    ArrayList<BoxedProduct> boxedProducts = new ArrayList<>();
    ArrayList<String> brands = new ArrayList<>();

    void add(SingleProduct p) {
        String brand = p.getBrand();
        if (!brands.contains(brand)) {
            brands.add(brand);
        }
        singleProducts.add(p);
    }

    void add(SingleProduct p, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(p);
        }
    }

    void add(BoxedProduct p) {
        String brand = p.getBrand();
        if (!brands.contains(brand)) {
            brands.add(brand);
        }
        boxedProducts.add(p);
    }

    void add(BoxedProduct p, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(p);
        }
    }

    String[] getBrands() {
        return brands.toArray(new String[0]);
    }

    BoxedProduct[] getBoxes(String brand) {
        ArrayList<BoxedProduct> result = new ArrayList<>();
        for (BoxedProduct p : boxedProducts) {
            if (p.getBrand().equals(brand)) {
                result.add(p);
            }
        }
        return result.toArray(new BoxedProduct[0]);
    }

    SingleProduct[] getSingles(String brand) {
        ArrayList<SingleProduct> result = new ArrayList<>();
        for (SingleProduct p : singleProducts) {
            if (p.getBrand().equals(brand)) {
                result.add(p);
            }
        }
        return result.toArray(new SingleProduct[0]);
    }
}
