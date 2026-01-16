package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_pollResults extends TLRPC$PollResults {
    public static int constructor = -1159937629;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.min = (int32 & 1) != 0;
        if ((int32 & 2) != 0) {
            int int322 = abstractSerializedData.readInt32(z);
            if (int322 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < int323; i++) {
                TLRPC$TL_pollAnswerVoters tLRPC$TL_pollAnswerVotersTLdeserialize = TLRPC$TL_pollAnswerVoters.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$TL_pollAnswerVotersTLdeserialize == null) {
                    return;
                }
                this.results.add(tLRPC$TL_pollAnswerVotersTLdeserialize);
            }
        }
        if ((this.flags & 4) != 0) {
            this.total_voters = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 8) != 0) {
            int int324 = abstractSerializedData.readInt32(z);
            if (int324 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                }
                return;
            } else {
                int int325 = abstractSerializedData.readInt32(z);
                for (int i2 = 0; i2 < int325; i2++) {
                    this.recent_voters.add(Integer.valueOf(abstractSerializedData.readInt32(z)));
                }
            }
        }
        if ((this.flags & 16) != 0) {
            this.solution = abstractSerializedData.readString(z);
        }
        if ((this.flags & 16) != 0) {
            int int326 = abstractSerializedData.readInt32(z);
            if (int326 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int326)));
                }
                return;
            }
            int int327 = abstractSerializedData.readInt32(z);
            for (int i3 = 0; i3 < int327; i3++) {
                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$MessageEntityTLdeserialize == null) {
                    return;
                }
                this.solution_entities.add(tLRPC$MessageEntityTLdeserialize);
            }
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.min ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.results.size();
            abstractSerializedData.writeInt32(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.results.get(i2).serializeToStream(abstractSerializedData);
            }
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeInt32(this.total_voters);
        }
        if ((this.flags & 8) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size2 = this.recent_voters.size();
            abstractSerializedData.writeInt32(size2);
            for (int i3 = 0; i3 < size2; i3++) {
                abstractSerializedData.writeInt32(this.recent_voters.get(i3).intValue());
            }
        }
        if ((this.flags & 16) != 0) {
            abstractSerializedData.writeString(this.solution);
        }
        if ((this.flags & 16) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size3 = this.solution_entities.size();
            abstractSerializedData.writeInt32(size3);
            for (int i4 = 0; i4 < size3; i4++) {
                this.solution_entities.get(i4).serializeToStream(abstractSerializedData);
            }
        }
    }
}
