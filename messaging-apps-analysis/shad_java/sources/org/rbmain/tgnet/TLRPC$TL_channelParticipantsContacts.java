package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_channelParticipantsContacts extends TLRPC$ChannelParticipantsFilter {
    public static int constructor = -1150621555;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.q = abstractSerializedData.readString(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.q);
    }
}
