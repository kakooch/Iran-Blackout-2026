package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_photos_uploadProfilePhoto extends TLObject {
    public static int constructor = -1980559511;
    public TLRPC$InputFile file;
    public int flags;
    public TLRPC$InputFile video;
    public double video_start_ts;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_photos_photo.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            this.file.serializeToStream(stream);
        }
        if ((this.flags & 2) != 0) {
            this.video.serializeToStream(stream);
        }
        if ((this.flags & 4) != 0) {
            stream.writeDouble(this.video_start_ts);
        }
    }
}
