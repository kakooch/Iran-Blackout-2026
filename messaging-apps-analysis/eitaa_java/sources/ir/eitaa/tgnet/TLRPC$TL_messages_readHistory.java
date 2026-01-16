package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_readHistory extends TLObject {
    public static int constructor = 238054714;
    public int max_id;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_messages_affectedMessages.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.max_id);
    }
}
