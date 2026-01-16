package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_chatForbidden extends TLRPC$Chat {
    public static int constructor = 1704108455;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt64(exception);
        this.title = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
        stream.writeString(this.title);
    }
}
