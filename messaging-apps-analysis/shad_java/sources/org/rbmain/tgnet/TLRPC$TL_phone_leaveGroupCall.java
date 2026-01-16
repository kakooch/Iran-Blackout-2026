package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_phone_leaveGroupCall extends TLObject {
    public static int constructor = 1342404601;
    public TLRPC$TL_inputGroupCall call;
    public int source;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.call.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.source);
    }
}
