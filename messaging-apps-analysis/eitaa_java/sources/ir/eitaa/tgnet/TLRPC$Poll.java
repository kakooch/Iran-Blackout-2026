package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$Poll extends TLObject {
    public ArrayList<TLRPC$TL_pollAnswer> answers = new ArrayList<>();
    public int close_date;
    public int close_period;
    public boolean closed;
    public int flags;
    public long id;
    public boolean multiple_choice;
    public boolean public_voters;
    public String question;
    public boolean quiz;

    public static TLRPC$Poll TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$TL_poll tLRPC$TL_poll;
        if (constructor == -2032041631) {
            tLRPC$TL_poll = new TLRPC$TL_poll();
        } else if (constructor == -1351325818) {
            tLRPC$TL_poll = new TLRPC$TL_poll() { // from class: ir.eitaa.tgnet.TLRPC$TL_poll_toDelete
                public static int constructor = -1351325818;

                @Override // ir.eitaa.tgnet.TLRPC$TL_poll, ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.id = stream2.readInt64(exception2);
                    int int32 = stream2.readInt32(exception2);
                    this.flags = int32;
                    this.closed = (int32 & 1) != 0;
                    this.public_voters = (int32 & 2) != 0;
                    this.multiple_choice = (int32 & 4) != 0;
                    this.quiz = (int32 & 8) != 0;
                    this.question = stream2.readString(exception2);
                    int int322 = stream2.readInt32(exception2);
                    if (int322 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                        }
                        return;
                    }
                    int int323 = stream2.readInt32(exception2);
                    for (int i = 0; i < int323; i++) {
                        TLRPC$TL_pollAnswer tLRPC$TL_pollAnswerTLdeserialize = TLRPC$TL_pollAnswer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$TL_pollAnswerTLdeserialize == null) {
                            return;
                        }
                        this.answers.add(tLRPC$TL_pollAnswerTLdeserialize);
                    }
                    if ((this.flags & 16) != 0) {
                        this.close_date = stream2.readInt32(exception2);
                    }
                }

                @Override // ir.eitaa.tgnet.TLRPC$TL_poll, ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt64(this.id);
                    int i = this.closed ? this.flags | 1 : this.flags & (-2);
                    this.flags = i;
                    int i2 = this.public_voters ? i | 2 : i & (-3);
                    this.flags = i2;
                    int i3 = this.multiple_choice ? i2 | 4 : i2 & (-5);
                    this.flags = i3;
                    int i4 = this.quiz ? i3 | 8 : i3 & (-9);
                    this.flags = i4;
                    stream2.writeInt32(i4);
                    stream2.writeString(this.question);
                    stream2.writeInt32(481674261);
                    int size = this.answers.size();
                    stream2.writeInt32(size);
                    for (int i5 = 0; i5 < size; i5++) {
                        this.answers.get(i5).serializeToStream(stream2);
                    }
                    if ((this.flags & 16) != 0) {
                        stream2.writeInt32(this.close_date);
                    }
                }
            };
        } else {
            tLRPC$TL_poll = constructor != -716006138 ? null : new TLRPC$TL_poll() { // from class: ir.eitaa.tgnet.TLRPC$TL_poll_layer111
                public static int constructor = -716006138;

                @Override // ir.eitaa.tgnet.TLRPC$TL_poll, ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.id = stream2.readInt64(exception2);
                    int int32 = stream2.readInt32(exception2);
                    this.flags = int32;
                    this.closed = (int32 & 1) != 0;
                    this.public_voters = (int32 & 2) != 0;
                    this.multiple_choice = (int32 & 4) != 0;
                    this.quiz = (int32 & 8) != 0;
                    this.question = stream2.readString(exception2);
                    int int322 = stream2.readInt32(exception2);
                    if (int322 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                        }
                        return;
                    }
                    int int323 = stream2.readInt32(exception2);
                    for (int i = 0; i < int323; i++) {
                        TLRPC$TL_pollAnswer tLRPC$TL_pollAnswerTLdeserialize = TLRPC$TL_pollAnswer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$TL_pollAnswerTLdeserialize == null) {
                            return;
                        }
                        this.answers.add(tLRPC$TL_pollAnswerTLdeserialize);
                    }
                }

                @Override // ir.eitaa.tgnet.TLRPC$TL_poll, ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt64(this.id);
                    int i = this.closed ? this.flags | 1 : this.flags & (-2);
                    this.flags = i;
                    int i2 = this.public_voters ? i | 2 : i & (-3);
                    this.flags = i2;
                    int i3 = this.multiple_choice ? i2 | 4 : i2 & (-5);
                    this.flags = i3;
                    int i4 = this.quiz ? i3 | 8 : i3 & (-9);
                    this.flags = i4;
                    stream2.writeInt32(i4);
                    stream2.writeString(this.question);
                    stream2.writeInt32(481674261);
                    int size = this.answers.size();
                    stream2.writeInt32(size);
                    for (int i5 = 0; i5 < size; i5++) {
                        this.answers.get(i5).serializeToStream(stream2);
                    }
                }
            };
        }
        if (tLRPC$TL_poll == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Poll", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_poll != null) {
            tLRPC$TL_poll.readParams(stream, exception);
        }
        return tLRPC$TL_poll;
    }
}
