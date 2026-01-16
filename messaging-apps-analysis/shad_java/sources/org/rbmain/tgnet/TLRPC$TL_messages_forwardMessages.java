package org.rbmain.tgnet;

import androidMessenger.proxy.MessageProxy$32$$ExternalSyntheticBackport0;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_forwardMessages extends TLObject {
    public static int constructor = -637606386;
    public boolean background;
    public int flags;
    public TLRPC$InputPeer from_peer;
    public ArrayList<Long> id = new ArrayList<>();
    public ArrayList<Long> random_id = new ArrayList<>();
    public int schedule_date;
    public boolean silent;
    public TLRPC$InputPeer to_peer;
    public boolean with_my_score;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.silent ? this.flags | 32 : this.flags & (-33);
        this.flags = i;
        int i2 = this.background ? i | 64 : i & (-65);
        this.flags = i2;
        int i3 = this.with_my_score ? i2 | 256 : i2 & (-257);
        this.flags = i3;
        abstractSerializedData.writeInt32(i3);
        this.from_peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.id.size();
        abstractSerializedData.writeInt32(size);
        for (int i4 = 0; i4 < size; i4++) {
            abstractSerializedData.writeInt32(MessageProxy$32$$ExternalSyntheticBackport0.m(this.id.get(i4).longValue()));
        }
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.random_id.size();
        abstractSerializedData.writeInt32(size2);
        for (int i5 = 0; i5 < size2; i5++) {
            abstractSerializedData.writeInt64(this.random_id.get(i5).longValue());
        }
        this.to_peer.serializeToStream(abstractSerializedData);
        if ((this.flags & 1024) != 0) {
            abstractSerializedData.writeInt32(this.schedule_date);
        }
    }
}
