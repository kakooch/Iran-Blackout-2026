package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputMediaPoll extends TLRPC$InputMedia {
    public static int constructor = 261416433;
    public TLRPC$Poll poll;
    public String solution;
    public ArrayList<byte[]> correct_answers = new ArrayList<>();
    public ArrayList<TLRPC$MessageEntity> solution_entities = new ArrayList<>();

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.flags = abstractSerializedData.readInt32(z);
        this.poll = TLRPC$Poll.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if ((this.flags & 1) != 0) {
            int int32 = abstractSerializedData.readInt32(z);
            if (int32 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                }
                return;
            } else {
                int int322 = abstractSerializedData.readInt32(z);
                for (int i = 0; i < int322; i++) {
                    this.correct_answers.add(abstractSerializedData.readByteArray(z));
                }
            }
        }
        if ((this.flags & 2) != 0) {
            this.solution = abstractSerializedData.readString(z);
        }
        if ((this.flags & 2) != 0) {
            int int323 = abstractSerializedData.readInt32(z);
            if (int323 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                }
                return;
            }
            int int324 = abstractSerializedData.readInt32(z);
            for (int i2 = 0; i2 < int324; i2++) {
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
        abstractSerializedData.writeInt32(this.flags);
        this.poll.serializeToStream(abstractSerializedData);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.correct_answers.size();
            abstractSerializedData.writeInt32(size);
            for (int i = 0; i < size; i++) {
                abstractSerializedData.writeByteArray(this.correct_answers.get(i));
            }
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeString(this.solution);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size2 = this.solution_entities.size();
            abstractSerializedData.writeInt32(size2);
            for (int i2 = 0; i2 < size2; i2++) {
                this.solution_entities.get(i2).serializeToStream(abstractSerializedData);
            }
        }
    }
}
