package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_photos_deletePhotos extends TLObject {
    public static int constructor = -2016444625;
    public ArrayList<TLRPC$InputPhoto> id = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
        int int32 = stream.readInt32(exception);
        for (int i = 0; i < int32; i++) {
            tLRPC$Vector.objects.add(Long.valueOf(stream.readInt64(exception)));
        }
        return tLRPC$Vector;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.id.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.id.get(i).serializeToStream(stream);
        }
    }
}
