package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_requestEncryption extends TLObject {
    public static int constructor = -162681021;
    public byte[] g_a;
    public int random_id;
    public TLRPC$InputUser user_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$EncryptedChat.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.user_id.serializeToStream(stream);
        stream.writeInt32(this.random_id);
        stream.writeByteArray(this.g_a);
    }
}
