package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_stats_getMessageStats extends TLObject {
    public static int constructor = -1226791947;
    public TLRPC$InputChannel channel;
    public boolean dark;
    public int flags;
    public long msg_id;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_stats_messageStats.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.dark ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        this.channel.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32((int) this.msg_id);
    }
}
