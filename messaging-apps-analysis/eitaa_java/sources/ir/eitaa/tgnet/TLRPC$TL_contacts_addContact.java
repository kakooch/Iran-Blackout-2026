package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_contacts_addContact extends TLObject {
    public static int constructor = -386636848;
    public boolean add_phone_privacy_exception;
    public String first_name;
    public int flags;
    public TLRPC$InputUser id;
    public String last_name;
    public String phone;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.add_phone_privacy_exception ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.id.serializeToStream(stream);
        stream.writeString(this.first_name);
        stream.writeString(this.last_name);
        stream.writeString(this.phone);
    }
}
