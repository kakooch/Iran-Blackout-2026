package ir.eitaa.tgnet;

import android.util.SparseArray;
import ir.eitaa.messenger.FileLog;

/* loaded from: classes.dex */
public class TLClassStore {
    static TLClassStore store;
    private SparseArray<Class> classStore;

    public TLClassStore() {
        SparseArray<Class> sparseArray = new SparseArray<>();
        this.classStore = sparseArray;
        sparseArray.put(TLRPC$TL_error.constructor, TLRPC$TL_error.class);
        this.classStore.put(TLRPC$TL_decryptedMessageService.constructor, TLRPC$TL_decryptedMessageService.class);
        this.classStore.put(TLRPC$TL_decryptedMessage.constructor, TLRPC$TL_decryptedMessage.class);
        this.classStore.put(TLRPC$TL_config.constructor, TLRPC$TL_config.class);
        this.classStore.put(TLRPC$TL_decryptedMessageLayer.constructor, TLRPC$TL_decryptedMessageLayer.class);
        this.classStore.put(TLRPC$TL_decryptedMessage_layer17.constructor, TLRPC$TL_decryptedMessage.class);
        this.classStore.put(TLRPC$TL_decryptedMessage_layer45.constructor, TLRPC$TL_decryptedMessage_layer45.class);
        this.classStore.put(TLRPC$TL_decryptedMessageService_layer8.constructor, TLRPC$TL_decryptedMessageService_layer8.class);
        this.classStore.put(TLRPC$TL_decryptedMessage_layer8.constructor, TLRPC$TL_decryptedMessage_layer8.class);
        this.classStore.put(TLRPC$TL_message_secret.constructor, TLRPC$TL_message_secret.class);
        this.classStore.put(TLRPC$TL_message_secret_layer72.constructor, TLRPC$TL_message_secret_layer72.class);
        this.classStore.put(TLRPC$TL_message_secret_old.constructor, TLRPC$TL_message_secret_old.class);
        this.classStore.put(TLRPC$TL_messageEncryptedAction.constructor, TLRPC$TL_messageEncryptedAction.class);
        this.classStore.put(TLRPC$TL_null.constructor, TLRPC$TL_null.class);
        this.classStore.put(TLRPC$TL_gzip_packed.constructor, TLRPC$TL_gzip_packed.class);
        this.classStore.put(TLRPC$TL_updateShortChatMessage.constructor, TLRPC$TL_updateShortChatMessage.class);
        this.classStore.put(TLRPC$TL_updates.constructor, TLRPC$TL_updates.class);
        this.classStore.put(TLRPC$TL_updateShortMessage.constructor, TLRPC$TL_updateShortMessage.class);
        this.classStore.put(TLRPC$TL_updateShort.constructor, TLRPC$TL_updateShort.class);
        this.classStore.put(TLRPC$TL_updatesCombined.constructor, TLRPC$TL_updatesCombined.class);
        this.classStore.put(TLRPC$TL_updateShortSentMessage.constructor, TLRPC$TL_updateShortSentMessage.class);
        this.classStore.put(TLRPC$TL_updatesTooLong.constructor, TLRPC$TL_updatesTooLong.class);
        this.classStore.put(TLRPC$TL_updates_token.constructor, TLRPC$TL_updates_token.class);
        this.classStore.put(TLRPC$TL_updates_ExpireToken.constructor, TLRPC$TL_updates_ExpireToken.class);
        this.classStore.put(TLRPC$TL_tokenUpdateing.constructor, TLRPC$TL_tokenUpdateing.class);
        this.classStore.put(TLRPC$TL_pong.constructor, TLRPC$TL_pong.class);
        this.classStore.put(TLRPC$TL_socketPong.constructor, TLRPC$TL_socketPong.class);
    }

    public static TLClassStore Instance() {
        if (store == null) {
            store = new TLClassStore();
        }
        return store;
    }

    public TLObject TLdeserialize(NativeByteBuffer stream, int constructor, boolean exception) {
        Class cls = this.classStore.get(constructor);
        if (cls != null) {
            try {
                TLObject tLObject = (TLObject) cls.newInstance();
                tLObject.readParams(stream, exception);
                return tLObject;
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        return null;
    }

    public TLObject TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        Class cls = this.classStore.get(constructor);
        if (cls != null) {
            try {
                TLObject tLObject = (TLObject) cls.newInstance();
                tLObject.readParams(stream, exception);
                return tLObject;
            } catch (Throwable th) {
                FileLog.e("tmessages", th);
            }
        }
        return null;
    }
}
