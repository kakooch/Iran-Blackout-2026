package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pollAnswerVoters extends TLObject {
    public static int constructor = 997055186;
    public boolean chosen;
    public boolean correct;
    public int flags;
    public byte[] option;
    public int voters;

    public static TLRPC$TL_pollAnswerVoters TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_pollAnswerVoters", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_pollAnswerVoters tLRPC$TL_pollAnswerVoters = new TLRPC$TL_pollAnswerVoters();
        tLRPC$TL_pollAnswerVoters.readParams(stream, exception);
        return tLRPC$TL_pollAnswerVoters;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.chosen = (int32 & 1) != 0;
        this.correct = (int32 & 2) != 0;
        this.option = stream.readByteArray(exception);
        this.voters = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.chosen ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.correct ? i | 2 : i & (-3);
        this.flags = i2;
        stream.writeInt32(i2);
        stream.writeByteArray(this.option);
        stream.writeInt32(this.voters);
    }
}
