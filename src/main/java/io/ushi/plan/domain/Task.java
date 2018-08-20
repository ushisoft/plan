package io.ushi.plan.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 任务
 */
@Entity
@Data
public class Task {

    @Enumerated(EnumType.STRING)
    Type type;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

//    Long groupId;

    /**  */
    String title;

//    String HierarchicalTitle;

    String status;

//    List<String> attachments;
//
//    String notes;
//
//    String duration;
//
//    /**  */
//    Long effort;
//
//    Long effortDone;
//
//    Long remainingEffort;
//
//    List<String> prerequisites;
//
//    List<String> dependents;
//
//    Date start;
//
//    Date end;
//
//    Integer priority;
//
//    BigDecimal completed;
//
//    String assigned;
//
//    Date startAfter;
//
//    Date startBefore;
//
//    Date endAfter;
//
//    Date endBefore;
//
//    BigDecimal taskCost;
//
//    BigDecimal resourcesCost;
//
//    BigDecimal totalTaskCost;
//
//    Date plannedStart;
//
//    Long startVariance;
//
//    Date plannedEnd;
//
//    Long endVariance;
//
//    String freeSlack;
//
//    String totalSlack;
//
//    Long minEffortEstimate;
//
//    Long expectedEffortEstimate;
//
//    Long maxEffortEstimate;
//
//    Long expected;
//
//    BigDecimal plannedValue;
//
//    BigDecimal earnedValue;
//
//    BigDecimal actualCost;
//
//    BigDecimal costVariance;
//
//    Long scheduleVariance;
//
//    String estimateAtCompletion;
//
//    BigDecimal budgetedAtCompletion;
//
//    Long varianceAtCompletion;
//
//    String costPerformanceIndex;
//
//    String schedulePerformanceIndex;
//
//    BigDecimal costVariancePercent;
//
//    BigDecimal scheduleVariancePercent;
//
//    String toCompletePerformanceIndex;

    public enum Type {
        Task, Milestone, Group
    }
}
