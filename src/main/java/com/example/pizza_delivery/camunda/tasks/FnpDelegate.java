package com.example.pizza_delivery.camunda.tasks;


import com.example.pizza_delivery.camunda.interfaces.MappingInterface;
import com.example.pizza_delivery.camunda.interfaces.VariableInterface;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.springframework.util.Assert;

/**
 * Abstract delegate that describes all the logic with process and task variables.
 * This class contains several functions which can map process variables into local variable vise versa
 * and also provides getters and setters for all types of variables
 */

@SuppressWarnings("Duplicates")
public abstract class FnpDelegate {

    /**
     * Maps a pair of strings as process variable -> local variable
     *
     * @param task               - current task
     * @param processAndTaskVars - process and task variables
     */
    protected void mapFromProcessToTask(DelegateTask task, String... processAndTaskVars) {
        map(task, (taskVars, processVars) -> {
            Assert.isTrue(processAndTaskVars.length % 2 == 0, "should be even");
            for (int i = 0; i < processAndTaskVars.length; i += 2) {
                String processVar = processAndTaskVars[i];
                String taskVar = processAndTaskVars[i + 1];
                taskVars.set(taskVar, processVars.get(processVar));
            }
        });
    }

    /**
     * Maps a pair of strings as local variable -> process variable
     *
     * @param task               - current task
     * @param taskAndProcessVars - task and process variables
     */
    protected void mapFromTaskToProcess(DelegateTask task, String... taskAndProcessVars) {
        map(task, (taskVars, processVars) -> {
            Assert.isTrue(taskAndProcessVars.length % 2 == 0, "should by even");
            for (int i = 0; i < taskAndProcessVars.length; i += 2) {
                String taskVar = taskAndProcessVars[i];
                String processVar = taskAndProcessVars[i + 1];
                processVars.set(processVar, taskVars.get(taskVar));
            }
        });
    }

    protected void map(DelegateTask task, MappingInterface mapping) {
        mapping.map(new TaskVariables(task), new ProcessVariables(task));
    }

    protected <T> T getTaskVariable(DelegateTask task, String variableName) {
        //noinspection unchecked
        return (T) task.getVariableLocal(variableName);
    }

    protected <T> void setTaskVariable(DelegateTask task, String variableName, T value) {
        task.setVariableLocal(variableName, value);
    }

    protected <T> T getProcessVariable(DelegateTask task, String variableName) {
        //noinspection unchecked
        return (T) task.getExecution().getProcessInstance().getVariableLocal(variableName);
    }

    protected <T> void setProcessVariable(DelegateTask task, String variableName, T value) {
        task.getExecution().getProcessInstance().setVariableLocal(variableName, value);
    }


    protected static class TaskVariables implements VariableInterface {
        private final DelegateTask task;

        public TaskVariables(DelegateTask task) {
            this.task = task;
        }

        @Override
        public Object get(String name) {
            return task.getVariableLocal(name);
        }

        @Override
        public void set(String name, Object value) {
            task.setVariableLocal(name, value);
        }
    }

    protected static class ProcessVariables implements VariableInterface {
        private final DelegateExecution process;

        public ProcessVariables(DelegateTask task) {
            this.process = task.getExecution().getProcessInstance();
        }

        @Override
        public Object get(String name) {
            return process.getVariableLocal(name);
        }

        @Override
        public void set(String name, Object value) {
            process.setVariableLocal(name, value);
        }
    }
}