package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$help_PromoData extends TLObject {
    public static TLRPC$help_PromoData TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$help_PromoData tLRPC$TL_help_promoData;
        if (constructor == -1942390465) {
            tLRPC$TL_help_promoData = new TLRPC$TL_help_promoData();
        } else {
            tLRPC$TL_help_promoData = constructor != -1728664459 ? null : new TLRPC$TL_help_promoDataEmpty();
        }
        if (tLRPC$TL_help_promoData == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in help_PromoData", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_help_promoData != null) {
            tLRPC$TL_help_promoData.readParams(stream, exception);
        }
        return tLRPC$TL_help_promoData;
    }
}
