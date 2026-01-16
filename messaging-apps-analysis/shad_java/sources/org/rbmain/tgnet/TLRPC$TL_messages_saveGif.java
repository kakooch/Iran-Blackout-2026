package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_saveGif extends TLObject {
    public static int constructor = 846868683;
    public TLRPC$InputDocument id;
    public TLRPC$Message message;
    public boolean unsave;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.id.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeBool(this.unsave);
    }
}
