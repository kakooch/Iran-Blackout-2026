package org.rbmain.tgnet;

import androidMessenger.proxy.MessageProxy$32$$ExternalSyntheticBackport0;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_deleteScheduledMessages extends TLObject {
    public static int constructor = 1504586518;
    public ArrayList<Long> id = new ArrayList<>();
    public TLRPC$InputPeer peer;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.peer = TLRPC$InputPeer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
        } else {
            int int322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < int322; i++) {
                this.id.add(Long.valueOf(abstractSerializedData.readInt32(z)));
            }
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.id.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            abstractSerializedData.writeInt32(MessageProxy$32$$ExternalSyntheticBackport0.m(this.id.get(i).longValue()));
        }
    }
}
