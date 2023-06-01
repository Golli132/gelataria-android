package pt.ipbeja.estig.twdm.pdm1.myapplication;

import java.util.ArrayList;
import java.util.List;

public class GeladoMemory {
    private static List<GeladoItems> geladoList;

    private static List<GeladoItems> initializeList(){
        if(geladoList == null){
            geladoList = new ArrayList<>();
            geladoList.add(new GeladoItems(0, "Morango", "1,20€"));
            geladoList.add(new GeladoItems(0, "Baunilha", "1,20€"));
        }
        return geladoList;
    }

    public static List<GeladoItems> getAllGeladoItems(){ return initializeList(); }

}
