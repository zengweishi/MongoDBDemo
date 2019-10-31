package mongodb.web;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import mongodb.domain.Product;
import mongodb.service.ProductService;

import java.util.Scanner;

/**
 * description:TODO
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/31 14:35
 */
public class ProductWeb {
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--------欢迎来到商品管理系统--------");
            System.out.println("输入以下命令进行操作:");
            System.out.println("C:添加商品D:根据编号删除商品 DA:删除所有商品 I:根据商品编号查询商品信息 FA:查询所有商品信息 Q:退出");
            // 获取用户输入的内容
            String s = sc.nextLine();
            switch (s.toUpperCase()) {
                case "C":
                    System.out.println("增加商品");
                    addProduct();
                    break;
                case "D":
                    System.out.println("根据编号删除商品");
                    deleteProductById();
                    break;
                case "DA":
                    System.out.println("暂时不允许删除所有商品");
                    break;
                case "I":
                    System.out.println("根据编号查询商品信息");
                    findProductById();
                    break;
                case "FA":
                    System.out.println("查询所有商品信息");
                    findAllProducts();
                    break;
                case "Q":
                     System.out.println("欢迎再次访问!");
                     System.exit(0);
                     break;
                default:
                    System.out.println("谢谢，欢迎再次访问!");
                    System.exit(0);
            }
        }
    }

    /**
     * description: 根据ID删除商品
     * @author weishi.zeng
     * @date 2019/10/31 15:08
     * @param []
     * @return void
     */
    private static void deleteProductById() {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的商品ID：");
        String s = scanner.nextLine();
        int pid = Integer.valueOf(s);
        try {
            DBCursor dbCursor = productService.findProductById(pid);
            if (dbCursor.size() == 0) {
                System.out.println("数据库中无该商品！");
            } else {
                System.out.println("请确定是否删除？y/n");
                String result = scanner.nextLine();
                if (result.equals("y")) {
                    productService.deleteProductById(pid);
                    System.out.println("根据ID删除商品成功");
                }
            }
        } catch (Exception e) {
            System.out.println("根据ID删除商品出现异常");
            e.printStackTrace();
        }
    }

    /**
     * description: 添加商品
     * @author weishi.zeng
     * @date 2019/10/31 15:00
     * @param []
     * @return void
     */
    private static void addProduct() {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品ID：");
        String s = scanner.nextLine();
        int i = Integer.parseInt(s);
        System.out.println("请输入商品名称：");
        String name = scanner.nextLine();
        System.out.println("请输入商品价格：");
        String priceStr = scanner.nextLine();
        int price = Integer.parseInt(priceStr);
        Product product = new Product();
        product.setPid(i);
        product.setPname(name);
        product.setPrice(price);
        try {
            productService.addProduct(product);
            System.out.println("添加商品成功！");
        } catch (Exception e) {
            System.out.println("添加商品出现异常！");
            e.printStackTrace();
        }
    }

    /**
     * description: 根据ID查询商品
     * @author weishi.zeng
     * @date 2019/10/31 14:47
     * @param []
     * @return void
     */
    private static void findProductById() {
        ProductService productService = new ProductService();
        System.out.println("请输入商品编号：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int pid = Integer.valueOf(s);
        try {
            DBCursor dbCursor = productService.findProductById(pid);
            if (dbCursor.size() == 0) {
                System.out.println("查无该商品");
            } else {
                while (dbCursor.hasNext()) {
                    DBObject product = dbCursor.next();
                    System.out.println("商品id:" + product.get("pid"));
                    System.out.println("商品名称：" + product.get("pname"));
                    System.out.println("商品价格：" + product.get("price"));
                }
            }
        } catch (Exception e) {
            System.out.println("根据编号查询商品信息出现异常");
            e.printStackTrace();
        }
    }

    /**
     * description: 查询所有商品
     * @author weishi.zeng
     * @date 2019/10/31 14:47
     * @param []
     * @return void
     */
    private static void findAllProducts() {
        ProductService productService = new ProductService();
        try {
            DBCursor dbCursor = productService.findAllProducts();
            if (dbCursor.size() == 0) {
                System.out.println("没有商品");
            } else {
                System.out.println("商品id\t商品名称\t商品价格");
                while (dbCursor.hasNext()) {
                    DBObject product = dbCursor.next();
                    System.out.println(product.get("pid")+"\t"+product.get("pname")+"\t"+product.get("price"));
                }
            }
        } catch (Exception e) {
            System.out.println("查询所有商品信息出现异常");
            e.printStackTrace();
        }
    }


}
