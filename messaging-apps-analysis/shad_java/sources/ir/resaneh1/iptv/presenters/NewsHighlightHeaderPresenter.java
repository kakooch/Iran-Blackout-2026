package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.NewsDetailFragment;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.model.GetCategoryHighlightListOutput;
import ir.resaneh1.iptv.model.NewsHighlightObject;
import ir.resaneh1.iptv.model.ViewPagerListItem;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import me.relex.circleindicator.CircleIndicator;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class NewsHighlightHeaderPresenter extends AbstractPresenter<GetCategoryHighlightListOutput.HighlightList, ViewHolder> {
    Context context;
    public OnPresenterItemClickListener onPresenterItemClickListener;
    public PresenterSelector presenterSelector;

    public NewsHighlightHeaderPresenter(final Context context) {
        super(context);
        this.context = context;
        this.presenterSelector = new PresenterSelector(this) { // from class: ir.resaneh1.iptv.presenters.NewsHighlightHeaderPresenter.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.newsHighlight) {
                    return new NewsHighlightPresenter(context);
                }
                return MainPresenterSelector.getInstance(context).getPresenter(presenterItemType);
            }
        };
        this.onPresenterItemClickListener = new OnPresenterItemClickListener(this) { // from class: ir.resaneh1.iptv.presenters.NewsHighlightHeaderPresenter.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                if (abstractViewHolder.item.getPresenterType() == PresenterItemType.newsHighlight) {
                    ((LaunchActivity) context).lambda$runLinkRequest$40(new NewsDetailFragment((NewsHighlightObject) abstractViewHolder.item));
                }
            }
        };
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.news_highlight_header, viewGroup, false));
        viewHolder.viewPager.getLayoutParams().height = DimensionHelper.getHeaderHeight(this.context);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, GetCategoryHighlightListOutput.HighlightList highlightList) throws Resources.NotFoundException {
        super.onBindViewHolder((NewsHighlightHeaderPresenter) viewHolder, (ViewHolder) highlightList);
        ViewPagerListItem viewPagerListItem = new ViewPagerListItem(highlightList.highlights, this.presenterSelector, this.onPresenterItemClickListener);
        setupViewPager(viewHolder.viewPager, viewPagerListItem);
        viewHolder.indicator.setViewPager(viewHolder.viewPager);
        viewHolder.viewPager.setCurrentItem(0);
        if (Build.VERSION.SDK_INT >= 17) {
            viewHolder.indicator.setLayoutDirection(0);
        }
        if (viewPagerListItem.list.size() <= 1) {
            viewHolder.indicator.setVisibility(4);
        } else {
            viewHolder.indicator.setVisibility(0);
        }
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<GetCategoryHighlightListOutput.HighlightList> {
        private CircleIndicator indicator;
        public ViewPager viewPager;

        public ViewHolder(View view) {
            super(view);
            this.viewPager = (ViewPager) view.findViewById(R.id.viewpager);
            this.indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        }
    }

    private void setupViewPager(ViewPager viewPager, ViewPagerListItem viewPagerListItem) throws Resources.NotFoundException {
        viewPager.setAdapter(new MyPagerAdapter(this, this.context, viewPagerListItem));
    }

    class MyPagerAdapter extends PagerAdapter {
        private ViewPagerListItem item;
        public View.OnClickListener onClickListener;

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return BuildConfig.FLAVOR;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public MyPagerAdapter(NewsHighlightHeaderPresenter newsHighlightHeaderPresenter, Context context, ViewPagerListItem viewPagerListItem) {
            this.item = viewPagerListItem;
            this.onClickListener = new View.OnClickListener(this, newsHighlightHeaderPresenter, viewPagerListItem) { // from class: ir.resaneh1.iptv.presenters.NewsHighlightHeaderPresenter.MyPagerAdapter.1
                final /* synthetic */ ViewPagerListItem val$item;

                {
                    this.val$item = viewPagerListItem;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnPresenterItemClickListener onPresenterItemClickListener = this.val$item.onPresenterItemClickListener;
                    if (onPresenterItemClickListener != null) {
                        onPresenterItemClickListener.onClick((AbstractPresenter.AbstractViewHolder) view.getTag());
                    }
                }
            };
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            ViewPagerListItem viewPagerListItem = this.item;
            AbstractPresenter.AbstractViewHolder abstractViewHolderOnCreateViewHolder = viewPagerListItem.presenterSelector.getPresenter(viewPagerListItem.list.get(i).getPresenterType()).onCreateViewHolder(viewGroup);
            View view = abstractViewHolderOnCreateViewHolder.itemView;
            view.setOnClickListener(this.onClickListener);
            ViewPagerListItem viewPagerListItem2 = this.item;
            viewPagerListItem2.presenterSelector.getPresenter(viewPagerListItem2.list.get(i).getPresenterType()).onBindViewHolder(abstractViewHolderOnCreateViewHolder, this.item.list.get(i));
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.item.list.size();
        }
    }
}
