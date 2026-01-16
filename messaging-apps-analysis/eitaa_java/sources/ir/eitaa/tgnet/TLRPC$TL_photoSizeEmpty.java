package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_photoSizeEmpty extends TLRPC$PhotoSize {
    public static int constructor = 236446268;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.type = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.type);
    }
}
