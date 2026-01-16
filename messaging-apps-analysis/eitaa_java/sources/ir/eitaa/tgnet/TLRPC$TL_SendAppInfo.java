package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_SendAppInfo extends TLObject {
    public static int constructor = 1635347946;
    public TLRPC$TL_AppInfo app_info;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.app_info.serializeToStream(stream);
    }
}
