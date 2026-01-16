package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_channels_getParticipant extends TLObject {
    public static int constructor = -1599378234;
    public TLRPC$InputChannel channel;
    public TLRPC$InputPeer participant;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_channels_channelParticipant.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.channel.serializeToStream(abstractSerializedData);
        this.participant.serializeToStream(abstractSerializedData);
    }
}
