import java.io.*;
import java.util.Scanner;
public class RedditData {
Scanner input = new Scanner(System.in);


	int count1=-1;
	int count2=-1;
	int count3=-1;
	String fileWithWord;
	String searchWord;
	String input1;
	String input2;
	String input3;	
	
	RedditPost [] getPostsReddit(String posts,String numberOfComments, String authors)
	{
		RedditPost [] theDonaldPosts=new RedditPost[6466];
		
		try
		{
			FileReader myFileReaderOne=new FileReader(posts);
			BufferedReader myBufferReaderOne= new BufferedReader(myFileReaderOne);
			String lineOne=null;
			
			FileReader myFileReaderTwo=new FileReader(numberOfComments);
			BufferedReader myBufferReaderTwo= new BufferedReader(myFileReaderTwo);
			String lineTwo=null;
			
			FileReader myFileReaderThree=new FileReader(authors);
			BufferedReader myBufferReaderThree= new BufferedReader(myFileReaderThree);
			String lineThree=null;
			

			int postCounter=0;
			while (postCounter<6465)
			{
				lineOne=myBufferReaderOne.readLine();
				lineTwo=myBufferReaderTwo.readLine();
				lineThree=myBufferReaderThree.readLine();
				int comments = Integer.parseInt(lineTwo);
				
				theDonaldPosts[postCounter]=new RedditPost(lineOne);
				theDonaldPosts[postCounter].numComments=comments;
				theDonaldPosts[postCounter].user=lineThree;
				postCounter+=1;
			}
			
			return theDonaldPosts;
			
			
		}
		catch (Exception ex)
		{
			System.out.println("I don't think I was able to find your file");
		}
		return theDonaldPosts;	
	}
	
}		
		


