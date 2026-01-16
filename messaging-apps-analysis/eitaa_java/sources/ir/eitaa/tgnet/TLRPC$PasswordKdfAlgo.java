package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$PasswordKdfAlgo extends TLObject {
    public static TLRPC$PasswordKdfAlgo TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$PasswordKdfAlgo tLRPC$TL_passwordKdfAlgoUnknown;
        if (constructor == -732254058) {
            tLRPC$TL_passwordKdfAlgoUnknown = new TLRPC$TL_passwordKdfAlgoUnknown();
        } else {
            tLRPC$TL_passwordKdfAlgoUnknown = constructor != 982592842 ? null : new TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow();
        }
        if (tLRPC$TL_passwordKdfAlgoUnknown == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in PasswordKdfAlgo", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_passwordKdfAlgoUnknown != null) {
            tLRPC$TL_passwordKdfAlgoUnknown.readParams(stream, exception);
        }
        return tLRPC$TL_passwordKdfAlgoUnknown;
    }
}
