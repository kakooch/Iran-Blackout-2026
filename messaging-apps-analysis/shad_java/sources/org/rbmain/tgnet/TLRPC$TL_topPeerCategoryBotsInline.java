package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_topPeerCategoryBotsInline extends TLRPC$TopPeerCategory {
    public static int constructor = 344356834;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
