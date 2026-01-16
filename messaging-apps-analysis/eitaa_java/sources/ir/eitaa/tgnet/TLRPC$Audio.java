package ir.eitaa.tgnet;

/* loaded from: classes.dex */
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
    public long user_id;

    public static TLRPC$Audio TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$Audio tLRPC$TL_audio_layer45;
        switch (constructor) {
            case -945003370:
                tLRPC$TL_audio_layer45 = new TLRPC$TL_audio_layer45() { // from class: ir.eitaa.tgnet.TLRPC$TL_audio_old2
                    public static int constructor = -945003370;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_audio_layer45, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.user_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.duration = stream2.readInt32(exception2);
                        this.mime_type = stream2.readString(exception2);
                        this.size = stream2.readInt32(exception2);
                        this.dc_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_audio_layer45, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.duration);
                        stream2.writeString(this.mime_type);
                        stream2.writeInt32(this.size);
                        stream2.writeInt32(this.dc_id);
                    }
                };
                break;
            case -102543275:
                tLRPC$TL_audio_layer45 = new TLRPC$TL_audio_layer45();
                break;
            case 1114908135:
                tLRPC$TL_audio_layer45 = new TLRPC$TL_audio_layer45() { // from class: ir.eitaa.tgnet.TLRPC$TL_audio_old
                    public static int constructor = 1114908135;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_audio_layer45, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.user_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.duration = stream2.readInt32(exception2);
                        this.size = stream2.readInt32(exception2);
                        this.dc_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_audio_layer45, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.duration);
                        stream2.writeInt32(this.size);
                        stream2.writeInt32(this.dc_id);
                    }
                };
                break;
            case 1431655926:
                tLRPC$TL_audio_layer45 = new TLRPC$TL_audio_layer45() { // from class: ir.eitaa.tgnet.TLRPC$TL_audioEncrypted
                    public static int constructor = 1431655926;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_audio_layer45, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.user_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.duration = stream2.readInt32(exception2);
                        this.size = stream2.readInt32(exception2);
                        this.dc_id = stream2.readInt32(exception2);
                        this.key = stream2.readByteArray(exception2);
                        this.iv = stream2.readByteArray(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_audio_layer45, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.duration);
                        stream2.writeInt32(this.size);
                        stream2.writeInt32(this.dc_id);
                        stream2.writeByteArray(this.key);
                        stream2.writeByteArray(this.iv);
                    }
                };
                break;
            case 1483311320:
                tLRPC$TL_audio_layer45 = new TLRPC$Audio() { // from class: ir.eitaa.tgnet.TLRPC$TL_audioEmpty_layer45
                    public static int constructor = 1483311320;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                    }
                };
                break;
            default:
                tLRPC$TL_audio_layer45 = null;
                break;
        }
        if (tLRPC$TL_audio_layer45 == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Audio", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_audio_layer45 != null) {
            tLRPC$TL_audio_layer45.readParams(stream, exception);
        }
        return tLRPC$TL_audio_layer45;
    }
}
