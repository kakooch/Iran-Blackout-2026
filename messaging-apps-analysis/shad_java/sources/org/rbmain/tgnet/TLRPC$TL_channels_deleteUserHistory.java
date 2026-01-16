package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_channels_deleteUserHistory extends TLObject {
    public static int constructor = -787622117;
    public TLRPC$InputChannel channel;
    public TLRPC$InputUser user_id;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_messages_affectedHistory.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.channel.serializeToStream(abstractSerializedData);
        this.user_id.serializeToStream(abstractSerializedData);
    }
}
