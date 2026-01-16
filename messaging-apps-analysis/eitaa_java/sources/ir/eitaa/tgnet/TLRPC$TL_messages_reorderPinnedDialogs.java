package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_reorderPinnedDialogs extends TLObject {
    public static int constructor = 991616823;
    public int flags;
    public int folder_id;
    public boolean force;
    public ArrayList<TLRPC$InputDialogPeer> order = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.force ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt32(this.folder_id);
        stream.writeInt32(481674261);
        int size = this.order.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.order.get(i2).serializeToStream(stream);
        }
    }
}
