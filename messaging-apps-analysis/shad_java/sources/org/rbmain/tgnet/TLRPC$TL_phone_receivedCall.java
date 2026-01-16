package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_phone_receivedCall extends TLObject {
    public static int constructor = 399855457;
    public TLRPC$TL_inputPhoneCall peer;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
    }
}
