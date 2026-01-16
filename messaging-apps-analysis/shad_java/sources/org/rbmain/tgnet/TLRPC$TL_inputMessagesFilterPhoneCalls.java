package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputMessagesFilterPhoneCalls extends TLRPC$MessagesFilter {
    public static int constructor = -2134272152;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.missed = (int32 & 1) != 0;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.missed ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
    }
}
