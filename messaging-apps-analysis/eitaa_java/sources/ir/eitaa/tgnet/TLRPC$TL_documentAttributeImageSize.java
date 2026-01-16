package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_documentAttributeImageSize extends TLRPC$DocumentAttribute {
    public static int constructor = 1815593308;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.w = stream.readInt32(exception);
        this.h = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.w);
        stream.writeInt32(this.h);
    }
}
