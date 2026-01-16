package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$ChatParticipants extends TLObject {
    public long admin_id;
    public long chat_id;
    public int flags;
    public ArrayList<TLRPC$ChatParticipant> participants = new ArrayList<>();
    public TLRPC$ChatParticipant self_participant;
    public int version;

    public static TLRPC$ChatParticipants TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$ChatParticipants tLRPC$TL_chatParticipantsForbidden;
        switch (constructor) {
            case -2023500831:
                tLRPC$TL_chatParticipantsForbidden = new TLRPC$TL_chatParticipantsForbidden();
                break;
            case -57668565:
                tLRPC$TL_chatParticipantsForbidden = new TLRPC$TL_chatParticipantsForbidden() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatParticipantsForbidden_layer131
                    public static int constructor = -57668565;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatParticipantsForbidden, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.chat_id = stream2.readInt32(exception2);
                        if ((this.flags & 1) != 0) {
                            this.self_participant = TLRPC$ChatParticipant.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatParticipantsForbidden, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeInt32((int) this.chat_id);
                        if ((this.flags & 1) != 0) {
                            this.self_participant.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 265468810:
                tLRPC$TL_chatParticipantsForbidden = new TLRPC$TL_chatParticipantsForbidden() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatParticipantsForbidden_old
                    public static int constructor = 265468810;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatParticipantsForbidden, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.chat_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatParticipantsForbidden, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.chat_id);
                    }
                };
                break;
            case 1018991608:
                tLRPC$TL_chatParticipantsForbidden = new TLRPC$TL_chatParticipants();
                break;
            case 1061556205:
                tLRPC$TL_chatParticipantsForbidden = new TLRPC$TL_chatParticipants() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatParticipants_layer131
                    public static int constructor = 1061556205;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatParticipants, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.chat_id = stream2.readInt32(exception2);
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$ChatParticipant tLRPC$ChatParticipantTLdeserialize = TLRPC$ChatParticipant.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$ChatParticipantTLdeserialize == null) {
                                return;
                            }
                            this.participants.add(tLRPC$ChatParticipantTLdeserialize);
                        }
                        this.version = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatParticipants, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.chat_id);
                        stream2.writeInt32(481674261);
                        int size = this.participants.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.participants.get(i).serializeToStream(stream2);
                        }
                        stream2.writeInt32(this.version);
                    }
                };
                break;
            case 2017571861:
                tLRPC$TL_chatParticipantsForbidden = new TLRPC$TL_chatParticipants() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatParticipants_old
                    public static int constructor = 2017571861;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatParticipants, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.chat_id = stream2.readInt32(exception2);
                        this.admin_id = stream2.readInt32(exception2);
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$ChatParticipant tLRPC$ChatParticipantTLdeserialize = TLRPC$ChatParticipant.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$ChatParticipantTLdeserialize == null) {
                                return;
                            }
                            this.participants.add(tLRPC$ChatParticipantTLdeserialize);
                        }
                        this.version = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatParticipants, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.chat_id);
                        stream2.writeInt32((int) this.admin_id);
                        stream2.writeInt32(481674261);
                        int size = this.participants.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.participants.get(i).serializeToStream(stream2);
                        }
                        stream2.writeInt32(this.version);
                    }
                };
                break;
            default:
                tLRPC$TL_chatParticipantsForbidden = null;
                break;
        }
        if (tLRPC$TL_chatParticipantsForbidden == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in ChatParticipants", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_chatParticipantsForbidden != null) {
            tLRPC$TL_chatParticipantsForbidden.readParams(stream, exception);
        }
        return tLRPC$TL_chatParticipantsForbidden;
    }
}
