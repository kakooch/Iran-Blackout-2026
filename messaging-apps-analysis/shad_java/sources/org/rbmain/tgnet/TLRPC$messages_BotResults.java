package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$messages_BotResults extends TLObject {
    public int cache_time;
    public int flags;
    public boolean gallery;
    public String next_offset;
    public long query_id;
    public TLRPC$TL_inlineBotSwitchPM switch_pm;
    public ArrayList<TLRPC$BotInlineResult> results = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$messages_BotResults TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$TL_messages_botResults tLRPC$TL_messages_botResults;
        if (i != -1803769784) {
            tLRPC$TL_messages_botResults = i != -858565059 ? null : new TLRPC$TL_messages_botResults() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_botResults_layer71
                public static int constructor = -858565059;

                @Override // org.rbmain.tgnet.TLRPC$TL_messages_botResults, org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    int int32 = abstractSerializedData2.readInt32(z2);
                    this.flags = int32;
                    this.gallery = (int32 & 1) != 0;
                    this.query_id = abstractSerializedData2.readInt64(z2);
                    if ((this.flags & 2) != 0) {
                        this.next_offset = abstractSerializedData2.readString(z2);
                    }
                    if ((this.flags & 4) != 0) {
                        this.switch_pm = TLRPC$TL_inlineBotSwitchPM.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }
                    int int322 = abstractSerializedData2.readInt32(z2);
                    if (int322 != 481674261) {
                        if (z2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                        }
                        return;
                    }
                    int int323 = abstractSerializedData2.readInt32(z2);
                    for (int i2 = 0; i2 < int323; i2++) {
                        TLRPC$BotInlineResult tLRPC$BotInlineResultTLdeserialize = TLRPC$BotInlineResult.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$BotInlineResultTLdeserialize == null) {
                            return;
                        }
                        this.results.add(tLRPC$BotInlineResultTLdeserialize);
                    }
                    this.cache_time = abstractSerializedData2.readInt32(z2);
                }

                @Override // org.rbmain.tgnet.TLRPC$TL_messages_botResults, org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    int i2 = this.gallery ? this.flags | 1 : this.flags & (-2);
                    this.flags = i2;
                    abstractSerializedData2.writeInt32(i2);
                    abstractSerializedData2.writeInt64(this.query_id);
                    if ((this.flags & 2) != 0) {
                        abstractSerializedData2.writeString(this.next_offset);
                    }
                    if ((this.flags & 4) != 0) {
                        this.switch_pm.serializeToStream(abstractSerializedData2);
                    }
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.results.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i3 = 0; i3 < size; i3++) {
                        this.results.get(i3).serializeToStream(abstractSerializedData2);
                    }
                    abstractSerializedData2.writeInt32(this.cache_time);
                }
            };
        } else {
            tLRPC$TL_messages_botResults = new TLRPC$TL_messages_botResults();
        }
        if (tLRPC$TL_messages_botResults == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_BotResults", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messages_botResults != null) {
            tLRPC$TL_messages_botResults.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_messages_botResults;
    }
}
