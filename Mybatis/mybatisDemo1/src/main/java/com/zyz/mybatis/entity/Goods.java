package com.zyz.mybatis.entity;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.entity
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-22  09:11
 * @Description: 商品实体类
 * @Version: 1.0
 */
public class Goods {
    private Integer id;
    private String goods_Name;
    private Integer goods_Amount;
    private Float goods_Price;
    public Goods() {
    }

    public Goods(Integer id, String goods_Name, Integer goods_Amount, Float goods_Price) {
        this.id = id;
        this.goods_Name = goods_Name;
        this.goods_Amount = goods_Amount;
        this.goods_Price = goods_Price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoods_Name() {
        return goods_Name;
    }

    public void setGoods_Name(String goods_Name) {
        this.goods_Name = goods_Name;
    }

    public Integer getGoods_Amount() {
        return goods_Amount;
    }

    public void setGoods_Amount(Integer goods_Amount) {
        this.goods_Amount = goods_Amount;
    }

    public Float getGoods_Price() {
        return goods_Price;
    }

    public void setGoods_Price(Float goods_Price) {
        this.goods_Price = goods_Price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goods_Name='" + goods_Name + '\'' +
                ", goods_Amount=" + goods_Amount +
                ", goods_Price=" + goods_Price +
                '}';
    }
}
