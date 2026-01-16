package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_botInlineMessageMediaAuto extends TLRPC$BotInlineMessage {
    public static int constructor = 1984755728;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.flags = abstractSerializedData.readInt32(z);
        this.message = abstractSerializedData.readString(z);
        if ((this.flags & 2) != 0) {
            int int32 = abstractSerializedData.readInt32(z);
            if (int32 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                }
                return;
            }
            int int322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < int322; i++) {
                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$MessageEntityTLdeserialize == null) {
                    return;
                }
                this.entities.add(tLRPC$MessageEntityTLdeserialize);
            }
        }
        if ((this.flags & 4) != 0) {
            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        abstractSerializedData.writeString(this.message);
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.entities.size();
            abstractSerializedData.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.entities.get(i).serializeToStream(abstractSerializedData);
            }
        }
        if ((this.flags & 4) != 0) {
            this.reply_markup.serializeToStream(abstractSerializedData);
        }
    }
}
