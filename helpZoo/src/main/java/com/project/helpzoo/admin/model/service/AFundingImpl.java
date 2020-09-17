package com.project.helpzoo.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.helpzoo.admin.model.DAO.AFundingDAO;
import com.project.helpzoo.admin.model.vo.AFunding;

@Service
public class AFundingImpl implements AFundingService{

	@Autowired
	private AFundingDAO fundingDAO;
	/**
	 * 펀딩 가져오기
	 */
	@Override
	public List<AFunding> selectFunding() {
		return fundingDAO.selectFunding();
	}
	@Override
	public int updateFunding(AFunding funding) {
		return fundingDAO.updateFunding(funding);
	}
	@Override
	public int deleteFunding(String fundingNo) {
		// TODO Auto-generated method stub
		return fundingDAO.deleteFunding(fundingNo);
	}
	
	/**
	 * status 값에 따라서 값 가져오기
	 */
	@Override
	public List<AFunding> selectFSList(String listStatus) {
		return fundingDAO.selectFSList(listStatus);
	}
	
	/*
	 * @Override public List<AFunding> selectFundingStatus() { return
	 * fundingDAO.selectselectFundingStatus; }
	 */

}
