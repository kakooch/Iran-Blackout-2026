package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$PollResults extends TLObject {
    public int flags;
    public boolean min;
    public String solution;
    public int total_voters;
    public ArrayList<TLRPC$TL_pollAnswerVoters> results = new ArrayList<>();
    public ArrayList<Integer> recent_voters = new ArrayList<>();
    public ArrayList<TLRPC$MessageEntity> solution_entities = new ArrayList<>();

    public static TLRPC$PollResults TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$PollResults tLRPC$TL_pollResults;
        if (i == -1159937629) {
            tLRPC$TL_pollResults = new TLRPC$TL_pollResults();
        } else if (i != -932174686) {
            tLRPC$TL_pollResults = i != 1465219162 ? null : new TLRPC$TL_pollResults() { // from class: org.rbmain.tgnet.TLRPC$TL_pollResults_layer108
                public static int constructor = 1465219162;

                @Override // org.rbmain.tgnet.TLRPC$TL_pollResults, org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    int int32 = abstractSerializedData2.readInt32(z2);
                    this.flags = int32;
                    this.min = (int32 & 1) != 0;
                    if ((int32 & 2) != 0) {
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$TL_pollAnswerVoters tLRPC$TL_pollAnswerVotersTLdeserialize = TLRPC$TL_pollAnswerVoters.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$TL_pollAnswerVotersTLdeserialize == null) {
                                return;
                            }
                            this.results.add(tLRPC$TL_pollAnswerVotersTLdeserialize);
                        }
                    }
                    if ((this.flags & 4) != 0) {
                        this.total_voters = abstractSerializedData2.readInt32(z2);
                    }
                }

                @Override // org.rbmain.tgnet.TLRPC$TL_pollResults, org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    int i2 = this.min ? this.flags | 1 : this.flags & (-2);
                    this.flags = i2;
                    abstractSerializedData2.writeInt32(i2);
                    if ((this.flags & 2) != 0) {
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.results.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i3 = 0; i3 < size; i3++) {
                            this.results.get(i3).serializeToStream(abstractSerializedData2);
                        }
                    }
                    if ((this.flags & 4) != 0) {
                        abstractSerializedData2.writeInt32(this.total_voters);
                    }
                }
            };
        } else {
            tLRPC$TL_pollResults = new TLRPC$PollResults() { // from class: org.rbmain.tgnet.TLRPC$TL_pollResults_layer111
                public static int constructor = -932174686;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    int int32 = abstractSerializedData2.readInt32(z2);
                    this.flags = int32;
                    this.min = (int32 & 1) != 0;
                    if ((int32 & 2) != 0) {
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$TL_pollAnswerVoters tLRPC$TL_pollAnswerVotersTLdeserialize = TLRPC$TL_pollAnswerVoters.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$TL_pollAnswerVotersTLdeserialize == null) {
                                return;
                            }
                            this.results.add(tLRPC$TL_pollAnswerVotersTLdeserialize);
                        }
                    }
                    if ((this.flags & 4) != 0) {
                        this.total_voters = abstractSerializedData2.readInt32(z2);
                    }
                    if ((this.flags & 8) != 0) {
                        int int324 = abstractSerializedData2.readInt32(z2);
                        if (int324 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                            }
                        } else {
                            int int325 = abstractSerializedData2.readInt32(z2);
                            for (int i3 = 0; i3 < int325; i3++) {
                                this.recent_voters.add(Integer.valueOf(abstractSerializedData2.readInt32(z2)));
                            }
                        }
                    }
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    int i2 = this.min ? this.flags | 1 : this.flags & (-2);
                    this.flags = i2;
                    abstractSerializedData2.writeInt32(i2);
                    if ((this.flags & 2) != 0) {
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.results.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i3 = 0; i3 < size; i3++) {
                            this.results.get(i3).serializeToStream(abstractSerializedData2);
                        }
                    }
                    if ((this.flags & 4) != 0) {
                        abstractSerializedData2.writeInt32(this.total_voters);
                    }
                    if ((this.flags & 8) != 0) {
                        abstractSerializedData2.writeInt32(481674261);
                        int size2 = this.recent_voters.size();
                        abstractSerializedData2.writeInt32(size2);
                        for (int i4 = 0; i4 < size2; i4++) {
                            abstractSerializedData2.writeInt32(this.recent_voters.get(i4).intValue());
                        }
                    }
                }
            };
        }
        if (tLRPC$TL_pollResults == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in PollResults", Integer.valueOf(i)));
        }
        if (tLRPC$TL_pollResults != null) {
            tLRPC$TL_pollResults.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_pollResults;
    }
}
