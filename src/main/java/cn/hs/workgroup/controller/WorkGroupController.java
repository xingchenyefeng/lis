package cn.hs.workgroup.controller;

import cn.hs.publicclass.method.ApiResult;
import cn.hs.workgroup.pojo.WorkGroup;
import cn.hs.workgroup.service.WorkGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workGroupSettings")
public class WorkGroupController {
    @Autowired
    private WorkGroupService workGroupService;

    //查找工作组
    @RequestMapping(value = "/getworkGroups.json", method = RequestMethod.GET)
    public ApiResult getworkGroups(@RequestParam(required = false) String workGroup){
        try {
            return ApiResult.success(workGroupService.getworkGroups(workGroup));
        } catch (Exception e){
            return ApiResult.failed(e.getMessage());
        }
    }

    //删除选中工作组
    @RequestMapping(value = "/deleteWorkGroups.json", method = RequestMethod.POST)
    public ApiResult deleteWorkGroups(@RequestBody List<String> itemIdList){
        try {
            return ApiResult.success(workGroupService.deleteWorkGroups(itemIdList));
        } catch (Exception e){
            return ApiResult.failed(e.getMessage());
        }
    }

    //保存工作组
    @RequestMapping(value = "/saveWorkGroup.json", method = RequestMethod.POST)
    public ApiResult saveWorkGroup(@RequestBody WorkGroup workGroup){
        try {
            workGroupService.saveWorkGroup(workGroup);
            return ApiResult.success();
        } catch (Exception e){
            return ApiResult.failed(e.getMessage());
        }
    }

    //根据组类型查找组代码
    @RequestMapping(value = "/getGroupCode.json", method = RequestMethod.GET)
    public ApiResult getGroupCode(@RequestParam(required = true) String groupType){
        try {
            return ApiResult.success(workGroupService.getGroupCode(groupType));
        } catch (Exception e){
            return ApiResult.failed(e.getMessage());
        }
    }
}
