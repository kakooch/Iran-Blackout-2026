package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageMediaVideo_layer45 extends TLRPC$MessageMedia {
    public static int constructor = 1540298357;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.video_unused = TLRPC$Video.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.captionLegacy = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.video_unused.serializeToStream(stream);
        stream.writeString(this.captionLegacy);
    }
}
