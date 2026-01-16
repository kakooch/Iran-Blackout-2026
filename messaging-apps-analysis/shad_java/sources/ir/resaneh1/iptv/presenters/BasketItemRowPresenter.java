package ir.resaneh1.iptv.presenters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.BasketItemObject;
import ir.resaneh1.iptv.model.BasketObject;
import ir.resaneh1.iptv.model.DropBasketInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.SetBasketItemCountInput;
import ir.resaneh1.iptv.model.SetBasketItemCountOutput;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import java.util.Iterator;
import org.rbmain.messenger.UserConfig;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class BasketItemRowPresenter extends AbstractPresenter<BasketItemObject, MyViewHolder> {
    public BasketObject basketObject;
    public ChangeBasketListener changeBasketListener;
    final int currentAccount;
    private Context mContext;
    View.OnLongClickListener onLongClickListenerDeleteItem;
    View.OnClickListener onMinesClick;
    View.OnClickListener onPlusClick;

    public interface ChangeBasketListener {
        void changeBasket(BasketObject basketObject);

        void dropBasket();

        void onItemRemoved(BasketItemObject basketItemObject);
    }

    public BasketItemRowPresenter(Context context, BasketObject basketObject) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.onPlusClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.BasketItemRowPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                if (myViewHolder.progressContainerMines.getVisibility() == 0) {
                    return;
                }
                Titem titem = myViewHolder.item;
                if (((BasketItemObject) titem).count >= 20) {
                    myViewHolder.imageViewPlus.setAlpha(0.5f);
                    return;
                }
                if (((BasketItemObject) titem).count < 20) {
                    ((BasketItemObject) titem).count++;
                    myViewHolder.imageViewPlus.setAlpha(1.0f);
                    myViewHolder.imageViewMines.setAlpha(1.0f);
                }
                if (((BasketItemObject) myViewHolder.item).count == 20) {
                    myViewHolder.imageViewPlus.setAlpha(0.5f);
                }
                final BasketItemObject basketItemObject = (BasketItemObject) myViewHolder.item;
                SetBasketItemCountInput setBasketItemCountInput = new SetBasketItemCountInput();
                setBasketItemCountInput.item_id = ((BasketItemObject) myViewHolder.item).item_id;
                BasketObject basketObject2 = BasketItemRowPresenter.this.basketObject;
                if (basketObject2 != null) {
                    setBasketItemCountInput.basket_id = basketObject2.basket_id;
                }
                setBasketItemCountInput.count = ((BasketItemObject) myViewHolder.item).count + BuildConfig.FLAVOR;
                myViewHolder.showLoadingPlus();
                ApiRequestMessanger.getInstance(BasketItemRowPresenter.this.currentAccount).setBasketItemCount(setBasketItemCountInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.presenters.BasketItemRowPresenter.1.1
                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onResponse(Call call, Object obj) {
                        myViewHolder.hideLoadingPlus();
                        SetBasketItemCountOutput setBasketItemCountOutput = (SetBasketItemCountOutput) obj;
                        BasketItemRowPresenter basketItemRowPresenter = BasketItemRowPresenter.this;
                        BasketObject basketObject3 = setBasketItemCountOutput.basket;
                        basketItemRowPresenter.basketObject = basketObject3;
                        ChangeBasketListener changeBasketListener = basketItemRowPresenter.changeBasketListener;
                        if (changeBasketListener != null) {
                            changeBasketListener.changeBasket(basketObject3);
                        }
                        if (!setBasketItemCountOutput.action_done) {
                            basketItemObject.count--;
                        }
                        BasketItemObject basketItemObject2 = basketItemObject;
                        MyViewHolder myViewHolder2 = myViewHolder;
                        if (basketItemObject2 == myViewHolder2.item) {
                            BasketItemRowPresenter.this.onBindViewHolder(myViewHolder2, basketItemObject2);
                        }
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onFailure(Call call, Throwable th) {
                        myViewHolder.hideLoadingPlus();
                        BasketItemObject basketItemObject2 = basketItemObject;
                        basketItemObject2.count--;
                        MyViewHolder myViewHolder2 = myViewHolder;
                        if (basketItemObject2 == myViewHolder2.item) {
                            BasketItemRowPresenter.this.onBindViewHolder(myViewHolder2, basketItemObject2);
                        }
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onError(MessangerOutput messangerOutput) {
                        myViewHolder.hideLoadingPlus();
                        BasketItemObject basketItemObject2 = basketItemObject;
                        basketItemObject2.count--;
                        MyViewHolder myViewHolder2 = myViewHolder;
                        if (basketItemObject2 == myViewHolder2.item) {
                            BasketItemRowPresenter.this.onBindViewHolder(myViewHolder2, basketItemObject2);
                        }
                    }
                });
            }
        };
        this.onLongClickListenerDeleteItem = new View.OnLongClickListener() { // from class: ir.resaneh1.iptv.presenters.BasketItemRowPresenter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                BasketItemRowPresenter.this.showDeleteDialog((MyViewHolder) view.getTag());
                return true;
            }
        };
        this.onMinesClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.BasketItemRowPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                if (myViewHolder.progressContainerPlus.getVisibility() == 0) {
                    return;
                }
                if (((BasketItemObject) myViewHolder.item).count == 1) {
                    BasketItemRowPresenter.this.showDeleteDialog(myViewHolder);
                } else {
                    BasketItemRowPresenter.this.callMines(myViewHolder);
                }
            }
        };
        this.mContext = context;
        this.basketObject = basketObject;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_row, viewGroup, false));
        myViewHolder.imageViewPlus.setTag(myViewHolder);
        myViewHolder.imageViewPlus.setOnClickListener(this.onPlusClick);
        myViewHolder.imageViewMines.setTag(myViewHolder);
        myViewHolder.imageViewMines.setOnClickListener(this.onMinesClick);
        myViewHolder.frameLayoutContainer.setTag(myViewHolder);
        myViewHolder.frameLayoutContainer.setOnLongClickListener(this.onLongClickListenerDeleteItem);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, BasketItemObject basketItemObject) {
        super.onBindViewHolder((BasketItemRowPresenter) myViewHolder, (MyViewHolder) basketItemObject);
        myViewHolder.textViewTitle.setText(basketItemObject.getTitle());
        myViewHolder.textViewDescription.setText(basketItemObject.getDescription());
        myViewHolder.hideLoadingPlus();
        myViewHolder.hideLoadingMines();
        Iterator<BasketItemObject> it = this.basketObject.items.iterator();
        while (it.hasNext()) {
            BasketItemObject next = it.next();
            if (next.item_id == basketItemObject.item_id) {
                basketItemObject.count = next.count;
            }
        }
        if (basketItemObject.count > 0) {
            myViewHolder.buyButtonText.setVisibility(8);
            myViewHolder.afterBuyLayout.setVisibility(0);
            myViewHolder.textViewNumber.setText(NumberUtils.toPersian(basketItemObject.count + BuildConfig.FLAVOR));
            myViewHolder.textViewPrice.setText(basketItemObject.getPriceString());
        } else {
            myViewHolder.afterBuyLayout.setVisibility(8);
        }
        GlideHelper.loadRoundedCorner(this.mContext, myViewHolder.imageView, basketItemObject.image_url, R.drawable.shape_grey_background);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<BasketItemObject> {
        public View afterBuyLayout;
        public TextView buyButtonText;
        private FrameLayout frameLayoutContainer;
        public ImageView imageView;
        public ImageView imageViewMines;
        public ImageView imageViewPlus;
        private FrameLayout progressContainerMines;
        private FrameLayout progressContainerPlus;
        public TextView textViewDescription;
        public TextView textViewNumber;
        TextView textViewPrice;
        public TextView textViewTitle;

        public MyViewHolder(View view) {
            super(view);
            this.textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
            this.textViewDescription = (TextView) view.findViewById(R.id.textViewDescription);
            this.buyButtonText = (TextView) view.findViewById(R.id.buyButtonText);
            this.afterBuyLayout = view.findViewById(R.id.afterBuyLayout);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.textViewNumber = (TextView) view.findViewById(R.id.textViewNumber);
            this.imageViewPlus = (ImageView) view.findViewById(R.id.imageViewPlus);
            this.imageViewMines = (ImageView) view.findViewById(R.id.imageViewMines);
            this.progressContainerPlus = (FrameLayout) view.findViewById(R.id.progressBarContainerPlus);
            this.progressContainerMines = (FrameLayout) view.findViewById(R.id.progressBarContainerMinos);
            this.frameLayoutContainer = (FrameLayout) view.findViewById(R.id.frameLayoutContainer);
            this.textViewPrice = (TextView) view.findViewById(R.id.textViewPrice);
        }

        public void showLoadingPlus() {
            if (this.progressContainerPlus.getChildCount() == 0) {
                UIProgressBarNewStyle.addToFrame((Activity) ((AbstractPresenter) BasketItemRowPresenter.this).context, this.progressContainerPlus, 24);
            }
            this.progressContainerPlus.setVisibility(0);
            this.imageViewPlus.setVisibility(4);
        }

        public void hideLoadingPlus() {
            this.imageViewPlus.setVisibility(0);
            this.progressContainerPlus.setVisibility(4);
        }

        public void showLoadingMines() {
            if (this.progressContainerMines.getChildCount() == 0) {
                UIProgressBarNewStyle.addToFrame((Activity) ((AbstractPresenter) BasketItemRowPresenter.this).context, this.progressContainerMines, 24);
            }
            this.progressContainerMines.setVisibility(0);
            this.imageViewMines.setVisibility(4);
        }

        public void hideLoadingMines() {
            this.imageViewMines.setVisibility(0);
            this.progressContainerMines.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDeleteDialog(final MyViewHolder myViewHolder) {
        final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(this.mContext, "آیا می خواهید این محصول را از سبد خرید حذف کنید؟");
        threeButtonDialog.button1.setText("بله");
        threeButtonDialog.button2.setText("انصراف");
        threeButtonDialog.button2.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.BasketItemRowPresenter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                threeButtonDialog.dismiss();
            }
        });
        threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.BasketItemRowPresenter.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                threeButtonDialog.dismiss();
                if (BasketItemRowPresenter.this.basketObject.items.size() == 1) {
                    BasketItemRowPresenter.this.callDropBasket(myViewHolder);
                } else {
                    BasketItemRowPresenter.this.callMines(myViewHolder);
                }
            }
        });
    }

    public void callDropBasket(final MyViewHolder myViewHolder) {
        ApiRequestMessanger.getInstance(this.currentAccount).dropBasket(new DropBasketInput(this.basketObject.basket_id), new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.presenters.BasketItemRowPresenter.6
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                ChangeBasketListener changeBasketListener = BasketItemRowPresenter.this.changeBasketListener;
                if (changeBasketListener != null) {
                    changeBasketListener.dropBasket();
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                myViewHolder.hideLoadingMines();
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                myViewHolder.hideLoadingMines();
            }
        });
    }

    public void callMines(final MyViewHolder myViewHolder) {
        Titem titem = myViewHolder.item;
        if (((BasketItemObject) titem).count <= 0) {
            myViewHolder.imageViewMines.setAlpha(0.5f);
            return;
        }
        if (((BasketItemObject) titem).count > 0) {
            ((BasketItemObject) titem).count--;
            myViewHolder.imageViewMines.setAlpha(1.0f);
            myViewHolder.imageViewPlus.setAlpha(1.0f);
        }
        if (((BasketItemObject) myViewHolder.item).count == 0) {
            myViewHolder.imageViewMines.setAlpha(0.5f);
        }
        final BasketItemObject basketItemObject = (BasketItemObject) myViewHolder.item;
        SetBasketItemCountInput setBasketItemCountInput = new SetBasketItemCountInput();
        setBasketItemCountInput.item_id = ((BasketItemObject) myViewHolder.item).item_id;
        setBasketItemCountInput.basket_id = this.basketObject.basket_id;
        setBasketItemCountInput.count = ((BasketItemObject) myViewHolder.item).count + BuildConfig.FLAVOR;
        myViewHolder.showLoadingMines();
        ApiRequestMessanger.getInstance(this.currentAccount).setBasketItemCount(setBasketItemCountInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.presenters.BasketItemRowPresenter.7
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                ChangeBasketListener changeBasketListener;
                myViewHolder.hideLoadingMines();
                if (basketItemObject.count == 0 && (changeBasketListener = BasketItemRowPresenter.this.changeBasketListener) != null) {
                    changeBasketListener.onItemRemoved((BasketItemObject) myViewHolder.item);
                }
                SetBasketItemCountOutput setBasketItemCountOutput = (SetBasketItemCountOutput) obj;
                BasketItemRowPresenter basketItemRowPresenter = BasketItemRowPresenter.this;
                BasketObject basketObject = setBasketItemCountOutput.basket;
                basketItemRowPresenter.basketObject = basketObject;
                ChangeBasketListener changeBasketListener2 = basketItemRowPresenter.changeBasketListener;
                if (changeBasketListener2 != null) {
                    changeBasketListener2.changeBasket(basketObject);
                }
                if (!setBasketItemCountOutput.action_done) {
                    basketItemObject.count++;
                }
                BasketItemObject basketItemObject2 = basketItemObject;
                MyViewHolder myViewHolder2 = myViewHolder;
                if (basketItemObject2 == myViewHolder2.item) {
                    BasketItemRowPresenter.this.onBindViewHolder(myViewHolder2, basketItemObject2);
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                myViewHolder.hideLoadingMines();
                BasketItemObject basketItemObject2 = basketItemObject;
                basketItemObject2.count++;
                MyViewHolder myViewHolder2 = myViewHolder;
                if (basketItemObject2 == myViewHolder2.item) {
                    BasketItemRowPresenter.this.onBindViewHolder(myViewHolder2, basketItemObject2);
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                myViewHolder.hideLoadingMines();
                BasketItemObject basketItemObject2 = basketItemObject;
                basketItemObject2.count++;
                MyViewHolder myViewHolder2 = myViewHolder;
                if (basketItemObject2 == myViewHolder2.item) {
                    BasketItemRowPresenter.this.onBindViewHolder(myViewHolder2, basketItemObject2);
                }
            }
        });
    }
}
