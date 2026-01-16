package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_getBotCallbackAnswer extends TLObject {
    public static int constructor = -1824339449;
    public byte[] data;
    public int flags;
    public boolean game;
    public int msg_id;
    public TLRPC$InputCheckPasswordSRP password;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_messages_botCallbackAnswer.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.game ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        stream.writeInt32(i);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.msg_id);
        if ((this.flags & 1) != 0) {
            stream.writeByteArray(this.data);
        }
        if ((this.flags & 4) != 0) {
            this.password.serializeToStream(stream);
        }
    }
}
