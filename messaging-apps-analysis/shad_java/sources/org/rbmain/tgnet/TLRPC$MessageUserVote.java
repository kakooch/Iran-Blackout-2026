package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$MessageUserVote extends TLObject {
    public int date;
    public int user_id;

    public static TLRPC$MessageUserVote TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$MessageUserVote tLRPC$TL_messageUserVote;
        if (i == -1567730343) {
            tLRPC$TL_messageUserVote = new TLRPC$TL_messageUserVote();
        } else if (i != 244310238) {
            tLRPC$TL_messageUserVote = i != 909603888 ? null : new TLRPC$TL_messageUserVoteInputOption();
        } else {
            tLRPC$TL_messageUserVote = new TLRPC$MessageUserVote() { // from class: org.rbmain.tgnet.TLRPC$TL_messageUserVoteMultiple
                public static int constructor = 244310238;
                public ArrayList<byte[]> options = new ArrayList<>();

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.user_id = abstractSerializedData2.readInt32(z2);
                    int int32 = abstractSerializedData2.readInt32(z2);
                    if (int32 != 481674261) {
                        if (z2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = abstractSerializedData2.readInt32(z2);
                    for (int i2 = 0; i2 < int322; i2++) {
                        this.options.add(abstractSerializedData2.readByteArray(z2));
                    }
                    this.date = abstractSerializedData2.readInt32(z2);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeInt32(this.user_id);
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.options.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        abstractSerializedData2.writeByteArray(this.options.get(i2));
                    }
                    abstractSerializedData2.writeInt32(this.date);
                }
            };
        }
        if (tLRPC$TL_messageUserVote == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageUserVote", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messageUserVote != null) {
            tLRPC$TL_messageUserVote.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_messageUserVote;
    }
}
