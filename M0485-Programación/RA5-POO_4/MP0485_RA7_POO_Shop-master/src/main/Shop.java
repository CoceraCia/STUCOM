package main;

import model.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Shop {

    private Amount cash = new Amount(100.0);
    private ArrayList<Product> inventory;
    private ArrayList<Sale> sales;

    final static double TAX_RATE = 1.04;

    public ArrayList<Product> getInventory() {
        return inventory;
    }
    
    

    public Shop() {
        inventory = new ArrayList<>();
        sales = new ArrayList<>();
    }

    public static void main(String[] args) {
        FilesManipulation files = new FilesManipulation();
        files.createLocation("files"); //en la carpeta del proyecto creamos la carpeta
        
        
        Employee emp = new Employee("Jorge");
        while (!initSession(emp)){}
        System.out.println("User loged. Welcome "+ emp.getName() + "!!");
        
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
            System.out.println("9) Eliminar Producto");
            System.out.println("10) Salir programa");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> shop.showCash();
                case 2 -> shop.addProduct();
                case 3 -> shop.addStock();
                case 4 -> shop.setExpired();
                case 5 -> shop.showInventory();
                case 6 -> shop.sale();
                case 7 -> shop.showSales();
                case 8 -> shop.totalAmountOfSales();
                case 9 -> shop.eliminarProducto();
                case 10 -> exit = true;
            }
        } while (!exit);
    }

    
    public static boolean initSession(Logable user){
        Scanner sc = new Scanner(System.in);
        System.out.print("Employee ID: ");
        String id = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        return user.login(id, password);
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

        inventory.add(new Product(name,publicPrice, wholesalerPrice, true, stock));
    }

    /**
     * add a product to inventory
     *
     * @param product
     */
    public void addProduct(Product product) {
        if (findProduct(product.getName()) != null) {
            System.out.println("Articulo ya existente");
            return;
        }
        inventory.add(product);
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
        for (int i = 0; i < this.inventory.size(); i++) {
            System.out.println("-------------------PRODUCTO " + i + "-----------------------");
            System.out.println("ID: " + this.inventory.get(i).getId());
            System.out.println("Nombre: " + this.inventory.get(i).getName());
            System.out.println("Precio publico: " + this.inventory.get(i).getPublicPrice().showAmount());
            System.out.println("Whole Saler Price: " + this.inventory.get(i).getWholesalerPrice().showAmount());
            System.out.println("Disponible: " + this.inventory.get(i).isAvailable());
            System.out.println("Stock: " + this.inventory.get(i).getStock());
        }
    }

    /**
     * make a sale of products to a client
     */
    public void sale() {
        // ask for client name
        Scanner sc = new Scanner(System.in);
        System.out.println("Realizar venta, escribir nombre cliente");
        Client client = new Client(sc.nextLine());

        // sale product until input name is not 0
        double totalAmount = 0.0;
        String name = "";
        ArrayList<Product> productos;    //Creamos un arraylist para almacenar todos los productos que pida el usuario
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
        System.out.println("Venta realizada con Ã©xito, total: " + totalAmount);
        sales.add(new Sale(client, productos, new Amount(totalAmount)));
        if(!client.pay(new Amount(totalAmount))){
            System.out.println("Cliente debe: "+(client.getBalance().getValue() - totalAmount));
        } else {
            System.out.println("Producto pagado, balance actual ->: "+(client.getBalance().getValue() - totalAmount));
        }
    }

    /**
     * show all sales
     */
    private void showSales() {
        System.out.println("Lista de ventas:");
        if (sales != null) {
            for (Sale sale : sales) {
                System.out.println("-------- Client "+ sale.getClient().getName()+"-------");
                for (int i = 0; i < sale.getProducts().size(); i++){
                    System.out.println("\t"+i+"- Product "+ sale.getProducts().get(i).getName());
                }
                System.out.println("\t- Total amount "+ sale.getAmount().showAmount());
            }
        }
    }

    /**
     * find product by name
     *
     * @param name
     * @return product found by name
     */
    public Product findProduct(String name) {
        for (int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i) != null && this.inventory.get(i).getName().equalsIgnoreCase(name)) {
                return this.inventory.get(i);
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

    
    public void eliminarProducto(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Producto a eliminar? -> ");
        String pr = sc.nextLine().strip();
        for (int i = 0; i < this.inventory.size();i++){
            if (pr.equalsIgnoreCase(this.inventory.get(i).getName())){
                this.inventory.remove(this.inventory.get(i));
                return;
            }
        }
        System.out.println("Producto innexistente");
    }
    
}
