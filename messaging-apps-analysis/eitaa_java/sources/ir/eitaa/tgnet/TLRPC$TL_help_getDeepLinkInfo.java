package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_help_getDeepLinkInfo extends TLObject {
    public static int constructor = 1072547679;
    public String path;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$help_DeepLinkInfo.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.path);
    }
}
