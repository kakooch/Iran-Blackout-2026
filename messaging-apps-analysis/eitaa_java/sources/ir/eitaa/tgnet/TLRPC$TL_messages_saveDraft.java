package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_saveDraft extends TLObject {
    public static int constructor = -1137057461;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public int flags;
    public String message;
    public boolean no_webpage;
    public TLRPC$InputPeer peer;
    public int reply_to_msg_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.no_webpage ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        stream.writeInt32(i);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.reply_to_msg_id);
        }
        this.peer.serializeToStream(stream);
        stream.writeString(this.message);
        if ((this.flags & 8) != 0) {
            stream.writeInt32(481674261);
            int size = this.entities.size();
            stream.writeInt32(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.entities.get(i2).serializeToStream(stream);
            }
        }
    }
}
