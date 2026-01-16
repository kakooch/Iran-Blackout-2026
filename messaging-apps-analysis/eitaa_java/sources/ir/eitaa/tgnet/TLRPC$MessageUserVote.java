package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$MessageUserVote extends TLObject {
    public int date;
    public long user_id;

    public static TLRPC$MessageUserVote TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$MessageUserVote tLRPC$TL_messageUserVoteInputOption;
        if (constructor == -1973033641) {
            tLRPC$TL_messageUserVoteInputOption = new TLRPC$MessageUserVote() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageUserVoteMultiple
                public static int constructor = -1973033641;
                public ArrayList<byte[]> options = new ArrayList<>();

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.user_id = stream2.readInt64(exception2);
                    int int32 = stream2.readInt32(exception2);
                    if (int32 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = stream2.readInt32(exception2);
                    for (int i = 0; i < int322; i++) {
                        this.options.add(stream2.readByteArray(exception2));
                    }
                    this.date = stream2.readInt32(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt64(this.user_id);
                    stream2.writeInt32(481674261);
                    int size = this.options.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        stream2.writeByteArray(this.options.get(i));
                    }
                    stream2.writeInt32(this.date);
                }
            };
        } else if (constructor == 886196148) {
            tLRPC$TL_messageUserVoteInputOption = new TLRPC$MessageUserVote() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageUserVote
                public static int constructor = 886196148;
                public byte[] option;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.user_id = stream2.readInt64(exception2);
                    this.option = stream2.readByteArray(exception2);
                    this.date = stream2.readInt32(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt64(this.user_id);
                    stream2.writeByteArray(this.option);
                    stream2.writeInt32(this.date);
                }
            };
        } else {
            tLRPC$TL_messageUserVoteInputOption = constructor != 1017491692 ? null : new TLRPC$TL_messageUserVoteInputOption();
        }
        if (tLRPC$TL_messageUserVoteInputOption == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageUserVote", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_messageUserVoteInputOption != null) {
            tLRPC$TL_messageUserVoteInputOption.readParams(stream, exception);
        }
        return tLRPC$TL_messageUserVoteInputOption;
    }
}
