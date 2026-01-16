package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_channelAdminLogEventActionUpdatePinned extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = -370660328;
    public TLRPC$Message message;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.message = TLRPC$Message.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.message.serializeToStream(abstractSerializedData);
    }
}
