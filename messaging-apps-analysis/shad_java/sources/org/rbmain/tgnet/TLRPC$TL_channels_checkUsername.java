package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_channels_checkUsername extends TLObject {
    public static int constructor = 283557164;
    public TLRPC$InputChannel channel;
    public String username;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.channel.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeString(this.username);
    }
}
