package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pollResults extends TLRPC$PollResults {
    public static int constructor = -591909213;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.min = (int32 & 1) != 0;
        if ((int32 & 2) != 0) {
            int int322 = stream.readInt32(exception);
            if (int322 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = stream.readInt32(exception);
            for (int i = 0; i < int323; i++) {
                TLRPC$TL_pollAnswerVoters tLRPC$TL_pollAnswerVotersTLdeserialize = TLRPC$TL_pollAnswerVoters.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$TL_pollAnswerVotersTLdeserialize == null) {
                    return;
                }
                this.results.add(tLRPC$TL_pollAnswerVotersTLdeserialize);
            }
        }
        if ((this.flags & 4) != 0) {
            this.total_voters = stream.readInt32(exception);
        }
        if ((this.flags & 8) != 0) {
            int int324 = stream.readInt32(exception);
            if (int324 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                }
                return;
            } else {
                int int325 = stream.readInt32(exception);
                for (int i2 = 0; i2 < int325; i2++) {
                    this.recent_voters.add(Long.valueOf(stream.readInt64(exception)));
                }
            }
        }
        if ((this.flags & 16) != 0) {
            this.solution = stream.readString(exception);
        }
        if ((this.flags & 16) != 0) {
            int int326 = stream.readInt32(exception);
            if (int326 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int326)));
                }
                return;
            }
            int int327 = stream.readInt32(exception);
            for (int i3 = 0; i3 < int327; i3++) {
                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$MessageEntityTLdeserialize == null) {
                    return;
                }
                this.solution_entities.add(tLRPC$MessageEntityTLdeserialize);
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.min ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        if ((this.flags & 2) != 0) {
            stream.writeInt32(481674261);
            int size = this.results.size();
            stream.writeInt32(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.results.get(i2).serializeToStream(stream);
            }
        }
        if ((this.flags & 4) != 0) {
            stream.writeInt32(this.total_voters);
        }
        if ((this.flags & 8) != 0) {
            stream.writeInt32(481674261);
            int size2 = this.recent_voters.size();
            stream.writeInt32(size2);
            for (int i3 = 0; i3 < size2; i3++) {
                stream.writeInt64(this.recent_voters.get(i3).longValue());
            }
        }
        if ((this.flags & 16) != 0) {
            stream.writeString(this.solution);
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt32(481674261);
            int size3 = this.solution_entities.size();
            stream.writeInt32(size3);
            for (int i4 = 0; i4 < size3; i4++) {
                this.solution_entities.get(i4).serializeToStream(stream);
            }
        }
    }
}
