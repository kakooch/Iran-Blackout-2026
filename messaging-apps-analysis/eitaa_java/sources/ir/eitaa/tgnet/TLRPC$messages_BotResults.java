package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_BotResults extends TLObject {
    public int cache_time;
    public int flags;
    public boolean gallery;
    public String next_offset;
    public long query_id;
    public TLRPC$TL_inlineBotSwitchPM switch_pm;
    public ArrayList<TLRPC$BotInlineResult> results = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$messages_BotResults TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$TL_messages_botResults tLRPC$TL_messages_botResults;
        if (constructor != -1803769784) {
            tLRPC$TL_messages_botResults = constructor != -858565059 ? null : new TLRPC$TL_messages_botResults() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_botResults_layer71
                public static int constructor = -858565059;

                @Override // ir.eitaa.tgnet.TLRPC$TL_messages_botResults, ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32 = stream2.readInt32(exception2);
                    this.flags = int32;
                    this.gallery = (int32 & 1) != 0;
                    this.query_id = stream2.readInt64(exception2);
                    if ((this.flags & 2) != 0) {
                        this.next_offset = stream2.readString(exception2);
                    }
                    if ((this.flags & 4) != 0) {
                        this.switch_pm = TLRPC$TL_inlineBotSwitchPM.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }
                    int int322 = stream2.readInt32(exception2);
                    if (int322 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                        }
                        return;
                    }
                    int int323 = stream2.readInt32(exception2);
                    for (int i = 0; i < int323; i++) {
                        TLRPC$BotInlineResult tLRPC$BotInlineResultTLdeserialize = TLRPC$BotInlineResult.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$BotInlineResultTLdeserialize == null) {
                            return;
                        }
                        this.results.add(tLRPC$BotInlineResultTLdeserialize);
                    }
                    this.cache_time = stream2.readInt32(exception2);
                }

                @Override // ir.eitaa.tgnet.TLRPC$TL_messages_botResults, ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    int i = this.gallery ? this.flags | 1 : this.flags & (-2);
                    this.flags = i;
                    stream2.writeInt32(i);
                    stream2.writeInt64(this.query_id);
                    if ((this.flags & 2) != 0) {
                        stream2.writeString(this.next_offset);
                    }
                    if ((this.flags & 4) != 0) {
                        this.switch_pm.serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size = this.results.size();
                    stream2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        this.results.get(i2).serializeToStream(stream2);
                    }
                    stream2.writeInt32(this.cache_time);
                }
            };
        } else {
            tLRPC$TL_messages_botResults = new TLRPC$TL_messages_botResults();
        }
        if (tLRPC$TL_messages_botResults == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_BotResults", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_messages_botResults != null) {
            tLRPC$TL_messages_botResults.readParams(stream, exception);
        }
        return tLRPC$TL_messages_botResults;
    }
}
