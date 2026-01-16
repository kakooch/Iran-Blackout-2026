package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$ChatInvite extends TLObject {
    public boolean broadcast;
    public boolean channel;
    public TLRPC$Chat chat;
    public TLRPC$ChatPhoto chatPhoto;
    public int expires;
    public int flags;
    public boolean isPublic;
    public boolean megagroup;
    public ArrayList<TLRPC$User> participants = new ArrayList<>();
    public int participants_count;
    public TLRPC$Photo photo;
    public String title;

    public static TLRPC$ChatInvite TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$ChatInvite tLRPC$ChatInvite;
        switch (constructor) {
            case -613092009:
                tLRPC$ChatInvite = new TLRPC$ChatInvite() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatInvitePreview
                    public static int constructor = -613092009;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.chat = TLRPC$Chat.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.chat.serializeToStream(stream2);
                    }
                };
                break;
            case -613092008:
                tLRPC$ChatInvite = new TLRPC$ChatInvite() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatInvite_layer84
                    public static int constructor = -613092008;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.channel = (int32 & 1) != 0;
                        this.broadcast = (int32 & 2) != 0;
                        this.isPublic = (int32 & 4) != 0;
                        this.megagroup = (int32 & 8) != 0;
                        this.title = stream2.readString(exception2);
                        this.chatPhoto = TLRPC$ChatPhoto.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.participants_count = stream2.readInt32(exception2);
                        if ((this.flags & 16) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$UserTLdeserialize == null) {
                                    return;
                                }
                                this.participants.add(tLRPC$UserTLdeserialize);
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.channel ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.broadcast ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.isPublic ? i2 | 4 : i2 & (-5);
                        this.flags = i3;
                        int i4 = this.megagroup ? i3 | 8 : i3 & (-9);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeString(this.title);
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.participants_count);
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.participants.size();
                            stream2.writeInt32(size);
                            for (int i5 = 0; i5 < size; i5++) {
                                this.participants.get(i5).serializeToStream(stream2);
                            }
                        }
                    }
                };
                break;
            case -540871282:
                tLRPC$ChatInvite = new TLRPC$ChatInvite() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatInvite
                    public static int constructor = -540871282;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.channel = (int32 & 1) != 0;
                        this.broadcast = (int32 & 2) != 0;
                        this.isPublic = (int32 & 4) != 0;
                        this.megagroup = (int32 & 8) != 0;
                        this.title = stream2.readString(exception2);
                        this.photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.participants_count = stream2.readInt32(exception2);
                        if ((this.flags & 16) != 0) {
                            int int322 = stream2.readInt32(exception2);
                            if (int322 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                                }
                                return;
                            }
                            int int323 = stream2.readInt32(exception2);
                            for (int i = 0; i < int323; i++) {
                                TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$UserTLdeserialize == null) {
                                    return;
                                }
                                this.participants.add(tLRPC$UserTLdeserialize);
                            }
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.channel ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.broadcast ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.isPublic ? i2 | 4 : i2 & (-5);
                        this.flags = i3;
                        int i4 = this.megagroup ? i3 | 8 : i3 & (-9);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        stream2.writeString(this.title);
                        this.photo.serializeToStream(stream2);
                        stream2.writeInt32(this.participants_count);
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.participants.size();
                            stream2.writeInt32(size);
                            for (int i5 = 0; i5 < size; i5++) {
                                this.participants.get(i5).serializeToStream(stream2);
                            }
                        }
                    }
                };
                break;
            case 1516793212:
                tLRPC$ChatInvite = new TLRPC$ChatInvite() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatInviteAlready
                    public static int constructor = 1516793212;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.chat = TLRPC$Chat.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.chat.serializeToStream(stream2);
                    }
                };
                break;
            case 1634294960:
                tLRPC$ChatInvite = new TLRPC$ChatInvite() { // from class: ir.eitaa.tgnet.TLRPC$TL_chatInvitePeek
                    public static int constructor = 1634294960;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.chat = TLRPC$Chat.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.expires = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.chat.serializeToStream(stream2);
                        stream2.writeInt32(this.expires);
                    }
                };
                break;
            default:
                tLRPC$ChatInvite = null;
                break;
        }
        if (tLRPC$ChatInvite == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in ChatInvite", Integer.valueOf(constructor)));
        }
        if (tLRPC$ChatInvite != null) {
            tLRPC$ChatInvite.readParams(stream, exception);
        }
        return tLRPC$ChatInvite;
    }
}
