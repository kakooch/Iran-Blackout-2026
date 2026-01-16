package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_emojiKeywordsDifference extends TLObject {
    public static int constructor = 1556570557;
    public int from_version;
    public ArrayList<TLRPC$EmojiKeyword> keywords = new ArrayList<>();
    public String lang_code;
    public int version;

    public static TLRPC$TL_emojiKeywordsDifference TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_emojiKeywordsDifference", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_emojiKeywordsDifference tLRPC$TL_emojiKeywordsDifference = new TLRPC$TL_emojiKeywordsDifference();
        tLRPC$TL_emojiKeywordsDifference.readParams(stream, exception);
        return tLRPC$TL_emojiKeywordsDifference;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.lang_code = stream.readString(exception);
        this.from_version = stream.readInt32(exception);
        this.version = stream.readInt32(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$EmojiKeyword tLRPC$EmojiKeywordTLdeserialize = TLRPC$EmojiKeyword.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$EmojiKeywordTLdeserialize == null) {
                return;
            }
            this.keywords.add(tLRPC$EmojiKeywordTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.lang_code);
        stream.writeInt32(this.from_version);
        stream.writeInt32(this.version);
        stream.writeInt32(481674261);
        int size = this.keywords.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.keywords.get(i).serializeToStream(stream);
        }
    }
}
