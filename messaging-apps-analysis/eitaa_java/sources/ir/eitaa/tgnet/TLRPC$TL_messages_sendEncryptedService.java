package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_sendEncryptedService extends TLObject {
    public static int constructor = 852769188;
    public NativeByteBuffer data;
    public TLRPC$TL_inputEncryptedChat peer;
    public long random_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_SentEncryptedMessage.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt64(this.random_id);
        stream.writeByteBuffer(this.data);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void freeResources() {
        NativeByteBuffer nativeByteBuffer = this.data;
        if (nativeByteBuffer != null) {
            nativeByteBuffer.reuse();
            this.data = null;
        }
    }
}
