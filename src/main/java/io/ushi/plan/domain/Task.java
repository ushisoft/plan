package io.ushi.plan.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 任务
 */
@Entity
public class Task {

    String type;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

//    Long parentId;

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

//    public enum Type {
//        Task, Milestone, Group
//    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
