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
import ir.resaneh1.iptv.UIView.UIThreeTextRow;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.BasketItemObject;
import ir.resaneh1.iptv.model.BasketObject;
import ir.resaneh1.iptv.model.ColorObject;
import ir.resaneh1.iptv.model.OrderObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenters.AddressBriefPresenter;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class OrderPresenter extends AbstractPresenter<OrderObject, MyViewHolder> {
    AddressBriefPresenter addressBriefPresenter;
    Context mContext;

    public OrderPresenter(Context context) {
        super(context);
        this.mContext = context;
        this.addressBriefPresenter = new AddressBriefPresenter(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        MyViewHolder myViewHolder = new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.order_row, viewGroup, false));
        AddressBriefPresenter.MyViewHolder myViewHolderOnCreateViewHolder = this.addressBriefPresenter.onCreateViewHolder(viewGroup);
        myViewHolder.addressViewHolder = myViewHolderOnCreateViewHolder;
        myViewHolderOnCreateViewHolder.cardView.setMaxCardElevation(0.0f);
        myViewHolder.addressViewHolder.cardView.setCardElevation(0.0f);
        ((ViewGroup) myViewHolder.itemView.findViewById(R.id.briefAddressContainer)).addView(myViewHolder.addressViewHolder.itemView);
        ((FrameLayout.LayoutParams) myViewHolder.addressViewHolder.itemView.getLayoutParams()).setMargins(0, 0, 0, 0);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, OrderObject orderObject) {
        long j;
        String str;
        super.onBindViewHolder((OrderPresenter) myViewHolder, (MyViewHolder) orderObject);
        myViewHolder.linearLayout.removeAllViews();
        BasketObject basketObject = orderObject.basket;
        if (basketObject != null && (str = basketObject.provider_title) != null) {
            myViewHolder.textViewTitle.setText(str);
        } else {
            myViewHolder.textViewTitle.setText(BuildConfig.FLAVOR);
        }
        UIThreeTextRow uIThreeTextRow = new UIThreeTextRow();
        BasketObject basketObject2 = orderObject.basket;
        if (basketObject2 == null || basketObject2.items == null) {
            j = 0;
        } else {
            uIThreeTextRow.createView((Activity) this.mContext, BuildConfig.FLAVOR, "تعداد", "قیمت کل");
            uIThreeTextRow.view.setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_200));
            uIThreeTextRow.textView1.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(28.0f), AndroidUtilities.dp(4.0f));
            uIThreeTextRow.imageView.getLayoutParams().height = 0;
            myViewHolder.linearLayout.addView(uIThreeTextRow.view);
            Iterator<BasketItemObject> it = orderObject.basket.items.iterator();
            j = 0;
            while (it.hasNext()) {
                BasketItemObject next = it.next();
                uIThreeTextRow.createView((Activity) this.mContext, next.title, NumberUtils.toPersian(next.count + BuildConfig.FLAVOR), NumberUtils.getPriceString(next.fee_after_discount * next.count));
                GlideHelper.loadRoundedCorner(this.mContext, uIThreeTextRow.imageView, next.image_url);
                uIThreeTextRow.view.setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_50));
                myViewHolder.linearLayout.addView(uIThreeTextRow.view);
                j += next.fee_after_discount * next.count;
            }
        }
        this.addressBriefPresenter.onBindViewHolder(myViewHolder.addressViewHolder, orderObject.delivery_info);
        this.addressBriefPresenter.bindDeliveryTime(myViewHolder.addressViewHolder, orderObject.delivery_time);
        myViewHolder.textViewBasketAmount.setText(NumberUtils.getPriceStringWithToman(j, false));
        if (orderObject.discount_amount != 0) {
            myViewHolder.textViewDiscount.setVisibility(0);
            myViewHolder.textViewDiscount.setText(NumberUtils.getPriceStringWithToman(orderObject.discount_amount, false));
        } else {
            myViewHolder.textViewDiscount.setVisibility(8);
        }
        myViewHolder.textViewTotalAmount.setText(NumberUtils.getPriceStringWithToman(orderObject.final_amount, false));
        myViewHolder.textViewShiping.setText(NumberUtils.getPriceStringWithToman(orderObject.delivery_type.amount, false));
        long j2 = orderObject.discount_amount;
        if (j2 > 0) {
            myViewHolder.textViewDiscount.setText(NumberUtils.getPriceStringWithToman(j2, false));
            myViewHolder.discountContainer.setVisibility(0);
        } else {
            myViewHolder.discountContainer.setVisibility(8);
        }
        myViewHolder.textViewTotalAmount.setVisibility(0);
        String str2 = orderObject.status_message;
        if (str2 != null || str2.isEmpty()) {
            myViewHolder.textViewStatus.setVisibility(0);
            myViewHolder.textViewStatus.setText(orderObject.status_message + BuildConfig.FLAVOR);
            ColorObject colorObject = orderObject.status_color;
            if (colorObject != null) {
                myViewHolder.textViewStatus.setTextColor(colorObject.getColor());
            } else {
                myViewHolder.textViewStatus.setTextColor(this.mContext.getResources().getColor(R.color.grey_900));
            }
        } else {
            myViewHolder.textViewStatus.setVisibility(8);
        }
        myViewHolder.textViewTime.setText(orderObject.getPersianDate());
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<OrderObject> {
        AddressBriefPresenter.MyViewHolder addressViewHolder;
        private final View discountContainer;
        public LinearLayout linearLayout;
        public TextView textViewBasketAmount;
        public TextView textViewDiscount;
        public TextView textViewShiping;
        public TextView textViewStatus;
        public TextView textViewTime;
        public TextView textViewTitle;
        public TextView textViewTotalAmount;

        public MyViewHolder(OrderPresenter orderPresenter, View view) {
            super(view);
            this.linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
            this.textViewStatus = (TextView) view.findViewById(R.id.textViewStatus);
            this.textViewTotalAmount = (TextView) view.findViewById(R.id.textViewTotalAmount);
            this.textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
            this.textViewBasketAmount = (TextView) view.findViewById(R.id.textViewBasketAmount);
            this.textViewDiscount = (TextView) view.findViewById(R.id.textViewDiscountAmount);
            this.textViewTime = (TextView) view.findViewById(R.id.textViewPaymentTime);
            this.textViewShiping = (TextView) view.findViewById(R.id.textViewShipingAmount);
            this.discountContainer = view.findViewById(R.id.basketAmoutDiscountContainer);
        }
    }
}
