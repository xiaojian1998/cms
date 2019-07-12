package com.xiaojian.cms.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaojian.cms.dao.SubjectMapper;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Resource
	private SubjectMapper  subjectMapper;
	@Override
	public List<Map> selectSubjectList() {
		// TODO Auto-generated method stub
		return subjectMapper.selectSubjectList();
	}

	@Override
	public boolean insert2(Integer aid[], Integer sid) {
		try {
			// 1先删除专题已有的文章.
			subjectMapper.deleteBySid(sid);
			//2. 在执行插入
			 if(aid!=null) {
				for (int i = 0; i < aid.length; i++)
					subjectMapper.insert(aid[i], sid);
			 }
			 return true;
		} catch (Exception e) {
			throw new RuntimeException("添加失败!");
		}
		
		
	}

	@Override
	public List<Map> selectArtilceListBySid(Integer sid) {
		// TODO Auto-generated method stub
		return subjectMapper.selectArtilceListBySid(sid);
	}

	@Override
	public int insert(Integer aid, Integer sid) {
		
		return subjectMapper.insert(aid, sid);
	}

}
