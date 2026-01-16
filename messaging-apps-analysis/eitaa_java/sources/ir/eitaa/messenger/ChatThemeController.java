package ir.eitaa.messenger;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.Pair;
import ir.eitaa.messenger.NotificationBadge;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.ResultCallback;
import ir.eitaa.tgnet.SerializedData;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_account_getChatThemes;
import ir.eitaa.tgnet.TLRPC$TL_chatTheme;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messages_setChatTheme;
import ir.eitaa.ui.ActionBar.ChatTheme;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ChatThemeController extends BaseController {
    private static List<ChatTheme> allChatThemes = null;
    private static volatile long lastReloadTimeMs = 0;
    private static final long reloadTimeoutMs = 7200000;
    private static volatile int themesHash;
    private final LongSparseArray<String> dialogEmoticonsMap;
    private static volatile DispatchQueue chatThemeQueue = new DispatchQueue("stageQueue");
    private static final HashMap<Long, Bitmap> themeIdWallpaperMap = new HashMap<>();
    private static final HashMap<Long, Bitmap> themeIdWallpaperThumbMap = new HashMap<>();
    private static final ChatThemeController[] instances = new ChatThemeController[3];

    public static void init() {
        SharedPreferences sharedPreferences = getSharedPreferences();
        themesHash = 0;
        lastReloadTimeMs = 0L;
        if (!BuildVars.DEBUG_VERSION) {
            sharedPreferences.getInt("hash", 0);
            lastReloadTimeMs = sharedPreferences.getLong("lastReload", 0L);
        }
        allChatThemes = getAllChatThemesFromPrefs();
        Emoji.preloadEmoji("❌");
        if (!allChatThemes.isEmpty()) {
            Iterator<ChatTheme> it = allChatThemes.iterator();
            while (it.hasNext()) {
                Emoji.preloadEmoji(it.next().getEmoticon());
            }
            return;
        }
        Emoji.preloadEmoji("🦁");
        Emoji.preloadEmoji("⛄");
        Emoji.preloadEmoji("💎");
        Emoji.preloadEmoji("👨\u200d🏫");
        Emoji.preloadEmoji("🌷");
        Emoji.preloadEmoji("🔮");
        Emoji.preloadEmoji("🎄");
        Emoji.preloadEmoji("🎮");
    }

    public static void requestAllChatThemes(final ResultCallback<List<ChatTheme>> callback, final boolean withDefault) {
        if (themesHash == 0 || lastReloadTimeMs == 0) {
            init();
        }
        boolean z = System.currentTimeMillis() - lastReloadTimeMs > reloadTimeoutMs;
        List<ChatTheme> list = allChatThemes;
        if (list == null || list.isEmpty() || z) {
            TLRPC$TL_account_getChatThemes tLRPC$TL_account_getChatThemes = new TLRPC$TL_account_getChatThemes();
            tLRPC$TL_account_getChatThemes.hash = themesHash;
            ConnectionsManager.getInstance(UserConfig.selectedAccount).sendRequest(tLRPC$TL_account_getChatThemes, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ChatThemeController$w1nhDZ0-Zr98M09sejHbceIoweE
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    ChatThemeController.chatThemeQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ChatThemeController$EkTCHL2kcAM9NUhANw1ISaEG6to
                        @Override // java.lang.Runnable
                        public final void run() {
                            ChatThemeController.lambda$requestAllChatThemes$2(tLObject, resultCallback, tLRPC$TL_error, z);
                        }
                    });
                }
            });
            return;
        }
        ArrayList arrayList = new ArrayList(allChatThemes);
        if (withDefault && !arrayList.get(0).isDefault) {
            arrayList.add(0, ChatTheme.getDefault());
        }
        Iterator<ChatTheme> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().initColors();
        }
        callback.onComplete(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void lambda$requestAllChatThemes$2(ir.eitaa.tgnet.TLObject r7, final ir.eitaa.tgnet.ResultCallback r8, final ir.eitaa.tgnet.TLRPC$TL_error r9, boolean r10) {
        /*
            boolean r0 = r7 instanceof ir.eitaa.tgnet.TLRPC$TL_account_chatThemes
            r1 = 0
            if (r0 == 0) goto L90
            ir.eitaa.tgnet.TLRPC$TL_account_chatThemes r7 = (ir.eitaa.tgnet.TLRPC$TL_account_chatThemes) r7
            int r9 = r7.hash
            ir.eitaa.messenger.ChatThemeController.themesHash = r9
            long r2 = java.lang.System.currentTimeMillis()
            ir.eitaa.messenger.ChatThemeController.lastReloadTimeMs = r2
            android.content.SharedPreferences r9 = getSharedPreferences()
            android.content.SharedPreferences$Editor r9 = r9.edit()
            r9.clear()
            int r0 = ir.eitaa.messenger.ChatThemeController.themesHash
            java.lang.String r2 = "hash"
            r9.putInt(r2, r0)
            long r2 = ir.eitaa.messenger.ChatThemeController.lastReloadTimeMs
            java.lang.String r0 = "lastReload"
            r9.putLong(r0, r2)
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_chatTheme> r0 = r7.themes
            int r0 = r0.size()
            java.lang.String r2 = "count"
            r9.putInt(r2, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_chatTheme> r2 = r7.themes
            int r2 = r2.size()
            r0.<init>(r2)
            r2 = 0
        L41:
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_chatTheme> r3 = r7.themes
            int r3 = r3.size()
            if (r2 >= r3) goto L8c
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_chatTheme> r3 = r7.themes
            java.lang.Object r3 = r3.get(r2)
            ir.eitaa.tgnet.TLRPC$TL_chatTheme r3 = (ir.eitaa.tgnet.TLRPC$TL_chatTheme) r3
            java.lang.String r4 = r3.emoticon
            ir.eitaa.messenger.Emoji.preloadEmoji(r4)
            ir.eitaa.tgnet.SerializedData r4 = new ir.eitaa.tgnet.SerializedData
            int r5 = r3.getObjectSize()
            r4.<init>(r5)
            r3.serializeToStream(r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "theme_"
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            byte[] r4 = r4.toByteArray()
            java.lang.String r4 = ir.eitaa.messenger.Utilities.bytesToHex(r4)
            r9.putString(r5, r4)
            ir.eitaa.ui.ActionBar.ChatTheme r4 = new ir.eitaa.ui.ActionBar.ChatTheme
            r4.<init>(r3, r1)
            r4.preloadWallpaper()
            r0.add(r4)
            int r2 = r2 + 1
            goto L41
        L8c:
            r9.apply()
            goto L98
        L90:
            boolean r7 = r7 instanceof ir.eitaa.tgnet.TLRPC$TL_account_chatThemesNotModified
            if (r7 == 0) goto L9a
            java.util.List r0 = getAllChatThemesFromPrefs()
        L98:
            r7 = 0
            goto La4
        L9a:
            r0 = 0
            ir.eitaa.messenger.-$$Lambda$ChatThemeController$4Lbl1yfikjoTXq3M36QpAIsEa9c r7 = new ir.eitaa.messenger.-$$Lambda$ChatThemeController$4Lbl1yfikjoTXq3M36QpAIsEa9c
            r7.<init>()
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r7)
            r7 = 1
        La4:
            if (r7 != 0) goto Ld5
            if (r10 == 0) goto Lb9
            java.lang.Object r7 = r0.get(r1)
            ir.eitaa.ui.ActionBar.ChatTheme r7 = (ir.eitaa.ui.ActionBar.ChatTheme) r7
            boolean r7 = r7.isDefault
            if (r7 != 0) goto Lb9
            ir.eitaa.ui.ActionBar.ChatTheme r7 = ir.eitaa.ui.ActionBar.ChatTheme.getDefault()
            r0.add(r1, r7)
        Lb9:
            java.util.Iterator r7 = r0.iterator()
        Lbd:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto Lcd
            java.lang.Object r9 = r7.next()
            ir.eitaa.ui.ActionBar.ChatTheme r9 = (ir.eitaa.ui.ActionBar.ChatTheme) r9
            r9.initColors()
            goto Lbd
        Lcd:
            ir.eitaa.messenger.-$$Lambda$ChatThemeController$Ms7ZflUEKf0DcW4jtrJD-l1iKlo r7 = new ir.eitaa.messenger.-$$Lambda$ChatThemeController$Ms7ZflUEKf0DcW4jtrJD-l1iKlo
            r7.<init>()
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r7)
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ChatThemeController.lambda$requestAllChatThemes$2(ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.ResultCallback, ir.eitaa.tgnet.TLRPC$TL_error, boolean):void");
    }

    static /* synthetic */ void lambda$requestAllChatThemes$1(List list, ResultCallback resultCallback) {
        allChatThemes = new ArrayList(list);
        resultCallback.onComplete(list);
    }

    private static SharedPreferences getSharedPreferences() {
        return ApplicationLoader.applicationContext.getSharedPreferences("chatthemeconfig", 0);
    }

    private static SharedPreferences getEmojiSharedPreferences() {
        return ApplicationLoader.applicationContext.getSharedPreferences("chatthemeconfig_emoji", 0);
    }

    private static List<ChatTheme> getAllChatThemesFromPrefs() {
        SharedPreferences sharedPreferences = getSharedPreferences();
        int i = sharedPreferences.getInt(NotificationBadge.NewHtcHomeBadger.COUNT, 0);
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            SerializedData serializedData = new SerializedData(Utilities.hexToBytes(sharedPreferences.getString("theme_" + i2, "")));
            try {
                TLRPC$TL_chatTheme tLRPC$TL_chatThemeTLdeserialize = TLRPC$TL_chatTheme.TLdeserialize(serializedData, serializedData.readInt32(true), true);
                if (tLRPC$TL_chatThemeTLdeserialize != null) {
                    arrayList.add(new ChatTheme(tLRPC$TL_chatThemeTLdeserialize, false));
                }
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        return arrayList;
    }

    public static void requestChatTheme(final String emoticon, final ResultCallback<ChatTheme> callback) {
        if (TextUtils.isEmpty(emoticon)) {
            callback.onComplete(null);
        } else {
            requestAllChatThemes(new ResultCallback<List<ChatTheme>>() { // from class: ir.eitaa.messenger.ChatThemeController.1
                public /* bridge */ /* synthetic */ void onError(Throwable throwable) {
                    ResultCallback.CC.$default$onError(this, throwable);
                }

                @Override // ir.eitaa.tgnet.ResultCallback
                public void onComplete(List<ChatTheme> result) {
                    for (ChatTheme chatTheme : result) {
                        if (emoticon.equals(chatTheme.getEmoticon())) {
                            chatTheme.initColors();
                            callback.onComplete(chatTheme);
                            return;
                        }
                    }
                }

                @Override // ir.eitaa.tgnet.ResultCallback
                public void onError(TLRPC$TL_error error) {
                    callback.onComplete(null);
                }
            }, false);
        }
    }

    public static ChatThemeController getInstance(int accountNum) {
        ChatThemeController[] chatThemeControllerArr = instances;
        ChatThemeController chatThemeController = chatThemeControllerArr[accountNum];
        if (chatThemeController == null) {
            synchronized (ChatThemeController.class) {
                chatThemeController = chatThemeControllerArr[accountNum];
                if (chatThemeController == null) {
                    chatThemeController = new ChatThemeController(accountNum);
                    chatThemeControllerArr[accountNum] = chatThemeController;
                }
            }
        }
        return chatThemeController;
    }

    public ChatThemeController(int num) {
        super(num);
        this.dialogEmoticonsMap = new LongSparseArray<>();
    }

    public void setDialogTheme(long dialogId, String emoticon, boolean sendRequest) {
        if (TextUtils.equals(this.dialogEmoticonsMap.get(dialogId), emoticon)) {
            return;
        }
        if (emoticon == null) {
            this.dialogEmoticonsMap.delete(dialogId);
        } else {
            this.dialogEmoticonsMap.put(dialogId, emoticon);
        }
        getEmojiSharedPreferences().edit().putString("chatTheme_" + this.currentAccount + "_" + dialogId, emoticon).apply();
        if (sendRequest) {
            TLRPC$TL_messages_setChatTheme tLRPC$TL_messages_setChatTheme = new TLRPC$TL_messages_setChatTheme();
            if (emoticon == null) {
                emoticon = "";
            }
            tLRPC$TL_messages_setChatTheme.emoticon = emoticon;
            tLRPC$TL_messages_setChatTheme.peer = getMessagesController().getInputPeer(dialogId);
            getConnectionsManager().sendRequest(tLRPC$TL_messages_setChatTheme, null);
        }
    }

    public ChatTheme getDialogTheme(long dialogId) {
        String string = this.dialogEmoticonsMap.get(dialogId);
        if (string == null) {
            string = getEmojiSharedPreferences().getString("chatTheme_" + this.currentAccount + "_" + dialogId, null);
            this.dialogEmoticonsMap.put(dialogId, string);
        }
        if (string != null) {
            for (ChatTheme chatTheme : allChatThemes) {
                if (string.equals(chatTheme.getEmoticon())) {
                    return chatTheme;
                }
            }
        }
        return null;
    }

    public static void preloadAllWallpaperImages(boolean isDark) {
        for (ChatTheme chatTheme : allChatThemes) {
            if (!themeIdWallpaperMap.containsKey(Long.valueOf(chatTheme.getTlTheme(isDark).id))) {
                chatTheme.loadWallpaper(isDark, new ResultCallback() { // from class: ir.eitaa.messenger.-$$Lambda$ChatThemeController$mmbq7qyKlJgbaubTwWCHbo-19EI
                    @Override // ir.eitaa.tgnet.ResultCallback
                    public final void onComplete(Object obj) {
                        ChatThemeController.lambda$preloadAllWallpaperImages$4((Pair) obj);
                    }

                    @Override // ir.eitaa.tgnet.ResultCallback
                    public /* synthetic */ void onError(TLRPC$TL_error tLRPC$TL_error) {
                        ResultCallback.CC.$default$onError(this, tLRPC$TL_error);
                    }
                });
            }
        }
    }

    static /* synthetic */ void lambda$preloadAllWallpaperImages$4(Pair pair) {
        if (pair != null) {
            themeIdWallpaperMap.put((Long) pair.first, (Bitmap) pair.second);
        }
    }

    public static void preloadAllWallpaperThumbs(boolean isDark) {
        for (ChatTheme chatTheme : allChatThemes) {
            if (!themeIdWallpaperThumbMap.containsKey(Long.valueOf(chatTheme.getTlTheme(isDark).id))) {
                chatTheme.loadWallpaperThumb(isDark, new ResultCallback() { // from class: ir.eitaa.messenger.-$$Lambda$ChatThemeController$0SXgGBiHnUtEf4LAc7kqQ4wxnlY
                    @Override // ir.eitaa.tgnet.ResultCallback
                    public final void onComplete(Object obj) {
                        ChatThemeController.lambda$preloadAllWallpaperThumbs$5((Pair) obj);
                    }

                    @Override // ir.eitaa.tgnet.ResultCallback
                    public /* synthetic */ void onError(TLRPC$TL_error tLRPC$TL_error) {
                        ResultCallback.CC.$default$onError(this, tLRPC$TL_error);
                    }
                });
            }
        }
    }

    static /* synthetic */ void lambda$preloadAllWallpaperThumbs$5(Pair pair) {
        if (pair != null) {
            themeIdWallpaperThumbMap.put((Long) pair.first, (Bitmap) pair.second);
        }
    }

    public static void clearWallpaperImages() {
        themeIdWallpaperMap.clear();
    }

    public static void clearWallpaperThumbImages() {
        themeIdWallpaperThumbMap.clear();
    }

    public static Bitmap getWallpaperBitmap(long themeId) {
        return themeIdWallpaperMap.get(Long.valueOf(themeId));
    }

    public static Bitmap getWallpaperThumbBitmap(long themeId) {
        return themeIdWallpaperThumbMap.get(Long.valueOf(themeId));
    }

    public void clearCache() {
        themesHash = 0;
        lastReloadTimeMs = 0L;
        getSharedPreferences().edit().clear().apply();
    }
}
