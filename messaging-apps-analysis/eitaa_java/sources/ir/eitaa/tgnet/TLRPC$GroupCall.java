package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$GroupCall extends TLObject {
    public long access_hash;
    public boolean can_change_join_muted;
    public boolean can_start_video;
    public int duration;
    public int flags;
    public long id;
    public boolean join_date_asc;
    public boolean join_muted;
    public int participants_count;
    public int record_start_date;
    public boolean record_video_active;
    public int schedule_date;
    public boolean schedule_start_subscribed;
    public int stream_dc_id;
    public String title;
    public int unmuted_video_count;
    public int unmuted_video_limit;
    public int version;

    public static TLRPC$GroupCall TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$GroupCall tLRPC$TL_groupCall;
        if (constructor != -711498484) {
            tLRPC$TL_groupCall = constructor != 2004925620 ? null : new TLRPC$TL_groupCallDiscarded();
        } else {
            tLRPC$TL_groupCall = new TLRPC$TL_groupCall();
        }
        if (tLRPC$TL_groupCall == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in GroupCall", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_groupCall != null) {
            tLRPC$TL_groupCall.readParams(stream, exception);
        }
        return tLRPC$TL_groupCall;
    }
}
