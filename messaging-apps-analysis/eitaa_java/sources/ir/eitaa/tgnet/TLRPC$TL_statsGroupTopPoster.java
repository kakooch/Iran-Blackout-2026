package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_statsGroupTopPoster extends TLObject {
    public static int constructor = -1660637285;
    public int avg_chars;
    public int messages;
    public long user_id;

    public static TLRPC$TL_statsGroupTopPoster TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_statsGroupTopPoster", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_statsGroupTopPoster tLRPC$TL_statsGroupTopPoster = new TLRPC$TL_statsGroupTopPoster();
        tLRPC$TL_statsGroupTopPoster.readParams(stream, exception);
        return tLRPC$TL_statsGroupTopPoster;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.user_id = stream.readInt64(exception);
        this.messages = stream.readInt32(exception);
        this.avg_chars = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.user_id);
        stream.writeInt32(this.messages);
        stream.writeInt32(this.avg_chars);
    }
}
