package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$Document extends TLObject {
    public long access_hash;
    public String cdnTag;
    public int date;
    public int dc_id;
    public String file_name;
    public byte[] file_reference;
    public int flags;
    public long id;
    public byte[] iv;
    public byte[] key;
    public String mime_type;
    public int size;
    public int user_id;
    public int version;
    public ArrayList<TLRPC$PhotoSize> thumbs = new ArrayList<>();
    public ArrayList<TLRPC$VideoSize> video_thumbs = new ArrayList<>();
    public ArrayList<TLRPC$DocumentAttribute> attributes = new ArrayList<>();

    public static TLRPC$Document TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Document tLRPC$TL_document_layer82;
        switch (i) {
            case -2027738169:
                tLRPC$TL_document_layer82 = new TLRPC$TL_document_layer82();
                break;
            case -1683841855:
                tLRPC$TL_document_layer82 = new TLRPC$TL_document() { // from class: org.rbmain.tgnet.TLRPC$TL_document_layer113
                    public static int constructor = -1683841855;

                    @Override // org.rbmain.tgnet.TLRPC$TL_document, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.flags = abstractSerializedData2.readInt32(z2);
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.file_reference = abstractSerializedData2.readByteArray(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.mime_type = abstractSerializedData2.readString(z2);
                        this.size = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 1) != 0) {
                            int int32 = abstractSerializedData2.readInt32(z2);
                            if (int32 != 481674261) {
                                if (z2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                                }
                                return;
                            }
                            int int322 = abstractSerializedData2.readInt32(z2);
                            for (int i2 = 0; i2 < int322; i2++) {
                                TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                                if (tLRPC$PhotoSizeTLdeserialize == null) {
                                    return;
                                }
                                this.thumbs.add(tLRPC$PhotoSizeTLdeserialize);
                            }
                        }
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                        int int323 = abstractSerializedData2.readInt32(z2);
                        if (int323 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                            }
                            return;
                        }
                        int int324 = abstractSerializedData2.readInt32(z2);
                        for (int i3 = 0; i3 < int324; i3++) {
                            TLRPC$DocumentAttribute tLRPC$DocumentAttributeTLdeserialize = TLRPC$DocumentAttribute.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$DocumentAttributeTLdeserialize == null) {
                                return;
                            }
                            this.attributes.add(tLRPC$DocumentAttributeTLdeserialize);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_document, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.flags);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeByteArray(this.file_reference);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.mime_type);
                        abstractSerializedData2.writeInt32(this.size);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(481674261);
                            int size = this.thumbs.size();
                            abstractSerializedData2.writeInt32(size);
                            for (int i2 = 0; i2 < size; i2++) {
                                this.thumbs.get(i2).serializeToStream(abstractSerializedData2);
                            }
                        }
                        abstractSerializedData2.writeInt32(this.dc_id);
                        abstractSerializedData2.writeInt32(481674261);
                        int size2 = this.attributes.size();
                        abstractSerializedData2.writeInt32(size2);
                        for (int i3 = 0; i3 < size2; i3++) {
                            this.attributes.get(i3).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case -1627626714:
                tLRPC$TL_document_layer82 = new TLRPC$TL_document() { // from class: org.rbmain.tgnet.TLRPC$TL_document_old
                    public static int constructor = -1627626714;

                    @Override // org.rbmain.tgnet.TLRPC$TL_document, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.user_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.file_name = abstractSerializedData2.readString(z2);
                        this.mime_type = abstractSerializedData2.readString(z2);
                        this.size = abstractSerializedData2.readInt32(z2);
                        this.thumbs.add(TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2));
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_document, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.user_id);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.file_name);
                        abstractSerializedData2.writeString(this.mime_type);
                        abstractSerializedData2.writeInt32(this.size);
                        this.thumbs.get(0).serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(this.dc_id);
                    }
                };
                break;
            case -106717361:
                tLRPC$TL_document_layer82 = new TLRPC$TL_document() { // from class: org.rbmain.tgnet.TLRPC$TL_document_layer53
                    public static int constructor = -106717361;

                    @Override // org.rbmain.tgnet.TLRPC$TL_document, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.mime_type = abstractSerializedData2.readString(z2);
                        this.size = abstractSerializedData2.readInt32(z2);
                        this.thumbs.add(TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2));
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int322; i2++) {
                            TLRPC$DocumentAttribute tLRPC$DocumentAttributeTLdeserialize = TLRPC$DocumentAttribute.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$DocumentAttributeTLdeserialize == null) {
                                return;
                            }
                            this.attributes.add(tLRPC$DocumentAttributeTLdeserialize);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_document, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.mime_type);
                        abstractSerializedData2.writeInt32(this.size);
                        this.thumbs.get(0).serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(this.dc_id);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.attributes.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.attributes.get(i2).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case 512177195:
                tLRPC$TL_document_layer82 = new TLRPC$TL_document();
                break;
            case 922273905:
                tLRPC$TL_document_layer82 = new TLRPC$TL_documentEmpty();
                break;
            case 1431655766:
                tLRPC$TL_document_layer82 = new TLRPC$TL_document() { // from class: org.rbmain.tgnet.TLRPC$TL_documentEncrypted_old
                    public static int constructor = 1431655766;

                    @Override // org.rbmain.tgnet.TLRPC$TL_document, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.user_id = abstractSerializedData2.readInt32(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.file_name = abstractSerializedData2.readString(z2);
                        this.mime_type = abstractSerializedData2.readString(z2);
                        this.size = abstractSerializedData2.readInt32(z2);
                        this.thumbs.add(TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2));
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                        this.key = abstractSerializedData2.readByteArray(z2);
                        this.iv = abstractSerializedData2.readByteArray(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_document, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeInt32(this.user_id);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.file_name);
                        abstractSerializedData2.writeString(this.mime_type);
                        abstractSerializedData2.writeInt32(this.size);
                        this.thumbs.get(0).serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(this.dc_id);
                        abstractSerializedData2.writeByteArray(this.key);
                        abstractSerializedData2.writeByteArray(this.iv);
                    }
                };
                break;
            case 1431655768:
                tLRPC$TL_document_layer82 = new TLRPC$TL_documentEncrypted();
                break;
            case 1498631756:
                tLRPC$TL_document_layer82 = new TLRPC$TL_document() { // from class: org.rbmain.tgnet.TLRPC$TL_document_layer92
                    public static int constructor = 1498631756;

                    @Override // org.rbmain.tgnet.TLRPC$TL_document, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.id = abstractSerializedData2.readInt64(z2);
                        this.access_hash = abstractSerializedData2.readInt64(z2);
                        this.file_reference = abstractSerializedData2.readByteArray(z2);
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.mime_type = abstractSerializedData2.readString(z2);
                        this.size = abstractSerializedData2.readInt32(z2);
                        this.thumbs.add(TLRPC$PhotoSize.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2));
                        this.dc_id = abstractSerializedData2.readInt32(z2);
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int322; i2++) {
                            TLRPC$DocumentAttribute tLRPC$DocumentAttributeTLdeserialize = TLRPC$DocumentAttribute.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$DocumentAttributeTLdeserialize == null) {
                                return;
                            }
                            this.attributes.add(tLRPC$DocumentAttributeTLdeserialize);
                        }
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_document, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt64(this.id);
                        abstractSerializedData2.writeInt64(this.access_hash);
                        abstractSerializedData2.writeByteArray(this.file_reference);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeString(this.mime_type);
                        abstractSerializedData2.writeInt32(this.size);
                        this.thumbs.get(0).serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(this.dc_id);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.attributes.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.attributes.get(i2).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            default:
                tLRPC$TL_document_layer82 = null;
                break;
        }
        if (tLRPC$TL_document_layer82 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Document", Integer.valueOf(i)));
        }
        if (tLRPC$TL_document_layer82 != null) {
            tLRPC$TL_document_layer82.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_document_layer82;
    }
}
