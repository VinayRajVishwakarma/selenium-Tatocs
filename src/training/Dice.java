package training;

public class Dice{
	int side=1;
	public Dice(int side ){
		this.side = side;
		}
	int rollTheDice(int side){
		int x= (int) ((Math.random()*(side-1)+1)+1);
	if(side==2){
		switch(x){
		case 1:System.out.println("Heads");
		case 2:System.out.println("Tails");
		}
	}
	else{	
		System.out.println(x);
	}
	return 0;
		}
	
	D2 dice = new D2();
	//dice.rollTheDice();
}





/*public class D6 extends Dice{
	public D6(){
		super(6);
		}
	rollTheDice(6);
}

public class D8 extends Dice{
	public D8(){
		super(8);
		}
	//rollTheDice(8);
}*/