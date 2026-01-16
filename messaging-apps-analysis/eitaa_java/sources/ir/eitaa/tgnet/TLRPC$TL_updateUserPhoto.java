package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateUserPhoto extends TLRPC$Update {
    public static int constructor = -232290676;
    public int date;
    public TLRPC$UserProfilePhoto photo;
    public boolean previous;
    public long user_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.user_id = stream.readInt64(exception);
        this.date = stream.readInt32(exception);
        this.photo = TLRPC$UserProfilePhoto.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.previous = stream.readBool(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.user_id);
        stream.writeInt32(this.date);
        this.photo.serializeToStream(stream);
        stream.writeBool(this.previous);
    }
}
