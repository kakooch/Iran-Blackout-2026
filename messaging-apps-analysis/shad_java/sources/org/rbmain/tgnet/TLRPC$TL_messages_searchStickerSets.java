package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_searchStickerSets extends TLObject {
    public static int constructor = -1028140917;
    public boolean exclude_featured;
    public int flags;
    public int hash;
    public String q;
    public String startId;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$messages_FoundStickerSets.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.exclude_featured ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        abstractSerializedData.writeString(this.q);
        abstractSerializedData.writeInt32(this.hash);
    }
}
