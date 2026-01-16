package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_upload_reuploadCdnFile extends TLObject {
    public static int constructor = -1691921240;
    public byte[] file_token;
    public byte[] request_token;

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
        abstractSerializedData.writeByteArray(this.request_token);
    }
}
