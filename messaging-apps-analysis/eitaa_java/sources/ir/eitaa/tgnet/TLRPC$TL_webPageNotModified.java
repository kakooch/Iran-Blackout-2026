package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_webPageNotModified extends TLRPC$WebPage {
    public static int constructor = 1930545681;
    public int cached_page_views;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.cached_page_views = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.cached_page_views);
        }
    }
}
