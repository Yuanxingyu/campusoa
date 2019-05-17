package org.stary.campusoa.activiti.controller;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.stary.campusoa.activiti.service.ActTaskService;
import org.stary.campusoa.activiti.vo.ProcessVO;
import org.stary.campusoa.activiti.vo.TaskVO;
import org.stary.campusoa.common.utils.PageUtils;
import org.stary.campusoa.common.utils.ShiroUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**

 */
@RequestMapping("activiti/task")
@RestController
public class TaskController {
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    FormService formService;
    @Autowired
    TaskService taskService;
    @Autowired
    ActTaskService actTaskService;

    @Autowired
    HistoryService historyService;

    @GetMapping("goto")
    public ModelAndView gotoTask(){
        return new ModelAndView("act/task/gotoTask");
    }

    /**
     * 发起流程
     * @param offset
     * @param limit
     * @return
     */
    @GetMapping("/gotoList")
    PageUtils list(int offset, int limit) {
        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery()
                .listPage(offset, limit);
        int count = (int) repositoryService.createProcessDefinitionQuery().count();
        List<Object> list = new ArrayList<>();
        for(ProcessDefinition processDefinition: processDefinitions){
            list.add(new ProcessVO(processDefinition));
        }

        PageUtils pageUtils = new PageUtils(list, count);
        return pageUtils;
    }

    @GetMapping("/form/{procDefId}")
    public void startForm(@PathVariable("procDefId") String procDefId  ,HttpServletResponse response) throws IOException {
        String formKey = actTaskService.getFormKey(procDefId, null);
        response.sendRedirect(formKey);
    }

    @GetMapping("/form/{procDefId}/{taskId}")
    public void form(@PathVariable("procDefId") String procDefId,@PathVariable("taskId") String taskId ,HttpServletResponse response) throws IOException {
        // 获取流程XML上的表单KEY

        String formKey = actTaskService.getFormKey(procDefId, taskId);


        response.sendRedirect(formKey+"/"+taskId);
    }

    @GetMapping("/todo")
    ModelAndView todo(){
        return new ModelAndView("act/task/todoTask");
    }

    /**
     * 代办任务
     * @return
     */
    @GetMapping("/todoList")
    List<TaskVO> todoList(){
//        List<Task> tasks = taskService.createTaskQuery().taskAssignee("20151344051").list();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(String.valueOf(ShiroUtils.getUserId())).list();
//        List<Task> tasks = taskService.createTaskQuery().taskAssignee(String.valueOf("admin")).list();
        List<TaskVO> taskVOS =  new ArrayList<>();
        for(Task task : tasks){
            TaskVO taskVO = new TaskVO(task);
            taskVOS.add(taskVO);
        }
        return taskVOS;
    }

    /**
     * 已办事务
     * @return
     */
    @GetMapping("/completedList")
    List<TaskVO> completedList(){
        //获得当前用户处理的历史流程实例
        List<HistoricTaskInstance>  hisTaskList = historyService.createHistoricTaskInstanceQuery()
                .taskAssignee(String.valueOf(ShiroUtils.getUserId())).orderByTaskId().desc().list();
        List<TaskVO> taskVOS =  new ArrayList<>();
        for(HistoricTaskInstance historicTaskInstance : hisTaskList){
            TaskVO taskVO = new TaskVO(historicTaskInstance);
            taskVOS.add(taskVO);
        }
        return taskVOS;
    }


    /**
     * 读取带跟踪的图片
     */
    @RequestMapping(value = "/trace/photo/{procDefId}/{execId}")
    public void tracePhoto(@PathVariable("procDefId") String procDefId, @PathVariable("execId") String execId, HttpServletResponse response) throws Exception {
        InputStream imageStream = actTaskService.tracePhoto(procDefId, execId);

        // 输出资源内容到相应对象
        byte[] b = new byte[1024];
        int len;
        while ((len = imageStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
    }


}
