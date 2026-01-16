package org.rbmain.tgnet;

import androidMessenger.proxy.MessageProxy$32$$ExternalSyntheticBackport0;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_deleteMessages extends TLObject {
    public static int constructor = -443640366;
    public int flags;
    public ArrayList<Long> id = new ArrayList<>();
    public boolean revoke;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_messages_affectedMessages.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.revoke = (int32 & 1) != 0;
        int int322 = abstractSerializedData.readInt32(z);
        if (int322 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
        } else {
            int int323 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < int323; i++) {
                this.id.add(Long.valueOf(abstractSerializedData.readInt32(z)));
            }
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.revoke ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        abstractSerializedData.writeInt32(481674261);
        int size = this.id.size();
        abstractSerializedData.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            abstractSerializedData.writeInt32(MessageProxy$32$$ExternalSyntheticBackport0.m(this.id.get(i2).longValue()));
        }
    }
}
