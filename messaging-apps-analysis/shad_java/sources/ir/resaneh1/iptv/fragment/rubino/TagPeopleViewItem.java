package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.appp.rghapp.rubinoPostSlider.PostTagObject;
import ir.appp.rghapp.rubinoPostSlider.RGHPostTagView;
import ir.resaneh1.iptv.helper.TouchHelper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.rbmain.ui.Components.Point;

/* loaded from: classes3.dex */
public class TagPeopleViewItem extends FrameLayout {
    private ActionOnTagItemView actionListener;
    private RGHPostTagView currentMovingView;
    private final ImageView imageView;
    private RGHMediaHelper$PhotoEntry photoEntry;
    private int position;
    private Set<RGHPostTagView> tagViews;

    public interface ActionOnTagItemView {
        void onClickOnView(Point point, int i);

        void onRemoveSearchMode();

        void onScroll(int i);
    }

    public TagPeopleViewItem(Context context) {
        super(context);
        this.tagViews = new HashSet();
        if (Build.VERSION.SDK_INT >= 17) {
            setLayoutDirection(0);
        }
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        setOnTouchListener(new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.rubino.TagPeopleViewItem.1
            private boolean isActionOnMentionView;
            private float movingX;
            private float movingY;
            private float startX;
            private float startY;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                TagPeopleViewItem tagPeopleViewItem = TagPeopleViewItem.this;
                if (tagPeopleViewItem.isViewContains(tagPeopleViewItem.currentMovingView, motionEvent.getRawX(), motionEvent.getRawY()) && !TagPeopleViewItem.this.currentMovingView.isTouchable()) {
                    return true;
                }
                if (action == 0) {
                    this.startX = motionEvent.getX();
                    this.startY = motionEvent.getY();
                    this.movingX = motionEvent.getX();
                    this.movingY = motionEvent.getY();
                    TagPeopleViewItem tagPeopleViewItem2 = TagPeopleViewItem.this;
                    if (!tagPeopleViewItem2.isViewContains(tagPeopleViewItem2.currentMovingView, motionEvent.getRawX(), motionEvent.getRawY())) {
                        if (TagPeopleViewItem.this.currentMovingView != null && TagPeopleViewItem.this.currentMovingView.getPostTagObject() != null) {
                            TagPeopleViewItem.this.currentMovingView.toggleCloseMode(false);
                        }
                    } else {
                        this.isActionOnMentionView = true;
                        TagPeopleViewItem.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                if (action == 1) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    Point point = new Point(this.startX, this.startY);
                    point.parentHeight = TagPeopleViewItem.this.getHeight();
                    point.parentWidth = TagPeopleViewItem.this.getWidth();
                    boolean zIsClick = TouchHelper.isClick(point, new Point(x, y));
                    if (zIsClick && TagPeopleViewItem.this.emptyTag() != null) {
                        TagPeopleViewItem.this.removeEmptyMentionedView();
                        return true;
                    }
                    if (zIsClick) {
                        if (this.isActionOnMentionView) {
                            TagPeopleViewItem.this.currentMovingView.toggleCloseMode(!TagPeopleViewItem.this.currentMovingView.isCloseIconVisible());
                            this.isActionOnMentionView = false;
                        } else {
                            TagPeopleViewItem.this.actionListener.onClickOnView(point, TagPeopleViewItem.this.position);
                        }
                        TagPeopleViewItem.this.getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        saveMentionViewNewPositionIfNeeded(x - this.startX, y - this.startY);
                    }
                } else if (action == 2 && this.isActionOnMentionView) {
                    updateMentionViewPosition(motionEvent);
                }
                return false;
            }

            private void saveMentionViewNewPositionIfNeeded(float f, float f2) {
                if (this.isActionOnMentionView) {
                    this.isActionOnMentionView = false;
                    Point point = TagPeopleViewItem.this.photoEntry.tempTaggedProfiles.get(TagPeopleViewItem.this.currentMovingView.getPostTagObject());
                    if (point != null) {
                        Point point2 = new Point();
                        point2.x = point.x + f;
                        point2.y = point.y + f2;
                        point2.parentWidth = TagPeopleViewItem.this.getWidth();
                        point2.parentHeight = TagPeopleViewItem.this.getHeight();
                        TagPeopleViewItem.this.photoEntry.tempTaggedProfiles.put(TagPeopleViewItem.this.currentMovingView.getPostTagObject(), point2);
                        TagPeopleViewItem.this.currentMovingView.setTrianglePointRelatedToParent(point2);
                        TagPeopleViewItem.this.requestLayout();
                    }
                }
            }

            private void updateMentionViewPosition(MotionEvent motionEvent) {
                TagPeopleViewItem.this.currentMovingView.toggleCloseMode(false);
                Point trianglePointRelatedToParent = TagPeopleViewItem.this.currentMovingView.getTrianglePointRelatedToParent();
                Point point = new Point();
                point.x = trianglePointRelatedToParent.x + (motionEvent.getX() - this.movingX);
                point.y = trianglePointRelatedToParent.y + (motionEvent.getY() - this.movingY);
                TagPeopleViewItem.this.currentMovingView.setTrianglePointRelatedToParent(point);
                this.movingX = motionEvent.getX();
                this.movingY = motionEvent.getY();
                TagPeopleViewItem.this.requestLayout();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View emptyTag() {
        for (RGHPostTagView rGHPostTagView : this.tagViews) {
            if (rGHPostTagView.getPostTagObject() == null) {
                return rGHPostTagView;
            }
        }
        return null;
    }

    private void changeAbilityOfAllAnotherChildren(boolean z) {
        for (int i = 1; i <= this.tagViews.size(); i++) {
            RGHPostTagView rGHPostTagView = (RGHPostTagView) getChildAt(i);
            if (rGHPostTagView.getPostTagObject() != null) {
                rGHPostTagView.setTouchable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isViewContains(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return f >= ((float) i) && f <= ((float) (i + view.getWidth())) && f2 >= ((float) i2) && f2 <= ((float) (i2 + view.getHeight()));
    }

    public void removeEmptyMentionedView() {
        View viewEmptyTag = emptyTag();
        if (!this.tagViews.isEmpty() && viewEmptyTag != null) {
            removeView(viewEmptyTag);
            this.tagViews.remove(viewEmptyTag);
            this.photoEntry.tempTaggedProfiles.remove(null);
        }
        this.actionListener.onRemoveSearchMode();
        changeAbilityOfAllAnotherChildren(true);
    }

    public void setActionListener(ActionOnTagItemView actionOnTagItemView) {
        this.actionListener = actionOnTagItemView;
    }

    public void addTagView(Point point, PostTagObject postTagObject) {
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.photoEntry;
        if (rGHMediaHelper$PhotoEntry == null || rGHMediaHelper$PhotoEntry.isVideo) {
            return;
        }
        RGHPostTagView rGHPostTagView = new RGHPostTagView(getContext(), postTagObject, 0);
        rGHPostTagView.setTrianglePointRelatedToParent(point);
        rGHPostTagView.setClickListener(new RGHPostTagView.ClickOnMentionView() { // from class: ir.resaneh1.iptv.fragment.rubino.TagPeopleViewItem.2
            @Override // ir.appp.rghapp.rubinoPostSlider.RGHPostTagView.ClickOnMentionView
            public void onTouch(View view) {
                RGHPostTagView rGHPostTagView2 = (RGHPostTagView) view;
                if (!rGHPostTagView2.isTouchable()) {
                    TagPeopleViewItem.this.removeEmptyMentionedView();
                }
                TagPeopleViewItem.this.currentMovingView = rGHPostTagView2;
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.RGHPostTagView.ClickOnMentionView
            public void onCancel(View view) {
                TagPeopleViewItem.this.removeView(view);
                TagPeopleViewItem.this.tagViews.remove(view);
                TagPeopleViewItem.this.photoEntry.tempTaggedProfiles.remove(((RGHPostTagView) view).getPostTagObject());
            }
        });
        addView(rGHPostTagView);
        this.tagViews.add(rGHPostTagView);
    }

    public void setData(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry, int i) {
        this.photoEntry = rGHMediaHelper$PhotoEntry;
        this.position = i;
        this.imageView.setImageBitmap(rGHMediaHelper$PhotoEntry.bitmap);
        if (!this.tagViews.isEmpty()) {
            removeViewsInLayout(1, this.tagViews.size());
            this.tagViews = new HashSet();
        }
        checkAndAddTaggedProfiles(rGHMediaHelper$PhotoEntry);
    }

    private void checkAndAddTaggedProfiles(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry) {
        HashMap<PostTagObject, Point> map = rGHMediaHelper$PhotoEntry.tempTaggedProfiles;
        if (map != null) {
            boolean z = false;
            for (Map.Entry<PostTagObject, Point> entry : map.entrySet()) {
                addTagView(entry.getValue(), entry.getKey());
                if (entry.getKey() == null) {
                    z = true;
                }
            }
            if (z) {
                changeAbilityOfAllAnotherChildren(false);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        for (RGHPostTagView rGHPostTagView : this.tagViews) {
            Point trianglePointRelatedToParent = rGHPostTagView.getTrianglePointRelatedToParent();
            float estimatedWidth = rGHPostTagView.getEstimatedWidth();
            int measuredHeight2 = rGHPostTagView.getMeasuredHeight();
            float f = trianglePointRelatedToParent.x;
            float f2 = estimatedWidth / 2.0f;
            if (f < f2) {
                rGHPostTagView.setX(-rGHPostTagView.getHorizontalMargin());
                rGHPostTagView.setTriangleHeadXAdjustment(f2 - trianglePointRelatedToParent.x);
            } else {
                float f3 = measuredWidth;
                float f4 = f3 - f2;
                if (f > f4) {
                    rGHPostTagView.setX((f3 - estimatedWidth) - rGHPostTagView.getHorizontalMargin());
                    rGHPostTagView.setTriangleHeadXAdjustment(f4 - trianglePointRelatedToParent.x);
                } else {
                    rGHPostTagView.setX((f - f2) - rGHPostTagView.getHorizontalMargin());
                }
            }
            float f5 = trianglePointRelatedToParent.y;
            if (f5 >= 0.0f) {
                if (f5 > measuredHeight - measuredHeight2) {
                    rGHPostTagView.setPointingDirection(RGHPostTagView.PointingDirection.DOWN);
                    rGHPostTagView.measure(measuredWidth, measuredHeight);
                    rGHPostTagView.setY(measuredHeight - rGHPostTagView.getMeasuredHeight());
                } else {
                    rGHPostTagView.setPointingDirection(RGHPostTagView.PointingDirection.UP);
                    rGHPostTagView.setY(trianglePointRelatedToParent.y);
                }
            }
            measureChild(rGHPostTagView, measuredWidth, measuredHeight);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
