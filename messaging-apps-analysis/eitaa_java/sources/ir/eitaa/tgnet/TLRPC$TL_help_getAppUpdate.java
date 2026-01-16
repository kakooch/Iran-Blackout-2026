package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_help_getAppUpdate extends TLObject {
    public static int constructor = 1378703997;
    public String source;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$help_AppUpdate.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.source);
    }
}
