package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputMediaDocument extends TLRPC$InputMedia {
    public static int constructor = 860303448;
    public TLRPC$InputDocument id;
    public String query;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.id = TLRPC$InputDocument.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 1) != 0) {
            this.ttl_seconds = stream.readInt32(exception);
        }
        if ((this.flags & 2) != 0) {
            this.query = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.id.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.ttl_seconds);
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.query);
        }
    }
}
