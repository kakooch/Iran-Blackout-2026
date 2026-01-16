package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_inviteToChannel extends TLObject {
    public static int constructor = 429865580;
    public TLRPC$InputChannel channel;
    public ArrayList<TLRPC$InputUser> users = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.channel.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.users.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.users.get(i).serializeToStream(stream);
        }
    }
}
