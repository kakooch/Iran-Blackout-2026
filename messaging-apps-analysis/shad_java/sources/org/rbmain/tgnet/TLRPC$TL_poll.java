package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_poll extends TLRPC$Poll {
    public static int constructor = -2032041631;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.id = abstractSerializedData.readInt64(z);
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.closed = (int32 & 1) != 0;
        this.public_voters = (int32 & 2) != 0;
        this.multiple_choice = (int32 & 4) != 0;
        this.quiz = (int32 & 8) != 0;
        this.question = abstractSerializedData.readString(z);
        int int322 = abstractSerializedData.readInt32(z);
        if (int322 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int323; i++) {
            TLRPC$TL_pollAnswer tLRPC$TL_pollAnswerTLdeserialize = TLRPC$TL_pollAnswer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_pollAnswerTLdeserialize == null) {
                return;
            }
            this.answers.add(tLRPC$TL_pollAnswerTLdeserialize);
        }
        if ((this.flags & 16) != 0) {
            this.close_period = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 32) != 0) {
            this.close_date = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt64(this.id);
        int i = this.closed ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.public_voters ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.multiple_choice ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        int i4 = this.quiz ? i3 | 8 : i3 & (-9);
        this.flags = i4;
        abstractSerializedData.writeInt32(i4);
        abstractSerializedData.writeString(this.question);
        abstractSerializedData.writeInt32(481674261);
        int size = this.answers.size();
        abstractSerializedData.writeInt32(size);
        for (int i5 = 0; i5 < size; i5++) {
            this.answers.get(i5).serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 16) != 0) {
            abstractSerializedData.writeInt32(this.close_period);
        }
        if ((this.flags & 32) != 0) {
            abstractSerializedData.writeInt32(this.close_date);
        }
    }
}
