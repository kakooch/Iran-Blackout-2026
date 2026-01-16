package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_contacts_resetTopPeerRating extends TLObject {
    public static int constructor = 451113900;
    public TLRPC$TopPeerCategory category;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.category.serializeToStream(stream);
        this.peer.serializeToStream(stream);
    }
}
