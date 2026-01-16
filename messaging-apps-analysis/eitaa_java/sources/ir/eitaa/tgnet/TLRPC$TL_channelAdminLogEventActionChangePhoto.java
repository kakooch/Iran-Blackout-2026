package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelAdminLogEventActionChangePhoto extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 1129042607;
    public TLRPC$Photo new_photo;
    public TLRPC$Photo prev_photo;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.prev_photo = TLRPC$Photo.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.new_photo = TLRPC$Photo.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.prev_photo.serializeToStream(stream);
        this.new_photo.serializeToStream(stream);
    }
}
