import com.example.demo.Journal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LearningJournalController {
    public Journal personJson(){

@GetMapping("/journal")
        public String greeting(
                @RequestParam(name="n", required = false, defaultValue = "Welt") String

    )
    }
}
//Endpunkte für datenbank