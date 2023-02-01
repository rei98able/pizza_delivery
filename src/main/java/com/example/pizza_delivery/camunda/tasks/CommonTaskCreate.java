package com.example.pizza_delivery.camunda.tasks;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Java delegate that is used on start every user task
 *
 * @inheritDoc FnpDelegate - abstract delegate with base functions to work with process
 * @implNote TaskListener - Camunda interface to work with tasks either on start or complete
 */
@Component("CommonTaskCreate")
public class CommonTaskCreate extends FnpDelegate implements TaskListener {
    private static final Logger logger = LoggerFactory.getLogger(CommonTaskCreate.class);
    @Override
    public void notify(DelegateTask delegateTask) {

        setProcessVariable(delegateTask, "status", delegateTask.getName());
        mapFromProcessToTask(delegateTask,
                "bpEntities", "bpEntities",
                "status", "status",
                "processBusinessKey", "processBusinessKey",
                "initiatorLogin", "initiatorLogin",
                "taskDefinition", "taskDefinition",
                "processDescr", "processDescr",
                "processType", "processType",
                "currentStep", "currentStep",
                "blockFB", "blockFB",
                "totalSteps", "totalSteps",
                "startDate", "startDate",
                "dueDate", "dueDate",
                "titleForm", "titleForm",
                "action", "action",
                "taskExtraName", "taskExtraName",
                "taskAssignee", "taskAssignee"
        );
        mapUsers(delegateTask);
    }


    /**
     * Maps all variables associated with user login into local variables
     *
     * @param delegateTask - current task
     */
    private void mapUsers(DelegateTask delegateTask) {
        mapFromProcessToTask(delegateTask,
                "dataExtractorLogin", "dataExtractorLogin",
                "orderExecutorApproverLogin", "orderExecutorApproverLogin",
                "equipmentOwnerLogin", "equipmentOwnerLogin",
                "expertVniaesLogin", "expertVniaesLogin",
                "orderOwnerLogin", "orderOwnerLogin",
                "orderExecutorLogin", "orderExecutorLogin",
                "workerGroupLogin", "workerGroupLogin",
                "responsibleLogin", "responsibleLogin"
        );
    }
}
