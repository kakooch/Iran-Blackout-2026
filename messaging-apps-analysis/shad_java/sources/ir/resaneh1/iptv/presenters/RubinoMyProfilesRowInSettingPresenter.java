package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class RubinoMyProfilesRowInSettingPresenter extends AbstractPresenter<InstaProfileObject, ViewHolder> {
    View.OnClickListener onClickListener;
    public View.OnClickListener onItemSelected;

    public RubinoMyProfilesRowInSettingPresenter(Context context) {
        super(context);
        this.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.RubinoMyProfilesRowInSettingPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View.OnClickListener onClickListener = RubinoMyProfilesRowInSettingPresenter.this.onItemSelected;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        };
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.rubino_my_profile_row_in_setting, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        viewHolder.container.setTag(viewHolder);
        viewHolder.container.setOnClickListener(this.onClickListener);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, InstaProfileObject instaProfileObject) {
        super.onBindViewHolder((RubinoMyProfilesRowInSettingPresenter) viewHolder, (ViewHolder) instaProfileObject);
        viewHolder.textView.setText(instaProfileObject.getUsername());
        GlideHelper.loadCircle(this.context, viewHolder.imageViewUser, instaProfileObject.full_thumbnail_url, R.drawable.placeholder_avatar_man);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<InstaProfileObject> {
        View container;
        ImageView imageViewUser;
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
            this.imageViewUser = (ImageView) view.findViewById(R.id.imageViewUser);
            this.container = view.findViewById(R.id.container);
            this.textView.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
        }
    }
}
