package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_decryptedMessageMediaWebPage extends TLRPC$DecryptedMessageMedia {
    public static int constructor = -452652584;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.url = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.url);
    }
}
