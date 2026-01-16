package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_deleteScheduledMessages extends TLObject {
    public static int constructor = 1504586518;
    public ArrayList<Integer> id = new ArrayList<>();
    public TLRPC$InputPeer peer;

    public static TLRPC$TL_messages_deleteScheduledMessages TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_deleteScheduledMessages", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_deleteScheduledMessages tLRPC$TL_messages_deleteScheduledMessages = new TLRPC$TL_messages_deleteScheduledMessages();
        tLRPC$TL_messages_deleteScheduledMessages.readParams(stream, exception);
        return tLRPC$TL_messages_deleteScheduledMessages;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$InputPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
        } else {
            int int322 = stream.readInt32(exception);
            for (int i = 0; i < int322; i++) {
                this.id.add(Integer.valueOf(stream.readInt32(exception)));
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.id.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeInt32(this.id.get(i).intValue());
        }
    }
}
