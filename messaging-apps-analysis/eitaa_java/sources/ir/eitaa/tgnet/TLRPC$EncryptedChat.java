package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$EncryptedChat extends TLObject {
    public byte[] a_or_b;
    public long access_hash;
    public long admin_id;
    public byte[] auth_key;
    public int date;
    public long exchange_id;
    public int flags;
    public int folder_id;
    public byte[] future_auth_key;
    public long future_key_fingerprint;
    public byte[] g_a;
    public byte[] g_a_or_b;
    public boolean history_deleted;
    public int id;
    public int in_seq_no;
    public int key_create_date;
    public long key_fingerprint;
    public byte[] key_hash;
    public short key_use_count_in;
    public short key_use_count_out;
    public int layer;
    public int mtproto_seq;
    public byte[] nonce;
    public long participant_id;
    public int seq_in;
    public int seq_out;
    public int ttl;
    public long user_id;

    public static TLRPC$EncryptedChat TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$EncryptedChat tLRPC$TL_encryptedChatDiscarded;
        switch (constructor) {
            case -1417756512:
                tLRPC$TL_encryptedChatDiscarded = new TLRPC$EncryptedChat() { // from class: ir.eitaa.tgnet.TLRPC$TL_encryptedChatEmpty
                    public static int constructor = -1417756512;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.id);
                    }
                };
                break;
            case -931638658:
                tLRPC$TL_encryptedChatDiscarded = new TLRPC$EncryptedChat() { // from class: ir.eitaa.tgnet.TLRPC$TL_encryptedChatRequested_layer115
                    public static int constructor = -931638658;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.admin_id = stream2.readInt32(exception2);
                        this.participant_id = stream2.readInt32(exception2);
                        this.g_a = stream2.readByteArray(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32((int) this.admin_id);
                        stream2.writeInt32((int) this.participant_id);
                        stream2.writeByteArray(this.g_a);
                    }
                };
                break;
            case -94974410:
                tLRPC$TL_encryptedChatDiscarded = new TLRPC$TL_encryptedChat() { // from class: ir.eitaa.tgnet.TLRPC$TL_encryptedChat_layer131
                    public static int constructor = -94974410;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_encryptedChat, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.admin_id = stream2.readInt32(exception2);
                        this.participant_id = stream2.readInt32(exception2);
                        this.g_a_or_b = stream2.readByteArray(exception2);
                        this.key_fingerprint = stream2.readInt64(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_encryptedChat, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32((int) this.admin_id);
                        stream2.writeInt32((int) this.participant_id);
                        stream2.writeByteArray(this.g_a_or_b);
                        stream2.writeInt64(this.key_fingerprint);
                    }
                };
                break;
            case -39213129:
                tLRPC$TL_encryptedChatDiscarded = new TLRPC$TL_encryptedChatRequested() { // from class: ir.eitaa.tgnet.TLRPC$TL_encryptedChatRequested_old
                    public static int constructor = -39213129;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_encryptedChatRequested, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.admin_id = stream2.readInt32(exception2);
                        this.participant_id = stream2.readInt32(exception2);
                        this.g_a = stream2.readByteArray(exception2);
                        this.nonce = stream2.readByteArray(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_encryptedChatRequested, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32((int) this.admin_id);
                        stream2.writeInt32((int) this.participant_id);
                        stream2.writeByteArray(this.g_a);
                        stream2.writeByteArray(this.nonce);
                    }
                };
                break;
            case 332848423:
                tLRPC$TL_encryptedChatDiscarded = new TLRPC$TL_encryptedChatDiscarded() { // from class: ir.eitaa.tgnet.TLRPC$TL_encryptedChatDiscarded_layer122
                    public static int constructor = 332848423;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_encryptedChatDiscarded, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_encryptedChatDiscarded, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.id);
                    }
                };
                break;
            case 505183301:
                tLRPC$TL_encryptedChatDiscarded = new TLRPC$TL_encryptedChatDiscarded();
                break;
            case 1006044124:
                tLRPC$TL_encryptedChatDiscarded = new TLRPC$TL_encryptedChatWaiting() { // from class: ir.eitaa.tgnet.TLRPC$TL_encryptedChatWaiting_layer131
                    public static int constructor = 1006044124;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_encryptedChatWaiting, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.admin_id = stream2.readInt32(exception2);
                        this.participant_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_encryptedChatWaiting, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32((int) this.admin_id);
                        stream2.writeInt32((int) this.participant_id);
                    }
                };
                break;
            case 1223809356:
                tLRPC$TL_encryptedChatDiscarded = new TLRPC$TL_encryptedChatRequested();
                break;
            case 1643173063:
                tLRPC$TL_encryptedChatDiscarded = new TLRPC$TL_encryptedChat();
                break;
            case 1651608194:
                tLRPC$TL_encryptedChatDiscarded = new TLRPC$TL_encryptedChatRequested() { // from class: ir.eitaa.tgnet.TLRPC$TL_encryptedChatRequested_layer131
                    public static int constructor = 1651608194;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_encryptedChatRequested, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        if ((int32 & 1) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        this.id = stream2.readInt32(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.admin_id = stream2.readInt32(exception2);
                        this.participant_id = stream2.readInt32(exception2);
                        this.g_a = stream2.readByteArray(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_encryptedChatRequested, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        stream2.writeInt32(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32((int) this.admin_id);
                        stream2.writeInt32((int) this.participant_id);
                        stream2.writeByteArray(this.g_a);
                    }
                };
                break;
            case 1711395151:
                tLRPC$TL_encryptedChatDiscarded = new TLRPC$TL_encryptedChat() { // from class: ir.eitaa.tgnet.TLRPC$TL_encryptedChat_old
                    public static int constructor = 1711395151;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_encryptedChat, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt32(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.admin_id = stream2.readInt32(exception2);
                        this.participant_id = stream2.readInt32(exception2);
                        this.g_a_or_b = stream2.readByteArray(exception2);
                        this.nonce = stream2.readByteArray(exception2);
                        this.key_fingerprint = stream2.readInt64(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_encryptedChat, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32((int) this.admin_id);
                        stream2.writeInt32((int) this.participant_id);
                        stream2.writeByteArray(this.g_a_or_b);
                        stream2.writeByteArray(this.nonce);
                        stream2.writeInt64(this.key_fingerprint);
                    }
                };
                break;
            case 1722964307:
                tLRPC$TL_encryptedChatDiscarded = new TLRPC$TL_encryptedChatWaiting();
                break;
            default:
                tLRPC$TL_encryptedChatDiscarded = null;
                break;
        }
        if (tLRPC$TL_encryptedChatDiscarded == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in EncryptedChat", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_encryptedChatDiscarded != null) {
            tLRPC$TL_encryptedChatDiscarded.readParams(stream, exception);
        }
        return tLRPC$TL_encryptedChatDiscarded;
    }
}
