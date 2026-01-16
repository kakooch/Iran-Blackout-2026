package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_AppInfo extends TLObject {
    public static int constructor = 1635347945;
    public String app_version;
    public int build_version;
    public String device_model;
    public String lang_code;
    public String sign = "";
    public String system_version;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.build_version);
        stream.writeString(this.device_model);
        stream.writeString(this.system_version);
        stream.writeString(this.app_version);
        stream.writeString(this.lang_code);
        stream.writeString(this.sign);
    }
}
