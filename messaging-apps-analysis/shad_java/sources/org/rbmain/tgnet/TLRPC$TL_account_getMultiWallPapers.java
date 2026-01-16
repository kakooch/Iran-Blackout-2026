package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_getMultiWallPapers extends TLObject {
    public static int constructor = 1705865692;
    public ArrayList<TLRPC$InputWallPaper> wallpapers = new ArrayList<>();

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
        int int32 = abstractSerializedData.readInt32(z);
        for (int i2 = 0; i2 < int32; i2++) {
            TLRPC$WallPaper tLRPC$WallPaperTLdeserialize = TLRPC$WallPaper.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$WallPaperTLdeserialize == null) {
                return tLRPC$Vector;
            }
            tLRPC$Vector.objects.add(tLRPC$WallPaperTLdeserialize);
        }
        return tLRPC$Vector;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(481674261);
        int size = this.wallpapers.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.wallpapers.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
