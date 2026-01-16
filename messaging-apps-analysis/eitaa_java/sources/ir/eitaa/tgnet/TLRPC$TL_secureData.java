package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_secureData extends TLObject {
    public static int constructor = -1964327229;
    public byte[] data;
    public byte[] data_hash;
    public byte[] secret;

    public static TLRPC$TL_secureData TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_secureData", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_secureData tLRPC$TL_secureData = new TLRPC$TL_secureData();
        tLRPC$TL_secureData.readParams(stream, exception);
        return tLRPC$TL_secureData;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.data = stream.readByteArray(exception);
        this.data_hash = stream.readByteArray(exception);
        this.secret = stream.readByteArray(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeByteArray(this.data);
        stream.writeByteArray(this.data_hash);
        stream.writeByteArray(this.secret);
    }
}
