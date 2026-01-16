package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_setDiscussionGroup extends TLObject {
    public static int constructor = 1079520178;
    public TLRPC$InputChannel broadcast;
    public TLRPC$InputChannel group;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.broadcast.serializeToStream(stream);
        this.group.serializeToStream(stream);
    }
}
