package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$initConnection extends TLObject {
    public static int constructor = 1769565673;
    public int api_id;
    public String app_version;
    public String device_model;
    public String lang_code;
    public TLObject query;
    public String system_version;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.api_id);
        stream.writeString(this.device_model);
        stream.writeString(this.system_version);
        stream.writeString(this.app_version);
        stream.writeString(this.lang_code);
        this.query.serializeToStream(stream);
    }
}
