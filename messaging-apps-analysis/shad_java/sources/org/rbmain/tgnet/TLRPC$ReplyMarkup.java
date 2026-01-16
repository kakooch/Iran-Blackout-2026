package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$ReplyMarkup extends TLObject {
    public int flags;
    public boolean resize;
    public ArrayList<TLRPC$TL_keyboardButtonRow> rows = new ArrayList<>();
    public boolean selective;
    public boolean single_use;

    public static TLRPC$ReplyMarkup TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$ReplyMarkup tLRPC$TL_replyKeyboardHide;
        switch (i) {
            case -1606526075:
                tLRPC$TL_replyKeyboardHide = new TLRPC$TL_replyKeyboardHide();
                break;
            case -200242528:
                tLRPC$TL_replyKeyboardHide = new TLRPC$ReplyMarkup() { // from class: org.rbmain.tgnet.TLRPC$TL_replyKeyboardForceReply
                    public static int constructor = -200242528;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.single_use = (int32 & 2) != 0;
                        this.selective = (int32 & 4) != 0;
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.single_use ? this.flags | 2 : this.flags & (-3);
                        this.flags = i2;
                        int i3 = this.selective ? i2 | 4 : i2 & (-5);
                        this.flags = i3;
                        abstractSerializedData2.writeInt32(i3);
                    }
                };
                break;
            case 889353612:
                tLRPC$TL_replyKeyboardHide = new TLRPC$TL_replyKeyboardMarkup();
                break;
            case 1218642516:
                tLRPC$TL_replyKeyboardHide = new TLRPC$TL_replyInlineMarkup();
                break;
            default:
                tLRPC$TL_replyKeyboardHide = null;
                break;
        }
        if (tLRPC$TL_replyKeyboardHide == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in ReplyMarkup", Integer.valueOf(i)));
        }
        if (tLRPC$TL_replyKeyboardHide != null) {
            tLRPC$TL_replyKeyboardHide.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_replyKeyboardHide;
    }
}
