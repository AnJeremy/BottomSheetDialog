package cn.syxg.bottomsheetdialog;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBottomSheet;

    private BottomSheetDialog mbottomSheetDialog;

    private BottomDialogAdapter adapter;

    private RecyclerView recyclerView;

    private StrongBottomSheetDialog mStrongBottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        setContentView(R.layout.activity_main);

        mBottomSheet = (Button) findViewById(R.id.bottomSheet);


        mBottomSheet.setOnClickListener(this);

        initView();

    }

    private void initView() {

        View view = View.inflate(this,R.layout.item_recycler,null);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= 100; i++) {
            list.add("" + i);
        }
        //RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(this).inflate(R.layout.item_recycler, null);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new BottomDialogAdapter(this, list);
        recyclerView.setAdapter(adapter);

        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        //int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        WindowManager wm1 = this.getWindowManager();
        int width1 = wm1.getDefaultDisplay().getWidth();
        int height1 = wm1.getDefaultDisplay().getHeight();



       /* DisplayMetrics dm =new DisplayMetrics();

        //dm  getResources().getDisplayMetrics();
        dm = this.getResources().getDisplayMetrics();

        dm.density;
        float density = dm.density;
        // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）

        int densityDPI = dm.densityDpi;
        // 屏幕密度（每寸像素：120/160/240/320）

        int screenWidth = dm.widthPixels;
        // 屏幕宽（像素，如：3200px）

        int screenHeight = dm.heightPixels;
        // 屏幕高（像素，如：1280px）*/

        /*DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        double x = Math.pow(dm.widthPixels/dm.xdpi,2);
        double y = Math.pow(dm.heightPixels/dm.ydpi,2);
        double screenInches = Math.sqrt(x+y); //屏幕尺寸（英寸）*/

        //获取屏幕的宽高
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width2 = outMetrics.widthPixels;
        int height2 = outMetrics.heightPixels;


/*
        mStrongBottomSheetDialog = new StrongBottomSheetDialog(this);
        mStrongBottomSheetDialog.setPeekHeight(height2/2);
        mStrongBottomSheetDialog.setMaxHeight(height2/2);
        mStrongBottomSheetDialog.setContentView(view);*/

        //上拉铺满屏幕

        mbottomSheetDialog = new BottomSheetDialog(this);
        mbottomSheetDialog.setCanceledOnTouchOutside(false);
        mbottomSheetDialog.setContentView(view);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bottomSheet:



                mbottomSheetDialog.show();
                //mStrongBottomSheetDialog.show();

                break;
            default:
                break;
        }
    }
}
