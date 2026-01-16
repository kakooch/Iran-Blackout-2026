package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.model.InstaGetListInput;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class ListInput {
    public ArrayList<? extends PresenterItem> arrayList;
    public BotSelectionListInput botSelectionListInput;
    public String cat_id;
    public String categoryId;
    public String chatId;
    public String comment_id;
    public String content;
    public GetDeliveryTimesInput deliveryTimesInput;
    public DeliveryTypeInput deliveryTypeInput;
    public GetDynamicPageDataInput dynamicPageDataInput;
    public String dynamicPageObjectId;
    public int first_index;
    public boolean isForceLoadLoacly;
    public ItemType itemType;
    public JJTabObject jjTabObject;
    public int last_index;
    public HashSet<String> likedItems;
    public int limit;
    public String max_id;
    public String min_id;
    public String object_id;
    public PaidOrdersInput paidOrdersInput;
    public String parentId;
    public String payListName;
    public String payListTargetMobile;
    public String post_id;
    public String post_profile_id;
    public PredictLinkObject predictLinkObject;
    public InstaProfileObject profileObject;
    public String provinceId;
    public InstaGetListInput rubinoHashtagInput;
    public String search_input;
    public SizeObject size;
    public InstaGetListInput.SortEnum sort;
    public String start_id;
    public TagObject tagObject;
    public String target_profile_id;
    public String title;
    public String topic_id;
    public ViewTagObject viewTagObject;

    public static class BotSelectionListInput {
        public String apiUrl;
        public String appId;
        public String object_guid;
        public String searchText;
        public String selectionId;
        public String start_id;
    }

    public static class DeliveryTypeInput {
        public String basket_id;
        public String delivery_info_id;
    }

    public enum ItemType {
        contact,
        chatUser,
        chatMessage,
        media,
        files,
        channelMessages,
        tag,
        viewTag,
        array,
        payItem,
        instaContact,
        newestNews,
        mostVisitedNews,
        jjMatch,
        instaComment,
        instaFollowers,
        instaFollowing,
        instaFollowRequest,
        instaReply,
        instaNewCommentLikes,
        instaNewPostLikes,
        instaNewComments,
        instaNewEvents,
        instaPostLikeProfile,
        instaTopProfiles,
        instaCommentLikeProfile,
        instaMyProfiles,
        instaSuggestedProfiles,
        instaSaleNotif,
        instaPurchaseNotif,
        instaPostSale,
        botSelection,
        instaHashTagPost,
        explorPost,
        relatedProfiles,
        endpointComment,
        basket,
        province,
        city,
        deliveryInfos,
        deliveryType,
        deliveryTime,
        paidOrder,
        searchViewTag,
        dynamicPageData,
        instaRelatedPost,
        rubinoHashtag
    }

    public enum JJTabNames {
        A,
        B,
        C,
        D,
        E,
        F,
        G,
        H,
        week2,
        week3,
        week4,
        week5,
        week6
    }

    public ListInput(ViewTagObject viewTagObject) {
        this.first_index = 0;
        this.last_index = 20;
        this.limit = 18;
        this.parentId = BuildConfig.FLAVOR;
        this.chatId = BuildConfig.FLAVOR;
        this.isForceLoadLoacly = false;
        this.itemType = ItemType.viewTag;
        this.viewTagObject = viewTagObject;
        this.title = viewTagObject.title;
    }

    public ListInput(ItemType itemType) {
        this.first_index = 0;
        this.last_index = 20;
        this.limit = 18;
        this.parentId = BuildConfig.FLAVOR;
        this.chatId = BuildConfig.FLAVOR;
        this.isForceLoadLoacly = false;
        this.itemType = itemType;
    }

    public ListInput(TagObject tagObject) {
        this.first_index = 0;
        this.last_index = 20;
        this.limit = 18;
        this.parentId = BuildConfig.FLAVOR;
        this.chatId = BuildConfig.FLAVOR;
        this.isForceLoadLoacly = false;
        this.itemType = ItemType.tag;
        this.tagObject = tagObject;
    }

    public ListInput(ViewTagObject viewTagObject, boolean z) {
        this.first_index = 0;
        this.last_index = 20;
        this.limit = 18;
        this.parentId = BuildConfig.FLAVOR;
        this.chatId = BuildConfig.FLAVOR;
        this.isForceLoadLoacly = false;
        if (!z) {
            this.itemType = ItemType.viewTag;
        } else {
            this.itemType = ItemType.searchViewTag;
        }
        this.viewTagObject = viewTagObject;
        this.title = viewTagObject.title;
    }

    public ListInput(ViewTagObject viewTagObject, String str, boolean z) {
        this.first_index = 0;
        this.last_index = 20;
        this.limit = 18;
        this.parentId = BuildConfig.FLAVOR;
        this.chatId = BuildConfig.FLAVOR;
        this.isForceLoadLoacly = false;
        if (!z) {
            this.itemType = ItemType.viewTag;
        } else {
            this.itemType = ItemType.searchViewTag;
        }
        this.viewTagObject = viewTagObject;
        this.title = viewTagObject.title;
        this.dynamicPageObjectId = str;
    }

    public ListInput(String str, String str2) {
        this.first_index = 0;
        this.last_index = 20;
        this.limit = 18;
        this.parentId = BuildConfig.FLAVOR;
        this.chatId = BuildConfig.FLAVOR;
        this.isForceLoadLoacly = false;
        this.payListName = str;
        this.payListTargetMobile = str2;
        this.itemType = ItemType.payItem;
    }

    public ListInput(ArrayList<? extends PresenterItem> arrayList) {
        this.first_index = 0;
        this.last_index = 20;
        this.limit = 18;
        this.parentId = BuildConfig.FLAVOR;
        this.chatId = BuildConfig.FLAVOR;
        this.isForceLoadLoacly = false;
        this.itemType = ItemType.array;
        this.arrayList = arrayList;
    }

    public ListInput(ItemType itemType, int i, int i2) {
        this.first_index = 0;
        this.last_index = 20;
        this.limit = 18;
        this.parentId = BuildConfig.FLAVOR;
        this.chatId = BuildConfig.FLAVOR;
        this.isForceLoadLoacly = false;
        this.itemType = itemType;
        this.first_index = i;
        this.last_index = i2;
    }

    public String getContentName() {
        ArrayList<? extends PresenterItem> arrayList;
        String str = BuildConfig.FLAVOR + this.itemType;
        if (this.itemType == ItemType.tag) {
            str = str + this.tagObject.tag_id + this.tagObject.type;
        }
        if (this.itemType != ItemType.array || (arrayList = this.arrayList) == null || arrayList.size() <= 0) {
            return str;
        }
        return str + this.arrayList.get(0).getPresenterType();
    }
}
