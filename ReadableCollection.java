import java.util.ArrayList;

public class ReadableCollection extends ArrayList<Readable>{
	double eTax = 1.00;
	int totalPrice = 0;

	public ReadableCollection(ArrayList<ArrayList<String>> stringList){
		super();

		for (int i =0; i < stringList.size(); i++){
			if (stringList.get(i).get(5).equals("Book")){
				add(new Book(Integer.parseInt(stringList.get(i).get(0)), stringList.get(i).get(2) ,stringList.get(i).get(1), Integer.parseInt(stringList.get(i).get(3)),Integer.parseInt(stringList.get(i).get(4))));
				eTax += 0.02;
			}else if (stringList.get(i).get(5).equals("eBook")){
				add(new Book(Integer.parseInt(stringList.get(i).get(0)), stringList.get(i).get(2) ,stringList.get(i).get(1), Integer.parseInt(stringList.get(i).get(3)),Integer.parseInt(stringList.get(i).get(4))));
			}
		}
	}

	public float getTotalPrice(){
		for (int i = 0; i < size(); i++){
			totalPrice += get(i).getPrice();
		}
		return totalPrice;
	}

}