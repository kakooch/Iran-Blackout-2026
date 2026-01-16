package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockVideo extends TLRPC$PageBlock {
    public static int constructor = 2089805750;
    public boolean autoplay;
    public TLRPC$TL_pageCaption caption;
    public int flags;
    public boolean loop;
    public long video_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.autoplay = (int32 & 1) != 0;
        this.loop = (int32 & 2) != 0;
        this.video_id = stream.readInt64(exception);
        this.caption = TLRPC$TL_pageCaption.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.autoplay ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.loop ? i | 2 : i & (-3);
        this.flags = i2;
        stream.writeInt32(i2);
        stream.writeInt64(this.video_id);
        this.caption.serializeToStream(stream);
    }
}
