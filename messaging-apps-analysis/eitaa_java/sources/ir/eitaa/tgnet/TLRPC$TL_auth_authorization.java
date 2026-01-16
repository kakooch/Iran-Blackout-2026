package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_auth_authorization extends TLRPC$auth_Authorization {
    public static int constructor = -855308010;
    public int flags;
    public int tmp_sessions;
    public String token;
    public TLRPC$User user;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.token = stream.readString(exception);
        if ((this.flags & 1) != 0) {
            this.tmp_sessions = stream.readInt32(exception);
        }
        this.user = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeString(this.token);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.tmp_sessions);
        }
        this.user.serializeToStream(stream);
    }
}
