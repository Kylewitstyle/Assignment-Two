import java.util.ArrayList;
import java.util.Scanner;
class RedditTester {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

//initialization	
RedditData myReader= new RedditData();
RedditPost [] posts=myReader.getPostsReddit("Posts.txt","Num_Comments.txt","User.txt");
int counter=0;
int counterTwo=0;
ArrayList<String> NoDuplicateUsers= new ArrayList<String>();

//Checks Code
//System.out.println(counter);
//System.out.println(posts[counter].title);
//System.out.println(posts[counter].user);
//System.out.println(posts[counter].numComments +"\n");
//counter=counter+1;
//}


//Application selection process

int program=0;
int loopControl=0;
while (loopControl==0) {
	try {
		System.out.println("Please select 0-4 to select which Application you'd like to use.\n0)Exit the program. \n1) Print out every line along with its author and number of comments.\n2) Search every line from a particular user.\n3) Search how many times a word was used.\n4) Analyzes data of Trump's opponents in the last election.");
		String answer=input.next();
		program= Integer.parseInt(answer);
		if (program >=0 && program<=4) {
		loopControl=1;
}
	} catch (Exception ex) {
		System.out.println("Please try again");
	}
}

//System Exit

if (program==0) {
	System.exit(0);
}

//Print Every Line
	if (program == 1) {
		while (counter<(posts.length-1) ) {
			int postNumber=counter+1;
			System.out.println("Post Number: " + postNumber);
			System.out.println("Post: " + posts[counter].title);
			System.out.println("Useranme of poster: " + posts[counter].user);
			System.out.println("Number of Comments: " + posts[counter].numComments +"\n");
			counter=counter+1;
		}
	}

//User Search
if (program==2) {
counter=0;
counterTwo=0;
while (counter < (posts.length-1)) {
	boolean x=false;
		while (counterTwo < NoDuplicateUsers.size()) {	

			if (posts[counter].user.equals(NoDuplicateUsers.get(counterTwo))) {
				x=true;
			}

			else {
				x=false;
			}

			int Location=counterTwo;
			counterTwo=counterTwo+1;
		}

		if (x!=true) {
	NoDuplicateUsers.add(posts[counter].user);
	System.out.println(NoDuplicateUsers.get(counterTwo));

	}
counter=counter+1;
	}
counter=0;
int postNumber=1;
System.out.println("Hello User, you have been given a list of users. Please the input the username of one user to see all their posts");
String selectedUser=input.next();
System.out.println("Okay User, I will print all posts by " + selectedUser + " for you");

while (counter<(posts.length-1)) {
	if (selectedUser.matches(posts[counter].user)) {
		System.out.println(postNumber+ ": " +posts[counter].title);
		postNumber=postNumber+1;
	}
	counter=counter+1;
}
}

//Word Counter 

if (program == 3) {
	counter=0;
	int lineCounter=0;
	System.out.println("Please enter a word or phrase you wish to be counted");
	String word=input.next();
	word=word.toLowerCase();
	while (counter<(posts.length-1) ) {
		String checker = posts[counter].title;
		checker=checker.toLowerCase();
		if (checker.contains(word)) {
			lineCounter=lineCounter+1;

		}
		counter=counter+1;
	}
	System.out.println(word + " was entered " + lineCounter + " times");
}

//Data pertaining to Trump's competition in previous election
if (program == 4) {
	counter=0;
	String competitionOne="hillary";
	String competitionTwo="bernie";
	String competitionThree="cruz";
	String competitionFour="rubio";
	String competitionFive="kasich";
	int counterForOne=0;
	int counterForTwo=0;
	int counterForThree=0;
	int counterForFour=0;
	int counterForFive=0;
	while (counter<(posts.length-1) ) {
		String checker = posts[counter].title;
		checker=checker.toLowerCase();
		
		if (checker.contains(competitionOne)) {
counterForOne=counterForOne+1;
		}
		
		if (checker.contains(competitionTwo)) {
counterForTwo=counterForTwo+1;
		}
		
		if (checker.contains(competitionThree)) {
counterForThree=counterForThree+1;
		}
		
		if (checker.contains(competitionFour)) {
counterForFour=counterForFour+1;
		}
		
		if (checker.contains(competitionFive)) {
counterForFive=counterForFive+1;
		}
		
		counter=counter+1;
		}
	System.out.println("For the purpose of this analysis the following words correspond to mention of Trump's biggest competitors in the last election: \nHillary: Hillary Clinton\nBernie: Bernie Sander\nCruz:Ted Cruz\nRubio: Marco Rubio\nKasich: John Kasich");
	System.out.println("Hillary was said, " + counterForOne + " times");
	System.out.println("Bernie was said, " + counterForTwo + " times");
	System.out.println("Cruz was said, " + counterForThree + " times");
	System.out.println("Rubio was said, " + counterForFour + " times");
	System.out.println("Kasich was said, " + counterForFour + " times");
	System.out.println("From this we can see that the members of this Reddit thread find Trumps opponents of Hilary, Bernie, and Cruz to be more of a discussion against Trump.");
	System.out.println("It makes sense that Rubio and Kasich are discussed less because they were generally behind Cruz in the polls");
	System.out.println("It also makes sense that Hillary was said the most since, she was Trump's opponent in the general election");
}
}
}