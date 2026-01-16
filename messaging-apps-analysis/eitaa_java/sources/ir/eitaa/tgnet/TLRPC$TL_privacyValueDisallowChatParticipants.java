package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_privacyValueDisallowChatParticipants extends TLRPC$PrivacyRule {
    public static int constructor = 1103656293;
    public ArrayList<Long> chats = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
        } else {
            int int322 = stream.readInt32(exception);
            for (int i = 0; i < int322; i++) {
                this.chats.add(Long.valueOf(stream.readInt64(exception)));
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.chats.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeInt64(this.chats.get(i).longValue());
        }
    }
}
