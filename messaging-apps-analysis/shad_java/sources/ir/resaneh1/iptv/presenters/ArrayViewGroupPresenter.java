package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.fragment.DynamicPageFragment;
import ir.resaneh1.iptv.model.ViewDataObjectArray;
import ir.resaneh1.iptv.model.ViewGroupObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.ViewGroupCellPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class ArrayViewGroupPresenter extends AbstractPresenter<ViewDataObjectArray, MyViewHolder> {
    int count;
    int hSpacePx;
    int itemWidthPx;
    Context mContext;
    int vSpacePx;
    ViewGroupCellPresenter viewGroupCellPresenter;
    ViewGroupObject viewGroupObject;

    public ArrayViewGroupPresenter(Context context, ViewGroupObject viewGroupObject, int i, int i2) {
        super(context);
        this.hSpacePx = 0;
        this.vSpacePx = 0;
        this.mContext = context;
        this.count = i;
        this.itemWidthPx = i2;
        this.viewGroupObject = viewGroupObject;
        this.viewGroupCellPresenter = new ViewGroupCellPresenter(context, false, viewGroupObject);
        this.hSpacePx = AndroidUtilities.dp(viewGroupObject.h_space * 100.0f);
        this.vSpacePx = AndroidUtilities.dp(viewGroupObject.v_space * 100.0f);
    }

    public ArrayViewGroupPresenter(Context context, DynamicPageFragment dynamicPageFragment, ViewGroupObject viewGroupObject, int i, int i2) {
        super(context);
        this.hSpacePx = 0;
        this.vSpacePx = 0;
        this.mContext = context;
        this.count = i;
        this.itemWidthPx = i2;
        this.viewGroupObject = viewGroupObject;
        ViewGroupCellPresenter viewGroupCellPresenter = new ViewGroupCellPresenter(context, false, viewGroupObject);
        this.viewGroupCellPresenter = viewGroupCellPresenter;
        viewGroupCellPresenter.dynamicPageFragment = dynamicPageFragment;
        this.hSpacePx = AndroidUtilities.dp(viewGroupObject.h_space * 100.0f);
        this.vSpacePx = AndroidUtilities.dp(viewGroupObject.v_space * 100.0f);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onViewRecycled(MyViewHolder myViewHolder) {
        super.onViewRecycled((ArrayViewGroupPresenter) myViewHolder);
        Iterator<ViewGroupCellPresenter.MyViewHolder> it = myViewHolder.viewGroupCellHolders.iterator();
        while (it.hasNext()) {
            this.viewGroupCellPresenter.onViewRecycled(it.next());
        }
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        MyViewHolder myViewHolder = new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.view_group_array, viewGroup, false));
        if (viewGroup instanceof RecyclerView) {
            MainAdapter mainAdapter = (MainAdapter) ((RecyclerView) viewGroup).getAdapter();
            myViewHolder.disposable = new CompositeDisposable();
            myViewHolder.setParentLifeCycleObservable(mainAdapter.getLifecycle());
        }
        myViewHolder.frameLayout.setTag(myViewHolder);
        myViewHolder.viewGroupObject = this.viewGroupObject;
        setViews(myViewHolder);
        setSize(myViewHolder);
        return myViewHolder;
    }

    private void setViews(MyViewHolder myViewHolder) {
        myViewHolder.getLifecycle().onNext(PresenterFragment.LifeCycleState.destroy);
        myViewHolder.viewGroupCellHolders.clear();
        myViewHolder.frameLayout.removeAllViews();
        myViewHolder.getLifecycle().onNext(PresenterFragment.LifeCycleState.resume);
        for (int i = 0; i < this.count; i++) {
            ViewGroupCellPresenter.MyViewHolder myViewHolderOnCreateViewHolder = this.viewGroupCellPresenter.onCreateViewHolder((ViewGroup) myViewHolder.frameLayout);
            myViewHolderOnCreateViewHolder.setParentLifeCycleObservable(myViewHolder.getLifecycle());
            myViewHolder.viewGroupCellHolders.add(myViewHolderOnCreateViewHolder);
            myViewHolder.frameLayout.addView(myViewHolderOnCreateViewHolder.itemView);
        }
        myViewHolder.frameLayout.setPadding(this.hSpacePx, this.vSpacePx, 0, 0);
    }

    public void setSize(MyViewHolder myViewHolder) {
        this.viewGroupCellPresenter.widthPx = this.itemWidthPx;
        int hWRatio = (int) (this.viewGroupObject.size.getHWRatio() * this.itemWidthPx);
        this.viewGroupCellPresenter.heightPx = hWRatio;
        myViewHolder.frameLayout.getLayoutParams().height = hWRatio + this.vSpacePx;
        for (int i = 0; i < myViewHolder.viewGroupCellHolders.size(); i++) {
            int i2 = this.itemWidthPx;
            int i3 = this.hSpacePx;
            int i4 = ((i2 + i3) * i) + i3;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) myViewHolder.viewGroupCellHolders.get(i).itemView.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMargins(0, 0, i4, 0);
            } else {
                layoutParams.setMargins(i4, 0, 0, 0);
            }
        }
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, ViewDataObjectArray viewDataObjectArray) {
        super.onBindViewHolder((ArrayViewGroupPresenter) myViewHolder, (MyViewHolder) viewDataObjectArray);
        myViewHolder.getLifecycle().onNext(PresenterFragment.LifeCycleState.resume);
        if (myViewHolder.frameLayout.getChildCount() != this.count) {
            setViews(myViewHolder);
            setSize(myViewHolder);
        } else if (this.viewGroupCellPresenter.widthPx != this.itemWidthPx) {
            setSize(myViewHolder);
        }
        for (int i = 0; i < myViewHolder.viewGroupCellHolders.size(); i++) {
            ViewGroupCellPresenter.MyViewHolder myViewHolder2 = myViewHolder.viewGroupCellHolders.get(i);
            if (i < viewDataObjectArray.arrayList.size()) {
                this.viewGroupCellPresenter.onBindViewHolder(myViewHolder2, viewDataObjectArray.arrayList.get(i));
                myViewHolder2.itemView.setVisibility(0);
            } else {
                myViewHolder2.itemView.setVisibility(4);
            }
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<ViewDataObjectArray> {
        private Disposable disposable;
        public FrameLayout frameLayout;
        private BehaviorSubject<PresenterFragment.LifeCycleState> lifecycleSubject;
        private BehaviorSubject<PresenterFragment.LifeCycleState> parentLifecycle;
        public ArrayList<ViewGroupCellPresenter.MyViewHolder> viewGroupCellHolders;
        public ViewGroupObject viewGroupObject;

        public MyViewHolder(ArrayViewGroupPresenter arrayViewGroupPresenter, View view) {
            super(view);
            this.viewGroupCellHolders = new ArrayList<>();
            this.frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }

        public BehaviorSubject<PresenterFragment.LifeCycleState> getLifecycle() {
            if (this.lifecycleSubject == null) {
                this.lifecycleSubject = BehaviorSubject.create();
            }
            return this.lifecycleSubject;
        }

        public void setParentLifeCycleObservable(BehaviorSubject<PresenterFragment.LifeCycleState> behaviorSubject) {
            this.parentLifecycle = behaviorSubject;
            this.disposable = (Disposable) behaviorSubject.subscribeWith(new DisposableObserver<PresenterFragment.LifeCycleState>() { // from class: ir.resaneh1.iptv.presenters.ArrayViewGroupPresenter.MyViewHolder.1
                @Override // io.reactivex.Observer
                public void onNext(PresenterFragment.LifeCycleState lifeCycleState) {
                    MyViewHolder.this.getLifecycle().onNext(lifeCycleState);
                    if (lifeCycleState == PresenterFragment.LifeCycleState.destroy) {
                        MyViewHolder.this.disposable.dispose();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    MyViewHolder.this.getLifecycle().onError(th);
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    MyViewHolder.this.getLifecycle().onComplete();
                }
            });
        }
    }
}
