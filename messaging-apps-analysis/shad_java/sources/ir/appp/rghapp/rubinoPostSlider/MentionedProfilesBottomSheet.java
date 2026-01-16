package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.ProfileOrHashtagCell;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;

/* compiled from: MentionedProfilesBottomSheet.kt */
/* loaded from: classes3.dex */
public final class MentionedProfilesBottomSheet extends BottomSheet {
    private final View contentView;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mentionedProfilesAdapter;
    private RecyclerView mentionedProfilesRecyclerView;
    private ArrayList<RubinoProfileObject> taggedProfiles;
    private TextView title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MentionedProfilesBottomSheet(Context context, boolean z) {
        super(context, z);
        Intrinsics.checkNotNullParameter(context, "context");
        this.contentView = View.inflate(context, R.layout.rubino_mention_bottom_sheet, null);
        initViews();
    }

    private final void initViews() {
        setupShadowDrawable();
        FrameLayout frameLayout = new FrameLayout(getContext()) { // from class: ir.appp.rghapp.rubinoPostSlider.MentionedProfilesBottomSheet.initViews.1
            private boolean ignoreLayout;

            {
                new LinkedHashMap();
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.ignoreLayout = true;
                    setPadding(((BottomSheet) MentionedProfilesBottomSheet.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) MentionedProfilesBottomSheet.this).backgroundPaddingLeft, 0);
                    this.ignoreLayout = false;
                }
                super.onMeasure(i, i2);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                int iDp = (-((BottomSheet) MentionedProfilesBottomSheet.this).backgroundPaddingTop) - AndroidUtilities.dp(13.0f);
                int measuredHeight = getMeasuredHeight() + AndroidUtilities.dp(150.0f) + ((BottomSheet) MentionedProfilesBottomSheet.this).backgroundPaddingTop;
                if (Build.VERSION.SDK_INT >= 21) {
                    int i = AndroidUtilities.statusBarHeight;
                    iDp += i;
                    measuredHeight -= i;
                }
                ((BottomSheet) MentionedProfilesBottomSheet.this).shadowDrawable.setBounds(0, iDp, getMeasuredWidth(), measuredHeight);
                Drawable drawable = ((BottomSheet) MentionedProfilesBottomSheet.this).shadowDrawable;
                Intrinsics.checkNotNull(canvas);
                drawable.draw(canvas);
            }
        };
        this.containerView = frameLayout;
        frameLayout.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i = this.backgroundPaddingLeft;
        viewGroup.setPadding(i, 0, i, 0);
        setBackgroundColor(Theme.getColor(Theme.key_mainTabBackground));
        this.containerView.addView(this.contentView, LayoutHelper.createFrame(-1, -1, 8388659, 0.0f, 0.0f, 0.0f, 0.0f));
        TextView textView = (TextView) this.contentView.findViewById(R.id.mention_view_title);
        this.title = textView;
        if (textView != null) {
            textView.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
            textView.setTypeface(Theme.getRubinoTypeFaceBold());
            textView.setText(LocaleController.getString(R.string.mention_view_title));
        }
        this.mentionedProfilesRecyclerView = (RecyclerView) this.contentView.findViewById(R.id.mention_rv);
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = new RecyclerView.Adapter<RecyclerView.ViewHolder>() { // from class: ir.appp.rghapp.rubinoPostSlider.MentionedProfilesBottomSheet.initViews.3
            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i2) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                ProfileOrHashtagCell profileOrHashtagCell = new ProfileOrHashtagCell(MentionedProfilesBottomSheet.this.getContext(), true, false);
                if (Build.VERSION.SDK_INT >= 23) {
                    profileOrHashtagCell.container.setForeground(null);
                }
                profileOrHashtagCell.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                return new BaseViewHolder(profileOrHashtagCell);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int i2) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                ProfileOrHashtagCell profileOrHashtagCell = (ProfileOrHashtagCell) holder.itemView;
                ArrayList arrayList = MentionedProfilesBottomSheet.this.taggedProfiles;
                profileOrHashtagCell.setProfile(arrayList == null ? null : (RubinoProfileObject) arrayList.get(i2), 0);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                ArrayList arrayList = MentionedProfilesBottomSheet.this.taggedProfiles;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            }
        };
        this.mentionedProfilesAdapter = adapter;
        RecyclerView recyclerView = this.mentionedProfilesRecyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private final void setupShadowDrawable() {
        Rect rect = new Rect();
        Drawable drawableMutate = getContext().getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogBackground), PorterDuff.Mode.MULTIPLY));
        this.shadowDrawable.getPadding(rect);
        this.backgroundPaddingLeft = rect.left;
        this.backgroundPaddingTop = rect.top;
    }

    public final void setTaggedProfiles(ArrayList<RubinoProfileObject> arrayList) {
        this.taggedProfiles = arrayList;
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.mentionedProfilesAdapter;
        if (adapter == null) {
            return;
        }
        adapter.notifyDataSetChanged();
    }

    public final boolean hasSetTaggedProfiles() {
        return this.taggedProfiles != null;
    }

    /* compiled from: MentionedProfilesBottomSheet.kt */
    public static final class BaseViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }
}
