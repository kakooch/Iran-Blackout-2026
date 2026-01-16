package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_decryptedMessageService extends TLRPC$DecryptedMessage {
    public static int constructor = 1930838368;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.random_id = stream.readInt64(exception);
        this.action = TLRPC$DecryptedMessageAction.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.random_id);
        this.action.serializeToStream(stream);
    }
}
