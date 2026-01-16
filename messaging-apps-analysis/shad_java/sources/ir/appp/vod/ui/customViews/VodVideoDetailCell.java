package ir.appp.vod.ui.customViews;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.button.MaterialButton;
import ir.appp.vod.domain.model.VodCastListViewEntity;
import ir.appp.vod.domain.model.VodCastReadEntity$CastRole;
import ir.appp.vod.domain.model.output.VodMediaEntity;
import ir.appp.vod.ui.activity.castList.VodCastListViewFragment;
import ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity;
import ir.appp.vod.ui.customViews.VodVideoDetailCell;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.Components.Point;

/* compiled from: VodVideoDetailCell.kt */
/* loaded from: classes3.dex */
public final class VodVideoDetailCell extends FrameLayout implements View.OnClickListener, View.OnLongClickListener {
    private TextView ageTextView;
    private final Pair<VodCastReadEntity$CastRole, String>[] castExtraCategoryList;
    private ArrayList<VodCastListViewEntity> castExtraList;
    private VodCastListViewFragment castExtraListViewFragment;
    private final View contentView;
    private TextView descriptionTextView;
    private ActionOnMediaListener listener;
    private MaterialButton playButton;
    private View rateIconHolderView;
    private ImageView rateIconView;
    private TextView seasonsTextView;
    private View shareHolderView;
    private TextView starringTitleTextView;
    private TextView titleTextView;
    private final VodMediaDetailActivity videoDetailActivity;
    private VodMediaEntity videoObject;
    private VodRateView vodRateView;
    private TextView yearTextView;

    /* compiled from: VodVideoDetailCell.kt */
    public interface ActionOnMediaListener {
        void likeMedia(VodMediaEntity.LikeStatus likeStatus);

        void playMedia();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodVideoDetailCell(VodMediaDetailActivity videoDetailActivity, Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(videoDetailActivity, "videoDetailActivity");
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.videoDetailActivity = videoDetailActivity;
        this.castExtraCategoryList = new Pair[]{new Pair<>(VodCastReadEntity$CastRole.Actor, getResources().getString(R.string.vod_stars)), new Pair<>(VodCastReadEntity$CastRole.Director, getResources().getString(R.string.vod_director))};
        this.contentView = FrameLayout.inflate(context, R.layout.vod_video_details_item, null);
        setWillNotDraw(false);
        initViews();
    }

    public final Pair<VodCastReadEntity$CastRole, String>[] getCastExtraCategoryList() {
        return this.castExtraCategoryList;
    }

    private final void initViews() {
        addView(this.contentView);
        this.playButton = (MaterialButton) this.contentView.findViewById(R.id.video_play_button);
        this.titleTextView = (TextView) this.contentView.findViewById(R.id.video_title);
        this.yearTextView = (TextView) this.contentView.findViewById(R.id.video_year);
        this.ageTextView = (TextView) this.contentView.findViewById(R.id.video_age_rate);
        this.seasonsTextView = (TextView) this.contentView.findViewById(R.id.video_seasons);
        this.descriptionTextView = (TextView) this.contentView.findViewById(R.id.video_description);
        this.starringTitleTextView = (TextView) this.contentView.findViewById(R.id.video_starring);
        this.rateIconView = (ImageView) this.contentView.findViewById(R.id.rate_icon);
        this.rateIconHolderView = this.contentView.findViewById(R.id.rate_icon_holder);
        this.shareHolderView = this.contentView.findViewById(R.id.share_icon_holder);
        MaterialButton materialButton = this.playButton;
        if (materialButton != null) {
            materialButton.setOnClickListener(this);
        }
        MaterialButton materialButton2 = this.playButton;
        if (materialButton2 != null) {
            materialButton2.setOnLongClickListener(this);
        }
        ImageView imageView = this.rateIconView;
        if (imageView != null) {
            imageView.setClickable(false);
        }
        View view = this.rateIconHolderView;
        if (view != null) {
            view.setOnClickListener(this);
        }
        View view2 = this.rateIconHolderView;
        if (view2 != null) {
            view2.setOnLongClickListener(this);
        }
        View view3 = this.shareHolderView;
        if (view3 != null) {
            view3.setOnClickListener(this);
        }
        View view4 = this.shareHolderView;
        if (view4 != null) {
            view4.setOnLongClickListener(this);
        }
        TextView textView = this.starringTitleTextView;
        if (textView != null) {
            textView.setOnLongClickListener(this);
        }
        TextView textView2 = this.starringTitleTextView;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        TextView textView3 = this.seasonsTextView;
        if (textView3 != null) {
            textView3.setTypeface(ResourcesCompat.getFont(getContext(), R.font.iran_yekan));
        }
        TextView textView4 = this.yearTextView;
        if (textView4 != null) {
            textView4.setTypeface(ResourcesCompat.getFont(getContext(), R.font.iran_yekan));
        }
        TextView textView5 = this.ageTextView;
        if (textView5 == null) {
            return;
        }
        textView5.setTypeface(ResourcesCompat.getFont(getContext(), R.font.iran_yekan));
    }

    public final void setActionOnMediaListener(ActionOnMediaListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void setData(VodMediaEntity videoObject) {
        Intrinsics.checkNotNullParameter(videoObject, "videoObject");
        throw null;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        onClick(v);
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        MaterialButton materialButton = this.playButton;
        if (materialButton != null && id == materialButton.getId()) {
            ActionOnMediaListener actionOnMediaListener = this.listener;
            if (actionOnMediaListener == null) {
                return;
            }
            actionOnMediaListener.playMedia();
            return;
        }
        TextView textView = this.starringTitleTextView;
        if (textView != null && id == textView.getId()) {
            if (this.castExtraListViewFragment == null) {
                ArrayList<VodCastListViewEntity> arrayList = this.castExtraList;
                this.castExtraListViewFragment = arrayList != null ? new VodCastListViewFragment(arrayList, null) : null;
            }
            ApplicationLoader.applicationActivity.getLastFragment().presentFragment(this.castExtraListViewFragment);
            return;
        }
        View view = this.rateIconHolderView;
        if (view != null && id == view.getId()) {
            VodMediaEntity.LikeStatus likeStatus = VodMediaEntity.LikeStatus.NONE;
            if (likeStatus != null) {
                ImageView imageView = this.rateIconView;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.vod_rate);
                }
                new Handler().postDelayed(new Runnable() { // from class: ir.appp.vod.ui.customViews.VodVideoDetailCell$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        VodVideoDetailCell.m376onClick$lambda12(this.f$0);
                    }
                }, 200L);
                ActionOnMediaListener actionOnMediaListener2 = this.listener;
                if (actionOnMediaListener2 == null) {
                    return;
                }
                actionOnMediaListener2.likeMedia(likeStatus);
                return;
            }
            if (this.vodRateView == null) {
                View view2 = this.videoDetailActivity.fragmentView;
                if (view2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
                }
                FrameLayout frameLayout = (FrameLayout) view2;
                int[] iArr = new int[2];
                ImageView imageView2 = this.rateIconView;
                if (imageView2 != null) {
                    imageView2.getLocationInWindow(iArr);
                }
                ImageView imageView3 = this.rateIconView;
                Integer numValueOf = imageView3 == null ? null : Integer.valueOf(imageView3.getWidth());
                Intrinsics.checkNotNull(numValueOf);
                int iIntValue = numValueOf.intValue();
                float f = iArr[0];
                ImageView imageView4 = this.rateIconView;
                Intrinsics.checkNotNull(imageView4 == null ? null : Integer.valueOf(imageView4.getWidth()));
                float fIntValue = f + (r7.intValue() / 2.0f);
                float top = iArr[1] - this.videoDetailActivity.fragmentView.getTop();
                ImageView imageView5 = this.rateIconView;
                Intrinsics.checkNotNull(imageView5 != null ? Integer.valueOf(imageView5.getHeight()) : null);
                Point point = new Point(fIntValue, (top + (r3.intValue() / 2.0f)) - AndroidUtilities.statusBarHeight);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                final VodRateView vodRateView = new VodRateView(iIntValue, point, context);
                vodRateView.setOnLikeClicked(new Function0<Unit>() { // from class: ir.appp.vod.ui.customViews.VodVideoDetailCell$onClick$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        VodMediaEntity unused = this.this$0.videoObject;
                        VodVideoDetailCell.ActionOnMediaListener actionOnMediaListener3 = this.this$0.listener;
                        if (actionOnMediaListener3 != null) {
                            actionOnMediaListener3.likeMedia(VodMediaEntity.LikeStatus.LIKE);
                        }
                        ImageView imageView6 = this.this$0.rateIconView;
                        if (imageView6 != null) {
                            imageView6.setImageResource(R.drawable.vod_like_fill);
                        }
                        View view3 = this.this$0.rateIconHolderView;
                        if (view3 == null) {
                            return;
                        }
                        view3.setBackgroundDrawable(vodRateView.getResources().getDrawable(R.drawable.vod_ripple));
                    }
                });
                vodRateView.setOnDisLikeClicked(new Function0<Unit>() { // from class: ir.appp.vod.ui.customViews.VodVideoDetailCell$onClick$3$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        VodMediaEntity unused = this.this$0.videoObject;
                        VodVideoDetailCell.ActionOnMediaListener actionOnMediaListener3 = this.this$0.listener;
                        if (actionOnMediaListener3 != null) {
                            actionOnMediaListener3.likeMedia(VodMediaEntity.LikeStatus.DISLIKE);
                        }
                        ImageView imageView6 = this.this$0.rateIconView;
                        if (imageView6 != null) {
                            imageView6.setImageResource(R.drawable.vod_dislike_fill);
                        }
                        View view3 = this.this$0.rateIconHolderView;
                        if (view3 == null) {
                            return;
                        }
                        view3.setBackgroundDrawable(vodRateView.getResources().getDrawable(R.drawable.vod_ripple));
                    }
                });
                vodRateView.setOnViewAnimationEnd(new Function0<Unit>() { // from class: ir.appp.vod.ui.customViews.VodVideoDetailCell$onClick$3$3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        this.this$0.showRateView(false);
                        VodRateView vodRateView2 = this.this$0.vodRateView;
                        ViewParent parent = vodRateView2 == null ? null : vodRateView2.getParent();
                        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                        if (viewGroup != null) {
                            viewGroup.removeView(this.this$0.vodRateView);
                        }
                        this.this$0.vodRateView = null;
                    }
                });
                this.vodRateView = vodRateView;
                frameLayout.addView(vodRateView, -1, -1);
            }
            showRateView(true);
            return;
        }
        View view3 = this.shareHolderView;
        if (view3 != null && id == view3.getId()) {
            showShareIntent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onClick$lambda-12, reason: not valid java name */
    public static final void m376onClick$lambda12(VodVideoDetailCell this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.rateIconHolderView;
        if (view == null) {
            return;
        }
        view.setBackground(null);
    }

    private final void showShareIntent() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", (String) null);
        intent.setType("text/plain");
        Intent.createChooser(intent, "title");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRateView(boolean z) {
        ImageView imageView = this.rateIconView;
        if (imageView != null) {
            imageView.setVisibility(z ? 4 : 0);
        }
        VodRateView vodRateView = this.vodRateView;
        if (vodRateView == null) {
            return;
        }
        vodRateView.startViewAnimation(z);
    }
}
