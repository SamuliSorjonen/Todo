package fi.academy.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/todot")
public class TodoController {
private TodonDAO dao;

@Autowired
    public TodoController(TodonDAO dao) {
        this.dao = dao;
    }

    @GetMapping("")
    public List<Tehtava> listaaKaikki() {
    List<Tehtava> kaikki = dao.haeKaikki();
    System.out.printf("Haetaa listaa, alkioita: %d kpl\n", kaikki.size());
    return kaikki;
    }

    @PostMapping("")
    public void lisaa(@RequestBody Tehtava uusi) {
        System.out.println("****** Luodaan uutta: " + uusi);
        dao.lisaa(uusi);
        System.out.println("****** Luotu uusi: " + uusi);
    }

    @DeleteMapping("/{id}")
    public void poista(@PathVariable int id) {
        dao.poista(id);
    }
}
