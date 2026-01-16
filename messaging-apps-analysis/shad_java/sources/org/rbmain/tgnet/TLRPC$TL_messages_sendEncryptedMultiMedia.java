package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_sendEncryptedMultiMedia extends TLObject {
    public ArrayList<TLRPC$TL_decryptedMessage> messages = new ArrayList<>();
    public ArrayList<TLRPC$InputEncryptedFile> files = new ArrayList<>();

    @Override // org.rbmain.tgnet.TLObject
    public void freeResources() {
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
    }

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$messages_SentEncryptedMessage.TLdeserialize(abstractSerializedData, i, z);
    }
}
