package top.faxuexiaoxin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brand {
    public static final byte displayStatus=1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 商品名称
     */
    private String brandName;

    /**
     * 商品logo
     */
    private String logo;

    /**
     * 商品展示 1表示展示,0表示不展示
     */
    private Byte showStatus;

    /**
     * 商品排序，
     */
    private Integer sort;

    //业务方法
    public boolean isShowStatus(){
        return showStatus.byteValue() == displayStatus;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", logo='" + logo + '\'' +
                ", showStatus=" + showStatus +
                ", sort=" + sort +
                '}';
    }

    //get set方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Byte getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Byte showStatus) {
        this.showStatus = showStatus;
    }

    private Integer getSort() {
        return sort;
    }

    private void setSort(Integer sort) {
        this.sort = sort;
    }
}
