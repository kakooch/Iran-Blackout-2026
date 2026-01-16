package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_groupCallParticipantVideoSourceGroup extends TLObject {
    public static int constructor = -592373577;
    public String semantics;
    public ArrayList<Integer> sources = new ArrayList<>();

    public static TLRPC$TL_groupCallParticipantVideoSourceGroup TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_groupCallParticipantVideoSourceGroup", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_groupCallParticipantVideoSourceGroup tLRPC$TL_groupCallParticipantVideoSourceGroup = new TLRPC$TL_groupCallParticipantVideoSourceGroup();
        tLRPC$TL_groupCallParticipantVideoSourceGroup.readParams(stream, exception);
        return tLRPC$TL_groupCallParticipantVideoSourceGroup;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.semantics = stream.readString(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
        } else {
            int int322 = stream.readInt32(exception);
            for (int i = 0; i < int322; i++) {
                this.sources.add(Integer.valueOf(stream.readInt32(exception)));
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.semantics);
        stream.writeInt32(481674261);
        int size = this.sources.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeInt32(this.sources.get(i).intValue());
        }
    }
}
