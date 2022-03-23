import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WhackAMole {
	int score;
	int molesLeft;
	int attemptsLeft;
	char[][] moleGrid;
	
	public WhackAMole(int numAttempts, int gridDimension) {
		score = 0;
		molesLeft = 0;
		attemptsLeft = numAttempts;
		moleGrid = new char[gridDimension][gridDimension];
		
		for (char[] arr : moleGrid) {
			Arrays.fill(arr, '*');	
		}	
	}
	
	public boolean place(int x, int y) {
		if(moleGrid[x][y] == 'M') {
			return false;
		}
		moleGrid[x][y] = 'M';
		molesLeft += 1;
		return true;
	}
	


	void whack(int x, int y) {
		if(moleGrid[x][y] == 'M') {
			moleGrid[x][y] = 'W';
			score += 1;
			molesLeft--;
		}
		attemptsLeft--;	
	}


	void printGridToUser() {
		for(char[] arr : moleGrid) {
			for(char a : arr) {
				if(a == 'W') {
					System.out.print("W");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	
	void printGrid() {
		for(char[] arr : moleGrid) {
			for(char a : arr) {
				if(a == 'M') {
					System.out.print("M");
				}else if(a == 'W') {
					System.out.print("W");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	
	
		
	public static void main(String[] args) {

		Random random = new Random();
		WhackAMole whackStart = new WhackAMole(50,10);
		for(int i = 0; i < 10; i++) {
			whackStart.place(random.nextInt(10), random.nextInt(10));
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome");

	
		while (whackStart.attemptsLeft > 0 && whackStart.molesLeft > 0) {
			System.out.println("SCORE: " + whackStart.score + "\nATTEMPTSLEFT " + whackStart.attemptsLeft + "\nMOLESLEFT " + whackStart.molesLeft + "\nEnter '-1 -1' For Giving Up ");
			whackStart.printGridToUser();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(x == -1 && y == -1) {
				break;
			}
			
			whackStart.whack(x,y);		
		}
		whackStart.printGrid();		
	}
}
