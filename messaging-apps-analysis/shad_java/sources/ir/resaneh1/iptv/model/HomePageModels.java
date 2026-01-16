package ir.resaneh1.iptv.model;

import androidMessenger.proxy.CallProxy$$ExternalSyntheticBackport0;
import androidMessenger.utilites.MyLog;
import ir.resaneh1.iptv.model.CardViewObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class HomePageModels {

    public static class BorderInfoObject {
        public float radius;
        public BorderShadowObject shadow;
        public BorderInfoType type;
    }

    public enum BorderInfoType {
        Flat,
        NoBorder,
        CardBorder
    }

    public static class BorderShadowObject {
        public CardViewObject.ShadowTypeEnum type;
    }

    public static class BottomInfoObject {
        public Link action_link;
        public SectionInfoType bottom_info_type;
        public String button_text;
        public String info_icon_1_url;
        public String info_icon_2_url;
        public boolean is_transparent;
        public String subtitle;
        public String subtitle_color_code;
        public float subtitle_font_size;
        public String title;
        public String title_color_code;
        public float title_font_size;
    }

    public static class FeedSectionVideo {
        public String play_type;
        public String url;
    }

    public static class GetHomePageOutput {
        public boolean has_continue;
        public String next_start_id;
        public ArrayList<HomePageSectionObject> sections_list;
    }

    public static class GetLiveSectionItemsInput {
        public String section_id;
        public String tag;
    }

    public static class GetLiveSectionItemsOutput {
        public CommonSectionDataObject common_section_data;
        public ArrayList<LiveSectionItem> live_section_items;
    }

    public static class GetSectionDetailsInput {
        public String section_id;
        public String section_item_id;
        public String start_id;
    }

    public static class GetSectionDetailsOutput {
        public boolean has_continue;
        public String next_start_id;
        public SectionItemObject section_items;
        public SectionTypeEnum section_type;
        public SubSectionItemObject sub_section_items;
    }

    public static class HeaderInfoObject {
        public Link action_link;
        public String button_color_code;
        public String button_icon_url;
        public String button_text;
        public float button_text_size;
        public String icon_url;
        public String title;
        public String title_color_code;
        public float title_size;
    }

    public static class HomeViewTagSectionObject {
        public ArrayList<ViewTagObject> view_tag_item_list;
    }

    public static class IndicatorInfoObject {
        public IndicatorInfoType position;
        public String selected_color_code;
        public IndicatorSizeType size;
        public String unselected_color_code;
    }

    public enum IndicatorInfoType {
        Inside,
        Outside
    }

    public enum IndicatorSizeType {
        Small,
        Medium,
        Big
    }

    public static class InputPredictionObject {
        public String prediction_team_1;
        public String prediction_team_2;
        public String section_item_id;
    }

    public static class MarginInfoObject {
        public float bottom;
        public float left;
        public float right;
        public float top;
    }

    public static class ParallaxSectionObject {
        public int column;
        public ArrayList<ParallaxItem> parallax_items_list;
        public int row;
    }

    public enum PredictionItemEnum {
        NotStarted,
        Finished,
        Ongoing
    }

    public enum SectionInfoType {
        LoadMore,
        Link
    }

    public static class SectionItemObject {
        public ArrayList<ServiceObject> all_services_items_list;
        public ArrayList<CollectionItemObject> collection_items_list;
        public ArrayList<SliderItemObject> slider_items_list;
    }

    public enum SectionTypeEnum {
        AllServices,
        UserFavoriteServices,
        Parallax,
        GroupVoiceChat,
        Collection,
        Slider,
        Feed,
        Banner,
        Container,
        Ad,
        Prediction,
        Music,
        Live,
        ViewTag,
        TextBox
    }

    public static class SetUserFavoriteServicesInput {
        public String section_id;
        public ArrayList<InputServiceObject> services_list;
    }

    public static class SetUserFavoriteServicesOutput {
    }

    public static class SubSectionItemObject {
        public ArrayList<SubCollectionItemObject> sub_collection_items_list;
    }

    public static class UserPredictionsInput {
        public ArrayList<InputPredictionObject> predictions_list;
    }

    public static class UserPredictionsOutput {
    }

    public static class GetHomePageInput {
        public String start_id;
        public String tag;

        public GetHomePageInput(String str) {
            this.tag = str;
        }
    }

    public static class HomePageSectionObject {
        public AdSectionObject ad_section;
        public AllServicesSectionObject all_services_section;
        public BannerSectionObject banner_section;
        public CollectionSectionObject collection_section;
        public CommonSectionDataObject common_section_data;
        public ContainerSectionObject container_section;
        public FeedSectionObject feed_section;
        public String id;
        public LiveSectionObject live_section;
        public MusicSectionObject music_section;
        public ParallaxSectionObject parallax_section;
        public PredictionSectionObject prediction_section;
        public SliderSectionObject slider_section;
        public TextBoxSectionObject text_box_section;
        public SectionTypeEnum type;
        public UserFavoriteServicesSectionObject user_favorite_services_section;
        public HomeViewTagSectionObject view_tag_section;

        public boolean isVisible() {
            LiveSectionObject liveSectionObject;
            ArrayList<LiveSectionItem> arrayList;
            if (this.type != SectionTypeEnum.Live || (liveSectionObject = this.live_section) == null) {
                return false;
            }
            if (MyLog.isDebugAble) {
                liveSectionObject.show_empty_live_section = true;
            }
            return liveSectionObject.show_empty_live_section || !((arrayList = liveSectionObject.liveSectionItems) == null || arrayList.size() == 0);
        }

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            HomePageSectionObject homePageSectionObject = (HomePageSectionObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.id, homePageSectionObject.id) && CallProxy$$ExternalSyntheticBackport0.m(this.type, homePageSectionObject.type) && CallProxy$$ExternalSyntheticBackport0.m(this.parallax_section, homePageSectionObject.parallax_section) && CallProxy$$ExternalSyntheticBackport0.m(this.common_section_data, homePageSectionObject.common_section_data) && CallProxy$$ExternalSyntheticBackport0.m(this.slider_section, homePageSectionObject.slider_section) && CallProxy$$ExternalSyntheticBackport0.m(this.collection_section, homePageSectionObject.collection_section) && CallProxy$$ExternalSyntheticBackport0.m(this.all_services_section, homePageSectionObject.all_services_section) && CallProxy$$ExternalSyntheticBackport0.m(this.user_favorite_services_section, homePageSectionObject.user_favorite_services_section) && CallProxy$$ExternalSyntheticBackport0.m(this.ad_section, homePageSectionObject.ad_section) && CallProxy$$ExternalSyntheticBackport0.m(this.feed_section, homePageSectionObject.feed_section) && CallProxy$$ExternalSyntheticBackport0.m(this.container_section, homePageSectionObject.container_section) && CallProxy$$ExternalSyntheticBackport0.m(this.prediction_section, homePageSectionObject.prediction_section) && CallProxy$$ExternalSyntheticBackport0.m(this.banner_section, homePageSectionObject.banner_section);
        }

        public String toString() {
            return "HomePageSectionObject{parallax_section=" + this.parallax_section + ", id='" + this.id + "', type=" + this.type + ", section_info=" + this.common_section_data + ", slider_section=" + this.slider_section + ", collection_section=" + this.collection_section + ", all_services_section=" + this.all_services_section + ", user_favorite_services_section=" + this.user_favorite_services_section + ", ad_section=" + this.ad_section + ", feed_section=" + this.feed_section + ", container_section=" + this.container_section + ", prediction_section=" + this.prediction_section + ", banner_section=" + this.banner_section + '}';
        }
    }

    public static class AllServicesSectionObject {
        public ArrayList<ServiceObject> all_services_items_list;
        public float column;
        public boolean has_continue;
        public String next_start_id;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            AllServicesSectionObject allServicesSectionObject = (AllServicesSectionObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(Float.valueOf(this.column), Float.valueOf(allServicesSectionObject.column)) && CallProxy$$ExternalSyntheticBackport0.m(this.all_services_items_list, allServicesSectionObject.all_services_items_list) && CallProxy$$ExternalSyntheticBackport0.m(Boolean.valueOf(this.has_continue), Boolean.valueOf(allServicesSectionObject.has_continue)) && CallProxy$$ExternalSyntheticBackport0.m(this.next_start_id, allServicesSectionObject.next_start_id);
        }
    }

    public static class UserFavoriteServicesSectionObject {
        public float column;
        public int max_favorite_services;
        public int row;
        public ArrayList<ServiceObject> user_favorite_services_list;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            UserFavoriteServicesSectionObject userFavoriteServicesSectionObject = (UserFavoriteServicesSectionObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(Float.valueOf(this.column), Float.valueOf(userFavoriteServicesSectionObject.column)) && CallProxy$$ExternalSyntheticBackport0.m(this.user_favorite_services_list, userFavoriteServicesSectionObject.user_favorite_services_list) && CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.row), Integer.valueOf(userFavoriteServicesSectionObject.row));
        }
    }

    public static class CommonSectionDataObject {
        public BorderInfoObject border_info;
        public BottomInfoObject bottom_info;
        public HeaderInfoObject header_info;
        public IndicatorInfoObject indicator_info;
        public MarginInfoObject margin_info;
        public int priority;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            CommonSectionDataObject commonSectionDataObject = (CommonSectionDataObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.priority), Integer.valueOf(commonSectionDataObject.priority)) && CallProxy$$ExternalSyntheticBackport0.m(this.border_info, commonSectionDataObject.border_info) && CallProxy$$ExternalSyntheticBackport0.m(this.header_info, commonSectionDataObject.header_info) && CallProxy$$ExternalSyntheticBackport0.m(this.bottom_info, commonSectionDataObject.bottom_info) && CallProxy$$ExternalSyntheticBackport0.m(this.margin_info, commonSectionDataObject.margin_info);
        }

        public String toString() {
            return "SectionInfoObject{priority='" + this.priority + "', border_info='" + this.border_info + "', header_info='" + this.header_info + "', bottom_info='" + this.bottom_info + "', margin_info=" + this.margin_info + '}';
        }
    }

    public static class TextBoxSectionObject {
        public Link action_link;
        public String icon_url;
        public String place_holder;
        public String place_holder_color_code;

        public String toString() {
            return "TextBoxSectionObject{place_holder='" + this.place_holder + "', place_holder_color_code='" + this.place_holder_color_code + "', icon_url='" + this.icon_url + "', action_link=" + this.action_link + '}';
        }
    }

    public static class SliderSectionObject {
        public float column;
        public boolean has_continue;
        public String image_url;
        public String next_start_id;
        public ArrayList<SliderItemObject> slider_items_list;
        public String title_color_code;
        public int title_font_size;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            SliderSectionObject sliderSectionObject = (SliderSectionObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.image_url, sliderSectionObject.image_url) && CallProxy$$ExternalSyntheticBackport0.m(Float.valueOf(this.column), Float.valueOf(sliderSectionObject.column)) && CallProxy$$ExternalSyntheticBackport0.m(this.title_color_code, sliderSectionObject.title_color_code) && CallProxy$$ExternalSyntheticBackport0.m(this.slider_items_list, sliderSectionObject.slider_items_list) && CallProxy$$ExternalSyntheticBackport0.m(this.next_start_id, sliderSectionObject.next_start_id) && CallProxy$$ExternalSyntheticBackport0.m(Boolean.valueOf(this.has_continue), Boolean.valueOf(sliderSectionObject.has_continue));
        }
    }

    public static class SliderItemObject {
        public Link action_link;
        public String id;
        public String image_url;
        public int priority;
        public String title;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            SliderItemObject sliderItemObject = (SliderItemObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.id, sliderItemObject.id) && CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.priority), Integer.valueOf(sliderItemObject.priority)) && CallProxy$$ExternalSyntheticBackport0.m(this.title, sliderItemObject.title) && CallProxy$$ExternalSyntheticBackport0.m(this.image_url, sliderItemObject.image_url);
        }
    }

    public static class FeedSectionObject {
        public Link action_link;
        public long end_show_time;
        public String image_url;
        public long start_show_time;
        public TimerInfoObject timer_info;
        public FeedSectionVideo video;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            FeedSectionObject feedSectionObject = (FeedSectionObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.image_url, feedSectionObject.image_url) && CallProxy$$ExternalSyntheticBackport0.m(this.video, feedSectionObject.video);
        }
    }

    public static class ContainerSectionItem {
        public Link action_link;
        public String button_text;
        public String id;
        public String image_url;
        public int priority;
        public String subtitle;
        public String title;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            ContainerSectionItem containerSectionItem = (ContainerSectionItem) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.id, containerSectionItem.id) && CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.priority), Integer.valueOf(containerSectionItem.priority)) && CallProxy$$ExternalSyntheticBackport0.m(this.title, containerSectionItem.title) && CallProxy$$ExternalSyntheticBackport0.m(this.button_text, containerSectionItem.button_text) && CallProxy$$ExternalSyntheticBackport0.m(this.image_url, containerSectionItem.image_url) && CallProxy$$ExternalSyntheticBackport0.m(this.subtitle, containerSectionItem.subtitle);
        }

        public String toString() {
            return "ContainerSectionItem{id='" + this.id + "', priority=" + this.priority + ", title='" + this.title + "', button_text='" + this.button_text + "', image_url='" + this.image_url + "', subtitle='" + this.subtitle + "', action_link=" + this.action_link + '}';
        }
    }

    public static class ContainerSectionObject {
        public ArrayList<ContainerSectionItem> container_items_list;
        public boolean has_continue;
        public String next_start_id;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            ContainerSectionObject containerSectionObject = (ContainerSectionObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.container_items_list, containerSectionObject.container_items_list) && CallProxy$$ExternalSyntheticBackport0.m(this.next_start_id, containerSectionObject.next_start_id) && CallProxy$$ExternalSyntheticBackport0.m(Boolean.valueOf(this.has_continue), Boolean.valueOf(containerSectionObject.has_continue));
        }

        public String toString() {
            return "ContainerSectionObject{, container_item_list=" + this.container_items_list + ", next_start_id='" + this.next_start_id + "', has_continue=" + this.has_continue + '}';
        }
    }

    public static class LiveSectionObject {
        public ArrayList<LiveSectionItem> liveSectionItems;
        public int main_item_count;
        public boolean show_empty_live_section;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            LiveSectionObject liveSectionObject = (LiveSectionObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.main_item_count), Integer.valueOf(liveSectionObject.main_item_count)) && CallProxy$$ExternalSyntheticBackport0.m(Boolean.valueOf(this.show_empty_live_section), Boolean.valueOf(liveSectionObject.show_empty_live_section));
        }

        public String toString() {
            return "LiveSectionObject{main_item_count='" + this.main_item_count + "'show_empty_live_section='" + this.show_empty_live_section + "'}";
        }
    }

    public static class LiveSectionItem {
        public String channel_avatar_url;
        public String channel_name;
        public Link live_message_share_link;
        public int live_online_count;
        public String live_title;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            LiveSectionItem liveSectionItem = (LiveSectionItem) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.channel_avatar_url, liveSectionItem.channel_avatar_url) && CallProxy$$ExternalSyntheticBackport0.m(this.channel_name, liveSectionItem.channel_name) && CallProxy$$ExternalSyntheticBackport0.m(this.live_title, liveSectionItem.live_title) && CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.live_online_count), Integer.valueOf(liveSectionItem.live_online_count)) && CallProxy$$ExternalSyntheticBackport0.m(this.live_message_share_link, liveSectionItem.live_message_share_link);
        }

        public String toString() {
            return "LiveSectionItem{channel_avatar_url='" + this.channel_avatar_url + "', channel_name='" + this.channel_name + "', live_title='" + this.live_title + "', live_online_count=" + this.live_online_count + ", live_message_share_link=" + this.live_message_share_link + '}';
        }
    }

    public static class MusicSectionObject {
        public ArrayList<MusicItem> music_items_list;

        public boolean equals(Object obj) {
            if (obj != null && obj.getClass() == getClass()) {
                return CallProxy$$ExternalSyntheticBackport0.m(this.music_items_list, ((MusicSectionObject) obj).music_items_list);
            }
            return false;
        }

        public String toString() {
            return "MusicSectionObject{, music_items_list=" + this.music_items_list + '}';
        }
    }

    public static class MusicItem {
        public int duration_seconds;
        public String id;
        public String image_url;
        public String music_performer;
        public String play_url;
        public int priority;
        public String title;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            MusicItem musicItem = (MusicItem) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.id, musicItem.id) && CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.priority), Integer.valueOf(musicItem.priority)) && CallProxy$$ExternalSyntheticBackport0.m(this.title, musicItem.title) && CallProxy$$ExternalSyntheticBackport0.m(this.image_url, musicItem.image_url) && CallProxy$$ExternalSyntheticBackport0.m(this.play_url, musicItem.play_url) && CallProxy$$ExternalSyntheticBackport0.m(this.music_performer, musicItem.music_performer) && CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.duration_seconds), Integer.valueOf(musicItem.duration_seconds));
        }

        public String toString() {
            return "MusicItem{id='" + this.id + "', priority=" + this.priority + ", title='" + this.title + "', image_url='" + this.image_url + "', play_url='" + this.play_url + "', music_performer='" + this.music_performer + "', duration_seconds=" + this.duration_seconds + '}';
        }
    }

    public static class BannerSectionObject {
        public Link action_link;
        public String background_color_code;
        public long end_show_time;
        public String image_url;
        public long start_show_time;
        public TimerInfoObject timer_info;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            BannerSectionObject bannerSectionObject = (BannerSectionObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.image_url, bannerSectionObject.image_url) && CallProxy$$ExternalSyntheticBackport0.m(this.background_color_code, bannerSectionObject.background_color_code) && CallProxy$$ExternalSyntheticBackport0.m(Long.valueOf(this.start_show_time), Long.valueOf(bannerSectionObject.start_show_time)) && CallProxy$$ExternalSyntheticBackport0.m(Long.valueOf(this.end_show_time), Long.valueOf(bannerSectionObject.end_show_time));
        }

        public String toString() {
            return "BannerSectionObject{image_url='" + this.image_url + "', background_color_code='" + this.background_color_code + "', start_show_time=" + this.start_show_time + ", end_show_time=" + this.end_show_time + '}';
        }
    }

    public static class PredictionSectionObject {
        public boolean has_continue;
        public ArrayList<PredictionSectionItem> prediction_items_list;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            PredictionSectionObject predictionSectionObject = (PredictionSectionObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.prediction_items_list, predictionSectionObject.prediction_items_list) && CallProxy$$ExternalSyntheticBackport0.m(Boolean.valueOf(this.has_continue), Boolean.valueOf(predictionSectionObject.has_continue));
        }

        public String toString() {
            return "PredictionSectionObject{prediction_item_list=" + this.prediction_items_list + ", has_continue=" + this.has_continue + '}';
        }
    }

    public static class PredictionSectionItem {
        public long end_show_time;
        public String id;
        public boolean is_prediction_allowed;
        public long match_end_datetime;
        public long match_start_datetime;
        public long predict_end_datetime;
        public int priority;
        public String result_team_1;
        public String result_team_2;
        public PredictionItemEnum state;
        public PredictionSectionTeam team_1;
        public PredictionSectionTeam team_2;
        public String user_prediction_team_1;
        public String user_prediction_team_2;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            PredictionSectionItem predictionSectionItem = (PredictionSectionItem) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.id, predictionSectionItem.id) && CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.priority), Integer.valueOf(predictionSectionItem.priority)) && CallProxy$$ExternalSyntheticBackport0.m(Long.valueOf(this.match_start_datetime), Long.valueOf(predictionSectionItem.match_start_datetime)) && CallProxy$$ExternalSyntheticBackport0.m(Long.valueOf(this.match_end_datetime), Long.valueOf(predictionSectionItem.match_end_datetime)) && CallProxy$$ExternalSyntheticBackport0.m(this.team_1, predictionSectionItem.team_1) && CallProxy$$ExternalSyntheticBackport0.m(this.team_2, predictionSectionItem.team_2) && CallProxy$$ExternalSyntheticBackport0.m(this.user_prediction_team_1, predictionSectionItem.user_prediction_team_1) && CallProxy$$ExternalSyntheticBackport0.m(this.user_prediction_team_2, predictionSectionItem.user_prediction_team_2) && CallProxy$$ExternalSyntheticBackport0.m(this.result_team_1, predictionSectionItem.result_team_1) && CallProxy$$ExternalSyntheticBackport0.m(this.result_team_2, predictionSectionItem.result_team_2) && CallProxy$$ExternalSyntheticBackport0.m(this.state, predictionSectionItem.state) && CallProxy$$ExternalSyntheticBackport0.m(Boolean.valueOf(this.is_prediction_allowed), Boolean.valueOf(predictionSectionItem.is_prediction_allowed));
        }

        public String toString() {
            return "PredictionSectionItem{id=" + this.id + ", priority=" + this.priority + ", match_start_datetime=" + this.match_start_datetime + ", match_end_datetime=" + this.match_end_datetime + ", team_1=" + this.team_1 + ", team_2=" + this.team_2 + ", user_prediction_team_1='" + this.user_prediction_team_1 + "', user_prediction_team_2='" + this.user_prediction_team_2 + "'}";
        }
    }

    public static class PredictionSectionTeam {
        public String id;
        public String image_url;
        public String latin_name;
        public String name;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            PredictionSectionTeam predictionSectionTeam = (PredictionSectionTeam) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.name, predictionSectionTeam.name) && CallProxy$$ExternalSyntheticBackport0.m(this.id, predictionSectionTeam.id) && CallProxy$$ExternalSyntheticBackport0.m(this.latin_name, predictionSectionTeam.latin_name) && CallProxy$$ExternalSyntheticBackport0.m(this.image_url, predictionSectionTeam.image_url);
        }

        public String toString() {
            return "PredictionSectionTeam{name='" + this.name + "', id=" + this.id + ", latin_name='" + this.latin_name + "', image_url='" + this.image_url + "'}";
        }
    }

    public static class CollectionSectionObject {
        public ArrayList<CollectionItemObject> collection_items_list;
        public float column;
        public boolean has_continue;
        public String next_start_id;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            CollectionSectionObject collectionSectionObject = (CollectionSectionObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(Float.valueOf(this.column), Float.valueOf(collectionSectionObject.column)) && CallProxy$$ExternalSyntheticBackport0.m(this.collection_items_list, collectionSectionObject.collection_items_list) && CallProxy$$ExternalSyntheticBackport0.m(this.next_start_id, collectionSectionObject.next_start_id) && CallProxy$$ExternalSyntheticBackport0.m(Boolean.valueOf(this.has_continue), Boolean.valueOf(collectionSectionObject.has_continue));
        }
    }

    public static class CollectionItemObject {
        public boolean has_continue;
        public String id;
        public String next_start_id;
        public int priority;
        public ArrayList<SubCollectionItemObject> sub_collection_items_list;
        public String title;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            CollectionItemObject collectionItemObject = (CollectionItemObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.id, collectionItemObject.id) && CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.priority), Integer.valueOf(collectionItemObject.priority)) && CallProxy$$ExternalSyntheticBackport0.m(this.title, collectionItemObject.title) && CallProxy$$ExternalSyntheticBackport0.m(this.sub_collection_items_list, collectionItemObject.sub_collection_items_list) && CallProxy$$ExternalSyntheticBackport0.m(this.next_start_id, collectionItemObject.next_start_id) && CallProxy$$ExternalSyntheticBackport0.m(Boolean.valueOf(this.has_continue), Boolean.valueOf(collectionItemObject.has_continue));
        }
    }

    public static class ServiceObject {
        public Link action_link;
        public String id;
        public String image_url;
        public boolean isDragging = false;
        public int priority;
        public String title;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            ServiceObject serviceObject = (ServiceObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.id, serviceObject.id) && CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.priority), Integer.valueOf(serviceObject.priority)) && CallProxy$$ExternalSyntheticBackport0.m(this.title, serviceObject.title) && CallProxy$$ExternalSyntheticBackport0.m(this.image_url, serviceObject.image_url) && CallProxy$$ExternalSyntheticBackport0.m(Boolean.valueOf(this.isDragging), Boolean.valueOf(serviceObject.isDragging));
        }
    }

    public static class SubCollectionItemObject {
        public Link action_link;
        public String id;
        public String image_url;
        public int priority;
        public String title;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            SubCollectionItemObject subCollectionItemObject = (SubCollectionItemObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.id, subCollectionItemObject.id) && CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.priority), Integer.valueOf(subCollectionItemObject.priority)) && CallProxy$$ExternalSyntheticBackport0.m(this.title, subCollectionItemObject.title) && CallProxy$$ExternalSyntheticBackport0.m(this.image_url, subCollectionItemObject.image_url);
        }
    }

    public static class ParallaxItem {
        public Link action_link;
        public String id;
        public String image_url;
        public int priority;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            ParallaxItem parallaxItem = (ParallaxItem) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(this.image_url, parallaxItem.image_url) && CallProxy$$ExternalSyntheticBackport0.m(this.id, parallaxItem.id) && CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.priority), Integer.valueOf(parallaxItem.priority));
        }
    }

    public static class InputServiceObject {
        public int priority;
        public String section_item_id;

        public static InputServiceObject createFromServiceObject(ServiceObject serviceObject) {
            InputServiceObject inputServiceObject = new InputServiceObject();
            inputServiceObject.section_item_id = serviceObject.id;
            inputServiceObject.priority = serviceObject.priority;
            return inputServiceObject;
        }
    }

    public static class AdItemObject {
        public Link action_link;
        public String id;
        public String image_url;
        public int priority;
        public TimerInfoObject timer_info;

        public String toString() {
            return "AdItemObject{id='" + this.id + "', priority=" + this.priority + ", action_link=" + this.action_link + ", image_url='" + this.image_url + "', timer_info=" + this.timer_info + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AdItemObject adItemObject = (AdItemObject) obj;
            return this.priority == adItemObject.priority && CallProxy$$ExternalSyntheticBackport0.m(this.id, adItemObject.id) && CallProxy$$ExternalSyntheticBackport0.m(this.action_link, adItemObject.action_link) && CallProxy$$ExternalSyntheticBackport0.m(this.image_url, adItemObject.image_url) && CallProxy$$ExternalSyntheticBackport0.m(this.timer_info, adItemObject.timer_info);
        }
    }

    public static class TimerInfoObject {
        public String color_code;
        public int expiration_time;
        public float font_size;
        public float x1;
        public float x2;
        public float y1;
        public float y2;

        public String toString() {
            return "TimerInfoObject{expiration_time=" + this.expiration_time + ", font_size=" + this.font_size + ", color_code='" + this.color_code + "', x1=" + this.x1 + ", x2=" + this.x2 + ", y1=" + this.y1 + ", y2=" + this.y2 + '}';
        }
    }

    public static class AdSectionObject {
        public ArrayList<AdItemObject> ad_items_list;
        public int column;
        public boolean has_continue;
        public String next_start_id;
        public int row;
        public int scroll_time;
        public boolean scrollable;
        public float w_h_ratio;

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            AdSectionObject adSectionObject = (AdSectionObject) obj;
            return CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.column), Integer.valueOf(adSectionObject.column)) && CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.row), Integer.valueOf(adSectionObject.row)) && CallProxy$$ExternalSyntheticBackport0.m(Boolean.valueOf(this.has_continue), Boolean.valueOf(adSectionObject.has_continue)) && CallProxy$$ExternalSyntheticBackport0.m(this.ad_items_list, adSectionObject.ad_items_list);
        }
    }
}
