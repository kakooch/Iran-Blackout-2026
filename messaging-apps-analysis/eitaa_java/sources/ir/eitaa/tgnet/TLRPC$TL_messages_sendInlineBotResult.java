package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_sendInlineBotResult extends TLObject {
    public static int constructor = 570955184;
    public boolean background;
    public boolean clear_draft;
    public int flags;
    public boolean hide_via;
    public String id;
    public TLRPC$InputPeer peer;
    public long query_id;
    public long random_id;
    public int reply_to_msg_id;
    public int schedule_date;
    public boolean silent;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.silent ? this.flags | 32 : this.flags & (-33);
        this.flags = i;
        int i2 = this.background ? i | 64 : i & (-65);
        this.flags = i2;
        int i3 = this.clear_draft ? i2 | 128 : i2 & (-129);
        this.flags = i3;
        int i4 = this.hide_via ? i3 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i3 & (-2049);
        this.flags = i4;
        stream.writeInt32(i4);
        this.peer.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.reply_to_msg_id);
        }
        stream.writeInt64(this.random_id);
        stream.writeInt64(this.query_id);
        stream.writeString(this.id);
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            stream.writeInt32(this.schedule_date);
        }
    }
}
