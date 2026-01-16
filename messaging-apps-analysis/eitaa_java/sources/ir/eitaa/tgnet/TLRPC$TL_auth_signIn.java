package ir.eitaa.tgnet;

import ir.eitaa.messenger.ApplicationLoader;

/* loaded from: classes.dex */
public class TLRPC$TL_auth_signIn extends TLObject {
    public static int constructor = -1126886015;
    public String phone_code;
    public String phone_code_hash;
    public String phone_number;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$auth_Authorization.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        TLRPC$TL_AppInfo appInfo;
        try {
            appInfo = ApplicationLoader.getAppInfo();
        } catch (Exception unused) {
            appInfo = null;
        }
        stream.writeInt32(constructor);
        stream.writeString(this.phone_number);
        stream.writeString(this.phone_code_hash);
        stream.writeString(this.phone_code);
        if (appInfo != null) {
            appInfo.serializeToStream(stream);
        }
    }
}
