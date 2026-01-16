package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_markDialogUnread extends TLObject {
    public static int constructor = -1031349873;
    public int flags;
    public TLRPC$InputDialogPeer peer;
    public boolean unread;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
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
