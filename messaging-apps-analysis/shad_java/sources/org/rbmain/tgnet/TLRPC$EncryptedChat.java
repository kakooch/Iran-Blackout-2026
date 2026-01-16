package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$EncryptedChat extends TLObject {
    public byte[] a_or_b;
    public long access_hash;
    public int admin_id;
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
    public int participant_id;
    public int seq_in;
    public int seq_out;
    public int ttl;
    public int user_id;

    public static TLRPC$EncryptedChat TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$EncryptedChat tLRPC$TL_encryptedChat;
        switch (i) {
            case -1417756512:
                tLRPC$TL_encryptedChat = new TLRPC$EncryptedChat() { // from class: org.rbmain.tgnet.TLRPC$TL_encryptedChatEmpty
                    public static int constructor = -1417756512;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.id);
                    }
                };
                break;
            case -931638658:
                tLRPC$TL_encryptedChat = new TLRPC$EncryptedChat() { // from class: org.rbmain.tgnet.TLRPC$TL_encryptedChatRequested_layer115
                    public static int constructor = -931638658;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.admin_id = abstractSerializedData2.readInt32(z2);
                        this.participant_id = abstractSerializedData2.readInt32(z2);
                        this.g_a = abstractSerializedData2.readByteArray(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeInt32(this.admin_id);
                        abstractSerializedData2.writeInt32(this.participant_id);
                        abstractSerializedData2.writeByteArray(this.g_a);
                    }
                };
                break;
            case -94974410:
                tLRPC$TL_encryptedChat = new TLRPC$TL_encryptedChat();
                break;
            case -39213129:
                tLRPC$TL_encryptedChat = new TLRPC$TL_encryptedChatRequested() { // from class: org.rbmain.tgnet.TLRPC$TL_encryptedChatRequested_old
                    public static int constructor = -39213129;

                    @Override // org.rbmain.tgnet.TLRPC$TL_encryptedChatRequested, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.admin_id = abstractSerializedData2.readInt32(z2);
                        this.participant_id = abstractSerializedData2.readInt32(z2);
                        this.g_a = abstractSerializedData2.readByteArray(z2);
                        this.nonce = abstractSerializedData2.readByteArray(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_encryptedChatRequested, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeInt32(this.admin_id);
                        abstractSerializedData2.writeInt32(this.participant_id);
                        abstractSerializedData2.writeByteArray(this.g_a);
                        abstractSerializedData2.writeByteArray(this.nonce);
                    }
                };
                break;
            case 332848423:
                tLRPC$TL_encryptedChat = new TLRPC$TL_encryptedChatDiscarded() { // from class: org.rbmain.tgnet.TLRPC$TL_encryptedChatDiscarded_layer122
                    public static int constructor = 332848423;

                    @Override // org.rbmain.tgnet.TLRPC$TL_encryptedChatDiscarded, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_encryptedChatDiscarded, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.id);
                    }
                };
                break;
            case 505183301:
                tLRPC$TL_encryptedChat = new TLRPC$TL_encryptedChatDiscarded();
                break;
            case 1006044124:
                tLRPC$TL_encryptedChat = new TLRPC$EncryptedChat() { // from class: org.rbmain.tgnet.TLRPC$TL_encryptedChatWaiting
                    public static int constructor = 1006044124;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.admin_id = abstractSerializedData2.readInt32(z2);
                        this.participant_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeInt32(this.admin_id);
                        abstractSerializedData2.writeInt32(this.participant_id);
                    }
                };
                break;
            case 1651608194:
                tLRPC$TL_encryptedChat = new TLRPC$TL_encryptedChatRequested();
                break;
            case 1711395151:
                tLRPC$TL_encryptedChat = new TLRPC$TL_encryptedChat() { // from class: org.rbmain.tgnet.TLRPC$TL_encryptedChat_old
                    public static int constructor = 1711395151;

                    @Override // org.rbmain.tgnet.TLRPC$TL_encryptedChat, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt32(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.admin_id = abstractSerializedData2.readInt32(z2);
                        this.participant_id = abstractSerializedData2.readInt32(z2);
                        this.g_a_or_b = abstractSerializedData2.readByteArray(z2);
                        this.nonce = abstractSerializedData2.readByteArray(z2);
                        this.key_fingerprint = abstractSerializedData2.readInt64(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_encryptedChat, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeInt32(this.admin_id);
                        abstractSerializedData2.writeInt32(this.participant_id);
                        abstractSerializedData2.writeByteArray(this.g_a_or_b);
                        abstractSerializedData2.writeByteArray(this.nonce);
                        abstractSerializedData2.writeInt64(this.key_fingerprint);
                    }
                };
                break;
            default:
                tLRPC$TL_encryptedChat = null;
                break;
        }
        if (tLRPC$TL_encryptedChat == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in EncryptedChat", Integer.valueOf(i)));
        }
        if (tLRPC$TL_encryptedChat != null) {
            tLRPC$TL_encryptedChat.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_encryptedChat;
    }
}
