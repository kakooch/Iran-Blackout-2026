package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messageActionSetMessagesTTL extends TLRPC$MessageAction {
    public static int constructor = -1441072131;
    public int period;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.period = abstractSerializedData.readInt32(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.period);
    }
}
