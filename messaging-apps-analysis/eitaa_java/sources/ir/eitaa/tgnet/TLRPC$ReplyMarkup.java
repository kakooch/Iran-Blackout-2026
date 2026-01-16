package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$ReplyMarkup extends TLObject {
    public int flags;
    public String placeholder;
    public boolean resize;
    public ArrayList<TLRPC$TL_keyboardButtonRow> rows = new ArrayList<>();
    public boolean selective;
    public boolean single_use;

    public static TLRPC$ReplyMarkup TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$ReplyMarkup tLRPC$TL_replyKeyboardMarkup;
        switch (constructor) {
            case -2049074735:
                tLRPC$TL_replyKeyboardMarkup = new TLRPC$TL_replyKeyboardMarkup();
                break;
            case -2035021048:
                tLRPC$TL_replyKeyboardMarkup = new TLRPC$TL_replyKeyboardForceReply();
                break;
            case -1606526075:
                tLRPC$TL_replyKeyboardMarkup = new TLRPC$TL_replyKeyboardHide();
                break;
            case -200242528:
                tLRPC$TL_replyKeyboardMarkup = new TLRPC$TL_replyKeyboardForceReply() { // from class: ir.eitaa.tgnet.TLRPC$TL_replyKeyboardForceReply_layer129
                    public static int constructor = -200242528;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_replyKeyboardForceReply, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.single_use = (int32 & 2) != 0;
                        this.selective = (int32 & 4) != 0;
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_replyKeyboardForceReply, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.single_use ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        int i2 = this.selective ? i | 4 : i & (-5);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                    }
                };
                break;
            case 889353612:
                tLRPC$TL_replyKeyboardMarkup = new TLRPC$TL_replyKeyboardMarkup() { // from class: ir.eitaa.tgnet.TLRPC$TL_replyKeyboardMarkup_layer129
                    public static int constructor = 889353612;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_replyKeyboardMarkup, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.resize = (int32 & 1) != 0;
                        this.single_use = (int32 & 2) != 0;
                        this.selective = (int32 & 4) != 0;
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$TL_keyboardButtonRow tLRPC$TL_keyboardButtonRowTLdeserialize = TLRPC$TL_keyboardButtonRow.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$TL_keyboardButtonRowTLdeserialize == null) {
                                return;
                            }
                            this.rows.add(tLRPC$TL_keyboardButtonRowTLdeserialize);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_replyKeyboardMarkup, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.resize ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.single_use ? i | 2 : i & (-3);
                        this.flags = i2;
                        int i3 = this.selective ? i2 | 4 : i2 & (-5);
                        this.flags = i3;
                        stream2.writeInt32(i3);
                        stream2.writeInt32(481674261);
                        int size = this.rows.size();
                        stream2.writeInt32(size);
                        for (int i4 = 0; i4 < size; i4++) {
                            this.rows.get(i4).serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 1218642516:
                tLRPC$TL_replyKeyboardMarkup = new TLRPC$TL_replyInlineMarkup();
                break;
            default:
                tLRPC$TL_replyKeyboardMarkup = null;
                break;
        }
        if (tLRPC$TL_replyKeyboardMarkup == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in ReplyMarkup", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_replyKeyboardMarkup != null) {
            tLRPC$TL_replyKeyboardMarkup.readParams(stream, exception);
        }
        return tLRPC$TL_replyKeyboardMarkup;
    }
}
