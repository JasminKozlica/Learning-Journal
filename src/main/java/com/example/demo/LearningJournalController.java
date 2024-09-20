import com.example.demo.Journal;
import com.example.demo.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LearningJournalController {
    public Journal personJson(){

    @Autowired
    private JournalService journalService;

    @GetMapping(value = "/journal")
    @ResponseBody
    public List<Journal> getJournal() {
        return journalService.getAllEntries();
    }

   // @GetMapping(value = "/journal/")
}
//Endpunkte für datenbank
