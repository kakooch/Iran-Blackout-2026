package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$WebDocument extends TLObject {
    public long access_hash;
    public ArrayList<TLRPC$DocumentAttribute> attributes = new ArrayList<>();
    public String mime_type;
    public int size;
    public String url;

    public static TLRPC$WebDocument TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$WebDocument tLRPC$TL_webDocument;
        if (i == -971322408) {
            tLRPC$TL_webDocument = new TLRPC$TL_webDocument() { // from class: org.rbmain.tgnet.TLRPC$TL_webDocument_layer81
                public static int constructor = -971322408;

                @Override // org.rbmain.tgnet.TLRPC$TL_webDocument, org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.url = abstractSerializedData2.readString(z2);
                    this.access_hash = abstractSerializedData2.readInt64(z2);
                    this.size = abstractSerializedData2.readInt32(z2);
                    this.mime_type = abstractSerializedData2.readString(z2);
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
                    abstractSerializedData2.readInt32(z2);
                }

                @Override // org.rbmain.tgnet.TLRPC$TL_webDocument, org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeString(this.url);
                    abstractSerializedData2.writeInt64(this.access_hash);
                    abstractSerializedData2.writeInt32(this.size);
                    abstractSerializedData2.writeString(this.mime_type);
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.attributes.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        this.attributes.get(i2).serializeToStream(abstractSerializedData2);
                    }
                    abstractSerializedData2.writeInt32(0);
                }
            };
        } else if (i == -104284986) {
            tLRPC$TL_webDocument = new TLRPC$WebDocument() { // from class: org.rbmain.tgnet.TLRPC$TL_webDocumentNoProxy
                public static int constructor = -104284986;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.url = abstractSerializedData2.readString(z2);
                    this.size = abstractSerializedData2.readInt32(z2);
                    this.mime_type = abstractSerializedData2.readString(z2);
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

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeString(this.url);
                    abstractSerializedData2.writeInt32(this.size);
                    abstractSerializedData2.writeString(this.mime_type);
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.attributes.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        this.attributes.get(i2).serializeToStream(abstractSerializedData2);
                    }
                }
            };
        } else {
            tLRPC$TL_webDocument = i != 475467473 ? null : new TLRPC$TL_webDocument();
        }
        if (tLRPC$TL_webDocument == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in WebDocument", Integer.valueOf(i)));
        }
        if (tLRPC$TL_webDocument != null) {
            tLRPC$TL_webDocument.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_webDocument;
    }
}
