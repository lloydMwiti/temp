import models.ListAll;

import java.util.List;

public interface connect {
    List<ListAll> getAll();
    void add(ListAll list);
}
