package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_photoStrippedSize extends TLRPC$PhotoSize {
    public static int constructor = -525288402;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.type = stream.readString(exception);
        this.bytes = stream.readByteArray(exception);
        this.h = 50;
        this.w = 50;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.type);
        stream.writeByteArray(this.bytes);
    }
}
