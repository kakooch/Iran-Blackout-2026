package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockEmbedPost extends TLRPC$PageBlock {
    public static int constructor = -229005301;
    public String author;
    public long author_photo_id;
    public ArrayList<TLRPC$PageBlock> blocks = new ArrayList<>();
    public TLRPC$TL_pageCaption caption;
    public int date;
    public String url;
    public long webpage_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.url = stream.readString(exception);
        this.webpage_id = stream.readInt64(exception);
        this.author_photo_id = stream.readInt64(exception);
        this.author = stream.readString(exception);
        this.date = stream.readInt32(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$PageBlockTLdeserialize == null) {
                return;
            }
            this.blocks.add(tLRPC$PageBlockTLdeserialize);
        }
        this.caption = TLRPC$TL_pageCaption.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.url);
        stream.writeInt64(this.webpage_id);
        stream.writeInt64(this.author_photo_id);
        stream.writeString(this.author);
        stream.writeInt32(this.date);
        stream.writeInt32(481674261);
        int size = this.blocks.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.blocks.get(i).serializeToStream(stream);
        }
        this.caption.serializeToStream(stream);
    }
}
