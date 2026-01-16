package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputEncryptedChat extends TLObject {
    public static int constructor = -247351839;
    public long access_hash;
    public int chat_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.chat_id = stream.readInt32(exception);
        this.access_hash = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.chat_id);
        stream.writeInt64(this.access_hash);
    }
}
