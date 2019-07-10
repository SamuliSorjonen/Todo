package fi.academy.todo;

import java.util.List;
import java.util.Optional;

public interface TodonDAO {

    List<Tehtava> haeKaikki();
    int lisaa(Tehtava tehtava);
    Tehtava poista(int id);
}

