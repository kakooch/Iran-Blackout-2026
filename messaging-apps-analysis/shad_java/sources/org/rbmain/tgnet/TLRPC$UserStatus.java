package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$UserStatus extends TLObject {
    public int expires;

    public static TLRPC$UserStatus TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$UserStatus tLRPC$TL_userStatusRecently;
        switch (i) {
            case -496024847:
                tLRPC$TL_userStatusRecently = new TLRPC$TL_userStatusRecently();
                break;
            case -306628279:
                tLRPC$TL_userStatusRecently = new TLRPC$TL_userStatusOnline();
                break;
            case 9203775:
                tLRPC$TL_userStatusRecently = new TLRPC$TL_userStatusOffline();
                break;
            case 129960444:
                tLRPC$TL_userStatusRecently = new TLRPC$TL_userStatusLastWeek();
                break;
            case 164646985:
                tLRPC$TL_userStatusRecently = new TLRPC$TL_userStatusEmpty();
                break;
            case 2011940674:
                tLRPC$TL_userStatusRecently = new TLRPC$TL_userStatusLastMonth();
                break;
            default:
                tLRPC$TL_userStatusRecently = null;
                break;
        }
        if (tLRPC$TL_userStatusRecently == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in UserStatus", Integer.valueOf(i)));
        }
        if (tLRPC$TL_userStatusRecently != null) {
            tLRPC$TL_userStatusRecently.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_userStatusRecently;
    }
}
