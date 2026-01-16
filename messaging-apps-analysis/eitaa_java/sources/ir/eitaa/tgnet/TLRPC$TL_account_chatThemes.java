package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_account_chatThemes extends TLRPC$account_ChatThemes {
    public static int constructor = -28524867;
    public int hash;
    public ArrayList<TLRPC$TL_chatTheme> themes = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.hash = stream.readInt32(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_chatTheme tLRPC$TL_chatThemeTLdeserialize = TLRPC$TL_chatTheme.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_chatThemeTLdeserialize == null) {
                return;
            }
            this.themes.add(tLRPC$TL_chatThemeTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.hash);
        stream.writeInt32(481674261);
        int size = this.themes.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.themes.get(i).serializeToStream(stream);
        }
    }
}
