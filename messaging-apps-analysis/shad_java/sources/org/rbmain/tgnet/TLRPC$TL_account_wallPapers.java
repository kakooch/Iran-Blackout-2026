package org.rbmain.tgnet;

import java.util.ArrayList;
import org.rbmain.ui.WallpapersListActivity;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_wallPapers extends TLRPC$account_WallPapers {
    public static int constructor = 1881892265;
    public int hash;
    public ArrayList<TLRPC$WallPaper> wallpapers = new ArrayList<>();
    public ArrayList<WallpapersListActivity.ColorWallpaper> colors = new ArrayList<>();

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.hash = abstractSerializedData.readInt32(z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$WallPaper tLRPC$WallPaperTLdeserialize = TLRPC$WallPaper.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$WallPaperTLdeserialize == null) {
                return;
            }
            this.wallpapers.add(tLRPC$WallPaperTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.hash);
        abstractSerializedData.writeInt32(481674261);
        int size = this.wallpapers.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.wallpapers.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
