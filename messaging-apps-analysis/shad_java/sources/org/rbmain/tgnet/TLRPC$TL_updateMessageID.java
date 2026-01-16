package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_updateMessageID extends TLRPC$Update {
    public static int constructor = 1318109142;
    public long id;
    public long random_id;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.id = abstractSerializedData.readInt32(z);
        this.random_id = abstractSerializedData.readInt64(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32((int) this.id);
        abstractSerializedData.writeInt64(this.random_id);
    }
}
