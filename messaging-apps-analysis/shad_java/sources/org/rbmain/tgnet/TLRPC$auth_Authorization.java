package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$auth_Authorization extends TLObject {
    public static TLRPC$auth_Authorization TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$auth_Authorization tLRPC$TL_auth_authorization;
        if (i != -855308010) {
            tLRPC$TL_auth_authorization = i != 1148485274 ? null : new TLRPC$auth_Authorization() { // from class: org.rbmain.tgnet.TLRPC$TL_auth_authorizationSignUpRequired
                public static int constructor = 1148485274;
                public int flags;
                public TLRPC$TL_help_termsOfService terms_of_service;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    int int32 = abstractSerializedData2.readInt32(z2);
                    this.flags = int32;
                    if ((int32 & 1) != 0) {
                        this.terms_of_service = TLRPC$TL_help_termsOfService.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeInt32(this.flags);
                    if ((this.flags & 1) != 0) {
                        this.terms_of_service.serializeToStream(abstractSerializedData2);
                    }
                }
            };
        } else {
            tLRPC$TL_auth_authorization = new TLRPC$TL_auth_authorization();
        }
        if (tLRPC$TL_auth_authorization == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in auth_Authorization", Integer.valueOf(i)));
        }
        if (tLRPC$TL_auth_authorization != null) {
            tLRPC$TL_auth_authorization.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_auth_authorization;
    }
}
