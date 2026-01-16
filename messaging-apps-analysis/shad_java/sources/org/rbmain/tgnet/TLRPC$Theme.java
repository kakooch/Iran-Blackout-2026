package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$Theme extends TLObject {
    public static TLRPC$TL_theme TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$TL_theme tLRPC$TL_theme;
        if (i == -1609668650) {
            tLRPC$TL_theme = new TLRPC$TL_theme();
        } else if (i == -136770336) {
            tLRPC$TL_theme = new TLRPC$TL_theme() { // from class: org.rbmain.tgnet.TLRPC$TL_theme_layer106
                public static int constructor = -136770336;

                @Override // org.rbmain.tgnet.TLRPC$TL_theme, org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    int int32 = abstractSerializedData2.readInt32(z2);
                    this.flags = int32;
                    this.creator = (int32 & 1) != 0;
                    this.isDefault = (int32 & 2) != 0;
                    this.id = abstractSerializedData2.readInt64(z2);
                    this.access_hash = abstractSerializedData2.readInt64(z2);
                    this.slug = abstractSerializedData2.readString(z2);
                    this.title = abstractSerializedData2.readString(z2);
                    if ((this.flags & 4) != 0) {
                        this.document = TLRPC$Document.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }
                    this.installs_count = abstractSerializedData2.readInt32(z2);
                }

                @Override // org.rbmain.tgnet.TLRPC$TL_theme, org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    int i2 = this.creator ? this.flags | 1 : this.flags & (-2);
                    this.flags = i2;
                    int i3 = this.isDefault ? i2 | 2 : i2 & (-3);
                    this.flags = i3;
                    abstractSerializedData2.writeInt32(i3);
                    abstractSerializedData2.writeInt64(this.id);
                    abstractSerializedData2.writeInt64(this.access_hash);
                    abstractSerializedData2.writeString(this.slug);
                    abstractSerializedData2.writeString(this.title);
                    if ((this.flags & 4) != 0) {
                        this.document.serializeToStream(abstractSerializedData2);
                    }
                    abstractSerializedData2.writeInt32(this.installs_count);
                }
            };
        } else {
            tLRPC$TL_theme = i != 1211967244 ? null : new TLRPC$TL_theme() { // from class: org.rbmain.tgnet.TLRPC$TL_themeDocumentNotModified_layer106
                public static int constructor = 1211967244;

                @Override // org.rbmain.tgnet.TLRPC$TL_theme, org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$TL_theme == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Theme", Integer.valueOf(i)));
        }
        if (tLRPC$TL_theme != null) {
            tLRPC$TL_theme.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_theme;
    }
}
