package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.api.PrivacySettings;
import ir.aaap.messengercore.utilites.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class SettingModels {

    public static class ActionOnMessageReactionInput {
        public ActionOnMessageReactionTypeEnum action;
        public long message_id;
        public String object_guid;
        public String reaction_id;
    }

    public static class ActionOnMessageReactionOutput {
        public ArrayList<MessageReactionObject> reactions;
    }

    public enum ActionOnMessageReactionTypeEnum {
        Add,
        Remove
    }

    public static class AddWallpaperSetThemeBackgroundInput {
        public String main_access_hash_rec;
        public long main_file_id;
        public String theme_id;
        public String thumb_access_hash_rec;
        public long thumbnail_file_id;
    }

    public static class AddWallpaperSetThemeBackgroundOutput {
        public WallpaperObject wallpaper;
    }

    public enum AutoNightModeType {
        Disable,
        Scheduled,
        Adaptive
    }

    public enum BackGroundTypeEnum {
        Color,
        Wallpaper
    }

    public enum ChatListSwipeGestureType {
        ChangeFolder,
        Pin,
        Read,
        Mute,
        Delete
    }

    public enum ChatListViewType {
        TwoLines,
        ThreeLines
    }

    public static class DataSettingObject {
        public boolean auto_download_media;
        public boolean cellular_auto_download;
        public AutoDownloadSettingObject cellular_file_auto_download;
        public AutoDownloadSettingObject cellular_gif_auto_download;
        public AutoDownloadSettingObject cellular_music_auto_download;
        public AutoDownloadSettingObject cellular_photo_auto_download;
        public AutoDownloadSettingObject cellular_video_auto_download;
        public boolean gif_auto_play;
        public KeepMediaPeriod keep_media;
        public boolean stream_videos_and_audio_files;
        public boolean video_auto_play;
        public boolean wifi_auto_download;
        public AutoDownloadSettingObject wifi_file_auto_download;
        public AutoDownloadSettingObject wifi_gif_auto_download;
        public AutoDownloadSettingObject wifi_music_auto_download;
        public AutoDownloadSettingObject wifi_photo_auto_download;
        public AutoDownloadSettingObject wifi_video_auto_download;
    }

    public static class GetAppearanceSettingOutput {
        public AppearanceSettingObject appearance_setting;
    }

    public static class GetAvailableReactionsInput {
    }

    public static class GetAvailableReactionsOutput {
        public ArrayList<ReactionObject> reactions;
    }

    public static class GetChatReactionInput {
        public long max_id;
        public long min_id;
        public String object_guid;
    }

    public static class GetChatReactionOutput {
        public Map<Long, ArrayList<MessageReactionObject>> list;
    }

    public static class GetDataSettingOutput {
        public DataSettingObject data_setting;
    }

    public static class GetDeviceSettingOutput {
        public AppearanceSettingObject appearance_setting;
        public DataSettingObject data_setting;
        public NotificationSettingObject notification_setting;
    }

    public static class GetMessageReactionsInput {
        public long message_id;
        public String object_guid;
        public String start_id;
    }

    public static class GetMessageReactionsOutput {
        public boolean has_continue;
        public String next_start_id;
        public int reactionCount;
        public ArrayList<UserReactionObject> user_message_reactions;
    }

    public static class GetNotificationSettingOutput {
        public NotificationSettingObject notification_setting;
    }

    public static class GetPrivacySettingOutput {
        public PrivacySettings privacy_setting;
    }

    public static class GetStickersSettingOutput {
        public StickerSettingObject sticker_setting;
    }

    public static class GetThemesOutput {
        public ArrayList<ThemeObject> themes;
    }

    public static class GetUserSettingOutput {
        public PrivacySettings privacy_setting;
    }

    public enum ImportanceObject {
        Low,
        Medium,
        High,
        Urgent
    }

    public enum KeepMediaPeriod {
        ThreeDays,
        OneWeek,
        OneMonth,
        Forever
    }

    public static class NotificationSettingObject {
        public boolean badge_count_unread_messages;
        public boolean badge_counter_enable;
        public boolean badge_include_mute_chats;
        public boolean channel_message_preview;
        public boolean channel_notification;
        public ImportanceObject channel_notification_importance;
        public PopupObject channel_notification_popup;
        public VibrateObject channel_notification_vibrate;
        public boolean event_contact_joined;
        public boolean event_pinned_messages;
        public boolean group_message_preview;
        public boolean group_notification;
        public ImportanceObject group_notification_importance;
        public PopupObject group_notification_popup;
        public VibrateObject group_notification_vibrate;
        public boolean importance;
        public boolean in_app_preview;
        public boolean in_app_sound;
        public boolean in_app_vibrate;
        public boolean in_chat_sounds;
        public boolean new_contacts;
        public boolean user_message_preview;
        public boolean user_notification;
        public ImportanceObject user_notification_importance;
        public PopupObject user_notification_popup;
        public VibrateObject user_notification_vibrate;
        public VibrateObject vibrate_voice_calls;
    }

    public enum ParameterNameEnum {
        auto_download_media,
        wifi_photo_auto_download,
        cellular_photo_auto_download,
        wifi_video_auto_download,
        cellular_video_auto_download,
        wifi_file_auto_download,
        cellular_file_auto_download,
        wifi_gif_auto_download,
        cellular_gif_auto_download,
        wifi_music_auto_download,
        cellular_music_auto_download,
        user_notification,
        user_message_preview,
        group_notification,
        group_message_preview,
        channel_notification,
        channel_message_preview,
        in_app_sound,
        in_app_preview,
        new_contacts,
        auto_dark_theme_id,
        auto_day_theme_id,
        manual_selected_theme_id,
        theme_background,
        large_emoji,
        android_font_size,
        gif_auto_play,
        auto_night_mode,
        suggest_stickers_by_emoji,
        show_my_phone_number,
        show_my_profile_photo,
        can_join_chat_by,
        link_forward_message,
        can_called_by,
        show_my_last_online,
        delete_account_not_active_months,
        user_notification_vibrate,
        user_notification_importance,
        user_notification_popup,
        group_notification_vibrate,
        group_notification_importance,
        group_notification_popup,
        channel_notification_vibrate,
        channel_notification_importance,
        channel_notification_popup,
        in_app_vibrate,
        in_chat_sounds,
        importance,
        badge_counter_enable,
        badge_include_mute_chats,
        badge_count_unread_messages,
        event_contact_joined,
        event_pinned_messages,
        vibrate_voice_calls,
        cellular_auto_download,
        wifi_auto_download,
        video_auto_play,
        stream_videos_and_audio_files,
        keep_media,
        message_corner,
        chat_list_swipe_gesture,
        chat_list_view,
        auto_night_mode_type,
        scheduled_use_local_sunset,
        scheduled_from_time,
        scheduled_to_time,
        preferred_night_theme_id,
        adaptive_brightness_threshold,
        direct_share,
        enable_animation,
        save_to_gallery,
        send_by_enter,
        quick_reaction
    }

    public enum PopupObject {
        NoPopup,
        OnlyScreenOn,
        OnlyScreenOff,
        Always
    }

    public static class SetSettingOutput {
    }

    public static class SettingInput {
    }

    public static class StickerSettingObject {
        public SuggestTypeEnum suggest_stickers_by_emoji;

        public enum SuggestTypeEnum {
            All,
            MyStickers,
            None
        }
    }

    public static class ThemeBackgroundInput {
        public ColorObject chat_background_color;
        public BackGroundTypeEnum chat_background_type;
        public WallpaperIdObject chat_background_wallpaper;
        public String theme_id;
        public ThemeBackgroundTypeEnum type;
    }

    public enum ThemeBackgroundTypeEnum {
        System,
        ClientTheme
    }

    public static class ThemeObject {
        public boolean is_dark_theme;
        public String name;
        public ColorObject preview_background_color;
        public ColorObject preview_my_color;
        public ColorObject preview_peer_color;
        public ChatBackGroundObject theme_background;
        public String theme_id;
        public String theme_string;
    }

    public static class TimeObject {
        public int hour;
        public int minute;
    }

    public enum VibrateObject {
        Disabled,
        Default,
        Short,
        Long,
        OnlySilent
    }

    public static class WallpaperFileInline extends FileInlineObject {
        @Override // ir.aaap.messengercore.model.FileInlineObject
        public String getMime() {
            return "jpg";
        }
    }

    public static class WallpapersOutput {
        public ArrayList<ColorObject> chat_background_colors;
        public ArrayList<WallpaperObject> chat_background_wallpapers;
        public ArrayList<ThemeBackground> new_theme_backgrounds;
    }

    public static class SetSettingInput {
        public Map<String, Object> settings;
        public Set<String> update_parameters;

        public SetSettingInput(Map<String, Object> map) {
            this.settings = map;
            if (map != null) {
                this.update_parameters = map.keySet();
            }
        }
    }

    public static class AutoDownloadSettingObject {
        public boolean channels;
        public boolean contacts;
        public boolean groups;
        public long max_download_size;
        public boolean other_users;

        public long getMaxDownloadSize_in_B() {
            return this.max_download_size * 1024;
        }

        public void setMaxDownloadSize(long j) {
            this.max_download_size = j / 1024;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AutoDownloadSettingObject autoDownloadSettingObject = (AutoDownloadSettingObject) obj;
            return this.contacts == autoDownloadSettingObject.contacts && this.other_users == autoDownloadSettingObject.other_users && this.groups == autoDownloadSettingObject.groups && this.channels == autoDownloadSettingObject.channels && this.max_download_size == autoDownloadSettingObject.max_download_size;
        }
    }

    public static class AppearanceSettingObject {
        public int adaptive_brightness_threshold;
        public String auto_dark_theme_id;
        public String auto_day_theme_id;
        public AutoNightModeType auto_night_mode_type;
        public ChatBackGroundObject chat_background;
        public ChatListSwipeGestureType chat_list_swipe_gesture;
        public ChatListViewType chat_list_view;
        public boolean direct_share;
        public boolean enable_animation;
        public boolean large_emoji;
        public String manual_selected_theme_id;
        public int message_corner;
        public String preferred_night_theme_id;
        public ReactionObject quick_reaction;
        public boolean save_to_gallery;
        public TimeObject scheduled_from_time;
        public TimeObject scheduled_to_time;
        public boolean scheduled_use_local_sunset;
        public boolean send_by_enter;
        public int android_font_size = 15;
        public boolean gif_auto_play = true;
        public boolean auto_night_mode = false;
        public ArrayList<ThemeBackground> theme_backgrounds = new ArrayList<>();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AppearanceSettingObject)) {
                return false;
            }
            AppearanceSettingObject appearanceSettingObject = (AppearanceSettingObject) obj;
            return this.large_emoji == appearanceSettingObject.large_emoji && this.android_font_size == appearanceSettingObject.android_font_size && this.gif_auto_play == appearanceSettingObject.gif_auto_play && this.auto_night_mode == appearanceSettingObject.auto_night_mode && Objects.equalsArray(this.theme_backgrounds, appearanceSettingObject.theme_backgrounds) && Objects.equals(this.auto_dark_theme_id, appearanceSettingObject.auto_dark_theme_id) && Objects.equals(this.auto_day_theme_id, appearanceSettingObject.auto_day_theme_id) && Objects.equals(this.manual_selected_theme_id, appearanceSettingObject.manual_selected_theme_id);
        }

        public ThemeBackground getCurrentThemeBackGround() {
            ArrayList<ThemeBackground> arrayList = this.theme_backgrounds;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<ThemeBackground> it = this.theme_backgrounds.iterator();
                while (it.hasNext()) {
                    ThemeBackground next = it.next();
                    if (next.theme_id.equals(this.manual_selected_theme_id)) {
                        return next;
                    }
                }
            }
            return null;
        }
    }

    public static class ChatBackGroundObject {
        public ColorObject chat_background_color;
        public BackGroundTypeEnum chat_background_type;
        public WallpaperObject chat_background_wallpaper;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChatBackGroundObject)) {
                return false;
            }
            ChatBackGroundObject chatBackGroundObject = (ChatBackGroundObject) obj;
            return this.chat_background_type == chatBackGroundObject.chat_background_type && Objects.equals(this.chat_background_color, chatBackGroundObject.chat_background_color) && Objects.equals(this.chat_background_wallpaper, chatBackGroundObject.chat_background_wallpaper);
        }
    }

    public static class WallpaperObject {
        public WallpaperFileInline main;
        public AvatarFileInline thumbnail;
        public TypeEnum type;
        public String wallpaper_id;

        public enum TypeEnum {
            System,
            UserUploaded
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WallpaperObject)) {
                return false;
            }
            WallpaperObject wallpaperObject = (WallpaperObject) obj;
            return Objects.equals(this.wallpaper_id, wallpaperObject.wallpaper_id) && this.type == wallpaperObject.type && Objects.equals(this.thumbnail, wallpaperObject.thumbnail) && Objects.equals(this.main, wallpaperObject.main);
        }
    }

    public static class ThemeBackground {
        public ChatBackGroundObject chat_background;
        public String theme_id;
        public ThemeBackgroundTypeEnum type;

        public ThemeBackground(String str, ThemeBackgroundTypeEnum themeBackgroundTypeEnum, ChatBackGroundObject chatBackGroundObject) {
            this.theme_id = str;
            this.type = themeBackgroundTypeEnum;
            this.chat_background = chatBackGroundObject;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ThemeBackground)) {
                return false;
            }
            ThemeBackground themeBackground = (ThemeBackground) obj;
            return Objects.equals(this.theme_id, themeBackground.theme_id) && this.type == themeBackground.type && Objects.equals(this.chat_background, themeBackground.chat_background);
        }
    }

    public static class WallpaperIdObject {
        public String wallpaper_id;

        public WallpaperIdObject(String str) {
            this.wallpaper_id = str;
        }
    }
}
