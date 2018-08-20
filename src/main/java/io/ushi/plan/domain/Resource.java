package io.ushi.plan.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 资源
 */
@Entity
@Data
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Enumerated(EnumType.STRING)
    Type type;

    Long projectId;

    Long groupId;

    /**  */
    String name;

    String status;

    BigDecimal units;

    BigDecimal efficiency;

    Date start;

    Date end;

    /** 按时间计算成本，通常用于雇员 */
    BigDecimal costOfHour;

    /** 按使用计算成本，比如一张纸、一次打印、一台笔记本等 */
    BigDecimal costOfUse;

    BigDecimal totalUses;

    BigDecimal totalHours;

    BigDecimal totalCost;

    public enum Type {
        Staff, Group
    }
}
