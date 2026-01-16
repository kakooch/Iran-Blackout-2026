package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messageMediaUnsupported extends TLRPC$MessageMedia {
    public static int constructor = -1618676578;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
