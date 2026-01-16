package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$Theme extends TLObject {
    public static TLRPC$Theme TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$Theme tLRPC$TL_theme;
        switch (constructor) {
            case -402474788:
                tLRPC$TL_theme = new TLRPC$TL_theme();
                break;
            case -136770336:
                tLRPC$TL_theme = new TLRPC$TL_theme() { // from class: ir.eitaa.tgnet.TLRPC$TL_theme_layer106
                    public static int constructor = -136770336;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_theme, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.isDefault = (int32 & 2) != 0;
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.slug = stream2.readString(exception2);
                        this.title = stream2.readString(exception2);
                        if ((this.flags & 4) != 0) {
                            this.document = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.installs_count = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_theme, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.isDefault ? i | 2 : i & (-3);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.slug);
                        stream2.writeString(this.title);
                        if ((this.flags & 4) != 0) {
                            this.document.serializeToStream(stream2);
                        }
                        stream2.writeInt32(this.installs_count);
                    }
                };
                break;
            case 42930452:
                tLRPC$TL_theme = new TLRPC$TL_theme() { // from class: ir.eitaa.tgnet.TLRPC$TL_theme_layer131
                    public static int constructor = 42930452;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_theme, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.creator = (int32 & 1) != 0;
                        this.isDefault = (int32 & 2) != 0;
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.slug = stream2.readString(exception2);
                        this.title = stream2.readString(exception2);
                        if ((this.flags & 4) != 0) {
                            this.document = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.settings = TLRPC$ThemeSettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.installs_count = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_theme, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.creator ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.isDefault ? i | 2 : i & (-3);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeString(this.slug);
                        stream2.writeString(this.title);
                        if ((this.flags & 4) != 0) {
                            this.document.serializeToStream(stream2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.settings.serializeToStream(stream2);
                        }
                        stream2.writeInt32(this.installs_count);
                    }
                };
                break;
            case 1211967244:
                tLRPC$TL_theme = new TLRPC$Theme() { // from class: ir.eitaa.tgnet.TLRPC$TL_themeDocumentNotModified_layer106
                    public static int constructor = 1211967244;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            default:
                tLRPC$TL_theme = null;
                break;
        }
        if (tLRPC$TL_theme == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Theme", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_theme != null) {
            tLRPC$TL_theme.readParams(stream, exception);
        }
        return tLRPC$TL_theme;
    }
}
