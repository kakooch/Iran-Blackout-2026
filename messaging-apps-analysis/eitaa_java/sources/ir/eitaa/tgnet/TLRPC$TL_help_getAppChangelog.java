package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_help_getAppChangelog extends TLObject {
    public static int constructor = -1877938321;
    public String prev_app_version;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.prev_app_version);
    }
}
