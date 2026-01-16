package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_acceptUrlAuth extends TLObject {
    public static int constructor = -1322487515;
    public int button_id;
    public int flags;
    public int msg_id;
    public TLRPC$InputPeer peer;
    public String url;
    public boolean write_allowed;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$UrlAuthResult.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.write_allowed ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        if ((this.flags & 2) != 0) {
            this.peer.serializeToStream(stream);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.msg_id);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.button_id);
        }
        if ((this.flags & 4) != 0) {
            stream.writeString(this.url);
        }
    }
}
