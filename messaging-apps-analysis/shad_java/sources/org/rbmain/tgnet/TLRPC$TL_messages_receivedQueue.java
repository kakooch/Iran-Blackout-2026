package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_receivedQueue extends TLObject {
    public static int constructor = 1436924774;
    public int max_qts;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
        int int32 = abstractSerializedData.readInt32(z);
        for (int i2 = 0; i2 < int32; i2++) {
            tLRPC$Vector.objects.add(Long.valueOf(abstractSerializedData.readInt64(z)));
        }
        return tLRPC$Vector;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.max_qts);
    }
}
