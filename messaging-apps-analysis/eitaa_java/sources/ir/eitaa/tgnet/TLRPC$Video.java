package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$Video extends TLObject {
    public long access_hash;
    public String caption;
    public int date;
    public int dc_id;
    public int duration;
    public int h;
    public long id;
    public byte[] iv;
    public byte[] key;
    public String mime_type;
    public int size;
    public TLRPC$PhotoSize thumb;
    public long user_id;
    public int w;

    public static TLRPC$Video TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$Video tLRPC$TL_video_layer45;
        switch (constructor) {
            case -1056548696:
                tLRPC$TL_video_layer45 = new TLRPC$Video() { // from class: ir.eitaa.tgnet.TLRPC$TL_videoEmpty_layer45
                    public static int constructor = -1056548696;

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
            case -291550643:
                tLRPC$TL_video_layer45 = new TLRPC$TL_video_layer45() { // from class: ir.eitaa.tgnet.TLRPC$TL_video_old3
                    public static int constructor = -291550643;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_video_layer45, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.user_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.duration = stream2.readInt32(exception2);
                        this.size = stream2.readInt32(exception2);
                        this.thumb = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2);
                        this.dc_id = stream2.readInt32(exception2);
                        this.w = stream2.readInt32(exception2);
                        this.h = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_video_layer45, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.duration);
                        stream2.writeInt32(this.size);
                        this.thumb.serializeToStream(stream2);
                        stream2.writeInt32(this.dc_id);
                        stream2.writeInt32(this.w);
                        stream2.writeInt32(this.h);
                    }
                };
                break;
            case -148338733:
                tLRPC$TL_video_layer45 = new TLRPC$TL_video_layer45();
                break;
            case 948937617:
                tLRPC$TL_video_layer45 = new TLRPC$TL_video_layer45() { // from class: ir.eitaa.tgnet.TLRPC$TL_video_old2
                    public static int constructor = 948937617;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_video_layer45, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.user_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.caption = stream2.readString(exception2);
                        this.duration = stream2.readInt32(exception2);
                        this.mime_type = stream2.readString(exception2);
                        this.size = stream2.readInt32(exception2);
                        this.thumb = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2);
                        this.dc_id = stream2.readInt32(exception2);
                        this.w = stream2.readInt32(exception2);
                        this.h = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_video_layer45, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.caption);
                        stream2.writeInt32(this.duration);
                        stream2.writeString(this.mime_type);
                        stream2.writeInt32(this.size);
                        this.thumb.serializeToStream(stream2);
                        stream2.writeInt32(this.dc_id);
                        stream2.writeInt32(this.w);
                        stream2.writeInt32(this.h);
                    }
                };
                break;
            case 1431655763:
                tLRPC$TL_video_layer45 = new TLRPC$TL_video_layer45() { // from class: ir.eitaa.tgnet.TLRPC$TL_videoEncrypted
                    public static int constructor = 1431655763;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_video_layer45, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.user_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.caption = stream2.readString(exception2);
                        this.duration = stream2.readInt32(exception2);
                        this.size = stream2.readInt32(exception2);
                        this.thumb = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2);
                        this.dc_id = stream2.readInt32(exception2);
                        this.w = stream2.readInt32(exception2);
                        this.h = stream2.readInt32(exception2);
                        this.key = stream2.readByteArray(exception2);
                        this.iv = stream2.readByteArray(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_video_layer45, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.caption);
                        stream2.writeInt32(this.duration);
                        stream2.writeInt32(this.size);
                        this.thumb.serializeToStream(stream2);
                        stream2.writeInt32(this.dc_id);
                        stream2.writeInt32(this.w);
                        stream2.writeInt32(this.h);
                        stream2.writeByteArray(this.key);
                        stream2.writeByteArray(this.iv);
                    }
                };
                break;
            case 1510253727:
                tLRPC$TL_video_layer45 = new TLRPC$TL_video_layer45() { // from class: ir.eitaa.tgnet.TLRPC$TL_video_old
                    public static int constructor = 1510253727;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_video_layer45, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.user_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.caption = stream2.readString(exception2);
                        this.duration = stream2.readInt32(exception2);
                        this.size = stream2.readInt32(exception2);
                        this.thumb = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2);
                        this.dc_id = stream2.readInt32(exception2);
                        this.w = stream2.readInt32(exception2);
                        this.h = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_video_layer45, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.caption);
                        stream2.writeInt32(this.duration);
                        stream2.writeInt32(this.size);
                        this.thumb.serializeToStream(stream2);
                        stream2.writeInt32(this.dc_id);
                        stream2.writeInt32(this.w);
                        stream2.writeInt32(this.h);
                    }
                };
                break;
            default:
                tLRPC$TL_video_layer45 = null;
                break;
        }
        if (tLRPC$TL_video_layer45 == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Video", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_video_layer45 != null) {
            tLRPC$TL_video_layer45.readParams(stream, exception);
        }
        return tLRPC$TL_video_layer45;
    }
}
