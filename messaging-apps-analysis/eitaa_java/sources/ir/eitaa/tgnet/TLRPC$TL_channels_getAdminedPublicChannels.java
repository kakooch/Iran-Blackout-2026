package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_getAdminedPublicChannels extends TLObject {
    public static int constructor = -122669393;
    public boolean by_location;
    public boolean check_limit;
    public int flags;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_Chats.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.by_location ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.check_limit ? i | 2 : i & (-3);
        this.flags = i2;
        stream.writeInt32(i2);
    }
}
