package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_getChatInviteImporters extends TLObject {
    public static int constructor = 654013065;
    public int limit;
    public String link;
    public int offset_date;
    public TLRPC$InputUser offset_user;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_messages_chatInviteImporters.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeString(this.link);
        stream.writeInt32(this.offset_date);
        this.offset_user.serializeToStream(stream);
        stream.writeInt32(this.limit);
    }
}
