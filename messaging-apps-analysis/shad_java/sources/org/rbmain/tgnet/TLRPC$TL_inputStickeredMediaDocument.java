package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputStickeredMediaDocument extends TLRPC$InputStickeredMedia {
    public static int constructor = 70813275;
    public TLRPC$InputDocument id;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.id = TLRPC$InputDocument.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.id.serializeToStream(abstractSerializedData);
    }
}
