package com.yarolegovich.discretescrollview;

import android.graphics.Point;
import android.view.View;

/* loaded from: classes3.dex */
public enum DSVOrientation {
    HORIZONTAL { // from class: com.yarolegovich.discretescrollview.DSVOrientation.1
        @Override // com.yarolegovich.discretescrollview.DSVOrientation
        Helper createHelper() {
            return new HorizontalHelper();
        }
    },
    VERTICAL { // from class: com.yarolegovich.discretescrollview.DSVOrientation.2
        @Override // com.yarolegovich.discretescrollview.DSVOrientation
        Helper createHelper() {
            return new VerticalHelper();
        }
    };

    interface Helper {
        boolean canScrollHorizontally();

        boolean canScrollVertically();

        float getDistanceFromCenter(Point point, int i, int i2);

        int getDistanceToChangeCurrent(int i, int i2);

        int getFlingVelocity(int i, int i2);

        int getPendingDx(int i);

        int getPendingDy(int i);

        int getViewEnd(int i, int i2);

        boolean hasNewBecomeVisible(DiscreteScrollLayoutManager discreteScrollLayoutManager);

        boolean isViewVisible(Point point, int i, int i2, int i3, int i4);

        void offsetChildren(int i, RecyclerViewProxy recyclerViewProxy);

        void setCurrentViewCenter(Point point, int i, Point point2);

        void shiftViewCenter(Direction direction, int i, Point point);
    }

    abstract Helper createHelper();

    protected static class HorizontalHelper implements Helper {
        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public boolean canScrollHorizontally() {
            return true;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public boolean canScrollVertically() {
            return false;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public int getDistanceToChangeCurrent(int i, int i2) {
            return i;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public int getFlingVelocity(int i, int i2) {
            return i;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public int getPendingDx(int i) {
            return i;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public int getPendingDy(int i) {
            return 0;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public int getViewEnd(int i, int i2) {
            return i;
        }

        protected HorizontalHelper() {
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public void setCurrentViewCenter(Point point, int i, Point point2) {
            point2.set(point.x - i, point.y);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public void shiftViewCenter(Direction direction, int i, Point point) {
            point.set(point.x + direction.applyTo(i), point.y);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public boolean isViewVisible(Point point, int i, int i2, int i3, int i4) {
            int i5 = point.x;
            return i5 - i < i3 + i4 && i5 + i > (-i4);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public boolean hasNewBecomeVisible(DiscreteScrollLayoutManager discreteScrollLayoutManager) {
            View firstChild = discreteScrollLayoutManager.getFirstChild();
            View lastChild = discreteScrollLayoutManager.getLastChild();
            return (discreteScrollLayoutManager.getDecoratedLeft(firstChild) > (-discreteScrollLayoutManager.getExtraLayoutSpace()) && discreteScrollLayoutManager.getPosition(firstChild) > 0) || (discreteScrollLayoutManager.getDecoratedRight(lastChild) < discreteScrollLayoutManager.getWidth() + discreteScrollLayoutManager.getExtraLayoutSpace() && discreteScrollLayoutManager.getPosition(lastChild) < discreteScrollLayoutManager.getItemCount() - 1);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public void offsetChildren(int i, RecyclerViewProxy recyclerViewProxy) {
            recyclerViewProxy.offsetChildrenHorizontal(i);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public float getDistanceFromCenter(Point point, int i, int i2) {
            return i - point.x;
        }
    }

    protected static class VerticalHelper implements Helper {
        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public boolean canScrollHorizontally() {
            return false;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public boolean canScrollVertically() {
            return true;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public int getDistanceToChangeCurrent(int i, int i2) {
            return i2;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public int getFlingVelocity(int i, int i2) {
            return i2;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public int getPendingDx(int i) {
            return 0;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public int getPendingDy(int i) {
            return i;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public int getViewEnd(int i, int i2) {
            return i2;
        }

        protected VerticalHelper() {
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public void setCurrentViewCenter(Point point, int i, Point point2) {
            point2.set(point.x, point.y - i);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public void shiftViewCenter(Direction direction, int i, Point point) {
            point.set(point.x, point.y + direction.applyTo(i));
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public void offsetChildren(int i, RecyclerViewProxy recyclerViewProxy) {
            recyclerViewProxy.offsetChildrenVertical(i);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public float getDistanceFromCenter(Point point, int i, int i2) {
            return i2 - point.y;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public boolean isViewVisible(Point point, int i, int i2, int i3, int i4) {
            int i5 = point.y;
            return i5 - i2 < i3 + i4 && i5 + i2 > (-i4);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.Helper
        public boolean hasNewBecomeVisible(DiscreteScrollLayoutManager discreteScrollLayoutManager) {
            View firstChild = discreteScrollLayoutManager.getFirstChild();
            View lastChild = discreteScrollLayoutManager.getLastChild();
            return (discreteScrollLayoutManager.getDecoratedTop(firstChild) > (-discreteScrollLayoutManager.getExtraLayoutSpace()) && discreteScrollLayoutManager.getPosition(firstChild) > 0) || (discreteScrollLayoutManager.getDecoratedBottom(lastChild) < discreteScrollLayoutManager.getHeight() + discreteScrollLayoutManager.getExtraLayoutSpace() && discreteScrollLayoutManager.getPosition(lastChild) < discreteScrollLayoutManager.getItemCount() - 1);
        }
    }
}
