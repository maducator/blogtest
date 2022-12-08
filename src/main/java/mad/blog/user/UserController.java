package mad.blog.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("")
    String index(Model model) {
        model.addAttribute("title", "User Index");
        model.addAttribute("list", list());
        return "user/index";
    }

    @GetMapping("list")
    @ResponseBody
    List<Map<String, Object>> list() {
        List<Map<String, Object>> list = new ArrayList<>();
        for( int i = 0; i < 10; ++i ) {
            var row = new HashMap<String, Object>();
            var num = i + 1;
            row.put("id", num);
            row.put("userId", "userId_" + num);
            row.put("password", UUID.randomUUID());
            row.put("updated", LocalDateTime.now());
            row.put("created", LocalDateTime.now());
            list.add(row);
        }
        return list;
    }

    @GetMapping("login")
    String login(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        return "user/login";
    }

    @PostMapping("processLogin")
    String processLogin(@RequestParam Map<String, Object> params, HttpSession session) {
        session.setAttribute("user", params);
        return "redirect:./login";
    }

    @GetMapping("logout")
    String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:./login";
    }

    @GetMapping("loginEcho")
    @ResponseBody
    Map<String, Object> loginEcho(@RequestParam Map<String, Object> params) {
        return params;
    }
}