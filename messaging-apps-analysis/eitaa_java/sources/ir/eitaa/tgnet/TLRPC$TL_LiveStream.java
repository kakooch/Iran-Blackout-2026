package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_LiveStream extends TLObject {
    public static int constructor = 765942443;
    public int flags;
    public String read_link;
    public int start_date;
    public String write_link;

    public static TLRPC$TL_LiveStream TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_LiveStream", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_LiveStream tLRPC$TL_LiveStream = new TLRPC$TL_LiveStream();
        tLRPC$TL_LiveStream.readParams(stream, exception);
        return tLRPC$TL_LiveStream;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.read_link = stream.readString(exception);
        }
        if ((this.flags & 2) != 0) {
            this.write_link = stream.readString(exception);
        }
        this.start_date = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.read_link);
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.write_link);
        }
        stream.writeInt32(this.start_date);
    }
}
