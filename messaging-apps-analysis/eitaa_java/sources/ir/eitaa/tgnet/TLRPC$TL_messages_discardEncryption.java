package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_discardEncryption extends TLObject {
    public static int constructor = -208425312;
    public int chat_id;
    public boolean delete_history;
    public int flags;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.delete_history ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt32(this.chat_id);
    }
}
