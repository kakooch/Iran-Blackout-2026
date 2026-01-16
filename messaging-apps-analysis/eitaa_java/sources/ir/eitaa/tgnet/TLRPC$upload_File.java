package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$upload_File extends TLObject {
    public NativeByteBuffer bytes;
    public int dc_id;
    public byte[] encryption_iv;
    public byte[] encryption_key;
    public ArrayList<TLRPC$TL_fileHash> file_hashes = new ArrayList<>();
    public byte[] file_token;
    public int mtime;
    public TLRPC$storage_FileType type;

    public static TLRPC$upload_File TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$upload_File tLRPC$TL_upload_file;
        if (constructor != -242427324) {
            tLRPC$TL_upload_file = constructor != 157948117 ? null : new TLRPC$TL_upload_file();
        } else {
            tLRPC$TL_upload_file = new TLRPC$upload_File() { // from class: ir.eitaa.tgnet.TLRPC$TL_upload_fileCdnRedirect
                public static int constructor = -242427324;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.dc_id = stream2.readInt32(exception2);
                    this.file_token = stream2.readByteArray(exception2);
                    this.encryption_key = stream2.readByteArray(exception2);
                    this.encryption_iv = stream2.readByteArray(exception2);
                    int int32 = stream2.readInt32(exception2);
                    if (int32 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = stream2.readInt32(exception2);
                    for (int i = 0; i < int322; i++) {
                        TLRPC$TL_fileHash tLRPC$TL_fileHashTLdeserialize = TLRPC$TL_fileHash.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$TL_fileHashTLdeserialize == null) {
                            return;
                        }
                        this.file_hashes.add(tLRPC$TL_fileHashTLdeserialize);
                    }
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.dc_id);
                    stream2.writeByteArray(this.file_token);
                    stream2.writeByteArray(this.encryption_key);
                    stream2.writeByteArray(this.encryption_iv);
                    stream2.writeInt32(481674261);
                    int size = this.file_hashes.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.file_hashes.get(i).serializeToStream(stream2);
                    }
                }
            };
        }
        if (tLRPC$TL_upload_file == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in upload_File", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_upload_file != null) {
            tLRPC$TL_upload_file.readParams(stream, exception);
        }
        return tLRPC$TL_upload_file;
    }
}
