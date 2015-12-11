package Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.musicgame.R;

/**
 * 工具类
 * Created by Zhaodj on 2015/12/11.
 */
public class Util {

    /**
     * 根据layoutid获得相应的View
     * @param context
     * @param layoutid
     * @return
     */
    public static View getView(Context context,int layoutid){
        LayoutInflater inflater=LayoutInflater.from(context);
       View view= inflater.inflate(layoutid,null);
        return view;
    }

}
