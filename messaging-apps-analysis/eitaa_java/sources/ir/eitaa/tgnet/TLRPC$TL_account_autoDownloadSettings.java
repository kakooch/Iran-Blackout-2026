package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_autoDownloadSettings extends TLObject {
    public static int constructor = 1674235686;
    public TLRPC$TL_autoDownloadSettings high;
    public TLRPC$TL_autoDownloadSettings low;
    public TLRPC$TL_autoDownloadSettings medium;

    public static TLRPC$TL_account_autoDownloadSettings TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_account_autoDownloadSettings", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_account_autoDownloadSettings tLRPC$TL_account_autoDownloadSettings = new TLRPC$TL_account_autoDownloadSettings();
        tLRPC$TL_account_autoDownloadSettings.readParams(stream, exception);
        return tLRPC$TL_account_autoDownloadSettings;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.low = TLRPC$TL_autoDownloadSettings.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.medium = TLRPC$TL_autoDownloadSettings.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.high = TLRPC$TL_autoDownloadSettings.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.low.serializeToStream(stream);
        this.medium.serializeToStream(stream);
        this.high.serializeToStream(stream);
    }
}
