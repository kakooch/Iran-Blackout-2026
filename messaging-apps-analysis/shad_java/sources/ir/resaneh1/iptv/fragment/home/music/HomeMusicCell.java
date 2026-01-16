package ir.resaneh1.iptv.fragment.home.music;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.home.HomeCell;
import ir.resaneh1.iptv.helper.CustomTextView;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RLottieImageView;
import org.rbmain.ui.Components.RecyclerListView;

/* compiled from: HomeMusicCell.kt */
/* loaded from: classes3.dex */
public final class HomeMusicCell extends HomeCell {
    private HomeMusicAdapter adapter;
    private RecyclerListView listView;
    private RLottieImageView lottieImageView;
    private FrameLayout mainFrameLayout;
    private TextView titleTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeMusicCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
    }

    @Override // ir.resaneh1.iptv.fragment.home.HomeCell
    public View createMainView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        initViews(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.addView(createTitleLayout(context), LayoutHelper.createLinear(-2, -2, 5, 8, 8, 8, 8));
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            recyclerListView = null;
        }
        linearLayout.addView(recyclerListView, LayoutHelper.createLinear(-1, -2, 17, 8, 8, 8, 8));
        FrameLayout frameLayout = this.mainFrameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFrameLayout");
            frameLayout = null;
        }
        frameLayout.addView(linearLayout, LayoutHelper.createFrame(-1, -2.0f, 17, 8.0f, 6.0f, 8.0f, 6.0f));
        FrameLayout frameLayout2 = this.mainFrameLayout;
        if (frameLayout2 != null) {
            return frameLayout2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mainFrameLayout");
        return null;
    }

    private final void initViews(Context context) {
        TextView textViewBuild = new CustomTextView.Builder(context).setTextSize(16).setGravity(5).isBold(true).setText(LocaleController.getString(R.string.home_music_play_list)).setTextColor(Theme.getColor(Theme.key_dialogTextBlack)).build();
        Intrinsics.checkNotNullExpressionValue(textViewBuild, "Builder(context)\n       …ck))\n            .build()");
        this.titleTextView = textViewBuild;
        this.lottieImageView = new RLottieImageView(context);
        this.adapter = new HomeMusicAdapter(context);
        this.mainFrameLayout = new FrameLayout(context);
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, true));
        RecyclerListView recyclerListView2 = this.listView;
        HomeMusicAdapter homeMusicAdapter = null;
        if (recyclerListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            recyclerListView2 = null;
        }
        HomeMusicAdapter homeMusicAdapter2 = this.adapter;
        if (homeMusicAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            homeMusicAdapter = homeMusicAdapter2;
        }
        recyclerListView2.setAdapter(homeMusicAdapter);
    }

    private final FrameLayout createTitleLayout(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        TextView textView = this.titleTextView;
        RLottieImageView rLottieImageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView = null;
        }
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 21, 44.0f, 0.0f, 0.0f, 0.0f));
        RLottieImageView rLottieImageView2 = this.lottieImageView;
        if (rLottieImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieImageView");
            rLottieImageView2 = null;
        }
        frameLayout.addView(rLottieImageView2, LayoutHelper.createLinear(40, 40, 19));
        RLottieImageView rLottieImageView3 = this.lottieImageView;
        if (rLottieImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieImageView");
            rLottieImageView3 = null;
        }
        rLottieImageView3.setAutoRepeat(true);
        RLottieImageView rLottieImageView4 = this.lottieImageView;
        if (rLottieImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieImageView");
            rLottieImageView4 = null;
        }
        rLottieImageView4.setAnimation(R.raw.home_music_cell, 40, 40);
        RLottieImageView rLottieImageView5 = this.lottieImageView;
        if (rLottieImageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieImageView");
        } else {
            rLottieImageView = rLottieImageView5;
        }
        rLottieImageView.playAnimation();
        return frameLayout;
    }

    public final void setData(HomePageModels.HomePageSectionObject homePageSectionObject) {
        HomePageModels.HeaderInfoObject headerInfoObject;
        String str;
        resetData();
        if (isValid(homePageSectionObject)) {
            VisibilityHelper.showViews(this);
            Intrinsics.checkNotNull(homePageSectionObject);
            setSectionInfoData(homePageSectionObject.common_section_data, homePageSectionObject.type);
            HomeMusicAdapter homeMusicAdapter = this.adapter;
            TextView textView = null;
            if (homeMusicAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                homeMusicAdapter = null;
            }
            ArrayList<HomePageModels.MusicItem> arrayList = homePageSectionObject.music_section.music_items_list;
            Intrinsics.checkNotNullExpressionValue(arrayList, "sectionObject.music_section.music_items_list");
            homeMusicAdapter.setData(arrayList);
            HomePageModels.CommonSectionDataObject commonSectionDataObject = homePageSectionObject.common_section_data;
            if (commonSectionDataObject == null || (headerInfoObject = commonSectionDataObject.header_info) == null || (str = headerInfoObject.title) == null) {
                return;
            }
            TextView textView2 = this.titleTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            } else {
                textView = textView2;
            }
            textView.setText(str);
            return;
        }
        VisibilityHelper.hideViews(this);
    }

    private final void resetData() {
        TextView textView = this.titleTextView;
        HomeMusicAdapter homeMusicAdapter = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView = null;
        }
        textView.setText(BuildConfig.FLAVOR);
        HomeMusicAdapter homeMusicAdapter2 = this.adapter;
        if (homeMusicAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            homeMusicAdapter = homeMusicAdapter2;
        }
        homeMusicAdapter.clearData();
    }

    public final boolean isValid(HomePageModels.HomePageSectionObject homePageSectionObject) {
        HomePageModels.MusicSectionObject musicSectionObject;
        return (homePageSectionObject == null || (musicSectionObject = homePageSectionObject.music_section) == null || musicSectionObject.music_items_list == null) ? false : true;
    }
}
