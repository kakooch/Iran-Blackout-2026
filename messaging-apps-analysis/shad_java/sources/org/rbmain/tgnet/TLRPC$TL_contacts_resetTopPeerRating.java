package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_contacts_resetTopPeerRating extends TLObject {
    public static int constructor = 451113900;
    public TLRPC$TopPeerCategory category;
    public TLRPC$InputPeer peer;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.category.serializeToStream(abstractSerializedData);
        this.peer.serializeToStream(abstractSerializedData);
    }
}
