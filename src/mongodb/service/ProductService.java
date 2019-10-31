package mongodb.service;

import com.mongodb.DBCursor;
import mongodb.dao.ProductDao;
import mongodb.domain.Product;

/**
 * description:TODO
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/31 14:35
 */
public class ProductService {
    ProductDao productDao = new ProductDao();
    /**
     * description: 查询所有商品
     * @author weishi.zeng
     * @date 2019/10/31 14:51
     * @param []
     * @return com.mongodb.DBCursor
     */
    public DBCursor findAllProducts() throws Exception {
        return productDao.findAllProducts();
    }

    /**
     * description: 根据ID查询商品
     * @author weishi.zeng
     * @date 2019/10/31 14:50
     * @param [pid]
     * @return com.mongodb.DBCursor
     */
    public DBCursor findProductById(int pid) throws Exception {
        return productDao.findProductById(pid);
    }

    /**
     * description: 添加商品
     * @author weishi.zeng
     * @date 2019/10/31 15:05
     * @param [product]
     * @return void
     */
    public void addProduct(Product product) throws Exception {
        productDao.addProduct(product);
    }

    /**
     * description: 根据ID删除商品
     * @author weishi.zeng
     * @date 2019/10/31 15:13
     * @param [pid]
     * @return void
     */
    public void deleteProductById(int pid) throws Exception {
        productDao.deleteProductById(pid);
    }
}
