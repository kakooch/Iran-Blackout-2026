package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_messageEditData extends TLObject {
    public static int constructor = 649453030;
    public boolean caption;
    public int flags;

    public static TLRPC$TL_messages_messageEditData TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_messageEditData", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_messageEditData tLRPC$TL_messages_messageEditData = new TLRPC$TL_messages_messageEditData();
        tLRPC$TL_messages_messageEditData.readParams(stream, exception);
        return tLRPC$TL_messages_messageEditData;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.caption = (int32 & 1) != 0;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.caption ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
    }
}
