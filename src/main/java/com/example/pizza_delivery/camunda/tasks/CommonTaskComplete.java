package com.example.pizza_delivery.camunda.tasks;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

/**
 * Java delegate that is used on complete every user task
 *
 * @inheritDoc FnpDelegate - abstract delegate with base functions to work with process
 * @implNote TaskListener - Camunda interface to work with tasks either on start or complete
 */
@Component("CommonTaskComplete")
public class CommonTaskComplete extends FnpDelegate implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        mapFromTaskToProcess(delegateTask,
                "bpEntities", "bpEntities",
                "currentStep", "currentStep",
                "blockFB", "blockFB",
                "dueDate", "dueDate",
                "approveAction", "approveAction",
                "action", "action",
                "taskDefinition", "taskDefinition",
                "taskExtraName", "taskExtraName",
                "currentAssignee", delegateTask.getAssignee(),
                "taskAssignee", "taskAssignee"
        );

    }
}
