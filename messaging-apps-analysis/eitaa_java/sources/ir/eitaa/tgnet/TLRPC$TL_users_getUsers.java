package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_users_getUsers extends TLObject {
    public static int constructor = 227648840;
    public ArrayList<TLRPC$InputUser> id = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
        int int32 = stream.readInt32(exception);
        for (int i = 0; i < int32; i++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$UserTLdeserialize == null) {
                return tLRPC$Vector;
            }
            tLRPC$Vector.objects.add(tLRPC$UserTLdeserialize);
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
