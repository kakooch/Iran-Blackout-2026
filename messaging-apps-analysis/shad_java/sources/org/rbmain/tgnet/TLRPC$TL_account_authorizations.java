package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_authorizations extends TLObject {
    public static int constructor = 307276766;
    public ArrayList<TLRPC$TL_authorization> authorizations = new ArrayList<>();
    public boolean canRemoveAll;

    public static TLRPC$TL_account_authorizations TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_account_authorizations", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_account_authorizations tLRPC$TL_account_authorizations = new TLRPC$TL_account_authorizations();
        tLRPC$TL_account_authorizations.readParams(abstractSerializedData, z);
        return tLRPC$TL_account_authorizations;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_authorization tLRPC$TL_authorizationTLdeserialize = TLRPC$TL_authorization.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_authorizationTLdeserialize == null) {
                return;
            }
            this.authorizations.add(tLRPC$TL_authorizationTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(481674261);
        int size = this.authorizations.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.authorizations.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
