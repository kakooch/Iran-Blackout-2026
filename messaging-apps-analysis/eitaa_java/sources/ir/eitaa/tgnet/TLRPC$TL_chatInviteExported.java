package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_chatInviteExported extends TLRPC$ExportedChatInvite {
    public static int constructor = -1316944408;
    public long admin_id;
    public int date;
    public int expire_date;
    public boolean expired;
    public int flags;
    public ArrayList<TLRPC$User> importers;
    public String link;
    public boolean permanent;
    public boolean revoked;
    public int start_date;
    public int usage;
    public int usage_limit;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.revoked = (int32 & 1) != 0;
        this.permanent = (int32 & 32) != 0;
        this.link = stream.readString(exception);
        this.admin_id = stream.readInt64(exception);
        this.date = stream.readInt32(exception);
        if ((this.flags & 16) != 0) {
            this.start_date = stream.readInt32(exception);
        }
        if ((this.flags & 2) != 0) {
            this.expire_date = stream.readInt32(exception);
        }
        if ((this.flags & 4) != 0) {
            this.usage_limit = stream.readInt32(exception);
        }
        if ((this.flags & 8) != 0) {
            this.usage = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.revoked ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.permanent ? i | 32 : i & (-33);
        this.flags = i2;
        stream.writeInt32(i2);
        stream.writeString(this.link);
        stream.writeInt64(this.admin_id);
        stream.writeInt32(this.date);
        if ((this.flags & 16) != 0) {
            stream.writeInt32(this.start_date);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.expire_date);
        }
        if ((this.flags & 4) != 0) {
            stream.writeInt32(this.usage_limit);
        }
        if ((this.flags & 8) != 0) {
            stream.writeInt32(this.usage);
        }
    }
}
