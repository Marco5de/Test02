package game2048;
import java.util.Random;
import java.util.Scanner;


public class Field {
	private int[][] field;
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	/**
	 * Initializes Array: First Bracket: row , Second Bracket: column
	 */
	Field(){
		field = new int[4][4];	
	}
	

	
	
	
	void runConsole() {
		run();
		while(isAlive()) {
			int c = scan.nextInt();
			while(c!=1 && c!=2 && c!=3 && c!=4) {
				c = scan.nextInt();
			}
			switch (c) {
			case 1: 
				left();
				run();
				break;
			case 2:
				right();
				run();
				break;
			case 3:
				up();
				run();
				break;
			case 4:
				down();
				run();
			}
		}
			
	}
	
	void run() {
		if(isAlive()) {
			add();
			print();
		}
		else 
			throw new NullPointerException();
			
	}
	/**
	 * Moves the field to the left
	 */
	void left() {
		for(int k=0; k<field.length;k++) {
			for(int i=0;i<field.length;i++) {
				for(int j=0; j<field[i].length-1;j++) {
					if(field[i][j] == 0) {
						field[i][j] = field[i][j+1];
						field[i][j+1] = 0;
					}
				}
			}
		for(int z=0;z<field.length;z++) {
			for(int x=0; x < field.length-1; x++) {
				if(field[z][x]==field[z][x+1]) {
					field[z][x] *= 2;
					field[z][x+1] = 0;
				}
					
			}
		}
		}
	}
	
	/**
	 * Moves the field to the right
	 */
	void right() {
		for(int k=0; k<field.length;k++) {
			for(int i=0;i<field.length;i++) {
				for(int j=3; j>0;j--) {
					if(field[i][j] == 0) {
						field[i][j] = field[i][j-1];
						field[i][j-1] = 0;
					}
				}
		}
			for(int z=0;z<field.length;z++) {
				for(int x=3; x > 0 ; x--) {
					if(field[z][x]==field[z][x-1]) {
						field[z][x] *= 2;
						field[z][x-1] = 0;
					}
						
				}
			}
		}
	}
	
	/**
	 * Moves the field up
	 */
	void up() {
		for(int k=0; k<field.length;k++) {
			for(int i=0; i<field.length-1;i++) {
				for(int j=0; j<field.length;j++) {
					if(field[i][j] == 0) {
						field[i][j] = field[i+1][j];
						field[i+1][j] = 0;
					}
				}
			}
			for(int z=0; z<field.length-1;z++) {
				for(int x=0; x < field.length;x++) {
					if(field[z][x] == field[z+1][x]) {
						field[z][x] *= 2;
						field[z+1][x] = 0;
					}
				}
			}
		}
	}
	
	
	
	/**
	 * Moves the field down
	 */
	void down() {
		for(int k=0; k<field.length;k++) {
			for(int i=3; i > 0;i--) {
				for(int j=0; j<field.length;j++) {
					if(field[i][j] == 0) {
						field[i][j] = field[i-1][j];
						field[i-1][j] = 0;
					}
				}
			}
			for(int z=3; z > 0 ;z--) {
				for(int x=0; x < field.length;x++) {
					if(field[z][x] == field[z-1][x]) {
						field[z][x] *= 2;
						field[z-1][x] = 0;
					}
				}
			}
		}
	}
	
	/**
	 * Randomly adds new 2 to an open space on the field
	 */
	void add() {
		while(isAlive()) {
			int a = rand.nextInt(4);
			int b = rand.nextInt(4);
			if(field[a][b]==0) {
				field[a][b]=2;
				break;
			}
		}
	}
	
	
	
	/**
	 * 
	 * @return boolean wheter Game is still alive
	 */
	boolean isAlive() {
		for(int i=0; i<field.length ;i++) {
			for(int j=0; j<field[i].length; j++) {
				if(field[i][j]==0)
					return true;
			}
		}
		System.out.print("Game over!");
		return false;
	}

	
	void print() {
		System.out.println("----------------------------------------");
		for(int i=0;i<field.length;i++) {
			for(int j=0;j<field[i].length;j++) {
				System.out.printf("%-8s", field[i][j]);
			}
			System.out.println();
		}
	}

}