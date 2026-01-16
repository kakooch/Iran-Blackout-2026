package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_getMessageReactionsList extends TLObject {
    public int flags;
    public long id;
    public TLRPC$InputPeer peer;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
    }

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_messageReactionsList.TLdeserialize(abstractSerializedData, i, z);
    }
}
