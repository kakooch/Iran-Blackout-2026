package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_jsonNumber extends TLRPC$JSONValue {
    public static int constructor = 736157604;
    public double value;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.value = abstractSerializedData.readDouble(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeDouble(this.value);
    }
}
