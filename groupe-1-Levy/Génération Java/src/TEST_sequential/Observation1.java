package TEST_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Observation1{
	/*@ spec_public */ private ControlM0 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Observation1(ControlM0 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.get_ExterieurGloria().has(machine.get_PersonneA()) && machine.get_InterieurGloria().has(machine.get_PersonneB()) && !(machine.Hotesses.intersection(machine.get_InterieurGloria())).equals(BSet.EMPTY)); */
	public /*@ pure */ boolean guard_Observation1() {
		return (machine.get_ExterieurGloria().has(machine.get_PersonneA()) && machine.get_InterieurGloria().has(machine.get_PersonneB()) && !(machine.Hotesses.intersection(machine.get_InterieurGloria())).equals(BSet.EMPTY));
	}

	/*@ public normal_behavior
		requires guard_Observation1();
		assignable machine.ExterieurGloria, machine.InterieurGloria;
		ensures guard_Observation1() &&  machine.get_ExterieurGloria().equals(\old(machine.get_ExterieurGloria().difference(new BSet<Integer>(machine.get_PersonneA())))) &&  machine.get_InterieurGloria().equals(\old((machine.get_InterieurGloria().union(new BSet<Integer>(machine.get_PersonneA()))))); 
	 also
		requires !guard_Observation1();
		assignable \nothing;
		ensures true; */
	public void run_Observation1(){
		if(guard_Observation1()) {
			BSet<Integer> ExterieurGloria_tmp = machine.get_ExterieurGloria();
			BSet<Integer> InterieurGloria_tmp = machine.get_InterieurGloria();

			machine.set_ExterieurGloria(ExterieurGloria_tmp.difference(new BSet<Integer>(machine.get_PersonneA())));
			machine.set_InterieurGloria((InterieurGloria_tmp.union(new BSet<Integer>(machine.get_PersonneA()))));

			System.out.println("Observation1 executed ");
		}
	}

}
