package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_Live_getParticipants extends TLObject {
    public static int constructor = -2008309847;
    public long access_hash;
    public long id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_Live_participants.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
        stream.writeInt64(this.access_hash);
    }
}
