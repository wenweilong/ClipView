package net.arvin.clipview;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by arvinljw on 17/8/19 21:33
 * Function：
 * Desc：
 */
public class RadiusTextView extends AppCompatTextView {
    private RadiusUtils mRadiusUtils;

    public RadiusTextView(Context context) {
        super(context);
        mRadiusUtils = new RadiusUtils(context, null);
    }

    public RadiusTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRadiusUtils = new RadiusUtils(context, attrs);
    }

    public RadiusTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRadiusUtils = new RadiusUtils(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRadiusUtils.onSizeChanged(w, h);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(mRadiusUtils.getPath());
        super.draw(canvas);
        canvas.restore();
    }

    public RadiusTextView setRadius(float radius) {
        mRadiusUtils.setRadius(radius);
        postInvalidate();
        return this;
    }

    public RadiusTextView setRadiusLeftTop(int radiusLeftTop) {
        mRadiusUtils.setRadiusLeftTop(radiusLeftTop);
        postInvalidate();
        return this;
    }

    public RadiusTextView setRadiusLeftBottom(float radiusLeftBottom) {
        mRadiusUtils.setRadiusLeftBottom(radiusLeftBottom);
        postInvalidate();
        return this;
    }

    public RadiusTextView setRadiusRightTop(float radiusRightTop) {
        mRadiusUtils.setRadiusRightTop(radiusRightTop);
        postInvalidate();
        return this;
    }

    public RadiusTextView setRadiusRightBottom(float radiusRightBottom) {
        mRadiusUtils.setRadiusRightBottom(radiusRightBottom);
        postInvalidate();
        return this;
    }

    @Override
    public Parcelable onSaveInstanceState() {
        return mRadiusUtils.onSaveInstanceState(super.onSaveInstanceState());
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(mRadiusUtils.onRestoreInstanceState(state));
        mRadiusUtils.onSizeChanged(getWidth(), getHeight());
    }
}