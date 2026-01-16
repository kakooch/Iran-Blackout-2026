package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_phoneCall extends TLObject {
    public static int constructor = -326966976;
    public TLRPC$PhoneCall phone_call;
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_phone_phoneCall TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_phone_phoneCall", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_phone_phoneCall tLRPC$TL_phone_phoneCall = new TLRPC$TL_phone_phoneCall();
        tLRPC$TL_phone_phoneCall.readParams(stream, exception);
        return tLRPC$TL_phone_phoneCall;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.phone_call = TLRPC$PhoneCall.TLdeserialize(stream, stream.readInt32(exception), exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.phone_call.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.users.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.users.get(i).serializeToStream(stream);
        }
    }
}
