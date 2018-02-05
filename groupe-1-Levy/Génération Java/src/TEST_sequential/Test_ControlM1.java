package TEST_sequential;
import java.util.Random;
import Util.Utilities;
import eventb_prelude.*;

public class Test_ControlM1{

	public static Integer random_Urgence;
	public static BSet<Integer> random_Employes;
	public static BSet<Integer> random_AUneCarte;
	public static BSet<Integer> random_AUnCode;
	public static BSet<Integer> random_Visiteurs;
	public static BSet<Integer> random_Hotesses;
	public static Integer random_Maintenance;
	public static Integer random_Normal;

	static Random rnd = new Random();
	static Integer max_size_BSet = 10;
	Integer min_integer = Utilities.min_integer;
	Integer max_integer = Utilities.max_integer;

	public Integer GenerateRandomInteger(){
		BSet<Integer> S =  new BSet<Integer>(
				new Enumerated(min_integer, max_integer)
				);
		/** User defined code that reflects axioms and theorems: Begin **/

		/** User defined code that reflects axioms and theorems: End **/

		return (Integer) S.toArray()[rnd.nextInt(S.size())];
	}

	public boolean GenerateRandomBoolean(){
		boolean res = (Boolean) BOOL.instance.toArray()[rnd.nextInt(2)];

		/** User defined code that reflects axioms and theorems: Begin **/

		/** User defined code that reflects axioms and theorems: End **/

		return res;
	}


	public BSet<Integer> GenerateRandomIntegerBSet(){
		int size = rnd.nextInt(max_size_BSet);
		BSet<Integer> S = new BSet<Integer>();
		while (S.size() != size){
			S.add(GenerateRandomInteger());
		}

		/** User defined code that reflects axioms and theorems: Begin **/

		/** User defined code that reflects axioms and theorems: End **/

		return S;
	}

	public BSet<Boolean> GenerateRandomBooleanBSet(){
		int size = rnd.nextInt(2);
		BSet<Boolean> res = new BSet<Boolean>();
		if (size == 0){
			res = new BSet<Boolean>(GenerateRandomBoolean());
		}else{
			res = new BSet<Boolean>(true,false);
		}

		/** User defined code that reflects axioms and theorems: Begin **/

		/** User defined code that reflects axioms and theorems: End **/

		return res;
	}

	public BRelation<Integer,Integer> GenerateRandomBRelation(){
		BRelation<Integer,Integer> res = new BRelation<Integer,Integer>();
		int size = rnd.nextInt(max_size_BSet);
		while (res.size() != size){
			res.add(
					new Pair<Integer, Integer>(GenerateRandomInteger(), GenerateRandomInteger()));
		}
		/** User defined code that reflects axioms and theorems: Begin **/

		/** User defined code that reflects axioms and theorems: End **/

		return res;
	}

	public static void main(String[] args){
		Test_ControlM1 test = new Test_ControlM1();

		/** User defined code that reflects axioms and theorems: Begin **/
		test.random_Urgence = test.GenerateRandomInteger();
		test.random_Employes = test.GenerateRandomIntegerBSet();
		test.random_AUneCarte = test.GenerateRandomIntegerBSet();
		test.random_AUnCode = test.GenerateRandomIntegerBSet();
		test.random_Visiteurs = test.GenerateRandomIntegerBSet();
		test.random_Hotesses = test.GenerateRandomIntegerBSet();
		test.random_Maintenance = test.GenerateRandomInteger();
		test.random_Normal = test.GenerateRandomInteger();
		/** User defined code that reflects axioms and theorems: End **/

		ControlM1 machine = new ControlM1();
		int n = 6; //the number of events in the machine
		while (true){
			switch (rnd.nextInt(n)){
			case 0: if (machine.evt_Observation1.guard_Observation1())
				machine.evt_Observation1.run_Observation1(); break;
			case 1: if (machine.evt_Observation2.guard_Observation2())
				machine.evt_Observation2.run_Observation2(); break;
			case 2: if (machine.evt_Observation3.guard_Observation3())
				machine.evt_Observation3.run_Observation3(); break;
			case 3: if (machine.evt_Observation4.guard_Observation4())
				machine.evt_Observation4.run_Observation4(); break;
			case 4: if (machine.evt_Observation5.guard_Observation5())
				machine.evt_Observation5.run_Observation5(); break;
			case 5: if (machine.evt_Observation6.guard_Observation6())
				machine.evt_Observation6.run_Observation6(); break;
			}
		}
	}

}
