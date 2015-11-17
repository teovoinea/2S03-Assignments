/*
 * Name: Nick Morrison, Roberto Temelkovski, Teo Voinea
 * MacID: morrin2, temelkr, voineat
 * Student Number: 1426613, 1418731, 1409586
 * Description: File containing the ReadableCollection class
 */
import java.util.ArrayList;

public class ReadableCollection extends ArrayList<Readable>{
	double eTax = 1.00;

	public ReadableCollection(ArrayList<ArrayList<String>> stringList){
		super();

		for (int i =0; i < stringList.size(); i++){
			if (stringList.get(i).get(5).equals("Book")){
				add(new Book(Integer.parseInt(stringList.get(i).get(0)),
					     stringList.get(i).get(1) ,
					     stringList.get(i).get(2),
					     Integer.parseInt(stringList.get(i).get(3)),
					     Integer.parseInt(stringList.get(i).get(4))));
				eTax += 0.02;
			}else if (stringList.get(i).get(5).equals("eBook")){
				add(new eBook(Integer.parseInt(stringList.get(i).get(0)),
					     stringList.get(i).get(1) ,
					     stringList.get(i).get(2),
					     Integer.parseInt(stringList.get(i).get(3)),Integer.parseInt(stringList.get(i).get(4))));
			}
		}
	}


	public int getTotalPrice(){
		int totalPrice = 0;
		for (int i = 0; i < size(); i++){
			totalPrice += get(i).getPrice();
		}
		return totalPrice;
	}

	public Readable findBysNo(int sNo){
		Readable read = new Readable(-1,"", "", -1, -1);
		for (Readable r : this){
			if (sNo == r.sNo){
				return r;
			}
		}
		return read;
	}
}