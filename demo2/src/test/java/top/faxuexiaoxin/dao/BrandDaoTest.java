package top.faxuexiaoxin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.faxuexiaoxin.entity.Brand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BrandDaoTest {

    @Autowired
    private BrandDao brandDao;

    @org.junit.jupiter.api.Test
    void findBrandByBrandName() {
        printAllData();
        Brand xiaomi = brandDao.findBrandByBrandName("小米手机");
        assertEquals(1,xiaomi.getId());
        assertTrue(xiaomi.isShowStatus());
    }

    private void printAllData() {
        System.out.println(" ===========数据=========== ");
        List<Brand> brands = brandDao.findAll();
        brands.forEach(System.out::println);
        System.out.println(" ====================== ");
    }
}