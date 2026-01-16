package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_chatParticipantsForbidden extends TLRPC$ChatParticipants {
    public static int constructor = -2023500831;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.chat_id = stream.readInt64(exception);
        if ((this.flags & 1) != 0) {
            this.self_participant = TLRPC$ChatParticipant.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt64(this.chat_id);
        if ((this.flags & 1) != 0) {
            this.self_participant.serializeToStream(stream);
        }
    }
}
