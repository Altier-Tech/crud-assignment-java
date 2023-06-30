package tech.altier.dba;

public class Item {

    /*
    this class is a data model for this entity:

    items
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `description` VARCHAR(45) NOT NULL,
    `quantity` INT NOT NULL,
    `price` DOUBLE NOT NULL,
     PRIMARY KEY (`id`))

     */

    private int id;
    private String name;
    private String description;
    private int quantity;
    private double price;

    public Item() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.quantity = 0;
        this.price = 0.0;
    }

    public Item(int id, String name, String description, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Item(String name, String description, int quantity, double price) {
        this.id = 0;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name.length() > 45) {
            this.name = name.substring(0, 45);
        } else {
            this.name = name;
        }
    }

    public void setDescription(String description) {
        if (description.length() > 45) {
            this.description = description.substring(0, 45);
        } else {
            this.description = description;
        }
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", description='" + this.description + '\'' +
                ", quantity=" + this.quantity +
                ", price=" + this.price +
                '}';
    }

}
