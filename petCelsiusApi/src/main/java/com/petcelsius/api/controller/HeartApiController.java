package com.petcelsius.api.controller;


import com.petcelsius.api.service.HeartInfoService;
import com.petcelsius.api.utils.R;
import com.petcelsius.api.vo.HeartListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("heartApi")
public class HeartApiController {

    @Autowired
    private HeartInfoService heartInfoService;


    /**
     * 获取缅怀所有信息，军犬和普通都获取
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
}
