package ir.resaneh1.iptv.apiMessanger;

import ir.resaneh1.iptv.model.AddDeliveryInfoInput;
import ir.resaneh1.iptv.model.AddDeliveryInfoOutput;
import ir.resaneh1.iptv.model.ApplyOrderDiscountCodeInput;
import ir.resaneh1.iptv.model.ApplyOrderDiscountCodeOutput;
import ir.resaneh1.iptv.model.ConfirmPaymentInput;
import ir.resaneh1.iptv.model.ConfirmPaymentOutput;
import ir.resaneh1.iptv.model.CreateBasketOrderInput;
import ir.resaneh1.iptv.model.CreateBasketOrderOutput;
import ir.resaneh1.iptv.model.DropBasketInput;
import ir.resaneh1.iptv.model.EmptyInputObject;
import ir.resaneh1.iptv.model.GetAllDeliveryInfoOutput;
import ir.resaneh1.iptv.model.GetBarcodeActionInput;
import ir.resaneh1.iptv.model.GetBarcodeActionOutput;
import ir.resaneh1.iptv.model.GetBasketInput;
import ir.resaneh1.iptv.model.GetBasketListOutput;
import ir.resaneh1.iptv.model.GetBasketOutput;
import ir.resaneh1.iptv.model.GetBasketStatusOutput;
import ir.resaneh1.iptv.model.GetCommentsOutput;
import ir.resaneh1.iptv.model.GetDefaultDeliveryInfoOutput;
import ir.resaneh1.iptv.model.GetDeliverCityInput;
import ir.resaneh1.iptv.model.GetDeliverCityOutput;
import ir.resaneh1.iptv.model.GetDeliverProvinceOutput;
import ir.resaneh1.iptv.model.GetDeliveryTimesInput;
import ir.resaneh1.iptv.model.GetDeliveryTimesOutput;
import ir.resaneh1.iptv.model.GetDeliveryTypeOutput;
import ir.resaneh1.iptv.model.GetDeliveryTypesInput;
import ir.resaneh1.iptv.model.GetListInputByStartId;
import ir.resaneh1.iptv.model.GetOrderPaymentInfoInput;
import ir.resaneh1.iptv.model.GetOrderPaymentInfoOutput;
import ir.resaneh1.iptv.model.GetPaidOrdersOutput;
import ir.resaneh1.iptv.model.GetPaymentOptionInput;
import ir.resaneh1.iptv.model.GetPaymentOptionOutput;
import ir.resaneh1.iptv.model.GetRubikaPaymentOptionInput;
import ir.resaneh1.iptv.model.GetRubikaPaymentOptionOutput;
import ir.resaneh1.iptv.model.GetSearchStructureOutput;
import ir.resaneh1.iptv.model.GetTagListInput;
import ir.resaneh1.iptv.model.GetTagListOutput;
import ir.resaneh1.iptv.model.GetTagObjectsOutput;
import ir.resaneh1.iptv.model.GetTileInput;
import ir.resaneh1.iptv.model.GetTileOutput;
import ir.resaneh1.iptv.model.GetWebAppFunctionInput;
import ir.resaneh1.iptv.model.InataAddPostOutput;
import ir.resaneh1.iptv.model.InstaActionOnRequestInput;
import ir.resaneh1.iptv.model.InstaAddPostInput;
import ir.resaneh1.iptv.model.InstaGetCommentsOutput;
import ir.resaneh1.iptv.model.InstaGetHashTagPostsOutput;
import ir.resaneh1.iptv.model.InstaGetHashTagsOutput;
import ir.resaneh1.iptv.model.InstaGetListInput;
import ir.resaneh1.iptv.model.InstaGetNewEventsOutput;
import ir.resaneh1.iptv.model.InstaGetPostSaleListOutput;
import ir.resaneh1.iptv.model.InstaGetPostsOutput;
import ir.resaneh1.iptv.model.InstaGetProfileInfoInput;
import ir.resaneh1.iptv.model.InstaGetProfileInfoOutput;
import ir.resaneh1.iptv.model.InstaGetProfilesOutput;
import ir.resaneh1.iptv.model.InstaGetPurchaseListOutput;
import ir.resaneh1.iptv.model.InstaGetRelatedExplorePostsOutput;
import ir.resaneh1.iptv.model.InstaGetRelatedProfilesOutput;
import ir.resaneh1.iptv.model.InstaGetSaleListOutput;
import ir.resaneh1.iptv.model.InstaGetTopProfilesInput;
import ir.resaneh1.iptv.model.InstaRemoveNotificationInput;
import ir.resaneh1.iptv.model.InstaReportInput;
import ir.resaneh1.iptv.model.InstaRequestFollowInput;
import ir.resaneh1.iptv.model.InstaSendFileErrorInput;
import ir.resaneh1.iptv.model.InstaSetBlockProfileInput;
import ir.resaneh1.iptv.model.InstaSetReadInput;
import ir.resaneh1.iptv.model.InstaUpdateProfileInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.MessengerInput;
import ir.resaneh1.iptv.model.RemoveDeliveryInfoInput;
import ir.resaneh1.iptv.model.RequestSendFileMiniFunctionInput;
import ir.resaneh1.iptv.model.RequestSendFileMiniFunctionOutput;
import ir.resaneh1.iptv.model.RubinoAddFilePostInput;
import ir.resaneh1.iptv.model.RubinoPublishPostInput;
import ir.resaneh1.iptv.model.RubinoPublishPostOutput;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileInput;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileOutput;
import ir.resaneh1.iptv.model.RubinoUpdateProfilePhotoInput;
import ir.resaneh1.iptv.model.RubinoUploadFileOutput;
import ir.resaneh1.iptv.model.SearchQueryInput;
import ir.resaneh1.iptv.model.SearchQueryOutput;
import ir.resaneh1.iptv.model.SendFileMiniFunctionOutput;
import ir.resaneh1.iptv.model.SetBasketItemCountInput;
import ir.resaneh1.iptv.model.SetBasketItemCountOutput;
import ir.resaneh1.iptv.model.WebAppChangeUserTokenInput;
import ir.resaneh1.iptv.model.WebAppChangeUserTokenOutput;
import ir.resaneh1.iptv.model.WebAppObject;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* loaded from: classes3.dex */
public interface RestApiMessanger {
    @POST
    Call<MessangerOutput<AddDeliveryInfoOutput>> addDeliveryInfo(@Url String str, @Body MessengerInput<AddDeliveryInfoInput> messengerInput);

    @POST
    Call<MessangerOutput<ApplyOrderDiscountCodeOutput>> applyOrderDiscountCode(@Url String str, @Body MessengerInput<ApplyOrderDiscountCodeInput> messengerInput);

    @POST
    Call<MessangerOutput<ConfirmPaymentOutput>> confirmPayment(@Url String str, @Body MessengerInput<ConfirmPaymentInput> messengerInput);

    @POST
    Call<MessangerOutput<CreateBasketOrderOutput>> createBasketOrder(@Url String str, @Body MessengerInput<CreateBasketOrderInput> messengerInput);

    @POST
    Call<MessangerOutput> dropBasket(@Url String str, @Body MessengerInput<DropBasketInput> messengerInput);

    @POST
    Call<MessangerOutput<AddDeliveryInfoOutput>> editDeliveryInfo(@Url String str, @Body MessengerInput<AddDeliveryInfoInput> messengerInput);

    @POST
    Call<MessangerOutput<GetAllDeliveryInfoOutput>> getAllDeliveryInfo(@Url String str, @Body MessengerInput<EmptyInputObject> messengerInput);

    @POST
    Call<MessangerOutput<GetBarcodeActionOutput>> getBarcodeAction(@Url String str, @Body MessengerInput<GetBarcodeActionInput> messengerInput);

    @POST
    Call<MessangerOutput<GetBasketOutput>> getBasket(@Url String str, @Body MessengerInput<GetBasketInput> messengerInput);

    @POST
    Call<MessangerOutput<GetBasketListOutput>> getBaskets(@Url String str, @Body MessengerInput messengerInput);

    @POST
    Call<MessangerOutput<GetBasketStatusOutput>> getBasketsStatus(@Url String str, @Body MessengerInput<EmptyInputObject> messengerInput);

    @POST
    Call<MessangerOutput<GetCommentsOutput>> getComments(@Url String str, @Body MessengerInput<GetListInputByStartId> messengerInput);

    @POST
    Call<MessangerOutput<GetDefaultDeliveryInfoOutput>> getDefaultDeliveryInfo(@Url String str, @Body MessengerInput<EmptyInputObject> messengerInput);

    @POST
    Call<MessangerOutput<GetDeliverCityOutput>> getDeliverCityProvince(@Url String str, @Body MessengerInput<GetDeliverCityInput> messengerInput);

    @POST
    Call<MessangerOutput<GetDeliverProvinceOutput>> getDeliverProvince(@Url String str, @Body MessengerInput messengerInput);

    @POST
    Call<MessangerOutput<GetDeliveryTimesOutput>> getDeliveryTimes(@Url String str, @Body MessengerInput<GetDeliveryTimesInput> messengerInput);

    @POST
    Call<MessangerOutput<GetDeliveryTypeOutput>> getDeliveryTypes(@Url String str, @Body MessengerInput<GetDeliveryTypesInput> messengerInput);

    @POST
    Call<MessangerOutput<GetOrderPaymentInfoOutput>> getOrderPaymentInfo(@Url String str, @Body MessengerInput<GetOrderPaymentInfoInput> messengerInput);

    @POST
    Call<MessangerOutput<GetPaidOrdersOutput>> getPaidOrders(@Url String str, @Body MessengerInput<GetListInputByStartId> messengerInput);

    @POST
    Call<MessangerOutput<GetPaymentOptionOutput>> getPaymentOption(@Url String str, @Body MessengerInput<GetPaymentOptionInput> messengerInput);

    @POST
    Call<MessangerOutput<GetRubikaPaymentOptionOutput>> getRubikaPaymentOption(@Url String str, @Body MessengerInput<GetRubikaPaymentOptionInput> messengerInput);

    @POST
    Call<MessangerOutput<GetSearchStructureOutput>> getSearchStructure(@Url String str, @Body MessengerInput messengerInput);

    @POST
    Call<MessangerOutput<GetTagListOutput>> getTagList(@Url String str, @Body MessengerInput<GetTagListInput> messengerInput);

    @POST
    Call<MessangerOutput<GetTagObjectsOutput>> getTagObjects(@Url String str, @Body MessengerInput<GetListInputByStartId> messengerInput);

    @POST
    Call<MessangerOutput<GetTileOutput>> getTiles(@Url String str, @Body MessengerInput<GetTileInput> messengerInput);

    @POST
    Call<MessangerOutput<WebAppObject>> getWebAppFunction(@Url String str, @Body MessengerInput<GetWebAppFunctionInput> messengerInput);

    @POST
    Call<MessangerOutput> instaActionOnRequest(@Url String str, @Body MessengerInput<InstaActionOnRequestInput> messengerInput);

    @POST
    Call<MessangerOutput<InataAddPostOutput>> instaAddPost(@Url String str, @Body MessengerInput<InstaAddPostInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetCommentsOutput>> instaGetCommentReplies(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetCommentsOutput>> instaGetComments(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetPostsOutput>> instaGetExplorePosts(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetHashTagPostsOutput>> instaGetHashTagPosts(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetHashTagsOutput>> instaGetHashTagTrend(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetProfilesOutput>> instaGetLikedCommentProfiles(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetProfilesOutput>> instaGetMyProfileList(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetNewEventsOutput>> instaGetNewEvents(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetProfilesOutput>> instaGetPostLikes(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetPostSaleListOutput>> instaGetPostSaleList(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetProfileInfoOutput>> instaGetProfileInfo(@Url String str, @Body MessengerInput<InstaGetProfileInfoInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetProfilesOutput>> instaGetProfiles(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetPurchaseListOutput>> instaGetPurchaseList(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetRelatedExplorePostsOutput>> instaGetRelatedExplorePosts(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetRelatedProfilesOutput>> instaGetRelatedProfiles(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetSaleListOutput>> instaGetSaleList(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetProfilesOutput>> instaGetSuggestedProfiles(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetProfilesOutput>> instaGetTopProfiles(@Url String str, @Body MessengerInput<InstaGetTopProfilesInput> messengerInput);

    @POST
    Call<MessangerOutput> instaRemoveNotification(@Url String str, @Body MessengerInput<InstaRemoveNotificationInput> messengerInput);

    @POST
    Call<MessangerOutput> instaReportRecord(@Url String str, @Body MessengerInput<InstaReportInput> messengerInput);

    @POST
    Call<MessangerOutput> instaRequestFollow(@Url String str, @Body MessengerInput<InstaRequestFollowInput> messengerInput);

    @POST
    Call<MessangerOutput<RubinoRequestUploadFileOutput>> instaRequestUploadFile(@Url String str, @Body MessengerInput<RubinoRequestUploadFileInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetHashTagsOutput>> instaSearchHashTags(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetProfilesOutput>> instaSearchProfiles(@Url String str, @Body MessengerInput<InstaGetListInput> messengerInput);

    @POST
    Call<MessangerOutput> instaSendFileError(@Url String str, @Body MessengerInput<InstaSendFileErrorInput> messengerInput);

    @POST
    Call<MessangerOutput> instaSetBlockProfile(@Url String str, @Body MessengerInput<InstaSetBlockProfileInput> messengerInput);

    @POST
    Call<MessangerOutput> instaSetReadInput(@Url String str, @Body MessengerInput<InstaSetReadInput> messengerInput);

    @POST
    Call<MessangerOutput<InstaGetProfileInfoOutput>> instaUpdateProfile(@Url String str, @Body MessengerInput<InstaUpdateProfileInput> messengerInput);

    @POST
    Call<MessangerOutput> instaUpdateProfilePhoto(@Url String str, @Body MessengerInput<RubinoUpdateProfilePhotoInput> messengerInput);

    @POST
    Call<MessangerOutput<RubinoUploadFileOutput>> instaUploadFile(@Url String str, @Body RequestBody requestBody, @Header("part-number") int i, @Header("total-part") int i2, @Header("auth") String str2, @Header("hash-file-request") String str3, @Header("file-id") String str4);

    @POST
    Call<MessangerOutput> removeDeliveryInfo(@Url String str, @Body MessengerInput<RemoveDeliveryInfoInput> messengerInput);

    @POST
    Call<MessangerOutput<RequestSendFileMiniFunctionOutput>> requestSendFileMiniFunction(@Url String str, @Body MessengerInput<RequestSendFileMiniFunctionInput> messengerInput);

    @POST
    Call<MessangerOutput> rubinoAddFilePost(@Url String str, @Body MessengerInput<RubinoAddFilePostInput> messengerInput);

    @POST
    Call<MessangerOutput<RubinoPublishPostOutput>> rubinoPublishPost(@Url String str, @Body MessengerInput<RubinoPublishPostInput> messengerInput);

    @POST
    Call<MessangerOutput<SearchQueryOutput>> searchQuery(@Url String str, @Body MessengerInput<SearchQueryInput> messengerInput);

    @POST
    Call<MessangerOutput<SendFileMiniFunctionOutput>> sendFileMiniFunction(@Url String str, @Body RequestBody requestBody, @Header("part-number") int i, @Header("total-part") int i2, @Header("auth") String str2, @Header("access-hash-send") String str3, @Header("file-id") String str4);

    @POST
    Call<MessangerOutput<SetBasketItemCountOutput>> setBasketItemCount(@Url String str, @Body MessengerInput<SetBasketItemCountInput> messengerInput);

    @POST
    Call<MessangerOutput<WebAppChangeUserTokenOutput>> webAppChangeUserToken(@Url String str, @Body MessengerInput<WebAppChangeUserTokenInput> messengerInput);
}
