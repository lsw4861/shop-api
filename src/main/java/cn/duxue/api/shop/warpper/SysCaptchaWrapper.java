package cn.duxue.api.shop.warpper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的包装类
 * Created by liang on 2019/1/5.
 */
public class SysCaptchaWrapper extends BaseControllerWrapper {

    public SysCaptchaWrapper(Map<String, Object> single) {
        super(single);
    }

    public SysCaptchaWrapper(List<Map<String, Object>> multi) {
        super(multi);
    }

    public SysCaptchaWrapper(Page<Map<String, Object>> page) {
        super(page);
    }

    public SysCaptchaWrapper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }

    @Override
    protected void wrapTheMap(Map<String, Object> map) {

    }
}
