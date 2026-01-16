package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_textPlain extends TLRPC$RichText {
    public static int constructor = 1950782688;
    public String text;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.text = abstractSerializedData.readString(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.text);
    }
}
