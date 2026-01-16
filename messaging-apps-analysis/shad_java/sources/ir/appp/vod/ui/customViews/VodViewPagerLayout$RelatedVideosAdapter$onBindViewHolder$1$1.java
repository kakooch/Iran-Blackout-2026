package ir.appp.vod.ui.customViews;

import android.content.Context;
import android.view.View;
import ir.appp.vod.domain.model.VodBriefMediaEntity;
import ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.rbmain.messenger.ApplicationLoader;

/* compiled from: VodViewPagerLayout.kt */
/* loaded from: classes3.dex */
final class VodViewPagerLayout$RelatedVideosAdapter$onBindViewHolder$1$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ VodRelatedVideoCell $this_apply;
    final /* synthetic */ VodBriefMediaEntity $vodBriefMediaEntity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VodViewPagerLayout$RelatedVideosAdapter$onBindViewHolder$1$1(VodBriefMediaEntity vodBriefMediaEntity, VodRelatedVideoCell vodRelatedVideoCell) {
        super(0);
        this.$vodBriefMediaEntity = vodBriefMediaEntity;
        this.$this_apply = vodRelatedVideoCell;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        final VodMediaDetailActivity vodMediaDetailActivity = new VodMediaDetailActivity(this.$vodBriefMediaEntity);
        Context context = this.$this_apply.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        final VodVideoPreviewBottomSheet vodVideoPreviewBottomSheet = new VodVideoPreviewBottomSheet(context, false);
        VodBriefMediaEntity vodBriefMediaEntity = this.$vodBriefMediaEntity;
        String title = vodBriefMediaEntity.getTitle();
        Long year = vodBriefMediaEntity.getYear();
        String string = year == null ? null : year.toString();
        Long seasons = vodBriefMediaEntity.getSeasons();
        vodVideoPreviewBottomSheet.setVideoDetails(title, string, seasons != null ? seasons.toString() : null, vodBriefMediaEntity.getShortDescription(), vodBriefMediaEntity.getImageUrl(), null);
        vodVideoPreviewBottomSheet.setDelegate(new View.OnClickListener() { // from class: ir.appp.vod.ui.customViews.VodViewPagerLayout$RelatedVideosAdapter$onBindViewHolder$1$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VodViewPagerLayout$RelatedVideosAdapter$onBindViewHolder$1$1.m385invoke$lambda1(vodVideoPreviewBottomSheet, vodMediaDetailActivity, view);
            }
        });
        ApplicationLoader.applicationActivity.getLastFragment().showDialog(vodVideoPreviewBottomSheet);
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1, reason: not valid java name */
    public static final void m385invoke$lambda1(VodVideoPreviewBottomSheet alert, VodMediaDetailActivity fragment, View view) {
        Intrinsics.checkNotNullParameter(alert, "$alert");
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        alert.dismiss();
        ApplicationLoader.applicationActivity.getLastFragment().presentFragment(fragment);
    }
}
