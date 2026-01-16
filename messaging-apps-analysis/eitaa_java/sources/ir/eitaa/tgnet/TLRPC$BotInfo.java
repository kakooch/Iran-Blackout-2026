package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$BotInfo extends TLObject {
    public ArrayList<TLRPC$TL_botCommand> commands = new ArrayList<>();
    public String description;
    public long user_id;
    public int version;

    public static TLRPC$BotInfo TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$TL_botInfo tLRPC$TL_botInfo;
        switch (constructor) {
            case -1729618630:
                tLRPC$TL_botInfo = new TLRPC$TL_botInfo() { // from class: ir.eitaa.tgnet.TLRPC$TL_botInfo_layer131
                    public static int constructor = -1729618630;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInfo, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.user_id = stream2.readInt32(exception2);
                        this.description = stream2.readString(exception2);
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$TL_botCommand tLRPC$TL_botCommandTLdeserialize = TLRPC$TL_botCommand.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$TL_botCommandTLdeserialize == null) {
                                return;
                            }
                            this.commands.add(tLRPC$TL_botCommandTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInfo, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeString(this.description);
                        stream2.writeInt32(481674261);
                        int size = this.commands.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.commands.get(i).serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -1154598962:
                tLRPC$TL_botInfo = new TLRPC$TL_botInfo() { // from class: ir.eitaa.tgnet.TLRPC$TL_botInfoEmpty_layer48
                    public static int constructor = -1154598962;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInfo, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 164583517:
                tLRPC$TL_botInfo = new TLRPC$TL_botInfo() { // from class: ir.eitaa.tgnet.TLRPC$TL_botInfo_layer48
                    public static int constructor = 164583517;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInfo, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.user_id = stream2.readInt32(exception2);
                        this.version = stream2.readInt32(exception2);
                        stream2.readString(exception2);
                        this.description = stream2.readString(exception2);
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$TL_botCommand tLRPC$TL_botCommandTLdeserialize = TLRPC$TL_botCommand.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$TL_botCommandTLdeserialize == null) {
                                return;
                            }
                            this.commands.add(tLRPC$TL_botCommandTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_botInfo, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt32(this.version);
                        stream2.writeString("");
                        stream2.writeString(this.description);
                        stream2.writeInt32(481674261);
                        int size = this.commands.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.commands.get(i).serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 460632885:
                tLRPC$TL_botInfo = new TLRPC$TL_botInfo();
                break;
            default:
                tLRPC$TL_botInfo = null;
                break;
        }
        if (tLRPC$TL_botInfo == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in BotInfo", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_botInfo != null) {
            tLRPC$TL_botInfo.readParams(stream, exception);
        }
        return tLRPC$TL_botInfo;
    }
}
