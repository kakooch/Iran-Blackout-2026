package ir.resaneh1.iptv.fragment.home.parallax;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidMessenger.helper.GlideHelper;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.HomePageActivityNew;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;

/* compiled from: ParallaxAdapter.kt */
/* loaded from: classes3.dex */
public final class ParallaxAdapter extends RecyclerView.Adapter<Holder> implements ParallaxClickListener {
    public static final Companion Companion = new Companion(null);
    private static int clickedPosition = -1;
    private final Handler handler;
    private int itemSize;
    private final ArrayList<HomePageModels.ParallaxItem> items;
    private final Context mContext;
    private final Runnable runnable;

    public ParallaxAdapter(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.items = new ArrayList<>();
        this.runnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.home.parallax.ParallaxAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ParallaxAdapter.m466runnable$lambda2(this.f$0);
            }
        };
        this.handler = new Handler();
    }

    public final void updateList(List<? extends HomePageModels.ParallaxItem> collections, int i) {
        Intrinsics.checkNotNullParameter(collections, "collections");
        this.items.clear();
        this.items.addAll(collections);
        this.itemSize = i;
        notifyDataSetChanged();
    }

    public final void clearData() {
        this.items.clear();
        this.itemSize = 0;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Holder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        int iDp = AndroidUtilities.dp(8.0f);
        linearLayout.setPadding(iDp, iDp, iDp, iDp);
        ImageView imageView = new ImageView(this.mContext);
        int i2 = this.itemSize;
        int iDp2 = i2 > 0 ? i2 - (AndroidUtilities.dp(8.0f) * 2) : AndroidUtilities.dp(100.0f);
        imageView.setId(R.id.parallax_image_view);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(iDp2, iDp2));
        return new Holder(linearLayout);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(Holder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        boolean z = false;
        if (i >= 0 && i < getItemCount()) {
            z = true;
        }
        if (z) {
            Context context = this.mContext;
            ImageView imageView = holder.getImageView();
            ArrayList<HomePageModels.ParallaxItem> arrayList = this.items;
            GlideHelper.loadRoundedCornerParallax(context, imageView, arrayList.get(i % arrayList.size()).image_url);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    /* compiled from: ParallaxAdapter.kt */
    public static final class Holder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            View viewFindViewById = view.findViewById(R.id.parallax_image_view);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.parallax_image_view)");
            this.imageView = (ImageView) viewFindViewById;
        }

        public final ImageView getImageView() {
            return this.imageView;
        }
    }

    /* compiled from: ParallaxAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: runnable$lambda-2, reason: not valid java name */
    public static final void m466runnable$lambda2(ParallaxAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = clickedPosition;
        if (i == -1) {
            return;
        }
        ArrayList<HomePageModels.ParallaxItem> arrayList = this$0.items;
        if (arrayList.get(i % arrayList.size()).action_link != null) {
            ArrayList<HomePageModels.ParallaxItem> arrayList2 = this$0.items;
            HomePageActivityNew.onLinkClick(arrayList2.get(clickedPosition % arrayList2.size()).action_link);
        }
    }

    public final void cancelClick() {
        if (clickedPosition != -1) {
            clickedPosition = -1;
            this.handler.removeCallbacks(this.runnable);
        }
    }

    public void click(int i) {
        clickedPosition = i;
        this.handler.postDelayed(this.runnable, 200L);
    }
}
