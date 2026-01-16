package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_sendEncryptedFile extends TLObject {
    public static int constructor = 1431914525;
    public NativeByteBuffer data;
    public TLRPC$InputEncryptedFile file;
    public int flags;
    public TLRPC$TL_inputEncryptedChat peer;
    public long random_id;
    public boolean silent;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_SentEncryptedMessage.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.silent ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.peer.serializeToStream(stream);
        stream.writeInt64(this.random_id);
        stream.writeByteBuffer(this.data);
        this.file.serializeToStream(stream);
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
