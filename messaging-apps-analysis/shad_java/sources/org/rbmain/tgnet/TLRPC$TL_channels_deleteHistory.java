package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_channels_deleteHistory extends TLObject {
    public static int constructor = -1355375294;
    public TLRPC$InputChannel channel;
    public long max_id;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.channel.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32((int) this.max_id);
    }
}
