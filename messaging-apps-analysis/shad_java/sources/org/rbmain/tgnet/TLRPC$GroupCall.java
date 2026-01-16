package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$GroupCall extends TLObject {
    public long access_hash;
    public boolean can_change_join_muted;
    public boolean can_start_video;
    public int duration;
    public int flags;
    public String id;
    public boolean join_date_asc;
    public boolean join_muted;
    public TLRPC$TL_dataJSON params;
    public int participants_count;
    public int record_start_date;
    public boolean record_video_active;
    public boolean rtmp_stream;
    public int schedule_date;
    public boolean schedule_start_subscribed;
    public int stream_dc_id;
    public String title;
    public int unmuted_video_count;
    public int unmuted_video_limit;
    public int version;

    public static TLRPC$GroupCall TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$GroupCall tLRPC$TL_groupCall;
        if (i != -916691372) {
            tLRPC$TL_groupCall = i != 2004925620 ? null : new TLRPC$TL_groupCallDiscarded();
        } else {
            tLRPC$TL_groupCall = new TLRPC$TL_groupCall();
        }
        if (tLRPC$TL_groupCall == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in GroupCall", Integer.valueOf(i)));
        }
        if (tLRPC$TL_groupCall != null) {
            tLRPC$TL_groupCall.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_groupCall;
    }

    public Object clone() throws CloneNotSupportedException {
        TLRPC$GroupCall tLRPC$TL_groupCallDiscarded;
        if (this instanceof TLRPC$TL_groupCall) {
            tLRPC$TL_groupCallDiscarded = new TLRPC$TL_groupCall();
        } else {
            tLRPC$TL_groupCallDiscarded = new TLRPC$TL_groupCallDiscarded();
        }
        cloneFields(tLRPC$TL_groupCallDiscarded);
        return tLRPC$TL_groupCallDiscarded;
    }

    public void cloneFields(TLRPC$GroupCall tLRPC$GroupCall) {
        if (tLRPC$GroupCall == null) {
            return;
        }
        tLRPC$GroupCall.flags = this.flags;
        tLRPC$GroupCall.join_muted = this.join_muted;
        tLRPC$GroupCall.can_change_join_muted = this.can_change_join_muted;
        tLRPC$GroupCall.join_date_asc = this.join_date_asc;
        tLRPC$GroupCall.schedule_start_subscribed = this.schedule_start_subscribed;
        tLRPC$GroupCall.id = this.id;
        tLRPC$GroupCall.access_hash = this.access_hash;
        tLRPC$GroupCall.participants_count = this.participants_count;
        tLRPC$GroupCall.params = this.params;
        tLRPC$GroupCall.title = this.title;
        tLRPC$GroupCall.stream_dc_id = this.stream_dc_id;
        tLRPC$GroupCall.record_start_date = this.record_start_date;
        tLRPC$GroupCall.schedule_date = this.schedule_date;
        tLRPC$GroupCall.version = this.version;
        tLRPC$GroupCall.duration = this.duration;
        tLRPC$GroupCall.rtmp_stream = this.rtmp_stream;
    }
}
