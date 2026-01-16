package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$ExportedChatInvite extends TLObject {
    public String link;

    public static TLRPC$ExportedChatInvite TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$ExportedChatInvite tLRPC$TL_chatInviteExported;
        switch (constructor) {
            case -1316944408:
                tLRPC$TL_chatInviteExported = new TLRPC$TL_chatInviteExported();
                break;
            case -64092740:
                tLRPC$TL_chatInviteExported = new TLRPC$ExportedChatInvite() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatInviteExported_layer122
                    public static int constructor = -64092740;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.link = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.link);
                    }
                };
                break;
            case 1776236393:
                tLRPC$TL_chatInviteExported = new TLRPC$TL_chatInviteEmpty_layer122();
                break;
            case 1847917725:
                tLRPC$TL_chatInviteExported = new TLRPC$TL_chatInviteExported() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatInviteExported_layer131
                    public static int constructor = 1847917725;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatInviteExported, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.revoked = (int32 & 1) != 0;
                        this.permanent = (int32 & 32) != 0;
                        ((TLRPC$TL_chatInviteExported) this).link = stream2.readString(exception2);
                        this.admin_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        if ((this.flags & 16) != 0) {
                            this.start_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.expire_date = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.usage_limit = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.usage = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_chatInviteExported, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.revoked ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.permanent ? i | 32 : i & (-33);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeString(((TLRPC$TL_chatInviteExported) this).link);
                        stream2.writeInt32((int) this.admin_id);
                        stream2.writeInt32(this.date);
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.start_date);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.expire_date);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.usage_limit);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeInt32(this.usage);
                        }
                    }
                };
                break;
            default:
                tLRPC$TL_chatInviteExported = null;
                break;
        }
        if (tLRPC$TL_chatInviteExported == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in ExportedChatInvite", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_chatInviteExported != null) {
            tLRPC$TL_chatInviteExported.readParams(stream, exception);
        }
        return tLRPC$TL_chatInviteExported;
    }
}
