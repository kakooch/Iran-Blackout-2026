package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelParticipantsAdmins extends TLRPC$ChannelParticipantsFilter {
    public static int constructor = -1268741783;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
