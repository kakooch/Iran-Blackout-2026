package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_getGroupParticipants extends TLObject {
    public static int constructor = -984033109;
    public TLRPC$TL_inputGroupCall call;
    public int limit;
    public String offset;
    public ArrayList<TLRPC$InputPeer> ids = new ArrayList<>();
    public ArrayList<Integer> sources = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_phone_groupParticipants.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.call.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.ids.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.ids.get(i).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.sources.size();
        stream.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            stream.writeInt32(this.sources.get(i2).intValue());
        }
        stream.writeString(this.offset);
        stream.writeInt32(this.limit);
    }
}
