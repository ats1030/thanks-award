package com.creve_ip.award.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import com.creve_ip.award.Greeting;
import com.creve_ip.award.HelloMessage;
import com.creve_ip.award.entity.ThanksCategory;
import com.creve_ip.award.entity.ThanksPost;
import com.creve_ip.award.form.ThanksForm;

@Controller
public class ThanksController {

    @GetMapping("/award")
    public ModelAndView award(ModelAndView mav, ThanksForm thanksForm) {

        mav.addObject("categoryCheckBox", getCheckBoxCategory());
        mav.addObject("thanksForm", thanksForm);
        mav.setViewName("index");
        return mav;
    }

    @PostMapping("/award")
    public void saveObject(ThanksForm thanksForm) {
        
        ThanksPost thanksPost = new ThanksPost();
        ThanksCategory thanksCategory = new ThanksCategory();        
        // tmp
        System.out.println("1．送り主を明かすかどうか：" + thanksForm.isSenderVisibility());
        thanksPost.setSenderVisibility(thanksForm.isSenderVisibility());
        
        // tmp
        System.out.println("2．投票先：" + thanksForm.getRecipient());
        thanksPost.setRecipient(thanksForm.getRecipient());
        
        // tmp
        // TODO 処理がイケてない。。チェックされている場合は「1」そうでない場合は「0」を出力したい。
        System.out.println("3．カテゴリ選択：");
        for (String element : thanksForm.getCategory()) {
            System.out.println("  " + element);
            if(element.equals("colleague")) {
                thanksCategory.setColleague(true);
            } else {
                thanksCategory.setColleague(false);
            }
            if(element.equals("customer")) {
                thanksCategory.setCustomer(true);
            } else {
                thanksCategory.setCustomer(false);
            }
            if(element.equals("company")) {
                thanksCategory.setCompany(true);
            } else {
                thanksCategory.setCompany(false);
            }
        }
        
        // tmp
        System.out.println("4．エピソード：" + thanksForm.getEpisode());
        thanksPost.setEpisode(thanksForm.getEpisode());
    }

    // チェックボックス用
    private Map<String, String> getCheckBoxCategory() {
        Map<String, String> CheckBoxCategory = new LinkedHashMap<String, String>();
        CheckBoxCategory.put("colleague", "同僚への感謝");
        CheckBoxCategory.put("customer", "お客様に貢献できたことへの感謝");
        CheckBoxCategory.put("company", "会社への貢献");
        return CheckBoxCategory;
    }

    /**
     * WebSocket検証用
     * @param message
     * @return
     * @throws Exception
     */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting(HtmlUtils.htmlEscape(message.getName())
                + " : "
                + HtmlUtils.htmlEscape(message.getMessage()));
    }
}