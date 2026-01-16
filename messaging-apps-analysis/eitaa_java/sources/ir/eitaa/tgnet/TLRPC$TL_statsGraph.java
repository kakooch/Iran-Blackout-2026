package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_statsGraph extends TLRPC$StatsGraph {
    public static int constructor = -1901828938;
    public int flags;
    public TLRPC$TL_dataJSON json;
    public String zoom_token;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.json = TLRPC$TL_dataJSON.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 1) != 0) {
            this.zoom_token = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.json.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.zoom_token);
        }
    }
}
