package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_help_getConfig extends TLObject {
    public static int constructor = -990308245;
    public TLRPC$TL_AppInfo appInfo;
    public int user_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_config.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.appInfo.serializeToStream(stream);
        stream.writeInt32(this.user_id);
    }
}
