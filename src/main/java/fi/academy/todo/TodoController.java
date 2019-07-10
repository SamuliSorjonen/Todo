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
    public ResponseEntity<?> lisaa(@RequestBody Tehtava uusi) {
        System.out.println("****** Luodaan uutta: " + uusi);
        int id = dao.lisaa(uusi);
        System.out.println("****** Luotu uusi: " + uusi);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).body(uusi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> poista(@PathVariable int id) {
        Tehtava poistettu = dao.poista(id);
        if (poistettu.getId() != 0)
            return ResponseEntity.ok(poistettu.getId());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Poistaminen ei onnistunut");
    }
}
