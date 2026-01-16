package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_chatAdminWithInvites extends TLObject {
    public static int constructor = -219353309;
    public long admin_id;
    public int invites_count;
    public int revoked_invites_count;

    public static TLRPC$TL_chatAdminWithInvites TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_chatAdminWithInvites", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_chatAdminWithInvites tLRPC$TL_chatAdminWithInvites = new TLRPC$TL_chatAdminWithInvites();
        tLRPC$TL_chatAdminWithInvites.readParams(stream, exception);
        return tLRPC$TL_chatAdminWithInvites;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.admin_id = stream.readInt64(exception);
        this.invites_count = stream.readInt32(exception);
        this.revoked_invites_count = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.admin_id);
        stream.writeInt32(this.invites_count);
        stream.writeInt32(this.revoked_invites_count);
    }
}
