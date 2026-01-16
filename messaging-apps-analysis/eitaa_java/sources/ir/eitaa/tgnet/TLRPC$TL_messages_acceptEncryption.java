package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_acceptEncryption extends TLObject {
    public static int constructor = 1035731989;
    public byte[] g_b;
    public long key_fingerprint;
    public TLRPC$TL_inputEncryptedChat peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$EncryptedChat.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeByteArray(this.g_b);
        stream.writeInt64(this.key_fingerprint);
    }
}
