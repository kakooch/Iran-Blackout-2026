package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_affectedFoundMessages extends TLObject {
    public static int constructor = -275956116;
    public ArrayList<Integer> messages = new ArrayList<>();
    public int offset;
    public int pts;
    public int pts_count;

    public static TLRPC$TL_messages_affectedFoundMessages TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_affectedFoundMessages", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_affectedFoundMessages tLRPC$TL_messages_affectedFoundMessages = new TLRPC$TL_messages_affectedFoundMessages();
        tLRPC$TL_messages_affectedFoundMessages.readParams(stream, exception);
        return tLRPC$TL_messages_affectedFoundMessages;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.pts = stream.readInt32(exception);
        this.pts_count = stream.readInt32(exception);
        this.offset = stream.readInt32(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
        } else {
            int int322 = stream.readInt32(exception);
            for (int i = 0; i < int322; i++) {
                this.messages.add(Integer.valueOf(stream.readInt32(exception)));
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.pts);
        stream.writeInt32(this.pts_count);
        stream.writeInt32(this.offset);
        stream.writeInt32(481674261);
        int size = this.messages.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeInt32(this.messages.get(i).intValue());
        }
    }
}
