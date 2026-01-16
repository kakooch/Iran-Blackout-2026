package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateDialogUnreadMark extends TLRPC$Update {
    public static int constructor = -513517117;
    public int flags;
    public TLRPC$DialogPeer peer;
    public boolean unread;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.unread = (int32 & 1) != 0;
        this.peer = TLRPC$DialogPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.unread ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.peer.serializeToStream(stream);
    }
}
