package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$account_ResetPasswordResult extends TLObject {
    public static TLRPC$account_ResetPasswordResult TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$account_ResetPasswordResult tLRPC$TL_account_resetPasswordFailedWait;
        if (constructor == -478701471) {
            tLRPC$TL_account_resetPasswordFailedWait = new TLRPC$TL_account_resetPasswordFailedWait();
        } else if (constructor != -383330754) {
            tLRPC$TL_account_resetPasswordFailedWait = constructor != -370148227 ? null : new TLRPC$TL_account_resetPasswordRequestedWait();
        } else {
            tLRPC$TL_account_resetPasswordFailedWait = new TLRPC$account_ResetPasswordResult() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_resetPasswordOk
                public static int constructor = -383330754;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$TL_account_resetPasswordFailedWait == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in account_ResetPasswordResult", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_account_resetPasswordFailedWait != null) {
            tLRPC$TL_account_resetPasswordFailedWait.readParams(stream, exception);
        }
        return tLRPC$TL_account_resetPasswordFailedWait;
    }
}
