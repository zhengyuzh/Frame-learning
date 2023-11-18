package com.zyz.SpringDemo3.entity;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo3.entity
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-17  16:40
 * @Description: 商品实体类
 * @Version: 1.0
 */
public class Goods {
    private Integer id;
    private String name;
    private Integer amount;
    private Float price;
    public Goods() {
    }
    public Goods(Integer id, String name, Integer amount, Float price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
