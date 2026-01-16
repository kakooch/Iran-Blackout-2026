package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$SecurePasswordKdfAlgo extends TLObject {
    public static TLRPC$SecurePasswordKdfAlgo TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$SecurePasswordKdfAlgo tLRPC$TL_securePasswordKdfAlgoSHA512;
        if (constructor == -2042159726) {
            tLRPC$TL_securePasswordKdfAlgoSHA512 = new TLRPC$TL_securePasswordKdfAlgoSHA512();
        } else if (constructor == -1141711456) {
            tLRPC$TL_securePasswordKdfAlgoSHA512 = new TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000();
        } else {
            tLRPC$TL_securePasswordKdfAlgoSHA512 = constructor != 4883767 ? null : new TLRPC$TL_securePasswordKdfAlgoUnknown();
        }
        if (tLRPC$TL_securePasswordKdfAlgoSHA512 == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in SecurePasswordKdfAlgo", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_securePasswordKdfAlgoSHA512 != null) {
            tLRPC$TL_securePasswordKdfAlgoSHA512.readParams(stream, exception);
        }
        return tLRPC$TL_securePasswordKdfAlgoSHA512;
    }
}
