package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$DecryptedMessageAction extends TLObject {
    public TLRPC$SendMessageAction action;
    public int end_seq_no;
    public long exchange_id;
    public byte[] g_a;
    public byte[] g_b;
    public long key_fingerprint;
    public int layer;
    public ArrayList<Long> random_ids = new ArrayList<>();
    public int start_seq_no;
    public int ttl_seconds;

    public static TLRPC$DecryptedMessageAction TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$DecryptedMessageAction tLRPC$TL_decryptedMessageActionScreenshotMessages;
        switch (constructor) {
            case -1967000459:
                tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$TL_decryptedMessageActionScreenshotMessages();
                break;
            case -1586283796:
                tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$TL_decryptedMessageActionSetMessageTTL();
                break;
            case -1473258141:
                tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$TL_decryptedMessageActionNoop();
                break;
            case -860719551:
                tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$DecryptedMessageAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionTyping
                    public static int constructor = -860719551;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.action = TLRPC$SendMessageAction.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.action.serializeToStream(stream2);
                    }
                };
                break;
            case -586814357:
                tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$TL_decryptedMessageActionAbortKey();
                break;
            case -332526693:
                tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$TL_decryptedMessageActionCommitKey();
                break;
            case -217806717:
                tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$TL_decryptedMessageActionNotifyLayer();
                break;
            case -204906213:
                tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$TL_decryptedMessageActionRequestKey();
                break;
            case 206520510:
                tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$TL_decryptedMessageActionReadMessages();
                break;
            case 1360072880:
                tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$TL_decryptedMessageActionResend();
                break;
            case 1700872964:
                tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$TL_decryptedMessageActionDeleteMessages();
                break;
            case 1729750108:
                tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$TL_decryptedMessageActionFlushHistory();
                break;
            case 1877046107:
                tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$TL_decryptedMessageActionAcceptKey();
                break;
            default:
                tLRPC$TL_decryptedMessageActionScreenshotMessages = null;
                break;
        }
        if (tLRPC$TL_decryptedMessageActionScreenshotMessages == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in DecryptedMessageAction", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_decryptedMessageActionScreenshotMessages != null) {
            tLRPC$TL_decryptedMessageActionScreenshotMessages.readParams(stream, exception);
        }
        return tLRPC$TL_decryptedMessageActionScreenshotMessages;
    }
}
