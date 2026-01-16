package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$account_Themes extends TLObject {
    public static TLRPC$account_Themes TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$account_Themes tLRPC$TL_account_themes;
        if (constructor == -1707242387) {
            tLRPC$TL_account_themes = new TLRPC$TL_account_themes();
        } else {
            tLRPC$TL_account_themes = constructor != -199313886 ? null : new TLRPC$account_Themes() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_themesNotModified
                public static int constructor = -199313886;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$TL_account_themes == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in account_Themes", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_account_themes != null) {
            tLRPC$TL_account_themes.readParams(stream, exception);
        }
        return tLRPC$TL_account_themes;
    }
}
