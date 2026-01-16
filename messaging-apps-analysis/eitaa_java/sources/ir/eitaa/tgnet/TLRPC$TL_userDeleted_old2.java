package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_userDeleted_old2 extends TLRPC$User {
    public static int constructor = -704549510;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt32(exception);
        this.first_name = stream.readString(exception);
        this.last_name = stream.readString(exception);
        this.username = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32((int) this.id);
        stream.writeString(this.first_name);
        stream.writeString(this.last_name);
        stream.writeString(this.username);
    }
}
