package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$WallPaper extends TLObject {
    public long access_hash;
    public boolean creator;
    public boolean dark;
    public TLRPC$Document document;
    public int flags;
    public long id;
    public boolean isDefault;
    public boolean pattern;
    public TLRPC$WallPaperSettings settings;
    public String slug;

    public static TLRPC$WallPaper TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$WallPaper tLRPC$TL_wallPaper;
        switch (constructor) {
            case -1963717851:
                tLRPC$TL_wallPaper = new TLRPC$TL_wallPaperNoFile() { // from class: ir.eitaa.tgnet.TLRPC$TL_wallPaperNoFile_layer128
                    public static int constructor = -1963717851;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_wallPaperNoFile, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.isDefault = (int32 & 2) != 0;
                        this.dark = (int32 & 16) != 0;
                        if ((int32 & 4) != 0) {
                            this.settings = TLRPC$WallPaperSettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_wallPaperNoFile, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.isDefault ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.dark ? i | 16 : i & (-17);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        if ((this.flags & 4) != 0) {
                            this.settings.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -1539849235:
                tLRPC$TL_wallPaper = new TLRPC$TL_wallPaper();
                break;
            case -528465642:
                tLRPC$TL_wallPaper = new TLRPC$TL_wallPaperNoFile();
                break;
            case -263220756:
                tLRPC$TL_wallPaper = new TLRPC$TL_wallPaper() { // from class: ir.eitaa.tgnet.TLRPC$TL_wallPaper_layer94
                    public static int constructor = -263220756;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_wallPaper, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.isDefault = (int32 & 2) != 0;
                        this.access_hash = stream2.readInt64(exception2);
                        this.slug = stream2.readString(exception2);
                        this.document = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_wallPaper, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.isDefault ? i | 2 : i & (-3);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.slug);
                        this.document.serializeToStream(stream2);
                    }
                };
                break;
            default:
                tLRPC$TL_wallPaper = null;
                break;
        }
        if (tLRPC$TL_wallPaper == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in WallPaper", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_wallPaper != null) {
            tLRPC$TL_wallPaper.readParams(stream, exception);
        }
        return tLRPC$TL_wallPaper;
    }
}
