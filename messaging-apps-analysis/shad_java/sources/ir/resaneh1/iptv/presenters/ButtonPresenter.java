package ir.resaneh1.iptv.presenters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import ir.resaneh1.iptv.model.ButtonItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class ButtonPresenter extends AbstractPresenter<ButtonItem, MyViewHolder> {
    Context mContext;

    public ButtonPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.item_button, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, ButtonItem buttonItem) {
        super.onBindViewHolder((ButtonPresenter) myViewHolder, (MyViewHolder) buttonItem);
        View.OnClickListener onClickListener = buttonItem.onClickListener;
        if (onClickListener != null) {
            myViewHolder.button.setOnClickListener(onClickListener);
            myViewHolder.button.setTag(myViewHolder);
        }
        if (buttonItem.buttonType == ButtonItem.ButtonType.button) {
            myViewHolder.button.setBackgroundResource(R.drawable.button_primary_background);
            myViewHolder.button.setTextColor(-1);
        } else {
            myViewHolder.button.setBackgroundResource(R.drawable.transparent);
            myViewHolder.button.setTextColor(this.mContext.getResources().getColor(R.color.colorPrimary));
        }
        Button button = myViewHolder.button;
        String str = buttonItem.buttonText;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        button.setText(str);
        myViewHolder.button.setTag(myViewHolder);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<ButtonItem> {
        public Button button;
        FrameLayout progressBarContainer;

        public MyViewHolder(View view) {
            super(view);
            this.button = (Button) view.findViewById(R.id.button);
            this.progressBarContainer = (FrameLayout) view.findViewById(R.id.progressBarContainer);
        }

        public void showLoading() {
            if (this.progressBarContainer.getChildCount() == 0) {
                UIProgressBarNewStyle.addToFrameWhiteWithTransparentBackground((Activity) ((AbstractPresenter) ButtonPresenter.this).context, this.progressBarContainer, 32);
            }
            this.progressBarContainer.setVisibility(0);
            this.button.setTextColor(((AbstractPresenter) ButtonPresenter.this).context.getResources().getColor(R.color.colorPrimary));
            this.progressBarContainer.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.ButtonPresenter.MyViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
        }

        public void hideLoading() {
            this.progressBarContainer.setVisibility(4);
            this.button.setTextColor(((AbstractPresenter) ButtonPresenter.this).context.getResources().getColor(R.color.white));
        }
    }
}
