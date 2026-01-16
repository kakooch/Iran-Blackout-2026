package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputPeerChat extends TLRPC$InputPeer {
    public static int constructor = 900291769;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.chat_id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.chat_id);
    }
}
