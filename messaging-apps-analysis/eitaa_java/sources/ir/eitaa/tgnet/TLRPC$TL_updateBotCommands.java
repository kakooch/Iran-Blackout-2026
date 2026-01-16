package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_updateBotCommands extends TLRPC$Update {
    public static int constructor = 1299263278;
    public long bot_id;
    public ArrayList<TLRPC$TL_botCommand> commands = new ArrayList<>();
    public TLRPC$Peer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.bot_id = stream.readInt64(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_botCommand tLRPC$TL_botCommandTLdeserialize = TLRPC$TL_botCommand.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_botCommandTLdeserialize == null) {
                return;
            }
            this.commands.add(tLRPC$TL_botCommandTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt64(this.bot_id);
        stream.writeInt32(481674261);
        int size = this.commands.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.commands.get(i).serializeToStream(stream);
        }
    }
}
