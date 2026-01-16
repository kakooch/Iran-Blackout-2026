package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_contacts_acceptContact extends TLObject {
    public static int constructor = -130964977;
    public TLRPC$InputUser id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.id.serializeToStream(stream);
    }
}
