package ir.resaneh1.iptv.model;

import android.view.View;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class EditTextItem extends PresenterItem {
    public String hint;
    public boolean isDelete;
    public boolean isEditable;
    public boolean isRequestFocus;
    public boolean isShowPass;
    public View.OnClickListener onClickListener;
    public ArrayList<String> suggestions;
    public String text;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.simpleEditText;
    }

    public EditTextItem() {
        this.text = BuildConfig.FLAVOR;
        this.hint = BuildConfig.FLAVOR;
        this.isEditable = true;
        this.isShowPass = false;
        this.isRequestFocus = false;
    }

    public EditTextItem(String str, String str2) {
        this.text = BuildConfig.FLAVOR;
        this.hint = BuildConfig.FLAVOR;
        this.isEditable = true;
        this.isShowPass = false;
        this.isRequestFocus = false;
        this.text = str;
        this.hint = str2;
    }
}
