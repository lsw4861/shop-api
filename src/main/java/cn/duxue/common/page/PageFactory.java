/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.duxue.common.page;

import cn.duxue.common.utils.PageUtils;
import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.Map;

/**
 * Table默认的分页参数创建
 * Created by liang on 2019/1/5.
 */
@Data
public  class PageFactory {

    /**
     * 当前页码
     */
    private int currPage = 1;
    /**
     * 每页条数
     */
    private int limit = 10;

    /**
     * 获取layui table的分页参数
     *
     * @author fengshuonan
     * @Date 2019/1/25 22:13
     */
    public  Page defaultPage(Map<String, Object> params) {

        //分页参数
        if(params.get("page") != null){
            currPage = Convert.toInt(params.get("page"));
        }
        if(params.get("limit") != null){
            limit = Convert.toInt(params.get("limit"));
        }

//        this.put("offset", (currPage - 1) * limit);
//        this.put("page", currPage);
//        this.put("limit", limit);

        return new Page<>(currPage, limit);
    }

    /**
     * 创建layui能识别的分页响应参数
     *
     * @author fengshuonan
     * @Date 2019/1/25 22:14
     */
    public static PageUtils createPageInfo(IPage page) {
        PageUtils pageUtils = new PageUtils(page.getRecords(), Convert.toInt(page.getTotal()), Convert.toInt(page.getSize()), Convert.toInt(page.getCurrent()));
        return pageUtils;
    }
}
