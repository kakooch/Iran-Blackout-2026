package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_setCallRating extends TLObject {
    public static int constructor = 1508562471;
    public String comment;
    public int flags;
    public TLRPC$TL_inputPhoneCall peer;
    public int rating;
    public boolean user_initiative;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.user_initiative ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.rating);
        stream.writeString(this.comment);
    }
}
