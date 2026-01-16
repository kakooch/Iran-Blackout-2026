package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$WebDocument extends TLObject {
    public long access_hash;
    public ArrayList<TLRPC$DocumentAttribute> attributes = new ArrayList<>();
    public String mime_type;
    public int size;
    public String url;

    public static TLRPC$WebDocument TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$WebDocument tLRPC$TL_webDocument;
        if (constructor == -971322408) {
            tLRPC$TL_webDocument = new TLRPC$TL_webDocument() { // from class: ir.eitaa.tgnet.TLRPC$TL_webDocument_layer81
                public static int constructor = -971322408;

                @Override // ir.eitaa.tgnet.TLRPC$TL_webDocument, ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.url = stream2.readString(exception2);
                    this.access_hash = stream2.readInt64(exception2);
                    this.size = stream2.readInt32(exception2);
                    this.mime_type = stream2.readString(exception2);
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
                    stream2.readInt32(exception2);
                }

                @Override // ir.eitaa.tgnet.TLRPC$TL_webDocument, ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeString(this.url);
                    stream2.writeInt64(this.access_hash);
                    stream2.writeInt32(this.size);
                    stream2.writeString(this.mime_type);
                    stream2.writeInt32(481674261);
                    int size = this.attributes.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.attributes.get(i).serializeToStream(stream2);
                    }
                    stream2.writeInt32(0);
                }
            };
        } else if (constructor == -104284986) {
            tLRPC$TL_webDocument = new TLRPC$WebDocument() { // from class: ir.eitaa.tgnet.TLRPC$TL_webDocumentNoProxy
                public static int constructor = -104284986;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.url = stream2.readString(exception2);
                    this.size = stream2.readInt32(exception2);
                    this.mime_type = stream2.readString(exception2);
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

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeString(this.url);
                    stream2.writeInt32(this.size);
                    stream2.writeString(this.mime_type);
                    stream2.writeInt32(481674261);
                    int size = this.attributes.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.attributes.get(i).serializeToStream(stream2);
                    }
                }
            };
        } else {
            tLRPC$TL_webDocument = constructor != 475467473 ? null : new TLRPC$TL_webDocument();
        }
        if (tLRPC$TL_webDocument == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in WebDocument", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_webDocument != null) {
            tLRPC$TL_webDocument.readParams(stream, exception);
        }
        return tLRPC$TL_webDocument;
    }
}
