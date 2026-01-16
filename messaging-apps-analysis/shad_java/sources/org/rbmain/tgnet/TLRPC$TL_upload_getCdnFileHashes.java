package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_upload_getCdnFileHashes extends TLObject {
    public static int constructor = 1302676017;
    public byte[] file_token;
    public int offset;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
        int int32 = abstractSerializedData.readInt32(z);
        for (int i2 = 0; i2 < int32; i2++) {
            TLRPC$TL_fileHash tLRPC$TL_fileHashTLdeserialize = TLRPC$TL_fileHash.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_fileHashTLdeserialize == null) {
                return tLRPC$Vector;
            }
            tLRPC$Vector.objects.add(tLRPC$TL_fileHashTLdeserialize);
        }
        return tLRPC$Vector;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeByteArray(this.file_token);
        abstractSerializedData.writeInt32(this.offset);
    }
}
