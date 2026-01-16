package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateUserPhone extends TLRPC$Update {
    public static int constructor = 88680979;
    public String phone;
    public long user_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.user_id = stream.readInt64(exception);
        this.phone = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.user_id);
        stream.writeString(this.phone);
    }
}
