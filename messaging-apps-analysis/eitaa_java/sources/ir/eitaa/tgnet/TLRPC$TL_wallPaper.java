package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_wallPaper extends TLRPC$WallPaper {
    public static int constructor = -1539849235;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt64(exception);
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.creator = (int32 & 1) != 0;
        this.isDefault = (int32 & 2) != 0;
        this.pattern = (int32 & 8) != 0;
        this.dark = (int32 & 16) != 0;
        this.access_hash = stream.readInt64(exception);
        this.slug = stream.readString(exception);
        this.document = TLRPC$Document.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 4) != 0) {
            this.settings = TLRPC$WallPaperSettings.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
        int i = this.creator ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.isDefault ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.pattern ? i2 | 8 : i2 & (-9);
        this.flags = i3;
        int i4 = this.dark ? i3 | 16 : i3 & (-17);
        this.flags = i4;
        stream.writeInt32(i4);
        stream.writeInt64(this.access_hash);
        stream.writeString(this.slug);
        this.document.serializeToStream(stream);
        if ((this.flags & 4) != 0) {
            this.settings.serializeToStream(stream);
        }
    }
}
