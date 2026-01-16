package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_updatePinnedDialogs extends TLRPC$Update {
    public static int constructor = -99664734;
    public int flags;
    public int folder_id;
    public ArrayList<TLRPC$DialogPeer> order = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 2) != 0) {
            this.folder_id = stream.readInt32(exception);
        }
        if ((this.flags & 1) != 0) {
            int int322 = stream.readInt32(exception);
            if (int322 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = stream.readInt32(exception);
            for (int i = 0; i < int323; i++) {
                TLRPC$DialogPeer tLRPC$DialogPeerTLdeserialize = TLRPC$DialogPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$DialogPeerTLdeserialize == null) {
                    return;
                }
                this.order.add(tLRPC$DialogPeerTLdeserialize);
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.folder_id);
        }
        if ((this.flags & 1) != 0) {
            stream.writeInt32(481674261);
            int size = this.order.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.order.get(i).serializeToStream(stream);
            }
        }
    }
}
