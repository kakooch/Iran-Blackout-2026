package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_updateReadChannelInbox extends TLRPC$Update {
    public static int constructor = 856380452;
    public int channel_id;
    public int flags;
    public int folder_id;
    public long max_id;
    public int pts;
    public int still_unread_count;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.folder_id = abstractSerializedData.readInt32(z);
        }
        this.channel_id = abstractSerializedData.readInt32(z);
        this.max_id = abstractSerializedData.readInt32(z);
        this.still_unread_count = abstractSerializedData.readInt32(z);
        this.pts = abstractSerializedData.readInt32(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32(this.folder_id);
        }
        abstractSerializedData.writeInt32(this.channel_id);
        abstractSerializedData.writeInt32((int) this.max_id);
        abstractSerializedData.writeInt32(this.still_unread_count);
        abstractSerializedData.writeInt32(this.pts);
    }
}
