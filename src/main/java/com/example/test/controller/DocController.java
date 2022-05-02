package com.example.test.controller;

import com.example.test.bean.InvideExpertBean;
import com.example.test.util.DocUtils;
import com.example.test.util.LogUtil;
import com.example.test.util.config.DishConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DocController {

    @Autowired
    DishConfig dishConfig;

    @RequestMapping("/doc/inviteExpert")
    public String inviteExpert(Model modelMap) {
        LogUtil.info("begin inviteExpert");
        modelMap.addAttribute("meetingDate","2022年*月*日");
        modelMap.addAttribute("meetingTime","上午9点");
        modelMap.addAttribute("meetingPlace","杭高院7号楼2楼215会议室");
        modelMap.addAttribute("senderName","李文庆");
        modelMap.addAttribute("senderPhone","15869047289");
        modelMap.addAttribute("sendDate","2022年*月*日");
        return "inviteExpert";
    }

    /**
     * 文件下载
     */
    @RequestMapping("/doc/download")
    public void downloadFile(String fileName, HttpServletResponse response) throws Exception {
        LogUtil.info("当前下载的文件的目录是：" + dishConfig.getFileDownloadDir());
        File file = new File(dishConfig.getFileDownloadDir(), fileName);
        FileInputStream is = new FileInputStream(file);
        // 2.1 获取响应流之前  一定要设置以附件形式下载
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        // 3.获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        FileCopyUtils.copy(is, os);
    }

    @RequestMapping("/doc/doInviteExpert")
    public String doInviteExpert(String expert1,
                                 String expert2,
                                 String expert3,
                                 String meetingDate,
                                 String meetingTime,
                                 String meetingPlace,
                                 String senderName,
                                 String senderPhone,
                                 String sendDate,
                                 Model modelMap,
                                 HttpServletResponse response) {
        modelMap.addAttribute("expert1",expert1);
        modelMap.addAttribute("expert2",expert2);
        modelMap.addAttribute("expert3",expert3);
        modelMap.addAttribute("meetingDate",meetingDate);
        modelMap.addAttribute("meetingTime",meetingTime);
        modelMap.addAttribute("meetingPlace",meetingPlace);
        modelMap.addAttribute("senderName",senderName);
        modelMap.addAttribute("senderPhone",senderPhone);
        modelMap.addAttribute("sendDate",sendDate);

        if(StringUtils.isEmpty(expert1)
                || StringUtils.isEmpty(expert2)
                || StringUtils.isEmpty(expert3)
                || StringUtils.isEmpty(meetingDate)
                || StringUtils.isEmpty(meetingTime)
                || StringUtils.isEmpty(meetingPlace)
                || StringUtils.isEmpty(senderName)
                || StringUtils.isEmpty(senderPhone)
                || StringUtils.isEmpty(sendDate)
        ){
            LogUtil.info("doInviteExpert, params empty, goto inviteExpert...");
            return "inviteExpert";
        }
//
        InvideExpertBean invideExpertBean = new InvideExpertBean();
        invideExpertBean.setExpert1(expert1);
        invideExpertBean.setExpert2(expert2);
        invideExpertBean.setExpert3(expert3);
        invideExpertBean.setMeetingDate(meetingDate);
        invideExpertBean.setMeetingTime(meetingTime);
        invideExpertBean.setMeetingPlace(meetingPlace);
        invideExpertBean.setSenderName(senderName);
        invideExpertBean.setSenderPhone(senderPhone);
        invideExpertBean.setSendDate(sendDate);

        // 通过doc模板生成word
        createDocByTemplate(invideExpertBean, dishConfig.getFileDownloadDir() + "专家邀请材料.docx");

        return "inviteExpertSuccess";
    }


    /**
     * eg.
     *             Map<String, Object> dataMap = new HashMap<>();
     *             dataMap.put("expert_1", "宋广华");
     *             dataMap.put("expert_2", "王信");
     *             dataMap.put("expert_3", "秦老师");
     *             dataMap.put("meeting_date", "2022年9月20日");
     *             dataMap.put("meeting_time", "上午9:00");
     *             dataMap.put("meeting_place", "国科大杭州高等研究院7号楼2楼215会议室");
     *             dataMap.put("sender_name", "李文庆");
     *             dataMap.put("sender_phone", "0571-12345678");
     *             dataMap.put("send_date", "2022年9月9日");
     *             DocUtils.saveWord("d:\\temp\\test.docx", dataMap);
     */
    public void createDocByTemplate(InvideExpertBean invideExpertBean, String newDocPath) {
        try {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("expert_1", invideExpertBean.getExpert1());
            dataMap.put("expert_2", invideExpertBean.getExpert2());
            dataMap.put("expert_3", invideExpertBean.getExpert3());
            dataMap.put("meeting_date", invideExpertBean.getMeetingDate());
            dataMap.put("meeting_time", invideExpertBean.getMeetingTime());
            dataMap.put("meeting_place", invideExpertBean.getMeetingPlace());
            dataMap.put("sender_name", invideExpertBean.getSenderName());
            dataMap.put("sender_phone", invideExpertBean.getSenderPhone());
            dataMap.put("send_date", invideExpertBean.getSendDate());
            DocUtils.saveWord(newDocPath, dataMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
