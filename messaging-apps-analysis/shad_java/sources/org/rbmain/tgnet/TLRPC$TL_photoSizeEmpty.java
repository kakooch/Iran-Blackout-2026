package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_photoSizeEmpty extends TLRPC$PhotoSize {
    public static int constructor = 236446268;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.type = abstractSerializedData.readString(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.type);
    }
}
