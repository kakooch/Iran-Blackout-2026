package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_saveAutoDownloadSettings extends TLObject {
    public static int constructor = 1995661875;
    public int flags;
    public boolean high;
    public boolean low;
    public TLRPC$TL_autoDownloadSettings settings;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.low ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.high ? i | 2 : i & (-3);
        this.flags = i2;
        stream.writeInt32(i2);
        this.settings.serializeToStream(stream);
    }
}
