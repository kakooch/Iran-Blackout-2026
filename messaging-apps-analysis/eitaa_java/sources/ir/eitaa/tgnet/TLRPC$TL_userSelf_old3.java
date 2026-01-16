package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_userSelf_old3 extends TLRPC$User {
    public static int constructor = 476112392;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt32(exception);
        this.first_name = stream.readString(exception);
        this.last_name = stream.readString(exception);
        this.username = stream.readString(exception);
        this.phone = stream.readString(exception);
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
        stream.writeString(this.phone);
        this.photo.serializeToStream(stream);
        this.status.serializeToStream(stream);
    }
}
