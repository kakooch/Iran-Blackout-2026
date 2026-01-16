package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_photoSizeProgressive extends TLRPC$PhotoSize {
    public static int constructor = -96535659;
    public ArrayList<Integer> sizes = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.type = stream.readString(exception);
        this.w = stream.readInt32(exception);
        this.h = stream.readInt32(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            this.sizes.add(Integer.valueOf(stream.readInt32(exception)));
        }
        if (this.sizes.isEmpty()) {
            return;
        }
        ArrayList<Integer> arrayList = this.sizes;
        this.size = arrayList.get(arrayList.size() - 1).intValue();
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.type);
        stream.writeInt32(this.w);
        stream.writeInt32(this.h);
        stream.writeInt32(481674261);
        int size = this.sizes.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeInt32(this.sizes.get(i).intValue());
        }
    }
}
