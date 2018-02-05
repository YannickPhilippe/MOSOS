package TEST_sequential;

import eventb_prelude.*;
import Util.*;
//@ model import org.jmlspecs.models.JMLObjectSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ControlM0{
	private static final Integer max_integer = Utilities.max_integer;
	private static final Integer min_integer = Utilities.min_integer;

	Observation5 evt_Observation5 = new Observation5(this);
	Observation4 evt_Observation4 = new Observation4(this);
	Observation3 evt_Observation3 = new Observation3(this);
	Observation2 evt_Observation2 = new Observation2(this);
	Observation1 evt_Observation1 = new Observation1(this);


	/******Set definitions******/
	//@ public static constraint Personnes.equals(\old(Personnes)); 
	public static final BSet<Integer> Personnes = new Enumerated(min_integer,max_integer);


	/******Constant definitions******/
	//@ public static constraint AUnCode.equals(\old(AUnCode)); 
	public static final BSet<Integer> AUnCode = Test_ControlM0.random_AUnCode;

	//@ public static constraint AUneCarte.equals(\old(AUneCarte)); 
	public static final BSet<Integer> AUneCarte = Test_ControlM0.random_AUneCarte;

	//@ public static constraint Employes.equals(\old(Employes)); 
	public static final BSet<Integer> Employes = Test_ControlM0.random_Employes;

	//@ public static constraint Hotesses.equals(\old(Hotesses)); 
	public static final BSet<Integer> Hotesses = Test_ControlM0.random_Hotesses;

	//@ public static constraint Visiteurs.equals(\old(Visiteurs)); 
	public static final BSet<Integer> Visiteurs = Test_ControlM0.random_Visiteurs;



	/******Axiom definitions******/
	/*@ public static invariant BSet.partition(Personnes,Visiteurs,Employes); */
	/*@ public static invariant Hotesses.isSubset(Employes); */
	/*@ public static invariant AUneCarte.isSubset(Personnes); */
	/*@ public static invariant Employes.isSubset(AUneCarte); */
	/*@ public static invariant AUnCode.isSubset(Personnes); */


	/******Variable definitions******/
	/*@ spec_public */ private BSet<Integer> ExterieurGloria;

	/*@ spec_public */ private BSet<Integer> InterieurGloria;

	/*@ spec_public */ private Integer PersonneA;

	/*@ spec_public */ private Integer PersonneB;




	/******Invariant definition******/
	/*@ public invariant
		InterieurGloria.isSubset(Personnes) &&
		ExterieurGloria.isSubset(Personnes) &&
		(InterieurGloria.intersection(ExterieurGloria)).equals(BSet.EMPTY) &&
		Personnes.has(PersonneA) &&
		Personnes.has(PersonneB); */


	/******Getter and Mutator methods definition******/
	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.InterieurGloria;*/
	public /*@ pure */ BSet<Integer> get_InterieurGloria(){
		return this.InterieurGloria;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.InterieurGloria;
	    ensures this.InterieurGloria == InterieurGloria;*/
	public void set_InterieurGloria(BSet<Integer> InterieurGloria){
		this.InterieurGloria = InterieurGloria;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.ExterieurGloria;*/
	public /*@ pure */ BSet<Integer> get_ExterieurGloria(){
		return this.ExterieurGloria;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.ExterieurGloria;
	    ensures this.ExterieurGloria == ExterieurGloria;*/
	public void set_ExterieurGloria(BSet<Integer> ExterieurGloria){
		this.ExterieurGloria = ExterieurGloria;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PersonneA;*/
	public /*@ pure */ Integer get_PersonneA(){
		return this.PersonneA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PersonneA;
	    ensures this.PersonneA == PersonneA;*/
	public void set_PersonneA(Integer PersonneA){
		this.PersonneA = PersonneA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PersonneB;*/
	public /*@ pure */ Integer get_PersonneB(){
		return this.PersonneB;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PersonneB;
	    ensures this.PersonneB == PersonneB;*/
	public void set_PersonneB(Integer PersonneB){
		this.PersonneB = PersonneB;
	}



	/*@ public normal_behavior
	    requires true;
	    assignable \everything;
	    ensures
		ExterieurGloria.equals(Personnes) &&
		InterieurGloria.isEmpty() &&
		(\exists Integer PersonneA_localVar; Personnes.has(PersonneA_localVar); PersonneA.equals(PersonneA_localVar)) &&
		(\exists Integer PersonneB_localVar; Personnes.has(PersonneB_localVar); PersonneB.equals(PersonneB_localVar));*/
	public ControlM0(){
		ExterieurGloria = (Personnes);
		InterieurGloria = new BSet<Integer>();
		PersonneA = Utilities.someVal(Personnes);
		PersonneB = Utilities.someVal(Personnes);

	}
}