
package C3Reto3.Reto3v2.repositorio;

import C3Reto3.Reto3v2.interfac.InterfaceGames;
import C3Reto3.Reto3v2.modelo.Games;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioGames {
    @Autowired
    private InterfaceGames crud;
    
    public List<Games> getAll(){
        return (List<Games>) crud.findAll();
    }
    public Optional <Games> getGames(int id){
        return crud.findById(id);
    }
    
    public Games save(Games games){
        return crud.save(games);
    }
    
    public void delete(Games games){
        crud.delete(games);
    }
}
