package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$DraftMessage extends TLObject {
    public int date;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public int flags;
    public String message;
    public boolean no_webpage;
    public int reply_to_msg_id;

    public static TLRPC$DraftMessage TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$DraftMessage tLRPC$TL_draftMessage;
        if (constructor == -1169445179) {
            tLRPC$TL_draftMessage = new TLRPC$TL_draftMessageEmpty() { // from class: ir.eitaa.tgnet.TLRPC$TL_draftMessageEmpty_layer81
                public static int constructor = -1169445179;

                @Override // ir.eitaa.tgnet.TLRPC$TL_draftMessageEmpty, ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else if (constructor != -40996577) {
            tLRPC$TL_draftMessage = constructor != 453805082 ? null : new TLRPC$TL_draftMessageEmpty();
        } else {
            tLRPC$TL_draftMessage = new TLRPC$TL_draftMessage();
        }
        if (tLRPC$TL_draftMessage == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in DraftMessage", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_draftMessage != null) {
            tLRPC$TL_draftMessage.readParams(stream, exception);
        }
        return tLRPC$TL_draftMessage;
    }
}
