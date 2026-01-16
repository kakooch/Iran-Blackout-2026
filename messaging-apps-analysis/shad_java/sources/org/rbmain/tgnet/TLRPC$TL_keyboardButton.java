package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_keyboardButton extends TLRPC$KeyboardButton {
    public static int constructor = -1560655744;

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
