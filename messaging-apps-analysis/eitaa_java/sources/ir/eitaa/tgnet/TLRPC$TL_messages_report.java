package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_report extends TLObject {
    public static int constructor = -1991005362;
    public ArrayList<Integer> id = new ArrayList<>();
    public String message;
    public TLRPC$InputPeer peer;
    public TLRPC$ReportReason reason;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.id.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeInt32(this.id.get(i).intValue());
        }
        this.reason.serializeToStream(stream);
        stream.writeString(this.message);
    }
}
