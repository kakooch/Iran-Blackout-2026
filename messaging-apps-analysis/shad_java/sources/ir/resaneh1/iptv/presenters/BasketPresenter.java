package ir.resaneh1.iptv.presenters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import ir.resaneh1.iptv.UIView.UIThreeTextRow;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.BasketItemObject;
import ir.resaneh1.iptv.model.BasketObject;
import ir.resaneh1.iptv.model.DropBasketInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnDoneListener;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.UserConfig;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class BasketPresenter extends AbstractPresenter<BasketObject, MyViewHolder> {
    private int currentAccount;
    View.OnClickListener deleteBasketClick;
    public boolean hasButton;
    Context mContext;
    public OnDoneListener onDeleteBasket;

    public BasketPresenter(Context context) {
        super(context);
        this.hasButton = true;
        this.currentAccount = UserConfig.selectedAccount;
        this.deleteBasketClick = new AnonymousClass1();
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.basket_row, viewGroup, false));
        myViewHolder.deleteView.setTag(myViewHolder);
        myViewHolder.deleteView.setOnClickListener(this.deleteBasketClick);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, BasketObject basketObject) {
        long j;
        long j2;
        super.onBindViewHolder((BasketPresenter) myViewHolder, (MyViewHolder) basketObject);
        myViewHolder.hideLoading();
        myViewHolder.linearLayout.removeAllViews();
        String str = basketObject.provider_title;
        if (str != null) {
            myViewHolder.textViewTitle.setText(str);
        } else {
            myViewHolder.textViewTitle.setText(BuildConfig.FLAVOR);
        }
        UIThreeTextRow uIThreeTextRow = new UIThreeTextRow();
        if (basketObject.items != null) {
            uIThreeTextRow.createView((Activity) this.mContext, BuildConfig.FLAVOR, "تعداد", "قیمت کل");
            uIThreeTextRow.view.setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_200));
            uIThreeTextRow.textView1.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(28.0f), AndroidUtilities.dp(4.0f));
            uIThreeTextRow.imageView.getLayoutParams().height = 0;
            myViewHolder.linearLayout.addView(uIThreeTextRow.view);
            Iterator<BasketItemObject> it = basketObject.items.iterator();
            j2 = 0;
            while (it.hasNext()) {
                BasketItemObject next = it.next();
                uIThreeTextRow.createView((Activity) this.mContext, next.title, NumberUtils.toPersian(next.count + BuildConfig.FLAVOR), NumberUtils.getPriceString(next.fee_after_discount * next.count));
                GlideHelper.loadRoundedCorner(this.mContext, uIThreeTextRow.imageView, next.image_url);
                uIThreeTextRow.view.setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_50));
                myViewHolder.linearLayout.addView(uIThreeTextRow.view);
                j2 += next.fee_after_discount * next.count;
            }
            j = 0;
        } else {
            j = 0;
            j2 = 0;
        }
        if (j2 > j) {
            TextView textView = myViewHolder.textViewTotalAmount;
            StringBuilder sb = new StringBuilder();
            sb.append("مجموع کل : ");
            sb.append(NumberUtils.toPersian(EditTextCostPresenter.setFormat(j2 + BuildConfig.FLAVOR)));
            sb.append(" تومان");
            textView.setText(sb.toString());
        } else {
            myViewHolder.textViewTotalAmount.setText(BuildConfig.FLAVOR);
        }
        if (this.hasButton) {
            myViewHolder.textViewButton.setVisibility(0);
            myViewHolder.deleteView.setVisibility(0);
            myViewHolder.textViewTotalAmount.setVisibility(0);
        } else {
            myViewHolder.textViewButton.setVisibility(8);
            myViewHolder.deleteView.setVisibility(8);
            myViewHolder.textViewTotalAmount.setVisibility(8);
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<BasketObject> {
        public View deleteView;
        public LinearLayout linearLayout;
        public FrameLayout progressBarContainer;
        public TextView textViewButton;
        public TextView textViewTitle;
        public TextView textViewTotalAmount;

        public MyViewHolder(View view) {
            super(view);
            this.linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
            this.textViewButton = (TextView) view.findViewById(R.id.textViewButton);
            this.textViewTotalAmount = (TextView) view.findViewById(R.id.textViewAmount);
            this.deleteView = view.findViewById(R.id.imageViewClose);
            this.textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
            this.progressBarContainer = (FrameLayout) view.findViewById(R.id.progressBarContainer);
        }

        public void showLoading() {
            if (this.progressBarContainer.getChildCount() == 0) {
                UIProgressBarNewStyle.addToFrame((Activity) ((AbstractPresenter) BasketPresenter.this).context, this.progressBarContainer, 16);
            }
            this.deleteView.setVisibility(4);
            this.progressBarContainer.setVisibility(0);
            this.progressBarContainer.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.BasketPresenter.MyViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
        }

        public void hideLoading() {
            this.progressBarContainer.setVisibility(4);
            this.deleteView.setVisibility(0);
        }
    }

    /* renamed from: ir.resaneh1.iptv.presenters.BasketPresenter$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
            final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(BasketPresenter.this.mContext, "آیا می خواهید این سبد خرید را حذف کنید؟");
            threeButtonDialog.button1.setText("بله");
            threeButtonDialog.button2.setText("انصراف");
            threeButtonDialog.button2.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.BasketPresenter.1.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    threeButtonDialog.dismiss();
                }
            });
            threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.BasketPresenter.1.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    threeButtonDialog.dismiss();
                    myViewHolder.showLoading();
                    ApiRequestMessanger.getInstance(BasketPresenter.this.currentAccount).dropBasket(new DropBasketInput(((BasketObject) myViewHolder.item).basket_id), new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.presenters.BasketPresenter.1.2.1
                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onResponse(Call call, Object obj) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            OnDoneListener onDoneListener = BasketPresenter.this.onDeleteBasket;
                            if (onDoneListener != null) {
                                onDoneListener.onDone(myViewHolder);
                            }
                            myViewHolder.hideLoading();
                        }

                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onFailure(Call call, Throwable th) {
                            myViewHolder.hideLoading();
                        }

                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onError(MessangerOutput messangerOutput) {
                            myViewHolder.hideLoading();
                        }
                    });
                }
            });
        }
    }
}
