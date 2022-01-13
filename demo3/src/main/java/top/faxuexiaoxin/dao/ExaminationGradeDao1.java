package top.faxuexiaoxin.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import top.faxuexiaoxin.entity.ExaminationGrade;

import java.util.List;


/**
 * 简单的查询
 */
@Service
public interface ExaminationGradeDao1 extends JpaRepository<ExaminationGrade,Long> {

    //不分页
    /**
     * 根据语文分数查询
     * @param chineseSource
     * @return
     */
    ExaminationGrade findFirstDistinctByChineseSource(int chineseSource);

    /**
     * 根据英语分数查询
     * @param englishSource
     * @return
     */
    ExaminationGrade findByEnglishSource(int englishSource);

    /**
     * 排序查询英语的分数
     * @param english
     * @param sort
     * @return
     */
    List<ExaminationGrade> findAllByEnglishSource(int english, Sort sort);

    /**
     * 分页 + 排序 查询英语的分数
     * 分页会自动包括排序的功能
     */
    List<ExaminationGrade> findByEnglishSource(int english, Pageable pageable);

    /**
     * 查询前面10名 英语成绩在start和end之间的人
     * @param englishSourceStart
     * @param englishSourceEnd
     * @return
     */
    List<ExaminationGrade> findTop10ByEnglishSourceBetween(int englishSourceStart,int englishSourceEnd);

    /**
     * 查询前面n名 英语成绩在start和end之间的人并且 语文成绩大于 一定分数的人
     * @param englishSourceStart
     * @param englishSourceEnd
     * @param chineseSourceStart
     * @return
     */
    List<ExaminationGrade> findFirst10ByEnglishSourceBetweenAndChineseSourceAfter(int englishSourceStart,int englishSourceEnd,int chineseSourceStart);

}
