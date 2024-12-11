package cn.edu.ctbu.dp01.dao;

import cn.edu.ctbu.dp01.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherReporsitory extends JpaRepository<Teacher, Integer> {

    /**
     * 按学工号查询
     * @param tno
     * @return
     */
    List<Teacher> findByTno(String tno);
}
