package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_readEncryptedHistory extends TLObject {
    public static int constructor = 2135648522;
    public int max_date;
    public TLRPC$TL_inputEncryptedChat peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.max_date);
    }
}
