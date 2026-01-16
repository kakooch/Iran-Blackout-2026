package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.MiniFunctionModels;
import ir.aaap.messengercore.model.ProductMessageData;
import ir.appp.vod.domain.model.VodBriefMediaEntity;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class Link {
    public EnumBannerAction action;
    public ActionData action_data;
    public AddBasketDataInLink addbasket_data;
    public AddShortcutDataInLink addshortcut_data;
    public AlertData alert_data;
    public AskAlertDataInLink ask_alert_data;
    public BarcodescanData barcodescan_data;
    public VodBriefMediaEntity brief_media;
    public MiniFunctionModels.ButtonCall call_data;
    public CallMessengerData call_messenger_data;
    public CardPageLinkData cardpage_data;
    public ChangeEnvDataInLink change_env_data;
    public CommandDataInLink commands_data;
    public String content_description;
    public CopyDataInLink copy_data;
    public String dynamic_page_object_id;
    public DynamicSearchDataInLink dynamic_search_data;
    public DynamicEndpointDataObject dynamicendpoint_data;
    public DynamicPageDataInLink dynamicpage_data;
    public EndPointData endpoint_data;
    public ExploreDataInLink explore_data;
    public ExploreTopicData explore_topic_data;
    public GetLocationData get_location_data;
    public GoBackDataInLink goback_data;
    public String hashtag_text;
    public HyperLinkData hyperlink_data;
    public Link if_supperted_link;
    public ImageViewerDataInLink image_viewer_data;
    public InlineOpenUrlObject inline_open_url_data;
    public InlineOpenUrlObject inline_open_url_with_access_data;
    public RubinoNewEventObject instaNewEventObject;
    public JoinChannelData joinchannel_data;
    public String link_chat_id;
    public Content link_content;
    public PredictLinkObject link_predict;
    public String link_service;
    public String link_service_title;
    public TagObject link_tag;
    public String link_url;
    public OpenStickerData localOpenStickerData;
    public Link not_supperted_link;
    public OpenChatDataObject open_chat_data;
    public OpenProfileChatDataObject open_chat_profile;
    public OpenInPackageDataInLink open_in_package_data;
    public OpenMessengerLiveData open_messenger_live_data;
    public String page;
    public PlayListDataInLink playlistplay_data;
    public ProductMessageLinkData product_message_data;
    public RubinoAddData rubino_add_data;
    public String rubinoexplore_topic_id;
    public RubinoPostDataInLink rubinopost_data;
    public SearchDataInLink search_data;
    public ShareDataInLink share_data;
    public MiniFunctionModels.ButtonSMS sms_data;
    public SuperLinkData superlink_data;
    public TagListData taglist_data;
    public ToastDataInLink toast_data;
    public String track_id;
    public LinkTypeEnum type = LinkTypeEnum.none;
    public ViewTagObject viewtag_data;
    public VodPlayDataInLink vodplay_data;
    public WebAppLink webapp_data;

    public enum AccuracyEnum {
        accurate,
        estimation
    }

    public static class AddShortcutDataInLink {
        public boolean ask_create;
        public String ask_dialog_text;
        public int icon_place_holder;
        public String icon_url;
        public String label;
        public Link link;
        public String shortcut_id;
    }

    public static class AlertData {
        public boolean has_link;
        public Link link;
        public String message;
    }

    public static class AskAlertDataInLink {
        public ArrayList<TextLinkObject> buttons;
        public String message;
    }

    public static class BarcodescanData {
        public String barcode;
        public boolean has_link;
        public Link link;
        public String link_title;
        public Link success_payment_return_link;
        public String success_payment_return_text;
        public String type;
        public String title = BuildConfig.FLAVOR;
        public String code_entry_message = BuildConfig.FLAVOR;
    }

    public static class CallMessengerData {
        public String peer_user_guid;
    }

    public static class CopyDataInLink {
        public String copy_text;
        public String toast_text;
    }

    public enum EnumBannerAction {
        invite,
        club,
        buycharge780,
        buyinternet780,
        paybill780,
        chats,
        card2card780,
        news,
        wc2018mypage,
        wc2018table,
        wc2018toplist,
        wc2018vote,
        tabrubino,
        myrubino,
        myprofile,
        mychat,
        chattab,
        settingtab,
        openPlayingMusic,
        mybasket,
        myaddresses,
        myorders,
        checkupdate,
        messengernotificationsetting,
        messengerprivacysetting,
        messengerdatasetting,
        messengerappearancesetting,
        rubinoglobalsetting,
        messengerstickersetting,
        rubinostorysetting,
        rubinomybookmarks,
        rubinomypurchases,
        rubinomysales,
        rubinomynotifications,
        mydevices
    }

    public static class ExploreTopicData {
        public String title;
        public String topic_id;
    }

    public static class GetLocationData {
        public AccuracyEnum accuracy;
        public Link success_link;
    }

    public static class HyperLinkData {
        public String url;
    }

    public static class InlineOpenUrlObject {
        public ArrayList<String> download_allowed_hosts;
        public String title;
        public String url;
        public boolean internal_back_enable = MyLog.isDebugAble;
        public boolean allow_access_file = false;
        public boolean allow_access_camera = false;
        public boolean allow_access_microphone = false;
    }

    public static class JoinChannelData {
        public boolean ask_join = false;
        public String username;
    }

    public enum LinkTypeEnum {
        cardpage,
        language,
        wallet,
        content,
        tag,
        url,
        page,
        action,
        none,
        service,
        alert,
        rubinoEvent,
        predict,
        taglist,
        viewtag,
        hashtag,
        endpoint,
        webapp,
        barcodescan,
        joinchannel,
        explore,
        exploretopic,
        superlink,
        call,
        sms,
        search,
        dynamicendpoint,
        vodplay,
        playlistplay,
        rubinopost,
        addbasket,
        goback,
        toast,
        share,
        dynamic_search,
        dynamicpage,
        addshortcut,
        imageviewer,
        changeenv,
        openinpackage,
        commands,
        askalert,
        copy,
        openchat,
        openchatprofile,
        inlineopenurl,
        inlineopenurlwithaccess,
        editname,
        savedmessages,
        editnameavatar,
        parentalcontrol,
        mycalls,
        mycontacts,
        getlocation,
        call_messenger,
        openmessengerlive,
        chatfolder,
        rubinoadd,
        dev,
        vod,
        new_vod,
        hyperlink,
        callout,
        productmessage,
        local_openMusicAlert,
        local_openStickerSet
    }

    public static class OpenMessengerLiveData {
        public String message_share_link;
        public boolean show_clean;
    }

    public static class OpenProfileChatDataObject {
        public String object_guid;
        public ChatType object_type;
    }

    public static class OpenStickerData {
        public String stickerSetId;
    }

    public static class ProductMessageLinkData {
        public boolean get_address_info;
        public String object_guid;
        public ChatType object_type;
        public String product_id;
        public ArrayList<ProductMessageData.ProductMessageVariety> product_varieties;
        public String store_id;
    }

    public static class RubinoAddData {
        public RubinoAddPostEnum type;
    }

    public enum RubinoAddPostEnum {
        Post,
        Story,
        Live,
        ClearCache
    }

    public static class ShareDataInLink {
        public String share_string;
        public TypeEnum type;

        public enum TypeEnum {
            Normal,
            Rubika
        }
    }

    public static class SuperLinkData {
        public ArrayList<SuperLinkViewObject> link_views;
        public String title;
    }

    public static class TagListData {
        public String taglist_id;
        public String title;
    }

    public static class ToastDataInLink {
        public int show_time;
        public String text;
    }

    public boolean isOpenExternalPage() {
        LinkTypeEnum linkTypeEnum = this.type;
        return linkTypeEnum == LinkTypeEnum.url || linkTypeEnum == LinkTypeEnum.hashtag || linkTypeEnum == LinkTypeEnum.explore || linkTypeEnum == LinkTypeEnum.dynamicendpoint || linkTypeEnum == LinkTypeEnum.rubinopost || linkTypeEnum == LinkTypeEnum.dynamic_search || linkTypeEnum == LinkTypeEnum.share || linkTypeEnum == LinkTypeEnum.service || linkTypeEnum == LinkTypeEnum.page || linkTypeEnum == LinkTypeEnum.sms || linkTypeEnum == LinkTypeEnum.call || linkTypeEnum == LinkTypeEnum.openchat || linkTypeEnum == LinkTypeEnum.openchatprofile;
    }

    public boolean isForRubino() {
        LinkTypeEnum linkTypeEnum = this.type;
        return linkTypeEnum == LinkTypeEnum.rubinoEvent || linkTypeEnum == LinkTypeEnum.rubinopost;
    }

    public static class SuperLinkViewObject extends PresenterItem {
        public String image_url;
        public Link link;
        public String text;

        @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
        public PresenterItemType getPresenterType() {
            return PresenterItemType.superLinkItem;
        }
    }

    public static class OpenChatDataObject {
        public long message_id;
        public String object_guid;
        public ChatType object_type;
        public boolean open_group_call;
        public boolean open_message;

        public OpenChatDataObject(String str, ChatType chatType) {
            this.object_guid = str;
            this.object_type = chatType;
        }
    }

    public static class TextLinkObject {
        public Link link;
        public String text;

        public TextLinkObject(String str, Link link) {
            this.text = str;
            this.link = link;
        }
    }
}
