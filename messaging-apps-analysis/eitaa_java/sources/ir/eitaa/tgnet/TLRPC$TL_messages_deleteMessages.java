package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_deleteMessages extends TLObject {
    public static int constructor = -443640366;
    public int flags;
    public ArrayList<Integer> id = new ArrayList<>();
    public boolean revoke;

    public static TLRPC$TL_messages_deleteMessages TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_deleteMessages", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_deleteMessages tLRPC$TL_messages_deleteMessages = new TLRPC$TL_messages_deleteMessages();
        tLRPC$TL_messages_deleteMessages.readParams(stream, exception);
        return tLRPC$TL_messages_deleteMessages;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_messages_affectedMessages.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.revoke = (int32 & 1) != 0;
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
        } else {
            int int323 = stream.readInt32(exception);
            for (int i = 0; i < int323; i++) {
                this.id.add(Integer.valueOf(stream.readInt32(exception)));
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.revoke ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt32(481674261);
        int size = this.id.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            stream.writeInt32(this.id.get(i2).intValue());
        }
    }
}
