package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_groupCall extends TLRPC$GroupCall {
    public static int constructor = -916691372;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.join_muted = (int32 & 2) != 0;
        this.can_change_join_muted = (int32 & 4) != 0;
        this.join_date_asc = (int32 & 64) != 0;
        this.schedule_start_subscribed = (int32 & 256) != 0;
        this.access_hash = abstractSerializedData.readInt64(z);
        this.participants_count = abstractSerializedData.readInt32(z);
        if ((this.flags & 1) != 0) {
            this.params = TLRPC$TL_dataJSON.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 8) != 0) {
            this.title = abstractSerializedData.readString(z);
        }
        if ((this.flags & 16) != 0) {
            this.stream_dc_id = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 32) != 0) {
            this.record_start_date = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 128) != 0) {
            this.schedule_date = abstractSerializedData.readInt32(z);
        }
        this.version = abstractSerializedData.readInt32(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.join_muted ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.can_change_join_muted ? i | 4 : i & (-5);
        this.flags = i2;
        int i3 = this.join_date_asc ? i2 | 64 : i2 & (-65);
        this.flags = i3;
        int i4 = this.schedule_start_subscribed ? i3 | 256 : i3 & (-257);
        this.flags = i4;
        abstractSerializedData.writeInt32(i4);
        abstractSerializedData.writeInt64(this.access_hash);
        abstractSerializedData.writeInt32(this.participants_count);
        if ((this.flags & 1) != 0) {
            this.params.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 8) != 0) {
            abstractSerializedData.writeString(this.title);
        }
        if ((this.flags & 16) != 0) {
            abstractSerializedData.writeInt32(this.stream_dc_id);
        }
        if ((this.flags & 32) != 0) {
            abstractSerializedData.writeInt32(this.record_start_date);
        }
        if ((this.flags & 128) != 0) {
            abstractSerializedData.writeInt32(this.schedule_date);
        }
        abstractSerializedData.writeInt32(this.version);
    }
}
