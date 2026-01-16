package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_popularContact extends TLObject {
    public static int constructor = 1558266229;
    public long client_id;
    public int importers;

    public static TLRPC$TL_popularContact TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_popularContact", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_popularContact tLRPC$TL_popularContact = new TLRPC$TL_popularContact();
        tLRPC$TL_popularContact.readParams(stream, exception);
        return tLRPC$TL_popularContact;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.client_id = stream.readInt64(exception);
        this.importers = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.client_id);
        stream.writeInt32(this.importers);
    }
}
