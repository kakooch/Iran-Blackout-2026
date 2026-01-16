package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputGroupCallStream extends TLRPC$InputFileLocation {
    public static int constructor = 93890858;
    public TLRPC$TL_inputGroupCall call;
    public int flags;
    public int scale;
    public long time_ms;
    public int video_channel;
    public int video_quality;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.time_ms = stream.readInt64(exception);
        this.scale = stream.readInt32(exception);
        if ((this.flags & 1) != 0) {
            this.video_channel = stream.readInt32(exception);
        }
        if ((this.flags & 1) != 0) {
            this.video_quality = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.call.serializeToStream(stream);
        stream.writeInt64(this.time_ms);
        stream.writeInt32(this.scale);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.video_channel);
        }
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.video_quality);
        }
    }
}
