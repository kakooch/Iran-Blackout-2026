package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_getEmojiKeywords extends TLObject {
    public static int constructor = 899735650;
    public String lang_code;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_emojiKeywordsDifference.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.lang_code);
    }
}
