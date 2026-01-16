package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$ChatParticipants extends TLObject {
    public int admin_id;
    public int chat_id;
    public int flags;
    public ArrayList<TLRPC$ChatParticipant> participants = new ArrayList<>();
    public TLRPC$ChatParticipant self_participant;
    public int version;

    public static TLRPC$ChatParticipants TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$ChatParticipants tLRPC$TL_chatParticipantsForbidden;
        switch (i) {
            case -57668565:
                tLRPC$TL_chatParticipantsForbidden = new TLRPC$TL_chatParticipantsForbidden();
                break;
            case 265468810:
                tLRPC$TL_chatParticipantsForbidden = new TLRPC$TL_chatParticipantsForbidden() { // from class: org.rbmain.tgnet.TLRPC$TL_chatParticipantsForbidden_old
                    public static int constructor = 265468810;

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatParticipantsForbidden, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.chat_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatParticipantsForbidden, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.chat_id);
                    }
                };
                break;
            case 1061556205:
                tLRPC$TL_chatParticipantsForbidden = new TLRPC$TL_chatParticipants();
                break;
            case 2017571861:
                tLRPC$TL_chatParticipantsForbidden = new TLRPC$TL_chatParticipants() { // from class: org.rbmain.tgnet.TLRPC$TL_chatParticipants_old
                    public static int constructor = 2017571861;

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatParticipants, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.chat_id = abstractSerializedData2.readInt32(z2);
                        this.admin_id = abstractSerializedData2.readInt32(z2);
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int322; i2++) {
                            TLRPC$ChatParticipant tLRPC$ChatParticipantTLdeserialize = TLRPC$ChatParticipant.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$ChatParticipantTLdeserialize == null) {
                                return;
                            }
                            this.participants.add(tLRPC$ChatParticipantTLdeserialize);
                        }
                        this.version = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_chatParticipants, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.chat_id);
                        abstractSerializedData2.writeInt32(this.admin_id);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.participants.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.participants.get(i2).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(this.version);
                    }
                };
                break;
            default:
                tLRPC$TL_chatParticipantsForbidden = null;
                break;
        }
        if (tLRPC$TL_chatParticipantsForbidden == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in ChatParticipants", Integer.valueOf(i)));
        }
        if (tLRPC$TL_chatParticipantsForbidden != null) {
            tLRPC$TL_chatParticipantsForbidden.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_chatParticipantsForbidden;
    }
}
