package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_updateGroupCallParticipants extends TLRPC$Update {
    public static int constructor = -219423922;
    public TLRPC$TL_inputGroupCall call;
    public ArrayList<TLRPC$TL_groupCallParticipant> participants = new ArrayList<>();
    public int version;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream, stream.readInt32(exception), exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipantTLdeserialize = TLRPC$TL_groupCallParticipant.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_groupCallParticipantTLdeserialize == null) {
                return;
            }
            this.participants.add(tLRPC$TL_groupCallParticipantTLdeserialize);
        }
        this.version = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.call.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.participants.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.participants.get(i).serializeToStream(stream);
        }
        stream.writeInt32(this.version);
    }
}
