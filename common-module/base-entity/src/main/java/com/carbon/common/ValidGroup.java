package com.carbon.common;

import javax.validation.groups.Default;


public class ValidGroup {
    /**
     * 新增 创建
     */
    public interface Create extends Default {
    }

    /**
     * 删除
     */
    public interface Delete extends Default {
    }

    /**
     * 修改
     */
    public interface Update extends Default {
    }


    /**
     * 查询
     */
    public interface Query extends Default {
    }
}
