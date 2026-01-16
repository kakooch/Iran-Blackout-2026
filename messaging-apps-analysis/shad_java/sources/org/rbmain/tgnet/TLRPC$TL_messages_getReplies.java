package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_getReplies extends TLObject {
    public static int constructor = 615875002;
    public int add_offset;
    public int hash;
    public int limit;
    public long max_id;
    public int min_id;
    public long msg_id;
    public int offset_date;
    public long offset_id;
    public TLRPC$InputPeer peer;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$messages_Messages.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32((int) this.msg_id);
        abstractSerializedData.writeInt32((int) this.offset_id);
        abstractSerializedData.writeInt32(this.offset_date);
        abstractSerializedData.writeInt32(this.add_offset);
        abstractSerializedData.writeInt32(this.limit);
        abstractSerializedData.writeInt32((int) this.max_id);
        abstractSerializedData.writeInt32(this.min_id);
        abstractSerializedData.writeInt32(this.hash);
    }
}
