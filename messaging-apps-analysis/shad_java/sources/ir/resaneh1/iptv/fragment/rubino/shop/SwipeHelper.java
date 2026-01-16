package ir.resaneh1.iptv.fragment.rubino.shop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public abstract class SwipeHelper extends ItemTouchHelper.SimpleCallback {
    public static boolean isCenter = false;
    private List<UnderlayButton> buttons;
    private Map<Integer, List<UnderlayButton>> buttonsBuffer;
    public Context context;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener gestureListener;
    private View.OnTouchListener onTouchListener;
    private Queue<Integer> recoverQueue;
    private RecyclerListView recyclerView;
    private float swipeThreshold;
    private int swipedPos;

    public interface ButtonSwipeListener {
        void onSwiped();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeEscapeVelocity(float f) {
        return f * 0.1f;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeVelocityThreshold(float f) {
        return f * 5.0f;
    }

    public abstract void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> list);

    public SwipeHelper(Context context, RecyclerListView recyclerListView) {
        super(0, 12);
        this.swipedPos = -1;
        this.swipeThreshold = 0.5f;
        this.gestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.SwipeHelper.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                for (int i = 0; i < SwipeHelper.this.buttons.size() && !((UnderlayButton) SwipeHelper.this.buttons.get(i)).onClick(motionEvent.getX(), motionEvent.getY(), i); i++) {
                }
                return true;
            }
        };
        this.onTouchListener = new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.SwipeHelper.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwipeHelper.this.swipedPos < 0) {
                    return false;
                }
                Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                View view2 = SwipeHelper.this.recyclerView.findViewHolderForAdapterPosition(SwipeHelper.this.swipedPos).itemView;
                Rect rect = new Rect();
                view2.getGlobalVisibleRect(rect);
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 2) {
                    int i = rect.top;
                    int i2 = point.y;
                    if (i >= i2 || rect.bottom <= i2) {
                        SwipeHelper.this.recoverQueue.add(Integer.valueOf(SwipeHelper.this.swipedPos));
                        SwipeHelper.this.swipedPos = -1;
                    } else {
                        SwipeHelper.this.gestureDetector.onTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        };
        this.recyclerView = recyclerListView;
        this.buttons = new ArrayList();
        this.gestureDetector = new GestureDetector(context, this.gestureListener);
        this.recyclerView.setOnTouchListener(this.onTouchListener);
        this.context = context;
        this.buttonsBuffer = new HashMap();
        this.recoverQueue = new LinkedList<Integer>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.SwipeHelper.3
            @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
            public boolean add(Integer num) {
                if (contains(num)) {
                    return false;
                }
                return super.add((AnonymousClass3) num);
            }
        };
        attachSwipe();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        Log.i("SEPI ---> ", "onMove: ");
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        int adapterPosition = viewHolder.getAdapterPosition();
        int i2 = this.swipedPos;
        if (i2 != adapterPosition) {
            this.recoverQueue.add(Integer.valueOf(i2));
        }
        this.swipedPos = adapterPosition;
        if (this.buttonsBuffer.containsKey(Integer.valueOf(adapterPosition))) {
            this.buttons = this.buttonsBuffer.get(Integer.valueOf(this.swipedPos));
        } else {
            this.buttons.clear();
        }
        if (i == 4) {
            this.buttons.get(0).swipeListener.onSwiped();
            swipeInMainView(viewHolder);
        } else if (i == 8) {
            swipeInMainView(viewHolder);
            this.buttons.get(1).swipeListener.onSwiped();
        }
        this.buttonsBuffer.clear();
        this.swipeThreshold = this.buttons.size() * 0.5f * 120.0f;
    }

    private void swipeInMainView(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.findViewById(R.id.shop_item_product_edit_inventory_ll).setBackground(this.context.getResources().getDrawable(R.drawable.shop_shape_blue_left));
        ((TextView) viewHolder.itemView.findViewById(R.id.shop_item_product_edit_inventory_text_view)).setTextColor(this.context.getResources().getColor(R.color.shop_blue));
        ((ImageView) viewHolder.itemView.findViewById(R.id.shop_item_product_edit_inventory_image_view)).setImageDrawable(this.context.getResources().getDrawable(R.drawable.shop_ic_edit_2));
        viewHolder.itemView.findViewById(R.id.shop_item_product_edit_price_ll).setBackground(this.context.getResources().getDrawable(R.drawable.shop_shape_blue_right));
        ((TextView) viewHolder.itemView.findViewById(R.id.shop_item_product_edit_price_text_view)).setTextColor(this.context.getResources().getColor(R.color.shop_blue));
        ((ImageView) viewHolder.itemView.findViewById(R.id.shop_item_product_edit_price_image_view)).setImageDrawable(this.context.getResources().getDrawable(R.drawable.shop_ic_dollar_circle));
        viewHolder.itemView.findViewById(R.id.shop_item_product_view_separator_view).setBackgroundColor(this.context.getResources().getColor(R.color.shop_blue));
        viewHolder.itemView.findViewById(R.id.shop_item_product_dont_show_image_view).setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return this.swipeThreshold;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        float size;
        int adapterPosition = viewHolder.getAdapterPosition();
        View view = viewHolder.itemView;
        if (adapterPosition < 0) {
            this.swipedPos = adapterPosition;
            return;
        }
        if (i == 1) {
            List<UnderlayButton> arrayList = new ArrayList<>();
            if (!this.buttonsBuffer.containsKey(Integer.valueOf(adapterPosition))) {
                instantiateUnderlayButton(viewHolder, arrayList);
                this.buttonsBuffer.put(Integer.valueOf(adapterPosition), arrayList);
            } else {
                arrayList = this.buttonsBuffer.get(Integer.valueOf(adapterPosition));
            }
            List<UnderlayButton> list = arrayList;
            if (Math.abs(f) < 400.0f) {
                swipeInMainView(viewHolder);
                isCenter = true;
                size = ((list.size() * f) * 120.0f) / view.getWidth();
            } else {
                isCenter = false;
                float size2 = ((list.size() * f) * 120.0f) / view.getWidth();
                drawButtons(canvas, view, list, adapterPosition, size2, f < 0.0f);
                size = size2;
            }
        } else {
            size = f;
        }
        super.onChildDraw(canvas, recyclerView, viewHolder, size, f2, i, z);
    }

    private void drawButtons(Canvas canvas, View view, List<UnderlayButton> list, int i, float f, boolean z) {
        float f2 = f * (-1.0f);
        for (UnderlayButton underlayButton : list) {
            if (underlayButton.isRight) {
                if (z) {
                    float right = view.getRight();
                    underlayButton.onDraw(canvas, new RectF(right - f2, view.getTop(), right, view.getBottom()), i);
                }
            } else if (!z) {
                float left = view.getLeft();
                underlayButton.onDraw(canvas, new RectF(left, view.getTop(), left - f2, view.getBottom()), i);
            }
        }
    }

    public void attachSwipe() {
        new ItemTouchHelper(this).attachToRecyclerView(this.recyclerView);
    }

    public static class UnderlayButton {
        private RectF clickRegion;
        private int color;
        private Drawable drawable;
        public boolean isRight;
        private Paint p = new Paint();
        private ButtonSwipeListener swipeListener;
        private String text;

        public UnderlayButton(String str, int i, int i2, ButtonSwipeListener buttonSwipeListener, boolean z, Drawable drawable) {
            this.text = str;
            this.color = i2;
            this.drawable = drawable;
            this.swipeListener = buttonSwipeListener;
            this.isRight = z;
        }

        public boolean onClick(float f, float f2, int i) {
            RectF rectF = this.clickRegion;
            if (rectF == null || !rectF.contains(f, f2) || SwipeHelper.isCenter) {
                return false;
            }
            if (i == 0 && this.p.getColor() == Color.parseColor("#FF3C30")) {
                this.swipeListener.onSwiped();
            } else if (i == 1 && this.p.getColor() == Color.parseColor("#0295F7")) {
                this.swipeListener.onSwiped();
            }
            return true;
        }

        public void onDraw(Canvas canvas, RectF rectF, int i) {
            this.p.setColor(-1);
            canvas.drawRect(rectF, this.p);
            this.p.setColor(this.color);
            this.p.setTextSize(24.0f);
            this.p.setAntiAlias(true);
            this.p.setTypeface(AndroidUtilities.getTypeface("fonts/iranyekanwebregular.ttf"));
            Rect rect = new Rect();
            float fHeight = rectF.height();
            float fWidth = rectF.width();
            this.p.setTextAlign(Paint.Align.LEFT);
            Paint paint = this.p;
            String str = this.text;
            paint.getTextBounds(str, 0, str.length(), rect);
            canvas.drawText(this.text, rectF.left + (((fWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left), rectF.top + (((fHeight / 2.0f) + (rect.height() / 2.0f)) - rect.bottom) + 20.0f, this.p);
            this.drawable.setBounds(((int) rectF.left) + ((((int) rectF.width()) / 2) - 20), ((int) rectF.top) + (((((int) rectF.height()) / 2) - 30) - 20), ((int) rectF.right) - ((((int) rectF.width()) / 2) - 20), ((int) rectF.bottom) - (((((int) rectF.height()) / 2) + 30) - 20));
            this.drawable.draw(canvas);
            this.clickRegion = rectF;
        }
    }
}
