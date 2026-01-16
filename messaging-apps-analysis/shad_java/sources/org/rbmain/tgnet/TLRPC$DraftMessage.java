package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$DraftMessage extends TLObject {
    public int date;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public int flags;
    public String message;
    public boolean no_webpage;
    public long reply_to_msg_id;

    public static TLRPC$DraftMessage TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$DraftMessage tLRPC$TL_draftMessage;
        if (i == -1169445179) {
            tLRPC$TL_draftMessage = new TLRPC$TL_draftMessageEmpty() { // from class: org.rbmain.tgnet.TLRPC$TL_draftMessageEmpty_layer81
                public static int constructor = -1169445179;

                @Override // org.rbmain.tgnet.TLRPC$TL_draftMessageEmpty, org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        } else if (i != -40996577) {
            tLRPC$TL_draftMessage = i != 453805082 ? null : new TLRPC$TL_draftMessageEmpty();
        } else {
            tLRPC$TL_draftMessage = new TLRPC$TL_draftMessage();
        }
        if (tLRPC$TL_draftMessage == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in DraftMessage", Integer.valueOf(i)));
        }
        if (tLRPC$TL_draftMessage != null) {
            tLRPC$TL_draftMessage.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_draftMessage;
    }
}
