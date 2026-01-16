package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_sendVote extends TLObject {
    public static int constructor = 283795844;
    public int msg_id;
    public ArrayList<byte[]> options = new ArrayList<>();
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.msg_id);
        stream.writeInt32(481674261);
        int size = this.options.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeByteArray(this.options.get(i));
        }
    }
}
