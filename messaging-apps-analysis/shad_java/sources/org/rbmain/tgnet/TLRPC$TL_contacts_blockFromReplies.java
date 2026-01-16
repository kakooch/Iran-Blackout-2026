package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_contacts_blockFromReplies extends TLObject {
    public static int constructor = 698914348;
    public boolean delete_history;
    public boolean delete_message;
    public int flags;
    public long msg_id;
    public boolean report_spam;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.delete_message ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.delete_history ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.report_spam ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        abstractSerializedData.writeInt32(i3);
        abstractSerializedData.writeInt32((int) this.msg_id);
    }
}
