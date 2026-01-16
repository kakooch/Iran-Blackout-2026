package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockAnchor extends TLRPC$PageBlock {
    public static int constructor = -837994576;
    public String name;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.name = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.name);
    }
}
