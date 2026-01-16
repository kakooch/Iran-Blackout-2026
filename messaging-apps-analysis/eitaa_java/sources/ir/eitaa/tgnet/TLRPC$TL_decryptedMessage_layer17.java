package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_decryptedMessage_layer17 extends TLRPC$TL_decryptedMessage {
    public static int constructor = 541931640;

    @Override // ir.eitaa.tgnet.TLRPC$TL_decryptedMessage, ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.random_id = stream.readInt64(exception);
        this.ttl = stream.readInt32(exception);
        this.message = stream.readString(exception);
        this.media = TLRPC$DecryptedMessageMedia.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLRPC$TL_decryptedMessage, ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.random_id);
        stream.writeInt32(this.ttl);
        stream.writeString(this.message);
        this.media.serializeToStream(stream);
    }
}
