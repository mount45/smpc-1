package smpc.events;

import smpc.abstractlibrary.Event;
import smpc.abstractlibrary.Simulation;
import smpc.library.OnlinePhaseSimulation;

public class Open extends Event {

	int start, end ; 
	public Open (Simulation simulation, double startTime, int hostID, int start, int end){
		this.simulation = simulation;
		this.startTime = startTime ; 
		this.hostID = hostID ;
		
		this.duration = 0.0 ;
		this.type = "Open";
		this.start = start ; 
		this.end = end ; 
	}
	
	
	@Override
	public boolean execute() {

		for (int j = start; j < end; j++) {
			
			for (int i = start; i < end; i++) {
				simulation.schedule(new Send(simulation, startTime, i, j)) ;
			}		
		}
		
		return false;
	}

}
