package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_photoCachedSize extends TLRPC$PhotoSize {
    public static int constructor = 35527382;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.type = stream.readString(exception);
        this.w = stream.readInt32(exception);
        this.h = stream.readInt32(exception);
        this.bytes = stream.readByteArray(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.type);
        stream.writeInt32(this.w);
        stream.writeInt32(this.h);
        stream.writeByteArray(this.bytes);
    }
}
