package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_saveRecentSticker extends TLObject {
    public static int constructor = 958863608;
    public boolean attached;
    public int flags;
    public TLRPC$InputDocument id;
    public boolean unsave;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.attached ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.id.serializeToStream(stream);
        stream.writeBool(this.unsave);
    }
}
