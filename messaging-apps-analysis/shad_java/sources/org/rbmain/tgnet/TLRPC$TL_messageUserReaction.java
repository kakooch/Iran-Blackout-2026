package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messageUserReaction extends TLObject {
    public static int constructor = -764945220;
    public String reaction;
    public int user_id;

    public static TLRPC$TL_messageUserReaction TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messageUserReaction", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_messageUserReaction tLRPC$TL_messageUserReaction = new TLRPC$TL_messageUserReaction();
        tLRPC$TL_messageUserReaction.readParams(abstractSerializedData, z);
        return tLRPC$TL_messageUserReaction;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = abstractSerializedData.readInt32(z);
        this.reaction = abstractSerializedData.readString(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.user_id);
        abstractSerializedData.writeString(this.reaction);
    }
}
