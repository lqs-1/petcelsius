package com.petcelsius.api.utils.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petcelsius.api.constant.Constant;

import java.util.Map;


public class QueryPage<T> {

    /**
     * 0是升序1是降序
     * @param param
     * @return
     */
    public IPage<T> getPage(Map<String, Object> param){
        return getPage(param, false);
    }

    public IPage<T> getPage(Map<String, Object> params, Boolean isDesc) {
        //分页参数
        long curPage = 1;
        long limit = 10;

        if(params.get(Constant.PAGE) != null){
            curPage = Long.parseLong((String)params.get(Constant.PAGE));
        }

        if(params.get(Constant.LIMIT) != null){
            limit = Long.parseLong((String)params.get(Constant.LIMIT));
        }
        //分页对象
        Page<T> page = new Page<>(curPage, limit);

        /**
         * 排序操作
         */
        if(isDesc){
            if(params.get(Constant.ORDERFILED) != null){
                // 0是升序1是降序
                if(params.get(Constant.ORDERTYPE) != null){
                    if(Long.parseLong((String)params.get(Constant.ORDERTYPE)) == 0){
                        page.addOrder(OrderItem.asc((String) params.get(Constant.ORDERFILED)));
                    }else if (Long.parseLong((String)params.get(Constant.ORDERTYPE)) == 1){
                        page.addOrder(OrderItem.desc((String) params.get(Constant.ORDERFILED)));
                    }
                }
                return page;
            }
        }
        return page;
    }
}
