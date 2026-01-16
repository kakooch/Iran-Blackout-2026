package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import ir.resaneh1.iptv.model.ButtonItem;
import ir.resaneh1.iptv.presenters.ButtonPresenter;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class UIApplyDiscountCode {
    public FrameLayout buttonContainer;
    public ButtonPresenter.MyViewHolder buttonHolder;
    public EditText editText;
    public FrameLayout frameLayoutCloseProgressContainer;
    public ImageView imageViewClose;
    public TextView textViewDescription;
    public View view;

    public View createView(Activity activity) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.ui_apply_discount_code, (ViewGroup) null);
        this.view = viewInflate;
        this.editText = (EditText) viewInflate.findViewById(R.id.editText);
        this.imageViewClose = (ImageView) this.view.findViewById(R.id.imageViewClose);
        this.textViewDescription = (TextView) this.view.findViewById(R.id.textViewDescription);
        this.buttonContainer = (FrameLayout) this.view.findViewById(R.id.buttonContainerView);
        FrameLayout frameLayout = (FrameLayout) this.view.findViewById(R.id.frameLayoutCloseProgressContainer);
        this.frameLayoutCloseProgressContainer = frameLayout;
        UIProgressBarNewStyle.addToFrameWithWhiteBackground(activity, frameLayout, 24);
        ButtonPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = new ButtonPresenter(activity).createViewHolderAndBind(new ButtonItem("اعمال کد تخفیف"));
        this.buttonHolder = myViewHolderCreateViewHolderAndBind;
        myViewHolderCreateViewHolderAndBind.button.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), 0);
        this.buttonHolder.button.setTextSize(1, 12.0f);
        this.buttonContainer.addView(this.buttonHolder.itemView, -1, -2);
        this.buttonHolder.button.getLayoutParams().height = -2;
        this.imageViewClose.setVisibility(4);
        return this.view;
    }

    public void hideCloseProgress() {
        this.frameLayoutCloseProgressContainer.setVisibility(4);
    }

    public void showCloseProgress() {
        this.imageViewClose.setVisibility(4);
        this.frameLayoutCloseProgressContainer.setVisibility(0);
    }

    public void hideCloseView() {
        this.imageViewClose.setVisibility(4);
        this.frameLayoutCloseProgressContainer.setVisibility(4);
    }
}
