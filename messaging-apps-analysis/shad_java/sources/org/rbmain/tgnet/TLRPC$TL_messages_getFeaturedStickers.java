package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_getFeaturedStickers extends TLObject {
    public static int constructor = 766298703;
    public boolean forceLoadFromServer;
    public int hash;
    public String startId;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$messages_FeaturedStickers.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.hash);
    }
}
