package com.petcelsius.api.controller;

import com.petcelsius.api.domain.CooperateDescImg;
import com.petcelsius.api.domain.CooperateInfo;
import com.petcelsius.api.service.CooperateDescImgService;
import com.petcelsius.api.service.CooperateInfoService;
import com.petcelsius.api.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 合作controller
 */
@RestController
@RequestMapping("cooperateApi")
public class CooperateApiController {

    @Autowired
    private CooperateInfoService cooperateInfoService;
    @Autowired
    private CooperateDescImgService cooperateDescImgService;


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


    /**
     * 根据合租机构的id来获取具体的机构描述图片
     * @param param
     * @return
     */
    @PostMapping("cooperateDescImgList")
    public R cooperateDescImgList(@RequestBody Map<String, Long> param){
        // 提出cooperateId
        Long cooperateId = param.get("cooperateId");
        // 查找对应的cooperateId的描述图片
        try{

            List<CooperateDescImg> cooperateDescImgList = cooperateDescImgService.selectListByCooperateId(cooperateId);
            // 成功返回数据
            return R.ok().put("cooperateDescImgList", cooperateDescImgList);
        }catch (Exception e){
            e.printStackTrace();
            // 失败返回错误信息
            return R.error();
        }
    }

}
