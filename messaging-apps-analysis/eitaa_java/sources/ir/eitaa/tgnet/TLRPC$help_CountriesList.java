package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$help_CountriesList extends TLObject {
    public static TLRPC$help_CountriesList TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$help_CountriesList tLRPC$TL_help_countriesList;
        if (constructor != -2016381538) {
            tLRPC$TL_help_countriesList = constructor != -1815339214 ? null : new TLRPC$help_CountriesList() { // from class: ir.eitaa.tgnet.TLRPC$TL_help_countriesListNotModified
                public static int constructor = -1815339214;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_help_countriesList = new TLRPC$TL_help_countriesList();
        }
        if (tLRPC$TL_help_countriesList == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in help_CountriesList", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_help_countriesList != null) {
            tLRPC$TL_help_countriesList.readParams(stream, exception);
        }
        return tLRPC$TL_help_countriesList;
    }
}
