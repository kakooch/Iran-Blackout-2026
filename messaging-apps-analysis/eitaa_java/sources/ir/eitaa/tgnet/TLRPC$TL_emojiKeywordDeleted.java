package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_emojiKeywordDeleted extends TLRPC$EmojiKeyword {
    public static int constructor = 594408994;
    public ArrayList<String> emoticons = new ArrayList<>();
    public String keyword;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.keyword = stream.readString(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
        } else {
            int int322 = stream.readInt32(exception);
            for (int i = 0; i < int322; i++) {
                this.emoticons.add(stream.readString(exception));
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.keyword);
        stream.writeInt32(481674261);
        int size = this.emoticons.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeString(this.emoticons.get(i));
        }
    }
}
