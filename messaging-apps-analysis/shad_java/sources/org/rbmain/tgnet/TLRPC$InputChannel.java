package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$InputChannel extends TLObject {
    public long access_hash;
    public int channel_id;

    public static TLRPC$InputChannel TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$InputChannel tLRPC$TL_inputChannel;
        if (i == -1343524562) {
            tLRPC$TL_inputChannel = new TLRPC$TL_inputChannel();
        } else if (i == -292807034) {
            tLRPC$TL_inputChannel = new TLRPC$TL_inputChannelEmpty();
        } else {
            tLRPC$TL_inputChannel = i != 707290417 ? null : new TLRPC$InputChannel() { // from class: org.rbmain.tgnet.TLRPC$TL_inputChannelFromMessage
                public static int constructor = 707290417;
                public long msg_id;
                public TLRPC$InputPeer peer;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.peer = TLRPC$InputPeer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    this.msg_id = abstractSerializedData2.readInt32(z2);
                    this.channel_id = abstractSerializedData2.readInt32(z2);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    this.peer.serializeToStream(abstractSerializedData2);
                    abstractSerializedData2.writeInt32((int) this.msg_id);
                    abstractSerializedData2.writeInt32(this.channel_id);
                }
            };
        }
        if (tLRPC$TL_inputChannel == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputChannel", Integer.valueOf(i)));
        }
        if (tLRPC$TL_inputChannel != null) {
            tLRPC$TL_inputChannel.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_inputChannel;
    }
}
