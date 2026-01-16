package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_phone_groupCallStreamChannels extends TLObject {
    public static int constructor = -790330702;
    public ArrayList<TLRPC$TL_groupCallStreamChannel> channels = new ArrayList<>();

    public static TLRPC$TL_phone_groupCallStreamChannels TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_phone_groupCallStreamChannels", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_phone_groupCallStreamChannels tLRPC$TL_phone_groupCallStreamChannels = new TLRPC$TL_phone_groupCallStreamChannels();
        tLRPC$TL_phone_groupCallStreamChannels.readParams(abstractSerializedData, z);
        return tLRPC$TL_phone_groupCallStreamChannels;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_groupCallStreamChannel tLRPC$TL_groupCallStreamChannelTLdeserialize = TLRPC$TL_groupCallStreamChannel.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_groupCallStreamChannelTLdeserialize == null) {
                return;
            }
            this.channels.add(tLRPC$TL_groupCallStreamChannelTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(481674261);
        int size = this.channels.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.channels.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
