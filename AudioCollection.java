/*
* Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
* MacID: morrin2, temelkr, voineat
* Student Number: 1426613, 1418731, 1409586
* Description: File containing the AudioCollection Class
*/
import java.util.ArrayList;

public class AudioCollection extends ArrayList<Audio>{
	public static AudioCollection instance;
    double eTax = 1.00;

    public AudioCollection(ArrayList<ArrayList<String>> stringList){
		super();
		instance = this;
		for (int i =0; i < stringList.size(); i++){
	    	if (stringList.get(i).get(5).equals("CD")){
			add(new CD(Integer.parseInt(stringList.get(i).get(0)),
			     stringList.get(i).get(1) ,
			     stringList.get(i).get(2),
			     Integer.parseInt(stringList.get(i).get(3)),
			     Integer.parseInt(stringList.get(i).get(4))));
			eTax += 0.02;
	    	}else if (stringList.get(i).get(5).equals("MP3")){
			add(new MP3(Integer.parseInt(stringList.get(i).get(0)),
			     stringList.get(i).get(1) ,
			     stringList.get(i).get(2),
			     Integer.parseInt(stringList.get(i).get(3)),Integer.parseInt(stringList.get(i).get(4))));
	    	}
		}
    }

    public int getPrice(){
	int re = 0;
	for(int i = 0; i < size();i++){
	    re += get(i).getPrice();
	}
	return re;
    }

    public Audio findBysNo(int sNo){
        //TODO get rid of random audio and return null
        Audio audio = new Audio(-1,"", "", -1, -1);
        for (Audio a : this){
            if (sNo == a.sNo){
                return a;
            }
        }
        return null;
    }

}