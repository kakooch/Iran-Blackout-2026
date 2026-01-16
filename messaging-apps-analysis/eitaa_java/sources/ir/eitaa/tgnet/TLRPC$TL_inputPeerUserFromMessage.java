package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputPeerUserFromMessage extends TLRPC$InputPeer {
    public static int constructor = -1468331492;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$InputPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.msg_id = stream.readInt32(exception);
        this.user_id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.msg_id);
        stream.writeInt64(this.user_id);
    }
}
