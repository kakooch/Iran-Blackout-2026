package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.appp.common.utils.AndroidUtilities;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import java.util.ArrayList;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class ProfileHorizontalListView extends RecyclerListView {
    ArrayList<RubinoProfileObject> arrayList;
    Context mContext;

    @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getParent() != null && getParent().getParent() != null) {
            getParent().getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public ProfileHorizontalListView(Context context) {
        super(context);
        int i = UserConfig.selectedAccount;
        setWillNotDraw(false);
        this.mContext = context;
        this.arrayList = new ArrayList<>();
        setPadding(AndroidUtilities.dp(2.0f), 0, AndroidUtilities.dp(2.0f), 0);
        setItemAnimator(null);
        setLayoutAnimation(null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, context) { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHorizontalListView.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        if (Build.VERSION.SDK_INT >= 17) {
            setLayoutDirection(0);
        }
        linearLayoutManager.setOrientation(0);
        setLayoutManager(linearLayoutManager);
        setAdapter(new ListAdapter());
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0.0f, getHeight() - 1, getWidth(), getHeight() - 1, Theme.getDividerPaint());
    }

    public void addOrUpdateProfileList(ArrayList<RubinoProfileObject> arrayList, boolean z) {
        if (z) {
            this.arrayList.clear();
        }
        this.arrayList.addAll(arrayList);
        getAdapter().notifyDataSetChanged();
    }

    class ListAdapter extends RecyclerListView.SelectionAdapter {
        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        ListAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new RecyclerListView.Holder(new RubinoRelatedProfileCell(ProfileHorizontalListView.this.mContext));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (i < ProfileHorizontalListView.this.arrayList.size()) {
                ((RubinoRelatedProfileCell) viewHolder.itemView).setData(ProfileHorizontalListView.this.arrayList.get(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ProfileHorizontalListView.this.arrayList.size();
        }
    }

    public void updateItem(String str) {
        RubinoRelatedProfileCell rubinoRelatedProfileCell;
        RubinoProfileObject rubinoProfileObject;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof RubinoRelatedProfileCell) && (rubinoProfileObject = (rubinoRelatedProfileCell = (RubinoRelatedProfileCell) childAt).profileObject) != null && rubinoProfileObject.id.equals(str)) {
                rubinoRelatedProfileCell.setData(rubinoRelatedProfileCell.profileObject);
                return;
            }
        }
    }
}
