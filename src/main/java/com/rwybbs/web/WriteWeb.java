/**
 * chenPeng
 * com.rwybbs.web
 * AddNoteWeb.java
 * 创建人:chenpeng
 * 时间：2018年7月15日-下午1:39:08 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.web;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.rwybbs.bean.Write;
import com.rwybbs.core.IsNull;
import com.rwybbs.service.WriteService;

/**
 * 
 * AddNoteWeb
 * 创建人:chenPeng
 * 时间：2018年7月15日-下午1:39:08 
 * @version 1.0.0
 * 
 */
@Controller
public class WriteWeb {
	@Autowired
	private WriteService writeService;
	
	
	/**
	 * 写论坛的页面跳转
	 * 方法名：writeInit
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午1:50:30 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("bbs/write")
	public ModelAndView writeInit(){
		ModelAndView andView = new ModelAndView();
		andView.addObject("sname", writeService.getSname());
		andView.setViewName("bbs/bbswrite");
		return andView;
	}
	
	/**
	 * 富文本编辑的图片上传功能
	 * 方法名：upload
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午3:46:44 
	 * 手机:17673111810
	 * @param photo
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException Map<String,String>
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="bbs/write/upimg",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> upload(MultipartFile photo) throws IllegalStateException, IOException {
        Map<String, String> map = new HashMap<String, String>();
        try {
            //存储文件夹
            String holder = "fileUpload/";
            if (photo == null) {
                return null;
            }
            String orgginalFileName = photo.getOriginalFilename();
            //新文件名称
            String newFileName = UUID.randomUUID().toString() + orgginalFileName;
            //保存路径
            String serverPath = getRealPath() + holder;
 
            photo.transferTo(new File(serverPath, newFileName));
 
            //返回客户端的JSON
            map.put("success", "true");
            map.put("msg", "成功");
            //返回服务器地址
            map.put("file_path",getServerPath() + holder + newFileName);
        } catch (IOException e) {
            map.put("success", "false");
        }
        return map;
    }
	
	/**
	 * 写入论坛
	 * 方法名：writeDo
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午10:17:44 
	 * 手机:17673111810
	 * @param re
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/bbs/write/do",method=RequestMethod.POST)
	@ResponseBody
	public String writeDo(HttpServletRequest re){
		String title = re.getParameter("title");
		String temotion = re.getParameter("temotion");
		String sprofile = re.getParameter("sprofile");
		String text = re.getParameter("text");
		String username = re.getParameter("username");
		
		//判断为空
		IsNull isNull = new IsNull();
		
		if (isNull.isNull(title)||
				isNull.isNull(temotion)||
					isNull.isNull(sprofile)||
						isNull.isNull(text)||
							isNull.isNull(username)) {
			return "error";
		}
		
		//写入
		Write write = new Write();
		write.setSname(sprofile);
		write.setTcontents(text);
		write.setTemotion(temotion);
		write.setTtopic(title);
		write.setUsername(username);
		
		writeService.setWrite(write);
		writeService.upDateSTopicCount(sprofile);
		
		return "success";
	}
	
	/**
	 * 通过连接跳入指定的博客修改页面
	 * 方法名：upDateWriteInit
	 * 创建人：chenPeng
	 * 时间：2018年7月16日-下午3:54:45 
	 * 手机:17673111810
	 * @param no
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("bbs/upwrite/{no}")
	public ModelAndView upDateWriteInit(@PathVariable Integer no){
		ModelAndView andView = new ModelAndView();
		if (writeService.eqNoteUser(no)==null) {
			andView.setViewName("error404");
			return andView;
		}
		andView.addObject("note", writeService.upWriteInit(no));
		andView.setViewName("bbs/bbsupwrite");
		return andView;
	}
	
	
	@RequestMapping(value="/bbs/upwrite/do",method=RequestMethod.POST)
	@ResponseBody
	public String upWriteDo(HttpServletRequest re){
		String title = re.getParameter("title");
		String text = re.getParameter("text");
		String tid = re.getParameter("tid");
		
		//判断为空
		IsNull isNull = new IsNull();
		
		if (isNull.isNull(title)||
				isNull.isNull(text)||
					isNull.isNull(tid)) {
			return "error";
		}
		
		//写入
		writeService.upWriteDo(title, text, tid);
		
		return "success";
	}
	
    /**
     * 服务器地址
     * @return
     */
    public String getServerPath() {
        HttpServletRequest request = getRequest();
        return request.getScheme() 
        		+ "://" + request.getServerName() 
        		+ ":" + request.getServerPort() 
        		+ "/" + request.getContextPath() 
        		+ "/";
 
    }
    /**
     * 获取项目根目录
     * @return
     */
    public String getRealPath() {
        HttpServletRequest request = getRequest();
        return request.getServletContext().getRealPath("/");
    }
    /**
     * 
     * @return
     */
    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
    }
   
    
    
    
}
