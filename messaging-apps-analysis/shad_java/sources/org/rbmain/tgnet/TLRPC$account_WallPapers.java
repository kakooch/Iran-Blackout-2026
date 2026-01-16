package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$account_WallPapers extends TLObject {
    public static TLRPC$account_WallPapers TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$account_WallPapers tLRPC$TL_account_wallPapers;
        if (i == 471437699) {
            tLRPC$TL_account_wallPapers = new TLRPC$account_WallPapers() { // from class: org.rbmain.tgnet.TLRPC$TL_account_wallPapersNotModified
                public static int constructor = 471437699;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_account_wallPapers = i != 1881892265 ? null : new TLRPC$TL_account_wallPapers();
        }
        if (tLRPC$TL_account_wallPapers == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in account_WallPapers", Integer.valueOf(i)));
        }
        if (tLRPC$TL_account_wallPapers != null) {
            tLRPC$TL_account_wallPapers.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_account_wallPapers;
    }
}
