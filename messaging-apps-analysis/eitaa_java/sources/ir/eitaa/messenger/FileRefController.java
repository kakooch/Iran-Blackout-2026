package ir.eitaa.messenger;

import android.os.SystemClock;
import ir.eitaa.messenger.FileLoadOperation;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$InputFileLocation;
import ir.eitaa.tgnet.TLRPC$InputMedia;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$InputStickeredMedia;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$Page;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$StickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSetCovered;
import ir.eitaa.tgnet.TLRPC$TL_account_getTheme;
import ir.eitaa.tgnet.TLRPC$TL_account_getWallPaper;
import ir.eitaa.tgnet.TLRPC$TL_account_getWallPapers;
import ir.eitaa.tgnet.TLRPC$TL_channel;
import ir.eitaa.tgnet.TLRPC$TL_channels_getChannels;
import ir.eitaa.tgnet.TLRPC$TL_channels_getMessages;
import ir.eitaa.tgnet.TLRPC$TL_chat;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_help_getAppUpdate;
import ir.eitaa.tgnet.TLRPC$TL_inputDocumentFileLocation;
import ir.eitaa.tgnet.TLRPC$TL_inputFileLocation;
import ir.eitaa.tgnet.TLRPC$TL_inputMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_inputMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterChatPhotos;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChannel;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChat;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerPhotoFileLocation;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerUser;
import ir.eitaa.tgnet.TLRPC$TL_inputPhotoFileLocation;
import ir.eitaa.tgnet.TLRPC$TL_inputSingleMedia;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetID;
import ir.eitaa.tgnet.TLRPC$TL_inputStickeredMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_inputStickeredMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_inputTheme;
import ir.eitaa.tgnet.TLRPC$TL_inputWallPaper;
import ir.eitaa.tgnet.TLRPC$TL_messages_editMessage;
import ir.eitaa.tgnet.TLRPC$TL_messages_faveSticker;
import ir.eitaa.tgnet.TLRPC$TL_messages_getAttachedStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_getChats;
import ir.eitaa.tgnet.TLRPC$TL_messages_getFavedStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_getMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_getRecentStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_getSavedGifs;
import ir.eitaa.tgnet.TLRPC$TL_messages_getScheduledMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_getStickerSet;
import ir.eitaa.tgnet.TLRPC$TL_messages_getWebPage;
import ir.eitaa.tgnet.TLRPC$TL_messages_saveGif;
import ir.eitaa.tgnet.TLRPC$TL_messages_saveRecentSticker;
import ir.eitaa.tgnet.TLRPC$TL_messages_search;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendMedia;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendMultiMedia;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.tgnet.TLRPC$TL_photos_getUserPhotos;
import ir.eitaa.tgnet.TLRPC$TL_theme;
import ir.eitaa.tgnet.TLRPC$TL_users_getUsers;
import ir.eitaa.tgnet.TLRPC$TL_wallPaper;
import ir.eitaa.tgnet.TLRPC$TL_webPageAttributeTheme;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.tgnet.TLRPC$WebPage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
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

    static /* synthetic */ void lambda$onUpdateObjectReference$24(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$onUpdateObjectReference$25(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$onUpdateObjectReference$26(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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

        public Waiter(String loc, String parent) {
            this.locationKey = loc;
            this.parentKey = parent;
        }
    }

    public static FileRefController getInstance(int num) {
        FileRefController fileRefController = Instance[num];
        if (fileRefController == null) {
            synchronized (FileRefController.class) {
                fileRefController = Instance[num];
                if (fileRefController == null) {
                    FileRefController[] fileRefControllerArr = Instance;
                    FileRefController fileRefController2 = new FileRefController(num);
                    fileRefControllerArr[num] = fileRefController2;
                    fileRefController = fileRefController2;
                }
            }
        }
        return fileRefController;
    }

    public FileRefController(int instance) {
        super(instance);
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

    public static String getKeyForParentObject(Object parentObject) {
        if (parentObject instanceof MessageObject) {
            MessageObject messageObject = (MessageObject) parentObject;
            return "message" + messageObject.getRealId() + "_" + messageObject.getChannelId() + "_" + messageObject.scheduled;
        }
        if (parentObject instanceof TLRPC$Message) {
            TLRPC$Message tLRPC$Message = (TLRPC$Message) parentObject;
            TLRPC$Peer tLRPC$Peer = tLRPC$Message.peer_id;
            return "message" + tLRPC$Message.id + "_" + (tLRPC$Peer != null ? tLRPC$Peer.channel_id : 0L) + "_" + tLRPC$Message.from_scheduled;
        }
        if (parentObject instanceof TLRPC$WebPage) {
            return "webpage" + ((TLRPC$WebPage) parentObject).id;
        }
        if (parentObject instanceof TLRPC$User) {
            return "user" + ((TLRPC$User) parentObject).id;
        }
        if (parentObject instanceof TLRPC$Chat) {
            return "chat" + ((TLRPC$Chat) parentObject).id;
        }
        if (parentObject instanceof String) {
            return "str" + ((String) parentObject);
        }
        if (parentObject instanceof TLRPC$TL_messages_stickerSet) {
            return "set" + ((TLRPC$TL_messages_stickerSet) parentObject).set.id;
        }
        if (parentObject instanceof TLRPC$StickerSetCovered) {
            return "set" + ((TLRPC$StickerSetCovered) parentObject).set.id;
        }
        if (parentObject instanceof TLRPC$InputStickerSet) {
            return "set" + ((TLRPC$InputStickerSet) parentObject).id;
        }
        if (parentObject instanceof TLRPC$TL_wallPaper) {
            return "wallpaper" + ((TLRPC$TL_wallPaper) parentObject).id;
        }
        if (parentObject instanceof TLRPC$TL_theme) {
            return "theme" + ((TLRPC$TL_theme) parentObject).id;
        }
        if (parentObject == null) {
            return null;
        }
        return "" + parentObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x036b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void requestReference(java.lang.Object r13, java.lang.Object... r14) {
        /*
            Method dump skipped, instructions count: 943
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.FileRefController.requestReference(java.lang.Object, java.lang.Object[]):void");
    }

    private void broadcastWaitersData(ArrayList<Waiter> waiters, TLObject response) {
        int size = waiters.size();
        int i = 0;
        while (i < size) {
            Waiter waiter = waiters.get(i);
            onRequestComplete(waiter.locationKey, waiter.parentKey, response, i == size + (-1), false);
            i++;
        }
        waiters.clear();
    }

    private void requestReferenceFromServer(Object parentObject, final String locationKey, final String parentKey, Object[] args) {
        if (parentObject instanceof MessageObject) {
            MessageObject messageObject = (MessageObject) parentObject;
            long channelId = messageObject.getChannelId();
            if (messageObject.scheduled) {
                TLRPC$TL_messages_getScheduledMessages tLRPC$TL_messages_getScheduledMessages = new TLRPC$TL_messages_getScheduledMessages();
                tLRPC$TL_messages_getScheduledMessages.peer = getMessagesController().getInputPeer(messageObject.getDialogId());
                tLRPC$TL_messages_getScheduledMessages.id.add(Integer.valueOf(messageObject.getRealId()));
                getConnectionsManager().sendRequest(tLRPC$TL_messages_getScheduledMessages, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$d_DApZnNe2P34J9u9UMQ_HqJnes
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$requestReferenceFromServer$0$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            if (channelId != 0) {
                TLRPC$TL_channels_getMessages tLRPC$TL_channels_getMessages = new TLRPC$TL_channels_getMessages();
                tLRPC$TL_channels_getMessages.channel = getMessagesController().getInputChannel(channelId);
                tLRPC$TL_channels_getMessages.id.add(Integer.valueOf(messageObject.getRealId()));
                getConnectionsManager().sendRequest(tLRPC$TL_channels_getMessages, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$w5SpZ7Cw1lWiGq4AqI0H3jZy6cg
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$requestReferenceFromServer$1$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages = new TLRPC$TL_messages_getMessages();
            tLRPC$TL_messages_getMessages.id.add(Integer.valueOf(messageObject.getRealId()));
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getMessages, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$RdFSiykeS9NPzR3oMHEpGeQJf6w
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$2$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (parentObject instanceof TLRPC$TL_wallPaper) {
            TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) parentObject;
            TLRPC$TL_account_getWallPaper tLRPC$TL_account_getWallPaper = new TLRPC$TL_account_getWallPaper();
            TLRPC$TL_inputWallPaper tLRPC$TL_inputWallPaper = new TLRPC$TL_inputWallPaper();
            tLRPC$TL_inputWallPaper.id = tLRPC$TL_wallPaper.id;
            tLRPC$TL_inputWallPaper.access_hash = tLRPC$TL_wallPaper.access_hash;
            tLRPC$TL_account_getWallPaper.wallpaper = tLRPC$TL_inputWallPaper;
            getConnectionsManager().sendRequest(tLRPC$TL_account_getWallPaper, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$Ia46RheEAVxWeMenC_AJD4PvJhM
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$3$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (parentObject instanceof TLRPC$TL_theme) {
            TLRPC$TL_theme tLRPC$TL_theme = (TLRPC$TL_theme) parentObject;
            TLRPC$TL_account_getTheme tLRPC$TL_account_getTheme = new TLRPC$TL_account_getTheme();
            TLRPC$TL_inputTheme tLRPC$TL_inputTheme = new TLRPC$TL_inputTheme();
            tLRPC$TL_inputTheme.id = tLRPC$TL_theme.id;
            tLRPC$TL_inputTheme.access_hash = tLRPC$TL_theme.access_hash;
            tLRPC$TL_account_getTheme.theme = tLRPC$TL_inputTheme;
            tLRPC$TL_account_getTheme.format = "android";
            getConnectionsManager().sendRequest(tLRPC$TL_account_getTheme, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$0dK0XOMdPPJMMmW5ad4ktzqeOzs
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$4$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (parentObject instanceof TLRPC$WebPage) {
            TLRPC$TL_messages_getWebPage tLRPC$TL_messages_getWebPage = new TLRPC$TL_messages_getWebPage();
            tLRPC$TL_messages_getWebPage.url = ((TLRPC$WebPage) parentObject).url;
            tLRPC$TL_messages_getWebPage.hash = 0;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getWebPage, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$OneBAfP_xrF8eWrEZjvHP2LgNtY
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$5$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (parentObject instanceof TLRPC$User) {
            TLRPC$TL_users_getUsers tLRPC$TL_users_getUsers = new TLRPC$TL_users_getUsers();
            tLRPC$TL_users_getUsers.id.add(getMessagesController().getInputUser((TLRPC$User) parentObject));
            getConnectionsManager().sendRequest(tLRPC$TL_users_getUsers, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$A_MmFHqURlTM_NSjc2MKUypaPWA
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$6$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (parentObject instanceof TLRPC$Chat) {
            TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) parentObject;
            if (tLRPC$Chat instanceof TLRPC$TL_chat) {
                TLRPC$TL_messages_getChats tLRPC$TL_messages_getChats = new TLRPC$TL_messages_getChats();
                tLRPC$TL_messages_getChats.id.add(Long.valueOf(tLRPC$Chat.id));
                getConnectionsManager().sendRequest(tLRPC$TL_messages_getChats, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$tFFQeUMxGHjcsbRrt-NLn0oPYJ4
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$requestReferenceFromServer$7$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            } else {
                if (tLRPC$Chat instanceof TLRPC$TL_channel) {
                    TLRPC$TL_channels_getChannels tLRPC$TL_channels_getChannels = new TLRPC$TL_channels_getChannels();
                    tLRPC$TL_channels_getChannels.id.add(MessagesController.getInputChannel(tLRPC$Chat));
                    getConnectionsManager().sendRequest(tLRPC$TL_channels_getChannels, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$I4y7TPRJvRMzc7lyxMQVLPlez5E
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$requestReferenceFromServer$8$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                        }
                    });
                    return;
                }
                return;
            }
        }
        if (parentObject instanceof String) {
            String str = (String) parentObject;
            if ("wallpaper".equals(str)) {
                if (this.wallpaperWaiters.isEmpty()) {
                    getConnectionsManager().sendRequest(new TLRPC$TL_account_getWallPapers(), new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$SIdC_wwrQfDsaM-yfrHIizhQznc
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$requestReferenceFromServer$9$FileRefController(tLObject, tLRPC$TL_error);
                        }
                    });
                }
                this.wallpaperWaiters.add(new Waiter(locationKey, parentKey));
                return;
            }
            if (str.startsWith("gif")) {
                if (this.savedGifsWaiters.isEmpty()) {
                    getConnectionsManager().sendRequest(new TLRPC$TL_messages_getSavedGifs(), new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$RFJwG-dBEzs0hMWpXN0RRM9aJGc
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$requestReferenceFromServer$10$FileRefController(tLObject, tLRPC$TL_error);
                        }
                    });
                }
                this.savedGifsWaiters.add(new Waiter(locationKey, parentKey));
                return;
            }
            if ("recent".equals(str)) {
                if (this.recentStickersWaiter.isEmpty()) {
                    getConnectionsManager().sendRequest(new TLRPC$TL_messages_getRecentStickers(), new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$MJE5Du0PwScS_bh5Kg7CcKPyRvI
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$requestReferenceFromServer$11$FileRefController(tLObject, tLRPC$TL_error);
                        }
                    });
                }
                this.recentStickersWaiter.add(new Waiter(locationKey, parentKey));
                return;
            }
            if ("fav".equals(str)) {
                if (this.favStickersWaiter.isEmpty()) {
                    getConnectionsManager().sendRequest(new TLRPC$TL_messages_getFavedStickers(), new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$tcO0EMeRpApTJxSQ0dPUC-xwh3Q
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$requestReferenceFromServer$12$FileRefController(tLObject, tLRPC$TL_error);
                        }
                    });
                }
                this.favStickersWaiter.add(new Waiter(locationKey, parentKey));
                return;
            }
            if ("update".equals(str)) {
                TLRPC$TL_help_getAppUpdate tLRPC$TL_help_getAppUpdate = new TLRPC$TL_help_getAppUpdate();
                try {
                    tLRPC$TL_help_getAppUpdate.source = ApplicationLoader.applicationContext.getPackageManager().getInstallerPackageName(ApplicationLoader.applicationContext.getPackageName());
                } catch (Exception unused) {
                }
                if (tLRPC$TL_help_getAppUpdate.source == null) {
                    tLRPC$TL_help_getAppUpdate.source = "";
                }
                getConnectionsManager().sendRequest(tLRPC$TL_help_getAppUpdate, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$1YounDj83QSIlCkSGbAQsrWirbs
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$requestReferenceFromServer$13$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            if (str.startsWith("avatar_")) {
                long jLongValue = Utilities.parseLong(str).longValue();
                if (jLongValue > 0) {
                    TLRPC$TL_photos_getUserPhotos tLRPC$TL_photos_getUserPhotos = new TLRPC$TL_photos_getUserPhotos();
                    tLRPC$TL_photos_getUserPhotos.limit = 80;
                    tLRPC$TL_photos_getUserPhotos.offset = 0;
                    tLRPC$TL_photos_getUserPhotos.max_id = 0L;
                    tLRPC$TL_photos_getUserPhotos.user_id = getMessagesController().getInputUser(jLongValue);
                    getConnectionsManager().sendRequest(tLRPC$TL_photos_getUserPhotos, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$ZHWgZAa7t6mOypUp5C3CfCfH0f4
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$requestReferenceFromServer$14$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                        }
                    });
                    return;
                }
                TLRPC$TL_messages_search tLRPC$TL_messages_search = new TLRPC$TL_messages_search();
                tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterChatPhotos();
                tLRPC$TL_messages_search.limit = 80;
                tLRPC$TL_messages_search.offset_id = 0;
                tLRPC$TL_messages_search.q = "";
                tLRPC$TL_messages_search.peer = getMessagesController().getInputPeer(jLongValue);
                getConnectionsManager().sendRequest(tLRPC$TL_messages_search, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$eRamzqvW2KxzGba5HViNIrHO2Qw
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$requestReferenceFromServer$15$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            if (str.startsWith("sent_")) {
                String[] strArrSplit = str.split("_");
                if (strArrSplit.length == 3) {
                    long jLongValue2 = Utilities.parseLong(strArrSplit[1]).longValue();
                    if (jLongValue2 != 0) {
                        TLRPC$TL_channels_getMessages tLRPC$TL_channels_getMessages2 = new TLRPC$TL_channels_getMessages();
                        tLRPC$TL_channels_getMessages2.channel = getMessagesController().getInputChannel(jLongValue2);
                        tLRPC$TL_channels_getMessages2.id.add(Utilities.parseInt(strArrSplit[2]));
                        getConnectionsManager().sendRequest(tLRPC$TL_channels_getMessages2, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$gpw9QPdiaKa_rTTujWipIkAjuCU
                            @Override // ir.eitaa.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                this.f$0.lambda$requestReferenceFromServer$16$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                            }
                        });
                        return;
                    }
                    TLRPC$TL_messages_getMessages tLRPC$TL_messages_getMessages2 = new TLRPC$TL_messages_getMessages();
                    tLRPC$TL_messages_getMessages2.id.add(Utilities.parseInt(strArrSplit[2]));
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_getMessages2, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$Xdz0py7DivRaZ-FXYI8KZPPgq94
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$requestReferenceFromServer$17$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                        }
                    });
                    return;
                }
                sendErrorToObject(args, 0);
                return;
            }
            sendErrorToObject(args, 0);
            return;
        }
        if (parentObject instanceof TLRPC$TL_messages_stickerSet) {
            TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet = new TLRPC$TL_messages_getStickerSet();
            TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
            tLRPC$TL_messages_getStickerSet.stickerset = tLRPC$TL_inputStickerSetID;
            TLRPC$StickerSet tLRPC$StickerSet = ((TLRPC$TL_messages_stickerSet) parentObject).set;
            tLRPC$TL_inputStickerSetID.id = tLRPC$StickerSet.id;
            tLRPC$TL_inputStickerSetID.access_hash = tLRPC$StickerSet.access_hash;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$_xPagObHuk99DsYtn4nbt-FOZqc
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$18$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (parentObject instanceof TLRPC$StickerSetCovered) {
            TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet2 = new TLRPC$TL_messages_getStickerSet();
            TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID2 = new TLRPC$TL_inputStickerSetID();
            tLRPC$TL_messages_getStickerSet2.stickerset = tLRPC$TL_inputStickerSetID2;
            TLRPC$StickerSet tLRPC$StickerSet2 = ((TLRPC$StickerSetCovered) parentObject).set;
            tLRPC$TL_inputStickerSetID2.id = tLRPC$StickerSet2.id;
            tLRPC$TL_inputStickerSetID2.access_hash = tLRPC$StickerSet2.access_hash;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet2, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$yn3cq3hGLjk0t4Kaf-pHQWCzRj8
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$19$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (parentObject instanceof TLRPC$InputStickerSet) {
            TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet3 = new TLRPC$TL_messages_getStickerSet();
            tLRPC$TL_messages_getStickerSet3.stickerset = (TLRPC$InputStickerSet) parentObject;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet3, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$XO7-eo77QGyfRGkIprkY3kSIIO0
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$requestReferenceFromServer$20$FileRefController(locationKey, parentKey, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        sendErrorToObject(args, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$0$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$1$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$2$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$3$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$4$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$5$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$6$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$7$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$8$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$9$FileRefController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        broadcastWaitersData(this.wallpaperWaiters, tLObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$10$FileRefController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        broadcastWaitersData(this.savedGifsWaiters, tLObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$11$FileRefController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        broadcastWaitersData(this.recentStickersWaiter, tLObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$12$FileRefController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        broadcastWaitersData(this.favStickersWaiter, tLObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$13$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$14$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$15$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$16$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$17$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$18$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$19$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestReferenceFromServer$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestReferenceFromServer$20$FileRefController(String str, String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        onRequestComplete(str, str2, tLObject, true, false);
    }

    private boolean isSameReference(byte[] oldRef, byte[] newRef) {
        return Arrays.equals(oldRef, newRef);
    }

    private boolean onUpdateObjectReference(final Requester requester, byte[] file_reference, TLRPC$InputFileLocation locationReplacement, boolean fromCache) {
        if (BuildVars.DEBUG_VERSION) {
            FileLog.d("fileref updated for " + requester.args[0] + " " + requester.locationKey);
        }
        if (requester.args[0] instanceof TLRPC$TL_inputSingleMedia) {
            final TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia = (TLRPC$TL_messages_sendMultiMedia) requester.args[1];
            final Object[] objArr = this.multiMediaCache.get(tLRPC$TL_messages_sendMultiMedia);
            if (objArr == null) {
                return true;
            }
            TLRPC$TL_inputSingleMedia tLRPC$TL_inputSingleMedia = (TLRPC$TL_inputSingleMedia) requester.args[0];
            TLRPC$InputMedia tLRPC$InputMedia = tLRPC$TL_inputSingleMedia.media;
            if (tLRPC$InputMedia instanceof TLRPC$TL_inputMediaDocument) {
                TLRPC$TL_inputMediaDocument tLRPC$TL_inputMediaDocument = (TLRPC$TL_inputMediaDocument) tLRPC$InputMedia;
                if (fromCache && isSameReference(tLRPC$TL_inputMediaDocument.id.file_reference, file_reference)) {
                    return false;
                }
                tLRPC$TL_inputMediaDocument.id.file_reference = file_reference;
            } else if (tLRPC$InputMedia instanceof TLRPC$TL_inputMediaPhoto) {
                TLRPC$TL_inputMediaPhoto tLRPC$TL_inputMediaPhoto = (TLRPC$TL_inputMediaPhoto) tLRPC$InputMedia;
                if (fromCache && isSameReference(tLRPC$TL_inputMediaPhoto.id.file_reference, file_reference)) {
                    return false;
                }
                tLRPC$TL_inputMediaPhoto.id.file_reference = file_reference;
            }
            int iIndexOf = tLRPC$TL_messages_sendMultiMedia.multi_media.indexOf(tLRPC$TL_inputSingleMedia);
            if (iIndexOf < 0) {
                return true;
            }
            ArrayList arrayList = (ArrayList) objArr[3];
            arrayList.set(iIndexOf, null);
            boolean z = true;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) != null) {
                    z = false;
                }
            }
            if (z) {
                this.multiMediaCache.remove(tLRPC$TL_messages_sendMultiMedia);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$xK4jITbg4vi0Puw8zIjYZ87umYs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onUpdateObjectReference$21$FileRefController(tLRPC$TL_messages_sendMultiMedia, objArr);
                    }
                });
            }
        } else if (!(requester.args[0] instanceof TLRPC$TL_messages_sendMedia)) {
            if (!(requester.args[0] instanceof TLRPC$TL_messages_editMessage)) {
                if (requester.args[0] instanceof TLRPC$TL_messages_saveGif) {
                    TLRPC$TL_messages_saveGif tLRPC$TL_messages_saveGif = (TLRPC$TL_messages_saveGif) requester.args[0];
                    if (fromCache && isSameReference(tLRPC$TL_messages_saveGif.id.file_reference, file_reference)) {
                        return false;
                    }
                    tLRPC$TL_messages_saveGif.id.file_reference = file_reference;
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_saveGif, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$qzcKCnEdZJKEfydorWHUMcQtCRo
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            FileRefController.lambda$onUpdateObjectReference$24(tLObject, tLRPC$TL_error);
                        }
                    });
                } else if (requester.args[0] instanceof TLRPC$TL_messages_saveRecentSticker) {
                    TLRPC$TL_messages_saveRecentSticker tLRPC$TL_messages_saveRecentSticker = (TLRPC$TL_messages_saveRecentSticker) requester.args[0];
                    if (fromCache && isSameReference(tLRPC$TL_messages_saveRecentSticker.id.file_reference, file_reference)) {
                        return false;
                    }
                    tLRPC$TL_messages_saveRecentSticker.id.file_reference = file_reference;
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_saveRecentSticker, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$Uo0y9cNbGee_iKkZrvngMjRZn6s
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            FileRefController.lambda$onUpdateObjectReference$25(tLObject, tLRPC$TL_error);
                        }
                    });
                } else if (requester.args[0] instanceof TLRPC$TL_messages_faveSticker) {
                    TLRPC$TL_messages_faveSticker tLRPC$TL_messages_faveSticker = (TLRPC$TL_messages_faveSticker) requester.args[0];
                    if (fromCache && isSameReference(tLRPC$TL_messages_faveSticker.id.file_reference, file_reference)) {
                        return false;
                    }
                    tLRPC$TL_messages_faveSticker.id.file_reference = file_reference;
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_faveSticker, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$MPSkHHmBZb81yw8yMgA8w50Qa5E
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            FileRefController.lambda$onUpdateObjectReference$26(tLObject, tLRPC$TL_error);
                        }
                    });
                } else if (requester.args[0] instanceof TLRPC$TL_messages_getAttachedStickers) {
                    TLRPC$TL_messages_getAttachedStickers tLRPC$TL_messages_getAttachedStickers = (TLRPC$TL_messages_getAttachedStickers) requester.args[0];
                    TLRPC$InputStickeredMedia tLRPC$InputStickeredMedia = tLRPC$TL_messages_getAttachedStickers.media;
                    if (tLRPC$InputStickeredMedia instanceof TLRPC$TL_inputStickeredMediaDocument) {
                        TLRPC$TL_inputStickeredMediaDocument tLRPC$TL_inputStickeredMediaDocument = (TLRPC$TL_inputStickeredMediaDocument) tLRPC$InputStickeredMedia;
                        if (fromCache && isSameReference(tLRPC$TL_inputStickeredMediaDocument.id.file_reference, file_reference)) {
                            return false;
                        }
                        tLRPC$TL_inputStickeredMediaDocument.id.file_reference = file_reference;
                    } else if (tLRPC$InputStickeredMedia instanceof TLRPC$TL_inputStickeredMediaPhoto) {
                        TLRPC$TL_inputStickeredMediaPhoto tLRPC$TL_inputStickeredMediaPhoto = (TLRPC$TL_inputStickeredMediaPhoto) tLRPC$InputStickeredMedia;
                        if (fromCache && isSameReference(tLRPC$TL_inputStickeredMediaPhoto.id.file_reference, file_reference)) {
                            return false;
                        }
                        tLRPC$TL_inputStickeredMediaPhoto.id.file_reference = file_reference;
                    }
                    getConnectionsManager().sendRequest(tLRPC$TL_messages_getAttachedStickers, (RequestDelegate) requester.args[1]);
                } else if (requester.args[1] instanceof FileLoadOperation) {
                    FileLoadOperation fileLoadOperation = (FileLoadOperation) requester.args[1];
                    if (locationReplacement == null) {
                        if (fromCache && isSameReference(requester.location.file_reference, file_reference)) {
                            return false;
                        }
                        requester.location.file_reference = file_reference;
                    } else {
                        if (fromCache && isSameReference(fileLoadOperation.location.file_reference, locationReplacement.file_reference)) {
                            return false;
                        }
                        fileLoadOperation.location = locationReplacement;
                    }
                    fileLoadOperation.requestingReference = false;
                    fileLoadOperation.startDownloadRequest();
                }
            } else {
                TLRPC$InputMedia tLRPC$InputMedia2 = ((TLRPC$TL_messages_editMessage) requester.args[0]).media;
                if (tLRPC$InputMedia2 instanceof TLRPC$TL_inputMediaDocument) {
                    TLRPC$TL_inputMediaDocument tLRPC$TL_inputMediaDocument2 = (TLRPC$TL_inputMediaDocument) tLRPC$InputMedia2;
                    if (fromCache && isSameReference(tLRPC$TL_inputMediaDocument2.id.file_reference, file_reference)) {
                        return false;
                    }
                    tLRPC$TL_inputMediaDocument2.id.file_reference = file_reference;
                } else if (tLRPC$InputMedia2 instanceof TLRPC$TL_inputMediaPhoto) {
                    TLRPC$TL_inputMediaPhoto tLRPC$TL_inputMediaPhoto2 = (TLRPC$TL_inputMediaPhoto) tLRPC$InputMedia2;
                    if (fromCache && isSameReference(tLRPC$TL_inputMediaPhoto2.id.file_reference, file_reference)) {
                        return false;
                    }
                    tLRPC$TL_inputMediaPhoto2.id.file_reference = file_reference;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$vBSn9kUJUJg5zlAYwTwZb0IHEKs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onUpdateObjectReference$23$FileRefController(requester);
                    }
                });
            }
        } else {
            TLRPC$InputMedia tLRPC$InputMedia3 = ((TLRPC$TL_messages_sendMedia) requester.args[0]).media;
            if (tLRPC$InputMedia3 instanceof TLRPC$TL_inputMediaDocument) {
                TLRPC$TL_inputMediaDocument tLRPC$TL_inputMediaDocument3 = (TLRPC$TL_inputMediaDocument) tLRPC$InputMedia3;
                if (fromCache && isSameReference(tLRPC$TL_inputMediaDocument3.id.file_reference, file_reference)) {
                    return false;
                }
                tLRPC$TL_inputMediaDocument3.id.file_reference = file_reference;
            } else if (tLRPC$InputMedia3 instanceof TLRPC$TL_inputMediaPhoto) {
                TLRPC$TL_inputMediaPhoto tLRPC$TL_inputMediaPhoto3 = (TLRPC$TL_inputMediaPhoto) tLRPC$InputMedia3;
                if (fromCache && isSameReference(tLRPC$TL_inputMediaPhoto3.id.file_reference, file_reference)) {
                    return false;
                }
                tLRPC$TL_inputMediaPhoto3.id.file_reference = file_reference;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$fIkHdt73Q7COv12vY0EgpKvC0Mc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onUpdateObjectReference$22$FileRefController(requester);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onUpdateObjectReference$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onUpdateObjectReference$21$FileRefController(TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia, Object[] objArr) {
        getSendMessagesHelper().performSendMessageRequestMulti(tLRPC$TL_messages_sendMultiMedia, (ArrayList) objArr[1], (ArrayList) objArr[2], null, (SendMessagesHelper.DelayedMessage) objArr[4], ((Boolean) objArr[5]).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onUpdateObjectReference$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onUpdateObjectReference$22$FileRefController(Requester requester) {
        getSendMessagesHelper().performSendMessageRequest((TLObject) requester.args[0], (MessageObject) requester.args[1], (String) requester.args[2], (SendMessagesHelper.DelayedMessage) requester.args[3], ((Boolean) requester.args[4]).booleanValue(), (SendMessagesHelper.DelayedMessage) requester.args[5], null, null, ((Boolean) requester.args[6]).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onUpdateObjectReference$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onUpdateObjectReference$23$FileRefController(Requester requester) {
        getSendMessagesHelper().performSendMessageRequest((TLObject) requester.args[0], (MessageObject) requester.args[1], (String) requester.args[2], (SendMessagesHelper.DelayedMessage) requester.args[3], ((Boolean) requester.args[4]).booleanValue(), (SendMessagesHelper.DelayedMessage) requester.args[5], null, null, ((Boolean) requester.args[6]).booleanValue());
    }

    private void sendErrorToObject(final Object[] args, int reason) {
        if (args[0] instanceof TLRPC$TL_inputSingleMedia) {
            final TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia = (TLRPC$TL_messages_sendMultiMedia) args[1];
            final Object[] objArr = this.multiMediaCache.get(tLRPC$TL_messages_sendMultiMedia);
            if (objArr != null) {
                this.multiMediaCache.remove(tLRPC$TL_messages_sendMultiMedia);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$ywxcakmUbX-nJt6supSZZbMoTcg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$sendErrorToObject$27$FileRefController(tLRPC$TL_messages_sendMultiMedia, objArr);
                    }
                });
                return;
            }
            return;
        }
        if ((args[0] instanceof TLRPC$TL_messages_sendMedia) || (args[0] instanceof TLRPC$TL_messages_editMessage)) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileRefController$2oGnc8WXE9oDcIntmdpChtxZCg4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendErrorToObject$28$FileRefController(args);
                }
            });
            return;
        }
        if (args[0] instanceof TLRPC$TL_messages_saveGif) {
            return;
        }
        if (args[0] instanceof TLRPC$TL_messages_saveRecentSticker) {
            return;
        }
        if (args[0] instanceof TLRPC$TL_messages_faveSticker) {
            return;
        }
        if (args[0] instanceof TLRPC$TL_messages_getAttachedStickers) {
            getConnectionsManager().sendRequest((TLRPC$TL_messages_getAttachedStickers) args[0], (RequestDelegate) args[1]);
            return;
        }
        if (reason == 0) {
            TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "not found parent object to request reference";
            tLRPC$TL_error.code = 400;
            if (args[1] instanceof FileLoadOperation) {
                FileLoadOperation fileLoadOperation = (FileLoadOperation) args[1];
                fileLoadOperation.requestingReference = false;
                fileLoadOperation.processRequestResult((FileLoadOperation.RequestInfo) args[2], tLRPC$TL_error);
                return;
            }
            return;
        }
        if (reason == 1 && (args[1] instanceof FileLoadOperation)) {
            FileLoadOperation fileLoadOperation2 = (FileLoadOperation) args[1];
            fileLoadOperation2.requestingReference = false;
            fileLoadOperation2.onFail(false, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendErrorToObject$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendErrorToObject$27$FileRefController(TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia, Object[] objArr) {
        getSendMessagesHelper().performSendMessageRequestMulti(tLRPC$TL_messages_sendMultiMedia, (ArrayList) objArr[1], (ArrayList) objArr[2], null, (SendMessagesHelper.DelayedMessage) objArr[4], ((Boolean) objArr[5]).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendErrorToObject$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendErrorToObject$28$FileRefController(Object[] objArr) {
        getSendMessagesHelper().performSendMessageRequest((TLObject) objArr[0], (MessageObject) objArr[1], (String) objArr[2], (SendMessagesHelper.DelayedMessage) objArr[3], ((Boolean) objArr[4]).booleanValue(), (SendMessagesHelper.DelayedMessage) objArr[5], null, null, ((Boolean) objArr[6]).booleanValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:207:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x013d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014e A[LOOP:2: B:56:0x00d2->B:81:0x014e, LOOP_END] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean onRequestComplete(java.lang.String r28, java.lang.String r29, ir.eitaa.tgnet.TLObject r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 1103
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.FileRefController.onRequestComplete(java.lang.String, java.lang.String, ir.eitaa.tgnet.TLObject, boolean, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onRequestComplete$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onRequestComplete$30$FileRefController(TLRPC$User tLRPC$User) {
        getMessagesController().putUser(tLRPC$User, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onRequestComplete$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onRequestComplete$31$FileRefController(TLRPC$Chat tLRPC$Chat) {
        getMessagesController().putChat(tLRPC$Chat, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onRequestComplete$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onRequestComplete$32$FileRefController(TLRPC$Chat tLRPC$Chat) {
        getMessagesController().putChat(tLRPC$Chat, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onRequestComplete$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onRequestComplete$33$FileRefController(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
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

    private CachedResult getCachedResponse(String key) {
        CachedResult cachedResult = this.responseCache.get(key);
        if (cachedResult == null || Math.abs(SystemClock.elapsedRealtime() - cachedResult.firstQueryTime) < 600000) {
            return cachedResult;
        }
        this.responseCache.remove(key);
        return null;
    }

    private void putReponseToCache(String key, TLObject response) {
        CachedResult cachedResult = this.responseCache.get(key);
        if (cachedResult == null) {
            cachedResult = new CachedResult();
            cachedResult.response = response;
            cachedResult.firstQueryTime = SystemClock.uptimeMillis();
            this.responseCache.put(key, cachedResult);
        }
        cachedResult.lastQueryTime = SystemClock.uptimeMillis();
    }

    private byte[] getFileReference(TLRPC$Document document, TLRPC$InputFileLocation location, boolean[] needReplacement, TLRPC$InputFileLocation[] replacement) {
        if (document != null && location != null) {
            if (!(location instanceof TLRPC$TL_inputDocumentFileLocation)) {
                int size = document.thumbs.size();
                for (int i = 0; i < size; i++) {
                    TLRPC$PhotoSize tLRPC$PhotoSize = document.thumbs.get(i);
                    byte[] fileReference = getFileReference(tLRPC$PhotoSize, location, needReplacement);
                    if (needReplacement != null && needReplacement[0]) {
                        replacement[0] = new TLRPC$TL_inputDocumentFileLocation();
                        replacement[0].id = document.id;
                        replacement[0].volume_id = location.volume_id;
                        replacement[0].local_id = location.local_id;
                        replacement[0].access_hash = document.access_hash;
                        TLRPC$InputFileLocation tLRPC$InputFileLocation = replacement[0];
                        byte[] bArr = document.file_reference;
                        tLRPC$InputFileLocation.file_reference = bArr;
                        replacement[0].thumb_size = tLRPC$PhotoSize.type;
                        return bArr;
                    }
                    if (fileReference != null) {
                        return fileReference;
                    }
                }
            } else if (document.id == location.id) {
                return document.file_reference;
            }
        }
        return null;
    }

    private boolean getPeerReferenceReplacement(TLRPC$User user, TLRPC$Chat chat, boolean big, TLRPC$InputFileLocation location, TLRPC$InputFileLocation[] replacement, boolean[] needReplacement) {
        TLRPC$InputPeer tLRPC$TL_inputPeerChat;
        TLRPC$InputPeer tLRPC$TL_inputPeerUser;
        if (needReplacement == null || !needReplacement[0]) {
            return false;
        }
        TLRPC$TL_inputPeerPhotoFileLocation tLRPC$TL_inputPeerPhotoFileLocation = new TLRPC$TL_inputPeerPhotoFileLocation();
        long j = location.volume_id;
        tLRPC$TL_inputPeerPhotoFileLocation.id = j;
        tLRPC$TL_inputPeerPhotoFileLocation.volume_id = j;
        tLRPC$TL_inputPeerPhotoFileLocation.local_id = location.local_id;
        tLRPC$TL_inputPeerPhotoFileLocation.big = big;
        if (user != null) {
            tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
            tLRPC$TL_inputPeerUser.user_id = user.id;
            tLRPC$TL_inputPeerUser.access_hash = user.access_hash;
            tLRPC$TL_inputPeerPhotoFileLocation.photo_id = user.photo.photo_id;
        } else {
            if (ChatObject.isChannel(chat)) {
                tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChannel();
                tLRPC$TL_inputPeerChat.channel_id = chat.id;
                tLRPC$TL_inputPeerChat.access_hash = chat.access_hash;
            } else {
                tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
                tLRPC$TL_inputPeerChat.chat_id = chat.id;
            }
            tLRPC$TL_inputPeerPhotoFileLocation.photo_id = chat.photo.photo_id;
            tLRPC$TL_inputPeerUser = tLRPC$TL_inputPeerChat;
        }
        tLRPC$TL_inputPeerPhotoFileLocation.peer = tLRPC$TL_inputPeerUser;
        replacement[0] = tLRPC$TL_inputPeerPhotoFileLocation;
        return true;
    }

    private byte[] getFileReference(TLRPC$User user, TLRPC$InputFileLocation location, boolean[] needReplacement, TLRPC$InputFileLocation[] replacement) {
        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto;
        if (user == null || (tLRPC$UserProfilePhoto = user.photo) == null || !(location instanceof TLRPC$TL_inputFileLocation)) {
            return null;
        }
        byte[] fileReference = getFileReference(tLRPC$UserProfilePhoto.photo_small, location, needReplacement);
        if (getPeerReferenceReplacement(user, null, false, location, replacement, needReplacement)) {
            return new byte[0];
        }
        if (fileReference == null) {
            fileReference = getFileReference(user.photo.photo_big, location, needReplacement);
            if (getPeerReferenceReplacement(user, null, true, location, replacement, needReplacement)) {
                return new byte[0];
            }
        }
        return fileReference;
    }

    private byte[] getFileReference(TLRPC$Chat chat, TLRPC$InputFileLocation location, boolean[] needReplacement, TLRPC$InputFileLocation[] replacement) {
        TLRPC$ChatPhoto tLRPC$ChatPhoto;
        byte[] fileReference = null;
        if (chat != null && (tLRPC$ChatPhoto = chat.photo) != null && ((location instanceof TLRPC$TL_inputFileLocation) || (location instanceof TLRPC$TL_inputPeerPhotoFileLocation))) {
            if (location instanceof TLRPC$TL_inputPeerPhotoFileLocation) {
                needReplacement[0] = true;
                if (getPeerReferenceReplacement(null, chat, false, location, replacement, needReplacement)) {
                    return new byte[0];
                }
                return null;
            }
            fileReference = getFileReference(tLRPC$ChatPhoto.photo_small, location, needReplacement);
            if (getPeerReferenceReplacement(null, chat, false, location, replacement, needReplacement)) {
                return new byte[0];
            }
            if (fileReference == null) {
                fileReference = getFileReference(chat.photo.photo_big, location, needReplacement);
                if (getPeerReferenceReplacement(null, chat, true, location, replacement, needReplacement)) {
                    return new byte[0];
                }
            }
        }
        return fileReference;
    }

    private byte[] getFileReference(TLRPC$Photo photo, TLRPC$InputFileLocation location, boolean[] needReplacement, TLRPC$InputFileLocation[] replacement) {
        if (photo == null) {
            return null;
        }
        if (location instanceof TLRPC$TL_inputPhotoFileLocation) {
            if (photo.id == location.id) {
                return photo.file_reference;
            }
            return null;
        }
        if (location instanceof TLRPC$TL_inputFileLocation) {
            int size = photo.sizes.size();
            for (int i = 0; i < size; i++) {
                TLRPC$PhotoSize tLRPC$PhotoSize = photo.sizes.get(i);
                byte[] fileReference = getFileReference(tLRPC$PhotoSize, location, needReplacement);
                if (needReplacement != null && needReplacement[0]) {
                    replacement[0] = new TLRPC$TL_inputPhotoFileLocation();
                    replacement[0].id = photo.id;
                    replacement[0].volume_id = location.volume_id;
                    replacement[0].local_id = location.local_id;
                    replacement[0].access_hash = photo.access_hash;
                    TLRPC$InputFileLocation tLRPC$InputFileLocation = replacement[0];
                    byte[] bArr = photo.file_reference;
                    tLRPC$InputFileLocation.file_reference = bArr;
                    replacement[0].thumb_size = tLRPC$PhotoSize.type;
                    return bArr;
                }
                if (fileReference != null) {
                    return fileReference;
                }
            }
        }
        return null;
    }

    private byte[] getFileReference(TLRPC$PhotoSize photoSize, TLRPC$InputFileLocation location, boolean[] needReplacement) {
        if (photoSize == null || !(location instanceof TLRPC$TL_inputFileLocation)) {
            return null;
        }
        return getFileReference(photoSize.location, location, needReplacement);
    }

    private byte[] getFileReference(TLRPC$FileLocation fileLocation, TLRPC$InputFileLocation location, boolean[] needReplacement) {
        if (fileLocation == null || !(location instanceof TLRPC$TL_inputFileLocation) || fileLocation.local_id != location.local_id || fileLocation.volume_id != location.volume_id) {
            return null;
        }
        byte[] bArr = fileLocation.file_reference;
        if (bArr == null && needReplacement != null) {
            needReplacement[0] = true;
        }
        return bArr;
    }

    private byte[] getFileReference(TLRPC$WebPage webpage, TLRPC$InputFileLocation location, boolean[] needReplacement, TLRPC$InputFileLocation[] replacement) {
        byte[] fileReference = getFileReference(webpage.document, location, needReplacement, replacement);
        if (fileReference != null) {
            return fileReference;
        }
        byte[] fileReference2 = getFileReference(webpage.photo, location, needReplacement, replacement);
        if (fileReference2 != null) {
            return fileReference2;
        }
        if (!webpage.attributes.isEmpty()) {
            int size = webpage.attributes.size();
            for (int i = 0; i < size; i++) {
                TLRPC$TL_webPageAttributeTheme tLRPC$TL_webPageAttributeTheme = webpage.attributes.get(i);
                int size2 = tLRPC$TL_webPageAttributeTheme.documents.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    byte[] fileReference3 = getFileReference(tLRPC$TL_webPageAttributeTheme.documents.get(i2), location, needReplacement, replacement);
                    if (fileReference3 != null) {
                        return fileReference3;
                    }
                }
            }
        }
        TLRPC$Page tLRPC$Page = webpage.cached_page;
        if (tLRPC$Page == null) {
            return null;
        }
        int size3 = tLRPC$Page.documents.size();
        for (int i3 = 0; i3 < size3; i3++) {
            byte[] fileReference4 = getFileReference(webpage.cached_page.documents.get(i3), location, needReplacement, replacement);
            if (fileReference4 != null) {
                return fileReference4;
            }
        }
        int size4 = webpage.cached_page.photos.size();
        for (int i4 = 0; i4 < size4; i4++) {
            byte[] fileReference5 = getFileReference(webpage.cached_page.photos.get(i4), location, needReplacement, replacement);
            if (fileReference5 != null) {
                return fileReference5;
            }
        }
        return null;
    }

    public static boolean isFileRefError(String error) {
        return "FILEREF_EXPIRED".equals(error) || "FILE_REFERENCE_EXPIRED".equals(error) || "FILE_REFERENCE_EMPTY".equals(error) || (error != null && error.startsWith("FILE_REFERENCE_"));
    }
}
