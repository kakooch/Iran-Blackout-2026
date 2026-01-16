package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_userForeign_old2 extends TLRPC$User {
    public static int constructor = 123533224;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt32(exception);
        this.first_name = stream.readString(exception);
        this.last_name = stream.readString(exception);
        this.username = stream.readString(exception);
        this.access_hash = stream.readInt64(exception);
        this.photo = TLRPC$UserProfilePhoto.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.status = TLRPC$UserStatus.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32((int) this.id);
        stream.writeString(this.first_name);
        stream.writeString(this.last_name);
        stream.writeString(this.username);
        stream.writeInt64(this.access_hash);
        this.photo.serializeToStream(stream);
        this.status.serializeToStream(stream);
    }
}
