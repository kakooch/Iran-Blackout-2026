package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_deleteRevokedExportedChatInvites extends TLObject {
    public static int constructor = 1452833749;
    public TLRPC$InputUser admin_id;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        this.admin_id.serializeToStream(stream);
    }
}
