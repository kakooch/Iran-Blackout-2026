package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockPhoto extends TLRPC$PageBlock {
    public static int constructor = 391759200;
    public TLRPC$TL_pageCaption caption;
    public int flags;
    public long photo_id;
    public String url;
    public long webpage_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.photo_id = stream.readInt64(exception);
        this.caption = TLRPC$TL_pageCaption.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 1) != 0) {
            this.url = stream.readString(exception);
        }
        if ((this.flags & 1) != 0) {
            this.webpage_id = stream.readInt64(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt64(this.photo_id);
        this.caption.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.url);
        }
        if ((this.flags & 1) != 0) {
            stream.writeInt64(this.webpage_id);
        }
    }
}
