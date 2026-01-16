package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pagePart_layer82 extends TLRPC$Page {
    public static int constructor = -1908433218;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$PageBlockTLdeserialize == null) {
                return;
            }
            this.blocks.add(tLRPC$PageBlockTLdeserialize);
        }
        int int323 = stream.readInt32(exception);
        if (int323 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
            }
            return;
        }
        int int324 = stream.readInt32(exception);
        for (int i2 = 0; i2 < int324; i2++) {
            TLRPC$Photo tLRPC$PhotoTLdeserialize = TLRPC$Photo.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$PhotoTLdeserialize == null) {
                return;
            }
            this.photos.add(tLRPC$PhotoTLdeserialize);
        }
        int int325 = stream.readInt32(exception);
        if (int325 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
            }
            return;
        }
        int int326 = stream.readInt32(exception);
        for (int i3 = 0; i3 < int326; i3++) {
            TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$DocumentTLdeserialize == null) {
                return;
            }
            this.documents.add(tLRPC$DocumentTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.blocks.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.blocks.get(i).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.photos.size();
        stream.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.photos.get(i2).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size3 = this.documents.size();
        stream.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.documents.get(i3).serializeToStream(stream);
        }
    }
}
