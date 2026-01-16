package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_chatParticipants extends TLRPC$ChatParticipants {
    public static int constructor = 1018991608;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.chat_id = stream.readInt64(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$ChatParticipant tLRPC$ChatParticipantTLdeserialize = TLRPC$ChatParticipant.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$ChatParticipantTLdeserialize == null) {
                return;
            }
            this.participants.add(tLRPC$ChatParticipantTLdeserialize);
        }
        this.version = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.chat_id);
        stream.writeInt32(481674261);
        int size = this.participants.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.participants.get(i).serializeToStream(stream);
        }
        stream.writeInt32(this.version);
    }
}
