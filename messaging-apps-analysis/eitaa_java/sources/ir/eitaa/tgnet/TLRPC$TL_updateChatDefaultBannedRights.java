package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateChatDefaultBannedRights extends TLRPC$Update {
    public static int constructor = 1421875280;
    public TLRPC$TL_chatBannedRights default_banned_rights;
    public TLRPC$Peer peer;
    public int version;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.default_banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.version = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        this.default_banned_rights.serializeToStream(stream);
        stream.writeInt32(this.version);
    }
}
