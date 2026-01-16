package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$account_Themes extends TLObject {
    public static TLRPC$account_Themes TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$account_Themes tLRPC$TL_account_themes;
        if (i != -199313886) {
            tLRPC$TL_account_themes = i != 2137482273 ? null : new TLRPC$TL_account_themes();
        } else {
            tLRPC$TL_account_themes = new TLRPC$account_Themes() { // from class: org.rbmain.tgnet.TLRPC$TL_account_themesNotModified
                public static int constructor = -199313886;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$TL_account_themes == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in account_Themes", Integer.valueOf(i)));
        }
        if (tLRPC$TL_account_themes != null) {
            tLRPC$TL_account_themes.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_account_themes;
    }
}
