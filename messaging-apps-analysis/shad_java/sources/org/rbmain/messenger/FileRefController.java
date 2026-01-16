package org.rbmain.messenger;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.rbmain.messenger.FileLoadOperation;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatPhoto;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$InputFileLocation;
import org.rbmain.tgnet.TLRPC$InputMedia;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$InputStickerSet;
import org.rbmain.tgnet.TLRPC$InputStickeredMedia;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$Page;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$StickerSet;
import org.rbmain.tgnet.TLRPC$StickerSetCovered;
import org.rbmain.tgnet.TLRPC$TL_account_getTheme;
import org.rbmain.tgnet.TLRPC$TL_account_getWallPaper;
import org.rbmain.tgnet.TLRPC$TL_account_getWallPapers;
import org.rbmain.tgnet.TLRPC$TL_channel;
import org.rbmain.tgnet.TLRPC$TL_channels_getChannels;
import org.rbmain.tgnet.TLRPC$TL_channels_getMessages;
import org.rbmain.tgnet.TLRPC$TL_chat;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputDocumentFileLocation;
import org.rbmain.tgnet.TLRPC$TL_inputFileLocation;
import org.rbmain.tgnet.TLRPC$TL_inputMediaDocument;
import org.rbmain.tgnet.TLRPC$TL_inputMediaPhoto;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterChatPhotos;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChannel;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChat;
import org.rbmain.tgnet.TLRPC$TL_inputPeerPhotoFileLocation;
import org.rbmain.tgnet.TLRPC$TL_inputPeerUser;
import org.rbmain.tgnet.TLRPC$TL_inputPhotoFileLocation;
import org.rbmain.tgnet.TLRPC$TL_inputSingleMedia;
import org.rbmain.tgnet.TLRPC$TL_inputStickerSetID;
import org.rbmain.tgnet.TLRPC$TL_inputStickeredMediaDocument;
import org.rbmain.tgnet.TLRPC$TL_inputStickeredMediaPhoto;
import org.rbmain.tgnet.TLRPC$TL_inputTheme;
import org.rbmain.tgnet.TLRPC$TL_inputWallPaper;
import org.rbmain.tgnet.TLRPC$TL_messages_editMessage;
import org.rbmain.tgnet.TLRPC$TL_messages_faveSticker;
import org.rbmain.tgnet.TLRPC$TL_messages_getAttachedStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getChats;
import org.rbmain.tgnet.TLRPC$TL_messages_getFavedStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getMessages;
import org.rbmain.tgnet.TLRPC$TL_messages_getRecentStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getSavedGifs;
import org.rbmain.tgnet.TLRPC$TL_messages_getScheduledMessages;
import org.rbmain.tgnet.TLRPC$TL_messages_getStickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_getWebPage;
import org.rbmain.tgnet.TLRPC$TL_messages_saveGif;
import org.rbmain.tgnet.TLRPC$TL_messages_saveRecentSticker;
import org.rbmain.tgnet.TLRPC$TL_messages_search;
import org.rbmain.tgnet.TLRPC$TL_messages_sendMedia;
import org.rbmain.tgnet.TLRPC$TL_messages_sendMultiMedia;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.tgnet.TLRPC$TL_photos_getUserPhotos;
import org.rbmain.tgnet.TLRPC$TL_theme;
import org.rbmain.tgnet.TLRPC$TL_users_getUsers;
import org.rbmain.tgnet.TLRPC$TL_wallPaper;
import org.rbmain.tgnet.TLRPC$TL_webPageAttributeTheme;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.tgnet.TLRPC$WebPage;

/* loaded from: classes4.dex */
public class FileRefController extends BaseController {
    private static volatile FileRefController[] Instance = new FileRefController[3];
    private ArrayList<Waiter> favStickersWaiter;
    private long lastCleanupTime;
    private HashMap<String, ArrayList<Requester>> locationRequester;
    private HashMap<TLRPC$TL_messages_sendMultiMedia, Object[]> multiMediaCache;
    private HashMap<String, ArrayList<Requester>> parentRequester;
    private ArrayList<Waiter> recentStickersWaiter;
    private HashMap<String, CachedResult> responseCache;
    private ArrayList<Waiter> savedGifsWaiters;
    private ArrayList<Waiter> wallpaperWaiters;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onUpdateObjectReference$23(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onUpdateObjectReference$24(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onUpdateObjectReference$25(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Requester {
        private Object[] args;
        private boolean completed;
        private TLRPC$InputFileLocation location;
        private String locationKey;

        private Requester() {
        }
    }

    private static class CachedResult {
        private long firstQueryTime;
        private long lastQueryTime;
        private TLObject response;

        private CachedResult() {
        }
    }

    private static class Waiter {
        private String locationKey;
        private String parentKey;

        public Waiter(String str, String str2) {
            this.locationKey = str;
            this.parentKey = str2;
        }
    }

    public static FileRefController getInstance(int i) {
        FileRefController fileRefController = Instance[i];
        if (fileRefController == null) {
            synchronized (FileRefController.class) {
                fileRefController = Instance[i];
                if (fileRefController == null) {
                    FileRefController[] fileRefControllerArr = Instance;
                    FileRefController fileRefController2 = new FileRefController(i);
                    fileRefControllerArr[i] = fileRefController2;
                    fileRefController = fileRefController2;
                }
            }
        }
        return fileRefController;
    }

    public FileRefController(int i) {
        super(i);
        this.locationRequester = new HashMap<>();
        this.parentRequester = new HashMap<>();
        this.responseCache = new HashMap<>();
        this.multiMediaCache = new HashMap<>();
        this.lastCleanupTime = SystemClock.elapsedRealtime();
        this.wallpaperWaiters = new ArrayList<>();
        this.savedGifsWaiters = new ArrayList<>();
        this.recentStickersWaiter = new ArrayList<>();
        this.favStickersWaiter = new ArrayList<>();
    }

    public static String getKeyForParentObject(Object obj) {
        if (obj instanceof MessageObject) {
            MessageObject messageObject = (MessageObject) obj;
            return "message" + messageObject.getRealId() + "_" + messageObject.getChannelId() + "_" + messageObject.scheduled;
        }
        if (obj instanceof TLRPC$Message) {
            TLRPC$Message tLRPC$Message = (TLRPC$Message) obj;
            TLRPC$Peer tLRPC$Peer = tLRPC$Message.peer_id;
            return "message" + tLRPC$Message.id + "_" + (tLRPC$Peer != null ? tLRPC$Peer.channel_id : 0) + "_" + tLRPC$Message.from_scheduled;
        }
        if (obj instanceof TLRPC$WebPage) {
            return "webpage" + ((TLRPC$WebPage) obj).id;
        }
        if (obj instanceof TLRPC$User) {
            return "user" + ((TLRPC$User) obj).id;
        }
        if (obj instanceof TLRPC$Chat) {
            return "chat" + ((TLRPC$Chat) obj).id;
        }
        if (obj instanceof String) {
            return "str" + ((String) obj);
        }
        if (obj instanceof TLRPC$TL_messages_stickerSet) {
            return "set" + ((TLRPC$TL_messages_stickerSet) obj).set.id;
        }
        if (obj instanceof TLRPC$StickerSetCovered) {
            return "set" + ((TLRPC$StickerSetCovered) obj).set.id;
        }
        if (obj instanceof TLRPC$InputStickerSet) {
            return "set" + ((TLRPC$InputStickerSet) obj).id;
        }
        if (obj instanceof TLRPC$TL_wallPaper) {
            return "wallpaper" + ((TLRPC$TL_wallPaper) obj).id;
        }
        if (obj instanceof TLRPC$TL_theme) {
            return "theme" + ((TLRPC$TL_theme) obj).id;
        }
        if (obj == null) {
            return null;
        }
        return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR + obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0346  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void requestReference(java.lang.Object r12, java.lang.Object... r13) {
        /*
            Method dump skipped, instructions count: 896
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.FileRefController.requestReference(java.lang.Object, java.lang.Object[]):void");
    }

    private void broadcastWaitersData(ArrayList<Waiter> arrayList, TLObject tLObject) {
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Waiter waiter = arrayList.get(i);
            onRequestComplete(waiter.locationKey, waiter.parentKey, tLObject, i == size + (-1));
            i++;
        }
        arrayList.clear();
    }

    private void requestReferenceFromServer(Object obj, final String str, final String str2, Object[] objArr) {
        if (obj instanceof MessageObject) {
            MessageObject messageObject = (MessageObject) obj;
            int channelId = messageObject.getChannelId();
            if (messageObject.scheduled) {
                TLRPC$TL_messages_getScheduledMessages tLRPC$TL_messages_getScheduledMessages = new TLRPC$TL_messages_getScheduledMessages();
                tLRPC$TL_messages_getScheduledMessages.peer = getMessagesController().getInputPeer((int) messageObject.getDialogId());
                tLRPC$TL_messages_getScheduledMessages.id.add(Long.valueOf(messageObject.getRealId()));
                getConnectionsManager().sendRequest(tLRPC$TL_messages_getScheduledMessages, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda26
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$requestReferenceFromServer$0(str, str2, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            if (channelId != 0) {
                TLRPC$TL_channels_getMessages tLRPC$TL_channels_getMessages = new TLRPC$TL_channels_getMessages();
                tLRPC$TL_channels_getMessages.channel = getMessagesController().getInputChannel(channelId);
                tLRPC$TL_channels_getMessages.id.add(Long.valueOf(messageObject.getRealId()));
                getConnectionsManager().sendRequest(tLRPC$TL_channels_getMessages, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda14
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$requestReferenceFromServer$1(str, str2, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages = new TLRPC$TL_messages_getMessages();
            tLRPC$TL_messages_getMessages.id.add(Long.valueOf(messageObject.getRealId()));
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getMessages, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda19
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$2(str, str2, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (obj instanceof TLRPC$TL_wallPaper) {
            TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) obj;
            TLRPC$TL_account_getWallPaper tLRPC$TL_account_getWallPaper = new TLRPC$TL_account_getWallPaper();
            TLRPC$TL_inputWallPaper tLRPC$TL_inputWallPaper = new TLRPC$TL_inputWallPaper();
            tLRPC$TL_inputWallPaper.id = tLRPC$TL_wallPaper.id;
            tLRPC$TL_inputWallPaper.access_hash = tLRPC$TL_wallPaper.access_hash;
            tLRPC$TL_account_getWallPaper.wallpaper = tLRPC$TL_inputWallPaper;
            getConnectionsManager().sendRequest(tLRPC$TL_account_getWallPaper, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda25
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$3(str, str2, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (obj instanceof TLRPC$TL_theme) {
            TLRPC$TL_theme tLRPC$TL_theme = (TLRPC$TL_theme) obj;
            TLRPC$TL_account_getTheme tLRPC$TL_account_getTheme = new TLRPC$TL_account_getTheme();
            TLRPC$TL_inputTheme tLRPC$TL_inputTheme = new TLRPC$TL_inputTheme();
            tLRPC$TL_inputTheme.id = tLRPC$TL_theme.id;
            tLRPC$TL_inputTheme.access_hash = tLRPC$TL_theme.access_hash;
            tLRPC$TL_account_getTheme.theme = tLRPC$TL_inputTheme;
            tLRPC$TL_account_getTheme.format = "android";
            getConnectionsManager().sendRequest(tLRPC$TL_account_getTheme, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda20
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$4(str, str2, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (obj instanceof TLRPC$WebPage) {
            TLRPC$TL_messages_getWebPage tLRPC$TL_messages_getWebPage = new TLRPC$TL_messages_getWebPage();
            tLRPC$TL_messages_getWebPage.url = ((TLRPC$WebPage) obj).url;
            tLRPC$TL_messages_getWebPage.hash = 0;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getWebPage, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda17
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$5(str, str2, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (obj instanceof TLRPC$User) {
            TLRPC$TL_users_getUsers tLRPC$TL_users_getUsers = new TLRPC$TL_users_getUsers();
            tLRPC$TL_users_getUsers.id.add(getMessagesController().getInputUser((TLRPC$User) obj));
            getConnectionsManager().sendRequest(tLRPC$TL_users_getUsers, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda28
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$6(str, str2, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (obj instanceof TLRPC$Chat) {
            TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) obj;
            if (tLRPC$Chat instanceof TLRPC$TL_chat) {
                TLRPC$TL_messages_getChats tLRPC$TL_messages_getChats = new TLRPC$TL_messages_getChats();
                tLRPC$TL_messages_getChats.id.add(Long.valueOf(tLRPC$Chat.id));
                getConnectionsManager().sendRequest(tLRPC$TL_messages_getChats, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda29
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$requestReferenceFromServer$7(str, str2, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            } else {
                if (tLRPC$Chat instanceof TLRPC$TL_channel) {
                    TLRPC$TL_channels_getChannels tLRPC$TL_channels_getChannels = new TLRPC$TL_channels_getChannels();
                    tLRPC$TL_channels_getChannels.id.add(MessagesController.getInputChannel(tLRPC$Chat));
                    getConnectionsManager().sendRequest(tLRPC$TL_channels_getChannels, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda27
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$requestReferenceFromServer$8(str, str2, tLObject, tLRPC$TL_error);
                        }
                    });
                    return;
                }
                return;
            }
        }
        if (obj instanceof String) {
            String str3 = (String) obj;
            if ("wallpaper".equals(str3)) {
                if (this.wallpaperWaiters.isEmpty()) {
                    getConnectionsManager().sendRequest(new TLRPC$TL_account_getWallPapers(), new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda12
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$requestReferenceFromServer$9(tLObject, tLRPC$TL_error);
                        }
                    });
                }
                this.wallpaperWaiters.add(new Waiter(str, str2));
                return;
            }
            if (str3.startsWith("gif")) {
                if (this.savedGifsWaiters.isEmpty()) {
                    getConnectionsManager().sendRequest(new TLRPC$TL_messages_getSavedGifs(), new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda11
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$requestReferenceFromServer$10(tLObject, tLRPC$TL_error);
                        }
                    });
                }
                this.savedGifsWaiters.add(new Waiter(str, str2));
                return;
            }
            if ("recent".equals(str3)) {
                if (this.recentStickersWaiter.isEmpty()) {
                    getConnectionsManager().sendRequest(new TLRPC$TL_messages_getRecentStickers(), new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda13
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$requestReferenceFromServer$11(tLObject, tLRPC$TL_error);
                        }
                    });
                }
                this.recentStickersWaiter.add(new Waiter(str, str2));
                return;
            }
            if ("fav".equals(str3)) {
                if (this.favStickersWaiter.isEmpty()) {
                    getConnectionsManager().sendRequest(new TLRPC$TL_messages_getFavedStickers(), new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda10
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$requestReferenceFromServer$12(tLObject, tLRPC$TL_error);
                        }
                    });
                }
                this.favStickersWaiter.add(new Waiter(str, str2));
                return;
            }
            if (str3.startsWith("avatar_")) {
                int iIntValue = Utilities.parseInt(str3).intValue();
                if (iIntValue > 0) {
                    TLRPC$TL_photos_getUserPhotos tLRPC$TL_photos_getUserPhotos = new TLRPC$TL_photos_getUserPhotos();
                    tLRPC$TL_photos_getUserPhotos.limit = 80;
                    tLRPC$TL_photos_getUserPhotos.offset = 0;
                    tLRPC$TL_photos_getUserPhotos.max_id = 0L;
                    tLRPC$TL_photos_getUserPhotos.user_id = getMessagesController().getInputUser(iIntValue);
                    getConnectionsManager().sendRequest(tLRPC$TL_photos_getUserPhotos, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda22
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$requestReferenceFromServer$13(str, str2, tLObject, tLRPC$TL_error);
                        }
                    });
                    return;
                }
                TLRPC$TL_messages_search tLRPC$TL_messages_search = new TLRPC$TL_messages_search();
                tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterChatPhotos();
                tLRPC$TL_messages_search.limit = 80;
                tLRPC$TL_messages_search.offset_id = 0L;
                tLRPC$TL_messages_search.q = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
                tLRPC$TL_messages_search.peer = getMessagesController().getInputPeer(iIntValue);
                getConnectionsManager().sendRequest(tLRPC$TL_messages_search, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda21
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$requestReferenceFromServer$14(str, str2, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            if (str3.startsWith("sent_")) {
                String[] strArrSplit = str3.split("_");
                if (strArrSplit.length == 3) {
                    int iIntValue2 = Utilities.parseInt(strArrSplit[1]).intValue();
                    if (iIntValue2 != 0) {
                        TLRPC$TL_channels_getMessages tLRPC$TL_channels_getMessages2 = new TLRPC$TL_channels_getMessages();
                        tLRPC$TL_channels_getMessages2.channel = getMessagesController().getInputChannel(iIntValue2);
                        tLRPC$TL_channels_getMessages2.id.add(Long.valueOf(Utilities.parseInt(strArrSplit[2]).intValue()));
                        getConnectionsManager().sendRequest(tLRPC$TL_channels_getMessages2, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda15
                            @Override // org.rbmain.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                this.f$0.lambda$requestReferenceFromServer$15(str, str2, tLObject, tLRPC$TL_error);
                            }
                        });
                        return;
                    }
                    TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages2 = new TLRPC$TL_messages_getMessages();
                    tLRPC$TL_messages_getMessages2.id.add(Long.valueOf(Utilities.parseInt(strArrSplit[2]).intValue()));
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_getMessages2, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda24
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$requestReferenceFromServer$16(str, str2, tLObject, tLRPC$TL_error);
                        }
                    });
                    return;
                }
                sendErrorToObject(objArr, 0);
                return;
            }
            sendErrorToObject(objArr, 0);
            return;
        }
        if (obj instanceof TLRPC$TL_messages_stickerSet) {
            TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet = new TLRPC$TL_messages_getStickerSet();
            TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
            tLRPC$TL_messages_getStickerSet.stickerset = tLRPC$TL_inputStickerSetID;
            TLRPC$StickerSet tLRPC$StickerSet = ((TLRPC$TL_messages_stickerSet) obj).set;
            tLRPC$TL_inputStickerSetID.id = tLRPC$StickerSet.id;
            tLRPC$TL_inputStickerSetID.access_hash = tLRPC$StickerSet.access_hash;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda23
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$17(str, str2, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (obj instanceof TLRPC$StickerSetCovered) {
            TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet2 = new TLRPC$TL_messages_getStickerSet();
            TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID2 = new TLRPC$TL_inputStickerSetID();
            tLRPC$TL_messages_getStickerSet2.stickerset = tLRPC$TL_inputStickerSetID2;
            TLRPC$StickerSet tLRPC$StickerSet2 = ((TLRPC$StickerSetCovered) obj).set;
            tLRPC$TL_inputStickerSetID2.id = tLRPC$StickerSet2.id;
            tLRPC$TL_inputStickerSetID2.access_hash = tLRPC$StickerSet2.access_hash;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet2, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda16
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$18(str, str2, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (obj instanceof TLRPC$InputStickerSet) {
            TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet3 = new TLRPC$TL_messages_getStickerSet();
            tLRPC$TL_messages_getStickerSet3.stickerset = (TLRPC$InputStickerSet) obj;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet3, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda18
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$19(str, str2, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        sendErrorToObject(objArr, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$0(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$1(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$2(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$3(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$4(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$5(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$6(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$7(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$8(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$9(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        broadcastWaitersData(this.wallpaperWaiters, tLObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$10(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        broadcastWaitersData(this.savedGifsWaiters, tLObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$11(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        broadcastWaitersData(this.recentStickersWaiter, tLObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$12(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        broadcastWaitersData(this.favStickersWaiter, tLObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$13(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$14(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$15(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$16(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$17(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$18(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestReferenceFromServer$19(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true);
    }

    private void onUpdateObjectReference(final Requester requester, byte[] bArr, TLRPC$InputFileLocation tLRPC$InputFileLocation) {
        if (BuildVars.DEBUG_VERSION) {
            FileLog.d("fileref updated for " + requester.args[0] + " " + requester.locationKey);
        }
        boolean z = true;
        if (requester.args[0] instanceof TLRPC$TL_inputSingleMedia) {
            final TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia = (TLRPC$TL_messages_sendMultiMedia) requester.args[1];
            final Object[] objArr = this.multiMediaCache.get(tLRPC$TL_messages_sendMultiMedia);
            if (objArr == null) {
                return;
            }
            TLRPC$TL_inputSingleMedia tLRPC$TL_inputSingleMedia = (TLRPC$TL_inputSingleMedia) requester.args[0];
            TLRPC$InputMedia tLRPC$InputMedia = tLRPC$TL_inputSingleMedia.media;
            if (tLRPC$InputMedia instanceof TLRPC$TL_inputMediaDocument) {
                ((TLRPC$TL_inputMediaDocument) tLRPC$InputMedia).id.file_reference = bArr;
            } else if (tLRPC$InputMedia instanceof TLRPC$TL_inputMediaPhoto) {
                ((TLRPC$TL_inputMediaPhoto) tLRPC$InputMedia).id.file_reference = bArr;
            }
            int iIndexOf = tLRPC$TL_messages_sendMultiMedia.multi_media.indexOf(tLRPC$TL_inputSingleMedia);
            if (iIndexOf < 0) {
                return;
            }
            ArrayList arrayList = (ArrayList) objArr[3];
            arrayList.set(iIndexOf, null);
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) != null) {
                    z = false;
                }
            }
            if (z) {
                this.multiMediaCache.remove(tLRPC$TL_messages_sendMultiMedia);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onUpdateObjectReference$20(tLRPC$TL_messages_sendMultiMedia, objArr);
                    }
                });
                return;
            }
            return;
        }
        if (!(requester.args[0] instanceof TLRPC$TL_messages_sendMedia)) {
            if (!(requester.args[0] instanceof TLRPC$TL_messages_editMessage)) {
                if (requester.args[0] instanceof TLRPC$TL_messages_saveGif) {
                    TLRPC$TL_messages_saveGif tLRPC$TL_messages_saveGif = (TLRPC$TL_messages_saveGif) requester.args[0];
                    tLRPC$TL_messages_saveGif.id.file_reference = bArr;
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_saveGif, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda30
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            FileRefController.lambda$onUpdateObjectReference$23(tLObject, tLRPC$TL_error);
                        }
                    });
                    return;
                }
                if (requester.args[0] instanceof TLRPC$TL_messages_saveRecentSticker) {
                    TLRPC$TL_messages_saveRecentSticker tLRPC$TL_messages_saveRecentSticker = (TLRPC$TL_messages_saveRecentSticker) requester.args[0];
                    tLRPC$TL_messages_saveRecentSticker.id.file_reference = bArr;
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_saveRecentSticker, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda32
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            FileRefController.lambda$onUpdateObjectReference$24(tLObject, tLRPC$TL_error);
                        }
                    });
                    return;
                }
                if (requester.args[0] instanceof TLRPC$TL_messages_faveSticker) {
                    TLRPC$TL_messages_faveSticker tLRPC$TL_messages_faveSticker = (TLRPC$TL_messages_faveSticker) requester.args[0];
                    tLRPC$TL_messages_faveSticker.id.file_reference = bArr;
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_faveSticker, new RequestDelegate() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda31
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            FileRefController.lambda$onUpdateObjectReference$25(tLObject, tLRPC$TL_error);
                        }
                    });
                    return;
                }
                if (requester.args[0] instanceof TLRPC$TL_messages_getAttachedStickers) {
                    TLRPC$TL_messages_getAttachedStickers tLRPC$TL_messages_getAttachedStickers = (TLRPC$TL_messages_getAttachedStickers) requester.args[0];
                    TLRPC$InputStickeredMedia tLRPC$InputStickeredMedia = tLRPC$TL_messages_getAttachedStickers.media;
                    if (tLRPC$InputStickeredMedia instanceof TLRPC$TL_inputStickeredMediaDocument) {
                        ((TLRPC$TL_inputStickeredMediaDocument) tLRPC$InputStickeredMedia).id.file_reference = bArr;
                    } else if (tLRPC$InputStickeredMedia instanceof TLRPC$TL_inputStickeredMediaPhoto) {
                        ((TLRPC$TL_inputStickeredMediaPhoto) tLRPC$InputStickeredMedia).id.file_reference = bArr;
                    }
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_getAttachedStickers, (RequestDelegate) requester.args[1]);
                    return;
                }
                if (requester.args[1] instanceof FileLoadOperation) {
                    FileLoadOperation fileLoadOperation = (FileLoadOperation) requester.args[1];
                    if (tLRPC$InputFileLocation == null) {
                        requester.location.file_reference = bArr;
                    } else {
                        fileLoadOperation.location = tLRPC$InputFileLocation;
                    }
                    fileLoadOperation.requestingReference = false;
                    fileLoadOperation.startDownloadRequest();
                    return;
                }
                return;
            }
            TLRPC$InputMedia tLRPC$InputMedia2 = ((TLRPC$TL_messages_editMessage) requester.args[0]).media;
            if (tLRPC$InputMedia2 instanceof TLRPC$TL_inputMediaDocument) {
                ((TLRPC$TL_inputMediaDocument) tLRPC$InputMedia2).id.file_reference = bArr;
            } else if (tLRPC$InputMedia2 instanceof TLRPC$TL_inputMediaPhoto) {
                ((TLRPC$TL_inputMediaPhoto) tLRPC$InputMedia2).id.file_reference = bArr;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onUpdateObjectReference$22(requester);
                }
            });
            return;
        }
        TLRPC$InputMedia tLRPC$InputMedia3 = ((TLRPC$TL_messages_sendMedia) requester.args[0]).media;
        if (tLRPC$InputMedia3 instanceof TLRPC$TL_inputMediaDocument) {
            ((TLRPC$TL_inputMediaDocument) tLRPC$InputMedia3).id.file_reference = bArr;
        } else if (tLRPC$InputMedia3 instanceof TLRPC$TL_inputMediaPhoto) {
            ((TLRPC$TL_inputMediaPhoto) tLRPC$InputMedia3).id.file_reference = bArr;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onUpdateObjectReference$21(requester);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUpdateObjectReference$20(TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia, Object[] objArr) {
        getSendMessagesHelper().performSendMessageRequestMulti(tLRPC$TL_messages_sendMultiMedia, (ArrayList) objArr[1], (ArrayList) objArr[2], null, (SendMessagesHelper.DelayedMessage) objArr[4], ((Boolean) objArr[5]).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUpdateObjectReference$21(Requester requester) {
        getSendMessagesHelper().performSendMessageRequest((TLObject) requester.args[0], (MessageObject) requester.args[1], (String) requester.args[2], (SendMessagesHelper.DelayedMessage) requester.args[3], ((Boolean) requester.args[4]).booleanValue(), (SendMessagesHelper.DelayedMessage) requester.args[5], null, null, ((Boolean) requester.args[6]).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUpdateObjectReference$22(Requester requester) {
        getSendMessagesHelper().performSendMessageRequest((TLObject) requester.args[0], (MessageObject) requester.args[1], (String) requester.args[2], (SendMessagesHelper.DelayedMessage) requester.args[3], ((Boolean) requester.args[4]).booleanValue(), (SendMessagesHelper.DelayedMessage) requester.args[5], null, null, ((Boolean) requester.args[6]).booleanValue());
    }

    private void sendErrorToObject(final Object[] objArr, int i) {
        if (objArr[0] instanceof TLRPC$TL_inputSingleMedia) {
            final TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia = (TLRPC$TL_messages_sendMultiMedia) objArr[1];
            final Object[] objArr2 = this.multiMediaCache.get(tLRPC$TL_messages_sendMultiMedia);
            if (objArr2 != null) {
                this.multiMediaCache.remove(tLRPC$TL_messages_sendMultiMedia);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$sendErrorToObject$26(tLRPC$TL_messages_sendMultiMedia, objArr2);
                    }
                });
                return;
            }
            return;
        }
        if ((objArr[0] instanceof TLRPC$TL_messages_sendMedia) || (objArr[0] instanceof TLRPC$TL_messages_editMessage)) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.FileRefController$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendErrorToObject$27(objArr);
                }
            });
            return;
        }
        if (objArr[0] instanceof TLRPC$TL_messages_saveGif) {
            return;
        }
        if (objArr[0] instanceof TLRPC$TL_messages_saveRecentSticker) {
            return;
        }
        if (objArr[0] instanceof TLRPC$TL_messages_faveSticker) {
            return;
        }
        if (objArr[0] instanceof TLRPC$TL_messages_getAttachedStickers) {
            getConnectionsManager().sendRequest((TLRPC$TL_messages_getAttachedStickers) objArr[0], (RequestDelegate) objArr[1]);
            return;
        }
        if (i == 0) {
            TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "not found parent object to request reference";
            tLRPC$TL_error.code = 400;
            if (objArr[1] instanceof FileLoadOperation) {
                FileLoadOperation fileLoadOperation = (FileLoadOperation) objArr[1];
                fileLoadOperation.requestingReference = false;
                fileLoadOperation.processRequestResult((FileLoadOperation.RequestInfo) objArr[2], tLRPC$TL_error);
                return;
            }
            return;
        }
        if (i == 1 && (objArr[1] instanceof FileLoadOperation)) {
            FileLoadOperation fileLoadOperation2 = (FileLoadOperation) objArr[1];
            fileLoadOperation2.requestingReference = false;
            fileLoadOperation2.onFail(false, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendErrorToObject$26(TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia, Object[] objArr) {
        getSendMessagesHelper().performSendMessageRequestMulti(tLRPC$TL_messages_sendMultiMedia, (ArrayList) objArr[1], (ArrayList) objArr[2], null, (SendMessagesHelper.DelayedMessage) objArr[4], ((Boolean) objArr[5]).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendErrorToObject$27(Object[] objArr) {
        getSendMessagesHelper().performSendMessageRequest((TLObject) objArr[0], (MessageObject) objArr[1], (String) objArr[2], (SendMessagesHelper.DelayedMessage) objArr[3], ((Boolean) objArr[4]).booleanValue(), (SendMessagesHelper.DelayedMessage) objArr[5], null, null, ((Boolean) objArr[6]).booleanValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0138 A[LOOP:2: B:53:0x00ba->B:78:0x0138, LOOP_END] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean onRequestComplete(java.lang.String r26, java.lang.String r27, org.rbmain.tgnet.TLObject r28, boolean r29) {
        /*
            Method dump skipped, instructions count: 1050
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.FileRefController.onRequestComplete(java.lang.String, java.lang.String, org.rbmain.tgnet.TLObject, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestComplete$29(TLRPC$User tLRPC$User) {
        getMessagesController().putUser(tLRPC$User, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestComplete$30(TLRPC$Chat tLRPC$Chat) {
        getMessagesController().putChat(tLRPC$Chat, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestComplete$31(TLRPC$Chat tLRPC$Chat) {
        getMessagesController().putChat(tLRPC$Chat, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestComplete$32(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        getMediaDataController().replaceStickerSet(tLRPC$TL_messages_stickerSet);
    }

    private void cleanupCache() {
        if (Math.abs(SystemClock.elapsedRealtime() - this.lastCleanupTime) < 600000) {
            return;
        }
        this.lastCleanupTime = SystemClock.elapsedRealtime();
        ArrayList arrayList = null;
        for (Map.Entry<String, CachedResult> entry : this.responseCache.entrySet()) {
            if (Math.abs(SystemClock.elapsedRealtime() - entry.getValue().firstQueryTime) >= 600000) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(entry.getKey());
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.responseCache.remove(arrayList.get(i));
            }
        }
    }

    private CachedResult getCachedResponse(String str) {
        CachedResult cachedResult = this.responseCache.get(str);
        if (cachedResult == null || Math.abs(SystemClock.elapsedRealtime() - cachedResult.firstQueryTime) < 600000) {
            return cachedResult;
        }
        this.responseCache.remove(str);
        return null;
    }

    private void putReponseToCache(String str, TLObject tLObject) {
        CachedResult cachedResult = this.responseCache.get(str);
        if (cachedResult == null) {
            cachedResult = new CachedResult();
            cachedResult.response = tLObject;
            cachedResult.firstQueryTime = SystemClock.uptimeMillis();
            this.responseCache.put(str, cachedResult);
        }
        cachedResult.lastQueryTime = SystemClock.uptimeMillis();
    }

    private byte[] getFileReference(TLRPC$Document tLRPC$Document, TLRPC$InputFileLocation tLRPC$InputFileLocation, boolean[] zArr, TLRPC$InputFileLocation[] tLRPC$InputFileLocationArr) {
        if (tLRPC$Document != null && tLRPC$InputFileLocation != null) {
            if (!(tLRPC$InputFileLocation instanceof TLRPC$TL_inputDocumentFileLocation)) {
                int size = tLRPC$Document.thumbs.size();
                for (int i = 0; i < size; i++) {
                    TLRPC$PhotoSize tLRPC$PhotoSize = tLRPC$Document.thumbs.get(i);
                    byte[] fileReference = getFileReference(tLRPC$PhotoSize, tLRPC$InputFileLocation, zArr);
                    if (zArr != null && zArr[0]) {
                        tLRPC$InputFileLocationArr[0] = new TLRPC$TL_inputDocumentFileLocation();
                        tLRPC$InputFileLocationArr[0].id = tLRPC$Document.id;
                        tLRPC$InputFileLocationArr[0].volume_id = tLRPC$InputFileLocation.volume_id;
                        tLRPC$InputFileLocationArr[0].local_id = tLRPC$InputFileLocation.local_id;
                        tLRPC$InputFileLocationArr[0].access_hash = tLRPC$Document.access_hash;
                        TLRPC$InputFileLocation tLRPC$InputFileLocation2 = tLRPC$InputFileLocationArr[0];
                        byte[] bArr = tLRPC$Document.file_reference;
                        tLRPC$InputFileLocation2.file_reference = bArr;
                        tLRPC$InputFileLocationArr[0].thumb_size = tLRPC$PhotoSize.type;
                        return bArr;
                    }
                    if (fileReference != null) {
                        return fileReference;
                    }
                }
            } else if (tLRPC$Document.id == tLRPC$InputFileLocation.id) {
                return tLRPC$Document.file_reference;
            }
        }
        return null;
    }

    private boolean getPeerReferenceReplacement(TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, boolean z, TLRPC$InputFileLocation tLRPC$InputFileLocation, TLRPC$InputFileLocation[] tLRPC$InputFileLocationArr, boolean[] zArr) {
        TLRPC$InputPeer tLRPC$TL_inputPeerChannel;
        TLRPC$InputPeer tLRPC$TL_inputPeerUser;
        if (zArr == null || !zArr[0]) {
            return false;
        }
        tLRPC$InputFileLocationArr[0] = new TLRPC$TL_inputPeerPhotoFileLocation();
        TLRPC$InputFileLocation tLRPC$InputFileLocation2 = tLRPC$InputFileLocationArr[0];
        long j = tLRPC$InputFileLocation.volume_id;
        tLRPC$InputFileLocation2.id = j;
        tLRPC$InputFileLocationArr[0].volume_id = j;
        tLRPC$InputFileLocationArr[0].local_id = tLRPC$InputFileLocation.local_id;
        tLRPC$InputFileLocationArr[0].big = z;
        if (tLRPC$User != null) {
            tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
            tLRPC$TL_inputPeerUser.user_id = tLRPC$User.id;
            tLRPC$TL_inputPeerUser.access_hash = tLRPC$User.access_hash;
        } else {
            if (ChatObject.isChannel(tLRPC$Chat)) {
                tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChat();
                tLRPC$TL_inputPeerChannel.chat_id = tLRPC$Chat.id;
            } else {
                tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
                tLRPC$TL_inputPeerChannel.channel_id = tLRPC$Chat.id;
                tLRPC$TL_inputPeerChannel.access_hash = tLRPC$Chat.access_hash;
            }
            tLRPC$TL_inputPeerUser = tLRPC$TL_inputPeerChannel;
        }
        tLRPC$InputFileLocationArr[0].peer = tLRPC$TL_inputPeerUser;
        return true;
    }

    private byte[] getFileReference(TLRPC$User tLRPC$User, TLRPC$InputFileLocation tLRPC$InputFileLocation, boolean[] zArr, TLRPC$InputFileLocation[] tLRPC$InputFileLocationArr) {
        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto;
        if (tLRPC$User == null || (tLRPC$UserProfilePhoto = tLRPC$User.photo) == null || !(tLRPC$InputFileLocation instanceof TLRPC$TL_inputFileLocation)) {
            return null;
        }
        byte[] fileReference = getFileReference(tLRPC$UserProfilePhoto.photo_small, tLRPC$InputFileLocation, zArr);
        if (getPeerReferenceReplacement(tLRPC$User, null, false, tLRPC$InputFileLocation, tLRPC$InputFileLocationArr, zArr)) {
            return new byte[0];
        }
        if (fileReference == null) {
            fileReference = getFileReference(tLRPC$User.photo.photo_big, tLRPC$InputFileLocation, zArr);
            if (getPeerReferenceReplacement(tLRPC$User, null, true, tLRPC$InputFileLocation, tLRPC$InputFileLocationArr, zArr)) {
                return new byte[0];
            }
        }
        return fileReference;
    }

    private byte[] getFileReference(TLRPC$Chat tLRPC$Chat, TLRPC$InputFileLocation tLRPC$InputFileLocation, boolean[] zArr, TLRPC$InputFileLocation[] tLRPC$InputFileLocationArr) {
        TLRPC$ChatPhoto tLRPC$ChatPhoto;
        if (tLRPC$Chat == null || (tLRPC$ChatPhoto = tLRPC$Chat.photo) == null || !(tLRPC$InputFileLocation instanceof TLRPC$TL_inputFileLocation)) {
            return null;
        }
        byte[] fileReference = getFileReference(tLRPC$ChatPhoto.photo_small, tLRPC$InputFileLocation, zArr);
        if (getPeerReferenceReplacement(null, tLRPC$Chat, false, tLRPC$InputFileLocation, tLRPC$InputFileLocationArr, zArr)) {
            return new byte[0];
        }
        if (fileReference == null) {
            fileReference = getFileReference(tLRPC$Chat.photo.photo_big, tLRPC$InputFileLocation, zArr);
            if (getPeerReferenceReplacement(null, tLRPC$Chat, true, tLRPC$InputFileLocation, tLRPC$InputFileLocationArr, zArr)) {
                return new byte[0];
            }
        }
        return fileReference;
    }

    private byte[] getFileReference(TLRPC$Photo tLRPC$Photo, TLRPC$InputFileLocation tLRPC$InputFileLocation, boolean[] zArr, TLRPC$InputFileLocation[] tLRPC$InputFileLocationArr) {
        if (tLRPC$Photo == null) {
            return null;
        }
        if (tLRPC$InputFileLocation instanceof TLRPC$TL_inputPhotoFileLocation) {
            if (tLRPC$Photo.id == tLRPC$InputFileLocation.id) {
                return tLRPC$Photo.file_reference;
            }
            return null;
        }
        if (tLRPC$InputFileLocation instanceof TLRPC$TL_inputFileLocation) {
            int size = tLRPC$Photo.sizes.size();
            for (int i = 0; i < size; i++) {
                TLRPC$PhotoSize tLRPC$PhotoSize = tLRPC$Photo.sizes.get(i);
                byte[] fileReference = getFileReference(tLRPC$PhotoSize, tLRPC$InputFileLocation, zArr);
                if (zArr != null && zArr[0]) {
                    tLRPC$InputFileLocationArr[0] = new TLRPC$TL_inputPhotoFileLocation();
                    tLRPC$InputFileLocationArr[0].id = tLRPC$Photo.id;
                    tLRPC$InputFileLocationArr[0].volume_id = tLRPC$InputFileLocation.volume_id;
                    tLRPC$InputFileLocationArr[0].local_id = tLRPC$InputFileLocation.local_id;
                    tLRPC$InputFileLocationArr[0].access_hash = tLRPC$Photo.access_hash;
                    TLRPC$InputFileLocation tLRPC$InputFileLocation2 = tLRPC$InputFileLocationArr[0];
                    byte[] bArr = tLRPC$Photo.file_reference;
                    tLRPC$InputFileLocation2.file_reference = bArr;
                    tLRPC$InputFileLocationArr[0].thumb_size = tLRPC$PhotoSize.type;
                    return bArr;
                }
                if (fileReference != null) {
                    return fileReference;
                }
            }
        }
        return null;
    }

    private byte[] getFileReference(TLRPC$PhotoSize tLRPC$PhotoSize, TLRPC$InputFileLocation tLRPC$InputFileLocation, boolean[] zArr) {
        if (tLRPC$PhotoSize == null || !(tLRPC$InputFileLocation instanceof TLRPC$TL_inputFileLocation)) {
            return null;
        }
        return getFileReference(tLRPC$PhotoSize.location, tLRPC$InputFileLocation, zArr);
    }

    private byte[] getFileReference(TLRPC$FileLocation tLRPC$FileLocation, TLRPC$InputFileLocation tLRPC$InputFileLocation, boolean[] zArr) {
        if (tLRPC$FileLocation == null || !(tLRPC$InputFileLocation instanceof TLRPC$TL_inputFileLocation) || tLRPC$FileLocation.local_id != tLRPC$InputFileLocation.local_id || tLRPC$FileLocation.volume_id != tLRPC$InputFileLocation.volume_id) {
            return null;
        }
        byte[] bArr = tLRPC$FileLocation.file_reference;
        if (bArr == null && zArr != null) {
            zArr[0] = true;
        }
        return bArr;
    }

    private byte[] getFileReference(TLRPC$WebPage tLRPC$WebPage, TLRPC$InputFileLocation tLRPC$InputFileLocation, boolean[] zArr, TLRPC$InputFileLocation[] tLRPC$InputFileLocationArr) {
        byte[] fileReference = getFileReference(tLRPC$WebPage.document, tLRPC$InputFileLocation, zArr, tLRPC$InputFileLocationArr);
        if (fileReference != null) {
            return fileReference;
        }
        byte[] fileReference2 = getFileReference(tLRPC$WebPage.photo, tLRPC$InputFileLocation, zArr, tLRPC$InputFileLocationArr);
        if (fileReference2 != null) {
            return fileReference2;
        }
        if (!tLRPC$WebPage.attributes.isEmpty()) {
            int size = tLRPC$WebPage.attributes.size();
            for (int i = 0; i < size; i++) {
                TLRPC$TL_webPageAttributeTheme tLRPC$TL_webPageAttributeTheme = tLRPC$WebPage.attributes.get(i);
                int size2 = tLRPC$TL_webPageAttributeTheme.documents.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    byte[] fileReference3 = getFileReference(tLRPC$TL_webPageAttributeTheme.documents.get(i2), tLRPC$InputFileLocation, zArr, tLRPC$InputFileLocationArr);
                    if (fileReference3 != null) {
                        return fileReference3;
                    }
                }
            }
        }
        TLRPC$Page tLRPC$Page = tLRPC$WebPage.cached_page;
        if (tLRPC$Page == null) {
            return null;
        }
        int size3 = tLRPC$Page.documents.size();
        for (int i3 = 0; i3 < size3; i3++) {
            byte[] fileReference4 = getFileReference(tLRPC$WebPage.cached_page.documents.get(i3), tLRPC$InputFileLocation, zArr, tLRPC$InputFileLocationArr);
            if (fileReference4 != null) {
                return fileReference4;
            }
        }
        int size4 = tLRPC$WebPage.cached_page.photos.size();
        for (int i4 = 0; i4 < size4; i4++) {
            byte[] fileReference5 = getFileReference(tLRPC$WebPage.cached_page.photos.get(i4), tLRPC$InputFileLocation, zArr, tLRPC$InputFileLocationArr);
            if (fileReference5 != null) {
                return fileReference5;
            }
        }
        return null;
    }

    public static boolean isFileRefError(String str) {
        return "FILEREF_EXPIRED".equals(str) || "FILE_REFERENCE_EXPIRED".equals(str) || "FILE_REFERENCE_EMPTY".equals(str) || (str != null && str.startsWith("FILE_REFERENCE_"));
    }
}
