package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_channelParticipantsMentions extends TLRPC$ChannelParticipantsFilter {
    public static int constructor = -531931925;
    public int flags;
    public long top_msg_id;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.q = abstractSerializedData.readString(z);
        }
        if ((this.flags & 2) != 0) {
            this.top_msg_id = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeString(this.q);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32((int) this.top_msg_id);
        }
    }
}
