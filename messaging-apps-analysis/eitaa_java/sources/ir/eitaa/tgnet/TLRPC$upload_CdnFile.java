package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$upload_CdnFile extends TLObject {
    public NativeByteBuffer bytes;
    public byte[] request_token;

    public static TLRPC$upload_CdnFile TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$upload_CdnFile tLRPC$TL_upload_cdnFile;
        if (constructor == -1449145777) {
            tLRPC$TL_upload_cdnFile = new TLRPC$TL_upload_cdnFile();
        } else {
            tLRPC$TL_upload_cdnFile = constructor != -290921362 ? null : new TLRPC$upload_CdnFile() { // from class: ir.eitaa.tgnet.TLRPC$TL_upload_cdnFileReuploadNeeded
                public static int constructor = -290921362;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.request_token = stream2.readByteArray(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeByteArray(this.request_token);
                }
            };
        }
        if (tLRPC$TL_upload_cdnFile == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in upload_CdnFile", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_upload_cdnFile != null) {
            tLRPC$TL_upload_cdnFile.readParams(stream, exception);
        }
        return tLRPC$TL_upload_cdnFile;
    }
}
