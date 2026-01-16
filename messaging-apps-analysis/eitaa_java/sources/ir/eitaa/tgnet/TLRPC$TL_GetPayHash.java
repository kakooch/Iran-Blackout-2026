package ir.eitaa.tgnet;

import ir.eitaa.messenger.ApplicationLoader;

/* loaded from: classes.dex */
public class TLRPC$TL_GetPayHash extends TLObject {
    public static int constructor = -559038801;
    public int flag;
    public int msg_id;
    public TLRPC$Peer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (TLRPC$TL_UserPayHash.constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_GetPayHash", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_UserPayHash tLRPC$TL_UserPayHash = new TLRPC$TL_UserPayHash();
        tLRPC$TL_UserPayHash.readParams(stream, exception);
        return tLRPC$TL_UserPayHash;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        TLRPC$TL_AppInfo appInfo;
        try {
            appInfo = ApplicationLoader.getAppInfo();
        } catch (Exception unused) {
            appInfo = null;
        }
        if (appInfo != null) {
            this.flag |= 1;
        }
        stream.writeInt32(constructor);
        stream.writeInt32(this.flag);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.msg_id);
        if ((this.flag & 1) == 0 || appInfo == null) {
            return;
        }
        appInfo.serializeToStream(stream);
    }
}
