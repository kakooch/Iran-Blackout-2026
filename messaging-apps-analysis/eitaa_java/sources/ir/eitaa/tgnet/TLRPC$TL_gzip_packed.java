package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_gzip_packed extends TLObject {
    public static int constructor = 812830625;
    public byte[] packed_data;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.packed_data = stream.readByteArray(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeByteArray(this.packed_data);
    }
}
