package analysis;

import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.scoring.EventsToScore;

public class SimpleAnalysis {
	
	public static void main(String[] args) {
		
		
		SimplePersonEventHandler handler = new SimplePersonEventHandler();
		
		EventsManager manager = EventsUtils.createEventsManager();
		manager.addHandler(handler);
		
		EventsUtils.readEvents(manager, "C:\\Users\\gusta\\git\\matsim-serengeti-park-hodenhagen\\scenarios\\serengeti-park-v1.0\\output\\output-serengeti-park-v1.0-run1\\serengeti-park-v1.0-run1.output_events.xml.gz");
	}

}
