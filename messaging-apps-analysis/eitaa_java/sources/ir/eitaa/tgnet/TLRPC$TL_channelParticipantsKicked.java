package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelParticipantsKicked extends TLRPC$ChannelParticipantsFilter {
    public static int constructor = -1548400251;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.q = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.q);
    }
}
