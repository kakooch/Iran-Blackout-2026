package ir.aaap.messengercore;

import ir.aaap.messengercore.model.ReactionObject;
import ir.aaap.messengercore.model.SettingModels;
import ir.aaap.messengercore.model.api.PrivacySettings;
import ir.aaap.messengercore.network.ApiServerException;
import ir.aaap.messengercore.network.NetworkHelper;
import ir.aaap.messengercore.network.RetryObject;
import ir.aaap.messengercore.utilites.CoreLog;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SettingUtils {
    private ArrayList<ReactionObject> availableReactions;
    private CoreLog coreLog;
    private boolean loadingDeviceSettings;
    private boolean loadingPrivacySettings;
    private boolean loadingStickerSettings;
    private boolean loadingThemes;
    private boolean loadingUserSettings;
    private boolean loadingWallpapers;
    public SettingModels.WallpapersOutput wallpapersOutput;
    private PrivacySettings privacySettingsInstant = null;
    private boolean loadingAvailableReactions = false;
    private final Object lock = new Object();

    public SettingUtils(CoreLog coreLog, JsonHelper jsonHelper) {
        this.coreLog = coreLog;
    }

    public void addWallpaperSetThemeBackground(long j, String str, long j2, String str2, String str3, String str4, NetworkHelper networkHelper, final LoadListener<SettingModels.AddWallpaperSetThemeBackgroundOutput> loadListener) {
        SettingModels.AddWallpaperSetThemeBackgroundInput addWallpaperSetThemeBackgroundInput = new SettingModels.AddWallpaperSetThemeBackgroundInput();
        addWallpaperSetThemeBackgroundInput.main_file_id = j;
        addWallpaperSetThemeBackgroundInput.main_access_hash_rec = str;
        addWallpaperSetThemeBackgroundInput.thumbnail_file_id = j2;
        addWallpaperSetThemeBackgroundInput.thumb_access_hash_rec = str2;
        addWallpaperSetThemeBackgroundInput.theme_id = str3;
        try {
            networkHelper.addWallpaperSetThemeBackground(str4, addWallpaperSetThemeBackgroundInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SettingModels.AddWallpaperSetThemeBackgroundOutput>(this) { // from class: ir.aaap.messengercore.SettingUtils.1
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SettingModels.AddWallpaperSetThemeBackgroundOutput addWallpaperSetThemeBackgroundOutput) {
                    if (addWallpaperSetThemeBackgroundOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(addWallpaperSetThemeBackgroundOutput);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void getWallpapers(String str, NetworkHelper networkHelper, KeyValueStorageHelper keyValueStorageHelper, final LoadListener<SettingModels.WallpapersOutput> loadListener) {
        if (this.loadingWallpapers) {
            return;
        }
        this.loadingWallpapers = true;
        try {
            networkHelper.getWallpapers(str, new SettingModels.SettingInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SettingModels.WallpapersOutput>() { // from class: ir.aaap.messengercore.SettingUtils.2
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SettingModels.WallpapersOutput wallpapersOutput) {
                    SettingUtils.this.loadingWallpapers = false;
                    if (wallpapersOutput != null) {
                        SettingUtils.this.wallpapersOutput = wallpapersOutput;
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(wallpapersOutput);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    SettingUtils.this.loadingWallpapers = false;
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.loadingWallpapers = false;
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void resetWallpapers(String str, NetworkHelper networkHelper, final KeyValueStorageHelper keyValueStorageHelper, final LoadListener<SettingModels.WallpapersOutput> loadListener) {
        try {
            networkHelper.resetWallpapers(str, new SettingModels.SettingInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SettingModels.WallpapersOutput>() { // from class: ir.aaap.messengercore.SettingUtils.3
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SettingModels.WallpapersOutput wallpapersOutput) {
                    if (wallpapersOutput != null) {
                        if (wallpapersOutput.new_theme_backgrounds != null) {
                            SettingModels.AppearanceSettingObject appearanceSettingObjectInstant = SettingUtils.this.getAppearanceSettingObjectInstant(keyValueStorageHelper);
                            appearanceSettingObjectInstant.theme_backgrounds = wallpapersOutput.new_theme_backgrounds;
                            keyValueStorageHelper.setAppearanceSettingObject(appearanceSettingObjectInstant, System.currentTimeMillis());
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(wallpapersOutput);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.loadingWallpapers = false;
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c0, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSettings(boolean r17, java.util.Map<ir.aaap.messengercore.model.SettingModels.ParameterNameEnum, java.lang.Object> r18, java.lang.String r19, ir.aaap.messengercore.network.NetworkHelper r20, final ir.aaap.messengercore.KeyValueStorageHelper r21, final ir.aaap.messengercore.LoadListener<java.lang.Integer> r22) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.aaap.messengercore.SettingUtils.setSettings(boolean, java.util.Map, java.lang.String, ir.aaap.messengercore.network.NetworkHelper, ir.aaap.messengercore.KeyValueStorageHelper, ir.aaap.messengercore.LoadListener):void");
    }

    public void getPrivacySettingFromServer(String str, NetworkHelper networkHelper, final LoadListener<PrivacySettings> loadListener) {
        if (this.loadingPrivacySettings) {
            return;
        }
        this.loadingPrivacySettings = true;
        try {
            networkHelper.getPrivacySetting(str, new SettingModels.SettingInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SettingModels.GetPrivacySettingOutput>() { // from class: ir.aaap.messengercore.SettingUtils.5
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SettingModels.GetPrivacySettingOutput getPrivacySettingOutput) {
                    PrivacySettings privacySettings;
                    SettingUtils.this.loadingPrivacySettings = false;
                    if (getPrivacySettingOutput != null && (privacySettings = getPrivacySettingOutput.privacy_setting) != null) {
                        SettingUtils.this.privacySettingsInstant = privacySettings;
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getPrivacySettingOutput.privacy_setting);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    SettingUtils.this.loadingPrivacySettings = false;
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.loadingPrivacySettings = false;
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void getUserSettingObjectFromServer(String str, NetworkHelper networkHelper, final KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<Integer> loadListener) {
        if (this.loadingUserSettings) {
            return;
        }
        this.loadingUserSettings = true;
        try {
            networkHelper.getUserSetting(str, new SettingModels.SettingInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SettingModels.GetUserSettingOutput>() { // from class: ir.aaap.messengercore.SettingUtils.6
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SettingModels.GetUserSettingOutput getUserSettingOutput) {
                    PrivacySettings privacySettings;
                    SettingUtils.this.loadingUserSettings = false;
                    if (getUserSettingOutput != null && (privacySettings = getUserSettingOutput.privacy_setting) != null) {
                        SettingUtils.this.privacySettingsInstant = privacySettings;
                        keyValueStorageHelper.setUserSettingObject(getUserSettingOutput.privacy_setting, System.currentTimeMillis());
                        absNotificationCenter.privacySettingsUpdated();
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(1);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    SettingUtils.this.loadingUserSettings = false;
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.loadingUserSettings = false;
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void getDeviceSettingObjectFromServer(String str, NetworkHelper networkHelper, final KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter, final boolean z, final LoadListener<Integer> loadListener) {
        if (this.loadingDeviceSettings) {
            return;
        }
        this.loadingDeviceSettings = true;
        try {
            networkHelper.getDeviceSetting(str, new SettingModels.SettingInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SettingModels.GetDeviceSettingOutput>() { // from class: ir.aaap.messengercore.SettingUtils.7
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SettingModels.GetDeviceSettingOutput getDeviceSettingOutput) {
                    SettingUtils.this.loadingDeviceSettings = false;
                    if (getDeviceSettingOutput != null) {
                        SettingModels.DataSettingObject dataSettingObject = getDeviceSettingOutput.data_setting;
                        if (dataSettingObject != null) {
                            keyValueStorageHelper.setDataSettingObject(dataSettingObject, System.currentTimeMillis());
                            if (z) {
                                absNotificationCenter.dataSettingsUpdated();
                            }
                        }
                        SettingModels.AppearanceSettingObject appearanceSettingObject = getDeviceSettingOutput.appearance_setting;
                        if (appearanceSettingObject != null) {
                            keyValueStorageHelper.setAppearanceSettingObject(appearanceSettingObject, System.currentTimeMillis());
                            if (z) {
                                absNotificationCenter.appearanceSettingsUpdated();
                            }
                        }
                        SettingModels.NotificationSettingObject notificationSettingObject = getDeviceSettingOutput.notification_setting;
                        if (notificationSettingObject != null) {
                            keyValueStorageHelper.setNotificationSettingObject(notificationSettingObject, System.currentTimeMillis());
                            absNotificationCenter.appNotificationsSettingsUpdated();
                        }
                        keyValueStorageHelper.setLastUpdatedDeviceSettingTime(System.currentTimeMillis());
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(1);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    SettingUtils.this.loadingDeviceSettings = false;
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.loadingDeviceSettings = false;
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    private void getThemesFromServer(String str, NetworkHelper networkHelper, final KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<Integer> loadListener) {
        if (this.loadingThemes) {
            return;
        }
        this.loadingThemes = true;
        try {
            networkHelper.getThemes(str, new SettingModels.SettingInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SettingModels.GetThemesOutput>() { // from class: ir.aaap.messengercore.SettingUtils.8
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SettingModels.GetThemesOutput getThemesOutput) {
                    SettingUtils.this.loadingThemes = false;
                    if (getThemesOutput != null && getThemesOutput.themes != null) {
                        keyValueStorageHelper.setThemes(getThemesOutput, System.currentTimeMillis());
                        absNotificationCenter.themesDidLoad();
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(1);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    SettingUtils.this.loadingThemes = false;
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.loadingThemes = false;
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void getThemes(boolean z, String str, NetworkHelper networkHelper, KeyValueStorageHelper keyValueStorageHelper, AbsNotificationCenter absNotificationCenter, LoadListener<Integer> loadListener) {
        ArrayList<SettingModels.ThemeObject> arrayList;
        boolean z2 = true;
        if (!z && System.currentTimeMillis() - keyValueStorageHelper.getLastUpdatedThemeSettingTime() < 7200000) {
            SettingModels.GetThemesOutput themesInstant = getThemesInstant(keyValueStorageHelper);
            if (themesInstant != null && (arrayList = themesInstant.themes) != null && arrayList.size() > 0) {
                if (loadListener != null) {
                    loadListener.onDidLoad(1);
                }
                if (absNotificationCenter != null) {
                    absNotificationCenter.themesDidLoad();
                }
            }
            z2 = false;
        }
        if (z || z2) {
            getThemesFromServer(str, networkHelper, keyValueStorageHelper, absNotificationCenter, loadListener);
        }
    }

    public void getStickerSettingObjectFromServer(String str, NetworkHelper networkHelper, final KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<Integer> loadListener) {
        if (this.loadingStickerSettings) {
            return;
        }
        this.loadingStickerSettings = true;
        try {
            networkHelper.getStickerSetting(str, new SettingModels.SettingInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SettingModels.GetStickersSettingOutput>() { // from class: ir.aaap.messengercore.SettingUtils.9
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SettingModels.GetStickersSettingOutput getStickersSettingOutput) {
                    SettingModels.StickerSettingObject stickerSettingObject;
                    SettingUtils.this.loadingStickerSettings = false;
                    if (getStickersSettingOutput != null && (stickerSettingObject = getStickersSettingOutput.sticker_setting) != null) {
                        keyValueStorageHelper.setStickerSettingObject(stickerSettingObject, System.currentTimeMillis());
                        absNotificationCenter.settingsUpdated();
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(1);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    SettingUtils.this.loadingStickerSettings = false;
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.loadingStickerSettings = false;
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public PrivacySettings getPrivacySettingInstant() {
        return this.privacySettingsInstant;
    }

    public SettingModels.GetThemesOutput getThemesInstant(KeyValueStorageHelper keyValueStorageHelper) {
        return keyValueStorageHelper.getThemes();
    }

    public SettingModels.DataSettingObject getDataSettingObjectInstant(KeyValueStorageHelper keyValueStorageHelper) {
        SettingModels.DataSettingObject dataSettingObject = keyValueStorageHelper.getDataSettingObject();
        return dataSettingObject == null ? getDefaultDataSetting() : dataSettingObject;
    }

    public SettingModels.NotificationSettingObject getNotificationSettingObjectInstant(KeyValueStorageHelper keyValueStorageHelper, boolean z) {
        SettingModels.NotificationSettingObject notificationSettingObject = keyValueStorageHelper.getNotificationSettingObject();
        return notificationSettingObject == null ? getDefaultNotificationSettingObject(z) : notificationSettingObject;
    }

    public SettingModels.AppearanceSettingObject getAppearanceSettingObjectInstant(KeyValueStorageHelper keyValueStorageHelper) {
        SettingModels.AppearanceSettingObject appearanceSettingObject = keyValueStorageHelper.getAppearanceSettingObject();
        return appearanceSettingObject == null ? getDefaultAppearanceSetting() : appearanceSettingObject;
    }

    public SettingModels.StickerSettingObject getStickerSettingObjectInstant(KeyValueStorageHelper keyValueStorageHelper) {
        SettingModels.StickerSettingObject stickerSettingObject = keyValueStorageHelper.getStickerSettingObject();
        return stickerSettingObject == null ? getDefaultStickerSetting() : stickerSettingObject;
    }

    private SettingModels.StickerSettingObject getDefaultStickerSetting() {
        SettingModels.StickerSettingObject stickerSettingObject = new SettingModels.StickerSettingObject();
        stickerSettingObject.suggest_stickers_by_emoji = SettingModels.StickerSettingObject.SuggestTypeEnum.All;
        return stickerSettingObject;
    }

    private SettingModels.DataSettingObject getDefaultDataSetting() {
        SettingModels.DataSettingObject dataSettingObject = new SettingModels.DataSettingObject();
        dataSettingObject.auto_download_media = true;
        SettingModels.AutoDownloadSettingObject autoDownloadSettingObject = new SettingModels.AutoDownloadSettingObject();
        dataSettingObject.wifi_photo_auto_download = autoDownloadSettingObject;
        autoDownloadSettingObject.other_users = true;
        autoDownloadSettingObject.contacts = true;
        autoDownloadSettingObject.groups = true;
        autoDownloadSettingObject.channels = true;
        SettingModels.AutoDownloadSettingObject autoDownloadSettingObject2 = new SettingModels.AutoDownloadSettingObject();
        dataSettingObject.cellular_photo_auto_download = autoDownloadSettingObject2;
        autoDownloadSettingObject2.other_users = true;
        autoDownloadSettingObject2.contacts = true;
        autoDownloadSettingObject2.groups = true;
        autoDownloadSettingObject2.channels = true;
        SettingModels.AutoDownloadSettingObject autoDownloadSettingObject3 = new SettingModels.AutoDownloadSettingObject();
        dataSettingObject.wifi_video_auto_download = autoDownloadSettingObject3;
        autoDownloadSettingObject3.other_users = false;
        autoDownloadSettingObject3.contacts = false;
        autoDownloadSettingObject3.groups = false;
        autoDownloadSettingObject3.channels = false;
        autoDownloadSettingObject3.max_download_size = 1000L;
        SettingModels.AutoDownloadSettingObject autoDownloadSettingObject4 = new SettingModels.AutoDownloadSettingObject();
        dataSettingObject.cellular_video_auto_download = autoDownloadSettingObject4;
        autoDownloadSettingObject4.other_users = false;
        autoDownloadSettingObject4.contacts = false;
        autoDownloadSettingObject4.groups = false;
        autoDownloadSettingObject4.channels = false;
        autoDownloadSettingObject4.max_download_size = 1000L;
        SettingModels.AutoDownloadSettingObject autoDownloadSettingObject5 = new SettingModels.AutoDownloadSettingObject();
        dataSettingObject.wifi_file_auto_download = autoDownloadSettingObject5;
        autoDownloadSettingObject5.other_users = false;
        autoDownloadSettingObject5.contacts = false;
        autoDownloadSettingObject5.groups = false;
        autoDownloadSettingObject5.channels = false;
        autoDownloadSettingObject5.max_download_size = 1000L;
        SettingModels.AutoDownloadSettingObject autoDownloadSettingObject6 = new SettingModels.AutoDownloadSettingObject();
        dataSettingObject.cellular_file_auto_download = autoDownloadSettingObject6;
        autoDownloadSettingObject6.other_users = false;
        autoDownloadSettingObject6.contacts = false;
        autoDownloadSettingObject6.groups = false;
        autoDownloadSettingObject6.channels = false;
        autoDownloadSettingObject6.max_download_size = 1000L;
        SettingModels.AutoDownloadSettingObject autoDownloadSettingObject7 = new SettingModels.AutoDownloadSettingObject();
        dataSettingObject.wifi_music_auto_download = autoDownloadSettingObject7;
        autoDownloadSettingObject7.other_users = true;
        autoDownloadSettingObject7.contacts = true;
        autoDownloadSettingObject7.groups = true;
        autoDownloadSettingObject7.channels = true;
        autoDownloadSettingObject7.max_download_size = 2000L;
        SettingModels.AutoDownloadSettingObject autoDownloadSettingObject8 = new SettingModels.AutoDownloadSettingObject();
        dataSettingObject.cellular_music_auto_download = autoDownloadSettingObject8;
        autoDownloadSettingObject8.other_users = true;
        autoDownloadSettingObject8.contacts = true;
        autoDownloadSettingObject8.groups = true;
        autoDownloadSettingObject8.channels = true;
        autoDownloadSettingObject8.max_download_size = 2000L;
        SettingModels.AutoDownloadSettingObject autoDownloadSettingObject9 = new SettingModels.AutoDownloadSettingObject();
        dataSettingObject.wifi_gif_auto_download = autoDownloadSettingObject9;
        autoDownloadSettingObject9.other_users = true;
        autoDownloadSettingObject9.contacts = true;
        autoDownloadSettingObject9.groups = true;
        autoDownloadSettingObject9.channels = true;
        autoDownloadSettingObject9.max_download_size = 2000L;
        SettingModels.AutoDownloadSettingObject autoDownloadSettingObject10 = new SettingModels.AutoDownloadSettingObject();
        dataSettingObject.cellular_gif_auto_download = autoDownloadSettingObject10;
        autoDownloadSettingObject10.other_users = true;
        autoDownloadSettingObject10.contacts = true;
        autoDownloadSettingObject10.groups = true;
        autoDownloadSettingObject10.channels = true;
        autoDownloadSettingObject10.max_download_size = 2000L;
        return dataSettingObject;
    }

    private SettingModels.AppearanceSettingObject getDefaultAppearanceSetting() {
        SettingModels.AppearanceSettingObject appearanceSettingObject = new SettingModels.AppearanceSettingObject();
        appearanceSettingObject.android_font_size = 15;
        return appearanceSettingObject;
    }

    private SettingModels.NotificationSettingObject getDefaultNotificationSettingObject(boolean z) {
        SettingModels.NotificationSettingObject notificationSettingObject = new SettingModels.NotificationSettingObject();
        notificationSettingObject.user_notification = true;
        notificationSettingObject.user_message_preview = true;
        notificationSettingObject.group_message_preview = true;
        notificationSettingObject.channel_message_preview = true;
        notificationSettingObject.in_app_sound = true;
        notificationSettingObject.in_app_preview = true;
        notificationSettingObject.new_contacts = true;
        if (z) {
            notificationSettingObject.group_notification = false;
            notificationSettingObject.channel_notification = false;
        } else {
            notificationSettingObject.group_notification = true;
            notificationSettingObject.channel_notification = true;
        }
        return notificationSettingObject;
    }

    public void initSettingIfNeeded(String str, NetworkHelper networkHelper, KeyValueStorageHelper keyValueStorageHelper, AbsNotificationCenter absNotificationCenter) {
        if (System.currentTimeMillis() - keyValueStorageHelper.getLastUpdatedUserSettingTime() > 7200000) {
            getUserSettingObjectFromServer(str, networkHelper, keyValueStorageHelper, absNotificationCenter, null);
        }
        long lastUpdatedDeviceSettingTime = keyValueStorageHelper.getLastUpdatedDeviceSettingTime();
        if (System.currentTimeMillis() - lastUpdatedDeviceSettingTime > 7200000) {
            getDeviceSettingObjectFromServer(str, networkHelper, keyValueStorageHelper, absNotificationCenter, lastUpdatedDeviceSettingTime <= 0, null);
        }
        if (System.currentTimeMillis() - keyValueStorageHelper.getLastUpdatedStickerSettingTime() > 7200000) {
            getStickerSettingObjectFromServer(str, networkHelper, keyValueStorageHelper, absNotificationCenter, null);
        }
        getThemes(false, str, networkHelper, keyValueStorageHelper, absNotificationCenter, null);
    }

    public void getAvailableReactionsIfNeeded(String str, NetworkHelper networkHelper, KeyValueStorageHelper keyValueStorageHelper, AbsNotificationCenter absNotificationCenter, LoadListener<Integer> loadListener) {
        long lastUpdatedReactionTime = keyValueStorageHelper.getLastUpdatedReactionTime();
        boolean z = getAvailableReactionsInstant(keyValueStorageHelper) != null;
        if (z) {
            if (loadListener != null) {
                loadListener.onDidLoad(1);
            }
            absNotificationCenter.availableReactionsDidLoad();
        }
        if (z) {
            if (System.currentTimeMillis() - lastUpdatedReactionTime <= (this.coreLog.isDebug() ? 1000L : 7200000L)) {
                return;
            }
        }
        if (z) {
            loadListener = null;
        }
        getAvailableReactionsFromServer(str, networkHelper, keyValueStorageHelper, absNotificationCenter, loadListener);
    }

    private void getAvailableReactionsFromServer(String str, NetworkHelper networkHelper, final KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<Integer> loadListener) {
        if (this.loadingAvailableReactions) {
            return;
        }
        this.loadingAvailableReactions = true;
        try {
            networkHelper.getAvailableReactions(str, new SettingModels.GetAvailableReactionsInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SettingModels.GetAvailableReactionsOutput>() { // from class: ir.aaap.messengercore.SettingUtils.10
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SettingModels.GetAvailableReactionsOutput getAvailableReactionsOutput) {
                    SettingUtils.this.loadingAvailableReactions = false;
                    if (getAvailableReactionsOutput != null) {
                        synchronized (SettingUtils.this.lock) {
                            SettingUtils.this.availableReactions = getAvailableReactionsOutput.reactions;
                        }
                        keyValueStorageHelper.setAvailableReactions(getAvailableReactionsOutput.reactions, System.currentTimeMillis());
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(1);
                        }
                        absNotificationCenter.availableReactionsDidLoad();
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    SettingUtils.this.loadingAvailableReactions = false;
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.loadingAvailableReactions = false;
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public ArrayList<ReactionObject> getAvailableReactionsInstant(KeyValueStorageHelper keyValueStorageHelper) {
        ArrayList<ReactionObject> arrayList = this.availableReactions;
        if (arrayList == null) {
            synchronized (this.lock) {
                arrayList = this.availableReactions;
                if (arrayList == null) {
                    ArrayList<ReactionObject> availableReactions = keyValueStorageHelper.getAvailableReactions();
                    this.availableReactions = availableReactions;
                    arrayList = availableReactions;
                }
            }
        }
        return arrayList;
    }
}
