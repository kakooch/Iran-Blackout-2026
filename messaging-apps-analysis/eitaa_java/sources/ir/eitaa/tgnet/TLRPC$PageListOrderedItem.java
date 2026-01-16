package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$PageListOrderedItem extends TLObject {
    public static TLRPC$PageListOrderedItem TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$PageListOrderedItem tLRPC$TL_pageListOrderedItemBlocks;
        if (constructor != -1730311882) {
            tLRPC$TL_pageListOrderedItemBlocks = constructor != 1577484359 ? null : new TLRPC$TL_pageListOrderedItemText();
        } else {
            tLRPC$TL_pageListOrderedItemBlocks = new TLRPC$TL_pageListOrderedItemBlocks();
        }
        if (tLRPC$TL_pageListOrderedItemBlocks == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in PageListOrderedItem", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_pageListOrderedItemBlocks != null) {
            tLRPC$TL_pageListOrderedItemBlocks.readParams(stream, exception);
        }
        return tLRPC$TL_pageListOrderedItemBlocks;
    }
}
