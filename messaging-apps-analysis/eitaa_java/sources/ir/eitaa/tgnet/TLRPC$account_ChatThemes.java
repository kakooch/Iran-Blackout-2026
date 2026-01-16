package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$account_ChatThemes extends TLObject {
    public static TLRPC$account_ChatThemes TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$account_ChatThemes tLRPC$TL_account_chatThemes;
        if (constructor == -535699004) {
            tLRPC$TL_account_chatThemes = new TLRPC$account_ChatThemes() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_chatThemesNotModified
                public static int constructor = -535699004;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_account_chatThemes = constructor != -28524867 ? null : new TLRPC$TL_account_chatThemes();
        }
        if (tLRPC$TL_account_chatThemes == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in account_ChatThemes", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_account_chatThemes != null) {
            tLRPC$TL_account_chatThemes.readParams(stream, exception);
        }
        return tLRPC$TL_account_chatThemes;
    }
}
