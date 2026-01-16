package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_channelAdminLogEventActionParticipantVolume extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 1048537159;
    public TLRPC$TL_groupCallParticipant participant;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.participant = TLRPC$TL_groupCallParticipant.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.participant.serializeToStream(abstractSerializedData);
    }
}
