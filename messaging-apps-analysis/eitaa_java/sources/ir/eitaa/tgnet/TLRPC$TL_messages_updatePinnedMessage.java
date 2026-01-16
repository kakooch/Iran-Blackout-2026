package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_updatePinnedMessage extends TLObject {
    public static int constructor = -760547348;
    public int flags;
    public int id;
    public TLRPC$InputPeer peer;
    public boolean pm_oneside;
    public boolean silent;
    public boolean unpin;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.silent ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.unpin ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.pm_oneside ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        stream.writeInt32(i3);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.id);
    }
}
