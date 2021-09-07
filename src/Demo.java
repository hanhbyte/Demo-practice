import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Validate validate = Validate.getInstance();
        ProductManager productManager = new ProductManager();
        productManager.readInFile();
        String chose;
        String regexChose =  "^[1-8]+";
        boolean checkOut;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM----");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Cập nhật danh sách");
            System.out.println("4. Xoá danh sách");
            System.out.println("5. Tìm kiếm sản phẩm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. THOÁT");
            System.out.println("CHỌN CHỨC NĂNG");
            chose = input.nextLine();
            checkOut = validate.validate(chose, regexChose) & chose.equals("8");
            switch (chose){
                case "1":
                    showAllList(productManager);
                    break;
                case "2":
                    addProduct(productManager);
                    break;
                case "3":
                    updateProduct(productManager);
                    break;
                case "4":
                    deleteProduct(productManager);
                    break;
                case "5":
                    searchProductById(productManager);
                    break;
                case "6":
                    readFile(productManager);
                    break;
                case "7":
                    writeFile(productManager);
                    break;
                case "8":
                    break;
                default:
                    System.out.println("Nhập sai chức năng, hãy nhập lại.");
                    break;
            }
        }while (checkOut);
    }


    public static void showAllList(ProductManager productManager){
        productManager.showAll();
        showAllList(productManager);
    }

    public static void showProduct(ProductManager productManager){
        Scanner inputNumber = new Scanner(System.in);
        System.out.println("Nhập id sản phẩm bạn muốn xem: ");
        String id = inputNumber.nextLine();
        int index = productManager.findProduct(id);
        if (index != -1){
            Product product = productManager.getList().get(index);
            String idProduct = product.getId();
            String nameProduct = product.getName();
            String priceProduct = product.getPrice();
            String quantinyProduct = product.getQuantiny();
            List<String> list = new ArrayList<>();
            list.add(idProduct);
            list.add(nameProduct);
            list.add(priceProduct);
            list.add(quantinyProduct);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
                inputNumber.nextLine();
            }
        }else {
            System.out.println("Không tìm thấy.");
        }
    }

    public static Product createProduct(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập id: ");
        String id = input.nextLine();
        System.out.println("Nhập tên: ");
        String name = input.nextLine();
        System.out.println("Nhập giá: ");
        String price = input.nextLine();
        System.out.println("Nhập số lượng: ");
        String quantiny = input.nextLine();
        System.out.println("Nhập mô tả: ");
        String description = input.nextLine();
        if (id.equals("") || name.equals("") || price.equals("") || quantiny.equals("") || description.equals("")){
            System.out.println("Nhập lại.");
            createProduct();
        }
        return new Product(id, name, price, quantiny, description);
    }

    public static  void addProduct(ProductManager productManager){
        Product product = createProduct();
        productManager.addProduct(product);
    }

    public static void updateProduct(ProductManager productManager){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id cần sửa: ");
        String id = scanner.nextLine();
        int index = productManager.findProduct(id);
        if (index != -1){
            System.out.println("Nhập id: ");
            String idProduct = scanner.nextLine();
            System.out.println("Nhập tên: ");
            String nameProduct = scanner.nextLine();
            System.out.println("Nhập giá: ");
            String priceProduct = scanner.nextLine();
            System.out.println("Nhập số lượng: ");
            String quantinyProduct = scanner.nextLine();
            System.out.println("Nhập mô tả: ");
            String description = scanner.nextLine();
            Product product = new Product(idProduct, nameProduct, priceProduct, quantinyProduct, description);
            productManager.editProduct(id, product);
        }
    }

    public static void deleteProduct(ProductManager productManager){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id sản phẩm cần xoá: ");
        String id = scanner.nextLine();
        productManager.deleteProduct(id);
    }

    public static void searchProductById(ProductManager productManager){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id cần tìm : ");
        String id = scanner.nextLine();
        int index =productManager.findProduct(id);
        if (index == -1) {
            System.out.println("Không tìm thấy");
        } else {
            System.out.println("Thông tin sản phẩm là" + productManager.getList().get(index));
        }
    }

    public static void writeFile(ProductManager productManager) {
       productManager.writeOnFile();
    }

    public static void readFile(ProductManager productManager) {
        productManager.readInFile();
    }
}
