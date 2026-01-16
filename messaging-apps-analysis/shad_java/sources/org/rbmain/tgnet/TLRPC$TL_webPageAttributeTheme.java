package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_webPageAttributeTheme extends TLObject {
    public static int constructor = 1421174295;
    public ArrayList<TLRPC$Document> documents = new ArrayList<>();
    public int flags;
    public TLRPC$TL_themeSettings settings;

    public static TLRPC$TL_webPageAttributeTheme TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_webPageAttributeTheme", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_webPageAttributeTheme tLRPC$TL_webPageAttributeTheme = new TLRPC$TL_webPageAttributeTheme();
        tLRPC$TL_webPageAttributeTheme.readParams(abstractSerializedData, z);
        return tLRPC$TL_webPageAttributeTheme;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            int int322 = abstractSerializedData.readInt32(z);
            if (int322 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < int323; i++) {
                TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$DocumentTLdeserialize == null) {
                    return;
                }
                this.documents.add(tLRPC$DocumentTLdeserialize);
            }
        }
        if ((this.flags & 2) != 0) {
            this.settings = TLRPC$TL_themeSettings.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.documents.size();
            abstractSerializedData.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.documents.get(i).serializeToStream(abstractSerializedData);
            }
        }
        if ((this.flags & 2) != 0) {
            this.settings.serializeToStream(abstractSerializedData);
        }
    }
}
