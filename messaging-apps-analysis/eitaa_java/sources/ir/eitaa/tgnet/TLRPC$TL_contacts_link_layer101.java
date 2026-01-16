package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_contacts_link_layer101 extends TLObject {
    public static int constructor = 986597452;
    public TLRPC$ContactLink_layer101 foreign_link;
    public TLRPC$ContactLink_layer101 my_link;
    public TLRPC$User user;

    public static TLRPC$TL_contacts_link_layer101 TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_contacts_link", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_contacts_link_layer101 tLRPC$TL_contacts_link_layer101 = new TLRPC$TL_contacts_link_layer101();
        tLRPC$TL_contacts_link_layer101.readParams(stream, exception);
        return tLRPC$TL_contacts_link_layer101;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.my_link = TLRPC$ContactLink_layer101.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.foreign_link = TLRPC$ContactLink_layer101.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.user = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.my_link.serializeToStream(stream);
        this.foreign_link.serializeToStream(stream);
        this.user.serializeToStream(stream);
    }
}
