package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputDocumentEmpty extends TLRPC$InputDocument {
    public static int constructor = 1928391342;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
