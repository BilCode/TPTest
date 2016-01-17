package bil.learn.tutpoint;

import java.util.Arrays;

public class Sorting {

	private int Numbers[];

	public int[] getNumbers() {
		return Numbers;
	}

	public void setNumbers(int numbers[]) {
		Numbers = numbers;
	}

	/**Insertion Sort**/
	int[] Insertion()
	{
		for(int k=1;k<Numbers.length;k++){
			for(int i=k;(i>0 && Numbers[i]<Numbers[i-1]);i--)
			{
				int temp = Numbers[i];
				Numbers[i]=Numbers[i-1];
				Numbers[i-1]=temp;
			}
		}
		return Numbers;
	}

	/**Selection Sort**/
	int[] Selection()
	{
		for(int i=0;i<Numbers.length;i++)
		{
			int small = Numbers[i] ;
			int samllposition = i;
			for(int k=i+1;k<Numbers.length;k++)
			{
				if(small>Numbers[k])
				{
					small=Numbers[k];
					samllposition=k;
				}
				//System.out.println(small);
			}
			Numbers[samllposition]=Numbers[i];
			Numbers[i]=small;
		}
		return Numbers;
	}

	/**Merge Sort**/
	int[] MergeSort(int ListToSort[])
	{
		if (ListToSort.length<2)
		{
			return ListToSort;
		}else
		{
			int lenNumbers = ListToSort.length;
			int midLength = lenNumbers/2;
			System.out.println("Length "+midLength+"");
			int[] leftList = new int[midLength];
			int[] rightList = new int[lenNumbers-midLength];

			System.arraycopy(ListToSort, 0, leftList, 0, midLength);
			System.arraycopy(ListToSort, midLength, rightList, 0, (lenNumbers-midLength));
			System.out.println("Left"+ Arrays.toString(leftList));

			leftList= MergeSort(leftList);
			//System.out.println( "After"+Arrays.toString(leftList));
			System.out.println( "Right"+Arrays.toString(rightList));
			rightList =MergeSort(rightList);
			//System.out.println( "After"+Arrays.toString(rightList));
			return merge(leftList, rightList);
		} 
	}

	private int[] merge(int mergelist1[], int mergelist2[])
	{
		int k=0,j=0,i=0;
		int sortedmergeList[] =new int[mergelist1.length+mergelist2.length];
		while (k<mergelist1.length&&j<mergelist2.length)
		{
			if(mergelist1[k]<mergelist2[j])
			{
				sortedmergeList[i]=mergelist1[k];
				k++;
			}else
			{
				sortedmergeList[i]=mergelist2[j];
				j++;
			}
			i++;
		}
		if(k<mergelist1.length)
		{
			while (k<mergelist1.length){
				//System.out.println("k "+k+" mergelist1 "+mergelist1.length);
				sortedmergeList[i]=mergelist1[k];
				k++;i++;
			}
		}else if(j<mergelist2.length)
		{
			while (j<mergelist2.length){
				//System.out.println("j "+j+" mergelist1 "+mergelist2.length);
				sortedmergeList[i]=mergelist2[j];
				j++;i++;
			}
		}
		return sortedmergeList;
	}

	//**Heap Sort**/
	private int[] maxheap(int[] a,int rootindex)
	{
		return a;
	}
}
