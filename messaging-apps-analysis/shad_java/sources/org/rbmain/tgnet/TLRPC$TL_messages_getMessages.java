package org.rbmain.tgnet;

import androidMessenger.proxy.MessageProxy$32$$ExternalSyntheticBackport0;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_getMessages extends TLObject {
    public static int constructor = 1109588596;
    public ArrayList<Long> id = new ArrayList<>();

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$messages_Messages.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(481674261);
        int size = this.id.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            abstractSerializedData.writeInt32(MessageProxy$32$$ExternalSyntheticBackport0.m(this.id.get(i).longValue()));
        }
    }
}
