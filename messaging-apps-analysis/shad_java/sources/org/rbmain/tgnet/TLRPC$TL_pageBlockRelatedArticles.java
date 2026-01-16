package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_pageBlockRelatedArticles extends TLRPC$PageBlock {
    public static int constructor = 370236054;
    public ArrayList<TLRPC$TL_pageRelatedArticle> articles = new ArrayList<>();
    public TLRPC$RichText title;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.title = TLRPC$RichText.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_pageRelatedArticle tLRPC$TL_pageRelatedArticleTLdeserialize = TLRPC$TL_pageRelatedArticle.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_pageRelatedArticleTLdeserialize == null) {
                return;
            }
            this.articles.add(tLRPC$TL_pageRelatedArticleTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.title.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.articles.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.articles.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
