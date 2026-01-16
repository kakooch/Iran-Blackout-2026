package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockAudio extends TLRPC$PageBlock {
    public static int constructor = -2143067670;
    public long audio_id;
    public TLRPC$TL_pageCaption caption;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.audio_id = stream.readInt64(exception);
        this.caption = TLRPC$TL_pageCaption.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.audio_id);
        this.caption.serializeToStream(stream);
    }
}
