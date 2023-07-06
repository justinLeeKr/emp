package ezen.exam.service;

import java.util.List;

import ezen.exam.vo.EmpVO;

public interface EmpService {
    
    void employeeJoin(EmpVO employee) throws Exception;

    List<EmpVO> getEmployeeList();

    EmpVO getEmployeeByEmpNo(Integer empno);

    void editEmployee(EmpVO employee);

    List<EmpVO> searchEmployeeByName(String ename);

    void deleteEmployee(Integer empno);
}
