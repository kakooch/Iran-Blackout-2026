package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_getWallPapers extends TLObject {
    public static int constructor = 127302966;
    public long hash;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$account_WallPapers.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.hash);
    }
}
