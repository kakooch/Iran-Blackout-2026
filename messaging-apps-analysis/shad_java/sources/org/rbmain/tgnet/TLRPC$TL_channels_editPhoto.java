package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_channels_editPhoto extends TLObject {
    public static int constructor = -248621111;
    public TLRPC$InputChannel channel;
    public TLRPC$InputChatPhoto photo;
    public TLRPC$InputChatPhoto smallPhoto;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.channel.serializeToStream(abstractSerializedData);
        this.photo.serializeToStream(abstractSerializedData);
    }
}
