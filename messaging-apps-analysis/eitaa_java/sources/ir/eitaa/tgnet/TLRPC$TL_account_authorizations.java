package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_account_authorizations extends TLObject {
    public static int constructor = 307276766;
    public ArrayList<TLRPC$TL_authorization> authorizations = new ArrayList<>();

    public static TLRPC$TL_account_authorizations TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_account_authorizations", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_account_authorizations tLRPC$TL_account_authorizations = new TLRPC$TL_account_authorizations();
        tLRPC$TL_account_authorizations.readParams(stream, exception);
        return tLRPC$TL_account_authorizations;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_authorization tLRPC$TL_authorizationTLdeserialize = TLRPC$TL_authorization.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_authorizationTLdeserialize == null) {
                return;
            }
            this.authorizations.add(tLRPC$TL_authorizationTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.authorizations.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.authorizations.get(i).serializeToStream(stream);
        }
    }
}
