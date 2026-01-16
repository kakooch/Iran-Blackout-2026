package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_theme extends TLRPC$Theme {
    public static int constructor = -402474788;
    public long access_hash;
    public boolean creator;
    public TLRPC$Document document;
    public int flags;
    public boolean for_chat;
    public long id;
    public int installs_count;
    public boolean isDefault;
    public TLRPC$ThemeSettings settings;
    public String slug;
    public String title;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.creator = (int32 & 1) != 0;
        this.isDefault = (int32 & 2) != 0;
        this.for_chat = (int32 & 32) != 0;
        this.id = stream.readInt64(exception);
        this.access_hash = stream.readInt64(exception);
        this.slug = stream.readString(exception);
        this.title = stream.readString(exception);
        if ((this.flags & 4) != 0) {
            this.document = TLRPC$Document.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 8) != 0) {
            this.settings = TLRPC$ThemeSettings.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 16) != 0) {
            this.installs_count = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.creator ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.isDefault ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.for_chat ? i2 | 32 : i2 & (-33);
        this.flags = i3;
        stream.writeInt32(i3);
        stream.writeInt64(this.id);
        stream.writeInt64(this.access_hash);
        stream.writeString(this.slug);
        stream.writeString(this.title);
        if ((this.flags & 4) != 0) {
            this.document.serializeToStream(stream);
        }
        if ((this.flags & 8) != 0) {
            this.settings.serializeToStream(stream);
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt32(this.installs_count);
        }
    }
}
