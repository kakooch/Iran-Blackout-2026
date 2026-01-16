package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_botResults extends TLRPC$messages_BotResults {
    public static int constructor = -1803769784;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.gallery = (int32 & 1) != 0;
        this.query_id = stream.readInt64(exception);
        if ((this.flags & 2) != 0) {
            this.next_offset = stream.readString(exception);
        }
        if ((this.flags & 4) != 0) {
            this.switch_pm = TLRPC$TL_inlineBotSwitchPM.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$BotInlineResult tLRPC$BotInlineResultTLdeserialize = TLRPC$BotInlineResult.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$BotInlineResultTLdeserialize == null) {
                return;
            }
            this.results.add(tLRPC$BotInlineResultTLdeserialize);
        }
        this.cache_time = stream.readInt32(exception);
        int int324 = stream.readInt32(exception);
        if (int324 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
            }
            return;
        }
        int int325 = stream.readInt32(exception);
        for (int i2 = 0; i2 < int325; i2++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.gallery ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt64(this.query_id);
        if ((this.flags & 2) != 0) {
            stream.writeString(this.next_offset);
        }
        if ((this.flags & 4) != 0) {
            this.switch_pm.serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size = this.results.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.results.get(i2).serializeToStream(stream);
        }
        stream.writeInt32(this.cache_time);
        stream.writeInt32(481674261);
        int size2 = this.users.size();
        stream.writeInt32(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            this.users.get(i3).serializeToStream(stream);
        }
    }
}
