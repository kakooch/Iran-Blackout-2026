package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pageRelatedArticle extends TLObject {
    public static int constructor = -1282352120;
    public String author;
    public String description;
    public int flags;
    public long photo_id;
    public int published_date;
    public String title;
    public String url;
    public long webpage_id;

    public static TLRPC$TL_pageRelatedArticle TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_pageRelatedArticle", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_pageRelatedArticle tLRPC$TL_pageRelatedArticle = new TLRPC$TL_pageRelatedArticle();
        tLRPC$TL_pageRelatedArticle.readParams(stream, exception);
        return tLRPC$TL_pageRelatedArticle;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.url = stream.readString(exception);
        this.webpage_id = stream.readInt64(exception);
        if ((this.flags & 1) != 0) {
            this.title = stream.readString(exception);
        }
        if ((this.flags & 2) != 0) {
            this.description = stream.readString(exception);
        }
        if ((this.flags & 4) != 0) {
            this.photo_id = stream.readInt64(exception);
        }
        if ((this.flags & 8) != 0) {
            this.author = stream.readString(exception);
        }
        if ((this.flags & 16) != 0) {
            this.published_date = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeString(this.url);
        stream.writeInt64(this.webpage_id);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.title);
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.description);
        }
        if ((this.flags & 4) != 0) {
            stream.writeInt64(this.photo_id);
        }
        if ((this.flags & 8) != 0) {
            stream.writeString(this.author);
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt32(this.published_date);
        }
    }
}
