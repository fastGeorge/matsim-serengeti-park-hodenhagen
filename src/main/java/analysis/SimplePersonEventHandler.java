package analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;
import org.matsim.api.core.v01.population.Person;

import java.util.HashMap;
import java.util.Map;

public class SimplePersonEventHandler implements PersonDepartureEventHandler, PersonArrivalEventHandler {

	private final Map<Id<Person>, Double> personDepartureTime = new HashMap<>();

	@Override
	public void handleEvent(PersonDepartureEvent event) {
		personDepartureTime.put(event.getPersonId(), event.getTime());
	}

	@Override
	public void handleEvent(PersonArrivalEvent event) {
		// TODO Auto-generated method stub

		double travelTime = event.getTime() - personDepartureTime.get(event.getPersonId());
		System.out.println("Person: " + event.getPersonId() + " travlled for: " + travelTime + " s");
	}

}
