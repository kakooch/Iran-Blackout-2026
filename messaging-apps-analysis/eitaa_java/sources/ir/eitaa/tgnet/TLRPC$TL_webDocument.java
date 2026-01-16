package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_webDocument extends TLRPC$WebDocument {
    public static int constructor = 475467473;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.url = stream.readString(exception);
        this.access_hash = stream.readInt64(exception);
        this.size = stream.readInt32(exception);
        this.mime_type = stream.readString(exception);
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
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.url);
        stream.writeInt64(this.access_hash);
        stream.writeInt32(this.size);
        stream.writeString(this.mime_type);
        stream.writeInt32(481674261);
        int size = this.attributes.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.attributes.get(i).serializeToStream(stream);
        }
    }
}
