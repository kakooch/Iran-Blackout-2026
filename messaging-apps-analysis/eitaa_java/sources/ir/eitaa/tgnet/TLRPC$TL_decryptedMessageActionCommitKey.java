package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_decryptedMessageActionCommitKey extends TLRPC$DecryptedMessageAction {
    public static int constructor = -332526693;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.exchange_id = stream.readInt64(exception);
        this.key_fingerprint = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.exchange_id);
        stream.writeInt64(this.key_fingerprint);
    }
}
