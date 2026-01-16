package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateDialogPinned extends TLRPC$Update {
    public static int constructor = 1852826908;
    public int flags;
    public int folder_id;
    public TLRPC$DialogPeer peer;
    public boolean pinned;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.pinned = (int32 & 1) != 0;
        if ((int32 & 2) != 0) {
            this.folder_id = stream.readInt32(exception);
        }
        this.peer = TLRPC$DialogPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.pinned ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.folder_id);
        }
        this.peer.serializeToStream(stream);
    }
}
