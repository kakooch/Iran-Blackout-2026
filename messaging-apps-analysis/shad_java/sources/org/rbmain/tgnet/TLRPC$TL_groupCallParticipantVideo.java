package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_groupCallParticipantVideo extends TLObject {
    public static int constructor = 1735736008;
    public int audio_source;
    public String endpoint;
    public int flags;
    public boolean paused;
    public ArrayList<TLRPC$TL_groupCallParticipantVideoSourceGroup> source_groups = new ArrayList<>();

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.paused = (int32 & 1) != 0;
        this.endpoint = abstractSerializedData.readString(z);
        int int322 = abstractSerializedData.readInt32(z);
        if (int322 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int323; i++) {
            TLRPC$TL_groupCallParticipantVideoSourceGroup tLRPC$TL_groupCallParticipantVideoSourceGroupTLdeserialize = TLRPC$TL_groupCallParticipantVideoSourceGroup.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_groupCallParticipantVideoSourceGroupTLdeserialize == null) {
                return;
            }
            this.source_groups.add(tLRPC$TL_groupCallParticipantVideoSourceGroupTLdeserialize);
        }
        if ((this.flags & 2) != 0) {
            this.audio_source = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.paused ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        abstractSerializedData.writeString(this.endpoint);
        abstractSerializedData.writeInt32(481674261);
        int size = this.source_groups.size();
        abstractSerializedData.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.source_groups.get(i2).serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(this.audio_source);
        }
    }
}
