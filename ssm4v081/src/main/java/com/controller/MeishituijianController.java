package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.MeishituijianEntity;
import com.entity.view.MeishituijianView;

import com.service.MeishituijianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 美食推荐
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-30 17:39:23
 */
@RestController
@RequestMapping("/meishituijian")
public class MeishituijianController {
    @Autowired
    private MeishituijianService meishituijianService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MeishituijianEntity meishituijian, 
		HttpServletRequest request){

        EntityWrapper<MeishituijianEntity> ew = new EntityWrapper<MeishituijianEntity>();
		PageUtils page = meishituijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishituijian), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MeishituijianEntity meishituijian, HttpServletRequest request){
        EntityWrapper<MeishituijianEntity> ew = new EntityWrapper<MeishituijianEntity>();
		PageUtils page = meishituijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishituijian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MeishituijianEntity meishituijian){
       	EntityWrapper<MeishituijianEntity> ew = new EntityWrapper<MeishituijianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( meishituijian, "meishituijian")); 
        return R.ok().put("data", meishituijianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MeishituijianEntity meishituijian){
        EntityWrapper< MeishituijianEntity> ew = new EntityWrapper< MeishituijianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( meishituijian, "meishituijian")); 
		MeishituijianView meishituijianView =  meishituijianService.selectView(ew);
		return R.ok("查询美食推荐成功").put("data", meishituijianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MeishituijianEntity meishituijian = meishituijianService.selectById(id);
        return R.ok().put("data", meishituijian);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MeishituijianEntity meishituijian = meishituijianService.selectById(id);
        return R.ok().put("data", meishituijian);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        MeishituijianEntity meishituijian = meishituijianService.selectById(id);
        if(type.equals("1")) {
        	meishituijian.setThumbsupnum(meishituijian.getThumbsupnum()+1);
        } else {
        	meishituijian.setCrazilynum(meishituijian.getCrazilynum()+1);
        }
        meishituijianService.updateById(meishituijian);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MeishituijianEntity meishituijian, HttpServletRequest request){
    	meishituijian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meishituijian);

        meishituijianService.insert(meishituijian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MeishituijianEntity meishituijian, HttpServletRequest request){
    	meishituijian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meishituijian);

        meishituijianService.insert(meishituijian);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MeishituijianEntity meishituijian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(meishituijian);
        meishituijianService.updateById(meishituijian);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        meishituijianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<MeishituijianEntity> wrapper = new EntityWrapper<MeishituijianEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = meishituijianService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
