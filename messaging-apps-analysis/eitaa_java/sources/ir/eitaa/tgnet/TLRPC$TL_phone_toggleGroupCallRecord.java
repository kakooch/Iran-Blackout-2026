package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_toggleGroupCallRecord extends TLObject {
    public static int constructor = -248985848;
    public TLRPC$TL_inputGroupCall call;
    public int flags;
    public boolean start;
    public String title;
    public boolean video;
    public boolean video_portrait;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.start ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.video ? i | 4 : i & (-5);
        this.flags = i2;
        stream.writeInt32(i2);
        this.call.serializeToStream(stream);
        if ((this.flags & 2) != 0) {
            stream.writeString(this.title);
        }
        if ((this.flags & 4) != 0) {
            stream.writeBool(this.video_portrait);
        }
    }
}
