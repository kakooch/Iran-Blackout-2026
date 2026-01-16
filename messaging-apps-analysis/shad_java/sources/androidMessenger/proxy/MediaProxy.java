package androidMessenger.proxy;

import androidMessenger.model.ExtraMediaInfo;
import androidMessenger.utilites.MessageConverter;
import ir.aaap.messengercore.MessageUtils;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.LoadMessagesResult;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.TLRPC$messages_Messages;

/* loaded from: classes.dex */
public class MediaProxy extends BaseController {
    public MediaProxy(int i) {
        super(i);
        this.currentAccount = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadMedia(long r21, final int r23, long r24, int r26, int r27, int r28) {
        /*
            r20 = this;
            r9 = r20
            r0 = r21
            int r2 = (int) r0
            if (r2 >= 0) goto L12
            int r3 = -r2
            int r4 = r9.currentAccount
            boolean r3 = org.rbmain.messenger.ChatObject.isChannelAppp(r3, r4)
            if (r3 == 0) goto L12
            r3 = 1
            goto L13
        L12:
            r3 = 0
        L13:
            androidMessenger.proxy.IdStorage r4 = androidMessenger.proxy.IdStorage.getInstance()
            long r5 = (long) r2
            java.lang.String r4 = r4.getDialogId(r5)
            if (r4 != 0) goto L1f
            return
        L1f:
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            androidMessenger.model.ExtraMediaInfo r8 = new androidMessenger.model.ExtraMediaInfo
            r10 = r8
            r11 = r21
            r13 = r23
            r14 = r24
            r16 = r26
            r17 = r27
            r18 = r28
            r19 = r3
            r10.<init>(r11, r13, r14, r16, r17, r18, r19)
            r10 = 0
            int r7 = (r24 > r10 ? 1 : (r24 == r10 ? 0 : -1))
            if (r7 == 0) goto L44
            r0 = 1
            long r0 = r24 - r0
        L42:
            r5 = r0
            goto L55
        L44:
            org.rbmain.messenger.MessagesController r7 = r20.getMessagesController()
            androidx.collection.LongSparseArray<org.rbmain.tgnet.TLRPC$Dialog> r7 = r7.dialogs_dict
            java.lang.Object r0 = r7.get(r0)
            org.rbmain.tgnet.TLRPC$Dialog r0 = (org.rbmain.tgnet.TLRPC$Dialog) r0
            if (r0 == 0) goto L55
            long r0 = r0.top_message_server
            goto L42
        L55:
            if (r2 <= 0) goto L74
            org.rbmain.messenger.MessagesController r0 = r20.getMessagesController()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            org.rbmain.tgnet.TLRPC$User r0 = r0.getUser(r1)
            boolean r1 = r0.bot
            if (r1 == 0) goto L6a
            ir.aaap.messengercore.model.ChatType r0 = ir.aaap.messengercore.model.ChatType.Bot
            goto L7b
        L6a:
            boolean r0 = r0.support
            if (r0 == 0) goto L71
            ir.aaap.messengercore.model.ChatType r0 = ir.aaap.messengercore.model.ChatType.Service
            goto L7b
        L71:
            ir.aaap.messengercore.model.ChatType r0 = ir.aaap.messengercore.model.ChatType.User
            goto L7b
        L74:
            if (r3 == 0) goto L79
            ir.aaap.messengercore.model.ChatType r0 = ir.aaap.messengercore.model.ChatType.Channel
            goto L7b
        L79:
            ir.aaap.messengercore.model.ChatType r0 = ir.aaap.messengercore.model.ChatType.Group
        L7b:
            r3 = r0
            r0 = r26
            ir.aaap.messengercore.MessageUtils$FilterTypeEnum r7 = r9.getMediaType(r0)
            if (r7 != 0) goto L85
            return
        L85:
            org.rbmain.messenger.DispatchQueue r10 = org.rbmain.messenger.Utilities.stageQueue
            androidMessenger.proxy.MediaProxy$$ExternalSyntheticLambda1 r11 = new androidMessenger.proxy.MediaProxy$$ExternalSyntheticLambda1
            r0 = r11
            r1 = r20
            r2 = r4
            r4 = r7
            r7 = r23
            r0.<init>()
            r10.postRunnable(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.proxy.MediaProxy.loadMedia(long, int, long, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadMedia$0(String str, ChatType chatType, MessageUtils.FilterTypeEnum filterTypeEnum, long j, int i, ExtraMediaInfo extraMediaInfo) {
        getAccountInstance().getCoreMainClass().loadMessages(str, chatType, filterTypeEnum, false, 0L, j, 0L, 0L, i, extraMediaInfo, false, false);
    }

    private MessageUtils.FilterTypeEnum getMediaType(int i) {
        if (i == 0) {
            return MessageUtils.FilterTypeEnum.Media;
        }
        if (i == 1) {
            return MessageUtils.FilterTypeEnum.File;
        }
        if (i == 3) {
            return null;
        }
        if (i == 4) {
            return MessageUtils.FilterTypeEnum.Music;
        }
        if (i == 2) {
            return MessageUtils.FilterTypeEnum.Voice;
        }
        return null;
    }

    public void proxyMedias(final LoadMessagesResult loadMessagesResult) {
        Object obj = loadMessagesResult.extraInfo;
        if (obj instanceof ExtraMediaInfo) {
            final ExtraMediaInfo extraMediaInfo = (ExtraMediaInfo) obj;
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MediaProxy$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$proxyMedias$1(extraMediaInfo, loadMessagesResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyMedias$1(ExtraMediaInfo extraMediaInfo, LoadMessagesResult loadMessagesResult) {
        TLRPC$messages_Messages tLRPC$messages_MessagesConvertAllMessages = MessageConverter.convertAllMessages(getAccountInstance().getCoreMainClass(), extraMediaInfo.uid, extraMediaInfo.isChannel, loadMessagesResult.messages, null);
        getAccountInstance().getMediaDataController().processLoadedMedia(tLRPC$messages_MessagesConvertAllMessages, extraMediaInfo.uid, tLRPC$messages_MessagesConvertAllMessages.messages.size(), extraMediaInfo.max_id, extraMediaInfo.type, 0, extraMediaInfo.classGuid, extraMediaInfo.isChannel, !loadMessagesResult.hasContinue);
    }
}
