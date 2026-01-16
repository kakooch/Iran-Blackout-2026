package org.rbmain.tgnet;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
public abstract class TLRPC$WallPaper extends TLObject {
    public long access_hash;
    public boolean creator;
    public boolean dark;
    public TLRPC$Document document;
    public TLRPC$Document documentMain;
    public int flags;
    public long id;
    public boolean isDefault;
    public boolean pattern;
    public TLRPC$WallPaperSettings settings;
    public String slug;
    public Bitmap stripedThumb;
    public String uploadingImage;

    public static TLRPC$WallPaper TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$WallPaper tLRPC$TL_wallPaper;
        if (i == -1963717851) {
            tLRPC$TL_wallPaper = new TLRPC$WallPaper() { // from class: org.rbmain.tgnet.TLRPC$TL_wallPaperNoFile
                public static int constructor = -1963717851;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    int int32 = abstractSerializedData2.readInt32(z2);
                    this.flags = int32;
                    this.isDefault = (int32 & 2) != 0;
                    this.dark = (int32 & 16) != 0;
                    if ((int32 & 4) != 0) {
                        this.settings = TLRPC$WallPaperSettings.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    int i2 = this.isDefault ? this.flags | 2 : this.flags & (-3);
                    this.flags = i2;
                    int i3 = this.dark ? i2 | 16 : i2 & (-17);
                    this.flags = i3;
                    abstractSerializedData2.writeInt32(i3);
                    if ((this.flags & 4) != 0) {
                        this.settings.serializeToStream(abstractSerializedData2);
                    }
                }
            };
        } else if (i == -1539849235) {
            tLRPC$TL_wallPaper = new TLRPC$TL_wallPaper();
        } else {
            tLRPC$TL_wallPaper = i != -263220756 ? null : new TLRPC$TL_wallPaper() { // from class: org.rbmain.tgnet.TLRPC$TL_wallPaper_layer94
                public static int constructor = -263220756;

                @Override // org.rbmain.tgnet.TLRPC$TL_wallPaper, org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.id = abstractSerializedData2.readInt64(z2);
                    int int32 = abstractSerializedData2.readInt32(z2);
                    this.flags = int32;
                    this.creator = (int32 & 1) != 0;
                    this.isDefault = (int32 & 2) != 0;
                    this.access_hash = abstractSerializedData2.readInt64(z2);
                    this.slug = abstractSerializedData2.readString(z2);
                    this.document = TLRPC$Document.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                }

                @Override // org.rbmain.tgnet.TLRPC$TL_wallPaper, org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeInt64(this.id);
                    int i2 = this.creator ? this.flags | 1 : this.flags & (-2);
                    this.flags = i2;
                    int i3 = this.isDefault ? i2 | 2 : i2 & (-3);
                    this.flags = i3;
                    abstractSerializedData2.writeInt32(i3);
                    abstractSerializedData2.writeInt64(this.access_hash);
                    abstractSerializedData2.writeString(this.slug);
                    this.document.serializeToStream(abstractSerializedData2);
                }
            };
        }
        if (tLRPC$TL_wallPaper == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in WallPaper", Integer.valueOf(i)));
        }
        if (tLRPC$TL_wallPaper != null) {
            tLRPC$TL_wallPaper.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_wallPaper;
    }
}
