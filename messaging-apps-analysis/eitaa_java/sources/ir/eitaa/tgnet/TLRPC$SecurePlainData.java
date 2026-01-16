package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$SecurePlainData extends TLObject {
    public static TLRPC$SecurePlainData TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$SecurePlainData tLRPC$TL_securePlainEmail;
        if (constructor == 569137759) {
            tLRPC$TL_securePlainEmail = new TLRPC$TL_securePlainEmail();
        } else {
            tLRPC$TL_securePlainEmail = constructor != 2103482845 ? null : new TLRPC$TL_securePlainPhone();
        }
        if (tLRPC$TL_securePlainEmail == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in SecurePlainData", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_securePlainEmail != null) {
            tLRPC$TL_securePlainEmail.readParams(stream, exception);
        }
        return tLRPC$TL_securePlainEmail;
    }
}
