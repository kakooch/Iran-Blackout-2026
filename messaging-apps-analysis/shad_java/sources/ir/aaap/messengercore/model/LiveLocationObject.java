package ir.aaap.messengercore.model;

/* loaded from: classes3.dex */
public class LiveLocationObject {
    public LocationObject current_location;
    public String device_hash;
    public long last_update_time;
    public String live_loc_track_id;
    public long live_period;
    public long start_time;
    public Status status;
    public String user_guid;

    public enum Status {
        Stopped,
        Live
    }
}
