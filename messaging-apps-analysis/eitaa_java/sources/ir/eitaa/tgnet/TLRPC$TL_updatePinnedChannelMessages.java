package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_updatePinnedChannelMessages extends TLRPC$Update {
    public static int constructor = 1538885128;
    public long channel_id;
    public int flags;
    public ArrayList<Integer> messages = new ArrayList<>();
    public boolean pinned;
    public int pts;
    public int pts_count;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.pinned = (int32 & 1) != 0;
        this.channel_id = stream.readInt64(exception);
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            this.messages.add(Integer.valueOf(stream.readInt32(exception)));
        }
        this.pts = stream.readInt32(exception);
        this.pts_count = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.pinned ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt64(this.channel_id);
        stream.writeInt32(481674261);
        int size = this.messages.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            stream.writeInt32(this.messages.get(i2).intValue());
        }
        stream.writeInt32(this.pts);
        stream.writeInt32(this.pts_count);
    }
}
