package hust.cs.server.controller;


import hust.cs.server.pojo.Joblevel;
import hust.cs.server.pojo.RespBean;
import hust.cs.server.service.IJoblevelService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qpphust
 * @since 2022-03-26
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

    @Autowired
    private IJoblevelService joblevelService;

    @ApiOperation(value = "获取所有职称")
    @GetMapping
    public List<Joblevel> getAllJobLevels(){
        return joblevelService.list();
    }

    @ApiOperation(value = "添加职称")
    @PostMapping
    public RespBean addJobLevel(@RequestBody Joblevel joblevel){
        joblevel.setCreateDate(LocalDateTime.now());
        if(joblevelService.save(joblevel)){
            return RespBean.success("添加职称成功");
        }
        return RespBean.error("添加职称失败");
    }

    @ApiOperation(value = "更新职称")
    @PutMapping
    public RespBean updateJobLevel(@RequestBody Joblevel joblevel){
        joblevel.setCreateDate(LocalDateTime.now());
        if(joblevelService.updateById(joblevel)){
            return RespBean.success("更新职称成功");
        }
        return RespBean.error("更新职称失败");
    }

    @ApiOperation(value = "删除职称")
    @DeleteMapping("/{id}")
    public RespBean deleteJobLevel(@PathVariable Integer id){
        if(joblevelService.removeById(id)){
            return RespBean.success("删除职称成功");
        }
        return RespBean.error("删除职称失败");
    }

    @ApiOperation(value = "批量删除职称")
    @DeleteMapping
    public RespBean deleteJobLevels(Integer[] ids){
        if(joblevelService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("批量删除职称成功");
        }
        return RespBean.error("批量删除职称失败");
    }
}
