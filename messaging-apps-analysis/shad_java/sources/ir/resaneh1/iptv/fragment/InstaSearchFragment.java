package ir.resaneh1.iptv.fragment;

import android.os.Handler;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.InstaGetHashTagsOutput;
import ir.resaneh1.iptv.model.InstaGetListInput;
import ir.resaneh1.iptv.model.InstaGetProfilesOutput;
import ir.resaneh1.iptv.model.InstaHashTagObject;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.InstaContactRowPresenter;
import ir.resaneh1.iptv.presenters.InstaHashTagRowPresenter;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class InstaSearchFragment extends PresenterFragment {
    public String lastSearchedText;
    public String searchingText;
    public TypeEnum type;
    private Handler handler = new Handler();
    private Call<MessangerOutput<InstaGetProfilesOutput>> lastProfileSearchCall = null;
    private Call<MessangerOutput<InstaGetHashTagsOutput>> lastHashTagSearchCall = null;
    private Call<MessangerOutput<InstaGetHashTagsOutput>> lastHashTagTrendCall = null;
    Runnable instaRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.InstaSearchFragment.6
        @Override // java.lang.Runnable
        public void run() {
            InstaSearchFragment.this.onSearchClickInsta();
        }
    };

    public enum TypeEnum {
        hashTag,
        profile
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_just_recycler;
    }

    public InstaSearchFragment(TypeEnum typeEnum) {
        this.type = typeEnum;
        this.fragmentName = "InstaSearchFragment";
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        initWithVerticalLinearLayoutManager();
        this.progressBar.setVisibility(4);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.InstaSearchFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.instaHashTag) {
                    return new InstaHashTagRowPresenter(InstaSearchFragment.this.mContext);
                }
                if (presenterItemType == PresenterItemType.instaProfile) {
                    InstaContactRowPresenter instaContactRowPresenter = new InstaContactRowPresenter(InstaSearchFragment.this.mContext);
                    instaContactRowPresenter.isButtonsVisible = false;
                    return instaContactRowPresenter;
                }
                return MainPresenterSelector.getInstance(InstaSearchFragment.this.mContext).getPresenter(presenterItemType);
            }
        }, new OnPresenterItemClickListener(this) { // from class: ir.resaneh1.iptv.fragment.InstaSearchFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                if (abstractViewHolder.item.getPresenterType() == PresenterItemType.instaHashTag) {
                    new MainClickHandler().onInstaHashTagClicked(((InstaHashTagObject) abstractViewHolder.item).content);
                } else {
                    if (abstractViewHolder.item.getPresenterType() != PresenterItemType.instaProfile || ApplicationLoader.applicationActivity == null) {
                        return;
                    }
                    new MainClickHandler().onRubinoProfileClick((InstaProfileObject) abstractViewHolder.item);
                }
            }
        }, null);
        this.mainAdapter = mainAdapter;
        this.mainRecyclerView.setAdapter(mainAdapter);
        callGetTrend();
    }

    private void callGetTrend() {
        if (this.type == TypeEnum.hashTag) {
            callGetHashTagTrend();
        }
    }

    private void callGetHashTagTrend() {
        this.notFoundLayout.setVisibility(4);
        this.retryLayout.setVisibility(4);
        this.progressBar.setVisibility(0);
        InstaGetListInput instaGetListInput = new InstaGetListInput();
        instaGetListInput.limit = 50;
        this.lastHashTagTrendCall = ApiRequestMessanger.getInstance(this.currentAccount).instaGetHashTagTrend(instaGetListInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.InstaSearchFragment.3
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                ArrayList<InstaHashTagObject> arrayList;
                InstaSearchFragment.this.progressBar.setVisibility(4);
                if (call.isCanceled()) {
                    return;
                }
                InstaSearchFragment.this.mainArrayList.clear();
                InstaSearchFragment.this.mainAdapter.notifyDataSetChanged();
                InstaGetHashTagsOutput instaGetHashTagsOutput = (InstaGetHashTagsOutput) obj;
                if (instaGetHashTagsOutput == null || (arrayList = instaGetHashTagsOutput.hash_tags) == null || arrayList.size() <= 0) {
                    return;
                }
                InstaSearchFragment.this.mainArrayList.addAll(instaGetHashTagsOutput.hash_tags);
                InstaSearchFragment.this.mainAdapter.notifyDataSetChanged();
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                if (call.isCanceled()) {
                    return;
                }
                InstaSearchFragment.this.progressBar.setVisibility(4);
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                InstaSearchFragment.this.progressBar.setVisibility(4);
            }
        });
    }

    public void onSearchClickInsta() {
        onSearchClickInsta(this.searchingText);
    }

    public void onSearchClickInsta(String str) {
        if (str == null) {
            return;
        }
        if (str.equals(BuildConfig.FLAVOR)) {
            if (str.equals(this.lastSearchedText)) {
                return;
            }
            this.lastSearchedText = str;
            callGetTrend();
            return;
        }
        if (str.equals(BuildConfig.FLAVOR) || str.equals(this.lastSearchedText)) {
            return;
        }
        this.lastSearchedText = str;
        TypeEnum typeEnum = this.type;
        if (typeEnum == TypeEnum.profile) {
            callSearchProfile(str);
        } else if (typeEnum == TypeEnum.hashTag) {
            callSearchHashTag(str);
        }
    }

    private void callSearchHashTag(String str) {
        Call<MessangerOutput<InstaGetHashTagsOutput>> call = this.lastHashTagSearchCall;
        if (call != null) {
            call.cancel();
        }
        Call<MessangerOutput<InstaGetHashTagsOutput>> call2 = this.lastHashTagTrendCall;
        if (call2 != null) {
            call2.cancel();
        }
        this.mainArrayList.clear();
        this.mainAdapter.notifyDataSetChanged();
        this.notFoundLayout.setVisibility(4);
        this.retryLayout.setVisibility(4);
        this.progressBar.setVisibility(0);
        InstaGetListInput instaGetListInput = new InstaGetListInput();
        instaGetListInput.content = str.replace("#", BuildConfig.FLAVOR);
        instaGetListInput.limit = 50;
        this.lastHashTagSearchCall = ApiRequestMessanger.getInstance(this.currentAccount).instaSearchHashTag(instaGetListInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.InstaSearchFragment.4
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call3, Object obj) {
                ArrayList<InstaHashTagObject> arrayList;
                if (call3.isCanceled()) {
                    return;
                }
                InstaSearchFragment.this.mainArrayList.clear();
                InstaSearchFragment.this.mainAdapter.notifyDataSetChanged();
                InstaSearchFragment.this.progressBar.setVisibility(4);
                InstaGetHashTagsOutput instaGetHashTagsOutput = (InstaGetHashTagsOutput) obj;
                if (instaGetHashTagsOutput != null && (arrayList = instaGetHashTagsOutput.hash_tags) != null && arrayList.size() > 0) {
                    InstaSearchFragment.this.mainArrayList.addAll(instaGetHashTagsOutput.hash_tags);
                    InstaSearchFragment.this.mainAdapter.notifyDataSetChanged();
                }
                if (InstaSearchFragment.this.mainArrayList.size() <= 0) {
                    InstaSearchFragment.this.setNotFoundLayout();
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call3, Throwable th) {
                if (call3.isCanceled()) {
                    return;
                }
                InstaSearchFragment.this.progressBar.setVisibility(4);
                if (InstaSearchFragment.this.mainArrayList.size() <= 0) {
                    InstaSearchFragment.this.showRetryLayout();
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                InstaSearchFragment.this.progressBar.setVisibility(4);
                if (InstaSearchFragment.this.mainArrayList.size() <= 0) {
                    InstaSearchFragment.this.showRetryLayout();
                }
            }
        });
    }

    private void callSearchProfile(String str) {
        Call<MessangerOutput<InstaGetProfilesOutput>> call = this.lastProfileSearchCall;
        if (call != null) {
            call.cancel();
        }
        this.mainArrayList.clear();
        this.mainAdapter.notifyDataSetChanged();
        this.notFoundLayout.setVisibility(4);
        this.retryLayout.setVisibility(4);
        this.progressBar.setVisibility(0);
        InstaGetListInput instaGetListInput = new InstaGetListInput();
        instaGetListInput.username = str.replace("@", BuildConfig.FLAVOR);
        instaGetListInput.limit = 50;
        this.lastProfileSearchCall = ApiRequestMessanger.getInstance(this.currentAccount).instaSearchProfiles(instaGetListInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.InstaSearchFragment.5
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call2, Object obj) {
                ArrayList<InstaProfileObject> arrayList;
                if (call2.isCanceled()) {
                    return;
                }
                InstaSearchFragment.this.mainArrayList.clear();
                InstaSearchFragment.this.mainAdapter.notifyDataSetChanged();
                InstaSearchFragment.this.progressBar.setVisibility(4);
                InstaGetProfilesOutput instaGetProfilesOutput = (InstaGetProfilesOutput) obj;
                if (instaGetProfilesOutput != null && (arrayList = instaGetProfilesOutput.profiles) != null && arrayList.size() > 0) {
                    InstaSearchFragment.this.mainArrayList.addAll(instaGetProfilesOutput.profiles);
                    InstaSearchFragment.this.mainAdapter.notifyDataSetChanged();
                }
                if (InstaSearchFragment.this.mainArrayList.size() <= 0) {
                    InstaSearchFragment.this.setNotFoundLayout();
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call2, Throwable th) {
                if (call2.isCanceled()) {
                    return;
                }
                InstaSearchFragment.this.progressBar.setVisibility(4);
                if (InstaSearchFragment.this.mainArrayList.size() <= 0) {
                    InstaSearchFragment.this.showRetryLayout();
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                InstaSearchFragment.this.progressBar.setVisibility(4);
                if (InstaSearchFragment.this.mainArrayList.size() <= 0) {
                    InstaSearchFragment.this.showRetryLayout();
                }
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        cancelTimerInsta();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        super.retryCall();
        this.lastSearchedText = BuildConfig.FLAVOR;
        cancelTimerInsta();
        startTimerInsta();
    }

    public void startTimerInsta() {
        this.handler.postDelayed(this.instaRunnable, 1000L);
    }

    public void cancelTimerInsta() {
        this.handler.removeCallbacks(this.instaRunnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void setNotFoundLayout() {
        this.notFoundLayout.setVisibility(4);
        View view = this.notFoundLayout;
        if (view != null) {
            view.setVisibility(0);
            this.progressBar.setVisibility(4);
            ImageView imageView = (ImageView) this.notFoundLayout.findViewById(R.id.imageView);
            TextView textView = (TextView) this.notFoundLayout.findViewById(R.id.textView);
            imageView.getLayoutParams().width = AndroidUtilities.dp(140.0f);
            imageView.getLayoutParams().height = AndroidUtilities.dp(140.0f);
            SpannableString spannableString = new SpannableString(BuildConfig.FLAVOR);
            TypeEnum typeEnum = this.type;
            if (typeEnum == TypeEnum.profile) {
                imageView.setImageResource(R.drawable.no_profile);
                spannableString = SpanHelper.makeBoldSpanWithColor(LocaleController.getString(R.string.username_not_found), this.mContext.getResources().getColor(R.color.grey_700));
            } else if (typeEnum == TypeEnum.hashTag) {
                imageView.setImageResource(R.drawable.no_hash_tag);
                spannableString = SpanHelper.makeBoldSpanWithColor(LocaleController.getString(R.string.hashtag_not_found), this.mContext.getResources().getColor(R.color.grey_700));
            }
            textView.setText(spannableString);
        }
        super.setNotFoundLayout();
    }
}
