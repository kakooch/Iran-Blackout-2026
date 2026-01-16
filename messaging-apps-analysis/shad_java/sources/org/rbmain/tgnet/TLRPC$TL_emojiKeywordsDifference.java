package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_emojiKeywordsDifference extends TLObject {
    public static int constructor = 1556570557;
    public int from_version;
    public ArrayList<TLRPC$EmojiKeyword> keywords = new ArrayList<>();
    public String lang_code;
    public int version;

    public static TLRPC$TL_emojiKeywordsDifference TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_emojiKeywordsDifference", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_emojiKeywordsDifference tLRPC$TL_emojiKeywordsDifference = new TLRPC$TL_emojiKeywordsDifference();
        tLRPC$TL_emojiKeywordsDifference.readParams(abstractSerializedData, z);
        return tLRPC$TL_emojiKeywordsDifference;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.lang_code = abstractSerializedData.readString(z);
        this.from_version = abstractSerializedData.readInt32(z);
        this.version = abstractSerializedData.readInt32(z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$EmojiKeyword tLRPC$EmojiKeywordTLdeserialize = TLRPC$EmojiKeyword.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$EmojiKeywordTLdeserialize == null) {
                return;
            }
            this.keywords.add(tLRPC$EmojiKeywordTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.lang_code);
        abstractSerializedData.writeInt32(this.from_version);
        abstractSerializedData.writeInt32(this.version);
        abstractSerializedData.writeInt32(481674261);
        int size = this.keywords.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.keywords.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
