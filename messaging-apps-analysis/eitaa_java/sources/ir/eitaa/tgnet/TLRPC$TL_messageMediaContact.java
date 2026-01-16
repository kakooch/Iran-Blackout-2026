package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageMediaContact extends TLRPC$MessageMedia {
    public static int constructor = 1882335561;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.phone_number = stream.readString(exception);
        this.first_name = stream.readString(exception);
        this.last_name = stream.readString(exception);
        this.vcard = stream.readString(exception);
        this.user_id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.phone_number);
        stream.writeString(this.first_name);
        stream.writeString(this.last_name);
        stream.writeString(this.vcard);
        stream.writeInt64(this.user_id);
    }
}
