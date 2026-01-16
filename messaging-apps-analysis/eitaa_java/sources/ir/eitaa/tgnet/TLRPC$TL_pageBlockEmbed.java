package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockEmbed extends TLRPC$PageBlock {
    public static int constructor = -1468953147;
    public boolean allow_scrolling;
    public TLRPC$TL_pageCaption caption;
    public int flags;
    public boolean full_width;
    public int h;
    public String html;
    public long poster_photo_id;
    public String url;
    public int w;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.full_width = (int32 & 1) != 0;
        this.allow_scrolling = (int32 & 8) != 0;
        if ((int32 & 2) != 0) {
            this.url = stream.readString(exception);
        }
        if ((this.flags & 4) != 0) {
            this.html = stream.readString(exception);
        }
        if ((this.flags & 16) != 0) {
            this.poster_photo_id = stream.readInt64(exception);
        }
        if ((this.flags & 32) != 0) {
            this.w = stream.readInt32(exception);
        }
        if ((this.flags & 32) != 0) {
            this.h = stream.readInt32(exception);
        }
        this.caption = TLRPC$TL_pageCaption.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.full_width ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.allow_scrolling ? i | 8 : i & (-9);
        this.flags = i2;
        stream.writeInt32(i2);
        if ((this.flags & 2) != 0) {
            stream.writeString(this.url);
        }
        if ((this.flags & 4) != 0) {
            stream.writeString(this.html);
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt64(this.poster_photo_id);
        }
        if ((this.flags & 32) != 0) {
            stream.writeInt32(this.w);
        }
        if ((this.flags & 32) != 0) {
            stream.writeInt32(this.h);
        }
        this.caption.serializeToStream(stream);
    }
}
