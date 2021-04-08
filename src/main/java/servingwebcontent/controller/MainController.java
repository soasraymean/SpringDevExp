package servingwebcontent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import servingwebcontent.db.Ticket;
import servingwebcontent.repos.TicketRepo;

import java.util.List;

@Controller
public class MainController {
    private final TicketRepo ticketRepo;

    public MainController(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

    @GetMapping("/main")
    public String main(Model model){

        String[] countries = {"MINSK", "BERLIN", "BOSTON", "KAIR", "MOSCOW","RIO-DE-JANEIRO"};
        model.addAttribute("countries", countries);

        String[] costs ={"ECONOMY CLASS $150","ECONOMY+ CLASS $200","BUSINESS CLASS $350","ALL INCLUSIVE $500"};
        model.addAttribute("costs", costs);


        Iterable<Ticket> tickets = ticketRepo.findAll();
        model.addAttribute("tickets", tickets);
        return "main";
    }

    @PostMapping("/main")
    public String addTicket(@RequestParam String otkyda, @RequestParam String kyda, @RequestParam String cost, Model model){

        String[] countries = {"MINSK", "BERLIN", "BOSTON", "KAIR", "MOSCOW","RIO-DE-JANEIRO"};
        model.addAttribute("countries", countries);

        String[] costs ={"ECONOMY CLASS $150","ECONOMY+ CLASS $200","BUSINESS CLASS $350","ALL INCLUSIVE $500"};
        model.addAttribute("costs", costs);

        if(otkyda.length()==0 || kyda.length()==0 || cost.length()==0 || otkyda.equals(kyda)){
            Iterable<Ticket> tickets = ticketRepo.findAll();
            model.addAttribute("tickets", tickets);
            return "main";
        }

        Ticket ticket = new Ticket(otkyda, kyda, cost);
        ticketRepo.save(ticket);

        Iterable<Ticket> tickets = ticketRepo.findAll();
        model.addAttribute("tickets", tickets);
        return "main";
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

}