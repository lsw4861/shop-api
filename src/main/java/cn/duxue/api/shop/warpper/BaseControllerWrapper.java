package cn.duxue.api.shop.warpper;

/**
 * created by liang on 2019/7/4 .
 */

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Data
public abstract class BaseControllerWrapper {
    private Page<Map<String, Object>> page = null;
    private PageResult<Map<String, Object>> pageResult = null;
    private Map<String, Object> single = null;
    private List<Map<String, Object>> multi = null;

    public  BaseControllerWrapper(){}

    public BaseControllerWrapper(Map<String, Object> single) {
        this.single = single;
    }

    public BaseControllerWrapper(List<Map<String, Object>> multi) {
        this.multi = multi;
    }

    public BaseControllerWrapper(Page<Map<String, Object>> page) {
        if (page != null && page.getRecords() != null) {
            this.page = page;
            this.multi = page.getRecords();
        }

    }

    public BaseControllerWrapper(PageResult<Map<String, Object>> pageResult) {
        if (pageResult != null && pageResult.getRows() != null) {
            this.pageResult = pageResult;
            this.multi = pageResult.getRows();
        }

    }

    public <T> T wrap() {
        if (this.single != null) {
            this.wrapTheMap(this.single);
        }

        if (this.multi != null) {
            Iterator var1 = this.multi.iterator();

            while(var1.hasNext()) {
                Map<String, Object> map = (Map)var1.next();
                this.wrapTheMap(map);
            }
        }

        if (this.page != null) {
            return (T) this.page;
        } else if (this.pageResult != null) {
            return (T)this.pageResult;
        } else if (this.single != null) {
            return (T)this.single;
        } else {
            return this.multi != null ? (T)this.multi : null;
        }
    }

    protected abstract void wrapTheMap(Map<String, Object> map);
}

