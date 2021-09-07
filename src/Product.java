public class Product {
    private String id;
    private String name;
    private String price;
    private String quantiny;
    private String description;

    public Product() {
    }

    public Product(String id, String name, String price, String quantiny, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantiny = quantiny;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantiny() {
        return quantiny;
    }

    public void setQuantiny(String quantiny) {
        this.quantiny = quantiny;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", quantiny=" + quantiny +
                ", description='" + description + '\'' +
                '}';
    }
}
