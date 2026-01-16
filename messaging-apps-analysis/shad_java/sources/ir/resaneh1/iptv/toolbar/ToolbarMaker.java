package ir.resaneh1.iptv.toolbar;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.SearchContainerFragment;
import ir.resaneh1.iptv.helper.FlavorHelper;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes4.dex */
public class ToolbarMaker {
    public LinearLayout centerView;
    ImageView imageViewCenter;
    public LinearLayout leftLayout;
    Activity mActivity;
    public LinearLayout rightLayout;
    private boolean rtlLayout = true;
    public Toolbar toolbar;
    FrameLayout toolbar2;
    View toolbarContainer;
    public ToolbarImageView toolbarImageView;
    public ToolbarTextView toolbarTextView;

    public ToolbarMaker(Activity activity, View view) {
        this.toolbarContainer = view;
        this.mActivity = activity;
        findViews();
        findViewsSecond();
    }

    public void findViews() {
        View view = this.toolbarContainer;
        if (view != null) {
            this.toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        }
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            this.rightLayout = (LinearLayout) toolbar.findViewById(R.id.rightLayout);
            this.leftLayout = (LinearLayout) this.toolbar.findViewById(R.id.leftLayout);
            this.imageViewCenter = (ImageView) this.toolbar.findViewById(R.id.toolbar_imageview_center);
            this.centerView = (LinearLayout) this.toolbar.findViewById(R.id.toolbar_center_frame);
        }
        this.toolbarImageView = new ToolbarImageView();
        this.toolbarTextView = new ToolbarTextView();
    }

    public void findViewsSecond() {
        if (this.toolbar != null) {
            FrameLayout frameLayout = (FrameLayout) this.toolbarContainer.findViewById(R.id.toolbar_lay2);
            this.toolbar2 = frameLayout;
            if (frameLayout == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 17) {
            }
        }
        hideToolbar2();
    }

    public void setToolbarForHomeFragment(boolean z) {
        setToolbarForHomeFragment(z, true);
    }

    public void setToolbarForHomeFragment(boolean z, boolean z2) {
        clearToolbar();
        int i = Theme.key_actionBarDefault;
        setBackgroundColor(Theme.getColor(i));
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setBackgroundColor(Theme.getColor(i));
        }
        addToCenterImageView(R.drawable.ic_home_logo);
        if (z) {
            View viewCreateView = this.toolbarImageView.createView(this.mActivity, R.drawable.arrow_back_grey, Integer.valueOf(Theme.getColor(Theme.key_actionBarDefaultIcon)));
            viewCreateView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.toolbar.ToolbarMaker.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ToolbarMaker.this.mActivity.onBackPressed();
                }
            });
            addViewToRightLayout(viewCreateView);
        }
        if (z2) {
            View viewCreateView2 = this.toolbarImageView.createView(this.mActivity, R.drawable.ic_search_small_grey, Integer.valueOf(Theme.getColor(Theme.key_actionBarDefaultIcon)));
            viewCreateView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.toolbar.ToolbarMaker.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        ((LaunchActivity) ToolbarMaker.this.mActivity).getLastFragment().presentFragment(new SearchContainerFragment(BuildConfig.FLAVOR, true));
                    } catch (Exception unused) {
                    }
                }
            });
            addViewToLeftLayout(viewCreateView2);
        }
    }

    public void setToolbarWithBackButtonAndTextGrey(final Activity activity, String str) {
        clearToolbar();
        View viewCreateView = this.toolbarImageView.createView(activity, getBackIcon(), Integer.valueOf(Theme.getColor(Theme.key_actionBarDefaultIcon)));
        View viewCreateView2 = this.toolbarTextView.createView(activity, str);
        this.toolbarTextView.textView.setTextColor(Theme.getColor(Theme.key_actionBarDefaultTitle));
        viewCreateView.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.toolbar.ToolbarMaker.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });
        addViewToRightLayout(viewCreateView);
        addViewToRightLayout(viewCreateView2);
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        }
    }

    public void setToolbarWithBackButtonAndTextWhite(final Activity activity, String str) {
        clearToolbar();
        View viewCreateView = this.toolbarImageView.createView(activity, getBackIcon());
        View viewCreateView2 = this.toolbarTextView.createView(activity, str);
        this.toolbarTextView.textView.setTextColor(activity.getResources().getColor(R.color.white));
        viewCreateView.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.toolbar.ToolbarMaker.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });
        addViewToRightLayout(viewCreateView);
        addViewToRightLayout(viewCreateView2);
    }

    public void setToolbarTransparentWithWhiteBackButton(final Activity activity, String str) {
        clearToolbar();
        View viewCreateView = this.toolbarImageView.createView(activity, R.drawable.ic_arrow_back_white);
        View viewCreateView2 = this.toolbarTextView.createView(activity, str);
        this.toolbarTextView.textView.setTextColor(activity.getResources().getColor(R.color.white));
        viewCreateView.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.toolbar.ToolbarMaker.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });
        addViewToRightLayout(viewCreateView);
        addViewToRightLayout(viewCreateView2);
    }

    public void clearToolbar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setBackgroundColor(0);
            LinearLayout linearLayout = this.rightLayout;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            LinearLayout linearLayout2 = this.leftLayout;
            if (linearLayout2 != null) {
                linearLayout2.removeAllViews();
            }
            LinearLayout linearLayout3 = this.centerView;
            if (linearLayout3 != null) {
                linearLayout3.removeAllViews();
            }
        }
    }

    public void setRtlLayout(boolean z) {
        this.rtlLayout = z;
    }

    private boolean isRtlLayout() {
        return this.rtlLayout;
    }

    public void setToolbarWithBackButton(int i) {
        clearToolbar();
        View viewCreateView = this.toolbarImageView.createView(this.mActivity, i, Integer.valueOf(Theme.getColor(Theme.key_actionBarDefaultIcon)));
        viewCreateView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.toolbar.ToolbarMaker.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToolbarMaker.this.mActivity.onBackPressed();
            }
        });
        addViewToRightLayout(viewCreateView);
    }

    private int getBackIcon() {
        return isRtlLayout() ? R.drawable.ic_arrow_back_white : R.drawable.ic_ab_back;
    }

    public void setInstaToolbar(String str) {
        clearToolbar();
        setToolbarWithBackButton(getBackIcon());
        this.toolbar.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        ToolbarTextView toolbarTextView = new ToolbarTextView();
        toolbarTextView.createView(this.mActivity, str);
        toolbarTextView.textView.setTextColor(this.mActivity.getResources().getColor(R.color.toolbar_text_grey));
        addToCenter(toolbarTextView.view);
    }

    public void addViewToRightLayout(View view) {
        if (isRtlLayout()) {
            LinearLayout linearLayout = this.rightLayout;
            if (linearLayout == null || view == null) {
                return;
            }
            linearLayout.addView(view, 0);
            return;
        }
        LinearLayout linearLayout2 = this.leftLayout;
        if (linearLayout2 == null || view == null) {
            return;
        }
        linearLayout2.addView(view);
    }

    public void addViewToLeftLayout(View view) {
        if (isRtlLayout()) {
            LinearLayout linearLayout = this.leftLayout;
            if (linearLayout == null || view == null) {
                return;
            }
            linearLayout.addView(view, 0);
            return;
        }
        LinearLayout linearLayout2 = this.leftLayout;
        if (linearLayout2 != null) {
            linearLayout2.addView(view);
        }
    }

    public void hideToolbar2() {
        FrameLayout frameLayout = this.toolbar2;
        if (frameLayout == null || frameLayout.getVisibility() != 0) {
            return;
        }
        this.toolbar2.setVisibility(4);
    }

    public void addToCenterImageView(int i) {
        ImageView imageView = this.imageViewCenter;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.imageViewCenter.setImageResource(i);
            if (!FlavorHelper.isShad()) {
                this.imageViewCenter.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_actionBarDefaultIcon), PorterDuff.Mode.MULTIPLY));
            }
            if (FlavorHelper.isShad()) {
                this.imageViewCenter.setPadding(0, 0, 0, 0);
            }
        }
        LinearLayout linearLayout = this.centerView;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void addToCenter(View view) {
        LinearLayout linearLayout = this.centerView;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.centerView.addView(view);
        }
        ImageView imageView = this.imageViewCenter;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void setBackgroundColor(int i) {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setBackgroundColor(i);
        }
    }
}
