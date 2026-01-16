package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_contacts_search extends TLObject {
    public static int constructor = 301470424;
    public int limit;
    public String q;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_contacts_found.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.q);
        stream.writeInt32(this.limit);
    }
}
