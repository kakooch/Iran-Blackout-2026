package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
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

    public static TLRPC$Page TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$Page tLRPC$TL_pagePart_layer82;
        switch (constructor) {
            case -1913754556:
                tLRPC$TL_pagePart_layer82 = new TLRPC$TL_pagePart_layer82() { // from class: ir.eitaa.tgnet.TLRPC$TL_pagePart_layer67
                    public static int constructor = -1913754556;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pagePart_layer82, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PageBlockTLdeserialize == null) {
                                return;
                            }
                            this.blocks.add(tLRPC$PageBlockTLdeserialize);
                        }
                        int int323 = stream2.readInt32(exception2);
                        if (int323 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                            }
                            return;
                        }
                        int int324 = stream2.readInt32(exception2);
                        for (int i2 = 0; i2 < int324; i2++) {
                            TLRPC$Photo tLRPC$PhotoTLdeserialize = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PhotoTLdeserialize == null) {
                                return;
                            }
                            this.photos.add(tLRPC$PhotoTLdeserialize);
                        }
                        int int325 = stream2.readInt32(exception2);
                        if (int325 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
                            }
                            return;
                        }
                        int int326 = stream2.readInt32(exception2);
                        for (int i3 = 0; i3 < int326; i3++) {
                            TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$DocumentTLdeserialize == null) {
                                return;
                            }
                            this.documents.add(tLRPC$DocumentTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pagePart_layer82, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(481674261);
                        int size = this.blocks.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.blocks.get(i).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size2 = this.photos.size();
                        stream2.writeInt32(size2);
                        for (int i2 = 0; i2 < size2; i2++) {
                            this.photos.get(i2).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size3 = this.documents.size();
                        stream2.writeInt32(size3);
                        for (int i3 = 0; i3 < size3; i3++) {
                            this.documents.get(i3).serializeToStream(stream2);
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
                tLRPC$TL_pagePart_layer82 = new TLRPC$TL_page() { // from class: ir.eitaa.tgnet.TLRPC$TL_page_layer110
                    public static int constructor = -1366746132;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_page, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.part = (int32 & 1) != 0;
                        this.rtl = (int32 & 2) != 0;
                        this.url = stream2.readString(exception2);
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PageBlockTLdeserialize == null) {
                                return;
                            }
                            this.blocks.add(tLRPC$PageBlockTLdeserialize);
                        }
                        int int324 = stream2.readInt32(exception2);
                        if (int324 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                            }
                            return;
                        }
                        int int325 = stream2.readInt32(exception2);
                        for (int i2 = 0; i2 < int325; i2++) {
                            TLRPC$Photo tLRPC$PhotoTLdeserialize = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PhotoTLdeserialize == null) {
                                return;
                            }
                            this.photos.add(tLRPC$PhotoTLdeserialize);
                        }
                        int int326 = stream2.readInt32(exception2);
                        if (int326 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int326)));
                            }
                            return;
                        }
                        int int327 = stream2.readInt32(exception2);
                        for (int i3 = 0; i3 < int327; i3++) {
                            TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$DocumentTLdeserialize == null) {
                                return;
                            }
                            this.documents.add(tLRPC$DocumentTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_page, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.part ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.rtl ? i | 2 : i & (-3);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeString(this.url);
                        stream2.writeInt32(481674261);
                        int size = this.blocks.size();
                        stream2.writeInt32(size);
                        for (int i3 = 0; i3 < size; i3++) {
                            this.blocks.get(i3).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size2 = this.photos.size();
                        stream2.writeInt32(size2);
                        for (int i4 = 0; i4 < size2; i4++) {
                            this.photos.get(i4).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size3 = this.documents.size();
                        stream2.writeInt32(size3);
                        for (int i5 = 0; i5 < size3; i5++) {
                            this.documents.get(i5).serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -677274263:
                tLRPC$TL_pagePart_layer82 = new TLRPC$TL_page() { // from class: ir.eitaa.tgnet.TLRPC$TL_pageFull_layer67
                    public static int constructor = -677274263;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_page, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PageBlockTLdeserialize == null) {
                                return;
                            }
                            this.blocks.add(tLRPC$PageBlockTLdeserialize);
                        }
                        int int323 = stream2.readInt32(exception2);
                        if (int323 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                            }
                            return;
                        }
                        int int324 = stream2.readInt32(exception2);
                        for (int i2 = 0; i2 < int324; i2++) {
                            TLRPC$Photo tLRPC$PhotoTLdeserialize = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PhotoTLdeserialize == null) {
                                return;
                            }
                            this.photos.add(tLRPC$PhotoTLdeserialize);
                        }
                        int int325 = stream2.readInt32(exception2);
                        if (int325 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
                            }
                            return;
                        }
                        int int326 = stream2.readInt32(exception2);
                        for (int i3 = 0; i3 < int326; i3++) {
                            TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$DocumentTLdeserialize == null) {
                                return;
                            }
                            this.documents.add(tLRPC$DocumentTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_page, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(481674261);
                        int size = this.blocks.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.blocks.get(i).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size2 = this.photos.size();
                        stream2.writeInt32(size2);
                        for (int i2 = 0; i2 < size2; i2++) {
                            this.photos.get(i2).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size3 = this.documents.size();
                        stream2.writeInt32(size3);
                        for (int i3 = 0; i3 < size3; i3++) {
                            this.documents.get(i3).serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 1433323434:
                tLRPC$TL_pagePart_layer82 = new TLRPC$TL_page() { // from class: ir.eitaa.tgnet.TLRPC$TL_pageFull_layer82
                    public static int constructor = 1433323434;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_page, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PageBlockTLdeserialize == null) {
                                return;
                            }
                            this.blocks.add(tLRPC$PageBlockTLdeserialize);
                        }
                        int int323 = stream2.readInt32(exception2);
                        if (int323 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                            }
                            return;
                        }
                        int int324 = stream2.readInt32(exception2);
                        for (int i2 = 0; i2 < int324; i2++) {
                            TLRPC$Photo tLRPC$PhotoTLdeserialize = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PhotoTLdeserialize == null) {
                                return;
                            }
                            this.photos.add(tLRPC$PhotoTLdeserialize);
                        }
                        int int325 = stream2.readInt32(exception2);
                        if (int325 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
                            }
                            return;
                        }
                        int int326 = stream2.readInt32(exception2);
                        for (int i3 = 0; i3 < int326; i3++) {
                            TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$DocumentTLdeserialize == null) {
                                return;
                            }
                            this.documents.add(tLRPC$DocumentTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_page, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(481674261);
                        int size = this.blocks.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.blocks.get(i).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size2 = this.photos.size();
                        stream2.writeInt32(size2);
                        for (int i2 = 0; i2 < size2; i2++) {
                            this.photos.get(i2).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size3 = this.documents.size();
                        stream2.writeInt32(size3);
                        for (int i3 = 0; i3 < size3; i3++) {
                            this.documents.get(i3).serializeToStream(stream2);
                        }
                    }
                };
                break;
            default:
                tLRPC$TL_pagePart_layer82 = null;
                break;
        }
        if (tLRPC$TL_pagePart_layer82 == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Page", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_pagePart_layer82 != null) {
            tLRPC$TL_pagePart_layer82.readParams(stream, exception);
        }
        return tLRPC$TL_pagePart_layer82;
    }
}
