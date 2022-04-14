package CanhNguyen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {
   @GetMapping("/Dictionary")
    public String index(){
       return "index";
   }

   @PostMapping("/translate")
    public String translate(@RequestParam String txtSearch, Model model){
       Map<String, String> dictionary = new HashMap<>();
       dictionary.put("hello", "おはようございます。");
       dictionary.put("how", "どうですか");
       dictionary.put("book", "ほん");
       dictionary.put("computer", "コンピューター");

       String result = dictionary.get(txtSearch);
       if(result != null){
           model.addAttribute("txtSearch", txtSearch);
           model.addAttribute("result", result);
       } else {
           model.addAttribute("txtSearch", txtSearch);
           model.addAttribute("result", "not found");
       }
       return "result";
   }

}
