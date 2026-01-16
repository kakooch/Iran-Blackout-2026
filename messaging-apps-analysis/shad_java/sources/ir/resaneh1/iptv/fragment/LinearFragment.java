package ir.resaneh1.iptv.fragment;

import android.view.View;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;

/* loaded from: classes3.dex */
public class LinearFragment extends PresenterFragment {
    View view;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.linearlayout_fragment;
    }

    public LinearFragment(View view) {
        this.view = view;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.swipeBackEnabled = false;
        this.progressBar.setVisibility(4);
        this.linearLayout.addView(this.view);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }
}
