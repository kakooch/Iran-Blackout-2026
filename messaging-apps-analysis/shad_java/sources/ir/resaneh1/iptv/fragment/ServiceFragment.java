package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UICellService;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GetTileInput;
import ir.resaneh1.iptv.model.GetTileOutput;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.OpenInPackageDataInLink;
import ir.resaneh1.iptv.model.ServiceItem;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.toolbar.ToolbarTextView;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class ServiceFragment extends PresenterFragment {
    public boolean isFirstPage;
    public boolean isHasBackButton;
    public boolean isLastPortrait;
    View.OnClickListener onClickListener;
    String page;
    public ArrayList<ServiceItem> serviceItemsLandscape;
    public ArrayList<ServiceItem> serviceItemsPortrait;
    public String title;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_framelayout;
    }

    public ServiceFragment(String str) {
        this.isHasBackButton = true;
        this.isFirstPage = false;
        this.isLastPortrait = true;
        this.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.ServiceFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MainClickHandler().onLinkClick(ServiceFragment.this.baseFragment, ((ServiceItem) view.getTag()).link);
            }
        };
        this.page = str;
    }

    public ServiceFragment(String str, String str2) {
        this.isHasBackButton = true;
        this.isFirstPage = false;
        this.isLastPortrait = true;
        this.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.ServiceFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MainClickHandler().onLinkClick(ServiceFragment.this.baseFragment, ((ServiceItem) view.getTag()).link);
            }
        };
        this.page = str;
        this.title = str2;
        this.isFirstPage = false;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        setToolbar();
        if (MyLog.isDebugAble) {
            ToolbarTextView toolbarTextView = new ToolbarTextView();
            toolbarTextView.createView((Activity) this.mContext, "home");
            toolbarTextView.view.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.ServiceFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            this.toolbarMaker.addViewToLeftLayout(toolbarTextView.view);
            ToolbarTextView toolbarTextView2 = new ToolbarTextView();
            toolbarTextView2.createView((Activity) this.mContext, "openMessage");
            toolbarTextView2.view.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.ServiceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Link link = new Link();
                    link.type = Link.LinkTypeEnum.openinpackage;
                    OpenInPackageDataInLink openInPackageDataInLink = new OpenInPackageDataInLink();
                    link.open_in_package_data = openInPackageDataInLink;
                    openInPackageDataInLink.package_name = "ir.resaneh1.iptv";
                    openInPackageDataInLink.open_url = "https://go.rubika.ir/salam";
                    new MainClickHandler().onLinkClick(link);
                }
            });
            this.toolbarMaker.addViewToRightLayout(toolbarTextView2.view);
            toolbarTextView.createView((Activity) this.mContext, "change");
            toolbarTextView.view.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.ServiceFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            this.toolbarMaker.addViewToLeftLayout(toolbarTextView.view);
            ToolbarTextView toolbarTextView3 = new ToolbarTextView();
            toolbarTextView3.createView((Activity) this.mContext, "Fold");
            toolbarTextView3.view.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.ServiceFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Link link = new Link();
                    link.type = Link.LinkTypeEnum.chatfolder;
                    new MainClickHandler().onLinkClick(link);
                }
            });
            this.toolbarMaker.addViewToLeftLayout(toolbarTextView3.view);
            ToolbarTextView toolbarTextView4 = new ToolbarTextView();
            toolbarTextView4.createView((Activity) this.mContext, "sup");
            toolbarTextView4.view.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.ServiceFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Link link = new Link();
                    link.type = null;
                    Link.ToastDataInLink toastDataInLink = new Link.ToastDataInLink();
                    link.toast_data = toastDataInLink;
                    toastDataInLink.text = "default";
                    Link link2 = new Link();
                    Link.LinkTypeEnum linkTypeEnum = Link.LinkTypeEnum.toast;
                    link2.type = linkTypeEnum;
                    link2.type = null;
                    Link.ToastDataInLink toastDataInLink2 = new Link.ToastDataInLink();
                    link2.toast_data = toastDataInLink2;
                    toastDataInLink2.text = "supported";
                    Link link3 = new Link();
                    link3.type = linkTypeEnum;
                    link3.type = null;
                    Link.ToastDataInLink toastDataInLink3 = new Link.ToastDataInLink();
                    link3.toast_data = toastDataInLink3;
                    toastDataInLink3.text = "Not supported";
                    link.if_supperted_link = link2;
                    link.not_supperted_link = link3;
                    new MainClickHandler().onLinkClick(link);
                }
            });
            this.toolbarMaker.addViewToLeftLayout(toolbarTextView4.view);
        }
        this.progressBar.setVisibility(0);
        callGetServiceList();
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        if (this.isFirstPage) {
            this.toolbarMaker.setRtlLayout(false);
            this.toolbarMaker.setToolbarForHomeFragment(this.isHasBackButton);
            return;
        }
        String str = this.title;
        if (str == null || str.isEmpty()) {
            this.title = "بازگشت";
        }
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, this.title);
    }

    private void callGetServiceList() {
        MyLog.e("ApirequestMessanger", "CacheDatabaseHelper3");
        this.progressBar.setVisibility(0);
        View view = this.retryLayout;
        if (view != null) {
            view.setVisibility(4);
        }
        ApiRequestMessanger.getInstance(this.currentAccount).getTiles(new GetTileInput(this.page), new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.ServiceFragment.6
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                ServiceFragment.this.progressBar.setVisibility(4);
                View view2 = ServiceFragment.this.retryLayout;
                if (view2 != null) {
                    view2.setVisibility(4);
                }
                GetTileOutput getTileOutput = (GetTileOutput) obj;
                ServiceFragment serviceFragment = ServiceFragment.this;
                serviceFragment.serviceItemsPortrait = getTileOutput.portrait;
                serviceFragment.serviceItemsLandscape = getTileOutput.landscape;
                if (serviceFragment.isPortrait()) {
                    ServiceFragment serviceFragment2 = ServiceFragment.this;
                    serviceFragment2.makeLayout(serviceFragment2.serviceItemsPortrait);
                } else {
                    ServiceFragment serviceFragment3 = ServiceFragment.this;
                    serviceFragment3.makeLayout(serviceFragment3.serviceItemsLandscape);
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                ServiceFragment.this.progressBar.setVisibility(4);
                ServiceFragment.this.showRetryLayout();
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                ServiceFragment.this.progressBar.setVisibility(4);
                ServiceFragment.this.showRetryLayout();
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        super.retryCall();
        callGetServiceList();
    }

    void makeLayout(ArrayList<ServiceItem> arrayList) {
        Link link;
        this.progressBar.setVisibility(4);
        FrameLayout frameLayout = this.frameLayout;
        if (frameLayout == null || arrayList == null) {
            return;
        }
        frameLayout.removeAllViews();
        float screenWidth = DimensionHelper.getScreenWidth((Activity) this.mContext);
        DimensionHelper.getScreenHeight((Activity) this.mContext);
        Iterator<ServiceItem> it = arrayList.iterator();
        while (it.hasNext()) {
            ServiceItem next = it.next();
            View viewCreateView = new UICellService().createView((Activity) getContext(), next);
            viewCreateView.setTag(next);
            Link link2 = next.link;
            if (link2 != null && link2.type != Link.LinkTypeEnum.none) {
                viewCreateView.setOnClickListener(this.onClickListener);
            }
            try {
                if (MyLog.isDebugAble && (link = next.link) != null && link.type != Link.LinkTypeEnum.none) {
                    link.content_description = "salam";
                }
                String str = next.link.content_description;
                if (str != null) {
                    viewCreateView.setContentDescription(str);
                }
            } catch (Exception unused) {
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((next.X2 - next.X1) * screenWidth) / 100.0f), (int) (((next.Y2 - next.Y1) * screenWidth) / 100.0f));
            float f = ((int) (next.Y1 * screenWidth)) / 100;
            float f2 = ((int) (next.X1 * screenWidth)) / 100;
            int i = (int) f;
            layoutParams.setMargins(0, i, 0, 0);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.gravity = 5;
                layoutParams.setMargins(0, i, (int) f2, 0);
            } else {
                layoutParams.setMargins((int) f2, i, 0, 0);
            }
            viewCreateView.setLayoutParams(layoutParams);
            this.frameLayout.addView(viewCreateView);
        }
        this.frameLayout.setPadding(0, 0, 0, AndroidUtilities.dp(8.0f));
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.isLastPortrait != isPortrait()) {
            if (isPortrait()) {
                this.isLastPortrait = true;
                makeLayout(this.serviceItemsPortrait);
            } else {
                this.isLastPortrait = false;
                makeLayout(this.serviceItemsLandscape);
            }
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            this.isLastPortrait = true;
            makeLayout(this.serviceItemsPortrait);
        } else {
            this.isLastPortrait = false;
            makeLayout(this.serviceItemsLandscape);
        }
    }
}
