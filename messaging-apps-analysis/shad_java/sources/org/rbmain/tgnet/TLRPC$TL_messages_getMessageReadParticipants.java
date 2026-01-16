package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_getMessageReadParticipants extends TLObject {
    public static int constructor = 834782287;
    public long msg_id;
    public TLRPC$InputPeer peer;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return new TLRPC$Vector();
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt64(this.msg_id);
    }
}
