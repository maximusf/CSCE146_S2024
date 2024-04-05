import java.util.Random;

public class Tester {

	public static void main(String[] args) {
		Random r = new Random(100);
		GenMaxHeap<Integer> iHeap = new GenMaxHeap<Integer>(16);
		
		for(int i=0;i<16;i++)
		{
			int temp = r.nextInt(50);
			System.out.println(temp);
			iHeap.add(temp);
		}
		System.out.println();
		for(int i=0;i<16;i++)
		{
			System.out.println(iHeap.remove());
		}
	}
}
