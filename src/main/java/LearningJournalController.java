import com.example.demo.Journal;
import com.example.demo.JournalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LearningJournalController {
    public Journal personJson(){


        @GetMapping (value ="/journal")
                @ResponseBody
        public List<Journal>getJournal(){
            return JournalService.getAll();
        }
        @GetMapping(value = "/journal/")
    }
}
