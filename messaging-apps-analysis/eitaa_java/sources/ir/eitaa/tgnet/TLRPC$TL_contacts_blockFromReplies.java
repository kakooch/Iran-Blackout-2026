package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_contacts_blockFromReplies extends TLObject {
    public static int constructor = 698914348;
    public boolean delete_history;
    public boolean delete_message;
    public int flags;
    public int msg_id;
    public boolean report_spam;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.delete_message ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.delete_history ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.report_spam ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        stream.writeInt32(i3);
        stream.writeInt32(this.msg_id);
    }
}
