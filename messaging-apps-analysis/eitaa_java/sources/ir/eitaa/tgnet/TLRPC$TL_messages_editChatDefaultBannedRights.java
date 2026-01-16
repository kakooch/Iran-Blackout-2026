package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_editChatDefaultBannedRights extends TLObject {
    public static int constructor = -1517917375;
    public TLRPC$TL_chatBannedRights banned_rights;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        this.banned_rights.serializeToStream(stream);
    }
}
