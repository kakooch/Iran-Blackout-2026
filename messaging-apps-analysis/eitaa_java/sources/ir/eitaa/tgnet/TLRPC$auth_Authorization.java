package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$auth_Authorization extends TLObject {
    public static TLRPC$auth_Authorization TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$auth_Authorization tLRPC$TL_auth_authorization;
        if (constructor != -855308010) {
            tLRPC$TL_auth_authorization = constructor != 1148485274 ? null : new TLRPC$TL_auth_authorizationSignUpRequired();
        } else {
            tLRPC$TL_auth_authorization = new TLRPC$TL_auth_authorization();
        }
        if (tLRPC$TL_auth_authorization == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in auth_Authorization", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_auth_authorization != null) {
            tLRPC$TL_auth_authorization.readParams(stream, exception);
        }
        return tLRPC$TL_auth_authorization;
    }
}
