package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_sendScreenshotNotification extends TLObject {
    public static int constructor = -914493408;
    public TLRPC$InputPeer peer;
    public long random_id;
    public long reply_to_msg_id;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32((int) this.reply_to_msg_id);
        abstractSerializedData.writeInt64(this.random_id);
    }
}
