package com.carbon.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class BaseEntity {
    /** 数据id，系统字段 */
    @NotBlank(message = "主键必须赋值", groups = {ValidGroup.Update.class})
    @TableId(value="id",type= IdType.ASSIGN_ID)
    //@JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /** 数据创建用户id，系统字段，禁止挪作业务用途 */
    @JsonIgnore
    private Long createId;
    /** 数据修改用户id，系统字段，禁止挪作业务用途 */
    @JsonIgnore
    private Long updateId;
    /** 数据状态，1：可用，其他值(unix_timestamp)：不可用，系统字段，禁止挪作业务用途 */
    private String state;
    /** 备注，系统字段，禁止挪作业务用途 */
    private String remark;
    /** 排序，系统字段，禁止挪作业务用途 */
    private Integer sort;
    /** 创建时间 */
    private LocalDateTime createTime;
    /** 更新时间 */
    private LocalDateTime updateTime;
    /**
     * 创建初始化
     *
     * @author: yusheng
     * @date: 2023/3/24 10:04
     * @param: [createId]
     * @since: 1.0
     * @return: void
     **/
    public void insertInit(Long createId) {
        this.createId = createId;
        this.updateId = createId;
        this.state = "1";
        this.sort = 0;
    }

    /**
     * 更新初始化
     *
     * @author: yusheng
     * @date: 2023/3/24 10:04
     * @param: [updateId]
     * @since: 1.0
     * @return: void
     **/
    public void updateInit(Long updateId) {
        this.updateId = updateId;
        this.updateTime = null;
        this.createTime = null;
    }
}


