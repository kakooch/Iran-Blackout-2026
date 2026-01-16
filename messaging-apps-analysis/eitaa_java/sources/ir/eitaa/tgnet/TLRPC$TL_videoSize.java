package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_videoSize extends TLRPC$VideoSize {
    public static int constructor = -567037804;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.type = stream.readString(exception);
        this.w = stream.readInt32(exception);
        this.h = stream.readInt32(exception);
        this.size = stream.readInt32(exception);
        if ((this.flags & 1) != 0) {
            this.video_start_ts = stream.readDouble(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeString(this.type);
        stream.writeInt32(this.w);
        stream.writeInt32(this.h);
        stream.writeInt32(this.size);
        if ((this.flags & 1) != 0) {
            stream.writeDouble(this.video_start_ts);
        }
    }
}
