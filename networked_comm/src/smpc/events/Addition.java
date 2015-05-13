package smpc.events;

import smpc.Parameters;
import smpc.library.OnlinePhaseSimulation;
import smpc.abstractlibrary.Event;

public class Addition extends Event {
	
	public Addition(OnlinePhaseSimulation onlinePhaseSimulation, double startTime, int hostID , int start, int end){

		this.simulation = onlinePhaseSimulation;
		this.startTime = startTime ; 
		this.hostID = hostID ;
		
		this.duration = 20.0 ;
		this.type = "aDDITION";
		
		this.start = start ; 
		this.end = end ; 

	}
	

	@Override
	public boolean execute() {
			/**
			 * ADD
			 */
			
			for (int i = 0; i < Parameters.getNumberOfParties(); i++) 
			{
				simulation.schedule(new Computation(simulation, startTime, i, Parameters.ComputationType.ADDITION));
			}

			return false ; 
	}

}
