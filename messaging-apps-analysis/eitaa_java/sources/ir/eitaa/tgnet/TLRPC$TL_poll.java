package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_poll extends TLRPC$Poll {
    public static int constructor = -2032041631;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt64(exception);
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.closed = (int32 & 1) != 0;
        this.public_voters = (int32 & 2) != 0;
        this.multiple_choice = (int32 & 4) != 0;
        this.quiz = (int32 & 8) != 0;
        this.question = stream.readString(exception);
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$TL_pollAnswer tLRPC$TL_pollAnswerTLdeserialize = TLRPC$TL_pollAnswer.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_pollAnswerTLdeserialize == null) {
                return;
            }
            this.answers.add(tLRPC$TL_pollAnswerTLdeserialize);
        }
        if ((this.flags & 16) != 0) {
            this.close_period = stream.readInt32(exception);
        }
        if ((this.flags & 32) != 0) {
            this.close_date = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
        int i = this.closed ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.public_voters ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.multiple_choice ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        int i4 = this.quiz ? i3 | 8 : i3 & (-9);
        this.flags = i4;
        stream.writeInt32(i4);
        stream.writeString(this.question);
        stream.writeInt32(481674261);
        int size = this.answers.size();
        stream.writeInt32(size);
        for (int i5 = 0; i5 < size; i5++) {
            this.answers.get(i5).serializeToStream(stream);
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt32(this.close_period);
        }
        if ((this.flags & 32) != 0) {
            stream.writeInt32(this.close_date);
        }
    }
}
