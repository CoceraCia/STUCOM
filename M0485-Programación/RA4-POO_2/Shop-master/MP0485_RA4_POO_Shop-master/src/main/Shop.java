package main;

import model.Product;
import model.Sale;
import model.Amount;
import java.util.Scanner;
import java.util.ArrayList;

public class Shop {

    private Amount cash = new Amount(100.0);
    private Product[] inventory;
    private int numberProducts;
    private ArrayList<Sale> sales;

    final static double TAX_RATE = 1.04;

    public Shop() {
        inventory = new Product[10];
        sales = new ArrayList<>();
    }

    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.loadInventory();

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean exit = false;

        do {
            System.out.println("\n");
            System.out.println("===========================");
            System.out.println("Menu principal miTienda.com");
            System.out.println("===========================");
            System.out.println("1) Contar caja");
            System.out.println("2) Añadir producto");
            System.out.println("3) Anadir stock");
            System.out.println("4) Marcar producto proxima caducidad");
            System.out.println("5) Ver inventario");
            System.out.println("6) Venta");
            System.out.println("7) Ver ventas");
            System.out.println("8) Numero total de ventas");
            System.out.println("10) Salir programa");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    shop.showCash();
                    break;

                case 2:
                    shop.addProduct();
                    break;

                case 3:
                    shop.addStock();
                    break;

                case 4:
                    shop.setExpired();
                    break;

                case 5:
                    shop.showInventory();
                    break;

                case 6:
                    shop.sale();
                    break;

                case 7:
                    shop.showSales();
                    break;
                case 8:
                    shop.totalAmountOfSales();
                    break;

                case 10:
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    /**
     * load initial inventory to shop
     */
    public void loadInventory() {
        addProduct(new Product("Manzana",new Amount(15.00), new Amount(10.00), true, 10));
        addProduct(new Product("Pera",new Amount(25.0), new Amount(20.00), true, 20));
        addProduct(new Product("Hamburguesa", new Amount(35.0), new Amount(30.00), true, 30));
        addProduct(new Product("Fresa",new Amount(8.50), new Amount(5.00), true, 20));
    }

    /**
     * show current total cash
     */
    public void showCash() {
        System.out.println("Dinero actual: " + cash.showAmount());
    }

    /**
     * add a new product to inventory getting data from console
     */
    public void addProduct() {
        if (isInventoryFull()) {
            System.out.println("No se pueden aÃ±adir mÃ¡s productos");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre: ");
        String name = scanner.nextLine();

        if (findProduct(name) != null) {
            System.out.println("Articulo ya existente");
            return;
        }
        System.out.print("Precio cara al publico: ");
        double value = scanner.nextDouble();
        Amount publicPrice = new Amount(value);
        System.out.print("Precio mayorista: ");
        double salerPrice = scanner.nextDouble();
        Amount wholesalerPrice = new Amount(salerPrice);
        System.out.print("Stock: ");
        int stock = scanner.nextInt();

        inventory[numberProducts] = new Product(name,publicPrice, wholesalerPrice, true, stock);
        numberProducts++;
    }

    /**
     * add a product to inventory
     *
     * @param product
     */
    public void addProduct(Product product) {
        if (isInventoryFull()) {
            System.out.println("No se pueden aÃ±adir mÃ¡s productos");
            return;
        }
        if (findProduct(product.getName()) != null) {
            System.out.println("Articulo ya existente");
            return;
        }
        inventory[numberProducts] = product;
        numberProducts++;
    }

    /**
     * add stock for a specific product
     */
    public void addStock() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione un nombre de producto: ");
        String name = scanner.next();
        Product product = findProduct(name);

        if (product != null) {
            // ask for stock
            System.out.print("Seleccione la cantidad a aÃ±adir: ");
            int stock = scanner.nextInt();
            // update stock product
            product.setStock(product.getStock() + stock);
            System.out.println("El stock del producto " + name + " ha sido actualizado a " + product.getStock());

        } else {
            System.out.println("No se ha encontrado el producto con nombre " + name);
        }
    }

    /**
     * set a product as expired
     */
    private void setExpired() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione un nombre de producto: ");
        String name = scanner.next();

        Product product = findProduct(name);
        
        if (product != null) {
            product.setStock(0);
            product.setAvailable(false);
            System.out.println("El stock del producto " + name + " ha sido actualizado a " + product.getStock());
            
        }
    }

    /**
     * show all inventory
     */
    public void showInventory() {
        System.out.println("Contenido actual de la tienda:");
        for (int i = 0; i < numberProducts; i++) {
            System.out.println("-------------------PRODUCTO " + i + "-----------------------");
            System.out.println("ID: " + inventory[i].getId());
            System.out.println("Nombre: " + inventory[i].getName());
            System.out.println("Precio publico: " + inventory[i].getPublicPrice().showAmount());
            System.out.println("Whole Saler Price: " + inventory[i].getWholesalerPrice().showAmount());
            System.out.println("Disponible: " + inventory[i].isAvailable());
            System.out.println("Stock: " + inventory[i].getStock());
        }
    }

    /**
     * make a sale of products to a client
     */
    public void sale() {
        // ask for client name
        Scanner sc = new Scanner(System.in);
        System.out.println("Realizar venta, escribir nombre cliente");
        String client = sc.nextLine();

        // sale product until input name is not 0
        double totalAmount = 0.0;
        String name = "";
        ArrayList<Product> productos;    //Creamos un arraylist temporal para almacenar todos los productos que pida el usuario
        productos = new ArrayList<>();
        while (!name.equals("0")) {
            System.out.println("Introduce el nombre del producto, escribir 0 para terminar:");
            name = sc.nextLine();

            if (name.equals("0")) {
                break;
            }
            Product product = findProduct(name);
            boolean productAvailable = false;

            if (product != null && product.isAvailable()) {
                productAvailable = true;
                totalAmount += product.getPublicPrice().getValue();
                product.setStock(product.getStock() - 1);
                // if no more stock, set as not available to sale
                if (product.getStock() == 0) {
                    product.setAvailable(false);
                }
                productos.add(product);
                System.out.println("Producto aÃ±adido con Ã©xito");
            }

            if (!productAvailable) {
                System.out.println("Producto no encontrado o sin stock");
            }
        }

        // show cost total
        totalAmount = totalAmount * TAX_RATE;
        cash.setValue(cash.getValue()+totalAmount);
        Product[] prodFinal = new Product[productos.size()];
        System.out.println("Venta realizada con Ã©xito, total: " + totalAmount);
        productos.toArray(prodFinal);
        sales.add(new Sale(client, prodFinal, new Amount(totalAmount)));
    }

    /**
     * show all sales
     */
    private void showSales() {
        System.out.println("Lista de ventas:");
        if (sales != null) {
            for (Sale sale : sales) {
                System.out.println(sale);
            }
        }
    }

    /**
     * check if inventory is full or not
     *
     * @return true if inventory is full
     */
    public boolean isInventoryFull() {
        if (numberProducts == 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * find product by name
     *
     * @param name
     * @return product found by name
     */
    public Product findProduct(String name) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].getName().equalsIgnoreCase(name)) {
                return inventory[i];
            }
        }
        return null;
    }
    
    public void totalAmountOfSales(){
        System.out.println("El numero total de ventas es de --> "+sales.size());
        double total = 0;
        for (Sale sale: sales){
            total += sale.getAmount().getValue();
        }
        
        System.out.println("El valor total de las ventas son de --> "+total);
    }

}
