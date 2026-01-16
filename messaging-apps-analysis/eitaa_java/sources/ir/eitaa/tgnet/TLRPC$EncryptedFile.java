package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$EncryptedFile extends TLObject {
    public long access_hash;
    public int dc_id;
    public long id;
    public int key_fingerprint;
    public int size;

    public static TLRPC$EncryptedFile TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$EncryptedFile tLRPC$EncryptedFile;
        if (constructor != -1038136962) {
            tLRPC$EncryptedFile = constructor != 1248893260 ? null : new TLRPC$EncryptedFile() { // from class: ir.eitaa.tgnet.TLRPC$TL_encryptedFile
                public static int constructor = 1248893260;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.id = stream2.readInt64(exception2);
                    this.access_hash = stream2.readInt64(exception2);
                    this.size = stream2.readInt32(exception2);
                    this.dc_id = stream2.readInt32(exception2);
                    this.key_fingerprint = stream2.readInt32(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt64(this.id);
                    stream2.writeInt64(this.access_hash);
                    stream2.writeInt32(this.size);
                    stream2.writeInt32(this.dc_id);
                    stream2.writeInt32(this.key_fingerprint);
                }
            };
        } else {
            tLRPC$EncryptedFile = new TLRPC$EncryptedFile() { // from class: ir.eitaa.tgnet.TLRPC$TL_encryptedFileEmpty
                public static int constructor = -1038136962;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$EncryptedFile == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in EncryptedFile", Integer.valueOf(constructor)));
        }
        if (tLRPC$EncryptedFile != null) {
            tLRPC$EncryptedFile.readParams(stream, exception);
        }
        return tLRPC$EncryptedFile;
    }
}
