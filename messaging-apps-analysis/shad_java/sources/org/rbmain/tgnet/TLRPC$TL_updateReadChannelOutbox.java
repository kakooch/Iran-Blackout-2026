package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_updateReadChannelOutbox extends TLRPC$Update {
    public static int constructor = 634833351;
    public int channel_id;
    public long max_id;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.channel_id = abstractSerializedData.readInt32(z);
        this.max_id = abstractSerializedData.readInt32(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.channel_id);
        abstractSerializedData.writeInt32((int) this.max_id);
    }
}
