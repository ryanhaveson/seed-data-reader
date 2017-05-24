package seedDataReader;

import java.util.List;
import java.util.Map;

/**
 * Created by rhaveson on 5/24/2017.
 */
public class Frame {
    long timestamp;
    Map<String, ParticipantFrame> participantFrame;
    List<Event> events;
}
