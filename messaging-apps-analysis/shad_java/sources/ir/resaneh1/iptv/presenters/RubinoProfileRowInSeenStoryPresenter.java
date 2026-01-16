package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import java.util.ArrayList;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.AlertDialog;

/* loaded from: classes3.dex */
public class RubinoProfileRowInSeenStoryPresenter extends AbstractPresenter<InstaProfileObject, ViewHolder> {
    int currentAccount;
    View.OnClickListener onOptionClick;
    View.OnClickListener onSendMessageClicked;
    View.OnClickListener onUserClicked;

    public RubinoProfileRowInSeenStoryPresenter(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.onUserClicked = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.RubinoProfileRowInSeenStoryPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewHolder viewHolder;
                if (view.getTag(R.id.imagetag) != null) {
                    viewHolder = (ViewHolder) view.getTag(R.id.imagetag);
                } else {
                    viewHolder = (ViewHolder) view.getTag();
                }
                if (viewHolder == null || viewHolder.item == 0) {
                    return;
                }
                new MainClickHandler().onRubinoProfileClick(RubinoProfileObject.createFromOldObject((InstaProfileObject) viewHolder.item));
            }
        };
        this.onSendMessageClicked = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.RubinoProfileRowInSeenStoryPresenter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MainClickHandler().onMessengerUsernameClicked(((InstaProfileObject) ((ViewHolder) view.getTag()).item).username);
            }
        };
        this.onOptionClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.RubinoProfileRowInSeenStoryPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ApplicationLoader.applicationActivity != null) {
                    final ViewHolder viewHolder = (ViewHolder) view.getTag();
                    ArrayList arrayList = new ArrayList();
                    final ArrayList arrayList2 = new ArrayList();
                    arrayList.add(LocaleController.getString(R.string.rubinoProfile));
                    arrayList2.add(2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(((AbstractPresenter) RubinoProfileRowInSeenStoryPresenter.this).context);
                    builder.setItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), new DialogInterface.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.RubinoProfileRowInSeenStoryPresenter.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (((Integer) arrayList2.get(i)).intValue() == 1) {
                                new MainClickHandler().onInstaBlockClick((InstaProfileObject) viewHolder.item, ((AbstractPresenter) RubinoProfileRowInSeenStoryPresenter.this).context, null);
                            } else if (((Integer) arrayList2.get(i)).intValue() == 2) {
                                new MainClickHandler().onRubinoProfileClick((InstaProfileObject) viewHolder.item);
                            }
                        }
                    });
                    AlertDialog alertDialogCreate = builder.create();
                    alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: ir.resaneh1.iptv.presenters.RubinoProfileRowInSeenStoryPresenter.3.2
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                        }
                    });
                    ApplicationLoader.applicationActivity.getLastFragment().showDialog(alertDialogCreate);
                }
            }
        };
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.rubino_profile_row_in_seen_story, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewHolder.imageViewOption.setTag(viewHolder);
        viewHolder.imageViewOption.setOnClickListener(this.onOptionClick);
        viewHolder.imageViewOption.setVisibility(8);
        viewHolder.imageViewSendMessage.setTag(viewHolder);
        viewHolder.imageViewSendMessage.setOnClickListener(this.onSendMessageClicked);
        viewHolder.usernameTextView.setTag(viewHolder);
        viewHolder.usernameTextView.setOnClickListener(this.onUserClicked);
        viewHolder.imageView.setTag(R.id.imagetag, viewHolder);
        viewHolder.imageView.setOnClickListener(this.onUserClicked);
        viewHolder.container.setTag(R.id.imagetag, viewHolder);
        viewHolder.container.setOnClickListener(this.onUserClicked);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, InstaProfileObject instaProfileObject) {
        super.onBindViewHolder((RubinoProfileRowInSeenStoryPresenter) viewHolder, (ViewHolder) instaProfileObject);
        InstaProfileObject instaCurrentProfileObject = AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject();
        Titem titem = viewHolder.item;
        ((InstaProfileObject) titem).isMyProfile = instaCurrentProfileObject != null && instaCurrentProfileObject.id.equals(((InstaProfileObject) titem).id);
        if (instaProfileObject.is_verified || instaProfileObject.sale_permission) {
            viewHolder.imageViewVerified.setVisibility(0);
            if (instaProfileObject.sale_permission) {
                viewHolder.imageViewVerified.setImageResource(R.drawable.ic_sale_permission);
            } else {
                viewHolder.imageViewVerified.setImageResource(R.drawable.ic_insta_verified);
            }
        } else {
            viewHolder.imageViewVerified.setVisibility(8);
        }
        viewHolder.usernameTextView.setText(instaProfileObject.getUsername());
        Titem titem2 = viewHolder.item;
        if (((InstaProfileObject) titem2).name != null && !((InstaProfileObject) titem2).name.isEmpty()) {
            viewHolder.nameTextView.setVisibility(0);
            viewHolder.nameTextView.setText(((InstaProfileObject) viewHolder.item).getName());
        } else {
            viewHolder.nameTextView.setVisibility(8);
        }
        GlideHelper.loadCircle(this.context, viewHolder.imageView, instaProfileObject.full_thumbnail_url, R.drawable.placeholder_avatar_man);
        if (((InstaProfileObject) viewHolder.item).presenterIsSelected) {
            viewHolder.itemView.setBackgroundColor(this.context.getResources().getColor(R.color.selectedRowBackground));
        } else {
            viewHolder.itemView.setBackgroundColor(0);
        }
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<InstaProfileObject> {
        View container;
        ImageView imageView;
        ImageView imageViewOption;
        ImageView imageViewSendMessage;
        ImageView imageViewVerified;
        TextView nameTextView;
        TextView usernameTextView;

        public ViewHolder(View view) {
            super(view);
            this.usernameTextView = (TextView) view.findViewById(R.id.textViewUserName);
            this.nameTextView = (TextView) view.findViewById(R.id.textViewName);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.imageViewOption = (ImageView) view.findViewById(R.id.imageViewOption);
            this.imageViewSendMessage = (ImageView) view.findViewById(R.id.imageViewSendMessage);
            this.container = view.findViewById(R.id.container);
            this.imageViewVerified = (ImageView) view.findViewById(R.id.imageViewVerified);
        }
    }
}
