import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> list = new ArrayList<>();

    public ProductManager() {
    }

    public ProductManager(List<Product> list) {
        this.list = list;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public void addProduct(Product product) {
        list.add(product);
    }

    public void editProduct(String id, Product product){
        int index = findProduct(id);
            if (index == -1){
                System.out.println("Not found id.");
            }else {
                list.remove(index);
                list.add(index, product);
            }
        }


    public void deleteProduct(String id){
        int index = findProduct(id);
        if (index == -1){
            System.out.println("Not found id");
        }else {
            list.remove(index);
        }
    }

    public void showAll(){
        System.out.println(list);
    }

    public int findProduct(String id){
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(id)){
                index = i;
            }
        }
        return index;
    }

    public void readInFile(){
        try {
            File file = new File("product.csv");
            if (file.length() > 0){
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                list = (List<Product>) objectInputStream.readObject();
            }
        }catch (IOException | ClassNotFoundException exception){
            System.out.println("File not found");
        }
    }

    public void writeOnFile(){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("product.csv");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
