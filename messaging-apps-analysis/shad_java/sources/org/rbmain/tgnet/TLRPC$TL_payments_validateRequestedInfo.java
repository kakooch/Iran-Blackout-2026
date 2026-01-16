package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_payments_validateRequestedInfo extends TLObject {
    public static int constructor = -619695760;
    public int flags;
    public TLRPC$TL_paymentRequestedInfo info;
    public long msg_id;
    public TLRPC$InputPeer peer;
    public boolean save;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_payments_validatedRequestedInfo.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.save ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32((int) this.msg_id);
        this.info.serializeToStream(abstractSerializedData);
    }
}
