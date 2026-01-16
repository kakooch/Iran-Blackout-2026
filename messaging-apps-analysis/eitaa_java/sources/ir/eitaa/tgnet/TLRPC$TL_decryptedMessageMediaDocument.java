package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_decryptedMessageMediaDocument extends TLRPC$DecryptedMessageMedia {
    public static int constructor = 2063502050;
    public byte[] thumb;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.thumb = stream.readByteArray(exception);
        this.thumb_w = stream.readInt32(exception);
        this.thumb_h = stream.readInt32(exception);
        this.mime_type = stream.readString(exception);
        this.size = stream.readInt32(exception);
        this.key = stream.readByteArray(exception);
        this.iv = stream.readByteArray(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttributeTLdeserialize = TLRPC$DocumentAttribute.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$DocumentAttributeTLdeserialize == null) {
                return;
            }
            this.attributes.add(tLRPC$DocumentAttributeTLdeserialize);
        }
        this.caption = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeByteArray(this.thumb);
        stream.writeInt32(this.thumb_w);
        stream.writeInt32(this.thumb_h);
        stream.writeString(this.mime_type);
        stream.writeInt32(this.size);
        stream.writeByteArray(this.key);
        stream.writeByteArray(this.iv);
        stream.writeInt32(481674261);
        int size = this.attributes.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.attributes.get(i).serializeToStream(stream);
        }
        stream.writeString(this.caption);
    }
}
