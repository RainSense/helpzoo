package com.project.helpzoo.funding.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.funding.dto.fundingOpen.FundingDetailViewDto;
import com.project.helpzoo.funding.dto.fundingOpen.FundingMainViewDto;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenInfoView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenMakerInfoView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenRequireView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenRewardView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenStoryView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingTotalInfoDto;
import com.project.helpzoo.funding.dto.viewDetail.FundingDetailRewardView;
import com.project.helpzoo.funding.dto.viewDetail.OrderRewardView;
import com.project.helpzoo.funding.model.vo.KakaoPayApiItem;
import com.project.helpzoo.funding.model.vo.funding.FundingAttachment;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.funding.model.vo.order.Address;
import com.project.helpzoo.funding.model.vo.order.Delivery;
import com.project.helpzoo.funding.model.vo.order.OrderReward;
import com.project.helpzoo.funding.model.vo.order.Orders;
import com.project.helpzoo.funding.model.vo.search.FundingSearch;

public interface FundingService {

	
	
	
	
	/** 24시 정각에 현재 등록된 펀딩프로젝트를 확인하여 종료일이 지난 프로젝트를 종료상태로 만드는 service.
	 * 
	 */
	void fundingStatusChange();

	/** 펀딩을 클릭 후 해당하는 번호의 펀딩 내용을 가져오는 service.
	 * @param fundingNo
	 * @return
	 */
	FundingDetailViewDto selectFunding(int fundingNo);
	
	

	/** 펀딩 처음 오픈 시 사용하는 service.
	 * @param makerName
	 * @param businessType
	 * @param phone
	 * @param memberNo
	 * @param string2 
	 * @param string 
	 * @return
	 */
	Long openFunding(String makerName, String businessType, int phone,int memberNo, String string, String string2);



	/** 펀딩 오픈 시 미리 입력한 기본요건을 받아오는 서비스.
	 * @param fundingNo
	 * @return
	 */
	FundingOpenRequireView openRequire(Long fundingNo);



	void openRequireSave(Long fundingNo, FundingOpenRequireView fundingOpenRequireView);



	FundingTotalInfoDto getFundingTotalInfo(Long fundingNo);



	void openInfoSave(Long fundingNo, FundingOpenInfoView fundingOpenInfoView);



	FundingOpenInfoView openInfo(Long fundingNo);



	void insertfundingStoryFile(FundingProject funding, List<MultipartFile> images, String savePath);

	
	//-----------------------------------------Summernote-----------------------------------------
	/** Summernote 이미지 업로드 Service
	 * @param uploadFile
	 * @param savePath
	 * @return map
	 */
	public abstract Map<String, String> insertImage(MultipartFile uploadFile, String savePath);

		
	/** DB에 저장된 파일 목록 조회 Service
	 * @return dbFileList
	 */
	public abstract List<String> selectDbFileList();
	//---------------------------------------------------------------------------------------------



	FundingOpenStoryView openStory(Long fundingNo);



	void insertfundingFile(FundingProject funding, ArrayList<MultipartFile> images, String savePath, Long fileCategory);



	void openRewardSave(Long fundingNo, FundingOpenRewardView rewardView);



	void openMakerSave(FundingOpenMakerInfoView fundingOpenMakerView, Long fundingNo);



	List<FundingDetailRewardView> selectReward(Long fundingNo);



	
	
	String kakaoPayReady(KakaoPayApiItem item, String contextPath,int orderId);



	Long makerOrder();



	void saveDelivery(Delivery delivery);



	Long saveOrder(Orders order, Address addressObject, Long fundingNo);



	List<OrderReward> persisOrderReward(OrderRewardView orderReward, Long ordersId);



	int getPrice(int i);



	String getRewardName(int i);



	void permitOrder(Long ordersId);




	Orders findOrder(Long orderNo2);



	String findRewardName(Long id);



	FundingOpenMakerInfoView openMaker(Long fundingNo);



	FundingAttachment getAttachment(Long fundingNo, long categoryNo);



	void deliteAttachment(FundingAttachment attachment);



	PageInfo pagination(int cp);



	List<FundingMainViewDto> selectList(PageInfo pInfo);

	List<FundingMainViewDto> selectSearchList(FundingSearch search, PageInfo pInfo);



	
}
