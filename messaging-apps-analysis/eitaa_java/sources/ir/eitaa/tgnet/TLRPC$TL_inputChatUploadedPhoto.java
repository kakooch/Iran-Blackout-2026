package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputChatUploadedPhoto extends TLRPC$InputChatPhoto {
    public static int constructor = -968723890;
    public TLRPC$InputFile file;
    public int flags;
    public TLRPC$InputFile video;
    public double video_start_ts;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.file = TLRPC$InputFile.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 2) != 0) {
            this.video = TLRPC$InputFile.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 4) != 0) {
            this.video_start_ts = stream.readDouble(exception);
        }
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
