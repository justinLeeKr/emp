package ezen.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.exam.mapper.EmpMapper;
import ezen.exam.vo.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {

    private final EmpMapper empMapper;

    @Autowired
    public EmpServiceImpl(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    @Override
    public void employeeJoin(EmpVO employee) throws Exception {
        empMapper.insert(employee);
    }

    @Override
    public List<EmpVO> getEmployeeList() {
        return empMapper.getList();
    }

    @Override
    public EmpVO getEmployeeByEmpNo(Integer empno) {
        return empMapper.read(empno);
    }

    @Override
    public void deleteEmployee(Integer empno) {
        empMapper.delete(empno);
    }

	@Override
	public void editEmployee(EmpVO employee) {

		
	}

	@Override
	public List<EmpVO> searchEmployeeByName(String ename) {

		return null;
	}
}
