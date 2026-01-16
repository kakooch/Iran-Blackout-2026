package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_exportMessageLink extends TLObject {
    public static int constructor = -432034325;
    public TLRPC$InputChannel channel;
    public int flags;
    public boolean grouped;
    public int id;
    public boolean thread;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_exportedMessageLink.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.grouped ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.thread ? i | 2 : i & (-3);
        this.flags = i2;
        stream.writeInt32(i2);
        this.channel.serializeToStream(stream);
        stream.writeInt32(this.id);
    }
}
