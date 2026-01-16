package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_fileHash extends TLObject {
    public static int constructor = 1648543603;
    public byte[] hash;
    public int limit;
    public int offset;

    public static TLRPC$TL_fileHash TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_fileHash", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_fileHash tLRPC$TL_fileHash = new TLRPC$TL_fileHash();
        tLRPC$TL_fileHash.readParams(stream, exception);
        return tLRPC$TL_fileHash;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.offset = stream.readInt32(exception);
        this.limit = stream.readInt32(exception);
        this.hash = stream.readByteArray(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.offset);
        stream.writeInt32(this.limit);
        stream.writeByteArray(this.hash);
    }
}
