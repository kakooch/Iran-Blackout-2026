package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$account_WallPapers extends TLObject {
    public static TLRPC$account_WallPapers TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$account_WallPapers tLRPC$TL_account_wallPapers;
        if (constructor != -842824308) {
            tLRPC$TL_account_wallPapers = constructor != 471437699 ? null : new TLRPC$account_WallPapers() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_wallPapersNotModified
                public static int constructor = 471437699;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_account_wallPapers = new TLRPC$TL_account_wallPapers();
        }
        if (tLRPC$TL_account_wallPapers == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in account_WallPapers", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_account_wallPapers != null) {
            tLRPC$TL_account_wallPapers.readParams(stream, exception);
        }
        return tLRPC$TL_account_wallPapers;
    }
}
