package ir.resaneh1.iptv.model;

import android.view.View;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class ButtonItem extends PresenterItem {
    public String buttonText;
    public View.OnClickListener onClickListener;
    public boolean isProgressing = false;
    public ButtonType buttonType = ButtonType.button;

    public enum ButtonType {
        button,
        text
    }

    public ButtonItem(String str) {
        this.buttonText = str;
    }

    public ButtonItem(String str, View.OnClickListener onClickListener) {
        this.buttonText = str;
        this.onClickListener = onClickListener;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.Button;
    }
}
