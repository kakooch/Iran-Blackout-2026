package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_groupCall extends TLRPC$GroupCall {
    public static int constructor = -711498484;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.join_muted = (int32 & 2) != 0;
        this.can_change_join_muted = (int32 & 4) != 0;
        this.join_date_asc = (int32 & 64) != 0;
        this.schedule_start_subscribed = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
        this.can_start_video = (int32 & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
        this.record_video_active = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
        this.id = stream.readInt64(exception);
        this.access_hash = stream.readInt64(exception);
        this.participants_count = stream.readInt32(exception);
        if ((this.flags & 8) != 0) {
            this.title = stream.readString(exception);
        }
        if ((this.flags & 16) != 0) {
            this.stream_dc_id = stream.readInt32(exception);
        }
        if ((this.flags & 32) != 0) {
            this.record_start_date = stream.readInt32(exception);
        }
        if ((this.flags & 128) != 0) {
            this.schedule_date = stream.readInt32(exception);
        }
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            this.unmuted_video_count = stream.readInt32(exception);
        }
        this.unmuted_video_limit = stream.readInt32(exception);
        this.version = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.join_muted ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.can_change_join_muted ? i | 4 : i & (-5);
        this.flags = i2;
        int i3 = this.join_date_asc ? i2 | 64 : i2 & (-65);
        this.flags = i3;
        int i4 = this.schedule_start_subscribed ? i3 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i3 & (-257);
        this.flags = i4;
        int i5 = this.can_start_video ? i4 | Factory.DEVICE_USE_ANDROID_CAMCORDER : i4 & (-513);
        this.flags = i5;
        int i6 = this.record_video_active ? i5 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i5 & (-2049);
        this.flags = i6;
        stream.writeInt32(i6);
        stream.writeInt64(this.id);
        stream.writeInt64(this.access_hash);
        stream.writeInt32(this.participants_count);
        if ((this.flags & 8) != 0) {
            stream.writeString(this.title);
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt32(this.stream_dc_id);
        }
        if ((this.flags & 32) != 0) {
            stream.writeInt32(this.record_start_date);
        }
        if ((this.flags & 128) != 0) {
            stream.writeInt32(this.schedule_date);
        }
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            stream.writeInt32(this.unmuted_video_count);
        }
        stream.writeInt32(this.unmuted_video_limit);
        stream.writeInt32(this.version);
    }
}
