package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_uploadMedia extends TLObject {
    public static int constructor = 1369162417;
    public TLRPC$InputMedia media;
    public TLRPC$InputPeer peer;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$MessageMedia.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        this.media.serializeToStream(abstractSerializedData);
    }
}
