package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_getSearchCounters extends TLObject {
    public static int constructor = 1932455680;
    public ArrayList<TLRPC$MessagesFilter> filters = new ArrayList<>();
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
        int int32 = stream.readInt32(exception);
        for (int i = 0; i < int32; i++) {
            TLRPC$TL_messages_searchCounter tLRPC$TL_messages_searchCounterTLdeserialize = TLRPC$TL_messages_searchCounter.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_messages_searchCounterTLdeserialize == null) {
                return tLRPC$Vector;
            }
            tLRPC$Vector.objects.add(tLRPC$TL_messages_searchCounterTLdeserialize);
        }
        return tLRPC$Vector;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.filters.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.filters.get(i).serializeToStream(stream);
        }
    }
}
