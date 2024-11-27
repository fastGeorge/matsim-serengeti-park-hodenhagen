package analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;
import org.matsim.api.core.v01.network.Link;

import java.util.HashMap;
import java.util.Map;

public class SimpleLinkHandler implements LinkLeaveEventHandler {

    private final Id<Link> linkOfInterest = Id.createLinkId("2344590910000f");

    private final Map<Integer, Integer> volumes = new HashMap<>();

    public Map<Integer, Integer> getVolumes() {
        return volumes;
    }

    @Override
    public void handleEvent(LinkLeaveEvent event) {

        if (event.getLinkId() == linkOfInterest){

            double time = event.getTime();
            int hour = (int) time / 3600;
            volumes.merge(hour, 1, Integer::sum);
        }

    }
}
