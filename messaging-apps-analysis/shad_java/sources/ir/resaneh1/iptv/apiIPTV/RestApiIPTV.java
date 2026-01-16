package ir.resaneh1.iptv.apiIPTV;

import ir.resaneh1.iptv.model.AODObjectAbs;
import ir.resaneh1.iptv.model.AODObjectDet;
import ir.resaneh1.iptv.model.ActionOnObjectInput;
import ir.resaneh1.iptv.model.AppAbsObject;
import ir.resaneh1.iptv.model.BannerObjectAbs;
import ir.resaneh1.iptv.model.CommentObject;
import ir.resaneh1.iptv.model.CourseAbs;
import ir.resaneh1.iptv.model.CourseDet;
import ir.resaneh1.iptv.model.EPGListInput;
import ir.resaneh1.iptv.model.EPGListTVOutput;
import ir.resaneh1.iptv.model.GetBuyServiceInput;
import ir.resaneh1.iptv.model.GetBuyServiceOutput2;
import ir.resaneh1.iptv.model.GetCategoryHighlightListOutput;
import ir.resaneh1.iptv.model.GetCategoryHighlightsInput;
import ir.resaneh1.iptv.model.GetClubInfoOutput;
import ir.resaneh1.iptv.model.GetEPGPageOutput;
import ir.resaneh1.iptv.model.GetListInput;
import ir.resaneh1.iptv.model.GetListOutput;
import ir.resaneh1.iptv.model.GetListPayInput;
import ir.resaneh1.iptv.model.GetListPayOutput2;
import ir.resaneh1.iptv.model.GetNewsCategoryListOutput;
import ir.resaneh1.iptv.model.GetNewsInput;
import ir.resaneh1.iptv.model.GetNewsListInput;
import ir.resaneh1.iptv.model.GetNewsListOutput;
import ir.resaneh1.iptv.model.GetNewsOutput;
import ir.resaneh1.iptv.model.GetObjectInput;
import ir.resaneh1.iptv.model.GetObjectOutput;
import ir.resaneh1.iptv.model.GetPageInput;
import ir.resaneh1.iptv.model.GetPageOutput;
import ir.resaneh1.iptv.model.GetRelatedNewsInput;
import ir.resaneh1.iptv.model.GetStreamUrlInput;
import ir.resaneh1.iptv.model.GetStreamUrlOutput;
import ir.resaneh1.iptv.model.GetTokenPayInput;
import ir.resaneh1.iptv.model.GetTokenPayOutput2;
import ir.resaneh1.iptv.model.JJApiInput;
import ir.resaneh1.iptv.model.JJGetChampionOutput;
import ir.resaneh1.iptv.model.JJGetGroupsTabsOutput;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListInput;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListOutput;
import ir.resaneh1.iptv.model.JJGetMatchDetailsInput;
import ir.resaneh1.iptv.model.JJGetMatchDetailsOutput;
import ir.resaneh1.iptv.model.JJGetRankOutput;
import ir.resaneh1.iptv.model.JJGetTableOutput;
import ir.resaneh1.iptv.model.JJSetChampionInput;
import ir.resaneh1.iptv.model.JJSetChampionOutput;
import ir.resaneh1.iptv.model.JJVoteInput;
import ir.resaneh1.iptv.model.JJVoteOutput;
import ir.resaneh1.iptv.model.LinkItem;
import ir.resaneh1.iptv.model.OperatorObject;
import ir.resaneh1.iptv.model.StatusOutput;
import ir.resaneh1.iptv.model.TVChannelAbs;
import ir.resaneh1.iptv.model.TVObjectDet;
import ir.resaneh1.iptv.model.TvEpisodeObjectAbs;
import ir.resaneh1.iptv.model.VChannelItemAbs;
import ir.resaneh1.iptv.model.VODObjectAbs;
import ir.resaneh1.iptv.model.ViewStreamInput;
import ir.resaneh1.iptv.model.VirtualChannelAbs;
import ir.resaneh1.iptv.model.VodObjectDet;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* loaded from: classes3.dex */
public interface RestApiIPTV {
    @POST
    Call<StatusOutput> actionOnObject(@Url String str, @Body ActionOnObjectInput actionOnObjectInput);

    @POST("getList")
    Call<GetListOutput<AODObjectAbs>> getAodAbsList(@Body GetListInput getListInput);

    @POST("getObject")
    Call<GetObjectOutput<AODObjectDet>> getAodDetObject(@Body GetObjectInput getObjectInput);

    @POST
    Call<GetListOutput<AppAbsObject>> getAppAbsList(@Url String str, @Body GetListInput getListInput);

    @POST
    Call<GetBuyServiceOutput2> getBuyServicePay(@Url String str, @Body GetBuyServiceInput getBuyServiceInput);

    @POST
    Call<GetCategoryHighlightListOutput> getCategoryHighlights(@Url String str, @Body GetCategoryHighlightsInput getCategoryHighlightsInput);

    @POST
    Call<GetNewsCategoryListOutput> getCategoryList(@Url String str);

    @POST("getClubInfo")
    Call<GetClubInfoOutput> getClubInfo();

    @POST
    Call<GetListOutput<CommentObject>> getCommentList(@Url String str, @Body GetListInput getListInput);

    @POST("getObject")
    Call<GetObjectOutput<CourseDet>> getCourseObject(@Body GetObjectInput getObjectInput);

    @POST("getEPGListTV")
    Call<EPGListTVOutput> getEPGListTV(@Body EPGListInput ePGListInput);

    @POST("getEPGPageTV")
    Call<GetEPGPageOutput> getEPGPageTV();

    @POST
    Call<JJGetGroupsTabsOutput> getJJGroupsTabs(@Url String str, @Body JJApiInput jJApiInput);

    @POST
    Call<JJGetMatchAndTeamListOutput> getJJMatchAndTeamList(@Url String str, @Body JJGetMatchAndTeamListInput jJGetMatchAndTeamListInput);

    @POST
    Call<JJGetMatchDetailsOutput> getJJMatchDetail(@Url String str, @Body JJGetMatchDetailsInput jJGetMatchDetailsInput);

    @POST
    Call<JJGetRankOutput> getJJRank(@Url String str, @Body JJApiInput jJApiInput);

    @POST
    Call<JJGetTableOutput> getJJTable(@Url String str, @Body JJApiInput jJApiInput);

    @POST("getList")
    Call<GetListOutput<BannerObjectAbs>> getLargeBannerList(@Body GetListInput getListInput);

    @POST("getList")
    Call<GetListOutput<LinkItem>> getLinkItemList(@Body GetListInput getListInput);

    @POST
    Call<GetListPayOutput2> getListPay(@Url String str, @Body GetListPayInput getListPayInput);

    @POST("getList")
    Call<GetListOutput<CourseAbs>> getLmsCourseList(@Body GetListInput getListInput);

    @POST
    Call<GetNewsListOutput> getMostVisitedNewsList(@Url String str, @Body GetNewsListInput getNewsListInput);

    @POST
    Call<GetNewsListOutput> getNewestNewsList(@Url String str, @Body GetNewsListInput getNewsListInput);

    @POST
    Call<GetNewsOutput> getNews(@Url String str, @Body GetNewsInput getNewsInput);

    @POST("getList")
    Call<GetListOutput<OperatorObject>> getOperatorList(@Body GetListInput getListInput);

    @POST
    Call<GetPageOutput> getPage(@Url String str, @Body GetPageInput getPageInput);

    @POST
    Call<GetNewsListOutput> getRelatedNews(@Url String str, @Body GetRelatedNewsInput getRelatedNewsInput);

    @POST("getStreamUrlV")
    Call<GetStreamUrlOutput> getStreamUrl2(@Body GetStreamUrlInput getStreamUrlInput);

    @POST("getList")
    Call<GetListOutput<TVChannelAbs>> getTVChannelAbsList(@Body GetListInput getListInput);

    @POST("getList")
    Call<GetListOutput<TvEpisodeObjectAbs>> getTVEpisodeAbsList(@Body GetListInput getListInput);

    @POST("getObject")
    Call<GetObjectOutput<TVObjectDet>> getTVEpisodeDet(@Body GetObjectInput getObjectInput);

    @POST
    Call<GetTokenPayOutput2> getTokenPay(@Url String str, @Body GetTokenPayInput getTokenPayInput);

    @POST("getList")
    Call<GetListOutput<VChannelItemAbs>> getVChannelItemList(@Body GetListInput getListInput);

    @POST("getList")
    Call<GetListOutput<VODObjectAbs>> getVODAbsList(@Body GetListInput getListInput);

    @POST("getList")
    Call<GetListOutput<VirtualChannelAbs>> getVirtualChannelAbs(@Body GetListInput getListInput);

    @POST("getObject")
    Call<GetObjectOutput<VodObjectDet>> getVodDetObject(@Body GetObjectInput getObjectInput);

    @POST
    Call<JJGetChampionOutput> jjGetChampionTeam(@Url String str, @Body JJApiInput jJApiInput);

    @POST
    Call<JJSetChampionOutput> jjSetChampionTeam(@Url String str, @Body JJSetChampionInput jJSetChampionInput);

    @POST
    Call<JJVoteOutput> jjVote(@Url String str, @Body JJVoteInput jJVoteInput);

    @POST("viewStream")
    Call<StatusOutput> viewStream(@Body ViewStreamInput viewStreamInput);
}
