package com.petcelsius.api.controller;

import com.petcelsius.api.domain.CooperateInfo;
import com.petcelsius.api.service.CooperateInfoService;
import com.petcelsius.api.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cooperateApi")
public class CooperateApiController {

    @Autowired
    private CooperateInfoService cooperateInfoService;


    /**
     * 获取所有合作机构
     * @return
     */
    @GetMapping("cooperateList")
    public R cooperateList(){
        try{
            // 获取所有合作机构集合
            List<CooperateInfo> cooperateInfoList = cooperateInfoService.selectAll();
            return R.ok().put("cooperateList", cooperateInfoList);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
    }

}
