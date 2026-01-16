package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_searchCounter extends TLObject {
    public static int constructor = -398136321;
    public int count;
    public TLRPC$MessagesFilter filter;
    public int flags;
    public boolean inexact;

    public static TLRPC$TL_messages_searchCounter TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_searchCounter", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_searchCounter tLRPC$TL_messages_searchCounter = new TLRPC$TL_messages_searchCounter();
        tLRPC$TL_messages_searchCounter.readParams(stream, exception);
        return tLRPC$TL_messages_searchCounter;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.inexact = (int32 & 2) != 0;
        this.filter = TLRPC$MessagesFilter.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.count = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.inexact ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        stream.writeInt32(i);
        this.filter.serializeToStream(stream);
        stream.writeInt32(this.count);
    }
}
