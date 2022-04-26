package com.petcelsius.api.controller;


import com.petcelsius.api.domain.HeartDetailImage;
import com.petcelsius.api.domain.HeartLogo;
import com.petcelsius.api.service.HeartDetailImageService;
import com.petcelsius.api.service.HeartInfoService;
import com.petcelsius.api.service.HeartLogoService;
import com.petcelsius.api.utils.R;
import com.petcelsius.api.vo.HeartListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("heartApi")
public class HeartApiController {

    @Autowired
    private HeartInfoService heartInfoService;

    @Autowired
    private HeartLogoService heartLogoService;

    @Autowired
    private HeartDetailImageService heartDetailImageService;


    /**
     * 查询所有的标题和logo
     * @return
     */
    @GetMapping("heartLogoList")
    public R heartLogoList(){
        try{
            List<HeartLogo> heartLogoList = heartLogoService.selectAll();

            // 成功返回数据
            return R.ok().put("heartLogoList", heartLogoList);
        }catch (Exception e){
            e.printStackTrace();
            // 失败返回错误信息
            return R.error();
        }
    }



    /**
     * 获取缅怀所有信息，功勋犬和普通都获取
     * @return
     */
    @GetMapping("heartList")
    public R heartList(){
        try {
            List<HeartListVo> heartListVos = heartInfoService.getHeartList();
            return R.ok().put("heartList", heartListVos);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
    }


    /**
     * 获取缅怀单个对象的详情信息,是获取详情图片的
     * @param param
     * @return
     */
    @PostMapping("heartDetailImage")
    public R heartDetailImage(@RequestBody Map<String, Long> param){
        Long petId = param.get("petId");
        try{

            List<HeartDetailImage> heartDetailImageList = heartDetailImageService.selectByPetId(petId);
            // 成功返回数据
            return R.ok().put("heartDetailImageList", heartDetailImageList);
        }catch (Exception e){
            e.printStackTrace();
            // 失败返回错误信息
            return R.error();
        }
    }
}
