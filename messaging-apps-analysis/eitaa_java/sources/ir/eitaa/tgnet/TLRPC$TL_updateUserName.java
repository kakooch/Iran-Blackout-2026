package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateUserName extends TLRPC$Update {
    public static int constructor = -1007549728;
    public String first_name;
    public String last_name;
    public long user_id;
    public String username;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.user_id = stream.readInt64(exception);
        this.first_name = stream.readString(exception);
        this.last_name = stream.readString(exception);
        this.username = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.user_id);
        stream.writeString(this.first_name);
        stream.writeString(this.last_name);
        stream.writeString(this.username);
    }
}
