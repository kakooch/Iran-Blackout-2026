package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$messages_SavedGifs extends TLObject {
    public ArrayList<TLRPC$Document> gifs = new ArrayList<>();
    public int hash;

    public static TLRPC$messages_SavedGifs TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$messages_SavedGifs tLRPC$TL_messages_savedGifs;
        if (i == -402498398) {
            tLRPC$TL_messages_savedGifs = new TLRPC$messages_SavedGifs() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_savedGifsNotModified
                public static int constructor = -402498398;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_messages_savedGifs = i != 772213157 ? null : new TLRPC$TL_messages_savedGifs();
        }
        if (tLRPC$TL_messages_savedGifs == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_SavedGifs", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messages_savedGifs != null) {
            tLRPC$TL_messages_savedGifs.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_messages_savedGifs;
    }
}
