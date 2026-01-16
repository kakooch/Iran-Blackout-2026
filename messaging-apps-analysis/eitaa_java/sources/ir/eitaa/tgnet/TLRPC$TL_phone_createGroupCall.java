package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_createGroupCall extends TLObject {
    public static int constructor = 1221445336;
    public int flags;
    public TLRPC$InputPeer peer;
    public int random_id;
    public int schedule_date;
    public String title;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.random_id);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.title);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.schedule_date);
        }
    }
}
