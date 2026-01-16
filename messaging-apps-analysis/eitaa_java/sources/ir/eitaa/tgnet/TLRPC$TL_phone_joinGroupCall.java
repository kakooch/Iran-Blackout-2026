package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_joinGroupCall extends TLObject {
    public static int constructor = -1322057861;
    public TLRPC$TL_inputGroupCall call;
    public int flags;
    public String invite_hash;
    public TLRPC$InputPeer join_as;
    public boolean muted;
    public TLRPC$TL_dataJSON params;
    public boolean video_stopped;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.muted ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.video_stopped ? i | 4 : i & (-5);
        this.flags = i2;
        stream.writeInt32(i2);
        this.call.serializeToStream(stream);
        this.join_as.serializeToStream(stream);
        if ((this.flags & 2) != 0) {
            stream.writeString(this.invite_hash);
        }
        this.params.serializeToStream(stream);
    }
}
