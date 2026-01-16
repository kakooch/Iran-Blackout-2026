package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$ChatParticipant extends TLObject {
    public int date;
    public int inviter_id;
    public int user_id;

    public static TLRPC$ChatParticipant TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$ChatParticipant tLRPC$TL_chatParticipant;
        if (i == -925415106) {
            tLRPC$TL_chatParticipant = new TLRPC$TL_chatParticipant();
        } else if (i == -636267638) {
            tLRPC$TL_chatParticipant = new TLRPC$ChatParticipant() { // from class: org.rbmain.tgnet.TLRPC$TL_chatParticipantCreator
                public static int constructor = -636267638;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.user_id = abstractSerializedData2.readInt32(z2);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeInt32(this.user_id);
                }
            };
        } else {
            tLRPC$TL_chatParticipant = i != -489233354 ? null : new TLRPC$TL_chatParticipantAdmin();
        }
        if (tLRPC$TL_chatParticipant == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in ChatParticipant", Integer.valueOf(i)));
        }
        if (tLRPC$TL_chatParticipant != null) {
            tLRPC$TL_chatParticipant.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_chatParticipant;
    }
}
