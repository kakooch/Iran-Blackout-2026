package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_Live_participants extends TLObject {
    public static int constructor = -219577344;
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_Live_participants TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_Live_participants", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_Live_participants tLRPC$TL_Live_participants = new TLRPC$TL_Live_participants();
        tLRPC$TL_Live_participants.readParams(stream, exception);
        return tLRPC$TL_Live_participants;
    }

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
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
    }
}
