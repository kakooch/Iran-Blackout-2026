package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_refreshToken extends TLObject {
    public static int constructor = -599448727;
    public TLRPC$TL_AppInfo appInfo;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        TLRPC$TL_AppInfo tLRPC$TL_AppInfo = this.appInfo;
        if (tLRPC$TL_AppInfo != null) {
            tLRPC$TL_AppInfo.serializeToStream(stream);
        }
    }
}
