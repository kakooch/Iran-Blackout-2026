package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockRelatedArticles extends TLRPC$PageBlock {
    public static int constructor = 370236054;
    public ArrayList<TLRPC$TL_pageRelatedArticle> articles = new ArrayList<>();
    public TLRPC$RichText title;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.title = TLRPC$RichText.TLdeserialize(stream, stream.readInt32(exception), exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_pageRelatedArticle tLRPC$TL_pageRelatedArticleTLdeserialize = TLRPC$TL_pageRelatedArticle.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_pageRelatedArticleTLdeserialize == null) {
                return;
            }
            this.articles.add(tLRPC$TL_pageRelatedArticleTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.title.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.articles.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.articles.get(i).serializeToStream(stream);
        }
    }
}
