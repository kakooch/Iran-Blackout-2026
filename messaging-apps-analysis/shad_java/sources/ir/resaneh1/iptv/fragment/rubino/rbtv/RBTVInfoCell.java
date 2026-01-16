package ir.resaneh1.iptv.fragment.rubino.rbtv;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;

/* compiled from: RBTVInfoCell.kt */
/* loaded from: classes3.dex */
public final class RBTVInfoCell extends FrameLayout {
    private final Lazy descriptionLl$delegate;
    private final Lazy descriptionTv$delegate;
    private final LinearLayout mainLl;
    private final Lazy profileId$delegate;
    private final Lazy profileIv$delegate;
    private final Lazy scrollView$delegate;
    private final LinearLayout topLinearLayout;

    static {
        new Companion(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RBTVInfoCell(final Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.profileIv$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVInfoCell$profileIv$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return new ImageView(context);
            }
        });
        this.profileId$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVInfoCell$profileId$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return RBTVUtils.Companion.createTv(context, BuildConfig.FLAVOR, null);
            }
        });
        this.descriptionTv$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVInfoCell$descriptionTv$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return RBTVUtils.Companion.createTv(context, BuildConfig.FLAVOR, null);
            }
        });
        this.scrollView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ScrollView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVInfoCell$scrollView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ScrollView invoke() {
                return new ScrollView(context);
            }
        });
        this.descriptionLl$delegate = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVInfoCell$descriptionLl$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return this.this$0.initDescriptionView();
            }
        });
        LinearLayout linearLayout = new LinearLayout(context);
        this.mainLl = linearLayout;
        getProfileIv().setImageDrawable(context.getResources().getDrawable(R.drawable.placeholder_avatar_man));
        LinearLayout linearLayoutInitTopLinearLayout = initTopLinearLayout();
        this.topLinearLayout = linearLayoutInitTopLinearLayout;
        linearLayout.setOrientation(1);
        linearLayout.addView(linearLayoutInitTopLinearLayout, LayoutHelper.createLinear(-1, -2, 48));
        linearLayout.addView(getDescriptionLl(), LayoutHelper.createFrame(-1, -2, 80));
        addView(linearLayout, LayoutHelper.createFrame(-1, -2));
    }

    /* compiled from: RBTVInfoCell.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final ImageView getProfileIv() {
        return (ImageView) this.profileIv$delegate.getValue();
    }

    private final TextView getProfileId() {
        return (TextView) this.profileId$delegate.getValue();
    }

    private final TextView getDescriptionTv() {
        return (TextView) this.descriptionTv$delegate.getValue();
    }

    private final ScrollView getScrollView() {
        return (ScrollView) this.scrollView$delegate.getValue();
    }

    private final LinearLayout getDescriptionLl() {
        return (LinearLayout) this.descriptionLl$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout initDescriptionView() {
        ScrollView scrollView = getScrollView();
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setHorizontalScrollBarEnabled(false);
        scrollView.addView(getDescriptionTv(), LayoutHelper.createLinear(-1, -2));
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(getScrollView(), LayoutHelper.createLinear(-1, -2));
        return linearLayout;
    }

    public final void moveView() {
        if (getDescriptionTv().getMaxLines() == 2) {
            this.mainLl.setLayoutParams(new FrameLayout.LayoutParams(-1, AndroidUtilities.px(AndroidUtilities.getScreenHeight()) / 2));
            getDescriptionTv().setMaxLines(999);
        } else {
            getDescriptionTv().setMaxLines(2);
            this.mainLl.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        }
    }

    private final LinearLayout initTopLinearLayout() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.addView(getProfileIv(), LayoutHelper.createLinear(40, 40));
        getProfileId().setGravity(16);
        getProfileId().setShadowLayer(20.0f, 0.1f, 0.1f, -1728053248);
        linearLayout.addView(getProfileId(), LayoutHelper.createLinear(-2, 40, 8.0f, 0.0f, 8.0f, 0.0f));
        return linearLayout;
    }

    public final void setData(final RubinoPostObject postObject) {
        Intrinsics.checkNotNullParameter(postObject, "postObject");
        GlideHelper.loadCircle(getContext(), getProfileIv(), postObject.profile.full_photo_url, R.drawable.placeholder_avatar_man);
        String str = postObject.post.caption;
        if (str != null) {
            TextView descriptionTv = getDescriptionTv();
            descriptionTv.setMaxLines(2);
            descriptionTv.setEllipsize(TextUtils.TruncateAt.END);
            descriptionTv.setText(str);
        }
        getProfileId().setText(postObject.profile.username);
        getProfileId().setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVInfoCell$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RBTVInfoCell.m507setData$lambda4(postObject, view);
            }
        });
        getProfileIv().setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVInfoCell$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RBTVInfoCell.m508setData$lambda5(postObject, view);
            }
        });
        getDescriptionTv().setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVInfoCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RBTVInfoCell.m509setData$lambda6(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setData$lambda-4, reason: not valid java name */
    public static final void m507setData$lambda4(RubinoPostObject postObject, View view) {
        Intrinsics.checkNotNullParameter(postObject, "$postObject");
        new MainClickHandler().onRubinoProfileClick(postObject.getProfileTryFromMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setData$lambda-5, reason: not valid java name */
    public static final void m508setData$lambda5(RubinoPostObject postObject, View view) {
        Intrinsics.checkNotNullParameter(postObject, "$postObject");
        new MainClickHandler().onRubinoProfileClick(postObject.getProfileTryFromMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setData$lambda-6, reason: not valid java name */
    public static final void m509setData$lambda6(RBTVInfoCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.moveView();
    }
}
