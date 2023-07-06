package ezen.exam.mapper;

import java.util.List;

import ezen.exam.vo.EmpVO;

public interface EmpMapper {

    List<EmpVO> getList();
    
    int insert(EmpVO vo);
    
    EmpVO read(Integer empno);
    
    int delete(Integer empno);
}