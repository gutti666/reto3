
package C3Reto3.Reto3v2.servicios;

import C3Reto3.Reto3v2.modelo.Games;
import C3Reto3.Reto3v2.repositorio.RepositorioGames;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosGames {
    @Autowired
    private RepositorioGames metodosCrud;
    
    public List<Games> getAll(){
         return metodosCrud.getAll();
    }
    
    public Optional<Games> getGames(int gamesId){
        return metodosCrud.getGames(gamesId);
    }
        
    public Games save(Games games){
        if(games.getId()==null){
            return metodosCrud.save(games);
        }else{
            Optional<Games> e=metodosCrud.getGames(games.getId());
            if(e.isEmpty()){
                return metodosCrud.save(games);
            }else{
                return games;
            }
        }
    }

    public Games update(Games games){
        if(games.getId()!=null){
            Optional<Games> e=metodosCrud.getGames(games.getId());
            if(!e.isEmpty()){
                if(games.getName()!=null){
                    e.get().setName(games.getName());
                }
                if(games.getDeveloper()!=null){
                    e.get().setDeveloper(games.getDeveloper());
                }
                if(games.getYear()!=null){
                    e.get().setYear(games.getYear());
                }
                if(games.getDescription()!=null){
                    e.get().setDescription(games.getDescription());
                }
                if(games.getCategory()!=null){
                    e.get().setCategory(games.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return games;
            }
        }else{
            return games;
        }
    }


    public boolean deleteGames(int gamesId) {
        Boolean aBoolean = getGames(gamesId).map(games -> {
            metodosCrud.delete(games);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}