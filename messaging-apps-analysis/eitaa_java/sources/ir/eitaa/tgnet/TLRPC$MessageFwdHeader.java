package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$MessageFwdHeader extends TLObject {
    public int channel_post;
    public int date;
    public int flags;
    public TLRPC$Peer from_id;
    public String from_name;
    public boolean imported;
    public String post_author;
    public String psa_type;
    public int saved_from_msg_id;
    public TLRPC$Peer saved_from_peer;

    public static TLRPC$MessageFwdHeader TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$TL_messageFwdHeader tLRPC$TL_messageFwdHeader;
        switch (constructor) {
            case -947462709:
                tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader_layer68
                    public static int constructor = -947462709;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        if ((int32 & 1) != 0) {
                            TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                            this.from_id = tLRPC$TL_peerChannel;
                            tLRPC$TL_peerChannel.user_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        if ((this.flags & 2) != 0) {
                            TLRPC$TL_peerChannel tLRPC$TL_peerChannel2 = new TLRPC$TL_peerChannel();
                            this.from_id = tLRPC$TL_peerChannel2;
                            tLRPC$TL_peerChannel2.channel_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.channel_post = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        stream2.writeInt32(this.date);
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32((int) this.from_id.channel_id);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.channel_post);
                        }
                    }
                };
                break;
            case -332168592:
                tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader_layer112
                    public static int constructor = -332168592;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        if ((int32 & 1) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.from_name = stream2.readString(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        if ((this.flags & 2) != 0) {
                            TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                            this.from_id = tLRPC$TL_peerChannel;
                            tLRPC$TL_peerChannel.channel_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.channel_post = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.post_author = stream2.readString(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.saved_from_peer = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.saved_from_msg_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeString(this.from_name);
                        }
                        stream2.writeInt32(this.date);
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32((int) this.from_id.channel_id);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.channel_post);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeString(this.post_author);
                        }
                        if ((this.flags & 16) != 0) {
                            this.saved_from_peer.serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.saved_from_msg_id);
                        }
                    }
                };
                break;
            case -85986132:
                tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader_layer72
                    public static int constructor = -85986132;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        if ((int32 & 1) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        if ((this.flags & 2) != 0) {
                            TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                            this.from_id = tLRPC$TL_peerChannel;
                            tLRPC$TL_peerChannel.channel_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.channel_post = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.post_author = stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        stream2.writeInt32(this.date);
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32((int) this.from_id.channel_id);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.channel_post);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeString(this.post_author);
                        }
                    }
                };
                break;
            case 893020267:
                tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader_layer118
                    public static int constructor = 893020267;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        if ((int32 & 1) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.from_name = stream2.readString(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        if ((this.flags & 2) != 0) {
                            TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                            this.from_id = tLRPC$TL_peerChannel;
                            tLRPC$TL_peerChannel.channel_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.channel_post = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.post_author = stream2.readString(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.saved_from_peer = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.saved_from_msg_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.psa_type = stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeString(this.from_name);
                        }
                        stream2.writeInt32(this.date);
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32((int) this.from_id.channel_id);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.channel_post);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeString(this.post_author);
                        }
                        if ((this.flags & 16) != 0) {
                            this.saved_from_peer.serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.saved_from_msg_id);
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeString(this.psa_type);
                        }
                    }
                };
                break;
            case 1436466797:
                tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader_layer96
                    public static int constructor = 1436466797;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        if ((int32 & 1) != 0) {
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            this.from_id = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = stream2.readInt32(exception2);
                        }
                        this.date = stream2.readInt32(exception2);
                        if ((this.flags & 2) != 0) {
                            TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                            this.from_id = tLRPC$TL_peerChannel;
                            tLRPC$TL_peerChannel.channel_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.channel_post = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.post_author = stream2.readString(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.saved_from_peer = TLRPC$Peer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.saved_from_msg_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageFwdHeader, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32((int) this.from_id.user_id);
                        }
                        stream2.writeInt32(this.date);
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32((int) this.from_id.channel_id);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.channel_post);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeString(this.post_author);
                        }
                        if ((this.flags & 16) != 0) {
                            this.saved_from_peer.serializeToStream(stream2);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt32(this.saved_from_msg_id);
                        }
                    }
                };
                break;
            case 1601666510:
                tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader();
                break;
            default:
                tLRPC$TL_messageFwdHeader = null;
                break;
        }
        if (tLRPC$TL_messageFwdHeader == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageFwdHeader", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_messageFwdHeader != null) {
            tLRPC$TL_messageFwdHeader.readParams(stream, exception);
        }
        return tLRPC$TL_messageFwdHeader;
    }
}
