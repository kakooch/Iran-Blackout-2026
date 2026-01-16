package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_inviteToGroupCall extends TLObject {
    public static int constructor = 2067345760;
    public TLRPC$TL_inputGroupCall call;
    public ArrayList<TLRPC$InputUser> users = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.call.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.users.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.users.get(i).serializeToStream(stream);
        }
    }
}
