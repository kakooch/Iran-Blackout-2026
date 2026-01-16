package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_chatEmpty extends TLRPC$Chat {
    public static int constructor = 693512293;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt64(exception);
        this.title = "DELETED";
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
    }
}
