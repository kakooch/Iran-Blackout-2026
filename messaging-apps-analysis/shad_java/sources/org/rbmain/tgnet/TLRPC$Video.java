package org.rbmain.tgnet;

/* loaded from: classes4.dex */
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
    public int user_id;
    public int w;

    public static TLRPC$Video TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Video tLRPC$TL_video_layer45;
        switch (i) {
            case -1056548696:
                tLRPC$TL_video_layer45 = new TLRPC$Video() { // from class: org.rbmain.tgnet.TLRPC$TL_videoEmpty_layer45
                    public static int constructor = -1056548696;

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
            case -291550643:
                tLRPC$TL_video_layer45 = new TLRPC$TL_video_layer45() { // from class: org.rbmain.tgnet.TLRPC$TL_video_old3
                    public static int constructor = -291550643;

                    @Override // org.rbmain.tgnet.TLRPC$TL_video_layer45, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.user_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.duration = abstractSerializedData2.readInt32(z2);
                        this.size = abstractSerializedData2.readInt32(z2);
                        this.thumb = TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                        this.w = abstractSerializedData2.readInt32(z2);
                        this.h = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_video_layer45, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.user_id);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeInt32(this.duration);
                        abstractSerializedData2.writeInt32(this.size);
                        this.thumb.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(this.dc_id);
                        abstractSerializedData2.writeInt32(this.w);
                        abstractSerializedData2.writeInt32(this.h);
                    }
                };
                break;
            case -148338733:
                tLRPC$TL_video_layer45 = new TLRPC$TL_video_layer45();
                break;
            case 948937617:
                tLRPC$TL_video_layer45 = new TLRPC$TL_video_layer45() { // from class: org.rbmain.tgnet.TLRPC$TL_video_old2
                    public static int constructor = 948937617;

                    @Override // org.rbmain.tgnet.TLRPC$TL_video_layer45, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.user_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.caption = abstractSerializedData2.readString(z2);
                        this.duration = abstractSerializedData2.readInt32(z2);
                        this.mime_type = abstractSerializedData2.readString(z2);
                        this.size = abstractSerializedData2.readInt32(z2);
                        this.thumb = TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                        this.w = abstractSerializedData2.readInt32(z2);
                        this.h = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_video_layer45, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.user_id);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.caption);
                        abstractSerializedData2.writeInt32(this.duration);
                        abstractSerializedData2.writeString(this.mime_type);
                        abstractSerializedData2.writeInt32(this.size);
                        this.thumb.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(this.dc_id);
                        abstractSerializedData2.writeInt32(this.w);
                        abstractSerializedData2.writeInt32(this.h);
                    }
                };
                break;
            case 1431655763:
                tLRPC$TL_video_layer45 = new TLRPC$TL_video_layer45() { // from class: org.rbmain.tgnet.TLRPC$TL_videoEncrypted
                    public static int constructor = 1431655763;

                    @Override // org.rbmain.tgnet.TLRPC$TL_video_layer45, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.user_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.caption = abstractSerializedData2.readString(z2);
                        this.duration = abstractSerializedData2.readInt32(z2);
                        this.size = abstractSerializedData2.readInt32(z2);
                        this.thumb = TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                        this.w = abstractSerializedData2.readInt32(z2);
                        this.h = abstractSerializedData2.readInt32(z2);
                        this.key = abstractSerializedData2.readByteArray(z2);
                        this.iv = abstractSerializedData2.readByteArray(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_video_layer45, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.user_id);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.caption);
                        abstractSerializedData2.writeInt32(this.duration);
                        abstractSerializedData2.writeInt32(this.size);
                        this.thumb.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(this.dc_id);
                        abstractSerializedData2.writeInt32(this.w);
                        abstractSerializedData2.writeInt32(this.h);
                        abstractSerializedData2.writeByteArray(this.key);
                        abstractSerializedData2.writeByteArray(this.iv);
                    }
                };
                break;
            case 1510253727:
                tLRPC$TL_video_layer45 = new TLRPC$TL_video_layer45() { // from class: org.rbmain.tgnet.TLRPC$TL_video_old
                    public static int constructor = 1510253727;

                    @Override // org.rbmain.tgnet.TLRPC$TL_video_layer45, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.user_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.caption = abstractSerializedData2.readString(z2);
                        this.duration = abstractSerializedData2.readInt32(z2);
                        this.size = abstractSerializedData2.readInt32(z2);
                        this.thumb = TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                        this.w = abstractSerializedData2.readInt32(z2);
                        this.h = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_video_layer45, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.user_id);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.caption);
                        abstractSerializedData2.writeInt32(this.duration);
                        abstractSerializedData2.writeInt32(this.size);
                        this.thumb.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(this.dc_id);
                        abstractSerializedData2.writeInt32(this.w);
                        abstractSerializedData2.writeInt32(this.h);
                    }
                };
                break;
            default:
                tLRPC$TL_video_layer45 = null;
                break;
        }
        if (tLRPC$TL_video_layer45 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Video", Integer.valueOf(i)));
        }
        if (tLRPC$TL_video_layer45 != null) {
            tLRPC$TL_video_layer45.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_video_layer45;
    }
}
