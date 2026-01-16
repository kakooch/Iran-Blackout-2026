package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$DocumentAttribute extends TLObject {
    public String alt;
    public int duration;
    public String file_name;
    public int flags;
    public int h;
    public boolean mask;
    public TLRPC$TL_maskCoords mask_coords;
    public String performer;
    public boolean round_message;
    public TLRPC$InputStickerSet stickerset;
    public boolean supports_streaming;
    public String title;
    public boolean voice;
    public int w;
    public byte[] waveform;

    public static TLRPC$DocumentAttribute TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$DocumentAttribute tLRPC$TL_documentAttributeHasStickers;
        switch (constructor) {
            case -1744710921:
                tLRPC$TL_documentAttributeHasStickers = new TLRPC$TL_documentAttributeHasStickers();
                break;
            case -1739392570:
                tLRPC$TL_documentAttributeHasStickers = new TLRPC$TL_documentAttributeAudio();
                break;
            case -1723033470:
                tLRPC$TL_documentAttributeHasStickers = new TLRPC$TL_documentAttributeSticker() { // from class: ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker_old2
                    public static int constructor = -1723033470;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.alt = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.alt);
                    }
                };
                break;
            case -556656416:
                tLRPC$TL_documentAttributeHasStickers = new TLRPC$TL_documentAttributeAudio() { // from class: ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio_layer45
                    public static int constructor = -556656416;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.duration = stream2.readInt32(exception2);
                        this.title = stream2.readString(exception2);
                        this.performer = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.duration);
                        stream2.writeString(this.title);
                        stream2.writeString(this.performer);
                    }
                };
                break;
            case -83208409:
                tLRPC$TL_documentAttributeHasStickers = new TLRPC$TL_documentAttributeSticker() { // from class: ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker_old
                    public static int constructor = -83208409;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 85215461:
                tLRPC$TL_documentAttributeHasStickers = new TLRPC$TL_documentAttributeAudio() { // from class: ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio_old
                    public static int constructor = 85215461;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.duration = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.duration);
                    }
                };
                break;
            case 250621158:
                tLRPC$TL_documentAttributeHasStickers = new TLRPC$TL_documentAttributeVideo();
                break;
            case 297109817:
                tLRPC$TL_documentAttributeHasStickers = new TLRPC$TL_documentAttributeAnimated();
                break;
            case 358154344:
                tLRPC$TL_documentAttributeHasStickers = new TLRPC$TL_documentAttributeFilename();
                break;
            case 978674434:
                tLRPC$TL_documentAttributeHasStickers = new TLRPC$TL_documentAttributeSticker_layer55();
                break;
            case 1494273227:
                tLRPC$TL_documentAttributeHasStickers = new TLRPC$TL_documentAttributeVideo() { // from class: ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo_layer65
                    public static int constructor = 1494273227;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.duration = stream2.readInt32(exception2);
                        this.w = stream2.readInt32(exception2);
                        this.h = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.duration);
                        stream2.writeInt32(this.w);
                        stream2.writeInt32(this.h);
                    }
                };
                break;
            case 1662637586:
                tLRPC$TL_documentAttributeHasStickers = new TLRPC$TL_documentAttributeSticker();
                break;
            case 1815593308:
                tLRPC$TL_documentAttributeHasStickers = new TLRPC$TL_documentAttributeImageSize();
                break;
            default:
                tLRPC$TL_documentAttributeHasStickers = null;
                break;
        }
        if (tLRPC$TL_documentAttributeHasStickers == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in DocumentAttribute", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_documentAttributeHasStickers != null) {
            tLRPC$TL_documentAttributeHasStickers.readParams(stream, exception);
        }
        return tLRPC$TL_documentAttributeHasStickers;
    }
}
