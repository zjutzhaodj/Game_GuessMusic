package Model;

import android.widget.Button;

/**
 * ���ְ�ť��model
 * Created by Zhaodj on 2015/12/11.
 */
public class WorldButton {
    //����
    private int mIndex;
    //�ж��Ƿ�ɼ�
    private boolean isVisible;
    //��ť�е�����
    private String mString;
    //�󶨵Ķ�Ӧ�İ�ť
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
