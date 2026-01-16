package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_channels_editTitle extends TLObject {
    public static int constructor = 1450044624;
    public TLRPC$InputChannel channel;
    public String title;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.channel.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeString(this.title);
    }
}
