package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_shop_exploreMessages extends TLObject {
    public static int constructor = -361857329;
    public ArrayList<Integer> categories_id = new ArrayList<>();
    public int flags;
    public int limit;
    public int msg_id;
    public int offset_date;
    public int offset_id;
    public TLRPC$InputPeer offset_peer;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_Messages.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(481674261);
            int size = this.categories_id.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                stream.writeInt32(this.categories_id.get(i).intValue());
            }
        }
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.msg_id);
        stream.writeInt32(this.offset_date);
        this.offset_peer.serializeToStream(stream);
        stream.writeInt32(this.offset_id);
        stream.writeInt32(this.limit);
    }
}
