package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_chatParticipants extends TLRPC$ChatParticipants {
    public static int constructor = 1061556205;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.chat_id = abstractSerializedData.readInt32(z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$ChatParticipant tLRPC$ChatParticipantTLdeserialize = TLRPC$ChatParticipant.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$ChatParticipantTLdeserialize == null) {
                return;
            }
            this.participants.add(tLRPC$ChatParticipantTLdeserialize);
        }
        this.version = abstractSerializedData.readInt32(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.chat_id);
        abstractSerializedData.writeInt32(481674261);
        int size = this.participants.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.participants.get(i).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(this.version);
    }
}
