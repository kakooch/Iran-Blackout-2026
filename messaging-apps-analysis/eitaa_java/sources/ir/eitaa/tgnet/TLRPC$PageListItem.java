package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$PageListItem extends TLObject {
    public static TLRPC$PageListItem TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$PageListItem tLRPC$TL_pageListItemText;
        if (constructor != -1188055347) {
            tLRPC$TL_pageListItemText = constructor != 635466748 ? null : new TLRPC$TL_pageListItemBlocks();
        } else {
            tLRPC$TL_pageListItemText = new TLRPC$TL_pageListItemText();
        }
        if (tLRPC$TL_pageListItemText == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in PageListItem", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_pageListItemText != null) {
            tLRPC$TL_pageListItemText.readParams(stream, exception);
        }
        return tLRPC$TL_pageListItemText;
    }
}
