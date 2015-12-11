package Model;

import android.widget.Button;

/**
 * 文字按钮的model
 * Created by Zhaodj on 2015/12/11.
 */
public class WorldButton {
    //索引
    private int mIndex;
    //判断是否可见
    private boolean isVisible;
    //按钮中的文字
    private String mString;
    //绑定的对应的按钮
    private Button mViewButton;


    public WorldButton() {
        this.isVisible = true;
        this.mString = "";
    }

    public int getmIndex() {
        return mIndex;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public String getmString() {
        return mString;
    }

    public Button getmViewButton() {
        return mViewButton;
    }

    public void setmIndex(int mIndex) {
        this.mIndex = mIndex;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public void setmString(String mString) {
        this.mString = mString;
    }

    public void setmViewButton(Button mViewButton) {
        this.mViewButton = mViewButton;
    }
}
