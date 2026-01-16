package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$EmojiKeyword extends TLObject {
    public static TLRPC$EmojiKeyword TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$EmojiKeyword tLRPC$TL_emojiKeyword;
        if (constructor != -709641735) {
            tLRPC$TL_emojiKeyword = constructor != 594408994 ? null : new TLRPC$TL_emojiKeywordDeleted();
        } else {
            tLRPC$TL_emojiKeyword = new TLRPC$TL_emojiKeyword();
        }
        if (tLRPC$TL_emojiKeyword == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in EmojiKeyword", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_emojiKeyword != null) {
            tLRPC$TL_emojiKeyword.readParams(stream, exception);
        }
        return tLRPC$TL_emojiKeyword;
    }
}
