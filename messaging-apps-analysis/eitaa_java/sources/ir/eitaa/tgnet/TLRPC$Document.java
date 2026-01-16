package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$Document extends TLObject {
    public long access_hash;
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
    public long user_id;
    public int version;
    public ArrayList<TLRPC$PhotoSize> thumbs = new ArrayList<>();
    public ArrayList<TLRPC$VideoSize> video_thumbs = new ArrayList<>();
    public ArrayList<TLRPC$DocumentAttribute> attributes = new ArrayList<>();

    public static TLRPC$Document TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$Document tLRPC$TL_document_layer82;
        switch (constructor) {
            case -2027738169:
                tLRPC$TL_document_layer82 = new TLRPC$TL_document_layer82();
                break;
            case -1683841855:
                tLRPC$TL_document_layer82 = new TLRPC$TL_document() { // from class: ir.eitaa.tgnet.TLRPC$TL_document_layer113
                    public static int constructor = -1683841855;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_document, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.file_reference = stream2.readByteArray(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.mime_type = stream2.readString(exception2);
                        this.size = stream2.readInt32(exception2);
                        if ((this.flags & 1) != 0) {
                            int int32 = stream2.readInt32(exception2);
                            if (int32 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                                }
                                return;
                            }
                            int int322 = stream2.readInt32(exception2);
                            int i = 0;
                            while (i < int322) {
                                int i2 = i;
                                TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$PhotoSizeTLdeserialize == null) {
                                    return;
                                }
                                this.thumbs.add(tLRPC$PhotoSizeTLdeserialize);
                                i = i2 + 1;
                            }
                        }
                        this.dc_id = stream2.readInt32(exception2);
                        int int323 = stream2.readInt32(exception2);
                        if (int323 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                            }
                            return;
                        }
                        int int324 = stream2.readInt32(exception2);
                        for (int i3 = 0; i3 < int324; i3++) {
                            TLRPC$DocumentAttribute tLRPC$DocumentAttributeTLdeserialize = TLRPC$DocumentAttribute.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$DocumentAttributeTLdeserialize == null) {
                                return;
                            }
                            this.attributes.add(tLRPC$DocumentAttributeTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_document, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeByteArray(this.file_reference);
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.mime_type);
                        stream2.writeInt32(this.size);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(481674261);
                            int size = this.thumbs.size();
                            stream2.writeInt32(size);
                            for (int i = 0; i < size; i++) {
                                this.thumbs.get(i).serializeToStream(stream2);
                            }
                        }
                        stream2.writeInt32(this.dc_id);
                        stream2.writeInt32(481674261);
                        int size2 = this.attributes.size();
                        stream2.writeInt32(size2);
                        for (int i2 = 0; i2 < size2; i2++) {
                            this.attributes.get(i2).serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -1627626714:
                tLRPC$TL_document_layer82 = new TLRPC$TL_document() { // from class: ir.eitaa.tgnet.TLRPC$TL_document_old
                    public static int constructor = -1627626714;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_document, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.user_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.file_name = stream2.readString(exception2);
                        this.mime_type = stream2.readString(exception2);
                        this.size = stream2.readInt32(exception2);
                        this.thumbs.add(TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2));
                        this.dc_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_document, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.file_name);
                        stream2.writeString(this.mime_type);
                        stream2.writeInt32(this.size);
                        this.thumbs.get(0).serializeToStream(stream2);
                        stream2.writeInt32(this.dc_id);
                    }
                };
                break;
            case -106717361:
                tLRPC$TL_document_layer82 = new TLRPC$TL_document() { // from class: ir.eitaa.tgnet.TLRPC$TL_document_layer53
                    public static int constructor = -106717361;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_document, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.mime_type = stream2.readString(exception2);
                        this.size = stream2.readInt32(exception2);
                        this.thumbs.add(TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2));
                        this.dc_id = stream2.readInt32(exception2);
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$DocumentAttribute tLRPC$DocumentAttributeTLdeserialize = TLRPC$DocumentAttribute.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$DocumentAttributeTLdeserialize == null) {
                                return;
                            }
                            this.attributes.add(tLRPC$DocumentAttributeTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_document, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.mime_type);
                        stream2.writeInt32(this.size);
                        this.thumbs.get(0).serializeToStream(stream2);
                        stream2.writeInt32(this.dc_id);
                        stream2.writeInt32(481674261);
                        int size = this.attributes.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.attributes.get(i).serializeToStream(stream2);
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
                tLRPC$TL_document_layer82 = new TLRPC$TL_document() { // from class: ir.eitaa.tgnet.TLRPC$TL_documentEncrypted_old
                    public static int constructor = 1431655766;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_document, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.user_id = stream2.readInt32(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.file_name = stream2.readString(exception2);
                        this.mime_type = stream2.readString(exception2);
                        this.size = stream2.readInt32(exception2);
                        this.thumbs.add(TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2));
                        this.dc_id = stream2.readInt32(exception2);
                        this.key = stream2.readByteArray(exception2);
                        this.iv = stream2.readByteArray(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_document, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.file_name);
                        stream2.writeString(this.mime_type);
                        stream2.writeInt32(this.size);
                        this.thumbs.get(0).serializeToStream(stream2);
                        stream2.writeInt32(this.dc_id);
                        stream2.writeByteArray(this.key);
                        stream2.writeByteArray(this.iv);
                    }
                };
                break;
            case 1431655768:
                tLRPC$TL_document_layer82 = new TLRPC$TL_documentEncrypted();
                break;
            case 1498631756:
                tLRPC$TL_document_layer82 = new TLRPC$TL_document() { // from class: ir.eitaa.tgnet.TLRPC$TL_document_layer92
                    public static int constructor = 1498631756;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_document, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.file_reference = stream2.readByteArray(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.mime_type = stream2.readString(exception2);
                        this.size = stream2.readInt32(exception2);
                        this.thumbs.add(TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2));
                        this.dc_id = stream2.readInt32(exception2);
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$DocumentAttribute tLRPC$DocumentAttributeTLdeserialize = TLRPC$DocumentAttribute.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$DocumentAttributeTLdeserialize == null) {
                                return;
                            }
                            this.attributes.add(tLRPC$DocumentAttributeTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_document, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeByteArray(this.file_reference);
                        stream2.writeInt32(this.date);
                        stream2.writeString(this.mime_type);
                        stream2.writeInt32(this.size);
                        this.thumbs.get(0).serializeToStream(stream2);
                        stream2.writeInt32(this.dc_id);
                        stream2.writeInt32(481674261);
                        int size = this.attributes.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.attributes.get(i).serializeToStream(stream2);
                        }
                    }
                };
                break;
            default:
                tLRPC$TL_document_layer82 = null;
                break;
        }
        if (tLRPC$TL_document_layer82 == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Document", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_document_layer82 != null) {
            tLRPC$TL_document_layer82.readParams(stream, exception);
        }
        return tLRPC$TL_document_layer82;
    }
}
