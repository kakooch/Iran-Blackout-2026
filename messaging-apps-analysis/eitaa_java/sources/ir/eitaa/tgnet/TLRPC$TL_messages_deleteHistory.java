package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_deleteHistory extends TLObject {
    public static int constructor = 469850889;
    public int flags;
    public boolean just_clear;
    public int max_id;
    public TLRPC$InputPeer peer;
    public boolean revoke;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_messages_affectedHistory.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.just_clear ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.revoke ? i | 2 : i & (-3);
        this.flags = i2;
        stream.writeInt32(i2);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.max_id);
    }
}
