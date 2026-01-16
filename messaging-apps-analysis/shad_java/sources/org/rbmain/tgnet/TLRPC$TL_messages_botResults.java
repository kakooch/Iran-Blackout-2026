package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_botResults extends TLRPC$messages_BotResults {
    public static int constructor = -1803769784;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.gallery = (int32 & 1) != 0;
        this.query_id = abstractSerializedData.readInt64(z);
        if ((this.flags & 2) != 0) {
            this.next_offset = abstractSerializedData.readString(z);
        }
        if ((this.flags & 4) != 0) {
            this.switch_pm = TLRPC$TL_inlineBotSwitchPM.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        int int322 = abstractSerializedData.readInt32(z);
        if (int322 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int323; i++) {
            TLRPC$BotInlineResult tLRPC$BotInlineResultTLdeserialize = TLRPC$BotInlineResult.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$BotInlineResultTLdeserialize == null) {
                return;
            }
            this.results.add(tLRPC$BotInlineResultTLdeserialize);
        }
        this.cache_time = abstractSerializedData.readInt32(z);
        int int324 = abstractSerializedData.readInt32(z);
        if (int324 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
            }
            return;
        }
        int int325 = abstractSerializedData.readInt32(z);
        for (int i2 = 0; i2 < int325; i2++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.gallery ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        abstractSerializedData.writeInt64(this.query_id);
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeString(this.next_offset);
        }
        if ((this.flags & 4) != 0) {
            this.switch_pm.serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size = this.results.size();
        abstractSerializedData.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.results.get(i2).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(this.cache_time);
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.users.size();
        abstractSerializedData.writeInt32(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            this.users.get(i3).serializeToStream(abstractSerializedData);
        }
    }
}
