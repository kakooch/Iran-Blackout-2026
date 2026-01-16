package ir.resaneh1.iptv.fragment.home.live.fragment;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import ir.appp.ui.ActionBar.LifecycleAwareBaseFragment;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.home.live.HomeLiveCell;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* compiled from: HomeLiveListFragment.kt */
/* loaded from: classes3.dex */
public final class HomeLiveListFragment extends LifecycleAwareBaseFragment {
    private final Lazy homeLiveCell$delegate;
    private final String sectionId;
    private final String tag;
    private final String title;

    public HomeLiveListFragment(String tag, String sectionId, String title) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(sectionId, "sectionId");
        Intrinsics.checkNotNullParameter(title, "title");
        this.tag = tag;
        this.sectionId = sectionId;
        this.title = title;
        this.homeLiveCell$delegate = LazyKt__LazyJVMKt.lazy(new Function0<HomeLiveCell>() { // from class: ir.resaneh1.iptv.fragment.home.live.fragment.HomeLiveListFragment$homeLiveCell$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HomeLiveCell invoke() {
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                return new HomeLiveCell(context, this.this$0.tag, null, true);
            }
        });
    }

    private final HomeLiveCell getHomeLiveCell() {
        return (HomeLiveCell) this.homeLiveCell$delegate.getValue();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        Intrinsics.checkNotNull(context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(getHomeLiveCell(), LayoutHelper.createFrame(-1, -2, 48));
        initLiveCell();
        initActionBar();
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        View fragmentView = this.fragmentView;
        Intrinsics.checkNotNullExpressionValue(fragmentView, "fragmentView");
        return fragmentView;
    }

    private final void initActionBar() {
        this.actionBar.createCenterTitleTextView();
        this.actionBar.setTitle(this.title);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.home.live.fragment.HomeLiveListFragment.initActionBar.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    HomeLiveListFragment.this.finishFragment();
                }
            }
        });
    }

    private final void initLiveCell() {
        getHomeLiveCell().setSection_id(this.sectionId);
        getHomeLiveCell().setTag(this.tag);
        getHomeLiveCell().setMaxItemCount(ConnectionsManager.DEFAULT_DATACENTER_ID);
        getHomeLiveCell().getHeaderInfoCell().hideTitle();
        getHomeLiveCell().setRefreshOnAttach(true);
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        this.needLockOrientation = true;
        return super.onFragmentCreate();
    }
}
