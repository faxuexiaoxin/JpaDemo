package top.faxuexiaoxin.dao;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.faxuexiaoxin.entity.ExaminationGrade;

import java.util.Optional;

@Repository
public interface ExaminationGradeDao2 extends JpaRepository<ExaminationGrade,Long>{
    /**
     * 默认提供了findExample的方法
     */
    @Override
    <S extends ExaminationGrade> Optional<S> findOne(Example<S> example);

    @Override
    <S extends ExaminationGrade> Page<S> findAll(Example<S> example, Pageable pageable);
}
