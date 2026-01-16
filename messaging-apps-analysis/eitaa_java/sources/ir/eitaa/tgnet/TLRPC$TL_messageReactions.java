package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messageReactions extends TLObject {
    public static int constructor = -1199954735;
    public int flags;
    public boolean min;
    public ArrayList<TLRPC$TL_reactionCount> results = new ArrayList<>();

    public static TLRPC$TL_messageReactions TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messageReactions", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messageReactions tLRPC$TL_messageReactions = new TLRPC$TL_messageReactions();
        tLRPC$TL_messageReactions.readParams(stream, exception);
        return tLRPC$TL_messageReactions;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.min = (int32 & 1) != 0;
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$TL_reactionCount tLRPC$TL_reactionCountTLdeserialize = TLRPC$TL_reactionCount.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_reactionCountTLdeserialize == null) {
                return;
            }
            this.results.add(tLRPC$TL_reactionCountTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.min ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt32(481674261);
        int size = this.results.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.results.get(i2).serializeToStream(stream);
        }
    }
}
