package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_StickerSetInstallResult extends TLObject {
    public ArrayList<TLRPC$StickerSetCovered> sets = new ArrayList<>();

    public static TLRPC$messages_StickerSetInstallResult TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$messages_StickerSetInstallResult tLRPC$messages_StickerSetInstallResult;
        if (constructor != 904138920) {
            tLRPC$messages_StickerSetInstallResult = constructor != 946083368 ? null : new TLRPC$messages_StickerSetInstallResult() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_stickerSetInstallResultSuccess
                public static int constructor = 946083368;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$messages_StickerSetInstallResult = new TLRPC$messages_StickerSetInstallResult() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_stickerSetInstallResultArchive
                public static int constructor = 904138920;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32 = stream2.readInt32(exception2);
                    if (int32 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = stream2.readInt32(exception2);
                    for (int i = 0; i < int322; i++) {
                        TLRPC$StickerSetCovered tLRPC$StickerSetCoveredTLdeserialize = TLRPC$StickerSetCovered.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$StickerSetCoveredTLdeserialize == null) {
                            return;
                        }
                        this.sets.add(tLRPC$StickerSetCoveredTLdeserialize);
                    }
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(481674261);
                    int size = this.sets.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.sets.get(i).serializeToStream(stream2);
                    }
                }
            };
        }
        if (tLRPC$messages_StickerSetInstallResult == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_StickerSetInstallResult", Integer.valueOf(constructor)));
        }
        if (tLRPC$messages_StickerSetInstallResult != null) {
            tLRPC$messages_StickerSetInstallResult.readParams(stream, exception);
        }
        return tLRPC$messages_StickerSetInstallResult;
    }
}
