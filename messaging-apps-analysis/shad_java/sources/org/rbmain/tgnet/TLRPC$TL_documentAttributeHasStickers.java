package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_documentAttributeHasStickers extends TLRPC$DocumentAttribute {
    public static int constructor = -1744710921;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
