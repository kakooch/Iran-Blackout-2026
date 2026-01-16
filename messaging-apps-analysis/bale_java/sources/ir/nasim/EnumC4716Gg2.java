package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Gg2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC4716Gg2 implements InterfaceC4314Ep2 {
    private static final /* synthetic */ EnumC4716Gg2[] K4;
    private static final /* synthetic */ F92 L4;
    public static final a b;
    private final String a;
    public static final EnumC4716Gg2 c = new EnumC4716Gg2("STORY_REPORT_ENABLED", 0, "jaryan.story_report.enabled");
    public static final EnumC4716Gg2 d = new EnumC4716Gg2("STORY_REACTION_ENABLED", 1, "jaryan.story_reaction.enabled");
    public static final EnumC4716Gg2 e = new EnumC4716Gg2("STORY_GET_POPULARITY", 2, "jaryan.story_get_popularity.enabled");
    public static final EnumC4716Gg2 f = new EnumC4716Gg2("STORY_VIDEO_STREAM_ENABLED", 3, "hengam.story_video_stream.enabled");
    public static final EnumC4716Gg2 g = new EnumC4716Gg2("STORY_RECORDER", 4, "hengam.recorder.enabled");
    public static final EnumC4716Gg2 h = new EnumC4716Gg2("STORY_PHOTO_EDITOR", 5, "hengam.photo_editor.enabled");
    public static final EnumC4716Gg2 i = new EnumC4716Gg2("VIDEO_PHOTO_EDITOR", 6, "hengam.video_editor.enabled");
    public static final EnumC4716Gg2 j = new EnumC4716Gg2("STORY_FOR_ADMIN_ENABLED", 7, "hengam.story_for_admin.enabled");
    public static final EnumC4716Gg2 k = new EnumC4716Gg2("STORY_TAG_SPECIAL_ENABLED", 8, "hengam.story_tag_special.enabled");
    public static final EnumC4716Gg2 l = new EnumC4716Gg2("STORY_VIEW_POST_ENABLED", 9, "hengam.story_view_post.enabled");
    public static final EnumC4716Gg2 m = new EnumC4716Gg2("STORY_ADD_POST_TO_STORY_ENABLED", 10, "hengam.story_add_post_to_story.enabled");
    public static final EnumC4716Gg2 n = new EnumC4716Gg2("NEW_MODEL_STORY_FOR_ADMIN_ENABLED", 11, "hengam.story_for_admin_new_model.enabled");
    public static final EnumC4716Gg2 o = new EnumC4716Gg2("DYNAMIC_POPULAR_STORY_ENABLED", 12, "hengam.dynamic_popular_story.enabled");
    public static final EnumC4716Gg2 p = new EnumC4716Gg2("HAFEZ_FAAL_IN_STORY_ENABLED", 13, "hengam.hafez_faal_in_story.enabled");
    public static final EnumC4716Gg2 q = new EnumC4716Gg2("STORY_NOTIFICATION_SETTINGS_ENABLED", 14, "farokhi.story_notification_settings.enabled");
    public static final EnumC4716Gg2 r = new EnumC4716Gg2("STORY_LIKE_NOTIFICATION_ENABLED", 15, "farokhi.story_like_notification.enabled");
    public static final EnumC4716Gg2 s = new EnumC4716Gg2("CHANNEL_STORY_NOTIFICATION_ENABLED", 16, "farokhi.channel_story_notification.enabled");
    public static final EnumC4716Gg2 t = new EnumC4716Gg2("STORY_SPECIALS_ENABLED", 17, "farokhi.story_specials.enabled");
    public static final EnumC4716Gg2 u = new EnumC4716Gg2("STORY_DOWNLOAD_REVERSE", 18, "farokhi.story_download_reverse.enabled");
    public static final EnumC4716Gg2 v = new EnumC4716Gg2("NEW_AUTO_DOWNLOAD", 19, "core.new_auto_download_settings.enabled");
    public static final EnumC4716Gg2 w = new EnumC4716Gg2("JARYAN_VIDEO_SEARCH_ENABLE", 20, "jaryan_video_search.enabled");
    public static final EnumC4716Gg2 x = new EnumC4716Gg2("ADD_COMMENT_TO_POST", 21, "farror.add_comment_to_post.enable");
    public static final EnumC4716Gg2 y = new EnumC4716Gg2("CHANGE_ENABLE_COMMENT", 22, "farror.change_enable_comment.enable");
    public static final EnumC4716Gg2 z = new EnumC4716Gg2("MARKET_AND_VITRINE_REPORT", 23, "report_market_vitrine.enable");
    public static final EnumC4716Gg2 A = new EnumC4716Gg2("MARKET_TAB_BADGE", 24, "akhavan.market.tab_badge.enabled");
    public static final EnumC4716Gg2 B = new EnumC4716Gg2("MARKET_UPDATE_TAB_BADGE", 25, "akhavan.market.update.tab_badge.enabled");
    public static final EnumC4716Gg2 D = new EnumC4716Gg2("MARKET_ONBOARDING", 26, "akhavan.market.onboarding.enabled");
    public static final EnumC4716Gg2 G = new EnumC4716Gg2("MARKET_SHUFFLED", 27, "akhavan.market.shuffled.enabled");
    public static final EnumC4716Gg2 H = new EnumC4716Gg2("MARKET_SEARCH", 28, "akhavan.market.search.enabled");
    public static final EnumC4716Gg2 J = new EnumC4716Gg2("MARKET_MORE_PRODUCT_CACHE_PAGINATION", 29, "akhavan.market.more.product.cache.pagination.enabled");
    public static final EnumC4716Gg2 Y = new EnumC4716Gg2("MARKET_MORE_PRODUCT_PAGINATION_TOAST", 30, "akhavan.market.more.product.pagination.toast.enabled");
    public static final EnumC4716Gg2 Z = new EnumC4716Gg2("MARKET_FOR_YOU_CATEGORY_FEEDBACK", 31, "akhavan.market.for.you.category.market.enabled");
    public static final EnumC4716Gg2 z0 = new EnumC4716Gg2("ARBAEEN_USSD_GET_VIEWERS_ENABLED", 32, "farokhi.arbaeen_ussd_get_viewers.enabled");
    public static final EnumC4716Gg2 A0 = new EnumC4716Gg2("RECOMMENDED_CHANNEL_ENABLE", 33, "recommended_channel.enabled");
    public static final EnumC4716Gg2 B0 = new EnumC4716Gg2("RECOMMENDED_CHANNEL_CHAT_ENABLE", 34, "recommended_channel_chat.enabled");
    public static final EnumC4716Gg2 C0 = new EnumC4716Gg2("SUGGESTION_CHANNELS_CHAT", 35, "jaryan.suggestion_channels_chat");
    public static final EnumC4716Gg2 D0 = new EnumC4716Gg2("MAGAZINE_SUGGEST_ENABLED", 36, "jaryan.magazine_suggest.enabled");
    public static final EnumC4716Gg2 E0 = new EnumC4716Gg2("MAGAZINE_SUGGEST_LIMIT_ENABLED", 37, "jaryan.magazine_suggest_limit.enabled");
    public static final EnumC4716Gg2 F0 = new EnumC4716Gg2("FEED_ENABLED", 38, "jaryan.feed.enabled");
    public static final EnumC4716Gg2 G0 = new EnumC4716Gg2("FEED_COMMENT_ENABLED", 39, "jaryan.feed_comment.enabled");
    public static final EnumC4716Gg2 H0 = new EnumC4716Gg2("FEED_CATEGORY_ENABLED", 40, "jaryan.feed_category.enabled");
    public static final EnumC4716Gg2 I0 = new EnumC4716Gg2("FEED_NEW_THUMBNAIL_ENABLED", 41, "jaryan.new_thumbnail.enabled");
    public static final EnumC4716Gg2 J0 = new EnumC4716Gg2("FEED_SEE_MORE_CONTENT_ENABLED", 42, "jaryan.feed_see_more_content.enabled");
    public static final EnumC4716Gg2 K0 = new EnumC4716Gg2("FEED_HIDING_SEARCHBAR_ENABLED", 43, "jaryan.feed_hiding_searchbar.enabled");
    public static final EnumC4716Gg2 L0 = new EnumC4716Gg2("IS_SHOW_UP_VOTERS", 44, "jaryan.is_show_up_voters.enabled");
    public static final EnumC4716Gg2 M0 = new EnumC4716Gg2("MAGAZINE_FULL_SCREEN_ENABLED", 45, "jaryan.magazine_full_screen.enabled");
    public static final EnumC4716Gg2 N0 = new EnumC4716Gg2("MAGAZINE_FULL_SCREEN_PHOTO_ENABLED", 46, "jaryan.magazine_full_screen_photo.enabled");
    public static final EnumC4716Gg2 O0 = new EnumC4716Gg2("MAGAZINE_FULL_SCREEN_VIDEO_ENABLED", 47, "jaryan.magazine_full_screen_video.enabled");
    public static final EnumC4716Gg2 P0 = new EnumC4716Gg2("MAGAZINE_FULL_SCREEN_TEXT_ENABLED", 48, "jaryan.magazine_full_screen_text.enabled");
    public static final EnumC4716Gg2 Q0 = new EnumC4716Gg2("MAGAZINE_FULL_SCREEN_GIF_ENABLED", 49, "jaryan.magazine_full_screen_gif.enabled");
    public static final EnumC4716Gg2 R0 = new EnumC4716Gg2("MAGAZINE_SIMILAR_POSTS", 50, "jaryan.magazine_similar_posts.enabled");
    public static final EnumC4716Gg2 S0 = new EnumC4716Gg2("CANCEL_STORY_PRELOAD_ON_MAGAZINE_SCROLL", 51, "jaryan.cancel_story_preload_on_magazine_scroll.enabled");
    public static final EnumC4716Gg2 T0 = new EnumC4716Gg2("POPULAR_LIKE_AND_VIEW_COUNT", 52, "farokhi.popular_like_and_view_count.enabled");
    public static final EnumC4716Gg2 U0 = new EnumC4716Gg2("SIMILLAR_POSTS_ONBOARDING_ANIMATION", 53, "jaryan.simillar_posts_onboarding_animation.enabled");
    public static final EnumC4716Gg2 V0 = new EnumC4716Gg2("SIMILAR_POSTS_FAKE_DRAG_ANIMATION_ENABLED", 54, "jaryan.similar_posts_fake_drag_animation.enabled");
    public static final EnumC4716Gg2 W0 = new EnumC4716Gg2("IS_ALBUM_UPVOTE_ENABLED", 55, "jaryan.album_upvote.enabled");
    public static final EnumC4716Gg2 X0 = new EnumC4716Gg2("MAGAZINE_EXOPLAYER_PRELOAD_ENABLED", 56, "jaryan.magazine_exoplayer_preload.enabled");
    public static final EnumC4716Gg2 Y0 = new EnumC4716Gg2("FULL_SCREEN_SKELETON_ENABLED", 57, "jaryan.feed_full_screen_skeleton.enabled");
    public static final EnumC4716Gg2 Z0 = new EnumC4716Gg2("SPONSORED_MESSAGE", 58, "farokhi.sponsored_message.enabled");
    public static final EnumC4716Gg2 a1 = new EnumC4716Gg2("CHANNEL_ADS_REPORT_ENABLED", 59, "farokhi.channel_ads_report.enabled");
    public static final EnumC4716Gg2 b1 = new EnumC4716Gg2("DIALOG_BANNER_SPOT_ONBOARDING", 60, "nahang.dialog_banner_spot_onboarding.enabled");
    public static final EnumC4716Gg2 c1 = new EnumC4716Gg2("AD_DISCOUNT_PROMOTION", 61, "nahang.ad_discount_promotion.enabled");
    public static final EnumC4716Gg2 d1 = new EnumC4716Gg2("IN_APP_MESSAGE", 62, "nahang.in_app_message.enabled");
    public static final EnumC4716Gg2 e1 = new EnumC4716Gg2("CUSTOM_EVENT_BAR", 63, "nahang.custom_event_bar.enabled");
    public static final EnumC4716Gg2 f1 = new EnumC4716Gg2("CARD_TO_CARD_BANNER_AD", 64, "nahang.card_to_card_banner_ad.enabled");
    public static final EnumC4716Gg2 g1 = new EnumC4716Gg2("DIALOG_BANNER_AD", 65, "nahang.dialog_banner_ad.enabled");
    public static final EnumC4716Gg2 h1 = new EnumC4716Gg2("DIALOG_AD_ANIMATED_TITLE_TEXT", 66, "nahang.dialog_ad_animated_title_text.enabled");
    public static final EnumC4716Gg2 i1 = new EnumC4716Gg2("DIALOG_AD_ANIMATED_CONTAINER", 67, "nahang.dialog_ad_animated_container.enabled");
    public static final EnumC4716Gg2 j1 = new EnumC4716Gg2("DIALOG_AD_ANIMATED_EMOJI", 68, "nahang.dialog_ad_animated_emoji.enabled");
    public static final EnumC4716Gg2 k1 = new EnumC4716Gg2("CLEAN_COMPOSE_TOP_SPOT_IN_OLD_DIALOG_LIST", 69, "nahang.clean_compose_top_spot_in_old_dialog_list.enabled");
    public static final EnumC4716Gg2 l1 = new EnumC4716Gg2("NEW_COMPOSE_ADD_CONTACT_SCREEN", 70, "nahang.new_compose_add_contact_screen.enabled");
    public static final EnumC4716Gg2 m1 = new EnumC4716Gg2("EDIT_GROUP_CALL_PERMISSIONS", 71, "graham.edit.group.call.permissions");
    public static final EnumC4716Gg2 n1 = new EnumC4716Gg2("END_GROUP_CALL_FOR_ADMIN", 72, "graham.admin.end.group.call");
    public static final EnumC4716Gg2 o1 = new EnumC4716Gg2("CALL_OPTIONS", 73, "graham.participant.options");
    public static final EnumC4716Gg2 p1 = new EnumC4716Gg2("SCREEN_ZOOM", 74, "graham.participant.zoom");
    public static final EnumC4716Gg2 q1 = new EnumC4716Gg2("START_GROUP_WITH_USERS_CALL", 75, "graham.call.group");
    public static final EnumC4716Gg2 r1 = new EnumC4716Gg2("CALL_LINK", 76, "graham.call.link");
    public static final EnumC4716Gg2 s1 = new EnumC4716Gg2("JOIN_CALL_FROM_LINK", 77, "graham.join.call.from.link");
    public static final EnumC4716Gg2 t1 = new EnumC4716Gg2("START_CALL_UPDATE_REF", 78, "graham.ref.startcall");
    public static final EnumC4716Gg2 u1 = new EnumC4716Gg2("REF_CALL_SURFACE", 79, "graham.ref.call.surface.enabled");
    public static final EnumC4716Gg2 v1 = new EnumC4716Gg2("CALL_RECORD", 80, "graham.feat.record.enabled");
    public static final EnumC4716Gg2 w1 = new EnumC4716Gg2("CALL_RECORD_SOUND", 81, "graham.feat.record.sound.enabled");
    public static final EnumC4716Gg2 x1 = new EnumC4716Gg2("DRAGGABLE_PARTICIPANT", 82, "graham.feat.draggable.enabled");
    public static final EnumC4716Gg2 y1 = new EnumC4716Gg2("SOFT_RECONNECT", 83, "graham.feat.softreconnect.enabled");
    public static final EnumC4716Gg2 z1 = new EnumC4716Gg2("ANDROID_14_FULL_SCREEN_PERMISSION", 84, "graham.feat.android14.dialog.enabled");
    public static final EnumC4716Gg2 A1 = new EnumC4716Gg2("NOTIFICATION_RING_SETTINGS", 85, "graham.feat.notification.ring.enabled");
    public static final EnumC4716Gg2 B1 = new EnumC4716Gg2("VIDEO_CALL_SURFACE_FIT", 86, "graham.feat.surface.fit.enabled");
    public static final EnumC4716Gg2 C1 = new EnumC4716Gg2("CALL_PREVIEW", 87, "graham.feat.call.preview.enabled");
    public static final EnumC4716Gg2 D1 = new EnumC4716Gg2("WEBRTC_METRICS", 88, "graham.feat.call.webrtc.metric.enabled");
    public static final EnumC4716Gg2 E1 = new EnumC4716Gg2("CALL_VIBRATE", 89, "graham.feat.call.vibration.enabled");
    public static final EnumC4716Gg2 F1 = new EnumC4716Gg2("GROUP_CALL_SYNC_MECHANISM", 90, "graham.feat.call.groupcall.sync");
    public static final EnumC4716Gg2 G1 = new EnumC4716Gg2("CALL_MEMBERS_LIST", 91, "graham.call.members.list.enabled");
    public static final EnumC4716Gg2 H1 = new EnumC4716Gg2("CALL_SHARE_SCREEN_ZOOM_ANIMATION_ENABLED", 92, "graham.call.share.screen.zoom.animation.enabled");
    public static final EnumC4716Gg2 I1 = new EnumC4716Gg2("START_CALL_PREVIEW", 93, "graham.start.call.preview");
    public static final EnumC4716Gg2 J1 = new EnumC4716Gg2("SHARE_SCREEN", 94, "graham.sharescreen.enabled");
    public static final EnumC4716Gg2 K1 = new EnumC4716Gg2("NEW_CALL_CONFIG", 95, "graham.callconfig.enabled");
    public static final EnumC4716Gg2 L1 = new EnumC4716Gg2("CALL_MONITORING", 96, "graham.callmonitoring.enabled");
    public static final EnumC4716Gg2 M1 = new EnumC4716Gg2("NEW_CALL_ESTABLISHED_METHOD", 97, "graham.new.established.enabled");
    public static final EnumC4716Gg2 N1 = new EnumC4716Gg2("ICE_CONNECTION_LOGS", 98, "graham.ice.connection.enabled");
    public static final EnumC4716Gg2 O1 = new EnumC4716Gg2("CUSTOM_SELECTION_CALLBACK_IN_BUBBLE", 99, "graham.ai.bubble.custom.selection");
    public static final EnumC4716Gg2 P1 = new EnumC4716Gg2("CUSTOM_SELECTION_CALLBACK_ASK_AI", 100, "graham.ai.ask.item.selection");
    public static final EnumC4716Gg2 Q1 = new EnumC4716Gg2("MORE_ITEM_BADGE_ENABLED", 101, "graham.moreitem.badge.enabled");
    public static final EnumC4716Gg2 R1 = new EnumC4716Gg2("VOICE_TO_TEXT", 102, "graham.ai.voice.to.text");
    public static final EnumC4716Gg2 S1 = new EnumC4716Gg2("VOICE_TO_TEXT_EVENT", 103, "graham.ai.voice.to.text.event");
    public static final EnumC4716Gg2 U1 = new EnumC4716Gg2("NEW_CALL_CORE", 104, "graham.new.switch.enabled");
    public static final EnumC4716Gg2 V1 = new EnumC4716Gg2("GENERAL_MESSAGE", 105, "graham.new.general_message.enabled");
    public static final EnumC4716Gg2 W1 = new EnumC4716Gg2("UNREAD_TAB", Type.L64, "messaging.dialog.unread_tab.enabled");
    public static final EnumC4716Gg2 X1 = new EnumC4716Gg2("SHOULD_INCLUDE_MUTE_DIALOGS_IN_UNREAD_TAB", 107, "messaging.dialog.should_include_mute_dialogs_in_unread_tab.enabled");
    public static final EnumC4716Gg2 Y1 = new EnumC4716Gg2("CHECKBOX_IN_GENERAL_MESSAGE", Type.EUI48, "graham.new.check_box_general_message.enabled");
    public static final EnumC4716Gg2 Z1 = new EnumC4716Gg2("AI_TAB_ENABLED", 109, "graham.new.ai_tab.enabled");
    public static final EnumC4716Gg2 a2 = new EnumC4716Gg2("AI_TAB_BOT_ENABLED", 110, "graham.new.ai_bot_in_tab.enabled");
    public static final EnumC4716Gg2 b2 = new EnumC4716Gg2("MULTI_ACCOUNT", WKSRecord.Service.SUNRPC, "core.multi.account.enabled");
    public static final EnumC4716Gg2 c2 = new EnumC4716Gg2("IN_ACTIVE_NOTIFICATION_MULTI_ACCOUNT", SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, "core.multi.account.inactive.account.notification");
    public static final EnumC4716Gg2 d2 = new EnumC4716Gg2("SECURITY_SETTINGS_REDESIGN", 113, "core.security_settings_redesign.enabled");
    public static final EnumC4716Gg2 e2 = new EnumC4716Gg2("NOTIFICATION_SETTINGS_REDESIGN", 114, "core.notification_settings_redesign.enabled");
    public static final EnumC4716Gg2 f2 = new EnumC4716Gg2("SENTRY_MONITORING", 115, "core.sentry_monitoring.enabled");
    public static final EnumC4716Gg2 g2 = new EnumC4716Gg2("NEW_STORAGE_MANAGER", 116, "core.settings.storage_manager.enabled");
    public static final EnumC4716Gg2 h2 = new EnumC4716Gg2("NEW_ENDPOINTS", WKSRecord.Service.UUCP_PATH, "core.settings.new_endpoints.enabled");
    public static final EnumC4716Gg2 i2 = new EnumC4716Gg2("PREMIUM", SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER, "core.premium.enabled");
    public static final EnumC4716Gg2 j2 = new EnumC4716Gg2("BADGE_VIEWER", 119, "core.premium.view.badge.enabled");
    public static final EnumC4716Gg2 k2 = new EnumC4716Gg2("BADGE_SETTER", SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, "core.premium.set.badge.enabled");
    public static final EnumC4716Gg2 l2 = new EnumC4716Gg2("BADGE_ANIMATION_IN_DIALOG_LIST", WKSRecord.Service.ERPC, "core.premium.badge.animation.enabled");
    public static final EnumC4716Gg2 m2 = new EnumC4716Gg2("MXP", 122, "bala.mxb.enabled");
    public static final EnumC4716Gg2 n2 = new EnumC4716Gg2("ARCHIVE", 123, "messenger.archive.enabled");
    public static final EnumC4716Gg2 o2 = new EnumC4716Gg2("MXP_UI", 124, "bala.mxp_ui.enabled");
    public static final EnumC4716Gg2 p2 = new EnumC4716Gg2("BANNED_MESSAGE", 125, "messenger.banned.bubble.enable");
    public static final EnumC4716Gg2 q2 = new EnumC4716Gg2("REPLIES_LIST", 126, "messenger.show_replies_list.enabled");
    public static final EnumC4716Gg2 r2 = new EnumC4716Gg2("PRIVATE_PINNED_MESSAGE", 127, "messenger.private.pinned.message.enabled");
    public static final EnumC4716Gg2 s2 = new EnumC4716Gg2("ANONYMOUS_CONTACT_WARNING", 128, "messenger.anonymous_contact.enabled");
    public static final EnumC4716Gg2 t2 = new EnumC4716Gg2("ADD_MESSAGE_ITEM_ANIMATION", 129, "messenger.add_message_item_animation.enabled");
    public static final EnumC4716Gg2 u2 = new EnumC4716Gg2("MUTUAL_GROUP", 130, "messenger.mutual_group.enabled");
    public static final EnumC4716Gg2 v2 = new EnumC4716Gg2("NEW_CONTACT_BUBBLE", 131, "messenger.new_contact_bubble.enabled");
    public static final EnumC4716Gg2 w2 = new EnumC4716Gg2("POLL_ENABLED", WKSRecord.Service.CISCO_SYS, "messenger.poll.enabled");
    public static final EnumC4716Gg2 x2 = new EnumC4716Gg2("DRAFT_INTERVAL_ENABLED", WKSRecord.Service.STATSRV, "messenger.draft_interval.enabled");
    public static final EnumC4716Gg2 y2 = new EnumC4716Gg2("NEW_FORWARD_MODAL", 134, "messenger.new_forward_modal.enabled");
    public static final EnumC4716Gg2 z2 = new EnumC4716Gg2("IMPROVED_CHAT_PERFORMANCE_ENABLED", 135, "messenger.improved.chat.performance.enabled");
    public static final EnumC4716Gg2 A2 = new EnumC4716Gg2("CACHE_CHAT_LIST_PROCESSOR_ENABLED", 136, "messenger.cache.chat.list.processor.enabled");
    public static final EnumC4716Gg2 B2 = new EnumC4716Gg2("IN_APP_UPDATE", 137, "messenger.in_app_update.enabled");
    public static final EnumC4716Gg2 C2 = new EnumC4716Gg2("SERVICE_TOOLTIP", WKSRecord.Service.NETBIOS_DGM, "messenger.services_tooltip.enabled");
    public static final EnumC4716Gg2 D2 = new EnumC4716Gg2("MENTION_WITHOUT_NICKNAME", WKSRecord.Service.NETBIOS_SSN, "messenger.mention_without_nickname.enabled");
    public static final EnumC4716Gg2 E2 = new EnumC4716Gg2("NEW_VOICE_RECORDER_CORE", WKSRecord.Service.EMFIS_DATA, "file.new_voice_recorder_core.enabled");
    public static final EnumC4716Gg2 F2 = new EnumC4716Gg2("NEW_VOICE_RECORDER", WKSRecord.Service.EMFIS_CNTL, "file.new_voice_recorder.enabled");
    public static final EnumC4716Gg2 G2 = new EnumC4716Gg2("PHOTO_EDITOR", WKSRecord.Service.BL_IDM, "photo_editor.enabled");
    public static final EnumC4716Gg2 H2 = new EnumC4716Gg2("MEDIA_VIEWER_NEW_CAPTION", SetRpcStruct$ComposedRpc.GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER, "file.media_viewer_catpin.enabled");
    public static final EnumC4716Gg2 I2 = new EnumC4716Gg2("SHARE_INTENT_HANDLER", SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER, "file.share_intent_handler.enabled");
    public static final EnumC4716Gg2 J2 = new EnumC4716Gg2("NEW_GALLERY_IN_SHARED_MEDIA", SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER, "messenger.new_gallery_in_shared_media.enabled");
    public static final EnumC4716Gg2 K2 = new EnumC4716Gg2("NEW_MEDIA_VIEWER", SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_CONTEXT_FIELD_NUMBER, "sabalan.new_media_viewer.enabled");
    public static final EnumC4716Gg2 L2 = new EnumC4716Gg2("NEW_MEDIA_VIEWER_GIF", 147, "file.new_media_viewer_gif.enabled");
    public static final EnumC4716Gg2 M2 = new EnumC4716Gg2("ASYNC_LAST_PUT_UPLOAD", 148, "file.async_last_put_upload.enabled");
    public static final EnumC4716Gg2 N2 = new EnumC4716Gg2("DYNAMIC_CHUNK_UPLOADER", 149, "file.dynamic_chunk_uploader.enabled");
    public static final EnumC4716Gg2 O2 = new EnumC4716Gg2("UPLOAD_MULTIPLE_QUEUE", 150, "file.upload_multiple_queue.enabled");
    public static final EnumC4716Gg2 P2 = new EnumC4716Gg2("NEW_DOWNLOAD_MANAGER", 151, "file.new_download_manager.enabled");
    public static final EnumC4716Gg2 Q2 = new EnumC4716Gg2("NEW_DOWNLOAD_MANAGER_FOR_CHAT", 152, "file.new_download_manager_for_chat.enabled");
    public static final EnumC4716Gg2 R2 = new EnumC4716Gg2("UPLOAD_SERVICE", SetRpcStruct$ComposedRpc.GET_GROUP_STATE_FIELD_NUMBER, "file.upload_service.enabled");
    public static final EnumC4716Gg2 S2 = new EnumC4716Gg2("CONCURRENT_COMPRESS_AND_UPLOAD", 154, "file.concurrent_compress_and_upload.enabled");
    public static final EnumC4716Gg2 T2 = new EnumC4716Gg2("STORY_NEW_COMPRESSION_CONFIG", 155, "file.story_new_compression_config.enabled");
    public static final EnumC4716Gg2 U2 = new EnumC4716Gg2("LIVE_DEEP_LINK", 156, "file.live_deep_link.enabled");
    public static final EnumC4716Gg2 V2 = new EnumC4716Gg2("LIVE_BOT", SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER, "file.live_bot.enabled");
    public static final EnumC4716Gg2 W2 = new EnumC4716Gg2("DYNAMIC_EXO_LOAD_CONTROL", 158, "file.exoplayer_dynamic_load_control");
    public static final EnumC4716Gg2 X2 = new EnumC4716Gg2("LIVE_BUBBLE", 159, "file.LIVE_BUBBLE.enabled");
    public static final EnumC4716Gg2 Y2 = new EnumC4716Gg2("SERVICES_PAGE_WEB_VIEW_PRELOAD", 160, "services.services_page_web_view_preload.enabled");
    public static final EnumC4716Gg2 Z2 = new EnumC4716Gg2("SERVICES_PAGE_EVENTS", SetUpdatesStruct$ComposedUpdates.OWN_STICKERS_CHANGED_FIELD_NUMBER, "services.services_page_events.enabled");
    public static final EnumC4716Gg2 a3 = new EnumC4716Gg2("SPA_WEBVIEW_CACHE", SetUpdatesStruct$ComposedUpdates.MESSAGE_CONTENT_CHANGED_FIELD_NUMBER, "services.spa_webview_cache.enabled");
    public static final EnumC4716Gg2 b3 = new EnumC4716Gg2("BOT_CAN_SEE_GROUP_MESSAGES_STATUS", SetUpdatesStruct$ComposedUpdates.MESSAGE_DATE_CHANGED_FIELD_NUMBER, "services.bot_can_see_group_messages.enabled");
    public static final EnumC4716Gg2 c3 = new EnumC4716Gg2("BOT_ADD_TO_HOME_SCREEN", SetUpdatesStruct$ComposedUpdates.STICKER_COLLECTIONS_CHANGED_FIELD_NUMBER, "services.bot_add_to_home_screen.enabled");
    public static final EnumC4716Gg2 d3 = new EnumC4716Gg2("SHOULD_USE_NEW_UNREAD_PEERS_MODEL", 165, "messaging.dialog.should_use_new_unread_peers_model.enabled");
    public static final EnumC4716Gg2 e3 = new EnumC4716Gg2("CHANGE_BOT_VIEW_GROUP_MESSAGES_STATUS", 166, "services.bot_ask_for_view_group_messages.enabled");
    public static final EnumC4716Gg2 f3 = new EnumC4716Gg2("WEB_APP_SEND_PHONE_NUMBER", 167, "services.webapp.send_phone_number.enabled");
    public static final EnumC4716Gg2 g3 = new EnumC4716Gg2("WEB_APP_CAMERA_PERMISSION_JUST_FOR_VERIFIED_BOT_ENABLED", 168, "services.webapp.camera_permission_for_verified_bot.enabled");
    public static final EnumC4716Gg2 h3 = new EnumC4716Gg2("WEB_APP_RECORD_AUDIO_PERMISSION_JUST_FOR_VERIFIED_BOT_ENABLED", SetUpdatesStruct$ComposedUpdates.MESSAGE_QUOTED_CHANGED_FIELD_NUMBER, "services.webapp.microphone_permission_for_verified_bot.enabled");
    public static final EnumC4716Gg2 i3 = new EnumC4716Gg2("WEB_APP_LOCATION_PERMISSION_JUST_FOR_VERIFIED_BOT_ENABLED", 170, "services.webapp.location_permission_for_verified_bot.enabled");
    public static final EnumC4716Gg2 j3 = new EnumC4716Gg2("WEB_APP_PERMISSION_LOCATION", 171, "services.webapp.permission_location.enabled");
    public static final EnumC4716Gg2 k3 = new EnumC4716Gg2("WEB_APP_PERMISSION_CAMERA", 172, "services.webapp.permission_camera.enabled");
    public static final EnumC4716Gg2 l3 = new EnumC4716Gg2("WEB_APP_PERMISSION_RECORD_AUDIO", 173, "services.webapp.permission_microphone.enabled");
    public static final EnumC4716Gg2 m3 = new EnumC4716Gg2("WEB_APP_MINIMIZE_VIEW", 174, "services.webapp.minimize_view.enabled");
    public static final EnumC4716Gg2 n3 = new EnumC4716Gg2("WEB_APP_ERROR_SCREEN", 175, "services.webapp.error_screen.enabled");
    public static final EnumC4716Gg2 o3 = new EnumC4716Gg2("WEB_APP_OPEN_INVOICE", 176, "services.webapp.open_invoice.enabled");
    public static final EnumC4716Gg2 p3 = new EnumC4716Gg2("WEB_APP_SHOW_BOT_CAN_SEND_MESSAGE_DIALOG", SetRpcStruct$ComposedRpc.GET_GROUP_INVITE_URL_FIELD_NUMBER, "services.webapp.show_bot_can_send_message_dialog.enabled");
    public static final EnumC4716Gg2 q3 = new EnumC4716Gg2("PASSPORT", SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER, "services.passport.enabled");
    public static final EnumC4716Gg2 r3 = new EnumC4716Gg2("APP_RATING", SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER, "services.app_rating.enabled");
    public static final EnumC4716Gg2 s3 = new EnumC4716Gg2("SHOW_DONT_SHOW_AGAIN_CHECK_BOX_IN_APP_RATING", SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER, "services.show_dont_show_again_check_box_in_app_rating.enabled");
    public static final EnumC4716Gg2 t3 = new EnumC4716Gg2("NEED_TO_UPDATE_FOR_EDIT_PASSPORT", SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER, "services.need_to_update_for_edit_passport.enabled");
    public static final EnumC4716Gg2 u3 = new EnumC4716Gg2("AUTHENTICATOR", 182, "services.authenticator.enabled");
    public static final EnumC4716Gg2 v3 = new EnumC4716Gg2("PASSWORD_ENABLED", 183, "services.password_enabled");
    public static final EnumC4716Gg2 w3 = new EnumC4716Gg2("IS_DISABLE_PASSWORD_ENABLED", 184, "services.is_disable_password_enabled");
    public static final EnumC4716Gg2 x3 = new EnumC4716Gg2("AUTHENTICATOR_BOT_INLINE_BUTTON", 185, "services.authenticator_bot_inline_button.enabled");
    public static final EnumC4716Gg2 y3 = new EnumC4716Gg2("PROTECTED_MESSAGE", 186, "services.protected_message.enabled");
    public static final EnumC4716Gg2 z3 = new EnumC4716Gg2("PROTECTED_MESSAGE_TEXT_TYPE", SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER, "services.protected_message_text_type.enabled");
    public static final EnumC4716Gg2 A3 = new EnumC4716Gg2("PROTECTED_MESSAGE_PHOTO_TYPE", 188, "services.protected_message_photo_type.enabled");
    public static final EnumC4716Gg2 B3 = new EnumC4716Gg2("PROTECTED_MESSAGE_DOCUMENT_TYPE", SetRpcStruct$ComposedRpc.VALIDATE_CODE_FIELD_NUMBER, "services.protected_message_document_type.enabled");
    public static final EnumC4716Gg2 C3 = new EnumC4716Gg2("PROTECTED_MESSAGE_TEMPLATE_BTN_TYPE", SetRpcStruct$ComposedRpc.SIGN_UP_FIELD_NUMBER, "services.protected_message_template_btn_type.enabled");
    public static final EnumC4716Gg2 D3 = new EnumC4716Gg2("REPLY_MARKUP_SHOW_UNSUPPORTED", SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER, "services.reply_markup_show_unsupported.enabled");
    public static final EnumC4716Gg2 E3 = new EnumC4716Gg2("SHOW_REPLY_MARKUP_WHEN_CHAT_OPENS", 192, "services.show_reply_markup_when_chat_opens");
    public static final EnumC4716Gg2 F3 = new EnumC4716Gg2("INLINE_SHOW_UNSUPPORTED", SetRpcStruct$ComposedRpc.RESPONSE_START_PHONE_AUTH_FIELD_NUMBER, "services.inline_show_unsupported.enabled");
    public static final EnumC4716Gg2 G3 = new EnumC4716Gg2("SEND_START_FOR_WHITELIST_BOTS_WITH_DEEPLINK", 194, "services.send_start_for_whitelist_bots_with_deeplink");
    public static final EnumC4716Gg2 H3 = new EnumC4716Gg2("BOT_INTRO_MESSAGE", 195, "services.bot_intro_message");
    public static final EnumC4716Gg2 I3 = new EnumC4716Gg2("BOT_INTRO_ABOUT_PLACEHOLDER", 196, "services.bot_intro_about_placeholder");
    public static final EnumC4716Gg2 J3 = new EnumC4716Gg2("BOT_RECOMMENDED_PEER", 197, "services.bot_recommended_peer");
    public static final EnumC4716Gg2 K3 = new EnumC4716Gg2("BOT_REVIEW", 198, "services.bot_review");
    public static final EnumC4716Gg2 L3 = new EnumC4716Gg2("BOT_STORY", 199, "services.bot_add_story");
    public static final EnumC4716Gg2 M3 = new EnumC4716Gg2("WEB_APP_SHOW_BOT_TERM_OF_USE_AGREEMENT", 200, "services.webapp.show_bot_term_of_use_agreement.enabled");
    public static final EnumC4716Gg2 N3 = new EnumC4716Gg2("TIMCHE_PROFILE_BUTTON", 201, "services.timche_profile_button");
    public static final EnumC4716Gg2 O3 = new EnumC4716Gg2("GENERIC_DEEP_LINKS", 202, "himalia.generic_deep_links.enabled");
    public static final EnumC4716Gg2 P3 = new EnumC4716Gg2("PRELOAD_JWT_TOKEN", 203, "himalia.preload_jwt_token.enabled");
    public static final EnumC4716Gg2 Q3 = new EnumC4716Gg2("SHAPARAK_AUTHENTICATION_BY_CARD_REGISTRATION", SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_DIFFERENCE_FIELD_NUMBER, "akhavan.get_shaparak_public_key_by_card_registration.enabled");
    public static final EnumC4716Gg2 R3 = new EnumC4716Gg2("CARD_PAYMENT_ACTIVITY_CARD_DETAILS_ENABLED", SetRpcStruct$ComposedRpc.EDIT_NICK_NAME_FIELD_NUMBER, "akhavan.card_details.activity.enabled");
    public static final EnumC4716Gg2 S3 = new EnumC4716Gg2("CARD_PAYMENT_ACTIVITY_CARD_CVV2_DETAILS_ENABLED", SetRpcStruct$ComposedRpc.CHECK_NICK_NAME_FIELD_NUMBER, "akhavan.card_cvv2_details.activity.enabled");
    public static final EnumC4716Gg2 T3 = new EnumC4716Gg2("CROWDFUNDING_NO_LIMIT_AMOUNT", 207, "akhavan.crowdfunding.no_limit_amount");
    public static final EnumC4716Gg2 U3 = new EnumC4716Gg2("BALANCE_HIDE_OTP", 208, "akhavan.balance_hide_otp");
    public static final EnumC4716Gg2 V3 = new EnumC4716Gg2("STATEMENT_HIDE_OTP", 209, "akhavan.statement_hide_otp");
    public static final EnumC4716Gg2 W3 = new EnumC4716Gg2("CHARGE_BOT_BUTTON", 210, "akhavan.charge.bot.button.enabled");
    public static final EnumC4716Gg2 X3 = new EnumC4716Gg2("INTERNET_BOT_BUTTON", 211, "akhavan.internet.bot.button.enabled");
    public static final EnumC4716Gg2 Y3 = new EnumC4716Gg2("CARD_PAYMENT_MELLI_CARD_PERCENTAGE", 212, "akhavan.card_payment_melli_card_percentage.enabled");
    public static final EnumC4716Gg2 Z3 = new EnumC4716Gg2("CARD_PAYMENT_FORCE_ERROR_MESSAGE_HANDLER", 213, "akhavan.cardpayment.force.error.message.handler_enable");
    public static final EnumC4716Gg2 a4 = new EnumC4716Gg2("MYBANK_BOOK_FAIR", SetUpdatesStruct$ComposedUpdates.GROUP_ABOUT_CHANGED_OBSOLETE_FIELD_NUMBER, "akhavan.mybank.book.fair.enabled");
    public static final EnumC4716Gg2 b4 = new EnumC4716Gg2("MYBANK_QRCODE_SCANNER", 215, "akhavan.mybank.qrcode.scanner.enabled");
    public static final EnumC4716Gg2 c4 = new EnumC4716Gg2("ALBUM_MONEY_REQUEST", 216, "akhavan.album_money.request.enabled");
    public static final EnumC4716Gg2 d4 = new EnumC4716Gg2("NEW_GIFT_PACKET", 217, "jaryan.new_gift_packet.enable");
    public static final EnumC4716Gg2 e4 = new EnumC4716Gg2("CACHE_WEBVIEW", 218, "farokhi.webview.cache");
    public static final EnumC4716Gg2 f4 = new EnumC4716Gg2("ROOT_DETECTION", 219, "messenger.root_detector.enabled");
    public static final EnumC4716Gg2 g4 = new EnumC4716Gg2("AVATAR_REACTION_FOR_FORWARDED_MESSAGE", SetRpcStruct$ComposedRpc.MESSAGE_REMOVE_REACTION_FIELD_NUMBER, "messaging.avatar_reaction_for_forwarded_message.enabled");
    public static final EnumC4716Gg2 h4 = new EnumC4716Gg2("PUBLIC_GROUPS", 221, "messaging.public_group.enabled");
    public static final EnumC4716Gg2 i4 = new EnumC4716Gg2("ADD_BOT_TO_GROUP", 222, "messaging.add_bot_to_group.enabled");
    public static final EnumC4716Gg2 j4 = new EnumC4716Gg2("RECOMMENDED_GROUP_ENABLE", 223, "recommended_group.enabled");
    public static final EnumC4716Gg2 k4 = new EnumC4716Gg2("SEARCH_GROUP_RECOMMEND", 224, "messaging.search_group_recommended.enabled");
    public static final EnumC4716Gg2 l4 = new EnumC4716Gg2("NEW_MENTION", 225, "messaging.new_group_mention.enabled");
    public static final EnumC4716Gg2 m4 = new EnumC4716Gg2("AVATAR_SEEN", 226, "messaging.avatar_seen_list.enabled");
    public static final EnumC4716Gg2 n4 = new EnumC4716Gg2("NEW_DIALOG_LIST_ENABLED", SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER, "messaging.new_dialoglist_design.enabled");
    public static final EnumC4716Gg2 o4 = new EnumC4716Gg2("LINK_STATUS_VALIDATION_ENABLED", SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_REMOVED_FIELD_NUMBER, "messaging.link.status.validation.enabled");
    public static final EnumC4716Gg2 p4 = new EnumC4716Gg2("FORMAL_DIALOGS_MAX_UNREAD_COUNT_ENABLED", SetRpcStruct$ComposedRpc.NOTIFY_ABOUT_DEVICE_INFO_FIELD_NUMBER, "messaging.formal_dialogs_max_unread_count.enabled");
    public static final EnumC4716Gg2 q4 = new EnumC4716Gg2("TWO_F_A", SetRpcStruct$ComposedRpc.CREATE_GROUP_FIELD_NUMBER, "messaging.two_f_a.enabled");
    public static final EnumC4716Gg2 r4 = new EnumC4716Gg2("DIALOG_MENTIONS", 231, "messaging.dialog_mention.enabled");
    public static final EnumC4716Gg2 s4 = new EnumC4716Gg2("DIALOG_REACTION", 232, "messaging.dialog_reaction.enabled");
    public static final EnumC4716Gg2 t4 = new EnumC4716Gg2("SEARCH_FILE_ENABLED", SetRpcStruct$ComposedRpc.SEARCH_PEER_FIELD_NUMBER, "messaging.search_file.enabled");
    public static final EnumC4716Gg2 u4 = new EnumC4716Gg2("CONTACT_REGISTER_MARK_AS_READ", SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_PEER_FIELD_NUMBER, "messaging.contact_register_mark_as_read.enabled");
    public static final EnumC4716Gg2 v4 = new EnumC4716Gg2("CHECK_BOX_MARK_DOWN", SetRpcStruct$ComposedRpc.RESPONSE_DIALOGS_ORDER_FIELD_NUMBER, "messaging.check_box_mark_down.enabled");
    public static final EnumC4716Gg2 w4 = new EnumC4716Gg2("CUSTOM_ACTION_INPUT_BAR_EDITOR", 236, "messaging.custom_action_bar_editor.enabled");
    public static final EnumC4716Gg2 x4 = new EnumC4716Gg2("STORY_IN_DIALOG_LIST", 237, "messaging.story_in_dialog_list.enabled");
    public static final EnumC4716Gg2 y4 = new EnumC4716Gg2("MARK_AS_UNREAD", SetRpcStruct$ComposedRpc.LOAD_OWN_STICKERS_FIELD_NUMBER, "messaging.mark_as_unread.enabled");
    public static final EnumC4716Gg2 z4 = new EnumC4716Gg2("GOLD_PACKET", SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER, "messaging.gold_packet_wallet.enabled");
    public static final EnumC4716Gg2 A4 = new EnumC4716Gg2("GOLD_PACKET_BUBBLE", SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, "messaging.gold_packet_bubble.enabled");
    public static final EnumC4716Gg2 B4 = new EnumC4716Gg2("SUGGEST_SERVICE_BANNER", 241, "messaging.suggest_service_banner.enabled");
    public static final EnumC4716Gg2 C4 = new EnumC4716Gg2("GOLD_KYC", 242, "messaging.gold_kyc.enabled");
    public static final EnumC4716Gg2 D4 = new EnumC4716Gg2("PERSONAL_NAME", WKSRecord.Service.SUR_MEAS, "messaging.personal_name.enabled");
    public static final EnumC4716Gg2 E4 = new EnumC4716Gg2("NEW_CONTACT", SetRpcStruct$ComposedRpc.ADD_STICKER_COLLECTION_FIELD_NUMBER, "messaging.new_contact_design.enabled");
    public static final EnumC4716Gg2 F4 = new EnumC4716Gg2("TOP_PEER", 245, "messaging.top_peer.enabled");
    public static final EnumC4716Gg2 G4 = new EnumC4716Gg2("EMPTY_STATE_ONBOARDING_ENABLED", SetRpcStruct$ComposedRpc.LOAD_STICKER_COLLECTION_FIELD_NUMBER, "messaging.empty_state_onboarding.enabled");
    public static final EnumC4716Gg2 H4 = new EnumC4716Gg2("EMPTY_STATE_CONTACTS_ONBOARDING_ENABLED", SetRpcStruct$ComposedRpc.RESPONSE_LOAD_STICKER_COLLECTION_FIELD_NUMBER, "messaging.empty_state_contacts_onboarding.enabled");
    public static final EnumC4716Gg2 I4 = new EnumC4716Gg2("NEW_SEARCH_DESIGN", 248, "messaging.new_search_design.enabled");
    public static final EnumC4716Gg2 J4 = new EnumC4716Gg2("NEW_CONNECTION_MANAGER", 249, "messaging.new.connection_manager");

    /* renamed from: ir.nasim.Gg2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC4716Gg2[] enumC4716Gg2ArrA = a();
        K4 = enumC4716Gg2ArrA;
        L4 = G92.a(enumC4716Gg2ArrA);
        b = new a(null);
    }

    private EnumC4716Gg2(String str, int i5, String str2) {
        this.a = str2;
    }

    private static final /* synthetic */ EnumC4716Gg2[] a() {
        return new EnumC4716Gg2[]{c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, D, G, H, J, Y, Z, z0, A0, B0, C0, D0, E0, F0, G0, H0, I0, J0, K0, L0, M0, N0, O0, P0, Q0, R0, S0, T0, U0, V0, W0, X0, Y0, Z0, a1, b1, c1, d1, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1, q1, r1, s1, t1, u1, v1, w1, x1, y1, z1, A1, B1, C1, D1, E1, F1, G1, H1, I1, J1, K1, L1, M1, N1, O1, P1, Q1, R1, S1, U1, V1, W1, X1, Y1, Z1, a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m2, n2, o2, p2, q2, r2, s2, t2, u2, v2, w2, x2, y2, z2, A2, B2, C2, D2, E2, F2, G2, H2, I2, J2, K2, L2, M2, N2, O2, P2, Q2, R2, S2, T2, U2, V2, W2, X2, Y2, Z2, a3, b3, c3, d3, e3, f3, g3, h3, i3, j3, k3, l3, m3, n3, o3, p3, q3, r3, s3, t3, u3, v3, w3, x3, y3, z3, A3, B3, C3, D3, E3, F3, G3, H3, I3, J3, K3, L3, M3, N3, O3, P3, Q3, R3, S3, T3, U3, V3, W3, X3, Y3, Z3, a4, b4, c4, d4, e4, f4, g4, h4, i4, j4, k4, l4, m4, n4, o4, p4, q4, r4, s4, t4, u4, v4, w4, x4, y4, z4, A4, B4, C4, D4, E4, F4, G4, H4, I4, J4};
    }

    public static F92 j() {
        return L4;
    }

    public static EnumC4716Gg2 valueOf(String str) {
        return (EnumC4716Gg2) Enum.valueOf(EnumC4716Gg2.class, str);
    }

    public static EnumC4716Gg2[] values() {
        return (EnumC4716Gg2[]) K4.clone();
    }

    @Override // ir.nasim.InterfaceC4314Ep2
    public String getValue() {
        return this.a;
    }

    public String p() {
        return "app.android." + this.a;
    }
}
