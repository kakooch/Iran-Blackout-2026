package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_upload_reuploadCdnFile extends TLObject {
    public static int constructor = -1691921240;
    public byte[] file_token;
    public byte[] request_token;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
        int int32 = stream.readInt32(exception);
        for (int i = 0; i < int32; i++) {
            TLRPC$TL_fileHash tLRPC$TL_fileHashTLdeserialize = TLRPC$TL_fileHash.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_fileHashTLdeserialize == null) {
                return tLRPC$Vector;
            }
            tLRPC$Vector.objects.add(tLRPC$TL_fileHashTLdeserialize);
        }
        return tLRPC$Vector;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeByteArray(this.file_token);
        stream.writeByteArray(this.request_token);
    }
}
