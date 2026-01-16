package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$PollResults extends TLObject {
    public int flags;
    public boolean min;
    public String solution;
    public int total_voters;
    public ArrayList<TLRPC$TL_pollAnswerVoters> results = new ArrayList<>();
    public ArrayList<Long> recent_voters = new ArrayList<>();
    public ArrayList<TLRPC$MessageEntity> solution_entities = new ArrayList<>();

    public static TLRPC$PollResults TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$PollResults tLRPC$TL_pollResults;
        switch (constructor) {
            case -1159937629:
                tLRPC$TL_pollResults = new TLRPC$TL_pollResults() { // from class: ir.eitaa.tgnet.TLRPC$TL_pollResults_layer131
                    public static int constructor = -1159937629;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pollResults, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.min = (int32 & 1) != 0;
                        if ((int32 & 2) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$TL_pollAnswerVoters tLRPC$TL_pollAnswerVotersTLdeserialize = TLRPC$TL_pollAnswerVoters.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$TL_pollAnswerVotersTLdeserialize == null) {
                                    return;
                                }
                                this.results.add(tLRPC$TL_pollAnswerVotersTLdeserialize);
                            }
                        }
                        if ((this.flags & 4) != 0) {
                            this.total_voters = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            int int324 = stream2.readInt32(exception2);
                            if (int324 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                                return;
                            } else {
                                int int325 = stream2.readInt32(exception2);
                                for (int i2 = 0; i2 < int325; i2++) {
                                    this.recent_voters.add(Long.valueOf(stream2.readInt32(exception2)));
                                }
                            }
                        }
                        if ((this.flags & 16) != 0) {
                            this.solution = stream2.readString(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            int int326 = stream2.readInt32(exception2);
                            if (int326 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int326)));
                                }
                                return;
                            }
                            int int327 = stream2.readInt32(exception2);
                            for (int i3 = 0; i3 < int327; i3++) {
                                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$MessageEntityTLdeserialize == null) {
                                    return;
                                }
                                this.solution_entities.add(tLRPC$MessageEntityTLdeserialize);
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pollResults, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.min ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.results.size();
                            stream2.writeInt32(size);
                            for (int i2 = 0; i2 < size; i2++) {
                                this.results.get(i2).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.total_voters);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(481674261);
                            int size2 = this.recent_voters.size();
                            stream2.writeInt32(size2);
                            for (int i3 = 0; i3 < size2; i3++) {
                                stream2.writeInt32((int) this.recent_voters.get(i3).longValue());
                            }
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeString(this.solution);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(481674261);
                            int size3 = this.solution_entities.size();
                            stream2.writeInt32(size3);
                            for (int i4 = 0; i4 < size3; i4++) {
                                this.solution_entities.get(i4).serializeToStream(stream2);
                            }
                        }
                    }
                };
                break;
            case -932174686:
                tLRPC$TL_pollResults = new TLRPC$PollResults() { // from class: ir.eitaa.tgnet.TLRPC$TL_pollResults_layer111
                    public static int constructor = -932174686;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.min = (int32 & 1) != 0;
                        if ((int32 & 2) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$TL_pollAnswerVoters tLRPC$TL_pollAnswerVotersTLdeserialize = TLRPC$TL_pollAnswerVoters.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$TL_pollAnswerVotersTLdeserialize == null) {
                                    return;
                                }
                                this.results.add(tLRPC$TL_pollAnswerVotersTLdeserialize);
                            }
                        }
                        if ((this.flags & 4) != 0) {
                            this.total_voters = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            int int324 = stream2.readInt32(exception2);
                            if (int324 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                                }
                            } else {
                                int int325 = stream2.readInt32(exception2);
                                for (int i2 = 0; i2 < int325; i2++) {
                                    this.recent_voters.add(Long.valueOf(stream2.readInt32(exception2)));
                                }
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.min ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.results.size();
                            stream2.writeInt32(size);
                            for (int i2 = 0; i2 < size; i2++) {
                                this.results.get(i2).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.total_voters);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(481674261);
                            int size2 = this.recent_voters.size();
                            stream2.writeInt32(size2);
                            for (int i3 = 0; i3 < size2; i3++) {
                                stream2.writeInt32((int) this.recent_voters.get(i3).longValue());
                            }
                        }
                    }
                };
                break;
            case -591909213:
                tLRPC$TL_pollResults = new TLRPC$TL_pollResults();
                break;
            case 1465219162:
                tLRPC$TL_pollResults = new TLRPC$TL_pollResults() { // from class: ir.eitaa.tgnet.TLRPC$TL_pollResults_layer108
                    public static int constructor = 1465219162;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pollResults, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.min = (int32 & 1) != 0;
                        if ((int32 & 2) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$TL_pollAnswerVoters tLRPC$TL_pollAnswerVotersTLdeserialize = TLRPC$TL_pollAnswerVoters.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$TL_pollAnswerVotersTLdeserialize == null) {
                                    return;
                                }
                                this.results.add(tLRPC$TL_pollAnswerVotersTLdeserialize);
                            }
                        }
                        if ((this.flags & 4) != 0) {
                            this.total_voters = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pollResults, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.min ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream2.writeInt32(i);
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.results.size();
                            stream2.writeInt32(size);
                            for (int i2 = 0; i2 < size; i2++) {
                                this.results.get(i2).serializeToStream(stream2);
                            }
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.total_voters);
                        }
                    }
                };
                break;
            default:
                tLRPC$TL_pollResults = null;
                break;
        }
        if (tLRPC$TL_pollResults == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in PollResults", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_pollResults != null) {
            tLRPC$TL_pollResults.readParams(stream, exception);
        }
        return tLRPC$TL_pollResults;
    }
}
