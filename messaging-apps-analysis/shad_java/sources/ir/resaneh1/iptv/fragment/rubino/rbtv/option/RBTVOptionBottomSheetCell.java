package ir.resaneh1.iptv.fragment.rubino.rbtv.option;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.appp.common.utils.AndroidUtilities;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RubinoBottomUpAlert;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVUtils;
import ir.resaneh1.iptv.helper.DrawableHelper;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoPostObject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;

/* compiled from: RBTVOptionBottomSheetCell.kt */
/* loaded from: classes3.dex */
public final class RBTVOptionBottomSheetCell extends LinearLayout {
    private final Lazy copyLinkTv$delegate;
    private final DismissListener dismissListener;
    private final Lazy lineIv$delegate;
    private View.OnClickListener onReportClickListener;
    private final RubinoPostObject postObject;
    private final Lazy reportTv$delegate;
    private final Lazy saveTv$delegate;
    private final Lazy shareTv$delegate;

    /* compiled from: RBTVOptionBottomSheetCell.kt */
    public interface DismissListener {
        void dismiss();
    }

    static {
        new Companion(null);
    }

    public final DismissListener getDismissListener() {
        return this.dismissListener;
    }

    public final RubinoPostObject getPostObject() {
        return this.postObject;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RBTVOptionBottomSheetCell(final Context context, RubinoPostObject rubinoPostObject, DismissListener dismissListener) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dismissListener, "dismissListener");
        new LinkedHashMap();
        this.postObject = rubinoPostObject;
        this.dismissListener = dismissListener;
        this.lineIv$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.option.RBTVOptionBottomSheetCell$lineIv$2
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
        this.reportTv$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.option.RBTVOptionBottomSheetCell$reportTv$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                RBTVUtils.Companion companion = RBTVUtils.Companion;
                Context context2 = context;
                String string = context2.getString(R.string.report);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.report)");
                return companion.createTv(context2, string, Integer.valueOf(context.getResources().getColor(R.color.rubino_red)));
            }
        });
        this.copyLinkTv$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.option.RBTVOptionBottomSheetCell$copyLinkTv$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                RBTVUtils.Companion companion = RBTVUtils.Companion;
                Context context2 = context;
                String string = context2.getString(R.string.link_copy);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.link_copy)");
                return companion.createTv(context2, string, Integer.valueOf(companion.getTextColor()));
            }
        });
        this.shareTv$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.option.RBTVOptionBottomSheetCell$shareTv$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                RBTVUtils.Companion companion = RBTVUtils.Companion;
                Context context2 = context;
                String string = context2.getString(R.string.share_rbtv);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.share_rbtv)");
                return companion.createTv(context2, string, Integer.valueOf(companion.getTextColor()));
            }
        });
        this.saveTv$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.option.RBTVOptionBottomSheetCell$saveTv$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                RBTVUtils.Companion companion = RBTVUtils.Companion;
                Context context2 = context;
                String string = context2.getString(R.string.btnSave);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.btnSave)");
                return companion.createTv(context2, string, Integer.valueOf(companion.getTextColor()));
            }
        });
        this.onReportClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.option.RBTVOptionBottomSheetCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RBTVOptionBottomSheetCell.m514onReportClickListener$lambda0(this.f$0, view);
            }
        };
        setOrientation(1);
        RBTVUtils.Companion companion = RBTVUtils.Companion;
        setBackgroundColor(companion.getBackgroundColor());
        setBackground(DrawableHelper.getDrawableWithColor(R.drawable.igtv_option_bottom_sheet, context, companion.getBackgroundColor()));
        setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(32.0f));
        getLineIv().setImageDrawable(context.getResources().getDrawable(R.drawable.line_igtv));
        addView(getLineIv(), LayoutHelper.createLinear(-2, -2, 17, 0, 0, 0, 0));
        addView(getReportTv(), LayoutHelper.createLinear(-1, -2, 5, 0, 16, 0, 0));
        addView(getCopyLinkTv(), LayoutHelper.createLinear(-1, -2, 5, 0, 16, 0, 0));
        addView(getShareTv(), LayoutHelper.createLinear(-1, -2, 5, 0, 16, 0, 0));
        addView(getSaveTv(), LayoutHelper.createLinear(-1, -2, 5, 0, 16, 0, 0));
        getReportTv().setOnClickListener(this.onReportClickListener);
        getCopyLinkTv().setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.option.RBTVOptionBottomSheetCell$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RBTVOptionBottomSheetCell.m511_init_$lambda1(this.f$0, view);
            }
        });
        getShareTv().setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.option.RBTVOptionBottomSheetCell$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RBTVOptionBottomSheetCell.m512_init_$lambda2(this.f$0, view);
            }
        });
        getSaveTv().setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.option.RBTVOptionBottomSheetCell$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RBTVOptionBottomSheetCell.m513_init_$lambda3(this.f$0, view);
            }
        });
    }

    /* compiled from: RBTVOptionBottomSheetCell.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final ImageView getLineIv() {
        return (ImageView) this.lineIv$delegate.getValue();
    }

    private final TextView getReportTv() {
        return (TextView) this.reportTv$delegate.getValue();
    }

    private final TextView getCopyLinkTv() {
        return (TextView) this.copyLinkTv$delegate.getValue();
    }

    private final TextView getShareTv() {
        return (TextView) this.shareTv$delegate.getValue();
    }

    private final TextView getSaveTv() {
        return (TextView) this.saveTv$delegate.getValue();
    }

    public final View.OnClickListener getOnReportClickListener() {
        return this.onReportClickListener;
    }

    public final void setOnReportClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "<set-?>");
        this.onReportClickListener = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onReportClickListener$lambda-0, reason: not valid java name */
    public static final void m514onReportClickListener$lambda0(RBTVOptionBottomSheetCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showReportBottomSheet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-1, reason: not valid java name */
    public static final void m511_init_$lambda1(RBTVOptionBottomSheetCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissListener.dismiss();
        RubinoController.getInstance(UserConfig.selectedAccount).shareOrCopyPost(true, false, ApplicationLoader.applicationActivity.getLastFragment().compositeDisposable, this$0.postObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-2, reason: not valid java name */
    public static final void m512_init_$lambda2(RBTVOptionBottomSheetCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RubinoController.getInstance(UserConfig.selectedAccount).shareOrCopyPost(false, false, ApplicationLoader.applicationActivity.getLastFragment().compositeDisposable, this$0.postObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-3, reason: not valid java name */
    public static final void m513_init_$lambda3(RBTVOptionBottomSheetCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ToastiLikeSnack.showMessageLikeToast("ذخیره شد");
        this$0.dismissListener.dismiss();
        RubinoController.getInstance(UserConfig.selectedAccount).onBookmarkClick(this$0.postObject, Rubino.BookMarkActionEnum.Bookmark);
    }

    private final void showReportBottomSheet() {
        ArrayList arrayList = new ArrayList();
        final RubinoBottomUpAlert rubinoBottomUpAlertCreateRubinoDialogItems = RubinoBottomUpAlert.createRubinoDialogItems(ApplicationLoader.applicationActivity.getLastFragment(), LocaleController.getString(R.string.rubinoReport), arrayList);
        arrayList.add(new Rubino.AlertBoldItem(LocaleController.getString(R.string.rubinoReportProfileQuestion)));
        arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoSpam), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.option.RBTVOptionBottomSheetCell$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RBTVOptionBottomSheetCell.m515showReportBottomSheet$lambda4(this.f$0, rubinoBottomUpAlertCreateRubinoDialogItems, view);
            }
        }));
        arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoInAppropriate), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.option.RBTVOptionBottomSheetCell$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RBTVOptionBottomSheetCell.m516showReportBottomSheet$lambda5(this.f$0, rubinoBottomUpAlertCreateRubinoDialogItems, view);
            }
        }));
        rubinoBottomUpAlertCreateRubinoDialogItems.listAdapter.notifyDataSetChanged();
        ApplicationLoader.applicationActivity.getLastFragment().showDialog(rubinoBottomUpAlertCreateRubinoDialogItems);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showReportBottomSheet$lambda-4, reason: not valid java name */
    public static final void m515showReportBottomSheet$lambda4(RBTVOptionBottomSheetCell this$0, RubinoBottomUpAlert rubinoBottomUpAlert, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RubinoController.getInstance(UserConfig.selectedAccount).reportPost(this$0.postObject, 1);
        rubinoBottomUpAlert.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showReportBottomSheet$lambda-5, reason: not valid java name */
    public static final void m516showReportBottomSheet$lambda5(RBTVOptionBottomSheetCell this$0, RubinoBottomUpAlert rubinoBottomUpAlert, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RubinoController.getInstance(UserConfig.selectedAccount).reportPost(this$0.postObject, 2);
        rubinoBottomUpAlert.dismiss();
    }
}
