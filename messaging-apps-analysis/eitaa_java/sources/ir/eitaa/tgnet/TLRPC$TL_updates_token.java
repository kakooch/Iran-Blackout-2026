package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updates_token extends TLObject {
    public static int constructor = -1519642063;
    public int date;
    public int expire;
    public String token;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.token = stream.readString(exception);
        this.expire = stream.readInt32(exception);
        this.date = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.token);
        stream.writeInt32(this.expire);
        stream.writeInt32(this.date);
    }
}
