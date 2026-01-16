package ir.resaneh1.iptv.apiMessanger;

import io.reactivex.Observable;
import ir.appp.vod.domain.model.input.ActionOnMediaInput;
import ir.appp.vod.domain.model.input.GetCastRelatedInput;
import ir.appp.vod.domain.model.input.GetEpisodesInput;
import ir.appp.vod.domain.model.input.GetMediaInput;
import ir.appp.vod.domain.model.input.GetRelatedInput;
import ir.appp.vod.domain.model.output.GetCastRelatedOutput;
import ir.appp.vod.domain.model.output.GetEpisodesOutput;
import ir.appp.vod.domain.model.output.GetRelatedOutput;
import ir.appp.vod.domain.model.output.VodMediaEntityOutput;
import ir.resaneh1.iptv.model.AddEmojiSliderAnswerInput;
import ir.resaneh1.iptv.model.AddPollAnswerInput;
import ir.resaneh1.iptv.model.AddStoryInput;
import ir.resaneh1.iptv.model.AddStoryOutput;
import ir.resaneh1.iptv.model.AddViewStoryInput;
import ir.resaneh1.iptv.model.AddViewStoryOutput;
import ir.resaneh1.iptv.model.ClickLinkTrackInput;
import ir.resaneh1.iptv.model.DeleteStoryInput;
import ir.resaneh1.iptv.model.DeleteStoryOutput;
import ir.resaneh1.iptv.model.GameAddCommentInput;
import ir.resaneh1.iptv.model.GameAddCommentOutput;
import ir.resaneh1.iptv.model.GameGetCommentsInput;
import ir.resaneh1.iptv.model.GameGetCommentsOutput;
import ir.resaneh1.iptv.model.GameInput;
import ir.resaneh1.iptv.model.GameSendAnswerInput;
import ir.resaneh1.iptv.model.GameSendAnswerOutput;
import ir.resaneh1.iptv.model.GameUseReliveChanceInput;
import ir.resaneh1.iptv.model.GameUseReliveChanceOutput;
import ir.resaneh1.iptv.model.GetDynamicPageDataInput;
import ir.resaneh1.iptv.model.GetDynamicPageDataOutput;
import ir.resaneh1.iptv.model.GetDynamicPageViewsInput;
import ir.resaneh1.iptv.model.GetDynamicPageViewsOutput;
import ir.resaneh1.iptv.model.GetEmojiResultsInput;
import ir.resaneh1.iptv.model.GetEndpointDataInput;
import ir.resaneh1.iptv.model.GetEndpointDataOutput;
import ir.resaneh1.iptv.model.GetEndpointViewInput;
import ir.resaneh1.iptv.model.GetEndpointViewOutput;
import ir.resaneh1.iptv.model.GetGameInfoOutput;
import ir.resaneh1.iptv.model.GetGameStatusInput;
import ir.resaneh1.iptv.model.GetGameStatusOutput;
import ir.resaneh1.iptv.model.GetMyStoryListInput;
import ir.resaneh1.iptv.model.GetMyStoryListOutput;
import ir.resaneh1.iptv.model.GetPollResultProfilesInput;
import ir.resaneh1.iptv.model.GetProductDetailInput;
import ir.resaneh1.iptv.model.GetProductDetailOutput;
import ir.resaneh1.iptv.model.GetProductsInput;
import ir.resaneh1.iptv.model.GetProductsOutput;
import ir.resaneh1.iptv.model.GetProfilesStoriesInput;
import ir.resaneh1.iptv.model.GetProfilesStoriesOutput;
import ir.resaneh1.iptv.model.GetProfilesStoryListInput;
import ir.resaneh1.iptv.model.GetProfilesStoryListOutput;
import ir.resaneh1.iptv.model.GetStoreDetailInput;
import ir.resaneh1.iptv.model.GetStoreDetailOutput;
import ir.resaneh1.iptv.model.GetStoryIdsInput;
import ir.resaneh1.iptv.model.GetStoryIdsOutput;
import ir.resaneh1.iptv.model.GetStoryInput;
import ir.resaneh1.iptv.model.GetStoryOutput;
import ir.resaneh1.iptv.model.GetStorySettingInput;
import ir.resaneh1.iptv.model.GetStoryViewersInput;
import ir.resaneh1.iptv.model.GetStoryViewersOutput;
import ir.resaneh1.iptv.model.GetTasksInput;
import ir.resaneh1.iptv.model.GetTasksOutput;
import ir.resaneh1.iptv.model.HomePageModels;
import ir.resaneh1.iptv.model.InstaGetHashTagsOutput;
import ir.resaneh1.iptv.model.InstaGetListInput;
import ir.resaneh1.iptv.model.InstaGetProfilesOutput;
import ir.resaneh1.iptv.model.LiveModels;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.MessengerInput;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileInput;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileOutput;
import ir.resaneh1.iptv.model.RubinoUpdateProfilePhotoInput;
import ir.resaneh1.iptv.model.RubinoUpdateProfilePhotoOutput;
import ir.resaneh1.iptv.model.RubinoUploadFileOutput;
import ir.resaneh1.iptv.model.SendDataDynamicPageInput;
import ir.resaneh1.iptv.model.SendDataDynamicPageOutput;
import ir.resaneh1.iptv.model.SetDefaultDeliveryInfoInput;
import ir.resaneh1.iptv.model.SetStorySettingInput;
import ir.resaneh1.iptv.model.ShopModels;
import ir.resaneh1.iptv.model.StorySettingOutput;
import ir.resaneh1.iptv.model.messenger.SendTaskResultInput;
import ir.resaneh1.iptv.model.messenger.SendTaskResultOutput;
import ir.resaneh1.iptv.model.wallet.CashOutInput;
import ir.resaneh1.iptv.model.wallet.CashOutOutput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByTokenInput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByTokenOutput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByUrlInput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByUrlOutput;
import ir.resaneh1.iptv.model.wallet.CheckAllowReceiveInput;
import ir.resaneh1.iptv.model.wallet.CheckAllowReceiveOutput;
import ir.resaneh1.iptv.model.wallet.GetCurrenciesInput;
import ir.resaneh1.iptv.model.wallet.GetCurrenciesOutput;
import ir.resaneh1.iptv.model.wallet.GetWalletByShareLinkInput;
import ir.resaneh1.iptv.model.wallet.GetWalletByShareLinkOutput;
import ir.resaneh1.iptv.model.wallet.GetWalletShareLinkInput;
import ir.resaneh1.iptv.model.wallet.GetWalletShareLinkOutput;
import ir.resaneh1.iptv.model.wallet.GetWalletStatusInput;
import ir.resaneh1.iptv.model.wallet.GetWalletStatusOutput;
import ir.resaneh1.iptv.model.wallet.GetWalletTransactionsInput;
import ir.resaneh1.iptv.model.wallet.GetWalletTransactionsOutput;
import ir.resaneh1.iptv.model.wallet.TransferCreditInput;
import ir.resaneh1.iptv.model.wallet.TransferCreditOutput;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* loaded from: classes3.dex */
public interface RestApiMessangerRx {
    @POST
    Observable<MessangerOutput> actionOnMedia(@Url String str, @Body MessengerInput<ActionOnMediaInput> messengerInput);

    @POST
    Observable<MessangerOutput> actionOnRequest(@Url String str, @Body MessengerInput<Rubino.ActionOnRequestInput> messengerInput);

    @POST
    Observable<MessangerOutput> addEmojiSliderAnswer(@Url String str, @Body MessengerInput<AddEmojiSliderAnswerInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.AddHighlightOutput>> addHighlight(@Url String str, @Body MessengerInput<Rubino.AddHighlightInput> messengerInput);

    @POST
    Observable<MessangerOutput> addPollAnswer(@Url String str, @Body MessengerInput<AddPollAnswerInput> messengerInput);

    @POST
    Observable<MessangerOutput> addPostViewCount(@Url String str, @Body MessengerInput<Rubino.AddPostViewCountInput> messengerInput);

    @POST
    Observable<MessangerOutput> addPostViewTime(@Url String str, @Body MessengerInput<Rubino.AddPostViewTimeInput> messengerInput);

    @POST
    Observable<MessangerOutput<ShopModels.AddProductOutput>> addProduct(@Url String str, @Body MessengerInput<ShopModels.AddProductInput> messengerInput);

    @POST
    Observable<MessangerOutput<AddStoryOutput>> addStory(@Url String str, @Body MessengerInput<AddStoryInput> messengerInput);

    @POST
    Observable<MessangerOutput<AddViewStoryOutput>> addViewStory(@Url String str, @Body MessengerInput<AddViewStoryInput> messengerInput);

    @POST
    Observable<MessangerOutput> bookmarkPostAction(@Url String str, @Body MessengerInput<Rubino.BookmarkActionInput> messengerInput);

    @POST
    Observable<MessangerOutput<CashOutOutput>> cashOut(@Url String str, @Body MessengerInput<CashOutInput> messengerInput);

    @POST
    Observable<MessangerOutput<ChargeWalletByTokenOutput>> chargeWalletByToken(@Url String str, @Body MessengerInput<ChargeWalletByTokenInput> messengerInput);

    @POST
    Observable<MessangerOutput<ChargeWalletByUrlOutput>> chargeWalletByUrl(@Url String str, @Body MessengerInput<ChargeWalletByUrlInput> messengerInput);

    @POST
    Observable<MessangerOutput<CheckAllowReceiveOutput>> checkAllowReceive(@Url String str, @Body MessengerInput<CheckAllowReceiveInput> messengerInput);

    @POST
    Observable<MessangerOutput> clickLinkTrack(@Url String str, @Body MessengerInput<ClickLinkTrackInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileInfoOutput>> createPage(@Url String str, @Body MessengerInput<Rubino.CreateProfileInput> messengerInput);

    @POST
    Observable<MessangerOutput<ShopModels.DeleteProductOutput>> deleteProduct(@Url String str, @Body MessengerInput<ShopModels.DeleteProductInput> messengerInput);

    @POST
    Observable<MessangerOutput<DeleteStoryOutput>> deleteStory(@Url String str, @Body MessengerInput<DeleteStoryInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.EditHighlightOutput>> editHighlight(@Url String str, @Body MessengerInput<Rubino.EditHighlightInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.EditPostOutput>> editPost(@Url String str, @Body MessengerInput<Rubino.EditPostInput> messengerInput);

    @POST
    Observable<MessangerOutput<ShopModels.AddProductOutput>> editProduct(@Url String str, @Body MessengerInput<ShopModels.EditProductInput> messengerInput);

    @POST
    Observable<MessangerOutput> exitGame(@Url String str, @Body MessengerInput<GameInput> messengerInput);

    @POST
    Observable<MessangerOutput<GameAddCommentOutput>> gameAddComment(@Url String str, @Body MessengerInput<GameAddCommentInput> messengerInput);

    @POST
    Observable<MessangerOutput<GameGetCommentsOutput>> gameGetComments(@Url String str, @Body MessengerInput<GameGetCommentsInput> messengerInput);

    @POST
    Observable<MessangerOutput<GameSendAnswerOutput>> gameSendAnswer(@Url String str, @Body MessengerInput<GameSendAnswerInput> messengerInput);

    @POST
    Observable<MessangerOutput<GameUseReliveChanceOutput>> gameUseReliveChance(@Url String str, @Body MessengerInput<GameUseReliveChanceInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetPostsOutput>> getBookmarkedPosts(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetCastRelatedOutput>> getCastMedias(@Url String str, @Body MessengerInput<GetCastRelatedInput> messengerInput);

    @POST
    Observable<MessangerOutput<ShopModels.GetColorsOutput>> getColors(@Url String str, @Body MessengerInput<ShopModels.EmptyInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetCurrenciesOutput>> getCurrencies(@Url String str, @Body MessengerInput<GetCurrenciesInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetDynamicPageDataOutput>> getDynamicPageData(@Url String str, @Body MessengerInput<GetDynamicPageDataInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetDynamicPageViewsOutput>> getDynamicPageViews(@Url String str, @Body MessengerInput<GetDynamicPageViewsInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetEmojiResultsOutput>> getEmojiSliderResults(@Url String str, @Body MessengerInput<GetEmojiResultsInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetEndpointDataOutput>> getEndPointData(@Url String str, @Body MessengerInput<GetEndpointDataInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetEndpointViewOutput>> getEndPointView(@Url String str, @Body MessengerInput<GetEndpointViewInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetEpisodesOutput>> getEpisodes(@Url String str, @Body MessengerInput<GetEpisodesInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetExploreTopicsOutput>> getExplorePostTopics(@Url String str, @Body MessengerInput<Rubino.BaseInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetPostsOutput>> getExplorePosts(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @GET
    Observable<Response<ResponseBody>> getFileRubino(@Url String str, @Header("Range") String str2);

    @POST
    Observable<MessangerOutput<GetGameInfoOutput>> getGameInfo(@Url String str, @Body MessengerInput<GameInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetGameStatusOutput>> getGameStatus(@Url String str, @Body MessengerInput<GetGameStatusInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetPostsOutput>> getHashTagPosts(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetHashtagListOutput>> getHashTagTrend(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetStoryOutput>> getHighlightStories(@Url String str, @Body MessengerInput<Rubino.GetHighlightStoriesInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetStoryIdsOutput>> getHighlightStoryIds(@Url String str, @Body MessengerInput<Rubino.GetHighlightStoryIdsInput> messengerInput);

    @POST
    Observable<MessangerOutput<HomePageModels.GetHomePageOutput>> getHomePage(@Url String str, @Body MessengerInput<HomePageModels.GetHomePageInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileListOutput>> getLikedCommentProfiles(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<HomePageModels.GetLiveSectionItemsOutput>> getLiveSectionItems(@Url String str, @Body MessengerInput<HomePageModels.GetLiveSectionItemsInput> messengerInput);

    @POST
    Observable<MessangerOutput<VodMediaEntityOutput>> getMedia(@Url String str, @Body MessengerInput<GetMediaInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetMyArchiveStoriesOutput>> getMyArchiveStories(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileInfoOutput>> getMyProfileInfo(@Url String str, @Body MessengerInput<Rubino.GetProfileInfoInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileListOutput>> getMyProfileList(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetPostsOutput>> getMyProfilePosts(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetMyStoryListOutput>> getMyStoryList(@Url String str, @Body MessengerInput<GetMyStoryListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetNewEventsOutput>> getNewEvents(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetFollowRequestsOutput>> getNewFollowRequests(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileListOutput>> getPollResultProfiles(@Url String str, @Body MessengerInput<GetPollResultProfilesInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetPostByShareLinkOutput>> getPostByShareLink(@Url String str, @Body MessengerInput<Rubino.GetPostByShareLinkInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileListOutput>> getPostLikes(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<ShopModels.GetPostLinkedProductsOutput>> getPostLinkedProducts(@Url String str, @Body MessengerInput<ShopModels.GetPostLinkedProductsInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetPostShareLinkOutput>> getPostShareLink(@Url String str, @Body MessengerInput<Rubino.GetPostShareLinkInput> messengerInput);

    @POST
    Observable<MessangerOutput<ShopModels.GetProductCategoriesOutput>> getProductCategories(@Url String str, @Body MessengerInput<ShopModels.EmptyInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetProductDetailOutput>> getProductDetail(@Url String str, @Body MessengerInput<GetProductDetailInput> messengerInput);

    @POST
    Observable<MessangerOutput<ShopModels.GetProductMessageLinkOutput>> getProductMessageLink(@Url String str, @Body MessengerInput<ShopModels.GetProductMessageLinkInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetProductsOutput>> getProducts(@Url String str, @Body MessengerInput<GetProductsInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileListOutput>> getProfileByIds(@Url String str, @Body MessengerInput<Rubino.GetProfileByIdsInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileListOutput>> getProfileFollowers(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileHighlightsOutput>> getProfileHighlights(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileInfoOutput>> getProfileInfo(@Url String str, @Body MessengerInput<Rubino.GetProfileInfoInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetPostsOutput>> getProfilePosts(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetPostsOutput>> getProfilesPostList(@Url String str, @Body MessengerInput<Rubino.GetProfilesPostListInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetProfilesStoriesOutput>> getProfilesStories(@Url String str, @Body MessengerInput<GetProfilesStoriesInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetProfilesStoryListOutput>> getProfilesStoryList(@Url String str, @Body MessengerInput<GetProfilesStoryListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetPostsOutput>> getRecentFollowingPosts(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetRelatedOutput>> getRelated(@Url String str, @Body MessengerInput<GetRelatedInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetRelatedExplorePostsOutput>> getRelatedExplorePost(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileLinkItemsOutput>> getRubinoProfileLinkItems(@Url String str, @Body MessengerInput<Rubino.GetProfileLinkItemsInput> messengerInput);

    @POST
    Observable<MessangerOutput<HomePageModels.GetSectionDetailsOutput>> getSectionDetails(@Url String str, @Body MessengerInput<HomePageModels.GetSectionDetailsInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetStoreDetailOutput>> getStoreDetail(@Url String str, @Body MessengerInput<GetStoreDetailInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetStoryOutput>> getStory(@Url String str, @Body MessengerInput<GetStoryInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetStoryIdsOutput>> getStoryIds(@Url String str, @Body MessengerInput<GetStoryIdsInput> messengerInput);

    @POST
    Observable<MessangerOutput<StorySettingOutput>> getStorySetting(@Url String str, @Body MessengerInput<GetStorySettingInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetStoryViewersOutput>> getStoryViewers(@Url String str, @Body MessengerInput<GetStoryViewersInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileListOutput>> getSuggested(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetPostsOutput>> getTaggedPosts(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetTasksOutput>> getTasks(@Url String str, @Body MessengerInput<GetTasksInput> messengerInput);

    @GET
    Observable<Response<ResponseBody>> getUrl(@Url String str);

    @POST
    Observable<MessangerOutput<GetWalletByShareLinkOutput>> getWalletByShareLink(@Url String str, @Body MessengerInput<GetWalletByShareLinkInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetWalletShareLinkOutput>> getWalletShareLink(@Url String str, @Body MessengerInput<GetWalletShareLinkInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetWalletStatusOutput>> getWalletStatus(@Url String str, @Body MessengerInput<GetWalletStatusInput> messengerInput);

    @POST
    Observable<MessangerOutput<GetWalletTransactionsOutput>> getWalletTransactions(@Url String str, @Body MessengerInput<GetWalletTransactionsInput> messengerInput);

    @POST
    Observable<MessangerOutput> highlightStory(@Url String str, @Body MessengerInput<Rubino.HighlightStoryInput> messengerInput);

    @POST
    Observable<MessangerOutput> likeCommentAction(@Url String str, @Body MessengerInput<Rubino.LikeActionInput> messengerInput);

    @POST
    Observable<MessangerOutput> likePostAction(@Url String str, @Body MessengerInput<Rubino.LikeActionInput> messengerInput);

    @POST
    Observable<MessangerOutput> removeHighlightCollection(@Url String str, @Body MessengerInput<Rubino.RemoveHighlightCollectionInput> messengerInput);

    @POST
    Observable<MessangerOutput> removeNotification(@Url String str, @Body MessengerInput<Rubino.RemoveNotificationInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.RemoveRecordOutput>> removeRecord(@Url String str, @Body MessengerInput<Rubino.RemoveRecordInput> messengerInput);

    @POST
    Observable<MessangerOutput> requestFollow(@Url String str, @Body MessengerInput<Rubino.RequestFollowInput> messengerInput);

    @POST
    Observable<MessangerOutput<RubinoRequestUploadFileOutput>> requestSendFileRubino(@Url String str, @Body MessengerInput<RubinoRequestUploadFileInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.AddCommentOutput>> rubinoAddComment(@Url String str, @Body MessengerInput<Rubino.AddCommentInput> messengerInput);

    @POST
    Observable<MessangerOutput> rubinoAddFilePost(@Url String str, @Body MessengerInput<Rubino.AddFilePostInput> messengerInput);

    @POST
    Observable<MessangerOutput<LiveModels.AddLiveCommentOutput>> rubinoAddLiveComment(@Url String str, @Body MessengerInput<LiveModels.RubinoAddLiveCommentInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.AddPostOutput>> rubinoAddPost(@Url String str, @Body MessengerInput<Rubino.AddPostInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.AddCommentOutput>> rubinoAddReplyComment(@Url String str, @Body MessengerInput<Rubino.AddCommentInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetCommentsOutput>> rubinoGetCommentReplies(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetCommentsOutput>> rubinoGetComments(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<LiveModels.GetLiveCommnetsOutput>> rubinoGetLiveComment(@Url String str, @Body MessengerInput<LiveModels.RubinoGetLiveCommnetsInput> messengerInput);

    @POST
    Observable<MessangerOutput<LiveModels.RubinoGetLiveInfoOutput>> rubinoGetLivePlayUrl(@Url String str, @Body MessengerInput<LiveModels.RubinoGetLiveInfolInput> messengerInput);

    @POST
    Observable<MessangerOutput<LiveModels.RubinoGetLiveStatusOutput>> rubinoGetLiveStatus(@Url String str, @Body MessengerInput<LiveModels.RubinoGetLiveStatusInput> messengerInput);

    @POST
    Observable<MessangerOutput<LiveModels.RubinoGetLiveViewersOutput>> rubinoGetLiveViewer(@Url String str, @Body MessengerInput<LiveModels.RubinoGetLiveViewersInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.IsExistUsernameOutput>> rubinoIsExistUsername(@Url String str, @Body MessengerInput<Rubino.IsExistUsernameInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.AddPostOutput>> rubinoPublishPost(@Url String str, @Body MessengerInput<Rubino.PublishPostInput> messengerInput);

    @POST
    Observable<MessangerOutput> rubinoReportRecord(@Url String str, @Body MessengerInput<Rubino.ReportInput> messengerInput);

    @POST
    Observable<MessangerOutput<RubinoRequestUploadFileOutput>> rubinoRequestUploadFile(@Url String str, @Body MessengerInput<RubinoRequestUploadFileInput> messengerInput);

    @POST
    Observable<MessangerOutput<LiveModels.RubinoSendLiveOutput>> rubinoSendLive(@Url String str, @Body MessengerInput<LiveModels.RubinoSendLiveInput> messengerInput);

    @POST
    Observable<MessangerOutput<LiveModels.RubinoSetLiveSettingOutput>> rubinoSetLiveSetting(@Url String str, @Body MessengerInput<LiveModels.RubinoSetLiveSettingInput> messengerInput);

    @POST
    Observable<MessangerOutput<LiveModels.RubinoStopLiveOutput>> rubinoStopLive(@Url String str, @Body MessengerInput<LiveModels.RubinoStopLiveInput> messengerInput);

    @POST
    Observable<MessangerOutput<RubinoUpdateProfilePhotoOutput>> rubinoUpdateProfilePhoto(@Url String str, @Body MessengerInput<RubinoUpdateProfilePhotoInput> messengerInput);

    @POST
    Observable<MessangerOutput<RubinoUploadFileOutput>> rubinoUploadFile(@Url String str, @Body RequestBody requestBody, @Header("part_number") int i, @Header("total_part") int i2, @Header("auth") String str2, @Header("hash_file_request") String str3, @Header("file_id") String str4);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileListOutput>> searchFollowerProfile(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<InstaGetHashTagsOutput>> searchHashTag(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetHashtagListOutput>> searchHashTag2(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<InstaGetProfilesOutput>> searchProfile(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileListOutput>> searchProfile2(@Url String str, @Body MessengerInput<Rubino.GetListInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.GetProfileForTagListOutput>> searchProfilesForTag(@Url String str, @Body MessengerInput<Rubino.GetProfileForTagListInput> messengerInput);

    @POST
    Observable<MessangerOutput<SendDataDynamicPageOutput>> sendDataDynamicPage(@Url String str, @Body MessengerInput<SendDataDynamicPageInput> messengerInput);

    @POST
    Observable<MessangerOutput<SendTaskResultOutput>> sendTaskResult(@Url String str, @Body MessengerInput<SendTaskResultInput> messengerInput);

    @POST
    Observable<MessangerOutput> setBlockProfile(@Url String str, @Body MessengerInput<Rubino.BlockInput> messengerInput);

    @POST
    Observable<MessangerOutput> setDefaultDeliveryInfo(@Url String str, @Body MessengerInput<SetDefaultDeliveryInfoInput> messengerInput);

    @POST
    Observable<MessangerOutput<Rubino.SetPostProductsOutput>> setPostProducts(@Url String str, @Body MessengerInput<Rubino.SetPostProductsInput> messengerInput);

    @POST
    Observable<MessangerOutput<HomePageModels.UserPredictionsOutput>> setPrediction(@Url String str, @Body MessengerInput<HomePageModels.UserPredictionsInput> messengerInput);

    @POST
    Observable<MessangerOutput<StorySettingOutput>> setStorySetting(@Url String str, @Body MessengerInput<SetStorySettingInput> messengerInput);

    @POST
    Observable<MessangerOutput<HomePageModels.SetUserFavoriteServicesOutput>> setUserFavoriteServices(@Url String str, @Body MessengerInput<HomePageModels.SetUserFavoriteServicesInput> messengerInput);

    @POST
    Observable<MessangerOutput<ShopModels.ShopRequestUploadFileOutput>> shopRequestSendFile(@Url String str, @Body MessengerInput<ShopModels.ShopRequestUploadFileInput> messengerInput);

    @POST
    Observable<MessangerOutput<TransferCreditOutput>> transferCredit(@Url String str, @Body MessengerInput<TransferCreditInput> messengerInput);
}
