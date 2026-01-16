package ir.eitaa.ui.Components;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Ads_Ad;
import ir.eitaa.tgnet.TLRPC$Ads_Location;
import ir.eitaa.tgnet.TLRPC$TL_ads_inputAdsLocationTrends;
import ir.eitaa.tgnet.TLRPC$TL_ads_simpleAd;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.CircularAdCell;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.SquarePhotoAdCell;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class SimpleAdsList extends LinearLayout {
    private SparseBooleanArray adViewsSend;
    private List<TLRPC$TL_ads_simpleAd> ads;
    private Delegate delegate;
    private RecyclerListView listView;
    public TLRPC$Ads_Location location;
    private ShadowSectionCell shadowCell;
    private boolean square;
    private GraySectionCell title;

    public interface Delegate {
        void onAdClicked(TLRPC$Ads_Ad ad);
    }

    static /* synthetic */ boolean lambda$new$1(View view, int i) {
        return true;
    }

    public SimpleAdsList(Context context) {
        super(context);
        this.ads = new ArrayList();
        this.location = new TLRPC$TL_ads_inputAdsLocationTrends();
        this.adViewsSend = new SparseBooleanArray();
        setTag(9);
        setOrientation(1);
        GraySectionCell graySectionCell = new GraySectionCell(context);
        this.title = graySectionCell;
        graySectionCell.setText("تبلیغات");
        this.title.settextSize(10);
        addView(this.title, LayoutHelper.createLinear(-1, -2));
        ShadowSectionCell shadowSectionCell = new ShadowSectionCell(context);
        this.shadowCell = shadowSectionCell;
        shadowSectionCell.setVisibility(8);
        if (this.ads.isEmpty()) {
            this.title.setVisibility(8);
        }
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) { // from class: ir.eitaa.ui.Components.SimpleAdsList.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        linearLayoutManager.setOrientation(0);
        this.listView.setLayoutManager(linearLayoutManager);
        this.listView.setAdapter(new ListAdapter());
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$SimpleAdsList$DxxwL_VeYMutRZy2NKZzi3-Ck-s
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$new$0$SimpleAdsList(view, i);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.SimpleAdsList.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                for (int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition < SimpleAdsList.this.ads.size() && iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition; iFindFirstVisibleItemPosition++) {
                    int i = ((TLRPC$TL_ads_simpleAd) SimpleAdsList.this.ads.get(iFindFirstVisibleItemPosition)).id;
                    if (!SimpleAdsList.this.adViewsSend.get(i)) {
                        MessagesController.getInstance(UserConfig.selectedAccount).addToAdViewsQueue(i, SimpleAdsList.this.location);
                        SimpleAdsList.this.adViewsSend.put(i, true);
                    }
                }
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$SimpleAdsList$mmkEcQ3HgjVjJ_OZ4HPQ23AxjME
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return SimpleAdsList.lambda$new$1(view, i);
            }
        });
        addView(this.listView, LayoutHelper.createLinear(-1, -2));
        addView(this.shadowCell, LayoutHelper.createLinear(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$SimpleAdsList(View view, int i) {
        if (i < this.ads.size()) {
            TLRPC$TL_ads_simpleAd tLRPC$TL_ads_simpleAd = this.ads.get(i);
            if (tLRPC$TL_ads_simpleAd.action == null || this.delegate == null) {
                return;
            }
            if (this.location != null) {
                MessagesController.getInstance(UserConfig.selectedAccount).addToAdActionsQueue(tLRPC$TL_ads_simpleAd.id, this.location);
            }
            this.delegate.onAdClicked(tLRPC$TL_ads_simpleAd);
        }
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e) {
        if (getParent() != null && getParent().getParent() != null) {
            getParent().getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(e);
    }

    public void showAds(List<TLRPC$Ads_Ad> newAds) {
        this.ads.clear();
        for (TLRPC$Ads_Ad tLRPC$Ads_Ad : newAds) {
            if (tLRPC$Ads_Ad instanceof TLRPC$TL_ads_simpleAd) {
                this.ads.add((TLRPC$TL_ads_simpleAd) tLRPC$Ads_Ad);
            }
        }
        if (this.ads.isEmpty()) {
            this.title.setVisibility(8);
            this.shadowCell.setVisibility(8);
        } else {
            this.title.setVisibility(0);
            this.shadowCell.setVisibility(8);
            this.listView.getAdapter().notifyDataSetChanged();
        }
    }

    public void setTitle(String titleText) {
        if (titleText == null || titleText.isEmpty()) {
            this.title.setText(LocaleController.getString("Ads", R.string.Ads));
        } else {
            this.title.setText(titleText);
        }
    }

    public void setIndex(int value) {
        ((ListAdapter) this.listView.getAdapter()).setIndex(value);
    }

    public void showCellsAsSquare(boolean square) {
        this.square = square;
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        private ListAdapter() {
        }

        public void setIndex(int value) {
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View squarePhotoAdCell;
            if (viewType == 0) {
                squarePhotoAdCell = new CircularAdCell(parent.getContext());
                squarePhotoAdCell.setLayoutParams(new RecyclerView.LayoutParams(AndroidUtilities.dp(80.0f), -2));
            } else {
                squarePhotoAdCell = new SquarePhotoAdCell(parent.getContext());
            }
            return new RecyclerListView.Holder(squarePhotoAdCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TLRPC$TL_ads_simpleAd tLRPC$TL_ads_simpleAd = (TLRPC$TL_ads_simpleAd) SimpleAdsList.this.ads.get(position);
            View view = holder.itemView;
            if (view instanceof SquarePhotoAdCell) {
                ((SquarePhotoAdCell) view).setAd(tLRPC$TL_ads_simpleAd);
            } else if (view instanceof CircularAdCell) {
                ((CircularAdCell) view).setAd(tLRPC$TL_ads_simpleAd);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return SimpleAdsList.this.square ? 1 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SimpleAdsList.this.ads.size();
        }
    }
}
