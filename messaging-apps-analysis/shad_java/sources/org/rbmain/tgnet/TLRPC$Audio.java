package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$Audio extends TLObject {
    public long access_hash;
    public int date;
    public int dc_id;
    public int duration;
    public long id;
    public byte[] iv;
    public byte[] key;
    public String mime_type;
    public int size;
    public int user_id;

    public static TLRPC$Audio TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Audio tLRPC$TL_audio_layer45;
        switch (i) {
            case -945003370:
                tLRPC$TL_audio_layer45 = new TLRPC$TL_audio_layer45() { // from class: org.rbmain.tgnet.TLRPC$TL_audio_old2
                    public static int constructor = -945003370;

                    @Override // org.rbmain.tgnet.TLRPC$TL_audio_layer45, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.user_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.duration = abstractSerializedData2.readInt32(z2);
                        this.mime_type = abstractSerializedData2.readString(z2);
                        this.size = abstractSerializedData2.readInt32(z2);
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_audio_layer45, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.user_id);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeInt32(this.duration);
                        abstractSerializedData2.writeString(this.mime_type);
                        abstractSerializedData2.writeInt32(this.size);
                        abstractSerializedData2.writeInt32(this.dc_id);
                    }
                };
                break;
            case -102543275:
                tLRPC$TL_audio_layer45 = new TLRPC$TL_audio_layer45();
                break;
            case 1114908135:
                tLRPC$TL_audio_layer45 = new TLRPC$TL_audio_layer45() { // from class: org.rbmain.tgnet.TLRPC$TL_audio_old
                    public static int constructor = 1114908135;

                    @Override // org.rbmain.tgnet.TLRPC$TL_audio_layer45, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.user_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.duration = abstractSerializedData2.readInt32(z2);
                        this.size = abstractSerializedData2.readInt32(z2);
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_audio_layer45, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.user_id);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeInt32(this.duration);
                        abstractSerializedData2.writeInt32(this.size);
                        abstractSerializedData2.writeInt32(this.dc_id);
                    }
                };
                break;
            case 1431655926:
                tLRPC$TL_audio_layer45 = new TLRPC$TL_audio_layer45() { // from class: org.rbmain.tgnet.TLRPC$TL_audioEncrypted
                    public static int constructor = 1431655926;

                    @Override // org.rbmain.tgnet.TLRPC$TL_audio_layer45, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.user_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.duration = abstractSerializedData2.readInt32(z2);
                        this.size = abstractSerializedData2.readInt32(z2);
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                        this.key = abstractSerializedData2.readByteArray(z2);
                        this.iv = abstractSerializedData2.readByteArray(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_audio_layer45, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.user_id);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeInt32(this.duration);
                        abstractSerializedData2.writeInt32(this.size);
                        abstractSerializedData2.writeInt32(this.dc_id);
                        abstractSerializedData2.writeByteArray(this.key);
                        abstractSerializedData2.writeByteArray(this.iv);
                    }
                };
                break;
            case 1483311320:
                tLRPC$TL_audio_layer45 = new TLRPC$Audio() { // from class: org.rbmain.tgnet.TLRPC$TL_audioEmpty_layer45
                    public static int constructor = 1483311320;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                    }
                };
                break;
            default:
                tLRPC$TL_audio_layer45 = null;
                break;
        }
        if (tLRPC$TL_audio_layer45 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Audio", Integer.valueOf(i)));
        }
        if (tLRPC$TL_audio_layer45 != null) {
            tLRPC$TL_audio_layer45.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_audio_layer45;
    }
}
