package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_updateDeleteChannelMessages extends TLRPC$Update {
    public static int constructor = -1020437742;
    public long channel_id;
    public ArrayList<Integer> messages = new ArrayList<>();
    public int pts;
    public int pts_count;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.channel_id = stream.readInt64(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            this.messages.add(Integer.valueOf(stream.readInt32(exception)));
        }
        this.pts = stream.readInt32(exception);
        this.pts_count = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.channel_id);
        stream.writeInt32(481674261);
        int size = this.messages.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeInt32(this.messages.get(i).intValue());
        }
        stream.writeInt32(this.pts);
        stream.writeInt32(this.pts_count);
    }
}
