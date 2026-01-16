package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_chatParticipantCreator extends TLRPC$ChatParticipant {
    public static int constructor = -462696732;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.user_id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.user_id);
    }
}
