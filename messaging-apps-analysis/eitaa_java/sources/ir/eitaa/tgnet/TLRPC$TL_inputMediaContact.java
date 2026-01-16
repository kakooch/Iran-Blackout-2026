package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputMediaContact extends TLRPC$InputMedia {
    public static int constructor = -122978821;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.phone_number = stream.readString(exception);
        this.first_name = stream.readString(exception);
        this.last_name = stream.readString(exception);
        this.vcard = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.phone_number);
        stream.writeString(this.first_name);
        stream.writeString(this.last_name);
        stream.writeString(this.vcard);
    }
}
