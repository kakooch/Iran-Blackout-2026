package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputPeerPhotoFileLocation extends TLRPC$InputFileLocation {
    public static int constructor = 925204121;
    public boolean big;
    public TLRPC$InputPeer peer;
    public long photo_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.big = (int32 & 1) != 0;
        this.peer = TLRPC$InputPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.photo_id = stream.readInt64(exception);
        this.volume_id = stream.readInt64(exception);
        this.local_id = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.big ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.peer.serializeToStream(stream);
        stream.writeInt64(this.photo_id);
        stream.writeInt64(this.volume_id);
        stream.writeInt32(this.local_id);
    }
}
