package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_phone_getGroupCall extends TLObject {
    public static int constructor = 209498135;
    public TLRPC$TL_inputGroupCall call;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_phone_groupCall.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.call.serializeToStream(abstractSerializedData);
    }
}
