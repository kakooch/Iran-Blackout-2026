package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_wallPaper extends TLRPC$WallPaper {
    public static int constructor = -1539849235;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.id = abstractSerializedData.readInt64(z);
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.creator = (int32 & 1) != 0;
        this.isDefault = (int32 & 2) != 0;
        this.pattern = (int32 & 8) != 0;
        this.dark = (int32 & 16) != 0;
        this.access_hash = abstractSerializedData.readInt64(z);
        this.slug = abstractSerializedData.readString(z);
        this.document = TLRPC$Document.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if ((this.flags & 4) != 0) {
            this.settings = TLRPC$WallPaperSettings.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt64(this.id);
        int i = this.creator ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.isDefault ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.pattern ? i2 | 8 : i2 & (-9);
        this.flags = i3;
        int i4 = this.dark ? i3 | 16 : i3 & (-17);
        this.flags = i4;
        abstractSerializedData.writeInt32(i4);
        abstractSerializedData.writeInt64(this.access_hash);
        abstractSerializedData.writeString(this.slug);
        this.document.serializeToStream(abstractSerializedData);
        if ((this.flags & 4) != 0) {
            this.settings.serializeToStream(abstractSerializedData);
        }
    }
}
