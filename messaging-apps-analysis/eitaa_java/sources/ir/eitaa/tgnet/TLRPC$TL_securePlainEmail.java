package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_securePlainEmail extends TLRPC$SecurePlainData {
    public static int constructor = 569137759;
    public String email;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.email = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.email);
    }
}
