package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_getPollVotes extends TLObject {
    public static int constructor = -1200736242;
    public int flags;
    public int id;
    public int limit;
    public String offset;
    public byte[] option;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_messages_votesList.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.id);
        if ((this.flags & 1) != 0) {
            stream.writeByteArray(this.option);
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.offset);
        }
        stream.writeInt32(this.limit);
    }
}
