package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_chatParticipant extends TLRPC$ChatParticipant {
    public static int constructor = -1070776313;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.user_id = stream.readInt64(exception);
        this.inviter_id = stream.readInt64(exception);
        this.date = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.user_id);
        stream.writeInt64(this.inviter_id);
        stream.writeInt32(this.date);
    }
}
