package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$Page extends TLObject {
    public int flags;
    public boolean part;
    public boolean rtl;
    public String url;
    public boolean v2;
    public int views;
    public ArrayList<TLRPC$PageBlock> blocks = new ArrayList<>();
    public ArrayList<TLRPC$Photo> photos = new ArrayList<>();
    public ArrayList<TLRPC$Document> documents = new ArrayList<>();

    public static TLRPC$Page TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Page tLRPC$TL_pagePart_layer82;
        switch (i) {
            case -1913754556:
                tLRPC$TL_pagePart_layer82 = new TLRPC$TL_pagePart_layer82() { // from class: org.rbmain.tgnet.TLRPC$TL_pagePart_layer67
                    public static int constructor = -1913754556;

                    @Override // org.rbmain.tgnet.TLRPC$TL_pagePart_layer82, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int322; i2++) {
                            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PageBlockTLdeserialize == null) {
                                return;
                            }
                            this.blocks.add(tLRPC$PageBlockTLdeserialize);
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        if (int323 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                            }
                            return;
                        }
                        int int324 = abstractSerializedData2.readInt32(z2);
                        for (int i3 = 0; i3 < int324; i3++) {
                            TLRPC$Photo tLRPC$PhotoTLdeserialize = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PhotoTLdeserialize == null) {
                                return;
                            }
                            this.photos.add(tLRPC$PhotoTLdeserialize);
                        }
                        int int325 = abstractSerializedData2.readInt32(z2);
                        if (int325 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
                            }
                            return;
                        }
                        int int326 = abstractSerializedData2.readInt32(z2);
                        for (int i4 = 0; i4 < int326; i4++) {
                            TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$DocumentTLdeserialize == null) {
                                return;
                            }
                            this.documents.add(tLRPC$DocumentTLdeserialize);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_pagePart_layer82, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.blocks.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.blocks.get(i2).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size2 = this.photos.size();
                        abstractSerializedData2.writeInt32(size2);
                        for (int i3 = 0; i3 < size2; i3++) {
                            this.photos.get(i3).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size3 = this.documents.size();
                        abstractSerializedData2.writeInt32(size3);
                        for (int i4 = 0; i4 < size3; i4++) {
                            this.documents.get(i4).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case -1908433218:
                tLRPC$TL_pagePart_layer82 = new TLRPC$TL_pagePart_layer82();
                break;
            case -1738178803:
                tLRPC$TL_pagePart_layer82 = new TLRPC$TL_page();
                break;
            case -1366746132:
                tLRPC$TL_pagePart_layer82 = new TLRPC$TL_page() { // from class: org.rbmain.tgnet.TLRPC$TL_page_layer110
                    public static int constructor = -1366746132;

                    @Override // org.rbmain.tgnet.TLRPC$TL_page, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.part = (int32 & 1) != 0;
                        this.rtl = (int32 & 2) != 0;
                        this.url = abstractSerializedData2.readString(z2);
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PageBlockTLdeserialize == null) {
                                return;
                            }
                            this.blocks.add(tLRPC$PageBlockTLdeserialize);
                        }
                        int int324 = abstractSerializedData2.readInt32(z2);
                        if (int324 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                            }
                            return;
                        }
                        int int325 = abstractSerializedData2.readInt32(z2);
                        for (int i3 = 0; i3 < int325; i3++) {
                            TLRPC$Photo tLRPC$PhotoTLdeserialize = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PhotoTLdeserialize == null) {
                                return;
                            }
                            this.photos.add(tLRPC$PhotoTLdeserialize);
                        }
                        int int326 = abstractSerializedData2.readInt32(z2);
                        if (int326 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int326)));
                            }
                            return;
                        }
                        int int327 = abstractSerializedData2.readInt32(z2);
                        for (int i4 = 0; i4 < int327; i4++) {
                            TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$DocumentTLdeserialize == null) {
                                return;
                            }
                            this.documents.add(tLRPC$DocumentTLdeserialize);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_page, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.part ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.rtl ? i2 | 2 : i2 & (-3);
                        this.flags = i3;
                        abstractSerializedData2.writeInt32(i3);
                        abstractSerializedData2.writeString(this.url);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.blocks.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i4 = 0; i4 < size; i4++) {
                            this.blocks.get(i4).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size2 = this.photos.size();
                        abstractSerializedData2.writeInt32(size2);
                        for (int i5 = 0; i5 < size2; i5++) {
                            this.photos.get(i5).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size3 = this.documents.size();
                        abstractSerializedData2.writeInt32(size3);
                        for (int i6 = 0; i6 < size3; i6++) {
                            this.documents.get(i6).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case -677274263:
                tLRPC$TL_pagePart_layer82 = new TLRPC$TL_page() { // from class: org.rbmain.tgnet.TLRPC$TL_pageFull_layer67
                    public static int constructor = -677274263;

                    @Override // org.rbmain.tgnet.TLRPC$TL_page, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int322; i2++) {
                            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PageBlockTLdeserialize == null) {
                                return;
                            }
                            this.blocks.add(tLRPC$PageBlockTLdeserialize);
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        if (int323 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                            }
                            return;
                        }
                        int int324 = abstractSerializedData2.readInt32(z2);
                        for (int i3 = 0; i3 < int324; i3++) {
                            TLRPC$Photo tLRPC$PhotoTLdeserialize = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PhotoTLdeserialize == null) {
                                return;
                            }
                            this.photos.add(tLRPC$PhotoTLdeserialize);
                        }
                        int int325 = abstractSerializedData2.readInt32(z2);
                        if (int325 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
                            }
                            return;
                        }
                        int int326 = abstractSerializedData2.readInt32(z2);
                        for (int i4 = 0; i4 < int326; i4++) {
                            TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$DocumentTLdeserialize == null) {
                                return;
                            }
                            this.documents.add(tLRPC$DocumentTLdeserialize);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_page, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.blocks.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.blocks.get(i2).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size2 = this.photos.size();
                        abstractSerializedData2.writeInt32(size2);
                        for (int i3 = 0; i3 < size2; i3++) {
                            this.photos.get(i3).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size3 = this.documents.size();
                        abstractSerializedData2.writeInt32(size3);
                        for (int i4 = 0; i4 < size3; i4++) {
                            this.documents.get(i4).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case 1433323434:
                tLRPC$TL_pagePart_layer82 = new TLRPC$TL_page() { // from class: org.rbmain.tgnet.TLRPC$TL_pageFull_layer82
                    public static int constructor = 1433323434;

                    @Override // org.rbmain.tgnet.TLRPC$TL_page, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int322; i2++) {
                            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PageBlockTLdeserialize == null) {
                                return;
                            }
                            this.blocks.add(tLRPC$PageBlockTLdeserialize);
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        if (int323 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                            }
                            return;
                        }
                        int int324 = abstractSerializedData2.readInt32(z2);
                        for (int i3 = 0; i3 < int324; i3++) {
                            TLRPC$Photo tLRPC$PhotoTLdeserialize = TLRPC$Photo.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$PhotoTLdeserialize == null) {
                                return;
                            }
                            this.photos.add(tLRPC$PhotoTLdeserialize);
                        }
                        int int325 = abstractSerializedData2.readInt32(z2);
                        if (int325 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
                            }
                            return;
                        }
                        int int326 = abstractSerializedData2.readInt32(z2);
                        for (int i4 = 0; i4 < int326; i4++) {
                            TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$DocumentTLdeserialize == null) {
                                return;
                            }
                            this.documents.add(tLRPC$DocumentTLdeserialize);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_page, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.blocks.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.blocks.get(i2).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size2 = this.photos.size();
                        abstractSerializedData2.writeInt32(size2);
                        for (int i3 = 0; i3 < size2; i3++) {
                            this.photos.get(i3).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size3 = this.documents.size();
                        abstractSerializedData2.writeInt32(size3);
                        for (int i4 = 0; i4 < size3; i4++) {
                            this.documents.get(i4).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            default:
                tLRPC$TL_pagePart_layer82 = null;
                break;
        }
        if (tLRPC$TL_pagePart_layer82 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Page", Integer.valueOf(i)));
        }
        if (tLRPC$TL_pagePart_layer82 != null) {
            tLRPC$TL_pagePart_layer82.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_pagePart_layer82;
    }
}
