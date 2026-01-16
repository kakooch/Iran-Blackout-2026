package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.os.Handler;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.appUpdate.UpdateUtils;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.BasketObject;
import ir.resaneh1.iptv.model.DeliveryCityObject;
import ir.resaneh1.iptv.model.DeliveryInfoObject;
import ir.resaneh1.iptv.model.DeliveryProvinceObject;
import ir.resaneh1.iptv.model.DeliveryTimeObject;
import ir.resaneh1.iptv.model.DeliveryTypeObject;
import ir.resaneh1.iptv.model.EndPointCommentObject;
import ir.resaneh1.iptv.model.GetAllDeliveryInfoOutput;
import ir.resaneh1.iptv.model.GetBasketListOutput;
import ir.resaneh1.iptv.model.GetCommentsOutput;
import ir.resaneh1.iptv.model.GetDeliverCityInput;
import ir.resaneh1.iptv.model.GetDeliverCityOutput;
import ir.resaneh1.iptv.model.GetDeliverProvinceOutput;
import ir.resaneh1.iptv.model.GetDeliveryTimesInput;
import ir.resaneh1.iptv.model.GetDeliveryTimesOutput;
import ir.resaneh1.iptv.model.GetDeliveryTypeOutput;
import ir.resaneh1.iptv.model.GetDeliveryTypesInput;
import ir.resaneh1.iptv.model.GetListInput;
import ir.resaneh1.iptv.model.GetListInputByStartId;
import ir.resaneh1.iptv.model.GetListOutput;
import ir.resaneh1.iptv.model.GetListPayInput;
import ir.resaneh1.iptv.model.GetListPayObject;
import ir.resaneh1.iptv.model.GetListPayOutput2;
import ir.resaneh1.iptv.model.GetNewsListInput;
import ir.resaneh1.iptv.model.GetNewsListOutput;
import ir.resaneh1.iptv.model.GetPaidOrdersOutput;
import ir.resaneh1.iptv.model.GetTagObjectsOutput;
import ir.resaneh1.iptv.model.InstaCommentObject;
import ir.resaneh1.iptv.model.InstaGetCommentsOutput;
import ir.resaneh1.iptv.model.InstaGetHashTagPostsOutput;
import ir.resaneh1.iptv.model.InstaGetListInput;
import ir.resaneh1.iptv.model.InstaGetNewEventsOutput;
import ir.resaneh1.iptv.model.InstaGetPostSaleListOutput;
import ir.resaneh1.iptv.model.InstaGetPostsOutput;
import ir.resaneh1.iptv.model.InstaGetProfilesOutput;
import ir.resaneh1.iptv.model.InstaGetPurchaseListOutput;
import ir.resaneh1.iptv.model.InstaGetRelatedExplorePostsOutput;
import ir.resaneh1.iptv.model.InstaGetRelatedProfilesOutput;
import ir.resaneh1.iptv.model.InstaGetSaleListOutput;
import ir.resaneh1.iptv.model.InstaGetTopProfilesInput;
import ir.resaneh1.iptv.model.InstaPostObject;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.model.InstaPurchaseNotificationObject;
import ir.resaneh1.iptv.model.InstaSaleNotificationObject;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListOutput;
import ir.resaneh1.iptv.model.JJMatchObject;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.NewsObject;
import ir.resaneh1.iptv.model.OrderObject;
import ir.resaneh1.iptv.model.PaidOrdersInput;
import ir.resaneh1.iptv.model.RubinoNewEventObject;
import ir.resaneh1.iptv.model.SearchQueryInput;
import ir.resaneh1.iptv.model.SearchQueryOutput;
import ir.resaneh1.iptv.model.TagObject;
import ir.resaneh1.iptv.model.ThreePostObject;
import ir.resaneh1.iptv.model.ViewDataObject;
import ir.resaneh1.iptv.model.ViewGroupObject;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class ItemListRequest {
    Call lastCall;

    public interface Listener {
        void onFailure(Throwable th);

        void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput);
    }

    public Call load(Context context, final ListInput listInput, final Listener listener) {
        TagObject tagObject;
        TagObject.TagType tagType;
        MyLog.e("itemlistRequest", "load:" + listInput.itemType);
        ListInput.ItemType itemType = listInput.itemType;
        if (itemType == ListInput.ItemType.botSelection) {
            String str = listInput.botSelectionListInput.searchText;
            if (str == null || str.isEmpty()) {
                String str2 = listInput.botSelectionListInput.object_guid;
                if (str2 != null) {
                    str2.length();
                }
            } else if (listInput.first_index != 0) {
                AndroidUtilities.runOnUIThread(new Runnable(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.1
                    @Override // java.lang.Runnable
                    public void run() {
                        listener.onResponse(new ArrayList<>(), null);
                    }
                }, 10L);
            }
        } else if (itemType == ListInput.ItemType.jjMatch) {
            Utilities.myQueue.postRunnable(new Runnable(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.2
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<JJMatchObject> arrayList;
                    final ArrayList arrayList2 = new ArrayList();
                    JJGetMatchAndTeamListOutput matchAndTeam = JJAppPreferences.getInstance().getMatchAndTeam();
                    if (matchAndTeam != null && (arrayList = matchAndTeam.result.matchUpdates) != null && listInput.jjTabObject != null) {
                        Iterator<JJMatchObject> it = arrayList.iterator();
                        while (it.hasNext()) {
                            JJMatchObject next = it.next();
                            if (listInput.jjTabObject.group.equals(next.group) && listInput.jjTabObject.week.equals(next.week)) {
                                arrayList2.add(next);
                            }
                        }
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.helper.ItemListRequest.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            listener.onResponse(arrayList2, null);
                        }
                    });
                }
            });
        } else if (itemType == ListInput.ItemType.searchViewTag) {
            SearchQueryInput searchQueryInput = new SearchQueryInput();
            searchQueryInput.limit = listInput.limit;
            String str3 = listInput.start_id;
            if (str3 != null && !str3.equals(BuildConfig.FLAVOR)) {
                searchQueryInput.start_id = listInput.start_id;
            }
            searchQueryInput.search_input = listInput.search_input;
            searchQueryInput.tag_id = listInput.viewTagObject.tag_id;
            searchQueryInput.dynamic_page_object_id = listInput.dynamicPageObjectId;
            this.lastCall = ApiRequestMessanger.getInstance(UserConfig.selectedAccount).searchQuery(searchQueryInput, listInput.viewTagObject.api_url, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.3
                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onResponse(Call call, Object obj) {
                    SearchQueryOutput searchQueryOutput = (SearchQueryOutput) obj;
                    String str4 = searchQueryOutput.next_start_id;
                    if (str4 == null || str4.isEmpty()) {
                        searchQueryOutput.next_start_id = "-1";
                    }
                    listInput.start_id = searchQueryOutput.next_start_id;
                    ArrayList<ViewDataObject> arrayList = searchQueryOutput.objects;
                    if (arrayList != null) {
                        listener.onResponse(arrayList, null);
                    } else {
                        listener.onResponse(new ArrayList<>(), null);
                    }
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onFailure(Call call, Throwable th) {
                    listener.onFailure(th);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onError(MessangerOutput messangerOutput) {
                    listener.onFailure(null);
                }
            });
        } else if (itemType == ListInput.ItemType.instaRelatedPost) {
            final InstaGetListInput instaGetListInput = new InstaGetListInput();
            instaGetListInput.limit = listInput.limit;
            String str4 = listInput.start_id;
            if (str4 != null && !str4.equals(BuildConfig.FLAVOR)) {
                instaGetListInput.start_id = listInput.start_id;
            }
            instaGetListInput.post_id = listInput.post_id;
            instaGetListInput.post_profile_id = listInput.post_profile_id;
            this.lastCall = ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetRelatedExplorePosts(instaGetListInput, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.4
                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onResponse(Call call, Object obj) {
                    InstaGetRelatedExplorePostsOutput instaGetRelatedExplorePostsOutput = (InstaGetRelatedExplorePostsOutput) obj;
                    String str5 = instaGetListInput.start_id;
                    if (str5 == null || str5.isEmpty()) {
                        if (instaGetRelatedExplorePostsOutput.related_posts == null) {
                            instaGetRelatedExplorePostsOutput.related_posts = new ArrayList<>();
                        }
                        instaGetRelatedExplorePostsOutput.related_posts.add(0, instaGetRelatedExplorePostsOutput.selected_post);
                    }
                    String str6 = instaGetRelatedExplorePostsOutput.next_start_id;
                    if (str6 == null || str6.isEmpty()) {
                        instaGetRelatedExplorePostsOutput.next_start_id = "-1";
                    }
                    ArrayList<InstaPostObject> arrayList = instaGetRelatedExplorePostsOutput.related_posts;
                    if (arrayList != null && instaGetRelatedExplorePostsOutput.following_list != null) {
                        Iterator<InstaPostObject> it = arrayList.iterator();
                        while (it.hasNext()) {
                            InstaPostObject next = it.next();
                            next.isProfileFollowed = instaGetRelatedExplorePostsOutput.following_list.contains(next.profile_id);
                        }
                    }
                    listInput.start_id = instaGetRelatedExplorePostsOutput.next_start_id;
                    listener.onResponse(instaGetRelatedExplorePostsOutput.related_posts, null);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onFailure(Call call, Throwable th) {
                    listener.onFailure(th);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onError(MessangerOutput messangerOutput) {
                    listener.onFailure(null);
                }
            });
        } else if (itemType == ListInput.ItemType.instaPostLikeProfile) {
            InstaGetListInput instaGetListInput2 = new InstaGetListInput();
            instaGetListInput2.limit = listInput.limit;
            String str5 = listInput.max_id;
            if (str5 != null && !str5.equals(BuildConfig.FLAVOR)) {
                instaGetListInput2.max_id = listInput.max_id;
            }
            instaGetListInput2.post_profile_id = listInput.post_profile_id;
            instaGetListInput2.post_id = listInput.post_id;
            instaGetListInput2.sort = InstaGetListInput.SortEnum.FromMax;
            ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetPostLikeProfiles(instaGetListInput2, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.5
                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onResponse(Call call, Object obj) {
                    ArrayList<InstaProfileObject> arrayList = ((InstaGetProfilesOutput) obj).profiles;
                    if (arrayList != null) {
                        listener.onResponse(arrayList, null);
                    } else {
                        listener.onResponse(new ArrayList<>(), null);
                    }
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onFailure(Call call, Throwable th) {
                    listener.onFailure(th);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onError(MessangerOutput messangerOutput) {
                    listener.onFailure(null);
                }
            });
        } else if (itemType == ListInput.ItemType.instaCommentLikeProfile) {
            InstaGetListInput instaGetListInput3 = new InstaGetListInput();
            instaGetListInput3.limit = listInput.limit;
            String str6 = listInput.max_id;
            if (str6 != null && !str6.equals(BuildConfig.FLAVOR)) {
                instaGetListInput3.max_id = listInput.max_id;
            }
            instaGetListInput3.comment_id = listInput.comment_id;
            instaGetListInput3.post_id = listInput.post_id;
            instaGetListInput3.sort = InstaGetListInput.SortEnum.FromMax;
            ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetLikedCommentProfiles(instaGetListInput3, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.6
                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onResponse(Call call, Object obj) {
                    ArrayList<InstaProfileObject> arrayList = ((InstaGetProfilesOutput) obj).profiles;
                    if (arrayList != null) {
                        listener.onResponse(arrayList, null);
                    }
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onFailure(Call call, Throwable th) {
                    listener.onFailure(th);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onError(MessangerOutput messangerOutput) {
                    listener.onFailure(null);
                }
            });
        } else if (itemType == ListInput.ItemType.instaTopProfiles) {
            ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetTopProfiles(new InstaGetTopProfilesInput(), new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.7
                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onResponse(Call call, Object obj) {
                    InstaGetProfilesOutput instaGetProfilesOutput = (InstaGetProfilesOutput) obj;
                    if (instaGetProfilesOutput.profiles != null) {
                        InstaProfileObject instaCurrentProfileObject = AppRubinoPreferences.getInstance(UserConfig.selectedAccount).getInstaCurrentProfileObject();
                        Iterator<InstaProfileObject> it = instaGetProfilesOutput.profiles.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            InstaProfileObject next = it.next();
                            if (next.id.equals(instaCurrentProfileObject.id)) {
                                instaGetProfilesOutput.profiles.remove(next);
                                break;
                            }
                        }
                        listener.onResponse(instaGetProfilesOutput.profiles, null);
                        return;
                    }
                    listener.onResponse(new ArrayList<>(), null);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onFailure(Call call, Throwable th) {
                    listener.onFailure(th);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onError(MessangerOutput messangerOutput) {
                    listener.onFailure(null);
                }
            });
        } else if (itemType == ListInput.ItemType.instaMyProfiles) {
            ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetMyProfileList(new InstaGetListInput(), new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.8
                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onResponse(Call call, Object obj) {
                    InstaGetProfilesOutput instaGetProfilesOutput = (InstaGetProfilesOutput) obj;
                    if (instaGetProfilesOutput.profiles != null) {
                        InstaProfileObject instaCurrentProfileObject = AppRubinoPreferences.getInstance(UserConfig.selectedAccount).getInstaCurrentProfileObject();
                        Iterator<InstaProfileObject> it = instaGetProfilesOutput.profiles.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            InstaProfileObject next = it.next();
                            if (next.id.equals(instaCurrentProfileObject.id)) {
                                instaGetProfilesOutput.profiles.remove(next);
                                break;
                            }
                        }
                        instaGetProfilesOutput.profiles.add(new InstaProfileObject(true));
                        listener.onResponse(instaGetProfilesOutput.profiles, null);
                        return;
                    }
                    listener.onResponse(new ArrayList<>(), null);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onFailure(Call call, Throwable th) {
                    listener.onFailure(th);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onError(MessangerOutput messangerOutput) {
                    listener.onFailure(null);
                }
            });
        } else if (itemType == ListInput.ItemType.instaHashTagPost) {
            InstaGetListInput instaGetListInput4 = new InstaGetListInput();
            instaGetListInput4.limit = listInput.limit;
            String str7 = listInput.max_id;
            if (str7 != null && !str7.equals(BuildConfig.FLAVOR)) {
                instaGetListInput4.max_id = listInput.max_id;
            }
            String str8 = listInput.min_id;
            if (str8 != null && !str8.equals(BuildConfig.FLAVOR)) {
                instaGetListInput4.min_id = listInput.min_id;
            }
            instaGetListInput4.sort = listInput.sort;
            instaGetListInput4.content = listInput.content;
            ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetHashTagPosts(instaGetListInput4, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.9
                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onResponse(Call call, Object obj) {
                    ArrayList<InstaPostObject> arrayList = ((InstaGetHashTagPostsOutput) obj).posts;
                    if (arrayList != null) {
                        listener.onResponse(arrayList, null);
                    } else {
                        listener.onResponse(new ArrayList<>(), null);
                    }
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onFailure(Call call, Throwable th) {
                    listener.onFailure(th);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onError(MessangerOutput messangerOutput) {
                    listener.onFailure(null);
                }
            });
        } else if (itemType == ListInput.ItemType.instaComment) {
            InstaGetListInput instaGetListInput5 = new InstaGetListInput();
            instaGetListInput5.post_id = listInput.post_id;
            instaGetListInput5.post_profile_id = listInput.post_profile_id;
            instaGetListInput5.limit = listInput.limit;
            String str9 = listInput.max_id;
            if (str9 != null && !str9.equals(BuildConfig.FLAVOR)) {
                instaGetListInput5.max_id = listInput.max_id;
            }
            ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetComments(instaGetListInput5, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.10
                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onResponse(Call call, Object obj) {
                    InstaGetCommentsOutput instaGetCommentsOutput = (InstaGetCommentsOutput) obj;
                    ArrayList<? extends PresenterItem> arrayList = new ArrayList<>();
                    ArrayList<InstaCommentObject> arrayList2 = instaGetCommentsOutput.comments;
                    if (arrayList2 != null) {
                        Iterator<InstaCommentObject> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            InstaCommentObject next = it.next();
                            next.isLiked = instaGetCommentsOutput.liked_comments.contains(next.id);
                            InstaCommentObject instaCommentObject = next.first_child_comment;
                            if (instaCommentObject != null) {
                                instaCommentObject.isLiked = instaGetCommentsOutput.liked_comments.contains(instaCommentObject.id);
                            }
                            arrayList.add(next);
                        }
                    }
                    listener.onResponse(arrayList, null);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onFailure(Call call, Throwable th) {
                    listener.onFailure(th);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onError(MessangerOutput messangerOutput) {
                    listener.onFailure(null);
                }
            });
        } else if (itemType == ListInput.ItemType.instaReply) {
            InstaGetListInput instaGetListInput6 = new InstaGetListInput();
            instaGetListInput6.post_id = listInput.post_id;
            instaGetListInput6.limit = listInput.limit;
            instaGetListInput6.comment_id = listInput.comment_id;
            instaGetListInput6.sort = InstaGetListInput.SortEnum.FromMin;
            String str10 = listInput.min_id;
            if (str10 != null && !str10.equals(BuildConfig.FLAVOR)) {
                instaGetListInput6.min_id = listInput.min_id;
            }
            ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetCommentReplies(instaGetListInput6, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.11
                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onResponse(Call call, Object obj) {
                    InstaGetCommentsOutput instaGetCommentsOutput = (InstaGetCommentsOutput) obj;
                    ArrayList<? extends PresenterItem> arrayList = new ArrayList<>();
                    ArrayList<InstaCommentObject> arrayList2 = instaGetCommentsOutput.comments;
                    if (arrayList2 != null) {
                        Iterator<InstaCommentObject> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            InstaCommentObject next = it.next();
                            next.isLiked = instaGetCommentsOutput.liked_comments.contains(next.id);
                            next.isReply = true;
                            arrayList.add(next);
                        }
                    }
                    listener.onResponse(arrayList, null);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onFailure(Call call, Throwable th) {
                    listener.onFailure(th);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onError(MessangerOutput messangerOutput) {
                    listener.onFailure(null);
                }
            });
        } else {
            ListInput.ItemType itemType2 = ListInput.ItemType.instaFollowers;
            if (itemType == itemType2 || itemType == ListInput.ItemType.instaFollowing) {
                InstaGetListInput instaGetListInput7 = new InstaGetListInput();
                instaGetListInput7.limit = listInput.limit;
                instaGetListInput7.target_profile_id = listInput.target_profile_id;
                String str11 = listInput.max_id;
                if (str11 != null && !str11.equals(BuildConfig.FLAVOR)) {
                    instaGetListInput7.max_id = listInput.max_id;
                }
                if (listInput.itemType == itemType2) {
                    instaGetListInput7.f_type = InstaGetListInput.TypeEnum.Follower;
                } else {
                    instaGetListInput7.f_type = InstaGetListInput.TypeEnum.Following;
                }
                ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetProfileFollowers(instaGetListInput7, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.12
                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onResponse(Call call, Object obj) {
                        InstaGetProfilesOutput instaGetProfilesOutput = (InstaGetProfilesOutput) obj;
                        ArrayList<InstaProfileObject> arrayList = instaGetProfilesOutput.profiles;
                        if (arrayList != null) {
                            Iterator<InstaProfileObject> it = arrayList.iterator();
                            while (it.hasNext()) {
                                InstaProfileObject next = it.next();
                                ArrayList<String> arrayList2 = instaGetProfilesOutput.following_list;
                                boolean z = true;
                                next.isFollowed = arrayList2 != null && arrayList2.contains(next.id);
                                ArrayList<String> arrayList3 = instaGetProfilesOutput.i_request;
                                next.isRequested = arrayList3 != null && arrayList3.contains(next.id);
                                ArrayList<String> arrayList4 = instaGetProfilesOutput.i_blocked;
                                if (arrayList4 == null || !arrayList4.contains(next.id)) {
                                    z = false;
                                }
                                next.isBlocked = z;
                            }
                            listener.onResponse(instaGetProfilesOutput.profiles, null);
                            return;
                        }
                        listener.onResponse(new ArrayList<>(), null);
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onFailure(Call call, Throwable th) {
                        listener.onFailure(th);
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onError(MessangerOutput messangerOutput) {
                        listener.onFailure(null);
                    }
                });
            } else if (itemType == ListInput.ItemType.instaSuggestedProfiles) {
                InstaGetListInput instaGetListInput8 = new InstaGetListInput();
                instaGetListInput8.limit = listInput.limit;
                instaGetListInput8.sort = InstaGetListInput.SortEnum.FromMax;
                String str12 = listInput.max_id;
                if (str12 != null && !str12.equals(BuildConfig.FLAVOR)) {
                    instaGetListInput8.max_id = listInput.max_id;
                }
                ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetSuggestedProfiles(instaGetListInput8, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.13
                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onResponse(Call call, Object obj) {
                        InstaGetProfilesOutput instaGetProfilesOutput = (InstaGetProfilesOutput) obj;
                        ArrayList<InstaProfileObject> arrayList = instaGetProfilesOutput.profiles;
                        if (arrayList != null) {
                            Iterator<InstaProfileObject> it = arrayList.iterator();
                            while (it.hasNext()) {
                                InstaProfileObject next = it.next();
                                ArrayList<String> arrayList2 = instaGetProfilesOutput.following_list;
                                boolean z = true;
                                next.isFollowed = arrayList2 != null && arrayList2.contains(next.id);
                                ArrayList<String> arrayList3 = instaGetProfilesOutput.i_request;
                                next.isRequested = arrayList3 != null && arrayList3.contains(next.id);
                                ArrayList<String> arrayList4 = instaGetProfilesOutput.i_blocked;
                                if (arrayList4 == null || !arrayList4.contains(next.id)) {
                                    z = false;
                                }
                                next.isBlocked = z;
                            }
                            listener.onResponse(instaGetProfilesOutput.profiles, null);
                            return;
                        }
                        listener.onResponse(new ArrayList<>(), null);
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onFailure(Call call, Throwable th) {
                        listener.onFailure(th);
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onError(MessangerOutput messangerOutput) {
                        listener.onFailure(null);
                    }
                });
            } else if (itemType == ListInput.ItemType.instaNewEvents) {
                InstaGetListInput instaGetListInput9 = new InstaGetListInput();
                instaGetListInput9.limit = listInput.limit;
                String str13 = listInput.max_id;
                if (str13 != null && !str13.equals(BuildConfig.FLAVOR)) {
                    instaGetListInput9.max_id = listInput.max_id;
                }
                ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetNewEvents(instaGetListInput9, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.14
                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onResponse(Call call, Object obj) {
                        ArrayList<RubinoNewEventObject> arrayList = ((InstaGetNewEventsOutput) obj).records;
                        if (arrayList != null) {
                            listener.onResponse(arrayList, null);
                        } else {
                            listener.onResponse(new ArrayList<>(), null);
                        }
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onFailure(Call call, Throwable th) {
                        listener.onFailure(th);
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onError(MessangerOutput messangerOutput) {
                        listener.onFailure(null);
                    }
                });
            } else if (itemType == ListInput.ItemType.instaSaleNotif) {
                InstaGetListInput instaGetListInput10 = new InstaGetListInput();
                instaGetListInput10.limit = listInput.limit;
                instaGetListInput10.sort = InstaGetListInput.SortEnum.FromMax;
                String str14 = listInput.max_id;
                if (str14 != null && !str14.equals(BuildConfig.FLAVOR)) {
                    instaGetListInput10.max_id = listInput.max_id;
                }
                ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetSaleList(instaGetListInput10, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.15
                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onResponse(Call call, Object obj) {
                        ArrayList<InstaSaleNotificationObject> arrayList = ((InstaGetSaleListOutput) obj).records;
                        if (arrayList != null) {
                            listener.onResponse(arrayList, null);
                        } else {
                            listener.onResponse(new ArrayList<>(), null);
                        }
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onFailure(Call call, Throwable th) {
                        listener.onFailure(th);
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onError(MessangerOutput messangerOutput) {
                        listener.onFailure(null);
                    }
                });
            } else if (itemType == ListInput.ItemType.instaPurchaseNotif) {
                InstaGetListInput instaGetListInput11 = new InstaGetListInput();
                instaGetListInput11.limit = listInput.limit;
                instaGetListInput11.sort = InstaGetListInput.SortEnum.FromMax;
                String str15 = listInput.max_id;
                if (str15 != null && !str15.equals(BuildConfig.FLAVOR)) {
                    instaGetListInput11.max_id = listInput.max_id;
                }
                ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetPurchaseList(instaGetListInput11, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.16
                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onResponse(Call call, Object obj) {
                        ArrayList<InstaPurchaseNotificationObject> arrayList = ((InstaGetPurchaseListOutput) obj).records;
                        if (arrayList != null) {
                            listener.onResponse(arrayList, null);
                        } else {
                            listener.onResponse(new ArrayList<>(), null);
                        }
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onFailure(Call call, Throwable th) {
                        listener.onFailure(th);
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onError(MessangerOutput messangerOutput) {
                        listener.onFailure(null);
                    }
                });
            } else if (itemType == ListInput.ItemType.instaPostSale) {
                InstaGetListInput instaGetListInput12 = new InstaGetListInput();
                instaGetListInput12.limit = listInput.limit;
                instaGetListInput12.sort = InstaGetListInput.SortEnum.FromMax;
                instaGetListInput12.post_profile_id = listInput.post_profile_id;
                instaGetListInput12.post_id = listInput.post_id;
                String str16 = listInput.max_id;
                if (str16 != null && !str16.equals(BuildConfig.FLAVOR)) {
                    instaGetListInput12.max_id = listInput.max_id;
                }
                ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetPostSaleList(instaGetListInput12, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.17
                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onResponse(Call call, Object obj) {
                        ArrayList<InstaSaleNotificationObject> arrayList = ((InstaGetPostSaleListOutput) obj).records;
                        if (arrayList != null) {
                            listener.onResponse(arrayList, null);
                        } else {
                            listener.onResponse(new ArrayList<>(), null);
                        }
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onFailure(Call call, Throwable th) {
                        listener.onFailure(th);
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onError(MessangerOutput messangerOutput) {
                        listener.onFailure(null);
                    }
                });
            } else if (itemType == ListInput.ItemType.newestNews) {
                ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getNewestNewsList(new GetNewsListInput(listInput.categoryId, listInput.first_index / 10), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.18
                    @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                    public void onResponse(Call call, Response response) {
                        GetNewsListOutput.NewsList newsList;
                        ArrayList<NewsObject> arrayList;
                        if (response != null && response.body() != null) {
                            GetNewsListOutput getNewsListOutput = (GetNewsListOutput) response.body();
                            if (getNewsListOutput != null && (newsList = getNewsListOutput.result) != null && (arrayList = newsList.newsList) != null) {
                                listener.onResponse(arrayList, null);
                                return;
                            } else {
                                listener.onFailure(null);
                                return;
                            }
                        }
                        listener.onFailure(null);
                    }

                    @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                    public void onFailure(Call call, Throwable th) {
                        listener.onFailure(th);
                    }
                });
            } else if (itemType == ListInput.ItemType.mostVisitedNews) {
                ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getMostVisitedNewsList(new GetNewsListInput(listInput.categoryId, listInput.first_index / 10), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.19
                    @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                    public void onResponse(Call call, Response response) {
                        GetNewsListOutput.NewsList newsList;
                        ArrayList<NewsObject> arrayList;
                        if (response != null && response.body() != null) {
                            GetNewsListOutput getNewsListOutput = (GetNewsListOutput) response.body();
                            if (getNewsListOutput != null && (newsList = getNewsListOutput.result) != null && (arrayList = newsList.newsList) != null) {
                                listener.onResponse(arrayList, null);
                                return;
                            } else {
                                listener.onFailure(null);
                                return;
                            }
                        }
                        listener.onFailure(null);
                    }

                    @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                    public void onFailure(Call call, Throwable th) {
                        listener.onFailure(th);
                    }
                });
            } else if (itemType == ListInput.ItemType.payItem) {
                ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getListPay(new GetListPayInput(AppPreferences.getInstance(UserConfig.selectedAccount).getString(AppPreferences.Key.token780), listInput.payListName, UpdateUtils.getAppVersion(context), listInput.payListTargetMobile), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.20
                    @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                    public void onResponse(Call call, Response response) {
                        GetListPayObject getListPayObject = ((GetListPayOutput2) response.body()).result;
                        ArrayList<GetListPayObject.List> arrayList = getListPayObject.multi_list_resp;
                        if (arrayList != null && arrayList.size() > 0) {
                            GetListPayObject.List list = getListPayObject.multi_list_resp.get(0);
                            ArrayList<GetListPayObject.Item> arrayList2 = list.item_list;
                            if (arrayList2 != null && arrayList2.size() > 0) {
                                listener.onResponse(list.item_list, null);
                                return;
                            } else {
                                listener.onFailure(null);
                                return;
                            }
                        }
                        listener.onFailure(null);
                    }

                    @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                    public void onFailure(Call call, Throwable th) {
                        listener.onFailure(th);
                    }
                });
            } else if (itemType == ListInput.ItemType.contact) {
                Utilities.myQueue.postRunnable(new Runnable(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.21
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            } else if (itemType != ListInput.ItemType.chatUser) {
                if (itemType == ListInput.ItemType.chatMessage || itemType == ListInput.ItemType.channelMessages || itemType == ListInput.ItemType.media) {
                    listener.onResponse(new ArrayList<>(), null);
                } else if (itemType == ListInput.ItemType.array) {
                    new Handler().postDelayed(new Runnable(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.22
                        @Override // java.lang.Runnable
                        public void run() {
                            ListInput listInput2 = listInput;
                            int i = listInput2.first_index;
                            if (i == 0 || i == 1) {
                                if (listInput2.arrayList == null) {
                                    listInput2.arrayList = new ArrayList<>();
                                }
                                listener.onResponse(listInput.arrayList, null);
                                return;
                            }
                            listener.onResponse(new ArrayList<>(), null);
                        }
                    }, 100L);
                } else if (itemType == ListInput.ItemType.endpointComment) {
                    final GetListInputByStartId getListInputByStartId = new GetListInputByStartId();
                    getListInputByStartId.cat_id = listInput.cat_id;
                    getListInputByStartId.object_id = listInput.object_id;
                    getListInputByStartId.limit = Integer.valueOf(listInput.limit);
                    getListInputByStartId.sort_by = GetListInputByStartId.CommentSortEnum.NewFirst;
                    getListInputByStartId.start_id = listInput.start_id;
                    ApiRequestMessanger.getInstance(UserConfig.selectedAccount).getComments(getListInputByStartId, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.23
                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onResponse(Call call, Object obj) {
                            GetCommentsOutput getCommentsOutput = (GetCommentsOutput) obj;
                            if (getCommentsOutput != null) {
                                listInput.start_id = getCommentsOutput.next_start_id;
                                ArrayList<EndPointCommentObject> arrayList = getCommentsOutput.comments;
                                if (arrayList != null) {
                                    Iterator<EndPointCommentObject> it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        EndPointCommentObject next = it.next();
                                        GetListInputByStartId getListInputByStartId2 = getListInputByStartId;
                                        next.catId = getListInputByStartId2.cat_id;
                                        next.objectId = getListInputByStartId2.object_id;
                                        next.isLiked = getCommentsOutput.liked_comments.contains(next.comment_id);
                                        next.isDisLiked = getCommentsOutput.disliked_comments.contains(next.comment_id);
                                    }
                                    listener.onResponse(getCommentsOutput.comments, null);
                                    return;
                                }
                                listener.onFailure(null);
                            }
                        }

                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onFailure(Call call, Throwable th) {
                            listener.onFailure(th);
                        }

                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onError(MessangerOutput messangerOutput) {
                            listener.onFailure(null);
                        }
                    });
                } else {
                    if (itemType == ListInput.ItemType.explorPost) {
                        InstaGetListInput instaGetListInput13 = new InstaGetListInput();
                        String str17 = listInput.start_id;
                        if (str17 != null && !str17.equals(BuildConfig.FLAVOR)) {
                            instaGetListInput13.max_id = listInput.start_id;
                        }
                        instaGetListInput13.limit = listInput.limit;
                        instaGetListInput13.sort = InstaGetListInput.SortEnum.FromMax;
                        instaGetListInput13.topic_id = listInput.topic_id;
                        Call<MessangerOutput<InstaGetPostsOutput>> callInstaGetExplorePosts = ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetExplorePosts(instaGetListInput13, new AnonymousClass24(this, listInput, new ArrayList(), listener));
                        this.lastCall = callInstaGetExplorePosts;
                        return callInstaGetExplorePosts;
                    }
                    if (itemType == ListInput.ItemType.relatedProfiles) {
                        InstaGetListInput instaGetListInput14 = new InstaGetListInput();
                        String str18 = listInput.start_id;
                        if (str18 != null && !str18.equals(BuildConfig.FLAVOR)) {
                            instaGetListInput14.start_id = listInput.start_id;
                        }
                        instaGetListInput14.limit = listInput.limit;
                        instaGetListInput14.target_profile_id = listInput.target_profile_id;
                        ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaGetRelatedProfiles(instaGetListInput14, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.25
                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onResponse(Call call, Object obj) {
                                InstaGetRelatedProfilesOutput instaGetRelatedProfilesOutput = (InstaGetRelatedProfilesOutput) obj;
                                if (instaGetRelatedProfilesOutput != null) {
                                    String str19 = instaGetRelatedProfilesOutput.next_start_id;
                                    if (str19 != null) {
                                        listInput.start_id = str19;
                                    }
                                    ArrayList<InstaProfileObject> arrayList = instaGetRelatedProfilesOutput.related_profiles;
                                    if (arrayList != null) {
                                        listener.onResponse(arrayList, null);
                                        return;
                                    } else {
                                        listener.onResponse(new ArrayList<>(), null);
                                        return;
                                    }
                                }
                                listener.onResponse(new ArrayList<>(), null);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onFailure(Call call, Throwable th) {
                                listener.onFailure(th);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onError(MessangerOutput messangerOutput) {
                                listener.onFailure(null);
                            }
                        });
                    } else if (itemType == ListInput.ItemType.province) {
                        final ArrayList arrayList = new ArrayList();
                        ApiRequestMessanger.getInstance(UserConfig.selectedAccount).getDeliveryProvinces(new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.26
                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onResponse(Call call, Object obj) {
                                ArrayList<DeliveryProvinceObject> arrayList2;
                                GetDeliverProvinceOutput getDeliverProvinceOutput = (GetDeliverProvinceOutput) obj;
                                if (getDeliverProvinceOutput != null && (arrayList2 = getDeliverProvinceOutput.provinces) != null) {
                                    arrayList.addAll(arrayList2);
                                }
                                listener.onResponse(arrayList, null);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onFailure(Call call, Throwable th) {
                                listener.onFailure(th);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onError(MessangerOutput messangerOutput) {
                                listener.onFailure(null);
                            }
                        });
                    } else if (itemType == ListInput.ItemType.city) {
                        final ArrayList arrayList2 = new ArrayList();
                        ApiRequestMessanger.getInstance(UserConfig.selectedAccount).getDeliveryCities(new GetDeliverCityInput(listInput.provinceId), new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.27
                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onResponse(Call call, Object obj) {
                                ArrayList<DeliveryCityObject> arrayList3;
                                GetDeliverCityOutput getDeliverCityOutput = (GetDeliverCityOutput) obj;
                                if (getDeliverCityOutput != null && (arrayList3 = getDeliverCityOutput.cities) != null) {
                                    arrayList2.addAll(arrayList3);
                                }
                                listener.onResponse(arrayList2, null);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onFailure(Call call, Throwable th) {
                                listener.onFailure(th);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onError(MessangerOutput messangerOutput) {
                                listener.onFailure(null);
                            }
                        });
                    } else if (itemType == ListInput.ItemType.deliveryInfos) {
                        final ArrayList arrayList3 = new ArrayList();
                        ApiRequestMessanger.getInstance(UserConfig.selectedAccount).getAllDeliveryInfo(new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.28
                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onResponse(Call call, Object obj) {
                                ArrayList<DeliveryInfoObject> arrayList4;
                                GetAllDeliveryInfoOutput getAllDeliveryInfoOutput = (GetAllDeliveryInfoOutput) obj;
                                if (getAllDeliveryInfoOutput != null && (arrayList4 = getAllDeliveryInfoOutput.delivery_infos) != null) {
                                    arrayList3.addAll(arrayList4);
                                }
                                listener.onResponse(arrayList3, null);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onFailure(Call call, Throwable th) {
                                listener.onFailure(th);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onError(MessangerOutput messangerOutput) {
                                listener.onFailure(null);
                            }
                        });
                    } else if (itemType == ListInput.ItemType.deliveryType) {
                        final ArrayList arrayList4 = new ArrayList();
                        GetDeliveryTypesInput getDeliveryTypesInput = new GetDeliveryTypesInput();
                        ListInput.DeliveryTypeInput deliveryTypeInput = listInput.deliveryTypeInput;
                        getDeliveryTypesInput.basket_id = deliveryTypeInput.basket_id;
                        getDeliveryTypesInput.delivery_info_id = deliveryTypeInput.delivery_info_id;
                        ApiRequestMessanger.getInstance(UserConfig.selectedAccount).getDeliveryTypes(getDeliveryTypesInput, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.29
                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onResponse(Call call, Object obj) {
                                ArrayList<DeliveryTypeObject> arrayList5;
                                GetDeliveryTypeOutput getDeliveryTypeOutput = (GetDeliveryTypeOutput) obj;
                                if (getDeliveryTypeOutput != null && (arrayList5 = getDeliveryTypeOutput.delivery_types) != null) {
                                    arrayList4.addAll(arrayList5);
                                }
                                listener.onResponse(arrayList4, null);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onFailure(Call call, Throwable th) {
                                listener.onFailure(th);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onError(MessangerOutput messangerOutput) {
                                listener.onFailure(null);
                            }
                        });
                    } else if (itemType == ListInput.ItemType.deliveryTime) {
                        final ArrayList arrayList5 = new ArrayList();
                        GetDeliveryTimesInput getDeliveryTimesInput = listInput.deliveryTimesInput;
                        if (getDeliveryTimesInput == null) {
                            listener.onFailure(null);
                        } else {
                            ApiRequestMessanger.getInstance(UserConfig.selectedAccount).getDeliveryTimes(getDeliveryTimesInput, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.30
                                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                                public void onResponse(Call call, Object obj) {
                                    ArrayList<DeliveryTimeObject> arrayList6;
                                    GetDeliveryTimesOutput getDeliveryTimesOutput = (GetDeliveryTimesOutput) obj;
                                    if (getDeliveryTimesOutput != null && (arrayList6 = getDeliveryTimesOutput.delivery_times) != null) {
                                        arrayList5.addAll(arrayList6);
                                    }
                                    listener.onResponse(arrayList5, null);
                                }

                                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                                public void onFailure(Call call, Throwable th) {
                                    listener.onFailure(th);
                                }

                                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                                public void onError(MessangerOutput messangerOutput) {
                                    listener.onFailure(null);
                                }
                            });
                        }
                    } else if (itemType == ListInput.ItemType.basket) {
                        final ArrayList arrayList6 = new ArrayList();
                        ApiRequestMessanger.getInstance(UserConfig.selectedAccount).getBasketList(new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.31
                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onResponse(Call call, Object obj) {
                                ArrayList<BasketObject> arrayList7;
                                GetBasketListOutput getBasketListOutput = (GetBasketListOutput) obj;
                                if (getBasketListOutput != null && (arrayList7 = getBasketListOutput.baskets) != null) {
                                    arrayList6.addAll(arrayList7);
                                }
                                listener.onResponse(arrayList6, null);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onFailure(Call call, Throwable th) {
                                listener.onFailure(th);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onError(MessangerOutput messangerOutput) {
                                listener.onFailure(null);
                            }
                        });
                    } else if (itemType == ListInput.ItemType.paidOrder) {
                        final ArrayList arrayList7 = new ArrayList();
                        GetListInputByStartId getListInputByStartId2 = new GetListInputByStartId();
                        getListInputByStartId2.limit = Integer.valueOf(listInput.limit);
                        PaidOrdersInput paidOrdersInput = listInput.paidOrdersInput;
                        if (paidOrdersInput != null) {
                            getListInputByStartId2.type = paidOrdersInput.type;
                        }
                        String str19 = listInput.start_id;
                        if (str19 != null) {
                            getListInputByStartId2.start_id = str19;
                        }
                        ApiRequestMessanger.getInstance(UserConfig.selectedAccount).getPaidOrders(getListInputByStartId2, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.32
                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onResponse(Call call, Object obj) {
                                String str20;
                                ArrayList<OrderObject> arrayList8;
                                GetPaidOrdersOutput getPaidOrdersOutput = (GetPaidOrdersOutput) obj;
                                if (getPaidOrdersOutput != null && (arrayList8 = getPaidOrdersOutput.paid_orders) != null) {
                                    arrayList7.addAll(arrayList8);
                                }
                                if (getPaidOrdersOutput != null && (str20 = getPaidOrdersOutput.next_start_id) != null) {
                                    listInput.start_id = str20;
                                }
                                listener.onResponse(arrayList7, null);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onFailure(Call call, Throwable th) {
                                listener.onFailure(th);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onError(MessangerOutput messangerOutput) {
                                listener.onFailure(null);
                            }
                        });
                    } else if (itemType == ListInput.ItemType.viewTag) {
                        if (listInput.viewTagObject == null) {
                            listener.onFailure(null);
                        }
                        final ArrayList arrayList8 = new ArrayList();
                        GetListInputByStartId getListInputByStartId3 = new GetListInputByStartId();
                        getListInputByStartId3.tag_id = listInput.viewTagObject.tag_id;
                        getListInputByStartId3.limit = Integer.valueOf(listInput.limit);
                        getListInputByStartId3.related_object_id = listInput.viewTagObject.related_object_id;
                        String str20 = listInput.start_id;
                        if (str20 != null && !str20.isEmpty()) {
                            getListInputByStartId3.start_id = listInput.start_id;
                        }
                        ViewGroupObject viewGroupObject = listInput.viewTagObject.view;
                        if (viewGroupObject != null) {
                            getListInputByStartId3.view_version = viewGroupObject.view_version;
                        }
                        ApiRequestMessanger.getInstance(UserConfig.selectedAccount).getTagObjects(getListInputByStartId3, listInput.viewTagObject.api_url, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.33
                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onResponse(Call call, Object obj) {
                                GetTagObjectsOutput getTagObjectsOutput = (GetTagObjectsOutput) obj;
                                if (getTagObjectsOutput != null) {
                                    listInput.start_id = getTagObjectsOutput.next_start_id;
                                    ArrayList<ViewDataObject> arrayList9 = getTagObjectsOutput.objects;
                                    if (arrayList9 != null) {
                                        arrayList8.addAll(arrayList9);
                                    }
                                }
                                listener.onResponse(arrayList8, null);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onFailure(Call call, Throwable th) {
                                listener.onFailure(th);
                            }

                            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                            public void onError(MessangerOutput messangerOutput) {
                                listener.onFailure(null);
                            }
                        });
                    } else if (itemType == ListInput.ItemType.tag && (tagType = (tagObject = listInput.tagObject).type) != TagObject.TagType.dynamicView) {
                        if (tagType == TagObject.TagType.app) {
                            ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getAppAbsList(new GetListInput(tagObject, String.valueOf(listInput.first_index), String.valueOf(listInput.last_index)), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.34
                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onResponse(Call call, Response response) {
                                    GetListOutput getListOutput = (GetListOutput) response.body();
                                    listener.onResponse(getListOutput.results, getListOutput);
                                }

                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onFailure(Call call, Throwable th) {
                                    listener.onFailure(th);
                                }
                            });
                        } else if (tagType == TagObject.TagType.virtual_channel) {
                            final ArrayList arrayList9 = new ArrayList();
                            ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getVirtualChannelAbsList(new GetListInput(listInput.tagObject, String.valueOf(listInput.first_index), String.valueOf(listInput.last_index)), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.35
                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onResponse(Call call, Response response) {
                                    MyLog.e("itemlistRequest", "onResponse");
                                    GetListOutput getListOutput = (GetListOutput) response.body();
                                    arrayList9.addAll(getListOutput.results);
                                    MyLog.e("itemlistRequest", "onResponse" + getListOutput.results.size());
                                    MyLog.e("itemlistRequest", "onResponse" + arrayList9.size());
                                    listener.onResponse(arrayList9, getListOutput);
                                }

                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onFailure(Call call, Throwable th) {
                                    listener.onFailure(th);
                                    MyLog.e("itemlistRequest", "onFailure");
                                }
                            });
                        } else if (tagType == TagObject.TagType.vod_film) {
                            final ArrayList arrayList10 = new ArrayList();
                            ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getVODObjectAbsList(new GetListInput(listInput.tagObject, String.valueOf(listInput.first_index), String.valueOf(listInput.last_index)), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.36
                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onResponse(Call call, Response response) {
                                    GetListOutput getListOutput = (GetListOutput) response.body();
                                    arrayList10.addAll(getListOutput.results);
                                    listener.onResponse(arrayList10, getListOutput);
                                }

                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onFailure(Call call, Throwable th) {
                                    listener.onFailure(th);
                                    MyLog.e("itemlistRequest", "onFailure");
                                }
                            });
                        } else if (tagType == TagObject.TagType.item_link) {
                            final ArrayList arrayList11 = new ArrayList();
                            ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getLinkItemList(new GetListInput(listInput.tagObject, String.valueOf(listInput.first_index), String.valueOf(listInput.last_index)), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.37
                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onResponse(Call call, Response response) {
                                    GetListOutput getListOutput = (GetListOutput) response.body();
                                    arrayList11.addAll(getListOutput.results);
                                    listener.onResponse(arrayList11, getListOutput);
                                }

                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onFailure(Call call, Throwable th) {
                                    listener.onFailure(th);
                                    MyLog.e("itemlistRequest", "onFailure");
                                }
                            });
                        } else if (tagType == TagObject.TagType.tv_episode) {
                            final ArrayList arrayList12 = new ArrayList();
                            ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getTVEpisodeObjectAbsList(new GetListInput(listInput.tagObject, String.valueOf(listInput.first_index), String.valueOf(listInput.last_index)), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.38
                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onResponse(Call call, Response response) {
                                    GetListOutput getListOutput = (GetListOutput) response.body();
                                    arrayList12.addAll(getListOutput.results);
                                    listener.onResponse(arrayList12, getListOutput);
                                }

                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onFailure(Call call, Throwable th) {
                                    listener.onFailure(th);
                                    MyLog.e("itemlistRequest", "onFailure");
                                }
                            });
                        } else if (tagType == TagObject.TagType.tv_channel) {
                            final ArrayList arrayList13 = new ArrayList();
                            ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getTVChannelAbsList(new GetListInput(listInput.tagObject, String.valueOf(listInput.first_index), String.valueOf(listInput.last_index)), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.39
                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onResponse(Call call, Response response) {
                                    GetListOutput getListOutput = (GetListOutput) response.body();
                                    arrayList13.addAll(getListOutput.results);
                                    listener.onResponse(arrayList13, getListOutput);
                                }

                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onFailure(Call call, Throwable th) {
                                    listener.onFailure(th);
                                    MyLog.e("itemlistRequest", "onFailure");
                                }
                            });
                        } else if (tagType == TagObject.TagType.aod_track) {
                            final ArrayList arrayList14 = new ArrayList();
                            ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getAODObjectAbsList(new GetListInput(listInput.tagObject, String.valueOf(listInput.first_index), String.valueOf(listInput.last_index)), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.40
                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onResponse(Call call, Response response) {
                                    GetListOutput getListOutput = (GetListOutput) response.body();
                                    arrayList14.addAll(getListOutput.results);
                                    listener.onResponse(arrayList14, getListOutput);
                                }

                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onFailure(Call call, Throwable th) {
                                    listener.onFailure(th);
                                    MyLog.e("itemlistRequest", "onFailure");
                                }
                            });
                        } else if (tagType == TagObject.TagType.operator) {
                            final ArrayList arrayList15 = new ArrayList();
                            ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getOperators(new GetListInput(listInput.tagObject, String.valueOf(listInput.first_index), String.valueOf(listInput.last_index)), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.41
                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onResponse(Call call, Response response) {
                                    GetListOutput getListOutput = (GetListOutput) response.body();
                                    arrayList15.addAll(getListOutput.results);
                                    listener.onResponse(arrayList15, getListOutput);
                                }

                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onFailure(Call call, Throwable th) {
                                    listener.onFailure(th);
                                    MyLog.e("itemlistRequest", "onFailure");
                                }
                            });
                        } else if (tagType == TagObject.TagType.course) {
                            final ArrayList arrayList16 = new ArrayList();
                            ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getlmsCourceList(new GetListInput(listInput.tagObject, String.valueOf(listInput.first_index), String.valueOf(listInput.last_index)), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.42
                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onResponse(Call call, Response response) {
                                    GetListOutput getListOutput = (GetListOutput) response.body();
                                    arrayList16.addAll(getListOutput.results);
                                    listener.onResponse(arrayList16, getListOutput);
                                }

                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onFailure(Call call, Throwable th) {
                                    listener.onFailure(th);
                                    MyLog.e("itemlistRequest", "onFailure");
                                }
                            });
                        } else if (listInput.tagObject.type == TagObject.TagType.vchannel_item) {
                            final ArrayList arrayList17 = new ArrayList();
                            ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getVChannelItemList(new GetListInput(listInput.tagObject, String.valueOf(listInput.first_index), String.valueOf(listInput.last_index)), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.43
                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onResponse(Call call, Response response) {
                                    GetListOutput getListOutput = (GetListOutput) response.body();
                                    arrayList17.addAll(getListOutput.results);
                                    listener.onResponse(arrayList17, getListOutput);
                                }

                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onFailure(Call call, Throwable th) {
                                    listener.onFailure(th);
                                    MyLog.e("itemlistRequest", "onFailure");
                                }
                            });
                        } else if (listInput.tagObject.type == TagObject.TagType.large_banner) {
                            final ArrayList arrayList18 = new ArrayList();
                            ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getLargeBannerList(new GetListInput(listInput.tagObject, String.valueOf(listInput.first_index), String.valueOf(listInput.last_index)), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.44
                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onResponse(Call call, Response response) {
                                    GetListOutput getListOutput = (GetListOutput) response.body();
                                    arrayList18.addAll(getListOutput.results);
                                    listener.onResponse(arrayList18, getListOutput);
                                }

                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onFailure(Call call, Throwable th) {
                                    listener.onFailure(th);
                                    MyLog.e("itemlistRequest", "onFailure");
                                }
                            });
                        } else if (listInput.tagObject.type == TagObject.TagType.comment) {
                            final ArrayList arrayList19 = new ArrayList();
                            ApiRequestIPTV.getInstance(UserConfig.selectedAccount).getComments(new GetListInput(listInput.tagObject, String.valueOf(listInput.first_index), String.valueOf(listInput.last_index)), new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.helper.ItemListRequest.45
                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onResponse(Call call, Response response) {
                                    GetListOutput getListOutput = (GetListOutput) response.body();
                                    arrayList19.addAll(getListOutput.results);
                                    listener.onResponse(arrayList19, getListOutput);
                                }

                                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                                public void onFailure(Call call, Throwable th) {
                                    listener.onFailure(th);
                                    MyLog.e("itemlistRequest", "onFailure");
                                }
                            });
                        }
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: ir.resaneh1.iptv.helper.ItemListRequest$24, reason: invalid class name */
    class AnonymousClass24 implements ApiRequestMessanger.Listener {
        final /* synthetic */ ListInput val$listInput;
        final /* synthetic */ Listener val$listener;
        final /* synthetic */ ArrayList val$result;

        AnonymousClass24(ItemListRequest itemListRequest, ListInput listInput, ArrayList arrayList, Listener listener) {
            this.val$listInput = listInput;
            this.val$result = arrayList;
            this.val$listener = listener;
        }

        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
        public void onResponse(Call call, final Object obj) {
            if (call.isCanceled()) {
                return;
            }
            Utilities.myQueue.postRunnable(new Runnable() { // from class: ir.resaneh1.iptv.helper.ItemListRequest.24.1
                @Override // java.lang.Runnable
                public void run() {
                    InstaGetPostsOutput instaGetPostsOutput = (InstaGetPostsOutput) obj;
                    if (instaGetPostsOutput != null) {
                        String str = instaGetPostsOutput.next_start_id;
                        if (str != null) {
                            AnonymousClass24.this.val$listInput.start_id = str;
                        }
                        if (instaGetPostsOutput.posts != null) {
                            int i = 0;
                            while (i < instaGetPostsOutput.posts.size()) {
                                InstaPostObject instaPostObject = instaGetPostsOutput.posts.get(i);
                                int i2 = i + 1;
                                InstaPostObject instaPostObject2 = null;
                                InstaPostObject instaPostObject3 = i2 < instaGetPostsOutput.posts.size() ? instaGetPostsOutput.posts.get(i2) : null;
                                int i3 = i2 + 1;
                                if (i3 < instaGetPostsOutput.posts.size()) {
                                    instaPostObject2 = instaGetPostsOutput.posts.get(i3);
                                }
                                AnonymousClass24.this.val$result.add(new ThreePostObject(instaPostObject, instaPostObject3, instaPostObject2));
                                i = i3 + 1;
                            }
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.helper.ItemListRequest.24.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass24 anonymousClass24 = AnonymousClass24.this;
                                    anonymousClass24.val$listener.onResponse(anonymousClass24.val$result, null);
                                }
                            });
                            return;
                        }
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.helper.ItemListRequest.24.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass24 anonymousClass24 = AnonymousClass24.this;
                                anonymousClass24.val$listener.onResponse(anonymousClass24.val$result, null);
                            }
                        });
                        return;
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.helper.ItemListRequest.24.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass24.this.val$listener.onResponse(new ArrayList<>(), null);
                        }
                    });
                }
            });
        }

        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
        public void onFailure(Call call, Throwable th) {
            this.val$listener.onFailure(th);
        }

        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
        public void onError(MessangerOutput messangerOutput) {
            this.val$listener.onFailure(null);
        }
    }
}
