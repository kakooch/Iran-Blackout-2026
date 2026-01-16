package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_botInfo extends TLRPC$BotInfo {
    public static int constructor = -1729618630;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = abstractSerializedData.readInt32(z);
        this.description = abstractSerializedData.readString(z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_botCommand tLRPC$TL_botCommandTLdeserialize = TLRPC$TL_botCommand.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_botCommandTLdeserialize == null) {
                return;
            }
            this.commands.add(tLRPC$TL_botCommandTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.user_id);
        abstractSerializedData.writeString(this.description);
        abstractSerializedData.writeInt32(481674261);
        int size = this.commands.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.commands.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
