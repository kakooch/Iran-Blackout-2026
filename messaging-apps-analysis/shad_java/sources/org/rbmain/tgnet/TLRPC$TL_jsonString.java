package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_jsonString extends TLRPC$JSONValue {
    public static int constructor = -1222740358;
    public String value;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.value = abstractSerializedData.readString(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.value);
    }
}
