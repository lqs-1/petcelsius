package com.petcelsius.api.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : mybatisplus分页插件
 */
@Configuration
public class MybatisPlusInterceptor {

    /**
     * 配置分页插件（mybatisPlus）
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置单页最大条数
        paginationInterceptor.setLimit(1000L);
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        paginationInterceptor.setOverflow(true);
        return paginationInterceptor;
    }
}
