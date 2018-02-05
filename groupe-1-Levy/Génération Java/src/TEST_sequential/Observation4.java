package TEST_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Observation4{
	/*@ spec_public */ private ControlM0 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Observation4(ControlM0 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.get_InterieurGloria().has(machine.get_PersonneA()) && machine.AUnCode.has(machine.get_PersonneA()) && (machine.Hotesses.intersection(machine.get_InterieurGloria())).equals(BSet.EMPTY)); */
	public /*@ pure */ boolean guard_Observation4() {
		return (machine.get_InterieurGloria().has(machine.get_PersonneA()) && machine.AUnCode.has(machine.get_PersonneA()) && (machine.Hotesses.intersection(machine.get_InterieurGloria())).equals(BSet.EMPTY));
	}

	/*@ public normal_behavior
		requires guard_Observation4();
		assignable machine.InterieurGloria, machine.ExterieurGloria;
		ensures guard_Observation4() &&  machine.get_InterieurGloria().equals(\old(machine.get_InterieurGloria().difference(new BSet<Integer>(machine.get_PersonneA())))) &&  machine.get_ExterieurGloria().equals(\old((machine.get_ExterieurGloria().union(new BSet<Integer>(machine.get_PersonneA()))))); 
	 also
		requires !guard_Observation4();
		assignable \nothing;
		ensures true; */
	public void run_Observation4(){
		if(guard_Observation4()) {
			BSet<Integer> InterieurGloria_tmp = machine.get_InterieurGloria();
			BSet<Integer> ExterieurGloria_tmp = machine.get_ExterieurGloria();

			machine.set_InterieurGloria(InterieurGloria_tmp.difference(new BSet<Integer>(machine.get_PersonneA())));
			machine.set_ExterieurGloria((ExterieurGloria_tmp.union(new BSet<Integer>(machine.get_PersonneA()))));

			System.out.println("Observation4 executed ");
		}
	}

}
