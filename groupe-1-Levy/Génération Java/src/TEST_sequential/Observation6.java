package TEST_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Observation6{
	/*@ spec_public */ private ControlM1 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Observation6(ControlM1 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.get_InterieurGloria().has(machine.get_PersonneA()) && machine.get_Situation().equals(machine.Urgence)); */
	public /*@ pure */ boolean guard_Observation6() {
		return (machine.get_InterieurGloria().has(machine.get_PersonneA()) && machine.get_Situation().equals(machine.Urgence));
	}

	/*@ public normal_behavior
		requires guard_Observation6();
		assignable machine.InterieurGloria, machine.ExterieurGloria;
		ensures guard_Observation6() &&  machine.get_InterieurGloria().equals(\old(machine.get_InterieurGloria().difference(new BSet<Integer>(machine.get_PersonneA())))) &&  machine.get_ExterieurGloria().equals(\old((machine.get_ExterieurGloria().union(new BSet<Integer>(machine.get_PersonneA()))))); 
	 also
		requires !guard_Observation6();
		assignable \nothing;
		ensures true; */
	public void run_Observation6(){
		if(guard_Observation6()) {
			BSet<Integer> InterieurGloria_tmp = machine.get_InterieurGloria();
			BSet<Integer> ExterieurGloria_tmp = machine.get_ExterieurGloria();

			machine.set_InterieurGloria(InterieurGloria_tmp.difference(new BSet<Integer>(machine.get_PersonneA())));
			machine.set_ExterieurGloria((ExterieurGloria_tmp.union(new BSet<Integer>(machine.get_PersonneA()))));

			System.out.println("Observation6 executed ");
		}
	}

}
