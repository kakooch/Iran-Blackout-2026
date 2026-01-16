package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_documentAttributeAnimated extends TLRPC$DocumentAttribute {
    public static int constructor = 297109817;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
