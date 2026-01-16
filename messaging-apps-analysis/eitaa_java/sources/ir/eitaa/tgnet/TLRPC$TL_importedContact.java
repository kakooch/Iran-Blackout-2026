package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_importedContact extends TLObject {
    public static int constructor = -1052885936;
    public long client_id;
    public long user_id;

    public static TLRPC$TL_importedContact TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_importedContact", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_importedContact tLRPC$TL_importedContact = new TLRPC$TL_importedContact();
        tLRPC$TL_importedContact.readParams(stream, exception);
        return tLRPC$TL_importedContact;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.user_id = stream.readInt64(exception);
        this.client_id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.user_id);
        stream.writeInt64(this.client_id);
    }
}
