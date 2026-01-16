package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_getSearchCounters extends TLObject {
    public static int constructor = 1932455680;
    public ArrayList<TLRPC$MessagesFilter> filters = new ArrayList<>();
    public TLRPC$InputPeer peer;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
        int int32 = abstractSerializedData.readInt32(z);
        for (int i2 = 0; i2 < int32; i2++) {
            TLRPC$TL_messages_searchCounter tLRPC$TL_messages_searchCounterTLdeserialize = TLRPC$TL_messages_searchCounter.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_messages_searchCounterTLdeserialize == null) {
                return tLRPC$Vector;
            }
            tLRPC$Vector.objects.add(tLRPC$TL_messages_searchCounterTLdeserialize);
        }
        return tLRPC$Vector;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.filters.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.filters.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
