
public class TacoManagerSorter {

	private void sortTacos()
	//Bubble sort using linkedlist
	{
		boolean swapped = true;
		while (swapped)
		{
			swapped = false;
			for(int i=0; i<tacos.getSize();i++)
			{
				if(tacos.getAt(i+1) == null)
					break;
				if(tacos.getAt(i).getPrice() > tacos.getAt(i+1).getPrice())
				{
					//Swap
					Taco temp = tacos.getAt(i);
					tacos.setAt(i, tacos.getAt(i+1));
					tacos.setAt(i+1, temp);
					swapped = true;
				}
			}
		}
		
		
	}

}
