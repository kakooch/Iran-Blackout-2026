package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_contacts_resolveUsername extends TLObject {
    public static int constructor = -113456221;
    public String username;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_contacts_resolvedPeer.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.username);
    }
}
