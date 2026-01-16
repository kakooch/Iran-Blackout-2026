package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_getParticipants_2 extends TLRPC$TL_channels_getParticipants {
    public static int constructor = 1204476129;

    @Override // ir.eitaa.tgnet.TLRPC$TL_channels_getParticipants, ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.channel.serializeToStream(stream);
        this.filter.serializeToStream(stream);
        stream.writeInt32(this.offset);
        stream.writeInt32(this.limit);
        stream.writeInt64(this.hash);
    }
}
