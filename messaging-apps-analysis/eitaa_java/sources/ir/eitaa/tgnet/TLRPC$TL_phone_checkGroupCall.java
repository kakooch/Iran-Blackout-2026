package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_checkGroupCall extends TLObject {
    public static int constructor = -1248003721;
    public TLRPC$TL_inputGroupCall call;
    public ArrayList<Integer> sources = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
        int int32 = stream.readInt32(exception);
        for (int i = 0; i < int32; i++) {
            tLRPC$Vector.objects.add(Integer.valueOf(stream.readInt32(exception)));
        }
        return tLRPC$Vector;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.call.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.sources.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeInt32(this.sources.get(i).intValue());
        }
    }
}
