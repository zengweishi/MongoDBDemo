package mongodb.domain;

import org.bson.types.ObjectId;

/**
 * description:TODO
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/31 13:40
 */
public class Product {
    private ObjectId obj_id;
    private int pid;//商品id
    private String pname;//商品名字
    private int price;//商品价格
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Product(ObjectId obj_id, int pid, String pname, int price) {
        super();
        this.obj_id = obj_id;
        this.pid = pid;
        this.pname = pname;
        this.price = price;
    }
    public ObjectId getObj_id() {
        return obj_id;
    }
    public void setObj_id(ObjectId obj_id) {
        this.obj_id = obj_id;
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product [obj_id=" + obj_id + ", pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
    }
}
