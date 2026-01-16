package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_page extends TLRPC$Page {
    public static int constructor = -1738178803;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.part = (int32 & 1) != 0;
        this.rtl = (int32 & 2) != 0;
        this.v2 = (int32 & 4) != 0;
        this.url = stream.readString(exception);
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$PageBlockTLdeserialize == null) {
                return;
            }
            this.blocks.add(tLRPC$PageBlockTLdeserialize);
        }
        int int324 = stream.readInt32(exception);
        if (int324 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
            }
            return;
        }
        int int325 = stream.readInt32(exception);
        for (int i2 = 0; i2 < int325; i2++) {
            TLRPC$Photo tLRPC$PhotoTLdeserialize = TLRPC$Photo.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$PhotoTLdeserialize == null) {
                return;
            }
            this.photos.add(tLRPC$PhotoTLdeserialize);
        }
        int int326 = stream.readInt32(exception);
        if (int326 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int326)));
            }
            return;
        }
        int int327 = stream.readInt32(exception);
        for (int i3 = 0; i3 < int327; i3++) {
            TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$DocumentTLdeserialize == null) {
                return;
            }
            this.documents.add(tLRPC$DocumentTLdeserialize);
        }
        if ((this.flags & 8) != 0) {
            this.views = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.part ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.rtl ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.v2 ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        stream.writeInt32(i3);
        stream.writeString(this.url);
        stream.writeInt32(481674261);
        int size = this.blocks.size();
        stream.writeInt32(size);
        for (int i4 = 0; i4 < size; i4++) {
            this.blocks.get(i4).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.photos.size();
        stream.writeInt32(size2);
        for (int i5 = 0; i5 < size2; i5++) {
            this.photos.get(i5).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size3 = this.documents.size();
        stream.writeInt32(size3);
        for (int i6 = 0; i6 < size3; i6++) {
            this.documents.get(i6).serializeToStream(stream);
        }
        if ((this.flags & 8) != 0) {
            stream.writeInt32(this.views);
        }
    }
}
