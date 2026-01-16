package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$SecureRequiredType extends TLObject {
    public static TLRPC$SecureRequiredType TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$SecureRequiredType tLRPC$TL_secureRequiredType;
        if (constructor == -2103600678) {
            tLRPC$TL_secureRequiredType = new TLRPC$TL_secureRequiredType();
        } else {
            tLRPC$TL_secureRequiredType = constructor != 41187252 ? null : new TLRPC$TL_secureRequiredTypeOneOf();
        }
        if (tLRPC$TL_secureRequiredType == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in SecureRequiredType", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_secureRequiredType != null) {
            tLRPC$TL_secureRequiredType.readParams(stream, exception);
        }
        return tLRPC$TL_secureRequiredType;
    }
}
