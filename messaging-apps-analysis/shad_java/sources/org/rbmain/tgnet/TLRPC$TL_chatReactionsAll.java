package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_chatReactionsAll extends TLRPC$ChatReactions {
    public static int constructor = 1385335754;
    public boolean allow_custom;
    public int flags;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.allow_custom = (int32 & 1) != 0;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.allow_custom ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
    }
}
