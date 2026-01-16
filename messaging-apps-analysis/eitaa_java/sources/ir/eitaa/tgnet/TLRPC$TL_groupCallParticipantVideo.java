package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_groupCallParticipantVideo extends TLObject {
    public static int constructor = 1735736008;
    public int audio_source;
    public String endpoint;
    public int flags;
    public boolean paused;
    public ArrayList<TLRPC$TL_groupCallParticipantVideoSourceGroup> source_groups = new ArrayList<>();

    public static TLRPC$TL_groupCallParticipantVideo TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_groupCallParticipantVideo", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_groupCallParticipantVideo tLRPC$TL_groupCallParticipantVideo = new TLRPC$TL_groupCallParticipantVideo();
        tLRPC$TL_groupCallParticipantVideo.readParams(stream, exception);
        return tLRPC$TL_groupCallParticipantVideo;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.paused = (int32 & 1) != 0;
        this.endpoint = stream.readString(exception);
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$TL_groupCallParticipantVideoSourceGroup tLRPC$TL_groupCallParticipantVideoSourceGroupTLdeserialize = TLRPC$TL_groupCallParticipantVideoSourceGroup.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_groupCallParticipantVideoSourceGroupTLdeserialize == null) {
                return;
            }
            this.source_groups.add(tLRPC$TL_groupCallParticipantVideoSourceGroupTLdeserialize);
        }
        if ((this.flags & 2) != 0) {
            this.audio_source = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.paused ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeString(this.endpoint);
        stream.writeInt32(481674261);
        int size = this.source_groups.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.source_groups.get(i2).serializeToStream(stream);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.audio_source);
        }
    }
}
