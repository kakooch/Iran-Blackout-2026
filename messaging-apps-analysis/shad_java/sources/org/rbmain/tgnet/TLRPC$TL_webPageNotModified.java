package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_webPageNotModified extends TLRPC$WebPage {
    public static int constructor = 1930545681;
    public int cached_page_views;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.cached_page_views = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32(this.cached_page_views);
        }
    }
}
