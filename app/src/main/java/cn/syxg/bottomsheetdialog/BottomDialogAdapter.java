package cn.syxg.bottomsheetdialog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */

public class BottomDialogAdapter extends RecyclerView.Adapter{

    private Context context;
    private List<String> list;

    public BottomDialogAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View inflater = LayoutInflater.from(context).inflate(R.layout.item_text,null,false);
        View view = View.inflate(context,R.layout.item_text,null);

        return new NormalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        NormalViewHolder vh = (NormalViewHolder) holder;
        vh.text.setText("条目:" + position);
        vh.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,position + "被点击",Toast.LENGTH_SHORT).show();
                //Toast.show(position + "被点击");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class NormalViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public NormalViewHolder(View itemView) {
            super(itemView);

            text = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}
