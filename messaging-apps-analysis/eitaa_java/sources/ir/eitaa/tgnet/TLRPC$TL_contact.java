package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_contact extends TLObject {
    public static int constructor = 341499403;
    public boolean mutual;
    public long user_id;

    public static TLRPC$TL_contact TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_contact", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_contact tLRPC$TL_contact = new TLRPC$TL_contact();
        tLRPC$TL_contact.readParams(stream, exception);
        return tLRPC$TL_contact;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.user_id = stream.readInt64(exception);
        this.mutual = stream.readBool(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.user_id);
        stream.writeBool(this.mutual);
    }
}
