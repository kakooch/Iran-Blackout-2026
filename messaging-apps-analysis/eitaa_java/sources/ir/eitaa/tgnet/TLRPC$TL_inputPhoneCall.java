package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputPhoneCall extends TLObject {
    public static int constructor = 506920429;
    public long access_hash;
    public long id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt64(exception);
        this.access_hash = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
        stream.writeInt64(this.access_hash);
    }
}
