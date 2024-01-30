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
import com.creve_ip.award.form.ThanksForm;

@Controller
public class ThanksController {

    @GetMapping("/award")
    public ModelAndView award(ModelAndView mav) {

        mav.addObject("categoryCheckBox", getCheckBoxCategory());
        mav.setViewName("index");
        return mav;
    }

    @PostMapping("/award")
    public void saveObject(ThanksForm thanksForm) {
        for(String element : thanksForm.getCategory()) {
            System.out.println("選択された要素: " + element);
        }
    }
    
    // チェックボックス用
    private Map<String, String> getCheckBoxCategory(){
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