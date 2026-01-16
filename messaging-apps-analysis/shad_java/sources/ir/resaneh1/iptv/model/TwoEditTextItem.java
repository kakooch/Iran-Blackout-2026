package ir.resaneh1.iptv.model;

import android.view.View;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class TwoEditTextItem extends PresenterItem {
    public String hint1;
    public String hint2;
    public boolean isDelete;
    public boolean isEditable1 = true;
    public boolean isEditable2 = true;
    public View.OnClickListener onClickListener;
    public String text1;
    public String text2;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.simpleEditText;
    }

    public TwoEditTextItem(String str, String str2, String str3, String str4) {
        this.text1 = BuildConfig.FLAVOR;
        this.hint1 = BuildConfig.FLAVOR;
        this.text2 = BuildConfig.FLAVOR;
        this.hint2 = BuildConfig.FLAVOR;
        this.text1 = str;
        this.hint1 = str2;
        this.text2 = str3;
        this.hint2 = str4;
    }
}
