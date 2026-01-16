package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_webPagePending extends TLRPC$WebPage {
    public static int constructor = -981018084;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt64(exception);
        this.date = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
        stream.writeInt32(this.date);
    }
}
