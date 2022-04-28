package com.petcelsius.api.controller;


import com.petcelsius.api.domain.IndexBanner;
import com.petcelsius.api.domain.IndexNavigate;
import com.petcelsius.api.service.IndexBannerService;
import com.petcelsius.api.service.IndexFloorService;
import com.petcelsius.api.service.IndexNavigateService;
import com.petcelsius.api.utils.R;
import com.petcelsius.api.vo.IndexFloorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("indexApi")
public class IndexApiController {
    @Autowired
    private IndexBannerService indexBannerService;

    @Autowired
    private IndexNavigateService indexNavigateService;

    @Autowired
    private IndexFloorService indexFloorService;

    /**
     * 获取首页banner图，前5条
     * @return
     */

    @GetMapping("indexBanner")
    public R indexBanner(){
        try {
            // 获取索引前五的图片
            List<IndexBanner> bannerList =  indexBannerService.selectBannerToFive();
//            for (IndexBanner indexBanner : bannerList) {
//                System.out.println(indexBanner);
//            }
            return R.ok().put("indexBannerList", bannerList);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
    }



    /**
     * 获取首页导航栏navigate数据，前6条
     * @return
     */
    @GetMapping("indexNavigate")
    public R indexNavigate(){
        try {
            // 获取索引前6的信息
            List<IndexNavigate> navigateList =  indexNavigateService.selectNavigateToSix();
//            for (IndexNavigate indexNavigate : navigateList) {
//                System.out.println(indexNavigate);
//            }
            return R.ok().put("indexNavigateList", navigateList);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
    }


    @GetMapping("indexFloor")
    public R indexFloor(){
        try {
            List<IndexFloorVo> indexFloorVos = indexFloorService.selectFloorToFour();
//            for (IndexFloorVo indexFloorVo : indexFloorVos) {
//                System.out.println(indexFloorVo);
//            }
            return R.ok().put("indexFloorList", indexFloorVos);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
    }
}
