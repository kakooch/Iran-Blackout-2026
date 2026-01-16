package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_deleteHistory extends TLObject {
    public static int constructor = 469850889;
    public int flags;
    public boolean just_clear;
    public long max_id;
    public TLRPC$InputPeer peer;
    public boolean revoke;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_messages_affectedHistory.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.just_clear ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.revoke ? i | 2 : i & (-3);
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32((int) this.max_id);
    }
}
