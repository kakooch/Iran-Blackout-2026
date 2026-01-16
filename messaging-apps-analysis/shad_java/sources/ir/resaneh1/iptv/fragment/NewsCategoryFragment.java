package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.widget.FrameLayout;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UICellNewsCategory;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import ir.resaneh1.iptv.model.GetNewsCategoryListOutput;
import ir.resaneh1.iptv.model.NewsCategoryObject;
import ir.resaneh1.iptv.model.Position;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class NewsCategoryFragment extends PresenterFragment {
    public ArrayList<NewsCategoryObject> items;
    public ArrayList<NewsCategoryObject> serviceItems;
    public boolean isHasBackButton = true;
    int matrixX = 3;
    int matrixY = 100;
    int[][] matrix = (int[][]) Array.newInstance((Class<?>) int.class, 3, 100);
    public int spaceDp = 2;
    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.NewsCategoryFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewsCategoryObject newsCategoryObject = (NewsCategoryObject) view.getTag();
            FirebaseEventSender.sendEvent(NewsCategoryFragment.this.mContext, "news_category_" + newsCategoryObject.title, BuildConfig.FLAVOR);
            if (newsCategoryObject.listType != 0) {
                NewsCategoryFragment.this.presentFragment(new NewsCategoryDetailFragment(newsCategoryObject));
            }
        }
    };

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_framelayout;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        this.toolbarMaker.setToolbarForHomeFragment(this.isHasBackButton);
        callGetList();
    }

    private void callGetList() {
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getNewsCategoryList(new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.NewsCategoryFragment.1
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                NewsCategoryObject newsCategoryObjectConvert;
                GetNewsCategoryListOutput getNewsCategoryListOutput = (GetNewsCategoryListOutput) response.body();
                NewsCategoryFragment.this.progressBar.setVisibility(4);
                NewsCategoryFragment newsCategoryFragment = NewsCategoryFragment.this;
                ArrayList<NewsCategoryObject> arrayList = getNewsCategoryListOutput.result.categoryList;
                newsCategoryFragment.items = arrayList;
                Collections.sort(arrayList, new CategoryComparator(newsCategoryFragment));
                NewsCategoryFragment.this.serviceItems = new ArrayList<>();
                Iterator<NewsCategoryObject> it = NewsCategoryFragment.this.items.iterator();
                while (it.hasNext()) {
                    NewsCategoryObject next = it.next();
                    int i = next.listType;
                    if (i >= 0 && i <= 4 && (newsCategoryObjectConvert = NewsCategoryFragment.this.convert(next)) != null) {
                        NewsCategoryFragment.this.serviceItems.add(newsCategoryObjectConvert);
                    }
                }
                NewsCategoryFragment.this.makeLayout();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                NewsCategoryFragment.this.progressBar.setVisibility(4);
                NewsCategoryFragment.this.showRetryLayout();
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        super.retryCall();
        callGetList();
    }

    void makeLayout() {
        if (this.frameLayout == null || this.serviceItems == null) {
            return;
        }
        for (int i = 0; i < this.matrixX; i++) {
            for (int i2 = 0; i2 < this.matrixY; i2++) {
                this.matrix[i][i2] = 0;
            }
        }
        this.frameLayout.removeAllViews();
        this.frameLayout.setLayoutDirection(0);
        this.frameLayout.setPadding(0, 0, 0, AndroidUtilities.dp(this.spaceDp));
        float screenWidth = DimensionHelper.getScreenWidth((Activity) this.mContext) - AndroidUtilities.dp(this.spaceDp);
        DimensionHelper.getScreenHeight((Activity) this.mContext);
        Iterator<NewsCategoryObject> it = this.serviceItems.iterator();
        while (it.hasNext()) {
            NewsCategoryObject next = it.next();
            View viewCreateView = new UICellNewsCategory().createView((Activity) getContext(), next);
            viewCreateView.setTag(next);
            viewCreateView.setOnClickListener(this.onClickListener);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((next.X2 - next.X1) * screenWidth) / 100.0f), (int) (((next.Y2 - next.Y1) * screenWidth) / 100.0f));
            layoutParams.setMargins(((int) (next.X1 * screenWidth)) / 100, ((int) (next.Y1 * screenWidth)) / 100, 0, 0);
            viewCreateView.setLayoutParams(layoutParams);
            this.frameLayout.addView(viewCreateView);
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        makeLayout();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        makeLayout();
    }

    public class CategoryComparator implements Comparator<NewsCategoryObject> {
        public CategoryComparator(NewsCategoryFragment newsCategoryFragment) {
        }

        @Override // java.util.Comparator
        public int compare(NewsCategoryObject newsCategoryObject, NewsCategoryObject newsCategoryObject2) {
            int i = newsCategoryObject.order;
            int i2 = newsCategoryObject2.order;
            if (i < i2) {
                return -1;
            }
            return i == i2 ? 0 : 1;
        }
    }

    public Position findPosition(int i, int i2) {
        int i3;
        Position position = new Position(-1, -1);
        for (int i4 = 0; i4 < this.matrixY; i4++) {
            for (int i5 = 0; i5 < this.matrixX; i5++) {
                boolean z = true;
                for (int i6 = 0; i6 < i; i6++) {
                    for (int i7 = 0; i7 < i2; i7++) {
                        int i8 = i5 + i6;
                        if (i8 >= this.matrixX || (i3 = i4 + i7) >= this.matrixY || this.matrix[i8][i3] != 0) {
                            z = false;
                        }
                    }
                }
                if (z) {
                    for (int i9 = 0; i9 < i; i9++) {
                        for (int i10 = 0; i10 < i2; i10++) {
                            this.matrix[i5 + i9][i4 + i10] = 1;
                        }
                    }
                    position.i = i5;
                    position.j = i4;
                    return position;
                }
            }
        }
        return position;
    }

    public NewsCategoryObject convert(NewsCategoryObject newsCategoryObject) {
        int i = findPosition(newsCategoryObject.xAxis, newsCategoryObject.yAxis).i;
        if (i < 0) {
            return null;
        }
        float f = i * 33.333332f;
        newsCategoryObject.X1 = f;
        float f2 = r0.j * 33.333332f;
        newsCategoryObject.Y1 = f2;
        newsCategoryObject.X2 = f + (newsCategoryObject.xAxis * 33.333332f);
        newsCategoryObject.Y2 = f2 + (newsCategoryObject.yAxis * 33.333332f);
        return newsCategoryObject;
    }
}
