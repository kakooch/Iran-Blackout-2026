package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class UIOrderFinalPricesView {
    public View discountAmountContainer;
    public TextView textViewBasketAmount;
    public TextView textViewDiscountAmount;
    public TextView textViewShiping;
    public TextView textViewTotalAmount;
    public View view;

    public View createView(Activity activity) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.order_final_amout_row, (ViewGroup) null);
        this.view = viewInflate;
        this.textViewBasketAmount = (TextView) viewInflate.findViewById(R.id.textViewBasketAmount);
        this.textViewTotalAmount = (TextView) this.view.findViewById(R.id.textViewTotalAmount);
        this.textViewDiscountAmount = (TextView) this.view.findViewById(R.id.textViewDiscountAmount);
        this.textViewShiping = (TextView) this.view.findViewById(R.id.textViewShipingAmount);
        this.discountAmountContainer = this.view.findViewById(R.id.basketAmoutDiscountContainer);
        return this.view;
    }
}
