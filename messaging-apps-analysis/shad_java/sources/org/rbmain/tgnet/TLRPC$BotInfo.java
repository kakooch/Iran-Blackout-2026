package org.rbmain.tgnet;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$BotInfo extends TLObject {
    public ArrayList<TLRPC$TL_botCommand> commands = new ArrayList<>();
    public String description;
    public TLRPC$Document description_document;
    public TLRPC$Photo description_photo;
    public String start_message;
    public int user_id;
    public int version;

    public static TLRPC$BotInfo TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$TL_botInfo tLRPC$TL_botInfo;
        if (i == -1729618630) {
            tLRPC$TL_botInfo = new TLRPC$TL_botInfo();
        } else if (i == -1154598962) {
            tLRPC$TL_botInfo = new TLRPC$TL_botInfo() { // from class: org.rbmain.tgnet.TLRPC$TL_botInfoEmpty_layer48
                public static int constructor = -1154598962;

                @Override // org.rbmain.tgnet.TLRPC$TL_botInfo, org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_botInfo = i != 164583517 ? null : new TLRPC$TL_botInfo() { // from class: org.rbmain.tgnet.TLRPC$TL_botInfo_layer48
                public static int constructor = 164583517;

                @Override // org.rbmain.tgnet.TLRPC$TL_botInfo, org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.user_id = abstractSerializedData2.readInt32(z2);
                    this.version = abstractSerializedData2.readInt32(z2);
                    abstractSerializedData2.readString(z2);
                    this.description = abstractSerializedData2.readString(z2);
                    int int32 = abstractSerializedData2.readInt32(z2);
                    if (int32 != 481674261) {
                        if (z2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = abstractSerializedData2.readInt32(z2);
                    for (int i2 = 0; i2 < int322; i2++) {
                        TLRPC$TL_botCommand tLRPC$TL_botCommandTLdeserialize = TLRPC$TL_botCommand.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$TL_botCommandTLdeserialize == null) {
                            return;
                        }
                        this.commands.add(tLRPC$TL_botCommandTLdeserialize);
                    }
                }

                @Override // org.rbmain.tgnet.TLRPC$TL_botInfo, org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeInt32(this.user_id);
                    abstractSerializedData2.writeInt32(this.version);
                    abstractSerializedData2.writeString(BuildConfig.FLAVOR);
                    abstractSerializedData2.writeString(this.description);
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.commands.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        this.commands.get(i2).serializeToStream(abstractSerializedData2);
                    }
                }
            };
        }
        if (tLRPC$TL_botInfo == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in BotInfo", Integer.valueOf(i)));
        }
        if (tLRPC$TL_botInfo != null) {
            tLRPC$TL_botInfo.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_botInfo;
    }
}
