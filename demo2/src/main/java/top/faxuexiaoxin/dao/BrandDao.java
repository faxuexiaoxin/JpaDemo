package top.faxuexiaoxin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.faxuexiaoxin.entity.Brand;

@Repository
public interface BrandDao extends JpaRepository<Brand,Integer> {
    Brand findBrandByBrandName(String brandName);
}
