package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_fileHash extends TLObject {
    public static int constructor = 1648543603;
    public byte[] hash;
    public int limit;
    public int offset;

    public static TLRPC$TL_fileHash TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_fileHash", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_fileHash tLRPC$TL_fileHash = new TLRPC$TL_fileHash();
        tLRPC$TL_fileHash.readParams(abstractSerializedData, z);
        return tLRPC$TL_fileHash;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.offset = abstractSerializedData.readInt32(z);
        this.limit = abstractSerializedData.readInt32(z);
        this.hash = abstractSerializedData.readByteArray(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.offset);
        abstractSerializedData.writeInt32(this.limit);
        abstractSerializedData.writeByteArray(this.hash);
    }
}
