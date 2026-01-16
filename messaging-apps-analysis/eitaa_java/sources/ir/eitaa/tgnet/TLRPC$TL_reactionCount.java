package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_reactionCount extends TLObject {
    public static int constructor = 1873957073;
    public boolean chosen;
    public int count;
    public int flags;
    public String reaction;

    public static TLRPC$TL_reactionCount TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_reactionCount", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_reactionCount tLRPC$TL_reactionCount = new TLRPC$TL_reactionCount();
        tLRPC$TL_reactionCount.readParams(stream, exception);
        return tLRPC$TL_reactionCount;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.chosen = (int32 & 1) != 0;
        this.reaction = stream.readString(exception);
        this.count = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.chosen ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeString(this.reaction);
        stream.writeInt32(this.count);
    }
}
