package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_webPageEmpty extends TLRPC$WebPage {
    public static int constructor = -350980120;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
    }
}
