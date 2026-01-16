package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_photoSize_layer127 extends TLRPC$TL_photoSize {
    public static int constructor = 2009052699;

    @Override // ir.eitaa.tgnet.TLRPC$TL_photoSize, ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.type = stream.readString(exception);
        this.location = TLRPC$FileLocation.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.w = stream.readInt32(exception);
        this.h = stream.readInt32(exception);
        this.size = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLRPC$TL_photoSize, ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.type);
        this.location.serializeToStream(stream);
        stream.writeInt32(this.w);
        stream.writeInt32(this.h);
        stream.writeInt32(this.size);
    }
}
