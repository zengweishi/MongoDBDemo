package mongodb.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import mongodb.domain.Product;
import mongodb.utils.MongoDBUtils;

/**
 * description:TODO
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/31 14:35
 */
public class ProductDao {
    /**
     * description: /查询所有商品
     * @author weishi.zeng
     * @date 2019/10/31 14:43
     * @param []
     * @return com.mongodb.DBCursor
     */
    public DBCursor findAllProducts() throws Exception {
        DBCollection collection = MongoDBUtils.getCollection("itcast", "products");
        DBCursor dbCursor = collection.find();
        return dbCursor;
    }

    /**
     * description: 根据ID查询商品
     * @author weishi.zeng
     * @date 2019/10/31 14:53
     * @param [pid]
     * @return com.mongodb.DBCursor
     */
    public DBCursor findProductById(int pid) throws Exception {
        DBCollection collection = MongoDBUtils.getCollection("itcast", "products");
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("pid",pid);
        DBCursor dbCursor = collection.find(basicDBObject);
        return dbCursor;
    }

    /**
     * description: 添加商品
     * @author weishi.zeng
     * @date 2019/10/31 15:05
     * @param [product]
     * @return void
     */
    public void addProduct(Product product) throws Exception {
        DBCollection collection = MongoDBUtils.getCollection("itcast", "products");
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("pid",product.getPid());
        basicDBObject.put("pname",product.getPname());
        basicDBObject.put("price",product.getPrice());
        collection.insert(basicDBObject);
    }

    /**
     * description: 根据ID删除商品
     * @author weishi.zeng
     * @date 2019/10/31 15:13
     * @param [pid]
     * @return void
     */
    public void deleteProductById(int pid) throws Exception {
        DBCollection collection = MongoDBUtils.getCollection("itcast", "products");
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("pid",pid);
        collection.remove(basicDBObject);
    }
}
